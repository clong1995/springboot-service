package com.example.demo.service.impl;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;
import java.util.Iterator;

public class AccessDecisionManagerImpl implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {

            if (authentication == null) {
                throw new AccessDeniedException("当前访问没有权限");
            }

            ConfigAttribute ca = ite.next();
            String needRole = ca.getAttribute();

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
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
