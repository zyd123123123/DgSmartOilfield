package com.sydx.aqsc.ctrl;

import com.sydx.aqsc.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "【系统管理】会员管理")
@Slf4j
public class HelloControler {
    @Autowired
    HelloService helloService;


    /*
    * paramType 请求时参数的位置，如query用于get请请参数的拼接
    * dataType 请求时参数的类型，默认String
    * */

    @ApiOperation(value = "列表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryMode", paramType = "query", dataType = "QueryModeEnum"),
            @ApiImplicitParam(name = "page", value = "页码", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "limit", value = "每页数量", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "nickname", value = "会员昵称", paramType = "query", dataType = "String")
    })
    @GetMapping(value = "/hello")
    public Map hi(HttpServletRequest request) {

        System.out.println("header= "+request.getHeader("user"));
        String aa=helloService.hiService("test");
        Map a=new HashMap();
        a.put("A",aa);
        a.put("code",200);
        a.put("msg","msg");
        return a;
    }
}
