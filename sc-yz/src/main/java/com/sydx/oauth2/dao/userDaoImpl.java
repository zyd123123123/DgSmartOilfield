package com.sydx.oauth2.dao;

import com.sydx.oauth2.entity.PermissionRole;
import com.sydx.oauth2.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userDaoImpl implements UserDao {
    @Autowired
    protected SqlSessionTemplate sql;

    @Override
    public List<User> getUserByName(String goal, Object obj) {
        System.out.println(obj.getClass().getName() + "." + goal);
        return   sql.selectList(obj.getClass().getName() + "." + goal, obj);
    }

    @Override
    public List<String> getUserPermissions(String goal, Object obj) {
            System.out.println(obj.getClass().getName() + "." + goal);
            return sql.selectList(obj.getClass().getName() + "." + goal, obj);
    }
    @Override
    public List<PermissionRole> getAllRolesByPermission(String goal, Object obj) {
        System.out.println(obj.getClass().getName() + "." + goal);
        return sql.selectList(obj.getClass().getName() + "." + goal, obj);
    }
    @Override
    public List<String> getMenuListByName(String goal, Object obj) {
        System.out.println(obj.getClass().getName() + "." + goal);
        return sql.selectList(obj.getClass().getName() + "." + goal, obj);
    }
}
