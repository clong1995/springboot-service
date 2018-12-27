package com.example.demo.service.impl;

import com.example.demo.dao.one.AuthDao;
import com.example.demo.domain.auth.Role;
import com.example.demo.domain.auth.UserDetail;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


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
        Role role = authDao.findRoleByUserId(userDetail.getId());
        userDetail.setRole(role);
        return userDetail;
    }
}
