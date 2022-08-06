package com.sydx.oauth2.dao;

import com.sydx.oauth2.entity.PermissionRole;
import com.sydx.oauth2.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xuyaohui
 * @date 2018/7/31 0031 上午 10:08
 */


public interface UserDao {

    /**
     * 通过用户名获取用户基本信息
     * @param userAccount
     * @return
     */
    List getUserByName(String goal, Object obj);

    /**
     * 通过用户ID获取该用户具有的权限
     * @param userAccount
     * @return
     */
    List<String> getUserPermissions(String goal, Object obj);

    /**
     * 获取所有权限及对
     * @return
     */
    List<PermissionRole> getAllRolesByPermission(String goal, Object obj);

    /**
     * 获取用户访问菜单权限
     * @param userAccount
     * @return
     */
    List<String> getMenuListByName(String goal, Object obj);

}
