package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.AuthDao;
import com.zoolon.issue.po.one.RolePermissionPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.*;

@Slf4j
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthDao authDao;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();


    /*private final Map<String, String> urlRoleMap = new HashMap<String, String>() {{
        put("/open/**", "ROLE_ANONYMOUS");
        put("/health", "ROLE_ANONYMOUS");
        put("/restart", "ROLE_ADMIN");
        put("/test/hasTestRole", "TEST");
    }};*/

    private final Map<String, String> urlRoleMap = new HashMap<>();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        //String httpMethod = fi.getRequest().getMethod();
        //...
        log.info("进入自定url鉴权");
        List<RolePermissionPo> rolePermissionPoList = authDao.findRolePermission();
        /*for(RolePermissionPo rolePermissionPo : rolePermissionPoList) {
            urlRoleMap.put(rolePermissionPo.getUrl(),rolePermissionPo.getRole());
        }
        log.info(urlRoleMap.toString());*/
        /*for (Map.Entry<String, String> entry : urlRoleMap.entrySet()) {
            if (antPathMatcher.match(entry.getKey(), url)) {
                return SecurityConfig.createList(entry.getValue());
            }
        }*/

        ArrayList<String> stringArrayList = new ArrayList<>();
        for (RolePermissionPo rolePermissionPo : rolePermissionPoList) {
            if (antPathMatcher.match(rolePermissionPo.getUrl(), url)) {
                stringArrayList.add(rolePermissionPo.getRole());
            }
        }
        int size = stringArrayList.size();
        log.info("当前地址需要的角色 {} ", stringArrayList.toString());
        if (size > 0) {
            String[] strings = new String[size];
            return SecurityConfig.createList(stringArrayList.toArray(strings));
        }

        //没有匹配到,默认是超级管理员录才能访问
        return SecurityConfig.createList("ADMIN");
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
