package com.sydx.oauth2.controller;

import com.sydx.oauth2.api.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加密数据解码
 * Created by lzf on 2021/7/13.
 */
@RestController
public class DecodeController {
    /**
     * 加密数据解码1 来自本地
     */
    @GetMapping(value = "/decode")
    public CommonResult<Map> un(String params,String redirect_uri){
        System.out.println("[这里开始解密用户传递参数]-----"+params);
        Map a=new HashMap();//这里模拟返回一组解密数据
        a.put("userid",100);
        a.put("username","macro");
        a.put("password","123456");
        a.put("nikename","nname1");
        //这里还有一系列验证
        return CommonResult.success(a);
    }

    /**
     * 加密数据解码 2 重定向，忽略来源
     */
    @GetMapping(value = "/redirect")
    public String un1(String params, String redirect_uri, HttpServletResponse response, RedirectAttributes redirectAttributes){
        System.out.println("[这里开始解密用户传递参数]-----"+params);
        Map a=new HashMap();//这里模拟返回一组解密数据
        a.put("userid",100);
        a.put("username","macro");
        a.put("password","123456");
        a.put("nikename","nname1");
        //这里还有一系列验证
        redirectAttributes.addFlashAttribute("message", "更新用户成功");
        try {
            response.setHeader("asdklf","Sdf");
            response.sendRedirect("https://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:https://www.baidu.com";
    }
}
