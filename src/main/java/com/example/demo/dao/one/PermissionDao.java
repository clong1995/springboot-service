package com.example.demo.dao.one;

import com.example.demo.domain.auth.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    List<Permission> findAll();

    List<Permission> findByAdminUserId(Integer userId);
}
