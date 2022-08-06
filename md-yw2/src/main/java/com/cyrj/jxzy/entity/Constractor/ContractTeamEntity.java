package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "合同绑定队伍信息类")
public class ContractTeamEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="合同id")
	private String contract_id;//合同id
	@ApiModelProperty(value="承包商ID(公司id)")
	private String contractor_id; // 承包商ID(公司id)
	@ApiModelProperty(value="承包商名称")
	private String contractor_name;//承包商名称
	@ApiModelProperty(value="队伍名称")
	private String team_name;//队伍名称
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="日期")
	private Date datetime;//日期
	@ApiModelProperty(value="复选框是否选中标记，空未选中，承包商合同信息创建页面使用")
	private String checkTab;//复选框是否选中标记，空未选中，承包商合同信息创建页面使用
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	@ApiModelProperty(value="甲方单位")
	private String unit_id;//甲方单位
	@ApiModelProperty(value="附件类型")
	private String filetype;//附件类型
	@ApiModelProperty(value="是否打印")
	private String if_dy;//是否打印
	@ApiModelProperty(value="是否上传")
	private String if_sc;//是否上传
	@ApiModelProperty(value="施工项目")
	private String construction_project;//施工项目
	@ApiModelProperty(value="审核状态")
	private String audit_tab;//审核状态
	@ApiModelProperty(value="队伍id")
	private String termid;//队伍id
	@ApiModelProperty(value="队伍id")
	private String team_id;//队伍id
	@ApiModelProperty(value="资质设计id")
	private String sjid;//资质设计id
	@ApiModelProperty(value="评估id")
	private String pgb_id;//评估id
	@ApiModelProperty(value="合同生效日期")
    private Date 	effective_date;//合同生效日期
	@ApiModelProperty(value="合同生效日期")
    private String 	effective_dates;//合同生效日期
	@ApiModelProperty(value="申请人")
    private String apply_person;//申请人
	@ApiModelProperty(value="申请时间")
    private String apply_times;//申请时间

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
	public String getCheckTab() {
		return checkTab;
	}
	public void setCheckTab(String checkTab) {
		this.checkTab = checkTab;
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
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getSjid() {
		return sjid;
	}
	public void setSjid(String sjid) {
		this.sjid = sjid;
	}
	public String getPgb_id() {
		return pgb_id;
	}
	public void setPgb_id(String pgb_id) {
		this.pgb_id = pgb_id;
	}
	public Date getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}
	public String getEffective_dates() {
		return effective_dates;
	}
	public void setEffective_dates(String effective_dates) {
		this.effective_dates = effective_dates;
	}
	
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	
	public String getApply_person() {
		return apply_person;
	}
	public void setApply_person(String apply_person) {
		this.apply_person = apply_person;
	}
	public String getApply_times() {
		return apply_times;
	}
	public void setApply_times(String apply_times) {
		this.apply_times = apply_times;
	}
	
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	@Override
	public String toString() {
		return "ContractTeamEntity [contract_id=" + contract_id
				+ ", contractor_id=" + contractor_id + ", contractor_name="
				+ contractor_name + ", team_name=" + team_name
				+ ", team_qualification=" + team_qualification + ", datetime="
				+ datetime + ", checkTab=" + checkTab + ", contract_name="
				+ contract_name + ", contract_number=" + contract_number
				+ ", unit_name=" + unit_name + ", unit_id=" + unit_id
				+ ", filetype=" + filetype + ", if_dy=" + if_dy + ", if_sc="
				+ if_sc + ", construction_project=" + construction_project
				+ ", audit_tab=" + audit_tab + ", termid=" + termid
				+ ", team_id=" + team_id + ", sjid=" + sjid + ", pgb_id="
				+ pgb_id + ", effective_date=" + effective_date
				+ ", effective_dates=" + effective_dates + ", apply_person="
				+ apply_person + ", apply_times=" + apply_times + "]";
	}
	

	
}
