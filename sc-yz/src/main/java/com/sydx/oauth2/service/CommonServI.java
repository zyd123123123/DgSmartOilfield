package com.sydx.oauth2.service;

import java.util.List;
import java.util.Map;

public interface CommonServI {
    //grid 分页查询
    Map grid(String goal, Object obj);
    //普通列表查询
    List maps(String goal, Object obj);
    List find(String goal, Object obj);
    //单个对象查询
    Object obj(String goal, Object obj);
    Object map(String goal, Object obj);
    int update(String goal, Object obj);
    int add(String goal, Object entity);
    int del(String goal, Object entity);
}
