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
import java.util.Map;


@RestController
@RequestMapping(value = "/gx")
@Api(tags = "【功能管理】施工工序管理")
public class GxController {

    @Autowired
    private GxServiceI service;


    @GetMapping(value = "/initComplate")
    @ApiOperation(value = "工序列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spname", value = "工序名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "aothname", value = "工序类别", paramType = "query", dataType = "String")
    })
    public Map initComplate(String spname, String aothname, Pager pager) {
        GxEntity gx = new GxEntity();
        gx.setSpname(spname);
        gx.setAothname(aothname);
        return service.initComplate(gx, pager);
    }

    @PostMapping(value = "/addSave")
    @ApiOperation(value = "工序新增保存")
    private Map addSave(@RequestBody GxEntity gx) {
        return service.addSave(gx);
    }

    @PutMapping(value = "/editAll")
    @ApiOperation(value = "工序修改")
    private Map editAll(@RequestBody GxEntity gx) {
        return service.editAll(gx);
    }

    @DeleteMapping(value = "/removeSave")
    @ApiOperation(value = "工序废除保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spid", value = "工序id", paramType = "query", dataType = "int", required = true)
    })
    public Map removeSave(int spid) {
        GxEntity gx = new GxEntity();
        gx.setSpid(spid);
        return service.removeSave(gx);
    }
    @GetMapping("/sgdyList")
    @ApiOperation(value = "施工单元列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spid", value = "工序ID", paramType = "query", dataType = "Integer", required = true)
    })
    public Map sgdyList(Integer spid) {
        SgdyEntity entity = new SgdyEntity();
        entity.setSpid(spid);
        //根据工序绑定的施工单元id，关联施工单元表查询安全环保要素
        return service.gx_sgdy_list(entity);
    }
    @GetMapping("/sgdy_aqhbys")
    @ApiOperation(value = "施工单元安全环保要素")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sgdyid", value = "施工单元id", paramType = "query", dataType = "String", required = true)
    })
    public Map sgdy_aqhbys(String sgdyid) {
        SgdyEntity entity = new SgdyEntity();
        entity.setSgdyid(sgdyid);
        return service.sgdy_aqhbys(entity);
    }
    @GetMapping("/gx_mb_list")
    @ApiOperation(value = "班报模板列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spid", value = "工序id", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "tab", value = "标识：1班报模板", paramType = "query", dataType = "String", required = true)
    })
    public Map gx_mb_list(int spid, String tab) {
        GxEntity entity = new GxEntity();
        entity.setSpid(spid);
        entity.setTab(tab);
        return service.gx_mb_list(entity);
    }
    @GetMapping(value = "/getPParamJSON")
    @ApiOperation(value = "班报模板修改查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "spid", value = "工序id", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "customid", value = "模板id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "tab", value = "标识：1班报模板", paramType = "query", dataType = "String", required = true)
    })
    public Map getPParamJSON(int spid, String customid, String tab) {
        GxnrmbEntity entity = new GxnrmbEntity();
        entity.setSpid(spid);
        entity.setCustomid(customid);
        entity.setTab(tab);
        return service.getPParamJSON(entity);
    }

    @PostMapping(value = "/gx_mb_addSave")
    @ApiOperation(value = "班报模板新增、修改保存")
    private Map gx_mb_addSave(@RequestBody GxnrmbEntity entity) {
        return service.gx_mb_addSave(entity);
    }
    @DeleteMapping("/gx_mb_remove")
    @ApiOperation(value = "班报模板废除保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customid", value = "模板id", paramType = "query", dataType = "String", required = true)
    })
    public Map gx_mb_remove(String customid) {
        GxnrmbEntity entity = new GxnrmbEntity();
        entity.setCustomid(customid);
        return service.gx_mb_remove(entity);
    }

    @PostMapping("/gx_sgdy_bdSave")
    @ApiOperation(value = "施工单元绑定保存")
    public Map gx_sgdy_bdSave(@RequestBody SgdyEntity entity){

        return service.gx_sgdy_bdSave(entity);
    }

}
