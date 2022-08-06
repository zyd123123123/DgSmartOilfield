package com.sydx.aqsc.entity.Security;
import com.sydx.aqsc.entity.Admin.BaseEntity;
import java.util.List;
public class CompleteReportEntity extends BaseEntity {

    private String construction_id;//施工总结id
    private  String well_common_name;//井号
    private  String well_purpose;//井型
    private  String cydid;//采油队id
    private  String is_under_pressure;//是否带压
    private  String design_num;//设计串号
    private String design_imei;
    private String has_sgsj;//井下授权有无施工设计(0:未授权,1：授权可以无施工设计)
    private  String sprq;//工程设计审批日期
    private  String sjid;//施工设计ID
    private  String start_time;//开工日期
    private  String complete_time;//完工日期
    private  String ssdwdm;//生产单位代码
    private  String well_id;//井id
    private  String op_team;//作业队id
    private  String sgdwmc;//作业队名称
    private  String csdl;//措施大类
    private  String csxl;//措施小类
    private  String cslb;//措施类别
    private  String cssil;//措施四类id
    private  String csdl_mc;//措施大类名称
    private  String csxl_mc;//措施小类名称
    private  String cslb_mc;//措施类别名称
    private  String cssil_mc;//措施四类名称
    private  String types_classified;
    private  String jbdm;//井别代码
    private  String sfdy;//是否带压
    private  String ccfs;//采出方式
    private  String ccfsmc;//采出方式名称
    private String qdfsdm;//驱动方式代码
    private String qdfs;//驱动方式
    private String scdw;//生产单位
    private  String reason;//井型
    //大修工艺分类参数开始
    private  String stim_i_caiegory;//大修1类
    private  String stim_ii_caiegory;//大修2类
    private  String stim_iii_caiegory;//大修3类
    private  String stim_key_id;//大修id
    private  String measure_fourth;//大修四类
    private  String measure_fourth_id;//大修四类id
    private  String pump_diameter;//泵的类型
    private  String pump_specification;//泵规范
    private  String stim_i_appraise_code;//鉴定结果1id
    private  String stim_ii_appraise_code;//鉴定结果2id
    private  String stim_iii_appraise_code;//鉴定结果3id
    private  String stim_iiii_appraise_code;//鉴定结果4id
    private  String stim_i_appraise;//鉴定结果1
    private  String stim_ii_appraise;//鉴定结果2
    private  String stim_iii_appraise;//鉴定结果3
    private  String stim_iiii_appraise;//鉴定结果4
    private  String construction_fracturing;//施工最高压力（MPa）
    private  String beforemeasure_pre;//措施前压力
    private  String aftermeasure_pre;//措施后压力
    private  String liquid_measure;//液量
    private  String max_displacement;//最大排量
    private  String min_displacement;//最小排量
    private  String fractur_ave_sand_ratio;//平均砂比(%)
    private  String ylzclx;//支撑类型
    private  String ylytx;//压裂液体系
    private  String team_id_yl;//压裂队伍编号



    private  String layercount;//层段数
    private  String total_sand;//总砂量(m<sup>3</sup>)
    private  String sandthinck;//砂岩厚度(m)
    private  String validthinck;//有效厚度
    //大修工艺分类参数开结束
    //酸化参数开始
    private  int xh;//序号
    private int cwid;//层位id
    private  String acidification_horizon;//酸化层数
    private  String acid_content;//酸量（m3）
    private  String acid_displacement;//排量（m3/min）
    private  String acid_sink;//入地酸量(m3)
    private  String acid_intake;//入地液量(m3);
    private  String sylx;//酸液类型;
    private  String sytx;//酸液体系
    private  String team_id_sh;//酸化队伍编号

    //酸化参数结束
    private  String stim_key_id_check;//措施id-核对后作业类型
    private  String csid;//措施id
    private  String cssilid;//措施四类id
    private  String no_construction;//未施工标识;1为未施工
    private  String main_measure;//主措施标志；1为主措施;0为辅措施;空为未维护
    private  String dxpd1;//大修判断，是否有大修
    private  String shpd1;//酸化判断
    private  String shyl1;//是否压裂
    private  String jbpd1;//井别判断
    private  String sfdy1;//是否带压
    private  String username;//
    private  String unitid;//
    private  String unitname;
    private String reportflag_daily;
    private  String reportflag;
    private  String reportflag_name;
    private String node_name;
    private  String sfdgmyl;
    private  String largefract;
    private  String pumpcheck;
    private  String unitflag;
    private  String pump_cation;
    private  String construction_reason;
    private String input_date;
    private List<CompleteReportEntity> entityList1;
    private List<CompleteReportEntity> entityList2;
    private List<CompleteReportEntity> entityList3;

