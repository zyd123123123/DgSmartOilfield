package com.sydx.aqsc.ctrl.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.SgdyEntity;
import com.sydx.aqsc.entity.Security.ZylxEntity;
import com.sydx.aqsc.service.Security.GxServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sgdy")
@Api(tags = "【功能管理】施工单元管理")
public class SgdyController {

    @Autowired
    private GxServiceI service;

    @GetMapping("/sgdy_List")
    @ApiOperation(value ="施工单元列表查询" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sgdymc", value = "施工单元名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdylb", value = "施工单元类别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "stim_key_id", value = "措施id", paramType = "query", dataType = "String")
    })
    public Map sgdy_List(String sgdymc, String stim_key_id,String sgdylb, Pager pager) {
        SgdyEntity entity = new SgdyEntity();
        entity.setSgdymc(sgdymc);
        entity.setStim_key_id(stim_key_id);
        entity.setSgdyid(sgdylb);
        return service.sgdy_List(entity, pager);
    }

    @PostMapping("/sgdy_Save")
    @ApiOperation(value = "施工单元新增保存")
    public Map sgdy_Save(@RequestBody SgdyEntity entity) {
        return service.sgdy_Save(entity);
    }

    @DeleteMapping("/sgdy_remove")
    @ApiOperation(value = "施工单元删除保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sgdyid", value = "施工单元id", paramType = "query", dataType = "String",required = true)
    })
    public Map sgdy_remove(String sgdyid) {
        return service.sgdy_remove(sgdyid);
    }

    //施工单批量元修改
//    @GetMapping("/sgdy_editAll")
//    @ApiOperation(value = "施工单元修改查询")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "shuzu", value = "施工单元id集合", paramType = "query", dataType = "String",required = true)
//    })
//    public Map sgdy_edit(String shuzu ) {
//        Map map =new HashMap();
//        map.put("code",200);
//        map.put("msg","成功");
//        map.put("data",service.sgdy_editAllSelect(shuzu));
//        return map;
//    }
//
//    @PutMapping("/sgdy_editAll_Save")
//    @ApiOperation(value = "施工单元批量修改保存")
//    public Map sgdy_editAll_Save(@RequestBody  SgdyEntity entity) {
//
//        return service.sgdy_editAll_Save(entity);
//    }

    @GetMapping("/sgdy_edit")
    @ApiOperation(value = "施工单元修改查询")
        @ApiImplicitParams({
            @ApiImplicitParam(name = "sgdyid", value = "施工单元id", paramType = "query", dataType = "String",required = true)
    })
    public Map sgdy_edit(String sgdyid){
        SgdyEntity entity= new SgdyEntity();
        entity.setSgdyid(sgdyid);
        List<SgdyEntity> list = service.sgdy_editSelect(entity);
        Map map= new HashMap();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",list.get(0));
        return  map;
    }

    @PutMapping("/sgdy_edit_Save")
    @ApiOperation(value = "施工单元修改保存")
    public  Map sgdy_edit_Save(@RequestBody  SgdyEntity entity){
        return service.sgdy_edit_Save(entity);
    }

    @GetMapping("/sgdySelect")
    @ApiOperation(value = "施工单元选择框")
    public Map sgdySelect() {
        SgdyEntity entity = new SgdyEntity();
        return service.sgdySelect(entity);
    }

    @GetMapping("/zylSelect")
    @ApiOperation(value = "措施类型选择框")
    public Map zylSelect(){
        ZylxEntity entity = new ZylxEntity();
        return service.zylSelect(entity);
    }
}
