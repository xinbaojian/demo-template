package com.qitech.scheduling.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: micro-parent
 * @description: Druid连接池
 * @author: xin.bj
 * @create: 2018-08-25 13:20
 **/
@Configuration
public class DruidConfig {

    @Value("${druid.loginUsername}")
    private String loginUsername;

    @Value("${druid.loginPassword}")
    private String loginPassword;

    @Value("${druid.resetEnable}")
    private String resetEnable;

    @Value("${druid.allow}")
    private String allow;

    @Value("${druid.deny}")
    private String deny;

    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        // 设置ip白名单
        if (StringUtils.isNotBlank(allow)) {
            servletRegistrationBean.addInitParameter("allow", allow);
        }
        // 设置ip黑名单,如果allow与deny共同存在时,deny优先于allow
        if (StringUtils.isNotBlank(deny)) {
            servletRegistrationBean.addInitParameter("deny", deny);
        }
        // 设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
        // 是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        // 创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
