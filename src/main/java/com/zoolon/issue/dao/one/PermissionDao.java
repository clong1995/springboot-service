package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.auth.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    List<Permission> findAll();

    List<Permission> findByAdminUserId(Integer userId);
}
