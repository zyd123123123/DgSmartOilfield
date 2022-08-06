package com.sydx.aqsc.entity.Security;
import com.sydx.aqsc.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel(value = "施工单元")
public class SgdyEntity extends BaseEntity {
    @ApiModelProperty(value="序号")
    private int xh; //序号
    @ApiModelProperty(value="工序id")
    private Integer spid; //工序id
    @ApiModelProperty(value="施工步骤定制时施工工序编号")
    private Integer pdid;//施工步骤定制时施工工序编号
    @ApiModelProperty(value="工序上报编号")
    private Integer spno;//工序上报编号
    @ApiModelProperty(value="工序名称")
    private String spname; //工序名称
    @ApiModelProperty(value="对照工序")
    private String circuit_id; //对照工序
    @ApiModelProperty(value="对照工序名称")
    private String circuit_name; //对照工序名称
    @ApiModelProperty(value="对照工序名称")
    private String circuit_table; //对照工序名称
    @ApiModelProperty(value="施工单元名称")
    private String sgdymc; //施工单元名称
    @ApiModelProperty(value="施工单元标识")
    private String aothname; //施工单元标识
    @ApiModelProperty(value="措施大类名称")
    private String stim_key_id; //措施大类名称
    @ApiModelProperty(value="施工单元名称")
    private String sgdyid; //施工单元名称
    @ApiModelProperty(value="工序施工单元编号")
    private Integer sgdyno; //工序施工单元编号
    @ApiModelProperty(value="施工单元类别")
    private String sgdylb; //施工单元类别
    @ApiModelProperty(value="主要设备")
    private String zysb; //主要设备
    @ApiModelProperty(value="配套设备")
    private String ptsb; // 配套设备
    @ApiModelProperty(value="人员要求")
    private String ryyq; //人员要求
    @ApiModelProperty(value="井控要求")
    private String jkyq; // 井控要求
    @ApiModelProperty(value="安全要求")
    private String aqyq; // 安全要求
    @ApiModelProperty(value="环保要求")
    private String hbyq; //环保要求
    @ApiModelProperty(value="工艺及质量要求")
    private String gyjzlyq; //工艺及质量要求
    @ApiModelProperty(value="设备要求")
    private String sbyq; //设备要求
    @ApiModelProperty(value="资料要求")
    private String zlyq; //资料要求
    @ApiModelProperty(value="变更管理")
    private String bggl; //变更管理
    @ApiModelProperty(value="甲方")
    private String jiaf; //甲方
    @ApiModelProperty(value="乙方")
    private String yif; //乙方
    @ApiModelProperty(value="丙方")
    private String bingf; //丙方
    @ApiModelProperty(value="录入人")
    private String lrr; //录入人、
    @ApiModelProperty(value="录入时间")
    private Date lrsj; //录入时间、
    @ApiModelProperty(value="录入人")
    private String lrrip; //录入人ip，
    @ApiModelProperty(value="修改人")
    private String xgr; //修改人、
    @ApiModelProperty(value="修改时间")
    private Date xgsj; //修改时间、
    @ApiModelProperty(value="油田id")
    private String ytid; //油田id
    @ApiModelProperty(value="录入时间")
    private String lrsjs; //录入时间、string形式

    @ApiModelProperty(value="井号")
    private String well_common_name;
    @ApiModelProperty(value="施工id")
    private String did;
    @ApiModelProperty(value="确认人（乙方）")
    private String qrr;//确认人（乙方）
    @ApiModelProperty(value="确认人id（乙方）")
    private String qrrid;//确认人id（乙方）
    @ApiModelProperty(value="确认时间（乙方）")
    private String qrsj;//确认时间（乙方）
    @ApiModelProperty(value="施工质量（乙方）")
    private String sgzl;//施工质量（乙方）
    @ApiModelProperty(value="备注（乙方）")
    private String bz;//备注（乙方）
    @ApiModelProperty(value="施工内容")
    private String buildcontent; // 施工内容
    @ApiModelProperty(value="施工内容模板")
    private String buildcontenttmp; // 施工内容模板
    @ApiModelProperty(value="技术要求")
    private String requirement; // 要求
    @ApiModelProperty(value="参数id")
    private String parame_val_num; //
    @ApiModelProperty(value="模板id")
    private String customid; //
    @ApiModelProperty(value="修改标识")
    private String editTab; //
    @ApiModelProperty(value="工序新增标识：0非新增，1新增行")
    private String addTab; //工序新增标识：0非新增，1新增行
    @ApiModelProperty(value="班报上报时间")
    private String report_time; //班报上报时间
    @ApiModelProperty(value="班报上报班次")
    private String order_classes; //班报上报班次
    @ApiModelProperty(value="施工模板id")
    private Integer buildcontentnum;
    private List<SgdyEntity> entityList;

    public String getAddTab() {
        return addTab;
    }

