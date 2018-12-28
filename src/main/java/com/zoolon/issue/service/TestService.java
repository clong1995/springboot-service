package com.zoolon.issue.service;

import com.zoolon.issue.vo.param.auth.SignParam;
import com.zoolon.issue.vo.res.test.ByIdRes;

public interface TestService {
    ByIdRes getTestById(SignParam signParam);
}
