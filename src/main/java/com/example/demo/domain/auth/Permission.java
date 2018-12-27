package com.example.demo.domain.auth;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Permission {
    private Integer id;
    //权限名称
    private String name;
    //权限描述
    private String description;
    //授权链接
    private String url;
    //父节点id
    private Integer pid;

    private String method;
}
