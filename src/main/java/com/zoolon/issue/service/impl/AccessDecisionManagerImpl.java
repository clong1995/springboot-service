package com.zoolon.issue.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.Iterator;

@Slf4j
public class AccessDecisionManagerImpl implements AccessDecisionManager {
    /**
     * @param authentication   当前正在请求受包含对象的Authentication
     * @param object           object 受保护对象，其可以是一个MethodInvocation、JoinPoint或FilterInvocation。
     * @param configAttributes 与正在请求的受保护对象相关联的配置属性
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(
            Authentication authentication,//当前携带的权限
            Object object,//URL
            Collection<ConfigAttribute> configAttributes//这个地址需要的权限数组
    )
            throws AccessDeniedException, InsufficientAuthenticationException {


        log.info("访问的地址 : {}", ((FilterInvocation) object).getRequestUrl());
        log.info("本地址需要的权限 : {}", configAttributes.toString());
        log.info("当前携带的权限 : {}", authentication.getAuthorities().toString());


        //遍历访问这个地址需要新的权限
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            String needRole = ca.getAttribute();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            //比较两组权限
            for (GrantedAuthority ga : authorities) {
                if (ga.getAuthority().equals(needRole)) {
                    //匹配到有对应角色,则允许通过
                    return;
                }
            }
        }
        //该url有配置权限,但是当然登录用户没有匹配到对应权限,则禁止访问
        throw new AccessDeniedException("not allow");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
