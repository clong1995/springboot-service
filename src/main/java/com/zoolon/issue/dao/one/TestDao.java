package com.zoolon.issue.dao.one;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
    void testOneTx1();

    void testOneTx2();
}
