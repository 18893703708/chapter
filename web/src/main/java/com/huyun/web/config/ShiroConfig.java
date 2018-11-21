package com.huyun.web.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import com.huyun.web.shiro.RedisCacheManager;
import com.huyun.web.shiro.ShiroRealm;
import com.huyun.web.shiro.ShiroSessionListener;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 */
@Configuration
public class ShiroConfig {
/*    @Bean
    public RedisCacheManager redisCacheManager(){

        RedisCacheManager redisCacheManager = new RedisCacheManager();

        return redisCacheManager;
    }*/


    @Bean("sessionManager")
    public SessionManager sessionManager(){

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new ShiroSessionListener());
        sessionManager.setSessionListeners(listeners);
       // sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);// 删除过期的session
        sessionManager.setSessionValidationSchedulerEnabled(true);// 是否定时检查session
        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(ShiroRealm userRealm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
       // securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login");
//        shiroFilter.setUnauthorizedUrl("/login");
        shiroFilter.setSuccessUrl("/index");
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/plugin/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/api/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-ui.html**", "anon");
        filterMap.put("/configuration/**", "anon");
        filterMap.put("/swagger-resources", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/v2/api-docs**", "anon");
        filterMap.put("/image/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/captcha", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }


}
