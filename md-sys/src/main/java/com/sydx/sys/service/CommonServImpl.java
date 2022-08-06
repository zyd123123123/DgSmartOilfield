package com.sydx.sys.service;

import com.sydx.sys.mapper.CommonDaoI;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CommonServImpl implements CommonServI {
    @Autowired
    private CommonDaoI dao;

    @Override
    public List find(String goal, Object obj) {
        return dao.find(goal, obj);
    }

    @Override
    public List maps(String goal, Object obj) {
        List<Map<String, Object>> maps =dao.find(goal, obj);
        int i = 0;
        for (Map<String, Object> m : maps) {
            m.put("rowid",i+1);
            maps.set(i, transferToLowerCase(m,obj));
            i++;

        }
        return maps;
    }

    @Override
    public Map grid(String goal, Object obj) {
        Method m1 = BeanUtils.findMethod(obj.getClass(), "getPage");
        Method m2 = BeanUtils.findMethod(obj.getClass(), "getPagesize");
        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            int pn=(int) m1.invoke(obj);
//            int ps=(int) m2.invoke(obj);
//            PageHelper.startPage(pn, ps);
//            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(dao.find(goal, obj));
//            List<Map<String, Object>> maps = pageInfo.getList();
//            int i = 0;
//            for (Map<String, Object> m : maps) {
//                m.put("ROW_ID",(pn-1)*ps+(i+1));//添加序号
//                maps.set(i, transferToLowerCase(m,obj));
//                i++;
//            }
//            map.put("Total", pageInfo.getTotal());
//            map.put("Rows", maps);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        return map;
    }

    public static Map<String, Object> transferToLowerCase(Map<String, Object> orgMap,Object obj) {
        Map<String, Object> resultMap = new HashMap<>();

        if (orgMap == null || orgMap.isEmpty()) {
            return resultMap;
        }

        Set<Map.Entry<String, Object>> entrySet = orgMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            resultMap.put(key.toLowerCase(), entry.getValue());
        }

        return resultMap;
    }

    @Override
    public Object obj(String goal, Object obj) {
        return dao.obj(goal, obj);
    }

    @Override
    public Object map(String goal, Object obj) {
        return transferToLowerCase((Map<String, Object>) dao.obj(goal, obj),obj);
    }

    @Override
    public int update(String goal, Object obj) {
        return dao.update(goal, obj);
    }

    @Override
    public int add(String goal, Object entity) {
        try {
            return dao.add(goal, entity);
        }catch (Exception e){
            return 0;
        }

    }
    @Override
    public int del(String goal, Object entity) {
        try {
            return dao.del(goal, entity);
        }catch (Exception e){
            return 0;
        }


    }

}
