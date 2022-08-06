package com.sydx.sys.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonDaoImpl implements CommonDaoI {
    @Autowired
    protected SqlSessionTemplate sql;

    @Override
    public List find(String goal, Object obj) {
        try {
            System.out.println(obj.getClass().getName() + "." + goal);
            return sql.selectList(obj.getClass().getName() + "." + goal, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object obj(String goal, Object obj) {
        try {
            return sql.selectOne(obj.getClass().getName() + "." + goal, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(String goal, Object obj) {
        try {
            return sql.update(obj.getClass().getName() + "." + goal, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int add(String goal, Object obj) {
        try {
            return sql.insert(obj.getClass().getName() + "." + goal, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int del(String goal, Object obj) {
        try {
            return sql.delete(obj.getClass().getName() + "." + goal, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
