package com.example.demo.service.impl;

import com.example.demo.service.TestService;
import com.example.demo.vo.param.auth.SignParam;
import com.example.demo.vo.res.test.ByIdRes;
import org.springframework.stereotype.Service;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public ByIdRes getTestById(SignParam signParam) {
        return null;
    }
}
