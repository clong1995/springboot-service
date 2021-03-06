package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.AuthDao;
import com.zoolon.issue.domain.one.auth.Role;
import com.zoolon.issue.domain.one.auth.UserDetail;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component(value = "CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private AuthDao authDao;

    public CustomUserDetailsServiceImpl(AuthDao authDao) {
        this.authDao = authDao;
    }

    @Override
    public UserDetail loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetail userDetail = authDao.findByUsername(name);
        if (userDetail == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", name));
        }
        //角色
        List<Role> roleList = authDao.findRoleByUserId(userDetail.getId());
        userDetail.setRoleList(roleList);
        return userDetail;
    }
}
