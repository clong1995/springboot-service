package com.example.demo.service;

import com.example.demo.vo.param.auth.SignParam;
import com.example.demo.vo.res.test.ByIdRes;

public interface TestService {
    ByIdRes getTestById(SignParam signParam);
}
