package com.qitech.gateway;


import com.qitech.gateway.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author xin.bj
 * @program security-parent
 * @description 权限过滤器
 * @create 2019-02-27 15:47
 **/
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Value("${auth.skip.urls}")
    private String[] skipAuthUrls;

    @Value("${jwt.blacklist.key.format}")
    private String jwtBlacklistKeyFormat;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String url = exchange.getRequest().getURI().getPath();
        //跳过不需要验证的路径
        if (Arrays.asList(skipAuthUrls).contains(url)) {
            return chain.filter(exchange);
        }
        //从请求头中取出token
        String AUTHORIZATION = "Authorization";
        String token = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            token = exchange.getRequest().getQueryParams().getFirst(AUTHORIZATION);
        }
        //未携带token或token在黑名单内
        if (token == null ||
                token.isEmpty() ||
                isBlackToken(token)) {
            ServerHttpResponse originalResponse = exchange.getResponse();
            originalResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            originalResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            byte[] response = "{\"code\": \"401\",\"msg\": \"401 Unauthorized.\"}"
                    .getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = originalResponse.bufferFactory().wrap(response);
            return originalResponse.writeWith(Flux.just(buffer));
        }
        //取出token包含的身份
        String userName = verifyJWT(token);
        if (StringUtils.isEmpty(userName)) {
            ServerHttpResponse originalResponse = exchange.getResponse();
            originalResponse.setStatusCode(HttpStatus.BAD_REQUEST);
            originalResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            byte[] response = "{\"code\": \"10002\",\"msg\": \"invalid token.\"}"
                    .getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = originalResponse.bufferFactory().wrap(response);
            return originalResponse.writeWith(Flux.just(buffer));
        }
        //将现在的request，添加当前身份
        ServerHttpRequest mutableReq = exchange.getRequest().mutate()
                .header("HEADER_LOGIN_NAME", userName)
                .header(AUTHORIZATION, token)
                .build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        return chain.filter(mutableExchange);
    }

    /**
     * JWT验证
     *
     * @param token
     * @return userName
     */
    private String verifyJWT(String token) {
        String userName;
        try {
            JwtTokenUtil tokenUtil = new JwtTokenUtil();
            Claims claims = tokenUtil.parseJWT(token);
            userName = claims.getIssuer();
        } catch (Exception e) {
            LOGGER.error("验证Token出错了", e);
            userName = null;
        }
        return userName;
    }

    /**
     * 判断token是否在黑名单内
     *
     * @param token
     * @return
     */
    private boolean isBlackToken(String token) {
        assert token != null;
        return stringRedisTemplate.hasKey(String.format(jwtBlacklistKeyFormat, token));
    }
}
