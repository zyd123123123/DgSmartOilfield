package com.sydx.aqsc.ctrl.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.service.Security.SgjdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 大庆油田安全生产施工进度大图,
 *大庆油田安全生产单井施工进度
 *冀东油田安全生产单井施工进度
 */
@RestController
@RequestMapping("/sgjd")
@Api(tags = "【施工管理】施工进度管理")
public class SgjdController {

    @Autowired
    private SgjdService service;

    @GetMapping("/djsgjd_Show")
    @ApiOperation(value = "单井生产进度列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "scdw", value = "生产单位代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw", value = "施工单位代码", paramType = "query", dataType = "String")
    })
    public Map djsgjd_Show(String well_common_name,String scdw,String sgdw,  Pager pager){
        WellEntity entity = new WellEntity();
        entity.setWell_common_name(well_common_name);
        entity.setScdw(scdw);
        entity.setZydw(sgdw);
        return service.djsgjd_Show(entity,pager);
    }

    @GetMapping("/djsgjd_gx_Show")
    @ApiOperation(value = "单井施工进度查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "construction_id", value = "施工总结id", paramType = "query", dataType = "String",required = true)
    })
    public Map djsgjd_gx_Show(String construction_id){
        Djsgjd_GxEntity entity = new Djsgjd_GxEntity();
        entity.setConstruction_id(construction_id);
        return service.djsgjd_gx_Show(entity);
    }
    //施工进度大图根据大队id查询队伍名称及施工井号——大庆
    @GetMapping("/zyjd_dw")
    @ApiOperation(value = "施工进度图井号查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "施工单位三级id", paramType = "query", dataType = "String",required = true)
    })
    public Map zyjd_dw(String parentid){
        ZyjdEntity entity = new ZyjdEntity();
        entity.setParentid(parentid);
        return service.zyjd_dw(entity);
    }

    //施工进度大图，根据单井施工工序——大庆
    @GetMapping("/zyjd_gx")
    @ApiOperation(value = "查询工序列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "construction_id", value = "施工总结id", paramType = "query", dataType = "String",required = true)
    })
    public Map zyjd_gx(String construction_id){
        Djsgjd_GxEntity entity = new Djsgjd_GxEntity();
        entity.setConstruction_id(construction_id);
        return service.zyjd_gx(entity);
    }
    @GetMapping("/ejList")
    @ApiOperation(value = "施工单位二级下拉框")
    public Map ejList(){
        return service.ejList();
    }
    @GetMapping("/sjList")
    @ApiOperation(value = "施工单位三级下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "施工单位二级id", paramType = "query", dataType = "String",required = true)
    })
    public Map sjList(String parentid){
        return service.sjList(parentid);
    }

    @GetMapping("/sijList")
    @ApiOperation(value = "施工单位四级下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "施工单位三级id", paramType = "query", dataType = "String",required = true)
    })
    public Map sijList(String parentid){
        return service.sijList(parentid);
    }



//    //查询暂停记录——大庆
//    @RequestMapping("/djsgjd_zt_Show")
//    @ResponseBody
//    public Map djsgjd_zt_Show(Djsgjd_GxEntity entity){
//
//    return service.djsgjd_zt_Show(entity);
//    }
//
//    //施工进度图配置页面——大庆
//    @RequestMapping("/sgjd_config")
//    public String sgjd_config(Sgjd_configEntity entity , Model model){
//        Sgjd_configEntity entity1 = service.sgjd_config(entity);
//        model.addAttribute("entity",entity1);
//        return "Security/sgdt/sgjd_config";
//    }
//
//    //施工进度配置保存——大庆
//    @RequestMapping("/config_save")
//    @ResponseBody
//    public  Map config_save(Sgjd_configEntity entity ){
//
//        return service.config_save(entity);
//    }
//
//    //施工进度配置重置功能——大庆
//    @RequestMapping("/config_remove")
//    @ResponseBody
//    public  Map config_remove(Sgjd_configEntity entity ){
//
//        return service.config_remove(entity);
//    }
//
//    //施工进度配置重置功能——大庆
//    @RequestMapping("/config_select")
//    @ResponseBody
//    public  Map config_select(Sgjd_configEntity entity ){
//
//        return service.config_select(entity);
//    }
//
//    /**
//     * 单井施工进度查询jd——冀东
//     * @return
//     */
//    @RequestMapping(value = "/sgjd_list")
//    @ResponseBody
//    public Map sgjd_list(ReportWorkoveEntity sgjd, Pager pager) {
//
//        return service.sgjd_list(sgjd, pager);
//    }
//
//    /**
//     * 查询单井施工步骤定制工序jd——冀东
//     * @return
//     */
//    @RequestMapping("/spnameList")
//    @ResponseBody
//    public Map<String, Object> spnameList(DjzyjdtEntity entity){
//
//
//        return service.spnameList(entity);
//
//    }

}
