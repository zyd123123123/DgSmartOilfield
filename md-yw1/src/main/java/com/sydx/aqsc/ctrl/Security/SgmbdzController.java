package com.sydx.aqsc.ctrl.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.GxEntity;
import com.sydx.aqsc.entity.Security.SgmbdzEntity;
import com.sydx.aqsc.service.Security.GxServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sgmbdz")
@Api(tags = "【功能管理】施工模板定制")
public class SgmbdzController {

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

    @PostMapping("/sgmbdzSave")
    @ApiOperation(value = " 新增保存")
    public Map sgmbdzSave(@RequestBody SgmbdzEntity entity) {
        return service.sgmbdzSave(entity);
    }

    @GetMapping("/sgmbdzEdit")
    @ApiOperation(value = "修改查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateid", value = "模板ID", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbdzEdit(String templateid) {
        SgmbdzEntity entity = new SgmbdzEntity();
        entity.setTemplateid(templateid);
        SgmbdzEntity entity1 = service.sgmbdzEditSelect(entity);
        List<SgmbdzEntity> entity_list = service.sgmbdzEditList(entity);
        Map map = new HashMap();
        map.put("entity", entity1);
        map.put("entityList", entity_list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @PutMapping("/sgmbdzEditSave")
    @ApiOperation(value = "修改保存")
    public Map sgmbdzEditSave(@RequestBody SgmbdzEntity entity) {
        return service.sgmbdzEditSave(entity);
    }

    @DeleteMapping("/sgmbdzRemoveSave")
    @ApiOperation(value = "删除保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateid", value = "模板ID", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbdzRemoveSave(String templateid) {
        SgmbdzEntity entity = new SgmbdzEntity();
        entity.setTemplateid(templateid);
        return service.sgmbdzRemoveSave(entity);
    }

    @GetMapping("/sgmbdz_gxList")
    @ApiOperation(value = "定制工序查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateid", value = "模板ID", paramType = "query", dataType = "String", required = true)
    })
    public Map sgmbdz_gxList(String templateid) {
        SgmbdzEntity entity = new SgmbdzEntity();
        entity.setTemplateid(templateid);
        Map<String, Object> map = new HashMap<String, Object>();
        List<SgmbdzEntity> liist = service.sgmbdzEditList(entity);
        map.put("rows", liist);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    //    @GetMapping("/gxSelect")
//    @ApiOperation(value = "工序下拉框")
//    public Map gxSelect() {
//        GxEntity entity = new GxEntity();
//        return service.gxSelect(entity);
//    }


    @GetMapping("/circuitSelect")
    @ApiOperation(value = "工序下拉框")
    public Map circuitSelect() {
        GxEntity entity= new GxEntity();
        return service.circuitSelect(entity);
    }
}
