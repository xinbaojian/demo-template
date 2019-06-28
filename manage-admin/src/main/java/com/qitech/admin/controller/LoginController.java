package com.qitech.admin.controller;

import com.qitech.admin.utils.JwtTokenUtil;
import com.qitech.constant.GlobalConstants;
import com.qitech.mybatis.annotation.CacheRemove;
import com.qitech.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xin.bj
 * @program security-parent
 * @description 登陆接口
 * @create 2019-02-27 16:29
 **/
@Slf4j
@RestController
public class LoginController extends BaseController {


    @Value("${jwt.token.expire}")
    private long tokenExpireTime;

    @Value("${refresh.token.expire.time}")
    private long refreshTokenExpireTime;

    @Value("${jwt.refresh.token.key.format}")
    private String jwtRefreshTokenKeyFormat;

    @Value("${jwt.blacklist.key.format}")
    private String jwtBlacklistKeyFormat;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private ISysUserAdminService userAdminService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 登录授权，生成JWT
     *
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value = "用户登录", httpMethod = "POST", response = ResponseResult.class, notes = "用户登录接口")
    @PostMapping("/api/login")
    public ResponseResult login(@ApiParam(name = "userName", value = "用户登录名", required = true, example = "admin") @RequestParam("userName") String userName,
                                @ApiParam(name = "password", value = "用户登录密码", required = true, example = "admin") @RequestParam("password") String password) {
//        Optional<SysUser> user = userAdminService.selectByLoginName(userName);

        Map<String, Object> resultMap = new HashMap<>(16);
        //账号密码校验
//        if (user.isPresent() && DigestsUtils.validatePassword(password, user.get().getPassword())) {
//
//            //生成JWT
//            String token = buildJWT(userName, user.get());
//            //生成refreshToken
//            String refreshToken = UUIDUtils.generateUUID();
//            //保存refreshToken至redis，使用hash结构保存使用中的token以及用户标识
//            String refreshTokenKey = String.format(jwtRefreshTokenKeyFormat, refreshToken);
//            stringRedisTemplate.opsForHash().put(refreshTokenKey,
//                    "token", token);
//            stringRedisTemplate.opsForHash().put(refreshTokenKey,
//                    "userName", userName);
//            //refreshToken设置过期时间
//            stringRedisTemplate.expire(refreshTokenKey,
//                    refreshTokenExpireTime, TimeUnit.MILLISECONDS);
//            //返回结果
//            Map<String, Object> dataMap = new HashMap<>(16);
//            dataMap.put("token", token);
//            dataMap.put("refreshToken", refreshToken);
//            resultMap.put("code", "10000");
//            resultMap.put("data", dataMap);
//            return ResponseResult.getInstance().success().setData(token);
//        }
        resultMap.put("isSuccess", false);
        return ResponseResult.getInstance().success().setData(resultMap);
    }

    @ApiOperation(value = "校验token")
    @PostMapping("/api/verify")
    public String verifyToken(@RequestParam("token") String token) {
        if (org.apache.commons.lang3.StringUtils.isBlank(token)) {
            return null;
        }
        String userName;
        try {
            JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
            userName = jwtTokenUtil.parseJWT(token).getIssuer();
        } catch (Exception e) {
            log.error("验证Token失败", e);
            userName = null;
        }
        return userName;
    }

    /**
     * 刷新JWT
     *
     * @param refreshToken
     * @return
     */
    @GetMapping("/api/token/refresh")
    public Map<String, Object> refreshToken(@RequestParam String refreshToken) {
        Map<String, Object> resultMap = new HashMap<>(16);
//        String refreshTokenKey = String.format(jwtRefreshTokenKeyFormat, refreshToken);
//        String userName = (String) stringRedisTemplate.opsForHash().get(refreshTokenKey,
//                "userName");
//        if (StringUtils.isBlank(userName)) {
//            resultMap.put("code", "10001");
//            resultMap.put("msg", "refreshToken过期");
//            return resultMap;
//        }
//        SysUser user = new SysUser();
//        user.setName(userName);
//        String newToken = buildJWT(userName, user);
//        //替换当前token，并将旧token添加到黑名单
//        String oldToken = (String) stringRedisTemplate.opsForHash().get(refreshTokenKey,
//                "token");
//        stringRedisTemplate.opsForHash().put(refreshTokenKey, "token", newToken);
//        stringRedisTemplate.opsForValue().set(String.format(jwtBlacklistKeyFormat, oldToken), "",
//                tokenExpireTime, TimeUnit.MILLISECONDS);
//        resultMap.put("code", "10000");
//        resultMap.put("data", newToken);
        return resultMap;
    }

//    private String buildJWT(String userName, SysUser user) {
//        JwtTokenUtil tokenUtil = new JwtTokenUtil();
//        return tokenUtil.createJWT(userName, user.getId());
//    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    @CacheRemove(value = GlobalConstants.LOGIN_USER)
    public ResponseEntity logout() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
