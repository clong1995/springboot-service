package com.zoolon.issue.vo.res.auth;

import com.zoolon.issue.domain.one.auth.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetUserRes {
    private Integer id;
    private String username;
    private String role;
}
