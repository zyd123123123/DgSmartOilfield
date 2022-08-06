package com.cyrj.jxzy.entity.Constractor;
import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "合同信息维护")
public class HtxxwhEntity extends BaseEntity {
	@ApiModelProperty(value="合同变更id")
	private String contract_bgid;//合同变更id
	@ApiModelProperty(value="合同ID——系统生成")
	private String contract_id;//合同ID——系统生成
	@ApiModelProperty(value="承包商名称")
	private String contractor_name; // 承包商名称
	@ApiModelProperty(value="承包商名称")
	private String contractor_id; // 承包商名称
	@ApiModelProperty(value="施工项目")
	private String construction_project; // 施工项目
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="合同来源")
	private String contract_source; // 合同来源
	@ApiModelProperty(value="履行期限——开工日期")
	private String operation_start_date; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private String completion_date; // 履行期限—完工日期
	@ApiModelProperty(value="工作量(井次)")
	private Integer workload; // 工作量(井次)
	@ApiModelProperty(value="标的金额")
	private String money; // 标的金额
	@ApiModelProperty(value="合同是否履行完毕")
	private String whether_to_perform; // 合同是否履行完毕
	@ApiModelProperty(value="合同变更时间")
	private String chang_time; // 合同变更时间
	@ApiModelProperty(value="合同变更人")
	private String chang_person; // 合同变更人
	@ApiModelProperty(value="合同生效时间")
	private String effective_date; // 合同生效时间
	@ApiModelProperty(value="甲方单位名称")
	private String unit_name; // 甲方单位名称
	@ApiModelProperty(value="甲方单位ID")
	private String unit_id; // 甲方单位ID
	@ApiModelProperty(value="合同是否履行完毕")
	private String if_bg; // 合同是否履行完毕
	@ApiModelProperty(value="变更原因")
    private String change_cause;//变更原因
	@ApiModelProperty(value="变更原因说明")
    private String change_cause_explain;//变更原因说明
	@ApiModelProperty(value="变更事项")
    private String change_matters;//变更事项
	@ApiModelProperty(value="变更事项1")
    private String change_matters1;//变更事项1
	@ApiModelProperty(value="变更事项2")
    private String change_matters2;//变更事项2
	@ApiModelProperty(value="变更事项3")
    private String change_matters3;//变更事项3
	@ApiModelProperty(value="变更事项4")
    private String change_matters4;//变更事项4
	@ApiModelProperty(value="变更事项5")
    private String change_matters5;//变更事项5
	@ApiModelProperty(value="变更事项6")
    private String change_matters6;//变更事项6
	@ApiModelProperty(value="变更标的金额")
    private String change_money;//变更标的金额
	@ApiModelProperty(value="变更合同履行期限（开工日期）")
    private String change_operation_start_date;//变更合同履行期限（开工日期）
	@ApiModelProperty(value="变更合同履行期限（完工日期）")
    private String change_completion_date;//变更合同履行期限（完工日期）
	@ApiModelProperty(value="其他变更")
    private String change_other;//其他变更
	@ApiModelProperty(value="变更后工作量")
    private Integer change_workload;//变更后工作量
	@ApiModelProperty(value="变更后税率")
    private String change_tax_rate;//变更后税率
	@ApiModelProperty(value="标记（原始信息、变更信息）")
	private String tab;//标记（原始信息、变更信息）
	private String sql;
	private String datetimes;
	private String wgqr_time;
	private String wgqrr;
	@ApiModelProperty(value="税率")
	private String tax_rate;//税率
	@ApiModelProperty(value="合同信息审核标记默认1待审核，2通过0退回")
	private String audittab;//合同信息审核标记默认1待审核，2通过0退回
	@ApiModelProperty(value="审核退回原因")
	private String auditremark;//审核退回原因
	@ApiModelProperty(value="审核人")
	private String auditperson;//审核人
	@ApiModelProperty(value="审核时间")
	private Date audittime;//审核时间
	@ApiModelProperty(value="审核时间")
	private String audittimes;//审核时间
	private List<String> file_list;

	public String getChange_matters4() {
		return change_matters4;
	}

	public void setChange_matters4(String change_matters4) {
		this.change_matters4 = change_matters4;
	}
	public String getWgqrr() {
		return wgqrr;
	}

	public void setWgqrr(String wgqrr) {
		this.wgqrr = wgqrr;
	}

	public String getConstruction_project() {
		return construction_project;
	}

	public String getContractor_name() {
		return contractor_name;
	}

	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}

	public void setConstruction_project(String construction_project) {
		this.construction_project = construction_project;
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

	public String getContract_source() {
		return contract_source;
	}

	public void setContract_source(String contract_source) {
		this.contract_source = contract_source;
	}

	public Integer getWorkload() {
		return workload;
	}

	public void setWorkload(Integer workload) {
		this.workload = workload;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getWhether_to_perform() {
		return whether_to_perform;
	}

	public void setWhether_to_perform(String whether_to_perform) {
		this.whether_to_perform = whether_to_perform;
	}

	
	public String getChang_time() {
		return chang_time;
	}

	public void setChang_time(String chang_time) {
		this.chang_time = chang_time;
	}

	public String getChang_person() {
		return chang_person;
	}

	public void setChang_person(String chang_person) {
		this.chang_person = chang_person;
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


	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getIf_bg() {
		return if_bg;
	}

	public void setIf_bg(String if_bg) {
		this.if_bg = if_bg;
	}

	public String getChange_cause() {
		return change_cause;
	}

	public void setChange_cause(String change_cause) {
		this.change_cause = change_cause;
	}

	public String getChange_cause_explain() {
		return change_cause_explain;
	}

	public void setChange_cause_explain(String change_cause_explain) {
		this.change_cause_explain = change_cause_explain;
	}

	public String getChange_matters() {
		return change_matters;
	}

	public void setChange_matters(String change_matters) {
		this.change_matters = change_matters;
	}

	public String getChange_matters1() {
		return change_matters1;
	}

	public void setChange_matters1(String change_matters1) {
		this.change_matters1 = change_matters1;
	}

	public String getChange_matters2() {
		return change_matters2;
	}

	public void setChange_matters2(String change_matters2) {
		this.change_matters2 = change_matters2;
	}

	public String getChange_matters3() {
		return change_matters3;
	}

	public void setChange_matters3(String change_matters3) {
		this.change_matters3 = change_matters3;
	}

	public String getChange_money() {
		return change_money;
	}

	public void setChange_money(String change_money) {
		this.change_money = change_money;
	}

	public String getOperation_start_date() {
		return operation_start_date;
	}

	public void setOperation_start_date(String operation_start_date) {
		this.operation_start_date = operation_start_date;
	}

	public String getCompletion_date() {
		return completion_date;
	}

	public void setCompletion_date(String completion_date) {
		this.completion_date = completion_date;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	public String getChange_operation_start_date() {
		return change_operation_start_date;
	}

	public void setChange_operation_start_date(String change_operation_start_date) {
		this.change_operation_start_date = change_operation_start_date;
	}

	public String getChange_completion_date() {
		return change_completion_date;
	}

	public void setChange_completion_date(String change_completion_date) {
		this.change_completion_date = change_completion_date;
	}

	public String getWgqr_time() {
		return wgqr_time;
	}

	public void setWgqr_time(String wgqr_time) {
		this.wgqr_time = wgqr_time;
	}

	public String getChange_other() {
		return change_other;
	}

	public void setChange_other(String change_other) {
		this.change_other = change_other;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}


	public String getDatetimes() {
		return datetimes;
	}

	public void setDatetimes(String datetimes) {
		this.datetimes = datetimes;
	}

	public String getAudittab() {
		return audittab;
	}

	public void setAudittab(String audittab) {
		this.audittab = audittab;
	}

	public String getAuditremark() {
		return auditremark;
	}

	public void setAuditremark(String auditremark) {
		this.auditremark = auditremark;
	}

	public String getAuditperson() {
		return auditperson;
	}

	public void setAuditperson(String auditperson) {
		this.auditperson = auditperson;
	}

	public Date getAudittime() {
		return audittime;
	}

	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	public String getAudittimes() {
		return audittimes;
	}

	public void setAudittimes(String audittimes) {
		this.audittimes = audittimes;
	}

	public String getContract_bgid() {
		return contract_bgid;
	}

	public void setContract_bgid(String contract_bgid) {
		this.contract_bgid = contract_bgid;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getContractor_id() {
		return contractor_id;
	}

	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}

	public Integer getChange_workload() {
		return change_workload;
	}

	public void setChange_workload(Integer change_workload) {
		this.change_workload = change_workload;
	}

	public String getChange_tax_rate() {
		return change_tax_rate;
	}

	public void setChange_tax_rate(String change_tax_rate) {
		this.change_tax_rate = change_tax_rate;
	}

	public String getChange_matters5() {
		return change_matters5;
	}

	public void setChange_matters5(String change_matters5) {
		this.change_matters5 = change_matters5;
	}

	public String getChange_matters6() {
		return change_matters6;
	}

	public void setChange_matters6(String change_matters6) {
		this.change_matters6 = change_matters6;
	}

	public List<String> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<String> file_list) {
		this.file_list = file_list;
	}
}
