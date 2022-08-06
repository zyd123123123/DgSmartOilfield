package com.cyrj.jxzy.Controller.Constractor;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CommitmentViewEntity;
import com.cyrj.jxzy.service.Constractor.CommitmentViewServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.cyrj.jxzy.entity.Constractor.CnsflbEntity;
import com.cyrj.jxzy.service.Constractor.CommitmentServiceI;


@RestController
@RequestMapping("/Constractor/Commitment/")
@Api(tags = "HSE承诺书管理")
public class CommitmentController {
    @Autowired
    private CommitmentServiceI commitmentService;
    @Autowired
    private CommitmentViewServiceI commitmentviewService;

    @GetMapping(value = "commitment_list")
    @ApiOperation(value = "承诺书附录表查询")
    public Map commitmentFind() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", commitmentService.cnsflbSelect());
        return map;
    }

    @PostMapping(value = "save")
    @ApiOperation(value = "承诺书附录表保存")
    public Map save(@RequestBody CnsflbEntity entity) {
        return commitmentService.save(entity);
    }


    @GetMapping(value = "show_list")
    @ApiOperation(value = "列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filetype", value = "附件类型:HSE承诺书", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String")
    })
    public Map show_list(String filetype, String effective_dates, String unit_id, String contractor_id,Pager pager) {
        CommitmentViewEntity entity = new CommitmentViewEntity();
        entity.setFiletype(filetype);
        entity.setEffective_dates(effective_dates);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        return commitmentviewService.show_list(entity, pager);
    }


    @GetMapping("/showPrint")
    @ApiOperation(value = "承诺书浏览、打印")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true)
    })
    public Map showPrint(String contract_id) {

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", commitmentviewService.getPrint(contract_id));
        return map;

    }
}
