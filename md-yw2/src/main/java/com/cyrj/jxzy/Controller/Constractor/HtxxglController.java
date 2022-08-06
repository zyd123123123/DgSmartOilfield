package com.cyrj.jxzy.Controller.Constractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.*;
import com.cyrj.jxzy.service.Constractor.HtxxckService;
import com.cyrj.jxzy.service.Constractor.HtxxwhService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cyrj.jxzy.service.Constractor.HtxxlrServiceI;


@RestController
@RequestMapping(value = {"/Htxxgl"})
@Api(tags = "合同管理")
public class HtxxglController {

    @Autowired
    private HtxxlrServiceI htxxlrService;
    @Autowired
    private HtxxckService htxxckService;
    @Autowired
    private HtxxwhService htxxwhService;

    //    ==============================================================原合同录入开始
    @GetMapping("/teamList")
    @ApiOperation(value = "合同录入获取队伍")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contractor_id", value = " 承包商ID", paramType = "query", dataType = "String", required = true)
    })
    public Map index(String contractor_id) {
        HtxxlrEntity entity = new HtxxlrEntity();
        entity.setContractor_id(contractor_id);
        //查询承包商下队伍
        List<QualificationEntity> entity_q_list = htxxlrService.qualification_select(entity);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", entity_q_list);
        return map;
    }

    @GetMapping(value = {"/unit_select"})
    @ApiOperation(value = "甲方单位名称下拉框")
    public Map unit_select() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", htxxlrService.unit_select());
        return map;
    }

    @GetMapping(value = {"/cbs_select"})
    @ApiOperation(value = "承包商名称下拉列表")
    public Map cbs_select() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", htxxlrService.cbs_select());
        return map;
    }

    @GetMapping(value = {"/yanzheng"})
    @ApiOperation(value = " 合同信息录入——合同编号校验")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_number", value = " 合同编号", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "contract_id", value = " 合同ID", paramType = "query", dataType = "String")
    })
    public Map check(String contract_number, String contract_id) {
        HtxxlrEntity entity = new HtxxlrEntity();
        entity.setContract_number(contract_number);
        entity.setContractor_id(contract_id);
        return htxxlrService.check(entity);
    }

    @PostMapping(value = {"/save"})
    @ApiOperation(value = "合同录入保存")
    public Map save(@RequestBody HtxxlrEntity entity,  MultipartFile[] files) {

        return htxxlrService.save(entity, files);
    }

    @PutMapping(value = {"/updateSave"})
    @ApiOperation(value = "合同修改保存")
    public Map updateSave(@RequestBody HtxxlrEntity entity, QualificationEntity entity_q) {
        return htxxlrService.updateSave(entity, entity_q);
    }

    @DeleteMapping(value = "/removeContract")
    @ApiOperation(value = "合同退回页面，删除功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = " 合同ID", paramType = "query", dataType = "String", required = true)
    })
    public Map removeContract(String contract_id) {
        HtxxlrEntity entity = new HtxxlrEntity();
        entity.setContract_id(contract_id);
        return htxxlrService.removeContract(entity);
    }


    @PutMapping("/htshth")
    @ApiOperation(value = "审核退回保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = " 合同ID", paramType = "query", dataType = "String", required = true)
    })
    public Map htshth( @RequestBody HtxxlrEntity entity) {
//        HtxxlrEntity entity = new HtxxlrEntity();
//        entity.setContract_id(contract_id);
        return htxxlrService.htshth(entity);
    }

    @PutMapping("/htwgth")
    @ApiOperation(value = "审完工退回保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = " 合同ID", paramType = "query", dataType = "String", required = true)
    })
    public Map htwgth( @RequestBody  HtxxlrEntity entity) {
//        HtxxlrEntity entity = new HtxxlrEntity();
//        entity.setContract_id(contract_id);
        return htxxlrService.htwgth(entity);
    }

