package com.sydx.aqsc.ctrl.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.service.Security.GxServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/shmbbd")
@Api(tags = "【功能管理】施工模板绑定")
public class SgmbbdController {

    @Autowired
    private GxServiceI service;

    @GetMapping("/sgmbdzList")
    @ApiOperation(value = "列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templatename", value = "模板名称", paramType = "query", dataType = "String")
    })
    public Map sgmbdzList(String templatename, Pager pager) {
        SgmbdzEntity entity = new SgmbdzEntity();
        entity.setTemplatename(templatename);
        return service.sgmbdzList(entity, pager);
    }

    @GetMapping("/sgmbdz_gxList")
    @ApiOperation(value = "定制工序查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateid", value = "模板ID", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbdz_gxList(String templateid) {
        SgmbdzEntity entity = new SgmbdzEntity();
        entity.setTemplateid(templateid);
        List<SgmbdzEntity> liist = service.sgmbdzEditList(entity);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", liist);
        return resultMap;
    }

    @GetMapping("/sgmbbd_zylx_List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateid", value = "模板ID", paramType = "query", dataType = "String", required = true)
    })
    @ApiOperation(value = "作业类型列表数据")
    public Map sgmbbd_zylx_List(String templateid, Pager pager) {
        SgmbbdEntity entity= new SgmbbdEntity();
        entity.setTemplateid(templateid);
        return service.sgmbbd_zylx_List(entity,pager);
    }
    @DeleteMapping("/sgmbbd_zylx_remove")
    @ApiOperation(value = "绑定删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bindingid", value = "绑定ID", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbbd_zylx_remove(String bindingid) {
        SgmbbdEntity entity = new SgmbbdEntity();
        entity.setBindingid(bindingid);
        return service.sgmbbd_zylx_remove(entity);
    }
    //措施下拉框
    @GetMapping("/csSelect")
    @ApiOperation(value = "作业类型树形下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tab", value = "标识:1非复合设计，2复合设计", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "templateid", value = "模板id", paramType = "query", dataType = "String", required = true)
    })
    public Map  csSelect( String tab, String templateid) {
        MeasureEntity entity= new MeasureEntity();
        return service.csSelect(entity, tab, templateid);
    }


    @PostMapping("/sgmbbd_zylx_Save_tree")
    @ApiOperation(value = "绑定保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tab", value = "标识:1非复合设计，2复合设计", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "templateid", value = "模板id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "str", value = "措施id", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbbd_zylx_Save_tree(@RequestBody SgmbbdSaveEntity entity) {
        return service.sgmbbd_zylx_Save_tree(entity.getTemplateid(), entity.getTab(), entity.getStr());
    }

}
