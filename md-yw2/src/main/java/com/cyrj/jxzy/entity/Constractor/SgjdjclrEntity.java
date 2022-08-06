package com.cyrj.jxzy.entity.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "施工监督检查")
public class SgjdjclrEntity extends BaseEntity{
	
	private String oilfield;
	private String jcid;
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="队伍id")
	private String op_team;//队伍id
	@ApiModelProperty(value="井号")
	private String well_common_name;//井号
	@ApiModelProperty(value="井别")
	private String well_purpose;//井别
	@ApiModelProperty(value="施工项目")
	private String item_name;//施工项目
	@ApiModelProperty(value="施工单位")
	private String sgdw;//施工单位
	@ApiModelProperty(value="检查项目一类")
	private String jcxm1;//检查项目一类
	@ApiModelProperty(value="检查项目二类")
	private String jcxm2;//检查项目二类
	@ApiModelProperty(value="检查项目三类")
	private String jcxm3;//检查项目三类
	@ApiModelProperty(value="检查内容id")
	private String jcnrid;//检查内容id
	@ApiModelProperty(value="检查内容id")
	private String jcnrid1;//检查内容id
	@ApiModelProperty(value="存在问题")
	private String czwt;//存在问题
	@ApiModelProperty(value="检查人")
	private String jcr;//检查人
	@ApiModelProperty(value="检查时间")
	private String jcsj;//检查时间
	@ApiModelProperty(value="检查总结")
	private String jczj;//检查总结
	@ApiModelProperty(value="施工单位负责人_检查")
	private String sgdwfzr_jc;//施工单位负责人_检查

	@ApiModelProperty(value="整改情况")
	private String zgqk;//整改情况
	@ApiModelProperty(value="整改人")
	private String zgr;//整改人
	@ApiModelProperty(value="整改时间")
	private String zgsj;//整改时间
	@ApiModelProperty(value="整改结果")
	private String zgjg;//整改结果
	@ApiModelProperty(value="施工单位负责人_复查")
	private String sgdwfzr_zg;//施工单位负责人_复查
	@ApiModelProperty(value="复查情况")
	private String fcqk;//复查情况
	@ApiModelProperty(value="复查人")
	private String fcr;//复查人
	@ApiModelProperty(value="复查时间")
	private String fcsj;//复查时间
	@ApiModelProperty(value="复查结果")
	private String fcjg;//复查结果
	@ApiModelProperty(value="施工单位负责人_复查")
	private String sgdwfzr_fc;//施工单位负责人_复查
	@ApiModelProperty(value="设计串号")
	private String design_num;//设计串号
	@ApiModelProperty(value="施工总结ID_A5")
	private String construction_id;//施工总结ID_A5
	@ApiModelProperty(value="检查录入是否上传现场照片标志1有现场照片0没有现场照片")
	private String img_tab1;//检查录入是否上传现场照片标志1有现场照片0没有现场照片
	@ApiModelProperty(value="整改反馈是否上传现场照片标志1有现场照片0没有现场照片")
	private String img_tab2;//整改反馈是否上传现场照片标志1有现场照片0没有现场照片
	@ApiModelProperty(value="复查是否上传现场照片标志1有现场照片0没有现场照片")
	private String img_tab3;//复查是否上传现场照片标志1有现场照片0没有现场照片
	@ApiModelProperty(value="录入人")
	private String lrr;//录入人
	private String datetime;
	@ApiModelProperty(value="问题条数")
	private Integer czwtallm;//问题条数
	private Integer zgqkTotal;
	@ApiModelProperty(value="标记1监督录入2承包商整改完成3复查完成")
	private String sign;//标记1监督录入2承包商整改完成3复查完成
	private List<SgjdjclrEntity> entity_list;
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
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
	public String getWell_purpose() {
		return well_purpose;
	}
	public void setWell_purpose(String well_purpose) {
		this.well_purpose = well_purpose;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getSgdw() {
		return sgdw;
	}
	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}
	public String getJcxm1() {
		return jcxm1;
	}
	public void setJcxm1(String jcxm1) {
		this.jcxm1 = jcxm1;
	}
	public String getJcxm2() {
		return jcxm2;
	}
	public void setJcxm2(String jcxm2) {
		this.jcxm2 = jcxm2;
	}
	public String getJcxm3() {
		return jcxm3;
	}
	public void setJcxm3(String jcxm3) {
		this.jcxm3 = jcxm3;
	}
	public String getJcnrid() {
		return jcnrid;
	}
	public void setJcnrid(String jcnrid) {
		this.jcnrid = jcnrid;
	}
	public String getJcnrid1() {
		return jcnrid1;
	}
	public void setJcnrid1(String jcnrid1) {
		this.jcnrid1 = jcnrid1;
	}
	public String getCzwt() {
		return czwt;
	}
	public void setCzwt(String czwt) {
		this.czwt = czwt;
	}
	public String getJcr() {
		return jcr;
	}
	public void setJcr(String jcr) {
		this.jcr = jcr;
	}
	public String getJcsj() {
		return jcsj;
	}
	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}
	public String getZgqk() {
		return zgqk;
	}
	public void setZgqk(String zgqk) {
		this.zgqk = zgqk;
	}
	public String getFcr() {
		return fcr;
	}
	public void setFcr(String fcr) {
		this.fcr = fcr;
	}
	public String getFcsj() {
		return fcsj;
	}
	public void setFcsj(String fcsj) {
		this.fcsj = fcsj;
	}
	public String getJczj() {
		return jczj;
	}
	public void setJczj(String jczj) {
		this.jczj = jczj;
	}
	public String getSgdwfzr_jc() {
		return sgdwfzr_jc;
	}
	public void setSgdwfzr_jc(String sgdwfzr_jc) {
		this.sgdwfzr_jc = sgdwfzr_jc;
	}
	public String getZgjg() {
		return zgjg;
	}
	public void setZgjg(String zgjg) {
		this.zgjg = zgjg;
	}
	public String getSgdwfzr_fc() {
		return sgdwfzr_fc;
	}
	public void setSgdwfzr_fc(String sgdwfzr_fc) {
		this.sgdwfzr_fc = sgdwfzr_fc;
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

	public String getImg_tab1() {
		return img_tab1;
	}
	public void setImg_tab1(String img_tab1) {
		this.img_tab1 = img_tab1;
	}
	public String getImg_tab2() {
		return img_tab2;
	}
	public void setImg_tab2(String img_tab2) {
		this.img_tab2 = img_tab2;
	}
	public String getImg_tab3() {
		return img_tab3;
	}
	public void setImg_tab3(String img_tab3) {
		this.img_tab3 = img_tab3;
	}
	public Integer getCzwtallm() {
		return czwtallm;
	}
	public void setCzwtallm(Integer czwtallm) {
		this.czwtallm = czwtallm;
	}
	public Integer getZgqkTotal() {
		return zgqkTotal;
	}
	public void setZgqkTotal(Integer zgqkTotal) {
		this.zgqkTotal = zgqkTotal;
	}
	public List<SgjdjclrEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<SgjdjclrEntity> entity_list) {
		this.entity_list = entity_list;
	}
	
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getZgr() {
		return zgr;
	}
	public void setZgr(String zgr) {
		this.zgr = zgr;
	}

	public String getZgsj() {
		return zgsj;
	}
	public void setZgsj(String zgsj) {
		this.zgsj = zgsj;
	}

	public String getFcjg() {
		return fcjg;
	}
	public void setFcjg(String fcjg) {
		this.fcjg = fcjg;
	}
	public String getSgdwfzr_zg() {
		return sgdwfzr_zg;
	}
	public void setSgdwfzr_zg(String sgdwfzr_zg) {
		this.sgdwfzr_zg = sgdwfzr_zg;
	}
	
	public String getFcqk() {
		return fcqk;
	}
	public void setFcqk(String fcqk) {
		this.fcqk = fcqk;
	}
	@Override
	public String toString() {
		return "SgjdjclrEntity [oilfield=" + oilfield + ", jcid=" + jcid + ", team_qualification=" + team_qualification
				+ ", op_team=" + op_team + ", well_common_name=" + well_common_name + ", well_purpose=" + well_purpose
				+ ", item_name=" + item_name + ", sgdw=" + sgdw + ", jcxm1=" + jcxm1 + ", jcxm2=" + jcxm2 + ", jcxm3="
				+ jcxm3 + ", jcnrid=" + jcnrid + ", jcnrid1=" + jcnrid1 + ", czwt=" + czwt + ", jcr=" + jcr + ", jcsj="
				+ jcsj + ", zgqk=" + zgqk + ", fcr=" + fcr + ", fcsj=" + fcsj + ", jczj=" + jczj + ", sgdwfzr_jc="
				+ sgdwfzr_jc + ", zgjg=" + zgjg + ", sgdwfzr_fc=" + sgdwfzr_fc + ", design_num=" + design_num
				+ ", construction_id=" + construction_id + ", img_tab1=" + img_tab1 + ", img_tab2=" + img_tab2
				+ ", img_tab3=" + img_tab3 + ", lrr=" + lrr + ", datetime=" + datetime + ", czwtallm=" + czwtallm
				+ ", zgqkTotal=" + zgqkTotal + ", sign=" + sign + ", entity_list=" + entity_list + "]";
	}

	
}
