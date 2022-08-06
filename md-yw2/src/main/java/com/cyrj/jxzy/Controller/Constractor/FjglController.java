package com.cyrj.jxzy.Controller.Constractor;

import java.util.Map;
import javax.servlet.http.HttpSession;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.FjglEntity;
import com.cyrj.jxzy.service.Constractor.FjglServiceI;

/**
 * 企业录入
 *
 * @author xu 20181023
 */
@RestController
@Api(tags = "【功能管理】附件管理")
@RequestMapping(value = {"/Fjgl"})
public class FjglController {

    @Autowired
    private FjglServiceI fjglService;

    @GetMapping(value = "/show_list")
    @ApiOperation(value = "列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent_id", value = "父级id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "annex_name", value = "附件名称", paramType = "query", dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功",response = FjglEntity.class),
    })
    public Map<String, Object> show_list(String parent_id,String annex_name, Pager pager) {
        return fjglService.show_list(parent_id,annex_name, pager);
    }

    @PostMapping("/addSave")
    @ApiOperation(value = "附件增加保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent_id", value = "父级id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "parent_name", value = "父级名称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "annex_name", value = "附件名称", paramType = "query", dataType = "String", required = true)
    })
    public Map addSave(@RequestBody FjglEntity entity) {
        return fjglService.addSave(entity);
    }

    @PutMapping("/editSave")
    @ApiOperation(value = "附件修改保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "附件id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "annex_name", value = "附件名称", paramType = "query", dataType = "String", required = true)
    })
    public Map editSave(@RequestBody FjglEntity entity) {
        return fjglService.editSave(entity);
    }

    @DeleteMapping("/removeSave")
    @ApiOperation(value = "删除附件保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "附件id", paramType = "query", dataType = "String", required = true)
    })
    public Map removeSave(String id) {
        return fjglService.removeSave(id);
    }

    @GetMapping(value = "/setId_Returnid")
    @ApiOperation(value = "根据条件查询下拉框",notes = "根据父id或父级名称查询，返回key为附件名称，value为附件id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent_id", value = "父级id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "parent_name", value = "父级名称", paramType = "query", dataType = "String")
    })
    public Map setId_Returnid(String parent_id,String parent_name) {
        return fjglService.setId_Returnid(parent_id,parent_name);
    }



    @GetMapping(value = "/selectTree_name")
    @ApiOperation(value = "根据条件查询树形结构",notes="根据附件id或附件名称查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent_id", value = "父级id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "parent_name", value = "父级名称", paramType = "query", dataType = "String")
    })
    public Map selectTree_name(String parent_id,String parent_name) {
        return fjglService.selectTree_name(parent_id,parent_name);
    }

}
