package com.zoolon.issue.domain.one.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDetail implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private List<Role> roleList;
    private Date updateTime;

    public UserDetail(
            Integer id,
            String username,
            List<Role> roleList,
            String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }

    public UserDetail(String username, String password, List<Role> roleList) {
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }

    public UserDetail(Long id, String username, String password) {
        //Long => Integer
        this.id = id.intValue();
        this.username = username;
        this.password = password;
    }

    public UserDetail(String username, String password, Date date) {
        //Long => Integer
        this.username = username;
        this.password = password;
        this.updateTime = date;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        /*for (int i = 0; i < roleList.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(roleList.get(i).getName()));
        }*/

        roleList.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return authorities;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
