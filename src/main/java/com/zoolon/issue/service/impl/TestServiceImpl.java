package com.zoolon.issue.service.impl;

import com.zoolon.issue.dao.one.TestDao;
import com.zoolon.issue.dao.two.TestDao2;
import com.zoolon.issue.service.TestService;
import com.zoolon.issue.vo.param.auth.SignParam;
import com.zoolon.issue.vo.res.test.ByIdRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: JoeTao
 * createAt: 2018/9/17
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Autowired
    private TestDao2 testDao2;

    @Override
    public ByIdRes getTestById(SignParam signParam) {
        return null;
    }

    @Override
    @Transactional
    public void testOneTx() {
        testDao.testOneTx1();
        testDao.testOneTx2();
    }

    @Override
    @Transactional
    public void testTowTx() {
        testDao.testOneTx1();
        testDao2.testOneTx1();
    }

    @Override
    public void testTow() {
        testDao2.testOneTx1();
    }
}