    //连续油管参数
    private  String coiled_tub;//是否连续油管
    private  String sfdgz;//是否动管柱
    private  String lxyg_gylx;//工艺类型
    private  String team_id_lxyg;//连续油管队伍编号
    private  String lxyg_maxpressure;//最高压力
    private  String lxyg_depth;//作业深度
    //清洁化作业参数
    private  String cleaning_operation;//是否清洁作业
    private  String qjzy_fl;//清洁作业分类
    private  String jsgfl_wt;//减少固废量——污土、污泥
    private  String jsgfl_fsb;//减少固废量——一次性防渗布
    private  String jsfy;//减少废液拉运(吨)


    public String getConstruction_id() {
        return construction_id;
    }

    public void setConstruction_id(String construction_id) {
        this.construction_id = construction_id;
    }

    public String getHas_sgsj() {
        return has_sgsj;
    }

    public void setHas_sgsj(String has_sgsj) {
        this.has_sgsj = has_sgsj;
    }

    public String getSprq() {
        return sprq;
    }

    public void setSprq(String sprq) {
        this.sprq = sprq;
    }

    public String getSjid() {
        return sjid;
    }

    public void setSjid(String sjid) {
        this.sjid = sjid;
    }

    public String getWell_common_name() {
        return well_common_name;
    }

