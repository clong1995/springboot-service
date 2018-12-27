package com.example.demo.result;

import com.example.demo.domain.auth.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUserToken {
    private String token;
    private UserDetail userDetail;
}
