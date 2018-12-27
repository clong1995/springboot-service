package com.example.demo.vo.param.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SignParam {
    @NotNull(message = "用户名不能为空")
    @Length(min = 2, max = 8, message = "用户姓名长度为{min}~{max}个字符")
    @ApiModelProperty(value = "用户名", dataType = "String", example = "zoolon", required = true)
    private String username;

    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 12, message = "密码长度为{min}~{max}个字符")
    @ApiModelProperty(value = "密码", dataType = "String", example = "123456", required = true)
    private String password;
}
