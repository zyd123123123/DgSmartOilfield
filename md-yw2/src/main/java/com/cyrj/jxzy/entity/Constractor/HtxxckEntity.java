package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "合同信息查询")
public class HtxxckEntity extends BaseEntity{
	@ApiModelProperty(value="备用字段1")
	private String reserve1; // 备用字段1
	@ApiModelProperty(value="备用字段2")
	private String reserve2; // 备用字段2
	@ApiModelProperty(value="备用字段3")
	private String reserve3; // 备用字段3
	@ApiModelProperty(value="备用字段3")
	private String oilfield; // 备用字段3
	@ApiModelProperty(value="合同ID——系统生成")
	private String contract_id;//合同ID——系统生成
	@ApiModelProperty(value="承包商名称")
	private String contractor_name; // 承包商名称
	@ApiModelProperty(value="承包商ID")
	private String contractor_id; // 承包商ID
	@ApiModelProperty(value="施工项目")
	private String construction_project; // 施工项目
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="合同来源")
	private String contract_source; // 合同来源
	@ApiModelProperty(value="履行期限——开工日期")
	private Date operation_start_date; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private Date completion_date; // 履行期限—完工日期
	@ApiModelProperty(value="履行期限——开工日期")
	private String operation_start_dates; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private String completion_dates; // 履行期限—完工日期
	@ApiModelProperty(value="工作量(井次)")
	private Integer workload; // 工作量(井次)
	@ApiModelProperty(value="标的金额")
	private String money; // 标的金额
	@ApiModelProperty(value="合同是否履行完毕")
	private String whether_to_perform; // 合同是否履行完毕
	@ApiModelProperty(value="合同录入系统时间")
	private Date entry_time; // 合同录入系统时间
	@ApiModelProperty(value="合同录入人")
	private String input_person; // 合同录入人
	@ApiModelProperty(value="合同生效时间")
	private Date effective_date; // 合同生效时间
	@ApiModelProperty(value="合同生效时间")
	private String effective_dates; // 合同生效时间
	@ApiModelProperty(value="甲方单位名称")
	private String unit_name; // 甲方单位名称
	@ApiModelProperty(value="甲方单位ID")
	private String unit_id; // 甲方单位ID
	@ApiModelProperty(value="合同是否履行完毕")
	private String if_bg; // 合同是否履行完毕
	// 确定数据类型，set&get
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
	@ApiModelProperty(value="是否上传合同扫描件标记")
	private int file_tab;//是否上传合同扫描件标记
	@ApiModelProperty(value="绑定队伍数量")
	private int term_num;//绑定队伍数量
	@ApiModelProperty(value="承包商简称")
	private String ejdwmc;//承包商简称
	@ApiModelProperty(value="是否评估")
	private String is_pg;//是否评估
	@ApiModelProperty(value="评估时间")
	private String pg_date;//评估时间
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getReserve3() {
		return reserve3;
	}
	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}
	public String getConstruction_project() {
		return construction_project;
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
	public Date getOperation_start_date() {
		return operation_start_date;
	}
	public void setOperation_start_date(Date operation_start_date) {
		this.operation_start_date = operation_start_date;
	}
	public Date getCompletion_date() {
		return completion_date;
	}
	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
	}
	public String getOperation_start_dates() {
		return operation_start_dates;
	}
	public void setOperation_start_dates(String operation_start_dates) {
		this.operation_start_dates = operation_start_dates;
	}
	public String getCompletion_dates() {
		return completion_dates;
	}
	public void setCompletion_dates(String completion_dates) {
		this.completion_dates = completion_dates;
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
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getInput_person() {
		return input_person;
	}
	public void setInput_person(String input_person) {
		this.input_person = input_person;
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
	public String getIf_bg() {
		return if_bg;
	}
	public void setIf_bg(String if_bg) {
		this.if_bg = if_bg;
	}
	public String getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
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
	public int getFile_tab() {
		return file_tab;
	}
	public void setFile_tab(int file_tab) {
		this.file_tab = file_tab;
	}
	public int getTerm_num() {
		return term_num;
	}
	public void setTerm_num(int term_num) {
		this.term_num = term_num;
	}
	
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	
	public String getEjdwmc() {
		return ejdwmc;
	}
	public void setEjdwmc(String ejdwmc) {
		this.ejdwmc = ejdwmc;
	}
	
	public String getIs_pg() {
		return is_pg;
	}
	public void setIs_pg(String is_pg) {
		this.is_pg = is_pg;
	}
	
	public String getPg_date() {
		return pg_date;
	}
	public void setPg_date(String pg_date) {
		this.pg_date = pg_date;
	}
	@Override
	public String toString() {
		return "HtxxckEntity [reserve1=" + reserve1 + ", reserve2=" + reserve2
				+ ", reserve3=" + reserve3 + ", contract_id=" + contract_id
				+ ", contractor_name=" + contractor_name + ", contractor_id="
				+ contractor_id + ", construction_project="
				+ construction_project + ", contract_name=" + contract_name
				+ ", contract_number=" + contract_number + ", contract_source="
				+ contract_source + ", operation_start_date="
				+ operation_start_date + ", completion_date=" + completion_date
				+ ", operation_start_dates=" + operation_start_dates
				+ ", completion_dates=" + completion_dates + ", workload="
				+ workload + ", money=" + money + ", whether_to_perform="
				+ whether_to_perform + ", entry_time=" + entry_time
				+ ", input_person=" + input_person + ", effective_date="
				+ effective_date + ", effective_dates=" + effective_dates
				+ ", unit_name=" + unit_name + ", unit_id=" + unit_id
				+ ", if_bg=" + if_bg + ", tax_rate=" + tax_rate + ", audittab="
				+ audittab + ", auditremark=" + auditremark + ", auditperson="
				+ auditperson + ", audittime=" + audittime + ", audittimes="
				+ audittimes + ", file_tab=" + file_tab + ", term_num="
				+ term_num + "]";
	}
	
	
}
