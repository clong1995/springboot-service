package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.AuthDao;
import com.zoolon.issue.domain.one.auth.Role;
import com.zoolon.issue.domain.one.auth.UserDetail;
import com.zoolon.issue.exception.CustomException;
import com.zoolon.issue.result.ResponseUserToken;
import com.zoolon.issue.result.ResultCode;
import com.zoolon.issue.service.AuthService;
import com.zoolon.issue.utils.JwtUtils;
import com.zoolon.issue.vo.param.auth.SignParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtTokenUtil;
    private final AuthDao authDao;

   /* @Value("${jwt.tokenHeader}")
    private String tokenHead;*/

    @Value("${jwt.authTokenStart}")
    private String authTokenStart;

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, @Qualifier("CustomUserDetailsService") UserDetailsService userDetailsService, JwtUtils jwtTokenUtil, AuthDao authDao) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authDao = authDao;
    }

    @Override
    @Transactional
    public UserDetail register(SignParam signParam) {


        /*List<Role> roleList = new ArrayList<Role>() {{
            add(Role.builder().id(1).build());
        }};

        UserDetail userDetail = new UserDetail(
                signParam.getUsername(),
                signParam.getPassword(),
                //Role.builder().id(1).build()
                roleList
        );*/


        //final String username = userDetail.getUsername();
        //检查是否存在
        if (authDao.findByUsername(signParam.getUsername()) != null) {
            throw new CustomException(ResultCode.BAD_REQUEST, "用户已存在");
        }

        //增加用户
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDetail userDetail = new UserDetail(
                signParam.getUsername(),
                encoder.encode(signParam.getPassword()),
                new Date()
        );
        authDao.insert(userDetail);

        //发生关系
        /*Integer roleId = userDetail.getRoleList().get(0).getId();
        Role role = authDao.findRoleById(roleId);
        userDetail.setRole(role);*/

        authDao.insertRole(userDetail.getId(), 1);

        return userDetail;
    }

    @Override
    public ResponseUserToken login(String username, String password) {
        //用户验证
        final Authentication authentication = authenticate(username, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        final UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateAccessToken(userDetail);
        //存储token
        jwtTokenUtil.putToken(username, token);
        return new ResponseUserToken(token, userDetail);
    }

    @Override
    public void logout(String token) {
        token = token.substring(authTokenStart.length());
        String userName = jwtTokenUtil.getUsernameFromToken(token);
        jwtTokenUtil.deleteToken(userName);
    }

    @Override
    public ResponseUserToken refresh(String oldToken) {
        String token = oldToken.substring(authTokenStart.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        UserDetail userDetail = (UserDetail) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, userDetail.getUpdateTime())) {
            token = jwtTokenUtil.refreshToken(token);
            return new ResponseUserToken(token, userDetail);
        }
        return null;
    }

    @Override
    public UserDetail getUserByToken(String token) {
        token = token.substring(authTokenStart.length());
        UserDetail userDetail = jwtTokenUtil.getUserFromToken(token);
        return userDetail;
    }

    private Authentication authenticate(String username, String password) {
        try {
            // 该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，
            // 如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new CustomException(ResultCode.LOGIN_ERROR, e.getMessage());
        }
    }
}
