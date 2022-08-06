package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "许可证审核")
public class XkzshEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield; // 油田
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	@ApiModelProperty(value="许可证id")
	private String permit_id;//许可证id
	@ApiModelProperty(value="合同id")
	private String contract_id;//合同id
	@ApiModelProperty(value="承包商ID(公司id)")
	private String contractor_id; // 承包商ID(公司id)
	@ApiModelProperty(value="承包商名称")
	private String contractor_name;//承包商名称
	@ApiModelProperty(value="队伍名称")
	private String term_name;//队伍名称
	@ApiModelProperty(value="队伍编号")
	private String term_id;//队伍编号
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	@ApiModelProperty(value="甲方单位id")
	private String unit_id;//甲方单位id
	@ApiModelProperty(value="申请时间")
	private Date apply_time;//申请时间
	@ApiModelProperty(value="申请时间")
	private String apply_times;//申请时间
	@ApiModelProperty(value="审核状态：默认0待审核，1审核通过，2审核未通过,3作废")
	private String audit_tab;//审核状态：默认0待审核，1审核通过，2审核未通过,3作废
	@ApiModelProperty(value="审核人")
	private String audit_person;//审核人
	@ApiModelProperty(value="审核时间")
	private Date audit_time;//审核时间
	@ApiModelProperty(value="审核时间")
	private String audit_times;//审核时间
	@ApiModelProperty(value="审核原因")
	private String audit_cause;//审核原因
	@ApiModelProperty(value="是否上传")
	private String if_sc;//是否上传
	@ApiModelProperty(value="合同签订日期")
	private String effective_dates;//合同签订日期
	@ApiModelProperty(value="退回原因")
	private String scrap_cause;//退回原因
	@ApiModelProperty(value="许可证通过队伍数量")
	private int termnum;//许可证通过队伍数量
	@ApiModelProperty(value="许可证申请次数")
	private int applynum;//许可证申请次数
	public String getPermit_id() {
		return permit_id;
	}
	public void setPermit_id(String permit_id) {
		this.permit_id = permit_id;
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
	public String getTerm_name() {
		return term_name;
	}
	public void setTerm_name(String term_name) {
		this.term_name = term_name;
	}
	public String getTerm_id() {
		return term_id;
	}
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
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
	public String getAudit_tab() {
		return audit_tab;
	}
	public void setAudit_tab(String audit_tab) {
		this.audit_tab = audit_tab;
	}
	public String getAudit_person() {
		return audit_person;
	}
	public void setAudit_person(String audit_person) {
		this.audit_person = audit_person;
	}
	public Date getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(Date audit_time) {
		this.audit_time = audit_time;
	}
	public String getAudit_times() {
		return audit_times;
	}
	public void setAudit_times(String audit_times) {
		this.audit_times = audit_times;
	}
	public String getAudit_cause() {
		return audit_cause;
	}
	public void setAudit_cause(String audit_cause) {
		this.audit_cause = audit_cause;
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
	public String getScrap_cause() {
		return scrap_cause;
	}
	public void setScrap_cause(String scrap_cause) {
		this.scrap_cause = scrap_cause;
	}
	public int getTermnum() {
		return termnum;
	}
	public void setTermnum(int termnum) {
		this.termnum = termnum;
	}
	public int getApplynum() {
		return applynum;
	}
	public void setApplynum(int applynum) {
		this.applynum = applynum;
	}
	
	
	
}
