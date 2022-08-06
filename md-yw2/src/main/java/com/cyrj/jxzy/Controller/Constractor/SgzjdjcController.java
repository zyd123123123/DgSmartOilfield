package com.cyrj.jxzy.Controller.Constractor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.entity.Constractor.*;
import com.cyrj.jxzy.util.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.service.Constractor.SgjdjcService;

@RestController
@RequestMapping("/sgzjdjc")
@Api(tags = "施工过程监督检查")
public class SgzjdjcController {

    @Autowired
    private SgjdjcService service;


    @GetMapping("/jcxzflb")
    @ApiOperation(value = "附录表数据查询")
    public Map jcxzflb() {
        CbsFj4Entity entity = new CbsFj4Entity();
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", service.listFlb(entity));
        return resultMap;
    }

    @PostMapping("/flbSave")
    @ApiOperation(value = "附录表保存")
    public Map flbSave(@RequestBody CbsFj4Entity entity) {
        return service.flbSave(entity);
    }

    @GetMapping("/jcxzb")
    @ApiOperation(value = "检查细则表查看、打印")
    public Map jcxzb() {
        CbsFj4Entity entity = new CbsFj4Entity();
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", service.listFlb(entity));
        return resultMap;
    }

    @GetMapping("/jcxzb_dy")
    @ApiOperation(value = "根据选择项返回打印页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tab1", value = "开工验收:1", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tab2", value = "井下作业HSE管理:2", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tab3", value = "井下作业质量管理:3", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tab4", value = "井下作业井控管理:4", paramType = "query", dataType = "String")
    })
    public Map  jcxzb_dy(String tab1, String tab2, String tab3, String tab4) {
        CbsFj4Entity entity = new CbsFj4Entity();
        Map<String, Object> map = new HashMap<String, Object>();
        String sql = "";
        if ("1".equals(tab1)) {
            sql = sql + ",'开工验收'";
        }
        if ("1".equals(tab2)) {
            sql = sql + ",'井下作业HSE管理'";
        }
        if ("1".equals(tab3)) {
            sql = sql + ",'井下作业质量管理'";
        }
        if ("1".equals(tab4)) {
            sql = sql + ",'井下作业井控管理'";
        }
        if(StringUtils.isNotEmpty(sql)&&sql.length()>0){
            sql = sql.substring(1, sql.length());
        }
        entity.setJcxm1(sql);
        List<CbsFj4Entity> list = service.listFlb(entity);
        //用于合并列的表格
        StringBuffer sb1 = new StringBuffer();
        sb1.append("<table class='bor' id='t_detail1'>");
        sb1.append("<tr>");
        sb1.append("<td colspan=\"3\" align='center'>").append("检查项目").append("</td>");
        sb1.append("<td align='center'>").append("监督检查内容").append("</td>");
        sb1.append("</tr>");
        sb1.append("<tbody id='tbody1'>");
        //用于分页获取数据表格（隐藏表格）
        StringBuffer sb2 = new StringBuffer();
        sb2.append("<table class='bor' id='t_detail2'>");
        sb2.append("<tr>");
        sb2.append("<td colspan=\"3\" align='center'> ").append("检查项目").append("</td>");
        sb2.append("<td align='center'>").append("监督检查内容").append("</td>");
        sb2.append("</tr>");
        sb2.append("<tbody id='tbody2'>");

        for (CbsFj4Entity entity1 : list) {

            sb1.append("<tr>");
            sb1.append("<td  align='center'>").append(entity1.getJcxm1()).append("</td>");
            sb1.append("<td  align='center'>").append(entity1.getJcxm2()).append("</td>");
            sb1.append("<td  align='center'>").append(entity1.getJcxm3()).append("</td>");
            sb1.append("<td >").append(entity1.getJdjcnr()).append("</td>");
            sb1.append("</tr>");

            sb2.append("<tr>");
            sb2.append("<td  align='center'>").append(entity1.getJcxm1()).append("</td>");
            sb2.append("<td  align='center'>").append(entity1.getJcxm2()).append("</td>");
            sb2.append("<td  align='center'>").append(entity1.getJcxm3()).append("</td>");
            sb2.append("<td >").append(entity1.getJdjcnr()).append("</td>");
            sb2.append("</tr>");
        }
        sb1.append("</tbody>");
        sb1.append("</table>");

        sb2.append("</tbody>");
        sb2.append("</table>");
        map.put("content1", sb1.toString());
        map.put("content2", sb2.toString());
        map.put("entity_list", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", service.listFlb(entity));
        return resultMap;
    }

    @GetMapping("/showList_lr")
    @ApiOperation(value = "检查录入页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "well_purpose", value = "井别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyc", value = "生产单位—采油厂", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyk", value = "生产单位—采油矿", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyd", value = "生产单位—采油队", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw1", value = "施工单位", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw2", value = "作业队", paramType = "query", dataType = "String")
    })
    public Map  showList_lr(String well_common_name,String well_purpose,String cyc ,String cyk ,String cyd ,String sgdw1,String sgdw2, Pager pager) {
        Sgjdjc_J_ListEntity entity= new Sgjdjc_J_ListEntity();
        entity.setCyd(cyd);
        entity.setCyk(cyk);
        entity.setCyc(cyc);
        entity.setWell_common_name(well_common_name);
        entity.setWell_purpose(well_purpose);
        entity.setSgdw1(sgdw1);
        entity.setSgdw2(sgdw2);
        return service.showList(entity, pager);
    }

    @GetMapping("/sgjdjclr")
    @ApiOperation(value = "施工监督检查录入查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sgdw", value = "施工单位", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "op_team", value = "作业队", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "qualification_id", value = "队伍资质", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "well_purpose", value = "井别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "zylx", value = "作业类型", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "design_num", value = "设计串号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "construction_id", value = "总结id", paramType = "query", dataType = "String",required = true)
    })
    public Map  sgjdjclr(String sgdw,String op_team, String qualification_id, String well_common_name,String well_purpose,String zylx,String design_num,String construction_id, HttpServletRequest request) {

        Sgjdjc_J_ListEntity entity= new Sgjdjc_J_ListEntity();
        entity.setSgdw(sgdw);
        entity.setOp_team(op_team);
        entity.setQualification_id(qualification_id);
        entity.setWell_common_name(well_common_name);
        entity.setWell_purpose(well_purpose);
        entity.setZylx(zylx);
        entity.setDesign_num(design_num);
        entity.setConstruction_id(construction_id);
        Map map= new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
        String date = sdf.format(new Date());
        int dd = (int) (Math.random() * 900 + 100);
        String jcId = "JC" + date + dd; //合同ID
        entity.setJcid(jcId);
        map.put("entity",entity);
        List<CbsFj4Entity> list = service.listFlb(new CbsFj4Entity());
        map.put("entity_list",list);
        SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
        String date1 = sdf1.format(new Date());
        map.put("jcsj",date1);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String truename =userEntity.getReal_name();
        map.put("jcr",truename);
        //查询队长
        String dz = service.select(entity);
        map.put("sgdwfzr_jc",dz);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @PostMapping("/sgjdjclrSave")
    @ApiOperation(value = " 监督检查记录保存")
    public Map sgjdjclrSave(@RequestBody SgjdjclrEntity entity) {
        return service.sgjdjclrSave(entity);
    }

    @GetMapping("/showList_jl")
    @ApiOperation(value = "检查记录查看页列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "well_purpose", value = "井别", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyc", value = "生产单位—采油厂", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyk", value = "生产单位—采油矿", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "cyd", value = "生产单位—采油队", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw1", value = "施工单位", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw2", value = "作业队", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sign", value = "标记:1监督录入2承包商整改完成3复查完成", paramType = "query", dataType = "String")
    })
    public Map  showList_jl( String well_common_name,String well_purpose,String cyc ,String cyk ,String cyd ,String sgdw1,String sgdw2,String sign, Pager pager) {
        Sgjdjc_J_ListEntity entity= new Sgjdjc_J_ListEntity();
        entity.setCyd(cyd);
        entity.setCyk(cyk);
        entity.setCyc(cyc);
        entity.setWell_common_name(well_common_name);
        entity.setWell_purpose(well_purpose);
        entity.setSgdw1(sgdw1);
        entity.setSgdw2(sgdw2);
        entity.setSign(sign);
        return service.showList_jl(entity, pager);
    }

    @GetMapping("/jdjcmxList")
    @ApiOperation(value = "检查记录列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "construction_id", value = "总结id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "sign", value = "标记:1监督录入2承包商整改完成3复查完成", paramType = "query", dataType = "String")
    })
    public Map  jdjcmxList(String construction_id,String sign) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setConstruction_id(construction_id);
        entity.setSign(sign);
        return service.jdjcmxList(entity);
    }

    @GetMapping("/jcjl_liulan")
    @ApiOperation(value = "监督检查记录查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jcid", value = "检查id", paramType = "query", dataType = "String",required = true)
    })
    public Map jcjl_liulan(String jcid) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setJcid(jcid);
        SgjdjclrEntity entity1 = service.jcjl_liulanSelect(entity);
        List<SgjdjclrEntity> list = service.jcjl_liulanList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity1);
        map.put("entity_list", list);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;

    }

