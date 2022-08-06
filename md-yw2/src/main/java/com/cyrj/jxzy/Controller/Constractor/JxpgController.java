package com.cyrj.jxzy.Controller.Constractor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj6Entity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.JxpgEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_Ht_DwEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_cbsEntity;
import com.cyrj.jxzy.service.Constractor.JxpgService;

import net.sf.json.JSONArray;

@RestController
@RequestMapping("/jxpg")
@Api(tags = "竣工后绩效评估")
public class JxpgController {

    @Autowired
    private JxpgService service;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/contractorList")
    @ApiOperation(value = " 绩效评估列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true)
    })
    public Map contractorList(String effective_dates, Pager pager) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        return service.contractorList(entity, pager);
    }

    @GetMapping("/contractList")
    @ApiOperation(value = "绩效评估—合同列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contractor_id", value = "承包商单位id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true)
    })
    public Map contractList(String contractor_id, String effective_dates) {
        HtxxckEntity entity = new HtxxckEntity();
        entity.setEffective_dates(effective_dates);
        entity.setContractor_id(contractor_id);
        return service.contractList(entity);
    }

    //把小数转化成整数，只进不舍——自己写的方法
    public int xzz(String ss) {
        int z = 0;
        if (ss.indexOf(".") != -1) {
            String zheng = ss.substring(0, ss.indexOf("."));
            z = Integer.parseInt(zheng);
            String xiao = ss.substring(ss.indexOf(".") + 1);
            int x = Integer.parseInt(xiao);
            if (x > 0) {
                z = z + 1;
            }
        } else {
            z = Integer.parseInt(ss);
        }
        return z;
    }

    @PostMapping("/jxpgSave")
    @ApiOperation(value = "绩效评估保存")
    public Map jxpgSave(@RequestBody JxpgEntity entity) {
        return service.jxpgSave( entity);
    }

    @GetMapping("/jxpgckList")
    @ApiOperation(value = "查看页面列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "jxpg_tab", value = "绩效评估标识:2新绩效评估，井和合同绑定", paramType = "query", dataType = "String"),
    })
    public Map jxpgckList(String year, String jxpg_tab, String unit_id, String contractor_id, Pager pager) {
        JxpgEntity entity = new JxpgEntity();
        entity.setYear(year);
        entity.setJxpg_tab(jxpg_tab);
        entity.setUnit_id(unit_id);
        entity.setContractor_id(contractor_id);
        return service.jxpgckList(entity, pager);
    }

    @GetMapping("/jxpgck")
    @ApiOperation(value = "绩效评估记录查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jxpgid", value = "绩效评估id", paramType = "query", dataType = "String", required = true)
    })
    public Map jxpgck(String jxpgid) {
        JxpgEntity entity = new JxpgEntity();
        entity.setJxpgid(jxpgid);
        JxpgEntity entity_jl = service.jxpgckSelect1(entity);
        List<Jxpg_Ht_DwEntity> entity_Htdw_list = service.jxpgckSelect2(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity_jl);
        map.put("entity_Htdw_list", entity_Htdw_list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    //按承包商单位评估，生成排名
    @GetMapping("/cbs_pg")
    @ApiOperation(value = "按承包商单位评估")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_class", value = "队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String")
    })
    public Map cbs_pg(String year, String unit_id, String team_class, String contractor_id) {
        Jxpg_cbsEntity entity = new Jxpg_cbsEntity();
        entity.setYear(year);
        entity.setUnit_id(unit_id);
        entity.setTeam_class(team_class);
        entity.setContractor_id(contractor_id);
        return service.cbs_pg(entity);
    }

    @GetMapping("/jxpg_cbs_ht")
    @ApiOperation(value = "合同查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "team_id", value = "队伍id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_class", value = "队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）", paramType = "query", dataType = "String")
    })
    public Map jxpg_cbs_ht(String year, String contractor_id, String team_id, String unit_id, String team_class) {
        Jxpg_cbsEntity entity = new Jxpg_cbsEntity();
        entity.setYear(year);
        entity.setTeam_id(team_id);
        entity.setUnit_id(unit_id);
        entity.setTeam_class(team_class);
        entity.setContractor_id(contractor_id);
        return service.jxpg_cbs_ht(entity);
    }

    @GetMapping("/jxpg_cbs_one")
    @ApiOperation(value = "单个承包商绩效评估表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "team_id", value = "队伍id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_class", value = "队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）", paramType = "query", dataType = "String")
    })
    public Map jxpg_cbs_one(String year, String contractor_id, String unit_id, String team_class) {
        Jxpg_cbsEntity entity = new Jxpg_cbsEntity();
        entity.setYear(year);
        entity.setUnit_id(unit_id);
        entity.setTeam_class(team_class);
        entity.setContractor_id(contractor_id);

        JxpgEntity entity_jl = new JxpgEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        if (StringUtils.isNoneBlank(entity.getUnit_id())) {
            if (StringUtils.isNotBlank(search) && search.length() >= 8) {
                entity_jl.setUnit_name(service.jxpg_cbs_one_select0(entity));
            } else {
                String unit_name = "";
                if ("pc0dq".equals(oilfield)) {
                    unit_name = "大庆油田公司";
                } else if ("pc0jd".equals(oilfield)) {
                    unit_name = "冀东油田公司";
                } else if ("pc0hb".equals(oilfield)) {
                    unit_name = "华北油田公司";
                } else if ("pc0jl".equals(oilfield)) {
                    unit_name = "吉林油田公司";
                } else if ("pc0lh".equals(oilfield)) {
                    unit_name = "辽河油田公司";
                } else if ("pc0dg".equals(oilfield)) {
                    unit_name = "大港油田公司";
                } else if ("pc0nf".equals(oilfield)) {
                    unit_name = "南方油田公司";
                } else if ("pc0zj".equals(oilfield)) {
                    unit_name = "浙江油田公司";
                } else if ("pc0xn".equals(oilfield)) {
                    unit_name = "西南油田公司";
                } else if ("pc0th".equals(oilfield)) {
                    unit_name = "吐哈油田公司";
                } else if ("pc0xj".equals(oilfield)) {
                    unit_name = "新疆油田公司";
                } else if ("pc0ym".equals(oilfield)) {
                    unit_name = "玉门油田公司";
                } else {
                    unit_name = "油田公司";
                }
                entity_jl.setUnit_name(unit_name);
            }
        } else if (StringUtils.isNotBlank(search) && search.length() >= 8) {
            entity.setUnit_id(search.substring(0, 8));
            entity_jl.setUnit_name(service.jxpg_cbs_one_select0(entity));
        } else {
            String unit_name = "";
            if ("pc0dq".equals(oilfield)) {
                unit_name = "大庆油田公司";
            } else if ("pc0jd".equals(oilfield)) {
                unit_name = "冀东油田公司";
            } else if ("pc0hb".equals(oilfield)) {
                unit_name = "华北油田公司";
            } else if ("pc0jl".equals(oilfield)) {
                unit_name = "吉林油田公司";
            } else if ("pc0lh".equals(oilfield)) {
                unit_name = "辽河油田公司";
            } else if ("pc0dg".equals(oilfield)) {
                unit_name = "大港油田公司";
            } else if ("pc0nf".equals(oilfield)) {
                unit_name = "南方油田公司";
            } else if ("pc0zj".equals(oilfield)) {
                unit_name = "浙江油田公司";
            } else if ("pc0xn".equals(oilfield)) {
                unit_name = "西南油田公司";
            } else if ("pc0th".equals(oilfield)) {
                unit_name = "吐哈油田公司";
            } else if ("pc0xj".equals(oilfield)) {
                unit_name = "新疆油田公司";
            } else if ("pc0ym".equals(oilfield)) {
                unit_name = "玉门油田公司";
            } else {
                unit_name = "油田公司";
            }
            entity_jl.setUnit_name(unit_name);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        entity_jl.setAssessment_time(sdf.format(new Date()));

        //查询合同、队伍信息
        List<Jxpg_Ht_DwEntity> entity_Htdw_list = service.jxpg_cbs_one_select1(entity);
        Map<String, Object> workload_ht_map = new HashMap<String, Object>();
        Map<String, Object> money_ht_map = new HashMap<String, Object>();
        Set<String> set = new TreeSet<String>();

        int workload_ht = 0;//合同合计工作量（井次）
        double money_ht = 0;//合同合计金额（万元）
        int workload_dw = 0;//队伍合计工作量（井次）
        for (Jxpg_Ht_DwEntity jx : entity_Htdw_list) {

            //合同总工作量
            if (workload_ht_map.get(jx.getContract_number()) == null) {
                workload_ht = workload_ht + jx.getWorkload_ht();
                workload_ht_map.put(jx.getContract_number(), jx);
            }
            //合同总金额
            if (money_ht_map.get(jx.getContract_number()) == null) {

                BigDecimal b1 = new BigDecimal(money_ht);
                BigDecimal b2 = new BigDecimal(jx.getMoney_ht());
                BigDecimal b3 = b1.add(b2);//小数相加
                money_ht = b3.doubleValue();
                money_ht_map.put(jx.getContract_number(), jx);
            }
            //队伍累计工作量
            workload_dw = workload_dw + jx.getWorkload_dw();
            entity_jl.setContractor_name(jx.getContractor_name());
            entity_jl.setContractor_id(jx.getContractor_id());
//				entity_jl.setUnit_name(jx.getUnit_name());
            //合同施工项目
            String[] ss = jx.getConstruction_project().split(",");
            for (String s : ss) {
                set.add(s);
            }
        }
        DecimalFormat df1 = new DecimalFormat("######0.0000");
        entity_jl.setWorkload_ht(workload_ht); //合同合计工作量
        entity_jl.setMoney_ht(df1.format(money_ht));//合同合计金额
        entity_jl.setWorkload_dw(workload_dw);//队伍累计工作量

        //拼接合同施工项目
        StringBuffer sb1 = new StringBuffer();
        for (String dd : set) {
            sb1.append(dd + ",");
        }
        String a = sb1.toString();
        if (StringUtils.isNoneBlank(a)) {
            entity_jl.setConstruction_project(a.substring(0, a.length() - 1));
        }
        //评估总分数
        double zfs = 0.0;
        //查询合同中是否有未上传HSE承诺书的，若存在没有承诺书合同，评估表中HSE承诺履行列得0，都有得5.00分
        List<Jxpg_Ht_DwEntity> list_HSE = service.jxpg_cbs_one_select3(entity);
        if (list_HSE != null && list_HSE.size() > 0) {
            entity_jl.setHse_score("0");
            entity_jl.setHse_remarks(list_HSE.size() + "个合同无HSE承诺书");
        } else {
            entity_jl.setHse_score("5.00");
            BigDecimal b1 = new BigDecimal(zfs);
            BigDecimal b2 = new BigDecimal(5.00);
            zfs = b1.add(b2).doubleValue();
        }


        //汇总得分
        List<CbsFj6Entity> list_fj6 = service.jxpg_cbs_one_select2(entity);
        Map<String, Double> map = new HashMap<String, Double>();
        for (CbsFj6Entity cj : list_fj6) {

            if (!map.containsKey(cj.getPgyjjbz().trim())) {

                map.put(cj.getPgyjjbz().trim(), cj.getSdf());
                BigDecimal b1 = new BigDecimal(zfs);
                BigDecimal b2 = new BigDecimal(cj.getSdf());
                zfs = b1.add(b2).doubleValue();
                if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/人员的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim().trim())) {//人员符合情况实得分
                    entity_jl.setStaff_compliance_score(cj.getSdfs());
                    entity_jl.setStaff_compliance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业健康的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井下作业健康实得分
                    entity_jl.setHealthy_score(cj.getSdfs());
                    entity_jl.setHealthy_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/设备设施的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim())) {//设备设施本质安全性能实得分
                    entity_jl.setSafety_performance_score(cj.getSdfs());
                    entity_jl.setSafety_performance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/设备设施安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×49项))".trim().equals(cj.getPgyjjbz().trim())) {//设备设施安全实得分
                    entity_jl.setSafety_score(cj.getSdfs());
                    entity_jl.setSafety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/用电安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×9项))".trim().equals(cj.getPgyjjbz().trim())) {//用电安全实得分
                    entity_jl.setElectrical_safety_score(cj.getSdfs());
                    entity_jl.setElectrical_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/消防安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×11项))".trim().equals(cj.getPgyjjbz().trim())) {//消防安全实得分
                    entity_jl.setFire_safety_score(cj.getSdfs());
                    entity_jl.setFire_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/施工安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×20项))".trim().equals(cj.getPgyjjbz().trim())) {//施工安全实得分
                    entity_jl.setConstruction_safety_score(cj.getSdfs());
                    entity_jl.setConstruction_safety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业质量管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×16项))".trim().equals(cj.getPgyjjbz().trim())) {//施工质量实得分
                    entity_jl.setConstruction_quality_score(cj.getSdfs());
                    entity_jl.setConstruction_quality_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业井控管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井控管理实得分
                    entity_jl.setWell_control_score(cj.getSdfs());
                    entity_jl.setWell_control_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业环保的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×12项))".trim().equals(cj.getPgyjjbz().trim())) {//环保管理1实得分
                    entity_jl.setEnvironmentalprotection_score1(cj.getSdfs());
                    entity_jl.setEnvironmentalprotection_remar1(cj.getBz());
                }
            }
        }
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_sgzj = service.jxpg_cbs_one_select4(entity);
        String sgzjpjzq;
        String construction_summary_remarks;//施工总结平均上传周期备注
        if (list_sgzj != null && list_sgzj.size() > 0 && list_sgzj.get(0) != null) {
            String sgzj = list_sgzj.get(0).getSgzj_pj();
            construction_summary_remarks = list_sgzj.get(0).getSgzj_pj_bz();
            int sgzj_pj = this.xzz(sgzj);

            if (sgzj_pj <= 7) {
                sgzjpjzq = "6.00";
            } else if (7 < sgzj_pj && sgzj_pj <= 8) {
                sgzjpjzq = "5.00";
            } else if (8 < sgzj_pj && sgzj_pj <= 9) {
                sgzjpjzq = "4.00";
            } else if (9 < sgzj_pj && sgzj_pj <= 10) {
                sgzjpjzq = "3.00";
            } else {
                sgzjpjzq = "0";
            }
        } else {
            construction_summary_remarks = "";
            sgzjpjzq = "0";
        }
        entity_jl.setConstruction_summary_score(sgzjpjzq);
        entity_jl.setConstruction_summary_remarks(construction_summary_remarks);
        BigDecimal b1 = new BigDecimal(zfs);
        BigDecimal b2 = new BigDecimal(Double.parseDouble(sgzjpjzq));
        zfs = b1.add(b2).doubleValue();

        //平均交井周期
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_jjj = service.jxpg_cbs_one_select5(entity);

        String jjpj;
        String cross_well_remarks;//施工总结平均上传周期备注
        if (list_jjj != null && list_jjj.size() > 0 && list_jjj.get(0) != null) {
            String dd = list_jjj.get(0).getJj_pj();
            cross_well_remarks = list_jjj.get(0).getJj_pj_bz();
            int ss = this.xzz(dd);
            if (ss <= 7) {
                jjpj = "6.00";
            } else if (7 < ss && ss <= 8) {
                jjpj = "5.00";
            } else if (8 < ss && ss <= 9) {
                jjpj = "4.00";
            } else if (9 < ss && ss <= 10) {
                jjpj = "3.00";
            } else {
                jjpj = "0";
            }
        } else {
            cross_well_remarks = "";
            jjpj = "0";
        }
        entity_jl.setCross_well_score(jjpj);
        entity_jl.setCross_well_remarks(cross_well_remarks);
        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(Double.parseDouble(jjpj));
        zfs = b1.add(b2).doubleValue();
        DecimalFormat df = new DecimalFormat("######.00");

        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(15.00);
        double zfs_qb = b1.add(b2).doubleValue();//汇总后的总得分（包含防砂布铺设5.00和质量评价10.00，共计15分）
        entity_jl.setZfs(df.format(zfs_qb));
        String evaluation_conclusion = "";
        if (zfs_qb >= 90) {
            evaluation_conclusion = "优秀";
        } else if (zfs_qb >= 70 && zfs_qb < 90) {
            evaluation_conclusion = "合格";
        } else if (zfs_qb >= 60 && zfs_qb < 70) {
            evaluation_conclusion = "观察使用";
        } else if (zfs_qb < 60) {
            evaluation_conclusion = "不合格";
        }
        entity_jl.setEvaluation_conclusion(evaluation_conclusion);
        Map map1 = new HashMap();
        map1.put("entity", entity_jl);
        map1.put("entity_Htdw_list", entity_Htdw_list);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map1);
        return resultMap;
    }

    @GetMapping("/zyd_pg")
    @ApiOperation(value = "按作业队评估")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_id", value = "队伍id", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_class", value = "队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）", paramType = "query", dataType = "String")

    })
    public Map zyd_pg(String year,  String team_id, String unit_id, String team_class,String contractor_id) {
        Jxpg_cbsEntity entity = new Jxpg_cbsEntity();
        entity.setYear(year);
        entity.setUnit_id(unit_id);
        entity.setTeam_class(team_class);
        entity.setTeam_id(team_id);
        entity.setContractor_id(contractor_id);
        return service.zyd_pg(entity);
    }

    @GetMapping("/jxpg_zyd_one")
    @ApiOperation(value = "单队绩效评估表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year", value = "年份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "contractor_id", value = "施工单位id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "team_id", value = "队伍id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "unit_id", value = "厂级单位ID", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "team_class", value = "队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）", paramType = "query", dataType = "String")

    })
    public Map  jxpg_zyd_one(String year,  String team_id, String unit_id, String team_class,String contractor_id) {
        Jxpg_cbsEntity entity = new Jxpg_cbsEntity();
        entity.setYear(year);
        entity.setUnit_id(unit_id);
        entity.setTeam_class(team_class);
        entity.setTeam_id(team_id);
        entity.setContractor_id(contractor_id);
        JxpgEntity entity_jl = new JxpgEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        if (StringUtils.isNotBlank(search) && search.length() >= 8) {
            entity.setUnit_id(search.substring(0, 8));
            entity_jl.setUnit_name(service.jxpg_cbs_one_select0(entity));
        } else {
            entity_jl.setUnit_name("油田公司");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        entity_jl.setAssessment_time(sdf.format(new Date()));

        //查询合同、队伍信息
        List<Jxpg_Ht_DwEntity> entity_Htdw_list = service.jxpg_zyd_one_select1(entity);
        Map<String, Object> workload_ht_map = new HashMap<String, Object>();
        Map<String, Object> money_ht_map = new HashMap<String, Object>();
        Set<String> set = new TreeSet<String>();

        int workload_ht = 0;//合同合计工作量（井次）
        double money_ht = 0;//合同合计金额（万元）
        int workload_dw = 0;//队伍合计工作量（井次）
        for (Jxpg_Ht_DwEntity jx : entity_Htdw_list) {

            //合同总工作量
            if (workload_ht_map.get(jx.getContract_number()) == null) {
                workload_ht = workload_ht + jx.getWorkload_ht();
                workload_ht_map.put(jx.getContract_number(), jx);
            }
            //合同总金额
            if (money_ht_map.get(jx.getContract_number()) == null) {

                BigDecimal b1 = new BigDecimal(money_ht);
                BigDecimal b2 = new BigDecimal(jx.getMoney_ht());
                BigDecimal b3 = b1.add(b2);//小数相加
                money_ht = b3.doubleValue();
                money_ht_map.put(jx.getContract_number(), jx);
            }
            workload_dw = workload_dw + jx.getWorkload_dw();
            entity_jl.setContractor_name(jx.getContractor_name());
            entity_jl.setContractor_id(jx.getContractor_id());
//				entity_jl.setUnit_name(jx.getUnit_name());
            //合同施工项目
            String[] ss = jx.getConstruction_project().split(",");
            for (String s : ss) {
                set.add(s);
            }
        }
        DecimalFormat df1 = new DecimalFormat("######0.0000");
        entity_jl.setWorkload_ht(workload_ht); //合同合计工作量
        entity_jl.setMoney_ht(df1.format(money_ht));//合同合计金额
        entity_jl.setWorkload_dw(workload_dw);//队伍累计工作量

        //拼接合同施工项目
        StringBuffer sb1 = new StringBuffer();
        for (String dd : set) {
            sb1.append(dd + ",");
        }
        String a = sb1.toString();
        if (StringUtils.isNoneBlank(a)) {
            entity_jl.setConstruction_project(a.substring(0, a.length() - 1));
        }
        //评估总分数
        double zfs = 0.0;
        //查询合同中是否有未上传HSE承诺书的，若存在没有承诺书合同，评估表中HSE承诺履行列得0，都有得5.00分
        entity_jl.setHse_score("5.00");
        //汇总得分
        List<CbsFj6Entity> list_fj6 = service.jxpg_zyd_one_select2(entity);
        Map<String, Double> map = new HashMap<String, Double>();
        for (CbsFj6Entity cj : list_fj6) {

            if (!map.containsKey(cj.getPgyjjbz().trim())) {

                map.put(cj.getPgyjjbz().trim(), cj.getSdf());
                BigDecimal b1 = new BigDecimal(zfs);
                BigDecimal b2 = new BigDecimal(cj.getSdf());
                zfs = b1.add(b2).doubleValue();
                if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/人员的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim().trim())) {//人员符合情况实得分
                    entity_jl.setStaff_compliance_score(cj.getSdfs());
                    entity_jl.setStaff_compliance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业健康的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井下作业健康实得分
                    entity_jl.setHealthy_score(cj.getSdfs());
                    entity_jl.setHealthy_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/设备设施的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim())) {//设备设施本质安全性能实得分
                    entity_jl.setSafety_performance_score(cj.getSdfs());
                    entity_jl.setSafety_performance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/设备设施安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×49项))".trim().equals(cj.getPgyjjbz().trim())) {//设备设施安全实得分
                    entity_jl.setSafety_score(cj.getSdfs());
                    entity_jl.setSafety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/用电安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×9项))".trim().equals(cj.getPgyjjbz().trim())) {//用电安全实得分
                    entity_jl.setElectrical_safety_score(cj.getSdfs());
                    entity_jl.setElectrical_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/消防安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×11项))".trim().equals(cj.getPgyjjbz().trim())) {//消防安全实得分
                    entity_jl.setFire_safety_score(cj.getSdfs());
                    entity_jl.setFire_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/施工安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×20项))".trim().equals(cj.getPgyjjbz().trim())) {//施工安全实得分
                    entity_jl.setConstruction_safety_score(cj.getSdfs());
                    entity_jl.setConstruction_safety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业质量管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×16项))".trim().equals(cj.getPgyjjbz().trim())) {//施工质量实得分
                    entity_jl.setConstruction_quality_score(cj.getSdfs());
                    entity_jl.setConstruction_quality_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业井控管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井控管理实得分
                    entity_jl.setWell_control_score(cj.getSdfs());
                    entity_jl.setWell_control_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业环保的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×12项))".trim().equals(cj.getPgyjjbz().trim())) {//环保管理1实得分
                    entity_jl.setEnvironmentalprotection_score1(cj.getSdfs());
                    entity_jl.setEnvironmentalprotection_remar1(cj.getBz());
                }
            }
        }
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_sgzj = service.jxpg_zyd_one_select4(entity);
        String sgzjpjzq;
        String construction_summary_remarks;//施工总结平均上传周期备注
        if (list_sgzj != null && list_sgzj.size() > 0 && list_sgzj.get(0) != null) {
            String sgzj = list_sgzj.get(0).getSgzj_pj();
            construction_summary_remarks = list_sgzj.get(0).getSgzj_pj_bz();
            int sgzj_pj = this.xzz(sgzj);

            if (sgzj_pj <= 7) {
                sgzjpjzq = "6.00";
            } else if (7 < sgzj_pj && sgzj_pj <= 8) {
                sgzjpjzq = "5.00";
            } else if (8 < sgzj_pj && sgzj_pj <= 9) {
                sgzjpjzq = "4.00";
            } else if (9 < sgzj_pj && sgzj_pj <= 10) {
                sgzjpjzq = "3.00";
            } else {
                sgzjpjzq = "0";
            }
        } else {
            construction_summary_remarks = "";
            sgzjpjzq = "0";
        }
        entity_jl.setConstruction_summary_score(sgzjpjzq);
        entity_jl.setConstruction_summary_remarks(construction_summary_remarks);
        BigDecimal b1 = new BigDecimal(zfs);
        BigDecimal b2 = new BigDecimal(Double.parseDouble(sgzjpjzq));
        zfs = b1.add(b2).doubleValue();
        //平均交井周期
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_jjj = service.jxpg_zyd_one_select5(entity);

        String jjpj;
        String cross_well_remarks;//施工总结平均上传周期备注
        if (list_jjj != null && list_jjj.size() > 0 && list_jjj.get(0) != null) {
            String dd = list_jjj.get(0).getJj_pj();
            cross_well_remarks = list_jjj.get(0).getJj_pj_bz();
            int ss = this.xzz(dd);
            if (ss <= 7) {
                jjpj = "6.00";
            } else if (7 < ss && ss <= 8) {
                jjpj = "5.00";
            } else if (8 < ss && ss <= 9) {
                jjpj = "4.00";
            } else if (9 < ss && ss <= 10) {
                jjpj = "3.00";
            } else {
                jjpj = "0";
            }
        } else {
            cross_well_remarks = "";
            jjpj = "0";
        }
        entity_jl.setCross_well_score(jjpj);
        entity_jl.setCross_well_remarks(cross_well_remarks);
        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(Double.parseDouble(jjpj));
        zfs = b1.add(b2).doubleValue();
        DecimalFormat df = new DecimalFormat("######.00");

        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(20.00);
        double zfs_qb = b1.add(b2).doubleValue();//汇总后的总得分（包含HSE承诺书5.00，防砂布铺设5.00和质量评价10.00，共计20分）
        entity_jl.setZfs(df.format(zfs_qb));
        String evaluation_conclusion = "";
        if (zfs_qb >= 90) {
            evaluation_conclusion = "优秀";
        } else if (zfs_qb >= 70 && zfs_qb < 90) {
            evaluation_conclusion = "合格";
        } else if (zfs_qb >= 60 && zfs_qb < 70) {
            evaluation_conclusion = "观察使用";
        } else if (zfs_qb < 60) {
            evaluation_conclusion = "不合格";
        }
        entity_jl.setEvaluation_conclusion(evaluation_conclusion);

        Map map1 = new HashMap();
        map1.put("entity", entity_jl);
        map1.put("entity_Htdw_list", entity_Htdw_list);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map1);
        return resultMap;
    }

    @PostMapping("/jxpg_new")
    @ApiOperation(value = "绩效评估",notes = "施工总结表保存每口井对应的合同id，根据选择的合同id管理查询总结表井号，解决一个作业队绑定多个合同时，井号拆分不开的问题")
    public Map jxpg_new( String shuzu) {
        Map resultMap = new HashMap();
        Jxpg_Ht_DwEntity entity= new Jxpg_Ht_DwEntity();
        JSONArray jsonArray = JSONArray.fromObject(shuzu);
        Collection<Jxpg_Ht_DwEntity> con = JSONArray.toCollection(jsonArray, Jxpg_Ht_DwEntity.class);
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        for (Jxpg_Ht_DwEntity en : con) {
            sb.append("'" + en.getContract_id() + "',");
        }
        String sql = sb.toString().substring(0, sb.length() - 1) + ")";
        entity.setWhc(sql);
        List<Jxpg_Ht_DwEntity> list = service.jxpgTeam(entity);
        if (list.size() > 0) {
            StringBuffer sb1 = new StringBuffer();
            for (Jxpg_Ht_DwEntity ee : list) {
                sb1.append("在" + ee.getContract_name() + "中" + ee.getTeam_name() + "未查询到审核通过施工许可证；");
            }
            sb1.append("请先完善以上队伍施工许可证后在评估。");
            resultMap.put("code", 200);
            resultMap.put("msg", sb1.toString());
            resultMap.put("data", 0);
            return resultMap;
        }


        JxpgEntity entity_jl = new JxpgEntity();
        entity_jl.setJxpg_tab("2");//新绩效评估，井和合同绑定
        List<Jxpg_Ht_DwEntity> entity_Htdw_list = new ArrayList<Jxpg_Ht_DwEntity>();
        entity_jl.setYear(entity.getOperation_start_dates());

//		//拼接绩效评估ID
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
        String date = sdf.format(new Date());
        int num = (int) (Math.random() * 900 + 100);
        String jxpg_id = "JXPG" + date + num; //合同ID
        entity_jl.setJxpgid(jxpg_id);

        //查询合同、队伍信息
        entity_Htdw_list = service.jxpg_newSelect1(entity);
        Map<String, Object> workload_ht_map = new HashMap<String, Object>();
        Map<String, Object> money_ht_map = new HashMap<String, Object>();
        Set<String> set = new TreeSet<String>();

        int workload_ht = 0;//合同合计工作量（井次）
        double money_ht = 0;//合同合计金额（万元）
        int workload_dw = 0;//队伍合计工作量（井次）
        for (Jxpg_Ht_DwEntity jx : entity_Htdw_list) {

            //合同总工作量
            if (workload_ht_map.get(jx.getContract_number()) == null) {
                workload_ht = workload_ht + jx.getWorkload_ht();
                workload_ht_map.put(jx.getContract_number(), jx);
            }
            //合同总金额
            if (money_ht_map.get(jx.getContract_number()) == null) {

                BigDecimal b1 = new BigDecimal(money_ht);
                BigDecimal b2 = new BigDecimal(jx.getMoney_ht());
                BigDecimal b3 = b1.add(b2);//小数相加
                money_ht = b3.doubleValue();
                money_ht_map.put(jx.getContract_number(), jx);
            }

            //队伍合计工作量
//			workload_dw=workload_dw+jx.getWorkload_dw();
            //承包商名称
            entity_jl.setContractor_name(jx.getContractor_name());
            entity_jl.setContractor_id(jx.getContractor_id());
            entity_jl.setUnit_name(jx.getUnit_name());
            //合同施工项目
            String[] ss = jx.getConstruction_project().split(",");
            for (String s : ss) {
                set.add(s);
            }
        }
        DecimalFormat df1 = new DecimalFormat("######0.0000");
        //查询累计工作量
        workload_dw = service.jxpg_newSelect6(entity);

        entity_jl.setWorkload_ht(workload_ht); //合同合计工作量
        entity_jl.setMoney_ht(df1.format(money_ht));//合同合计金额
        entity_jl.setWorkload_dw(workload_dw);//队伍累计工作量

        //拼接合同施工项目
        StringBuffer sb1 = new StringBuffer();
        for (String dd : set) {
            sb1.append(dd + ",");
        }
        String a = sb1.toString();
        if (StringUtils.isNoneBlank(a)) {
            entity_jl.setConstruction_project(a.substring(0, a.length() - 1));
        }
        //---------------------------------------------------开始计算评估分数
        //评估总分数
        double zfs = 0.0;

        //查询合同中是否有未上传HSE承诺书的，若存在没有承诺书合同，评估表中HSE承诺履行列得0，都有得5.00分
        List<Jxpg_Ht_DwEntity> list_HSE = service.jxpg_newSelect2(entity);
        if (list_HSE != null && list_HSE.size() > 0) {
            entity_jl.setHse_score("0");
        } else {
            entity_jl.setHse_score("5.00");
            BigDecimal b1 = new BigDecimal(zfs);
            BigDecimal b2 = new BigDecimal(5.00);
            zfs = b1.add(b2).doubleValue();
        }

        //依据“评估依据及标准”查询检查问题项数，在根据算法计算得分
        CbsFj6Entity entity_fj6 = new CbsFj6Entity();
        entity_fj6.setWhc(sql);

        List<CbsFj6Entity> list_fj6 = service.jxpg_newSelect3(entity_fj6);
        Map<String, Double> map = new HashMap<String, Double>();
        for (CbsFj6Entity cj : list_fj6) {

            if (!map.containsKey(cj.getPgyjjbz().trim())) {

                map.put(cj.getPgyjjbz().trim(), cj.getSdf());
                BigDecimal b1 = new BigDecimal(zfs);
                BigDecimal b2 = new BigDecimal(cj.getSdf());
                zfs = b1.add(b2).doubleValue();
                if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/人员的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim().trim())) {//人员符合情况实得分
                    entity_jl.setStaff_compliance_score(cj.getSdfs());
                    entity_jl.setStaff_compliance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业健康的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井下作业健康实得分
                    entity_jl.setHealthy_score(cj.getSdfs());
                    entity_jl.setHealthy_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/开工验收/队伍资质/设备设施的对应检查结果实得分=标准分×(1-检查问题对应项数÷完成工作量)".trim().equals(cj.getPgyjjbz().trim())) {//设备设施本质安全性能实得分
                    entity_jl.setSafety_performance_score(cj.getSdfs());
                    entity_jl.setSafety_performance_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/设备设施安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×49项))".trim().equals(cj.getPgyjjbz().trim())) {//设备设施安全实得分
                    entity_jl.setSafety_score(cj.getSdfs());
                    entity_jl.setSafety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/用电安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×9项))".trim().equals(cj.getPgyjjbz().trim())) {//用电安全实得分
                    entity_jl.setElectrical_safety_score(cj.getSdfs());
                    entity_jl.setElectrical_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/消防安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×11项))".trim().equals(cj.getPgyjjbz().trim())) {//消防安全实得分
                    entity_jl.setFire_safety_score(cj.getSdfs());
                    entity_jl.setFire_safety_remarks(cj.getBz());
                } else if ("附件5：井下作业承包商施工过程监督检查表/井下作业HSE管理/井下作业安全/施工安全的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×20项))".trim().equals(cj.getPgyjjbz().trim())) {//施工安全实得分
                    entity_jl.setConstruction_safety_score(cj.getSdfs());
                    entity_jl.setConstruction_safety_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业质量管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×16项))".trim().equals(cj.getPgyjjbz().trim())) {//施工质量实得分
                    entity_jl.setConstruction_quality_score(cj.getSdfs());
                    entity_jl.setConstruction_quality_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业井控管理的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×14项))".trim().equals(cj.getPgyjjbz().trim())) {//井控管理实得分
                    entity_jl.setWell_control_score(cj.getSdfs());
                    entity_jl.setWell_control_remarks(cj.getBz());
                } else if ("依据附件5：井下作业承包商施工过程监督检查表/井下作业环保的对应检查结果实得分=标准分×(1-检查问题对应项数÷(完成工作量×12项))".trim().equals(cj.getPgyjjbz().trim())) {//环保管理1实得分
                    entity_jl.setEnvironmentalprotection_score1(cj.getSdfs());
                    entity_jl.setEnvironmentalprotection_remar1(cj.getBz());
                }
            }
        }
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_sgzj = service.jxpg_newSelect4(entity);
        String sgzjpjzq;
        String construction_summary_remarks;//施工总结平均上传周期备注
        if (list_sgzj != null && list_sgzj.size() > 0 && list_sgzj.get(0) != null) {
            String sgzj = list_sgzj.get(0).getSgzj_pj();
            construction_summary_remarks = list_sgzj.get(0).getSgzj_pj_bz();
            int sgzj_pj = this.xzz(sgzj);

            if (sgzj_pj <= 7) {
                sgzjpjzq = "6.00";
            } else if (7 < sgzj_pj && sgzj_pj <= 8) {
                sgzjpjzq = "5.00";
            } else if (8 < sgzj_pj && sgzj_pj <= 9) {
                sgzjpjzq = "4.00";
            } else if (9 < sgzj_pj && sgzj_pj <= 10) {
                sgzjpjzq = "3.00";
            } else {
                sgzjpjzq = "0";
            }
        } else {
            construction_summary_remarks = "";
            sgzjpjzq = "0";
        }
        entity_jl.setConstruction_summary_score(sgzjpjzq);
        entity_jl.setConstruction_summary_remarks(construction_summary_remarks);
        BigDecimal b1 = new BigDecimal(zfs);
        BigDecimal b2 = new BigDecimal(Double.parseDouble(sgzjpjzq));
        zfs = b1.add(b2).doubleValue();

        //平均交井周期
        //计算施工总结平均上传周期
        List<Jxpg_Ht_DwEntity> list_jjj = service.jxpg_newSelect5(entity);

        String jjpj;
        String cross_well_remarks;//施工总结平均上传周期备注
        if (list_jjj != null && list_jjj.size() > 0 && list_jjj.get(0) != null) {
            String dd = list_jjj.get(0).getJj_pj();
            cross_well_remarks = list_jjj.get(0).getJj_pj_bz();
            int ss = this.xzz(dd);
            if (ss <= 7) {
                jjpj = "6.00";
            } else if (7 < ss && ss <= 8) {
                jjpj = "5.00";
            } else if (8 < ss && ss <= 9) {
                jjpj = "4.00";
            } else if (9 < ss && ss <= 10) {
                jjpj = "3.00";
            } else {
                jjpj = "0";
            }
        } else {
            cross_well_remarks = "";
            jjpj = "0";
        }
        entity_jl.setCross_well_score(jjpj);
        entity_jl.setCross_well_remarks(cross_well_remarks);

        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(Double.parseDouble(jjpj));
        zfs = b1.add(b2).doubleValue();
        DecimalFormat df = new DecimalFormat("######.00");
        entity_jl.setZfs(df.format(zfs));


        b1 = new BigDecimal(zfs);
        b2 = new BigDecimal(15.00);
        double zfs_qb = b1.add(b2).doubleValue();//汇总后的总得分（包含防砂布铺设5.00和质量评价10.00，共计15分）
        entity_jl.setZfs_qb(df.format(zfs_qb));

        Map map1 = new HashMap();
        map1.put("entity", entity_jl);
        map1.put("entity_Htdw_list", entity_Htdw_list);

        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map1);
        return resultMap;
    }
}
