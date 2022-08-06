package com.sydx.oauth2.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.JWSObject;
import com.sydx.oauth2.api.CommonResult;
import com.sydx.oauth2.entity.MenuEntity;
import com.sydx.oauth2.service.CommonServI;
import com.sydx.oauth2.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加密数据解码
 * Created by lzf on 2021/7/13.
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserService userService;
    @Autowired
    private CommonServI service;



    /**
     * 加密数据解码1 来自本地
     */
    @GetMapping("/users/me")
    public CommonResult<Map> un(String params,ServletRequest req) throws ParseException {
        System.out.println("[这里开始模拟用户数据]-----"+params);
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String authorization = httpServletRequest.getHeader("Authorization");
        System.out.println("获取的auth: "+authorization);
        String realToken = authorization.replace("bearer ", "");
        JWSObject jwsObject = JWSObject.parse(realToken);
        String userStr = jwsObject.getPayload().toString();
        System.out.println(userStr);
        JSONObject jsonObject=new JSONObject(userStr) ;
        //UserDTO user=(UserDTO)JSONObject.toBean(jsonObject, UserDTO.class);
        int userId =  jsonObject.getInt("user_Id");
        String userAccount =  jsonObject.getStr("user_Account");
//获取信息
        Map a=new HashMap();//这里模拟返回一组解密数据
//        a.put("userid",100);
        a.put("data",userService.getUserByAccount(String.valueOf(userAccount) ));
        //这里还有一系列验证
        return CommonResult.success(a);
    }
    @GetMapping("/sys/menus")
    public CommonResult<Map> menus(){
        ClassPathResource classPathResource = new ClassPathResource("menu.json");
        try{
            System.out.println("menu.json");
            InputStream inputStream = classPathResource.getInputStream();
            String aa = IOUtils.toString(inputStream,"UTF-8");
//            File file = classPathResource.getFile();
//            String input = FileUtils.readFileToString(file, "UTF-8");
            JSONObject jsonObject = JSONUtil.parseObj(aa);
            Map a=new HashMap();
            a.put("menu",jsonObject.get("menu"));
            return CommonResult.success(a);
        }catch (Exception e){
            e.printStackTrace();
        }

        //这里还有一系列验证
        return null;
    }

    @GetMapping("/sys/menus_cbs")
    public CommonResult<Map> menus_c(){
        List<Map> l = service.maps("menus",new MenuEntity());
        System.out.println("承包商菜单");
        List l2 =new ArrayList();
        for (Map m:l) {
            Map a1=new HashMap();
            if(String.valueOf(m.get("parent_node")).equals("3")){
                a1.put("id",m.get("menu_id"));
                if(null!=m.get("url")){
                    a1.put("path",m.get("url"));
                    String name=String.valueOf(m.get("url"));
                    a1.put("component",name.replaceFirst("/",""));
                    a1.put("name",name.substring(name.lastIndexOf("/")+1));
                }
                //a1.put("redirect",m.get("url"));
                a1.put("route",m.get("isroute"));
                Map a2=new HashMap();
                a2.put("keepAlive",m.get("keepalive"));
                a2.put("internalOrExternal",m.get("internalorexternal"));
                a2.put("icon",m.get("icon"));
                a2.put("title",m.get("menu_name"));
                a1.put("meta",a2);
                List ll = getChil(l, String.valueOf(m.get("menu_id")));
                if(ll.size()>0){
                    a1.put("children",ll);
                }
                l2.add(a1);
            }
        }
        Map a=new HashMap();
        a.put("menu",l2);
        return CommonResult.success(a);
    }

    public List getChil(List<Map> l,String id){
        List l2 =new ArrayList();
        for (Map m:l){
            if(String.valueOf(m.get("parent_node")).equals(id)){
                Map a1=new HashMap();
                a1.put("id",m.get("menu_id"));
                if(null!=m.get("url")){
                    a1.put("path",m.get("url"));
                    String name=String.valueOf(m.get("url"));
                    a1.put("component",name.replaceFirst("/",""));
                    a1.put("name",name.substring(name.lastIndexOf("/")+1));
                }
                a1.put("route",m.get("isroute"));
                    Map a2=new HashMap();
                    a2.put("keepAlive",m.get("keepalive"));
                    a2.put("internalOrExternal",m.get("internalorexternal"));
                    a2.put("icon",m.get("icon"));
                    a2.put("title",m.get("menu_name"));
                a1.put("meta",a2);
                List ll = getChil(l, String.valueOf(m.get("menu_id")));
                if(ll.size()>0){
                    a1.put("children",ll);
                }
                l2.add(a1);
            }
        }
        return l2;
    }

}
