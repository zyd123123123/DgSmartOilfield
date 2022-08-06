package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "能力评估")
public class NlpgshEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield; // 油田
	@ApiModelProperty(value="评估表id")
	private String pgb_id;//评估表id
	@ApiModelProperty(value="资质设计id")
	private String sjid;//资质设计id
	@ApiModelProperty(value="合同id")
	private String contract_id;//合同id
	@ApiModelProperty(value="承包商ID(公司id)")
	private String contractor_id; // 承包商ID(公司id)
	@ApiModelProperty(value="承包商名称")
	private String contractor_name;//承包商名称
	@ApiModelProperty(value="队伍名称")
	private String team_name;//队伍名称
	@ApiModelProperty(value="队伍编号")
	private String team_id;//队伍编号
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="日期")
	private Date datetime;//日期
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	@ApiModelProperty(value="甲方单位id")
	private String unit_id;//甲方单位id
	@ApiModelProperty(value="施工项目")
	private String construction_project;//施工项目
	@ApiModelProperty(value="审核状态")
	private String audit_tab;//审核状态
	@ApiModelProperty(value="审核结果")
	private String audit_jg;//审核结果
	@ApiModelProperty(value="原因")
	private String audit_cause;//原因
	@ApiModelProperty(value="申请人")
	private String apply_person;//申请人
	@ApiModelProperty(value="申请时间")
	private Date apply_time;//申请时间
	@ApiModelProperty(value="申请时间")
	private String apply_times;//申请时间
	@ApiModelProperty(value="文件类型")
	private String filetype;//文件类型
	@ApiModelProperty(value="是否打印")
	private String if_dy;//是否打印
	@ApiModelProperty(value="是否上传")
	private String if_sc;//是否上传
	@ApiModelProperty(value="合同签订日期")
	private String effective_dates;//合同签订日期
	@ApiModelProperty(value="退回原因")
	private String back_cause;//退回原因
	@ApiModelProperty(value="退回人")
	private String back_person;//退回人
	@ApiModelProperty(value="退回时间")
	private String back_time;//退回时间
	private List<CbsFj2Entity> entity_fj2_list;
	
	public String getPgb_id() {
		return pgb_id;
	}
	public void setPgb_id(String pgb_id) {
		this.pgb_id = pgb_id;
	}
	public String getSjid() {
		return sjid;
	}
	public void setSjid(String sjid) {
		this.sjid = sjid;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getConstruction_project() {
		return construction_project;
	}
	public void setConstruction_project(String construction_project) {
		this.construction_project = construction_project;
	}
	public String getAudit_tab() {
		return audit_tab;
	}
	public void setAudit_tab(String audit_tab) {
		this.audit_tab = audit_tab;
	}
	public String getAudit_jg() {
		return audit_jg;
	}
	public void setAudit_jg(String audit_jg) {
		this.audit_jg = audit_jg;
	}
	public String getApply_person() {
		return apply_person;
	}
	public void setApply_person(String apply_person) {
		this.apply_person = apply_person;
	}
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	public String getApply_times() {
		return apply_times;
	}
	public void setApply_times(String apply_times) {
		this.apply_times = apply_times;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getIf_dy() {
		return if_dy;
	}
	public void setIf_dy(String if_dy) {
		this.if_dy = if_dy;
	}
	public String getIf_sc() {
		return if_sc;
	}
	public void setIf_sc(String if_sc) {
		this.if_sc = if_sc;
	}
	public String getEffective_dates() {
		return effective_dates;
	}
	public void setEffective_dates(String effective_dates) {
		this.effective_dates = effective_dates;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getAudit_cause() {
		return audit_cause;
	}
	public void setAudit_cause(String audit_cause) {
		this.audit_cause = audit_cause;
	}
	public String getBack_cause() {
		return back_cause;
	}
	public void setBack_cause(String back_cause) {
		this.back_cause = back_cause;
	}
	public String getBack_person() {
		return back_person;
	}
	public void setBack_person(String back_person) {
		this.back_person = back_person;
	}
	public String getBack_time() {
		return back_time;
	}
	public void setBack_time(String back_time) {
		this.back_time = back_time;
	}

	public List<CbsFj2Entity> getEntity_fj2_list() {
		return entity_fj2_list;
	}

	public void setEntity_fj2_list(List<CbsFj2Entity> entity_fj2_list) {
		this.entity_fj2_list = entity_fj2_list;
	}
}
