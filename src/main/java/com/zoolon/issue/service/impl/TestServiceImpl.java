package com.zoolon.issue.service.impl;

import com.zoolon.issue.service.TestService;
import com.zoolon.issue.vo.param.auth.SignParam;
import com.zoolon.issue.vo.res.test.ByIdRes;
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
