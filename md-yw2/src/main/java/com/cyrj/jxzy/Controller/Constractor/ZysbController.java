package com.cyrj.jxzy.Controller.Constractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;
import com.cyrj.jxzy.service.Constractor.ZysbService;

@RestController
@RequestMapping("/zysb")
@Api(tags = "【设备管理】主要设备")
public class ZysbController {

    @Autowired
    private ZysbService service;

    @GetMapping("/showList")
    @ApiOperation(value = "列表查询", response = ZysbEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String")
    })
    public Map<String, Object> showList(String dwdm, String termid, Pager pager) {
        ZysbEntity entity = new ZysbEntity();
        entity.setTermid(termid);
        entity.setDwdm(dwdm);
        return service.showList(entity, pager);
    }



    @GetMapping("/termSelect_Zysb")
    @ApiOperation(value = "查询主要设备未录入施工队伍")
    @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String", required = true)
    public Map termSelect_Zysb(String dwdm) {
        List<Map<String, String>> list = service.termSelect_Zysb(dwdm);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @PostMapping("/insertSave")
    @ApiOperation(value = "新增、修改保存")
    public Map insertSave(@RequestBody ZysbEntity entity) {
        return service.insertSave(entity);
    }


    @GetMapping("/unit_select")
    @ApiOperation(value = "企业下拉框")
    public Map unit_select() {
        List<Map<String, String>> list = service.unit_select();
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }


    @GetMapping("/term_select")
    @ApiOperation(value = " 队伍下拉框")
    @ApiImplicitParam(name = "parentid", value = "单位代码", paramType = "query", dataType = "String", required = true)
    public Map term_select(String parentid) {
        List<Map<String, String>> list = service.term_select(parentid);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }


    @GetMapping("/selectOne")
    @ApiOperation("队伍主要设备信息")
    @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String", required = true)
    public Map selectOne(String termid) {
        Map map = new HashMap();
        ZysbEntity entity=new ZysbEntity();
        entity.setTermid(termid);
        List<ZysbEntity> list = service.updateSelect(entity);
        map.put("entity", entity);
        map.put("entity1", entity);
        map.put("entity2", entity);
        if (list.size() > 0) {
            for (ZysbEntity en : list) {
                if (en.getSb().equals("设备一")) {
                    map.put("entity1", en);
                } else if (en.getSb().equals("设备二")) {
                    map.put("entity2", en);
                }
            }
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

}
