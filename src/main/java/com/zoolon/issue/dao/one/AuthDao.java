package com.zoolon.issue.dao.one;

import com.zoolon.issue.domain.auth.Role;
import com.zoolon.issue.domain.auth.UserDetail;
import com.zoolon.issue.po.one.RolePermissionPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthDao {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    UserDetail findByUsername(@Param("username") String username);

    /**
     * 创建新用户
     *
     * @param userDetail
     */
    void insert(UserDetail userDetail);

    /**
     * 创建用户角色
     *
     * @param user
     * @param role
     * @return
     */
    Integer insertRole(@Param("user") Integer user, @Param("role") Integer role);

    /**
     * 根据角色id查找角色
     *
     * @param id
     * @return
     */
    Role findRoleById(@Param("id") Integer id);

    /**
     * 根据用户id查找该用户角色
     *
     * @param id
     * @return
     */
    Role findRoleByUserId(@Param("id") Integer id);

    List<RolePermissionPo> findRolePermission();


}
