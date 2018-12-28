package com.zoolon.issue.domain.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author : JoeTao
 * createAt: 2018/9/17
 */
@Builder
@Data
public class User {
    private String username;
    private String password;
}
