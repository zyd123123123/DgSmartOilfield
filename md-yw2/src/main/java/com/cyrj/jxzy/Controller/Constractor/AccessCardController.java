package com.cyrj.jxzy.Controller.Constractor;

import java.util.Map;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.DwzzEntity;
import com.cyrj.jxzy.service.Constractor.AccessCardServiceI;

@RestController
@RequestMapping(value = {"/AccessCard"})
@Api(tags = "准入证管理")
public class AccessCardController {

    @Autowired
    private AccessCardServiceI accessCardService;


    @GetMapping("/apply")
    @ApiOperation(value = "准入证申请", notes = "查询返回队伍绑定设备、人员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwlbid", value = "单位类别id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String", required = true)
//			@ApiImplicitParam(name = "jl", value = "经理", paramType = "query", dataType = "String"),
//			@ApiImplicitParam(name = "dh", value = "电话", paramType = "query", dataType = "String"),
//			@ApiImplicitParam(name = "bh", value = "队伍资质编号", paramType = "query", dataType = "String")
    })
    public Map apply(String termid, String dwdm, String dwlbid) {
        return accessCardService.apply(termid, dwdm, dwlbid);
    }

    @GetMapping("/unit_select")
    @ApiOperation(value = "企业名称下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwlbid", value = "单位类别id", paramType = "query", dataType = "String")
    })
    public Map unit_select(String dwlbid) {
        return accessCardService.unit_select(dwlbid);
    }


    @GetMapping("unit_select1")
    @ApiOperation(value = "队伍名称下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "单位代码", paramType = "query", dataType = "String", required = true)
    })
    public Map unit_select1(String parentid) {
        return accessCardService.unit_select1(parentid);
    }


    @GetMapping("unit_select11")
    @ApiOperation(value = "队伍名称下拉框2",notes = "与资质表左联，查询未申请资质表的小队")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "单位代码", paramType = "query", dataType = "String", required = true)
    })
    public Map unit_select11(String parentid) {
        return accessCardService.unit_select11(parentid);
    }

    @GetMapping("unit_select3")
    @ApiOperation(value = "施工项目下拉框")
    public  Map unit_select3() {

        return accessCardService.unit_select3();
    }

    @PostMapping("save")
    @ApiOperation(value = "申请、修改、换证保存")
    public Map save(@RequestBody DwzzEntity zz_entity) {
        return accessCardService.accessCard_save(zz_entity);
    }


    @GetMapping("/term")
    @ApiOperation(value = "准入证申请验证",notes = "判断队伍是否已经提交过，每个队伍只能提交一次")
    @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String", required = true)
    public Map term(String termid) {
        return accessCardService.totalRows4(termid);
    }


    @GetMapping("/select_manager")
    @ApiOperation(value = "查询经理和电话",response = QylrEntity.class)
    @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String", required = true)
    public Map select_manager(String termid) {
        return accessCardService.select_manager(termid);
    }


    @GetMapping("/accessCard_select")
    @ApiOperation(value = "列表查询",response = DwzzEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "audit_tab", value = "审核标记：1待审核(申请)、2通过、3待审核(换证)、4过期  0初次申请退回 5换证退回", paramType = "query", dataType = "String")
    })
    public Map accessCard_select(String dwdm,String audit_tab, Pager pager) {
        return accessCardService.accessCard_select(dwdm,audit_tab, pager);
    }

    @GetMapping("/apply_audit_select")
    @ApiOperation(value = "待审核列表查询",response = DwzzEntity.class)
    public Map apply_audit_select( Pager pager) {
        DwzzEntity zz_entity= new DwzzEntity();
        return accessCardService.apply_audit_select(zz_entity, pager);
    }

    @GetMapping("/apply_InReview_select")
    @ApiOperation(value = "审核中列表查询",response = DwzzEntity.class)
    public Map apply_InReview_select( Pager pager) {
        DwzzEntity zz_entity= new DwzzEntity();
        return accessCardService.apply_InReview_select(zz_entity, pager);
    }

    @GetMapping("/apply_completed_select")
    @ApiOperation(value = "已完成列表查询",response = DwzzEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "audit_tab", value = "审核标记：2已完成", paramType = "query", dataType = "String",required = true)
    })
    public Map apply_completed_select(String audit_tab, Pager pager) {
        DwzzEntity zz_entity= new DwzzEntity();
        zz_entity.setAudit_tab(audit_tab);
        return accessCardService.apply_completed_select(zz_entity, pager);
    }

    @GetMapping("/apply_fail_select")
    @ApiOperation(value = "未通过列表查询",response = DwzzEntity.class)
    public Map apply_fail_select( Pager pager) {
        DwzzEntity zz_entity= new DwzzEntity();
        return accessCardService.apply_fail_select(zz_entity, pager);
    }

    @GetMapping("/apply_audit")
    @ApiOperation(value = "审核功能准入证信息")
    @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true)
    public Map apply_audit(String sjid) {
        return accessCardService.apply_audit(sjid);
    }

    @PutMapping(value = {"/audit_sava"})
    @ApiOperation(value = "审核保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "audit_tab", value = "审核标记：2通过、 0初次申请退回 5换证退回", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "syxq1", value = "有效期开始时间", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "syxq2", value = "有效期结束时间", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "ffbm", value = "发证部门", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "sgqy", value = "施工区域", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "sgxm", value = "施工项目", paramType = "query", dataType = "String",required = true)
    })
    public Map audit_sava(@RequestBody DwzzEntity zz_entity) {
        return accessCardService.audit_sava(zz_entity);
    }


    @GetMapping("/accessCard_print")
    @ApiOperation(value = "准入证打印")
    @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true)
    public Map  accessCard_print(String sjid) {
        DwzzEntity zz_entity = new DwzzEntity();
        zz_entity.setSjid(sjid);
        return accessCardService.accessCard_print(zz_entity);
    }

    @GetMapping("/changeCertificate_select")
    @ApiOperation(value = "换证列表查询",response = DwzzEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dwmc", value = "企业名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unitname", value = "企业简称", paramType = "query", dataType = "String")
    })
    public Map changeCertificate_select(String dwmc,String  unitname, Pager pager) {
        DwzzEntity zz_entity= new DwzzEntity();
        zz_entity.setDwmc(dwmc);
        zz_entity.setUnitname(unitname);
        return accessCardService.changeCertificate_select(zz_entity, pager);
    }

    @GetMapping("/changeCertificate")
    @ApiOperation(value = "换证申请判断",notes ="判断换证申请是否已经提交过，保证换证过程中能够只能提交一次" )
    @ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true)
    public Map changeCertificate(String termid) {
        DwzzEntity zz_entity= new DwzzEntity();
        zz_entity.setTermid(termid);
        return accessCardService.changeCertificate(zz_entity);
    }

    @GetMapping("/changeCertificate_thisTeam_select")
    @ApiOperation(value = "换证、修改功能准入证信息",notes ="返回新的人员、设备信息" )
    @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true)
    public Map changeCertificate_thisTeam_select(String sjid){
        DwzzEntity zz_entity= new DwzzEntity();
        zz_entity.setSjid(sjid);
        return accessCardService.changeCertificate_thisTeam_select(zz_entity);
    }

    @PutMapping("/feichu")
    @ApiOperation(value = "废除保存")
    @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true)
    public Map feichu(@RequestBody  DwzzEntity zz_entity) {
//        DwzzEntity zz_entity= new DwzzEntity();
//        zz_entity.setSjid(sjid);
        return accessCardService.feichu(zz_entity);
    }


    @PutMapping("/jiechu")
    @ApiOperation(value = "解除保存")
    @ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String",required = true)
    public Map jiechu(@RequestBody  DwzzEntity zz_entity) {
//        DwzzEntity zz_entity= new DwzzEntity();
//        zz_entity.setSjid(sjid);
        return accessCardService.jiechu(zz_entity);
    }

}
