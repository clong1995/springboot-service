package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.one.auth.Role;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AuthDaoTest {
    @Autowired
    private AuthDao authDao;

    @Test
    public void findRoleByUserId() {
        List<Role> roleList = authDao.findRoleByUserId(3);
        log.info("role {}", roleList);
    }
}