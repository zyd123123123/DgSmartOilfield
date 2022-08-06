package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 许可证合同信息
 * @author admin
 *
 */
@ApiModel(value = "许可证合同信息")
public class XkzhtEntity extends BaseEntity{
	@ApiModelProperty(value="油田id")
	private String oilfield;//油田id
	@ApiModelProperty(value="许可证id")
	private String permit_id;//许可证id
	@ApiModelProperty(value="合同id")
	private String contract_id;//合同id
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="单位名称")
	private String dwmc;//单位名称
	@ApiModelProperty(value="队伍id")
	private String team_id;//队伍id
	@ApiModelProperty(value="队伍名称")
	private String term_name;//队伍名称
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="申请人")
	private String apply_person;//申请人
	@ApiModelProperty(value="申请时间")
	private Date apply_time;//申请时间
	@ApiModelProperty(value="申请时间电话")
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
	@ApiModelProperty(value="许可证作废人")
	private String scrap_person;//许可证作废人
	@ApiModelProperty(value="许可证作废时间")
	private Date scrap_time;//许可证作废时间
	@ApiModelProperty(value="许可证作废时间")
	private String scrap_times;//许可证作废时间
	@ApiModelProperty(value="许可证作废原因")
	private String scrap_cause;//许可证作废原因
	@ApiModelProperty(value="大文本类型")
	private String type;//大文本类型
	@ApiModelProperty(value="大文本时间")
	private String neirong;//大文本时间
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
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
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTerm_name() {
		return term_name;
	}
	public void setTerm_name(String term_name) {
		this.term_name = term_name;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
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
	public String getScrap_person() {
		return scrap_person;
	}
	public void setScrap_person(String scrap_person) {
		this.scrap_person = scrap_person;
	}
	public Date getScrap_time() {
		return scrap_time;
	}
	public void setScrap_time(Date scrap_time) {
		this.scrap_time = scrap_time;
	}
	public String getScrap_times() {
		return scrap_times;
	}
	public void setScrap_times(String scrap_times) {
		this.scrap_times = scrap_times;
	}
	public String getScrap_cause() {
		return scrap_cause;
	}
	public void setScrap_cause(String scrap_cause) {
		this.scrap_cause = scrap_cause;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	@Override
	public String toString() {
		return "XkzEntity [oilfield=" + oilfield + ", permit_id=" + permit_id
				+ ", contract_id=" + contract_id + ", dwdm=" + dwdm + ", dwmc="
				+ dwmc + ", team_id=" + team_id + ", term_name=" + term_name
				+ ", team_qualification=" + team_qualification
				+ ", apply_person=" + apply_person + ", apply_time="
				+ apply_time + ", apply_times=" + apply_times + ", audit_tab="
				+ audit_tab + ", audit_person=" + audit_person
				+ ", audit_time=" + audit_time + ", audit_times=" + audit_times
				+ ", audit_cause=" + audit_cause + ", scrap_person="
				+ scrap_person + ", scrap_time=" + scrap_time
				+ ", scrap_times=" + scrap_times + ", scrap_cause="
				+ scrap_cause + ", type=" + type + ", neirong=" + neirong
				+ ", unit_name=" + unit_name + "]";
	}
	
	
}