//    //监督检查记录打印
//    @RequestMapping("/jcjl_liulan_print")
//    public String jcjl_liulan_print(SgjdjclrEntity entity, Model model) {
//
//        SgjdjclrEntity entity1 = service.jcjl_liulanSelect(entity);
//        List<SgjdjclrEntity> list = service.jcjl_liulanList(entity);
//        model.addAttribute("entity", entity1);
//        model.addAttribute("entity_list", list);
//
//        return "Constractor/cbs/Sgjdjcjl_mx_print";
//
//    }

    //
    @DeleteMapping("/jcjlRemove")
    @ApiOperation(value = "删除检查记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jcid", value = "检查id", paramType = "query", dataType = "String",required = true)
    })
    public Map  jcjlRemove(String jcid) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setJcid(jcid);
        return service.jcjlRemove(entity);
    }

    @GetMapping("/sgjdjcjl_hz")
    @ApiOperation(value = "检查记录汇总查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "construction_id", value = "总结id", paramType = "query", dataType = "String",required = true)
    })
    public Map  sgjdjcjl_hz(String construction_id) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setConstruction_id(construction_id);

        SgjdjclrEntity entity1 = service.sgjdjcjl_hzSelect(entity);
        List<SgjdjclrEntity> entity_list = service.sgjdjcjl_hzList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity1);
        map.put("entity_list", entity_list);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;
    }

    @PostMapping("/uploadFiles")
    @ApiOperation(value = "图片上传")
    public Map uploadFiles(SgjdjcUploadEntity entity, @RequestPart("files") MultipartFile[] files) {
        return service.uploadFiles(entity, files);
    }

    @GetMapping("/imageView")
    @ApiOperation(value = "查询监督图片路径")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jcid", value = "检查id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "jcxm1", value = "检查项一", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "jcxm2", value = "检查项二", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "jcxm3", value = "检查项三", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "tab", value = "标记：1检查照片、2整改照片，3、复查照片", paramType = "query", dataType = "String",required = true),
    })
    public Map  imageView(String jcid,String jcxm1,String jcxm2,String jcxm3,String tab) {
        SgjdjcUploadEntity entity = new SgjdjcUploadEntity();
        entity.setJcid(jcid);
        entity.setJcxm1(jcxm1);
        entity.setJcxm2(jcxm2);
        entity.setJcxm3(jcxm3);
        entity.setTab(tab);
        List<SgjdjcUploadEntity> list = service.imageView(entity);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",list);
        return  resultMap;
    }

    @GetMapping("/sgjdjczg_lr")
    @ApiOperation(value = "整改录入查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jcid", value = "检查id", paramType = "query", dataType = "String",required = true)
    })
    public Map  sgjdjczg_lr(String jcid, HttpServletRequest request) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setJcid(jcid);

        SgjdjclrEntity entity1 = service.jcjl_liulanSelect(entity);
        List<SgjdjclrEntity> list = service.jcjl_liulanList(entity);
        if (StringUtils.isBlank(entity1.getSgdwfzr_zg())) {
            entity1.setSgdwfzr_zg(entity1.getSgdwfzr_jc());
        }
        if (StringUtils.isBlank(entity1.getZgr())) {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String truename = userEntity.getReal_name();
            entity1.setZgr(truename);
        }
        if (StringUtils.isBlank(entity1.getZgsj())) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
            String date1 = sdf1.format(new Date());
            entity1.setZgsj(date1);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity1);
        map.put("entity_list", list);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;
    }

    @PutMapping("/sgjdjczgSave")
    @ApiOperation(value = "整改、复查记录保存")
    public Map  sgjdjczgSave(@RequestBody SgjdjclrEntity entity) {
        return service.sgjdjczgSave(entity);
    }

    @GetMapping("/sgjdjcfc_lr")
    @ApiOperation(value = "复查录入查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jcid", value = "检查id", paramType = "query", dataType = "String",required = true)
    })
    public Map sgjdjcfc_lr(String  jcid, HttpServletRequest request) {
        SgjdjclrEntity entity = new SgjdjclrEntity();
        entity.setJcid(jcid);
        SgjdjclrEntity entity1 = service.jcjl_liulanSelect(entity);
        List<SgjdjclrEntity> list = service.jcjl_liulanList(entity);
        if (StringUtils.isBlank(entity1.getSgdwfzr_fc())) {
            entity1.setSgdwfzr_fc(entity1.getSgdwfzr_zg());
        }
        if (StringUtils.isBlank(entity1.getFcr())) {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String truename = userEntity.getReal_name();
            entity1.setFcr(truename);
        }
        if (StringUtils.isBlank(entity1.getFcsj())) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd");
            String date1 = sdf1.format(new Date());
            entity1.setFcsj(date1);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity1);
        map.put("entity_list", list);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;

    }

    @GetMapping("/unit_select")
    @ApiOperation(value = "生产单位下拉框")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentid", value = "父级单位id", paramType = "query", dataType = "String")
    })
    public Map  unit_select(String parentid) {
        PcUnitEntity entity = new PcUnitEntity();
        entity.setParentid(parentid);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",service.unit_select(entity));
        return  resultMap;
    }
}
