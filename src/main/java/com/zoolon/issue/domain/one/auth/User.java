package com.zoolon.issue.domain.one.auth;

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
