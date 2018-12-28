package com.zoolon.issue.controller;

import com.zoolon.issue.domain.auth.Role;
import com.zoolon.issue.domain.auth.UserDetail;
import com.zoolon.issue.result.ResponseUserToken;
import com.zoolon.issue.result.ResultCode;
import com.zoolon.issue.result.ResultJson;
import com.zoolon.issue.service.AuthService;
import com.zoolon.issue.vo.param.auth.LoginParam;
import com.zoolon.issue.vo.param.auth.SignParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author JoeTao
 * createAt: 2018/9/17
 */

@RestController
@Api(description = "注册，登陆，登出，刷新")
@RequestMapping("/auth")
public class AuthController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login")
    @ApiOperation(
            value = "登陆",
            notes = "登陆成功返回token"
    )
    public ResultJson login(@Valid @RequestBody LoginParam loginParam) {
        final ResponseUserToken response = authService.login(loginParam.getUsername(), loginParam.getPassword());
        return ResultJson.ok(response.getToken());
    }

    @GetMapping(value = "/logout")
    @ApiOperation(value = "登出", notes = "退出登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson logout(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        authService.logout(token);
        return ResultJson.ok();
    }

    @GetMapping(value = "/user")
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Authorization token",
                    required = true,
                    dataType = "string",
                    paramType = "header"
            )
    })
    public ResultJson getUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        UserDetail userDetail = authService.getUserByToken(token);
        return ResultJson.ok(userDetail);
    }

    @PostMapping(value = "/sign")
    @ApiOperation(
            value = "用户注册",
            notes = "用户注册，不可注册admin，已被内置"
    )
    public ResultJson sign(@Valid @RequestBody SignParam signParam) {
        UserDetail userDetail = new UserDetail(
                signParam.getUsername(),
                signParam.getPassword(),
                Role.builder().id(1).build()
        );
        authService.register(userDetail);
        return ResultJson.ok();
    }

    @GetMapping(value = "refresh")
    @ApiOperation(value = "刷新token")
    public ResultJson refreshAndGetAuthenticationToken(
            HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        ResponseUserToken response = authService.refresh(token);
        if (response == null) {
            return ResultJson.failure(ResultCode.BAD_REQUEST, "token无效");
        } else {
            return ResultJson.ok(response);
        }
    }
}