    public void setAddTab(String addTab) {
        this.addTab = addTab;
    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getPdid() {
        return pdid;
    }

    public void setPdid(Integer pdid) {
        this.pdid = pdid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getSgdymc() {
        return sgdymc;
    }

    public void setSgdymc(String sgdymc) {
        this.sgdymc = sgdymc;
    }

    public String getSgdyid() {
        return sgdyid;
    }

    public void setSgdyid(String sgdyid) {
        this.sgdyid = sgdyid;
    }

    public String getSgdylb() {
        return sgdylb;
    }

    public void setSgdylb(String sgdylb) {
        this.sgdylb = sgdylb;
    }

    public String getZysb() {
        return zysb;
    }

    public void setZysb(String zysb) {
        this.zysb = zysb;
    }

    public String getPtsb() {
        return ptsb;
    }

    public void setPtsb(String ptsb) {
        this.ptsb = ptsb;
    }

    public String getRyyq() {
        return ryyq;
    }

    public void setRyyq(String ryyq) {
        this.ryyq = ryyq;
    }

    public String getJkyq() {
        return jkyq;
    }

    public void setJkyq(String jkyq) {
        this.jkyq = jkyq;
    }

    public String getAqyq() {
        return aqyq;
    }

    public void setAqyq(String aqyq) {
        this.aqyq = aqyq;
    }

    public String getHbyq() {
        return hbyq;
    }

    public void setHbyq(String hbyq) {
        this.hbyq = hbyq;
    }

    public String getGyjzlyq() {
        return gyjzlyq;
    }

    public void setGyjzlyq(String gyjzlyq) {
        this.gyjzlyq = gyjzlyq;
    }

    public String getSbyq() {
        return sbyq;
    }

    public void setSbyq(String sbyq) {
        this.sbyq = sbyq;
    }

    public String getZlyq() {
        return zlyq;
    }

    public void setZlyq(String zlyq) {
        this.zlyq = zlyq;
    }

    public String getBggl() {
        return bggl;
    }

    public void setBggl(String bggl) {
        this.bggl = bggl;
    }

    public String getJiaf() {
        return jiaf;
    }

    public void setJiaf(String jiaf) {
        this.jiaf = jiaf;
    }

    public String getYif() {
        return yif;
    }

    public void setYif(String yif) {
        this.yif = yif;
    }

    public String getBingf() {
        return bingf;
    }

    public void setBingf(String bingf) {
        this.bingf = bingf;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getLrrip() {
        return lrrip;
    }

    public void setLrrip(String lrrip) {
        this.lrrip = lrrip;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public String getYtid() {
        return ytid;
    }

    public void setYtid(String ytid) {
        this.ytid = ytid;
    }

    public String getLrsjs() {
        return lrsjs;
    }

    public void setLrsjs(String lrsjs) {
        this.lrsjs = lrsjs;
    }

    public List<SgdyEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<SgdyEntity> entityList) {
        this.entityList = entityList;
    }

    public String getWell_common_name() {
        return well_common_name;
    }

    public void setWell_common_name(String well_common_name) {
        this.well_common_name = well_common_name;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getQrr() {
        return qrr;
    }

    public void setQrr(String qrr) {
        this.qrr = qrr;
    }

    public String getQrrid() {
        return qrrid;
    }

    public void setQrrid(String qrrid) {
        this.qrrid = qrrid;
    }

    public String getQrsj() {
        return qrsj;
    }

    public void setQrsj(String qrsj) {
        this.qrsj = qrsj;
    }

    public String getSgzl() {
        return sgzl;
    }

    public void setSgzl(String sgzl) {
        this.sgzl = sgzl;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getAothname() {
        return aothname;
    }

    public void setAothname(String aothname) {
        this.aothname = aothname;
    }

    public String getCircuit_id() {
        return circuit_id;
    }

    public void setCircuit_id(String circuit_id) {
        this.circuit_id = circuit_id;
    }

    public String getCircuit_name() {
        return circuit_name;
    }

    public void setCircuit_name(String circuit_name) {
        this.circuit_name = circuit_name;
    }

    public String getStim_key_id() {
        return stim_key_id;
    }

    public void setStim_key_id(String stim_key_id) {
        this.stim_key_id = stim_key_id;
    }

    public String getBuildcontent() {
        return buildcontent;
    }

    public void setBuildcontent(String buildcontent) {
        this.buildcontent = buildcontent;
    }

    public String getBuildcontenttmp() {
        return buildcontenttmp;
    }

    public void setBuildcontenttmp(String buildcontenttmp) {
        this.buildcontenttmp = buildcontenttmp;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Integer getSgdyno() {
        return sgdyno;
    }

    public void setSgdyno(Integer sgdyno) {
        this.sgdyno = sgdyno;
    }

    public String getCircuit_table() {
        return circuit_table;
    }

    public void setCircuit_table(String circuit_table) {
        this.circuit_table = circuit_table;
    }

    public String getParame_val_num() {
        return parame_val_num;
    }

    public String getCustomid() {
        return customid;
    }

    public void setParame_val_num(String parame_val_num) {
        this.parame_val_num = parame_val_num;
    }

    public void setCustomid(String customid) {
        this.customid = customid;
    }

    public String getEditTab() {
        return editTab;
    }

    public void setEditTab(String editTab) {
        this.editTab = editTab;
    }


    public String getReport_time() {
        return report_time;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
    }

    public String getOrder_classes() {
        return order_classes;
    }

    public void setOrder_classes(String order_classes) {
        this.order_classes = order_classes;
    }

    public Integer getSpno() {
        return spno;
    }

    public void setSpno(Integer spno) {
        this.spno = spno;
    }

    public Integer getBuildcontentnum() {
        return buildcontentnum;
    }

    public void setBuildcontentnum(Integer buildcontentnum) {
        this.buildcontentnum = buildcontentnum;
    }
}
