package com.example.demo.service.impl;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final Map<String, String> urlRoleMap = new HashMap<String, String>() {{
        put("/open/**", "ROLE_ANONYMOUS");
        put("/health", "ROLE_ANONYMOUS");
        put("/restart", "ROLE_ADMIN");
        put("/test/hasTestRole", "TEST");
    }};

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        //String httpMethod = fi.getRequest().getMethod();
        //...
        for (Map.Entry<String, String> entry : urlRoleMap.entrySet()) {
            if (antPathMatcher.match(entry.getKey(), url)) {
                return SecurityConfig.createList(entry.getValue());
            }
        }
        //没有匹配到,默认是要登录才能访问
        //return SecurityConfig.createList("ADMIN");
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
