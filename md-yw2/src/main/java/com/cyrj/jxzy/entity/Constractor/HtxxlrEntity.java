package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "合同信息录入")
public class HtxxlrEntity extends BaseEntity {
	@ApiModelProperty(value="备用字段1")
	private String reserve1; // 备用字段1
	@ApiModelProperty(value="备用字段2")
	private String reserve2; // 备用字段2
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="合同ID——系统生成")
	private String contract_id;// 合同ID——系统生成
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
	private String operation_start_date; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限——开工日期")
	private String operation_start_dates; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private String completion_date; // 履行期限—完工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private String completion_dates; // 履行期限—完工日期
	@ApiModelProperty(value="工作量(井次)")
	private Integer workload; // 工作量(井次)
	@ApiModelProperty(value="标的金额")
	private String money; // 标的金额
	@ApiModelProperty(value="合同是否履行完毕")
	private String whether_to_perform; // 合同是否履行完毕
	@ApiModelProperty(value="合同录入系统时间")
	private String entry_time; // 合同录入系统时间
	@ApiModelProperty(value="合同录入人")
	private String input_person; // 合同录入人
	@ApiModelProperty(value="合同生效时间")
	private String effective_date; // 合同生效时间
	@ApiModelProperty(value="合同生效时间")
	private String effective_dates; // 合同生效时间
	@ApiModelProperty(value="甲方单位名称")
	private String unit_name; // 甲方单位名称
	@ApiModelProperty(value="甲方单位ID")
	private String unit_id; // 甲方单位ID
	@ApiModelProperty(value="二级单位名称（承包商名称简称）")
	private String ejdwmc;// 二级单位名称（承包商名称简称）
	@ApiModelProperty(value="合同扫描件")
	private String file_tab;// 合同扫描件
	@ApiModelProperty(value="税率")
	private String tax_rate;// 税率
	// 确定数据类型，set&get
	@ApiModelProperty(value="退回验证")
	private List<QualificationEntity> entity_q_list;
	private List<String> file_list;
	private String audittab;// 退回验证

	public String getAudittab() {
		return audittab;
	}

	public void setAudittab(String audittab) {
		this.audittab = audittab;
	}

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

	public String getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(String entry_time) {
		this.entry_time = entry_time;
	}

	public String getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
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

	public String getInput_person() {
		return input_person;
	}

	public void setInput_person(String input_person) {
		this.input_person = input_person;
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

	public String getEjdwmc() {
		return ejdwmc;
	}

	public void setEjdwmc(String ejdwmc) {
		this.ejdwmc = ejdwmc;
	}

	public String getFile_tab() {
		return file_tab;
	}

	public void setFile_tab(String file_tab) {
		this.file_tab = file_tab;
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

	public String getEffective_dates() {
		return effective_dates;
	}

	public void setEffective_dates(String effective_dates) {
		this.effective_dates = effective_dates;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public List<QualificationEntity> getEntity_q_list() {
		return entity_q_list;
	}

	public void setEntity_q_list(List<QualificationEntity> entity_q_list) {
		this.entity_q_list = entity_q_list;
	}

	public List<String> getFile_list() {
		return file_list;
	}

	public void setFile_list(List<String> file_list) {
		this.file_list = file_list;
	}


}
