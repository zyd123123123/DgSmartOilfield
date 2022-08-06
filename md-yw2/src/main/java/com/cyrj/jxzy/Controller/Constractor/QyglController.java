package com.cyrj.jxzy.Controller.Constractor;


import java.util.Map;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.service.Constractor.QylrServiceI;


@RestController
@RequestMapping(value = {"/qygl"})
@Api(tags = "企业管理")
public class QyglController {

    @Autowired
    private QylrServiceI qylrService;



    @GetMapping(value = {"/show_list"})
    @ApiOperation(value = "列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwlbid", value = "单位类别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unitname", value = "企业简称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "dwmc", value = "企业名称", paramType = "query", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功",response = QylrEntity.class),
    })
    public Map<String, Object> show_list(String dwlbid,String unitname,String dwmc, Pager pager) {
        return qylrService.show_list(dwlbid, unitname,dwmc,pager);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "企业录入保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwdm", value = "单位代码", dataType = "String",required = true)
    })
    public Map save(@RequestBody QylrEntity entity) {
        return qylrService.save(entity);
    }

    @GetMapping(value = "/selecltOne")
    @ApiOperation(value = "企业信息查询")
    @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true)
    public Map selecltOne(String dwdm){
        return qylrService.selecltOne(dwdm);
    }


    @PutMapping(value = {"/save_update"})
    @ApiOperation(value = "企业修改保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "dwmc", value = "单位全称", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "dwmc", value = "单位全称", paramType = "query", dataType = "String",required = true),
    })
    public Map  save_update(@RequestBody QylrEntity entity) {
        return qylrService.save_update(entity);
    }


    @GetMapping(value = {"/unit_select"})
    @ApiOperation(value = "单位类别下拉列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", paramType = "query", dataType = "String",required = true)
    })
    public Map unit_select(String id) {
        return qylrService.unit_select(id);
    }


    @GetMapping(value = {"/unit_select1"})
    @ApiOperation(value = "组织机构下拉列表")
    public Map unit_select1() {
        return qylrService.unit_select1();
    }


    @GetMapping(value = {"/yanzheng"})
    @ApiOperation(value = "验证组织机构是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true)
    })
    public Map check(String dwdm) {
        return qylrService.check(dwdm);
    }

}
