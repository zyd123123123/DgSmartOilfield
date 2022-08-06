package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.BaseEntity;

//施工井信息
public class WellEntity extends BaseEntity {


    private String zizj;//队伍资质
    private String op_team;//作业队id
    private String well_common_name;//井号
    private String start_time;//开工时间
    private String complete_time;//完工时间
    private String well_id;//井id
    private String design_num;//设计串号
    private String construction_id;//施工总结id
    private String ssdwdm; //
    private String zydw;//作业单位
    private String scdw;//生产单位
    private String ffsj;//分配时间
    private String construction_department;//施工单位代码
    private String cydid;//采油队id
    private  String well_purpose;//井别
    private String qdfs;//驱动方式
    private String ccfs;//采出方式
    private  String csfl;

    public String getZizj() {
        return zizj;
    }

    public void setZizj(String zizj) {
        this.zizj = zizj;
    }

    public String getOp_team() {
        return op_team;
    }

    public void setOp_team(String op_team) {
        this.op_team = op_team;
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

    public String getWell_id() {
        return well_id;
    }

    public void setWell_id(String well_id) {
        this.well_id = well_id;
    }

    public String getDesign_num() {
        return design_num;
    }

    public void setDesign_num(String design_num) {
        this.design_num = design_num;
    }

    public String getConstruction_id() {
        return construction_id;
    }

    public void setConstruction_id(String construction_id) {
        this.construction_id = construction_id;
    }

    public String getSsdwdm() {
        return ssdwdm;
    }

    public void setSsdwdm(String ssdwdm) {
        this.ssdwdm = ssdwdm;
    }

    public String getZydw() {
        return zydw;
    }

    public void setZydw(String zydw) {
        this.zydw = zydw;
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) {
        this.scdw = scdw;
    }

    public String getFfsj() {
        return ffsj;
    }

    public void setFfsj(String ffsj) {
        this.ffsj = ffsj;
    }

    public String getConstruction_department() {
        return construction_department;
    }

    public void setConstruction_department(String construction_department) {
        this.construction_department = construction_department;
    }

    public String getCydid() {
        return cydid;
    }

    public void setCydid(String cydid) {
        this.cydid = cydid;
    }

    public String getWell_purpose() {
        return well_purpose;
    }

    public void setWell_purpose(String well_purpose) {
        this.well_purpose = well_purpose;
    }

    public String getQdfs() {
        return qdfs;
    }

    public void setQdfs(String qdfs) {
        this.qdfs = qdfs;
    }

    public String getCcfs() {
        return ccfs;
    }

    public void setCcfs(String ccfs) {
        this.ccfs = ccfs;
    }

    public String getCsfl() {
        return csfl;
    }

    public void setCsfl(String csfl) {
        this.csfl = csfl;
    }
}