    public void setWell_common_name(String well_common_name) {
        this.well_common_name = well_common_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(String complete_time) {
        this.complete_time = complete_time;
    }

    public String getCsdl() {
        return csdl;
    }

    public void setCsdl(String csdl) {
        this.csdl = csdl;
    }

    public String getCsxl() {
        return csxl;
    }

    public void setCsxl(String csxl) {
        this.csxl = csxl;
    }

    public String getCslb() {
        return cslb;
    }

    public void setCslb(String cslb) {
        this.cslb = cslb;
    }

    public String getJbdm() {
        return jbdm;
    }

    public void setJbdm(String jbdm) {
        this.jbdm = jbdm;
    }

    public String getSfdy() {
        return sfdy;
    }

    public void setSfdy(String sfdy) {
        this.sfdy = sfdy;
    }

    public String getCcfs() {
        return ccfs;
    }

    public void setCcfs(String ccfs) {
        this.ccfs = ccfs;
    }

    public String getStim_key_id() {
        return stim_key_id;
    }

    public void setStim_key_id(String stim_key_id) {
        this.stim_key_id = stim_key_id;
    }

    public String getPump_diameter() {
        return pump_diameter;
    }

    public void setPump_diameter(String pump_diameter) {
        this.pump_diameter = pump_diameter;
    }

    public String getPump_specification() {
        return pump_specification;
    }

    public void setPump_specification(String pump_specification) {
        this.pump_specification = pump_specification;
    }

    public String getStim_i_appraise_code() {
        return stim_i_appraise_code;
    }

    public void setStim_i_appraise_code(String stim_i_appraise_code) {
        this.stim_i_appraise_code = stim_i_appraise_code;
    }

    public String getStim_ii_appraise_code() {
        return stim_ii_appraise_code;
    }

    public void setStim_ii_appraise_code(String stim_ii_appraise_code) {
        this.stim_ii_appraise_code = stim_ii_appraise_code;
    }

    public String getStim_iii_appraise_code() {
        return stim_iii_appraise_code;
    }

    public void setStim_iii_appraise_code(String stim_iii_appraise_code) {
        this.stim_iii_appraise_code = stim_iii_appraise_code;
    }

    public String getStim_iiii_appraise_code() {
        return stim_iiii_appraise_code;
    }

    public void setStim_iiii_appraise_code(String stim_iiii_appraise_code) {
        this.stim_iiii_appraise_code = stim_iiii_appraise_code;
    }

    public String getConstruction_fracturing() {
        return construction_fracturing;
    }

    public void setConstruction_fracturing(String construction_fracturing) {
        this.construction_fracturing = construction_fracturing;
    }

    public String getBeforemeasure_pre() {
        return beforemeasure_pre;
    }

    public void setBeforemeasure_pre(String beforemeasure_pre) {
        this.beforemeasure_pre = beforemeasure_pre;
    }

    public String getAftermeasure_pre() {
        return aftermeasure_pre;
    }

    public void setAftermeasure_pre(String aftermeasure_pre) {
        this.aftermeasure_pre = aftermeasure_pre;
    }

    public String getLiquid_measure() {
        return liquid_measure;
    }

    public void setLiquid_measure(String liquid_measure) {
        this.liquid_measure = liquid_measure;
    }

    public String getMax_displacement() {
        return max_displacement;
    }

    public void setMax_displacement(String max_displacement) {
        this.max_displacement = max_displacement;
    }

    public String getMin_displacement() {
        return min_displacement;
    }

    public void setMin_displacement(String min_displacement) {
        this.min_displacement = min_displacement;
    }

    public String getLayercount() {
        return layercount;
    }

    public void setLayercount(String layercount) {
        this.layercount = layercount;
    }

    public String getTotal_sand() {
        return total_sand;
    }

    public void setTotal_sand(String total_sand) {
        this.total_sand = total_sand;
    }

    public String getSandthinck() {
        return sandthinck;
    }

    public void setSandthinck(String sandthinck) {
        this.sandthinck = sandthinck;
    }

    public String getValidthinck() {
        return validthinck;
    }

    public void setValidthinck(String validthinck) {
        this.validthinck = validthinck;
    }

    public String getAcidification_horizon() {
        return acidification_horizon;
    }

    public void setAcidification_horizon(String acidification_horizon) {
        this.acidification_horizon = acidification_horizon;
    }

    public String getAcid_content() {
        return acid_content;
    }

    public void setAcid_content(String acid_content) {
        this.acid_content = acid_content;
    }

    public String getAcid_displacement() {
        return acid_displacement;
    }

    public void setAcid_displacement(String acid_displacement) {
        this.acid_displacement = acid_displacement;
    }

    public String getAcid_sink() {
        return acid_sink;
    }

    public void setAcid_sink(String acid_sink) {
        this.acid_sink = acid_sink;
    }

    public String getAcid_intake() {
        return acid_intake;
    }

    public void setAcid_intake(String acid_intake) {
        this.acid_intake = acid_intake;
    }

    public String getStim_key_id_check() {
        return stim_key_id_check;
    }

    public void setStim_key_id_check(String stim_key_id_check) {
        this.stim_key_id_check = stim_key_id_check;
    }

    public String getCsid() {
        return csid;
    }

    public void setCsid(String csid) {
        this.csid = csid;
    }

    public String getCssilid() {
        return cssilid;
    }

    public void setCssilid(String cssilid) {
        this.cssilid = cssilid;
    }

    public String getNo_construction() {
        return no_construction;
    }

    public void setNo_construction(String no_construction) {
        this.no_construction = no_construction;
    }

    public String getMain_measure() {
        return main_measure;
    }

    public void setMain_measure(String main_measure) {
        this.main_measure = main_measure;
    }

    public String getDxpd1() {
        return dxpd1;
    }

    public void setDxpd1(String dxpd1) {
        this.dxpd1 = dxpd1;
    }

    public String getShpd1() {
        return shpd1;
    }

    public void setShpd1(String shpd1) {
        this.shpd1 = shpd1;
    }

    public String getShyl1() {
        return shyl1;
    }

    public void setShyl1(String shyl1) {
        this.shyl1 = shyl1;
    }

    public String getJbpd1() {
        return jbpd1;
    }

    public void setJbpd1(String jbpd1) {
        this.jbpd1 = jbpd1;
    }

    public String getSfdy1() {
        return sfdy1;
    }

    public void setSfdy1(String sfdy1) {
        this.sfdy1 = sfdy1;
    }

    public String getCcfsmc() {
        return ccfsmc;
    }

    public void setCcfsmc(String ccfsmc) {
        this.ccfsmc = ccfsmc;
    }

    public List<CompleteReportEntity> getEntityList1() {
        return entityList1;
    }

    public void setEntityList1(List<CompleteReportEntity> entityList1) {
        this.entityList1 = entityList1;
    }

    public List<CompleteReportEntity> getEntityList2() {
        return entityList2;
    }

    public void setEntityList2(List<CompleteReportEntity> entityList2) {
        this.entityList2 = entityList2;
    }

    public List<CompleteReportEntity> getEntityList3() {
        return entityList3;
    }

    public void setEntityList3(List<CompleteReportEntity> entityList3) {
        this.entityList3 = entityList3;
    }

    public String getCssil() {
        return cssil;
    }

    public void setCssil(String cssil) {
        this.cssil = cssil;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getSsdwdm() {
        return ssdwdm;
    }

    public void setSsdwdm(String ssdwdm) {
        this.ssdwdm = ssdwdm;
    }

    public String getWell_id() {
        return well_id;
    }

    public void setWell_id(String well_id) {
        this.well_id = well_id;
    }

    public String getOp_team() {
        return op_team;
    }

    public void setOp_team(String op_team) {
        this.op_team = op_team;
    }

    public String getSgdwmc() {
        return sgdwmc;
    }

    public void setSgdwmc(String sgdwmc) {
        this.sgdwmc = sgdwmc;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getStim_i_caiegory() {
        return stim_i_caiegory;
    }

    public void setStim_i_caiegory(String stim_i_caiegory) {
        this.stim_i_caiegory = stim_i_caiegory;
    }

    public String getStim_ii_caiegory() {
        return stim_ii_caiegory;
    }

    public void setStim_ii_caiegory(String stim_ii_caiegory) {
        this.stim_ii_caiegory = stim_ii_caiegory;
    }

    public String getStim_iii_caiegory() {
        return stim_iii_caiegory;
    }

    public void setStim_iii_caiegory(String stim_iii_caiegory) {
        this.stim_iii_caiegory = stim_iii_caiegory;
    }

    public int getCwid() {
        return cwid;
    }

    public void setCwid(int cwid) {
        this.cwid = cwid;
    }

    public String getMeasure_fourth() {
        return measure_fourth;
    }

    public void setMeasure_fourth(String measure_fourth) {
        this.measure_fourth = measure_fourth;
    }

    public String getMeasure_fourth_id() {
        return measure_fourth_id;
    }

    public void setMeasure_fourth_id(String measure_fourth_id) {
        this.measure_fourth_id = measure_fourth_id;
    }

    public String getStim_i_appraise() {
        return stim_i_appraise;
    }

    public void setStim_i_appraise(String stim_i_appraise) {
        this.stim_i_appraise = stim_i_appraise;
    }

    public String getStim_ii_appraise() {
        return stim_ii_appraise;
    }

    public void setStim_ii_appraise(String stim_ii_appraise) {
        this.stim_ii_appraise = stim_ii_appraise;
    }

    public String getStim_iii_appraise() {
        return stim_iii_appraise;
    }

    public void setStim_iii_appraise(String stim_iii_appraise) {
        this.stim_iii_appraise = stim_iii_appraise;
    }

    public String getStim_iiii_appraise() {
        return stim_iiii_appraise;
    }

    public void setStim_iiii_appraise(String stim_iiii_appraise) {
        this.stim_iiii_appraise = stim_iiii_appraise;
    }

    public String getWell_purpose() {
        return well_purpose;
    }

    public void setWell_purpose(String well_purpose) {
        this.well_purpose = well_purpose;
    }

    public String getCydid() {
        return cydid;
    }

    public void setCydid(String cydid) {
        this.cydid = cydid;
    }

    public String getIs_under_pressure() {
        return is_under_pressure;
    }

    public void setIs_under_pressure(String is_under_pressure) {
        this.is_under_pressure = is_under_pressure;
    }

    public String getDesign_num() {
        return design_num;
    }

    public void setDesign_num(String design_num) {
        this.design_num = design_num;
    }

    public String getCsdl_mc() {
        return csdl_mc;
    }

    public void setCsdl_mc(String csdl_mc) {
        this.csdl_mc = csdl_mc;
    }

    public String getCsxl_mc() {
        return csxl_mc;
    }

    public void setCsxl_mc(String csxl_mc) {
        this.csxl_mc = csxl_mc;
    }

    public String getCslb_mc() {
        return cslb_mc;
    }

    public void setCslb_mc(String cslb_mc) {
        this.cslb_mc = cslb_mc;
    }

    public String getCssil_mc() {
        return cssil_mc;
    }

    public void setCssil_mc(String cssil_mc) {
        this.cssil_mc = cssil_mc;
    }

    public String getQdfsdm() {
        return qdfsdm;
    }

    public void setQdfsdm(String qdfsdm) {
        this.qdfsdm = qdfsdm;
    }

    public String getQdfs() {
        return qdfs;
    }

    public void setQdfs(String qdfs) {
        this.qdfs = qdfs;
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) {
        this.scdw = scdw;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getDesign_imei() {
        return design_imei;
    }

    public void setDesign_imei(String design_imei) {
        this.design_imei = design_imei;
    }

    public String getTypes_classified() {
        return types_classified;
    }

    public void setTypes_classified(String types_classified) {
        this.types_classified = types_classified;
    }

    public String getReportflag_daily() {
        return reportflag_daily;
    }

    public void setReportflag_daily(String reportflag_daily) {
        this.reportflag_daily = reportflag_daily;
    }

    public String getReportflag() {
        return reportflag;
    }

    public void setReportflag(String reportflag) {
        this.reportflag = reportflag;
    }

    public String getReportflag_name() {
        return reportflag_name;
    }

    public void setReportflag_name(String reportflag_name) {
        this.reportflag_name = reportflag_name;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getSfdgmyl() {
        return sfdgmyl;
    }

    public void setSfdgmyl(String sfdgmyl) {
        this.sfdgmyl = sfdgmyl;
    }

    public String getLargefract() {
        return largefract;
    }

    public void setLargefract(String largefract) {
        this.largefract = largefract;
    }

    public String getPumpcheck() {
        return pumpcheck;
    }

    public void setPumpcheck(String pumpcheck) {
        this.pumpcheck = pumpcheck;
    }

    public String getUnitflag() {
        return unitflag;
    }

    public void setUnitflag(String unitflag) {
        this.unitflag = unitflag;
    }

    public String getPump_cation() {
        return pump_cation;
    }

    public void setPump_cation(String pump_cation) {
        this.pump_cation = pump_cation;
    }

    public String getConstruction_reason() {
        return construction_reason;
    }

    public void setConstruction_reason(String construction_reason) {
        this.construction_reason = construction_reason;
    }

    public String getInput_date() {
        return input_date;
    }

    public void setInput_date(String input_date) {
        this.input_date = input_date;
    }

    public String getFractur_ave_sand_ratio() {
        return fractur_ave_sand_ratio;
    }

    public void setFractur_ave_sand_ratio(String fractur_ave_sand_ratio) {
        this.fractur_ave_sand_ratio = fractur_ave_sand_ratio;
    }

    public String getYlzclx() {
        return ylzclx;
    }

    public void setYlzclx(String ylzclx) {
        this.ylzclx = ylzclx;
    }

    public String getYlytx() {
        return ylytx;
    }

    public void setYlytx(String ylytx) {
        this.ylytx = ylytx;
    }

    public String getTeam_id_yl() {
        return team_id_yl;
    }

    public void setTeam_id_yl(String team_id_yl) {
        this.team_id_yl = team_id_yl;
    }

    public String getSylx() {
        return sylx;
    }

    public void setSylx(String sylx) {
        this.sylx = sylx;
    }

    public String getSytx() {
        return sytx;
    }

    public void setSytx(String sytx) {
        this.sytx = sytx;
    }

    public String getTeam_id_sh() {
        return team_id_sh;
    }

    public void setTeam_id_sh(String team_id_sh) {
        this.team_id_sh = team_id_sh;
    }

    public String getCoiled_tub() {
        return coiled_tub;
    }

    public void setCoiled_tub(String coiled_tub) {
        this.coiled_tub = coiled_tub;
    }

    public String getSfdgz() {
        return sfdgz;
    }

    public void setSfdgz(String sfdgz) {
        this.sfdgz = sfdgz;
    }

    public String getLxyg_gylx() {
        return lxyg_gylx;
    }

    public void setLxyg_gylx(String lxyg_gylx) {
        this.lxyg_gylx = lxyg_gylx;
    }

    public String getTeam_id_lxyg() {
        return team_id_lxyg;
    }

    public void setTeam_id_lxyg(String team_id_lxyg) {
        this.team_id_lxyg = team_id_lxyg;
    }

    public String getCleaning_operation() {
        return cleaning_operation;
    }

    public void setCleaning_operation(String cleaning_operation) {
        this.cleaning_operation = cleaning_operation;
    }

    public String getQjzy_fl() {
        return qjzy_fl;
    }

    public void setQjzy_fl(String qjzy_fl) {
        this.qjzy_fl = qjzy_fl;
    }

    public String getJsgfl_wt() {
        return jsgfl_wt;
    }

    public void setJsgfl_wt(String jsgfl_wt) {
        this.jsgfl_wt = jsgfl_wt;
    }

    public String getJsgfl_fsb() {
        return jsgfl_fsb;
    }

    public void setJsgfl_fsb(String jsgfl_fsb) {
        this.jsgfl_fsb = jsgfl_fsb;
    }

    public String getJsfy() {
        return jsfy;
    }

    public void setJsfy(String jsfy) {
        this.jsfy = jsfy;
    }

    public String getLxyg_maxpressure() {
        return lxyg_maxpressure;
    }

    public void setLxyg_maxpressure(String lxyg_maxpressure) {
        this.lxyg_maxpressure = lxyg_maxpressure;
    }

    public String getLxyg_depth() {
        return lxyg_depth;
    }

    public void setLxyg_depth(String lxyg_depth) {
        this.lxyg_depth = lxyg_depth;
    }
}
