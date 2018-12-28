package com.zoolon.issue.vo.res.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SignRes {
    String token;
}
