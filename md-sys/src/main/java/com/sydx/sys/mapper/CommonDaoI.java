package com.sydx.sys.mapper;

import java.util.List;

public interface CommonDaoI {
    List find(String goal, Object obj);
    Object obj(String goal, Object obj);
    int update(String goal, Object obj);
    int add(String goal, Object entity);
    int del(String goal, Object entity);
}
