package com.sydx.sys.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sydx.common.api.CommonResult;
import com.sydx.sys.entity.MenuEntity;
import com.sydx.sys.service.CommonServI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.*;

@Api(tags = "菜单接口")
@RestController
@RequestMapping("/menus")
@Slf4j
@AllArgsConstructor
public class SysMenusController {

    private CommonServI service;

//    @GetMapping("/munus/list")
//    public CommonResult<Map> menus(){
//        ClassPathResource classPathResource = new ClassPathResource("menu.json");
//        try{
//            System.out.println("menu.json");
//            InputStream inputStream = classPathResource.getInputStream();
//            String aa = IOUtils.toString(inputStream,"UTF-8");
////            File file = classPathResource.getFile();
////            String input = FileUtils.readFileToString(file, "UTF-8");
//            JSONObject jsonObject = JSONUtil.parseObj(aa);
//            Map a=new HashMap();
//            a.put("menu",jsonObject.get("menu"));
//            return CommonResult.success(a);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        //这里还有一系列验证
//        return null;
//    }

    @GetMapping("/list")
    @ApiOperation(value = "菜单列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "菜单名称", paramType = "query", dataType = "String")
//    })
    public CommonResult<List> menus_c() {
        List<Map> list = service.maps("menus", new MenuEntity());
        List l2 = new ArrayList();
        Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .filter(m -> "0".equals(m.get("parent_node") + ""))
                .forEach(m -> {
                    Map a1 = new HashMap();
//                a1.put("id", m.get("menu_id"));
//                if (null != m.get("url")) {
//                    a1.put("path", m.get("url"));
//                    String name = String.valueOf(m.get("url"));
//                    a1.put("component", name.replaceFirst("/", ""));
//                    a1.put("name", name.substring(name.lastIndexOf("/") + 1));
//                }
//                  a1.put("redirect",m.get("url"));
//                a1.put("route", m.get("isroute"));
//                Map a2 = new HashMap();
//                a2.put("keepAlive", m.get("keepalive"));
//                a2.put("internalOrExternal", m.get("internalorexternal"));
//                a2.put("icon", m.get("icon"));
//                a1.put("name", m.get("menu_name"));
//                a1.put("meta", a2);
                    List ll = getChil(list, m.get("menu_id") + "");
                    if (CollectionUtil.isNotEmpty(ll)) {
                        a1.put(m.get("menu_name"), ll);
                    }
                    l2.add(a1);
                });
//        Map a = new HashMap();
//        a.put("menu", l2);
        return CommonResult.success(l2);
    }

    //递归子节点
    public List getChil(List<Map> list, String id) {
        List l2 = new ArrayList();
        Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .filter(m -> id.equals(m.get("parent_node") + ""))
                .forEach(m -> {
                    Map a1 = new HashMap();
                    a1.put("id", m.get("menu_id"));
                    if (null != m.get("url")) {
                        a1.put("path", m.get("url"));
                        String name = String.valueOf(m.get("url"));
                        a1.put("component", name.replaceFirst("/", ""));
                        a1.put("name", name.substring(name.lastIndexOf("/") + 1));
                    }
                    a1.put("route", m.get("isroute"));
                    Map a2 = new HashMap();
                    a2.put("keepAlive", m.get("keepalive"));
                    a2.put("internalOrExternal", m.get("internalorexternal"));
                    a2.put("icon", m.get("icon"));
                    a2.put("title", m.get("menu_name"));
                    a1.put("meta", a2);
                    List ll = getChil(list, m.get("menu_id") + "");
                    if (CollectionUtil.isNotEmpty(ll)) {
                        a1.put("children", ll);
                    }
                    l2.add(a1);
                });
        return l2;
    }

}