//    ==============================================================原合同查看开始
    @GetMapping("/unit_select1")
    @ApiOperation(value = "厂级单位下拉框")
    public Map unit_select1() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", htxxckService.unit_select());
        return map;
    }

    @GetMapping("/cbs_select1")
    @ApiOperation(value = "施工单位下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String")
    })
    public Map cbs_select1(String unit_id) {

        HtxxckEntity entity = new HtxxckEntity();
        entity.setUnit_id(unit_id);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", htxxckService.cbs_select(entity));
        return map;
    }

    @GetMapping("/nf_select")
    @ApiOperation(value = "年份下拉框")
    public Map nf_select() {
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", htxxckService.nf_select());
        return map;
    }

    @GetMapping("/show_list")
    @ApiOperation(value = "查看页面、未通过页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "audittab", value = " 合同信息审核标记默认1待审核，2通过0退回", paramType = "query", dataType = "String")
    })
    public Map show_list(String effective_dates, String unit_id, String contractor_id, String audittab, Pager pager) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        entity.setAudittab(audittab);
        return htxxckService.show_list(entity, pager);
    }

    @GetMapping("/show_list_cj")
    @ApiOperation(value = "合同创建审核列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
    })
    public Map show_list_cj(String effective_dates, String unit_id, String contractor_id, Pager pager) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        return htxxckService.show_list_cj(entity, pager);
    }

    @GetMapping("/show_list_audit")
    @ApiOperation(value = "审核退回页面、完工退回页面、完工确认页面列表数据", notes = "审核退回页面、完工退回页面、完工确认页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "audittab", value = "合同信息审核标记默认1待审核，2通过0退回", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "whether_to_perform", value = "合同是否履行完毕", paramType = "query", dataType = "String")
    })
    public Map show_list_audit(String effective_dates, String unit_id, String contractor_id, String audittab, String whether_to_perform, Pager pager) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        entity.setAudittab(audittab);
        entity.setWhether_to_perform(whether_to_perform);
        return htxxckService.show_list_audit(entity, pager);
    }

    @GetMapping("/show_list_Chang")
    @ApiOperation(value = "合同变更审核页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String")
    })
    public Map show_list_Chang(String unit_id, String contractor_id, Pager pager) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        return htxxckService.show_list_Chang(entity, pager);
    }

    @GetMapping("/term")
    @ApiOperation(value = "合同绑定队伍列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true)
    })
    public Map  term(String contract_id) {
        ContractTeamEntity entity = new ContractTeamEntity();
        entity.setContract_id(contract_id);
        return htxxckService.term(entity);
    }

    @PutMapping("/auditSave")
    @ApiOperation(value = "合同创建审核结果保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "audittab", value = "审核结果：0退回2通过", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "auditremark", value = "退回原因", paramType = "query", dataType = "String")
    })
    public Map auditSave(@RequestBody HtxxckEntity entity) {
//        HtxxckEntity entity = new HtxxckEntity();
//        entity.setContract_id(contract_id);
//        entity.setAudittab(audittab);
//        entity.setAuditremark(auditremark);
        return htxxckService.auditSave(entity);
    }
//    ==============================================================原合同维护开始

    @GetMapping("/listHtxxwh")
    @ApiOperation(value = "合同信息维护列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String")
    })
    public Map listHtxxwh(String effective_dates,String unit_id,String contractor_id, Pager pager){
        HtxxckEntity entity= new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        return htxxwhService.listHtxxwh(entity,pager);
    }


    @GetMapping("/getHtxxck")
    @ApiOperation(value = "合同变更申请",notes = "根据合同id查询，返回合同信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true)
    })
    public Map changeView( String contract_id){

        HtxxckEntity entity=htxxwhService.getHtxxck(contract_id);
        Map map= new HashMap();
        map.put("entity",entity);
        map.put("yxq",entity.getOperation_start_dates()+"至"+entity.getCompletion_dates());//合同有效期

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @PostMapping("/change_save")
    @ApiOperation(value = "合同变更保存")
    public Map change_save(@RequestBody HtxxwhEntity entity){

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",htxxwhService.change_save(entity));
        return resultMap;
    }


    @GetMapping("/xiugai")
    @ApiOperation("合同信息修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true)
    })
    public Map xiugai( String contract_id){

        //查看合同信息
        HtxxckEntity entity = htxxwhService.getHtxxck(contract_id);

        //查询承包商施工队伍，及合同绑定的队伍
        //队伍资质
        QualificationEntity entity_q= new QualificationEntity();
        entity_q.setContract_id(contract_id);
        entity_q.setDwdm(entity.getContractor_id());

        List<QualificationEntity> entity_q_list=htxxwhService.listQualification(entity_q);
        Map map= new HashMap();
        map.put("entity", entity);
        map.put("entity_q_list", entity_q_list);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @GetMapping("/change_Record")
    @ApiOperation("合同变更记录列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true)
    })
    public Map change_Record(String contract_id){

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",htxxwhService.change_Record(contract_id));
        return resultMap;
    }

    @PutMapping("/changeAuditSave")
    @ApiOperation(value = "合同变更审核保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_bgid", value = "合同变更id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "audittab", value = "审核标记:2通过0退回", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "auditremark", value = "退回原因", paramType = "query", dataType = "String" ),
    })
    public Map changeAuditSave( @RequestBody HtxxwhEntity entity ){
//        HtxxwhEntity entity = new HtxxwhEntity();
//        entity.setContract_bgid(contract_bgid);
//        entity.setAudittab(audittab);
//        entity.setAuditremark(auditremark);
        return htxxwhService.changeAuditSave(entity);
    }

    @PutMapping("/completionConfirmation")
    @ApiOperation(value = "完工确认保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true)
    })
    public Map completionConfirmation( @RequestBody HtxxwhEntity entity){
//        HtxxwhEntity entity= new HtxxwhEntity();
//        entity.setContract_id(contract_id);
        return htxxwhService.completionConfirmation(entity);

    }

    @DeleteMapping("/bgRemove")
    @ApiOperation(value = "变更记录删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract_bgid", value = "合同变更id", paramType = "query", dataType = "String", required = true)
    })
    public Map  bgRemove(String contract_bgid  ){
        HtxxwhEntity entity= new HtxxwhEntity();
        entity.setContract_bgid(contract_bgid);
        return htxxwhService.bgRemove(entity);
    }
}
