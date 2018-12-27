package com.example.demo.domain.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @author : JoeTao
 * createAt: 2018/9/17
 */
@Data
@Builder
public class Role {
    private Integer id;
    private String name;
    private String nameZh;
}
