package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "企业管理")
public class QylrEntity extends BaseEntity{
	@ApiModelProperty(value="备用",hidden=true)
	private String  reserve1;
	@ApiModelProperty(value="备用",hidden=true)
	private String  reserve2;
	@ApiModelProperty(value="备用",hidden=true)
	private String  reserve3;
	@ApiModelProperty(value="油田")
	private String  oilfield;
	@ApiModelProperty(value="单位代码（id）",hidden=true)
	private String  dwdm;
	@ApiModelProperty(value="组织机构中企业名称（企业简称）")
	private String  unitname;
	@ApiModelProperty(value="单位名称（全称）")
	private String  dwmc;
	@ApiModelProperty(value="录入时间",hidden=true)
	private String  datatime;
	@ApiModelProperty(value="录入人",hidden=true)
	private String  input_person;
	@ApiModelProperty(value="单位类别")
	private String  dwlb;
	@ApiModelProperty(value="单位类别id ")
	private String  dwlbid;
	//确定数据类型，set&get
	@ApiModelProperty(value="组织机构中企业名称（企业简称）")
	private String  unitname1;
	@ApiModelProperty(value="int类型的电话")
	private String  iphone;
	@ApiModelProperty(value="队伍数量")
	private Integer termNUM;
	@ApiModelProperty(value="油公司合格供方入网证书编号")
	private String 	access_cert_num;
	@ApiModelProperty(value="取得集团资质单队数")
	private String 	group_quali_term;
	@ApiModelProperty(value="取得油公司准入单队数")
	private String 	oil_admittance_term;
	@ApiModelProperty(value="企业现住址")
	private String 	enterprise_address;
	@ApiModelProperty(value="企业性质")
	private String 	enterprise_nature;
	@ApiModelProperty(value="经理  法定代表人姓名")
	private String  manager;
	@ApiModelProperty(value="电话  法定代表人手机号")
	private String  phone;
	@ApiModelProperty(value="法定代表人身份证号")
	private String 	manager_IDCard;
	@ApiModelProperty(value="委托代理人身份证号")
	private String 	agent_IDCard;
	@ApiModelProperty(value="委托代理人姓名")
	private String 	agent;
	@ApiModelProperty(value="委托代理人手机号")
	private String 	agent_phone;
	@ApiModelProperty(value="营业执照统一社会信用代码")
	private String 	social_credit_code;
	@ApiModelProperty(value="注册资本金")
	private String 	registered_capital;
	@ApiModelProperty(value="主要经营范围（营业执照）")
	private String 	business_scope;
	@ApiModelProperty(value="开户银行名称")
	private String 	deposit_bank;
	@ApiModelProperty(value="银行帐号")
	private String 	bank_account_num;
	@ApiModelProperty(value="企业办公电话")
	private String 	telephone;
	@ApiModelProperty(value="企业总人数")
	private String 	total_number;
	@ApiModelProperty(value="管理人员人数")
	private String 	managers_number;
	@ApiModelProperty(value="主要设备台数")
	private String 	main_equi_num;
	@ApiModelProperty(value="设备资产原值（万元）")
	private String 	equi_assets_orig_val;
	@ApiModelProperty(value="设备资产现值（万元）")
	private String equi_assets_now_val;
	@ApiModelProperty(value="经营场所面积（平方米）")
	private String 	business_place;
	@ApiModelProperty(value="企业年度资产负债率（％）")
	private String 	asset_liability_ratio;
	@ApiModelProperty(value="准入证许可施工项目")
	private String 	construction_project;
	@ApiModelProperty(value="备注")
	private String 	remarks;

	
	
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
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInput_person() {
		return input_person;
	}
	public void setInput_person(String input_person) {
		this.input_person = input_person;
	}
	public String getDwlb() {
		return dwlb;
	}
	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}
	public String getDwlbid() {
		return dwlbid;
	}
	public void setDwlbid(String dwlbid) {
		this.dwlbid = dwlbid;
	}
	public String getUnitname1() {
		return unitname1;
	}
	public void setUnitname1(String unitname1) {
		this.unitname1 = unitname1;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public String getDatatime() {
		return datatime;
	}

	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}

	public Integer getTermNUM() {
		return termNUM;
	}

	public void setTermNUM(Integer termNUM) {
		this.termNUM = termNUM;
	}
	public String getAccess_cert_num() {
		return access_cert_num;
	}
	public void setAccess_cert_num(String access_cert_num) {
		this.access_cert_num = access_cert_num;
	}
	public String getGroup_quali_term() {
		return group_quali_term;
	}
	public void setGroup_quali_term(String group_quali_term) {
		this.group_quali_term = group_quali_term;
	}
	public String getOil_admittance_term() {
		return oil_admittance_term;
	}
	public void setOil_admittance_term(String oil_admittance_term) {
		this.oil_admittance_term = oil_admittance_term;
	}
	public String getEnterprise_address() {
		return enterprise_address;
	}
	public void setEnterprise_address(String enterprise_address) {
		this.enterprise_address = enterprise_address;
	}
	public String getEnterprise_nature() {
		return enterprise_nature;
	}
	public void setEnterprise_nature(String enterprise_nature) {
		this.enterprise_nature = enterprise_nature;
	}
	public String getManager_IDCard() {
		return manager_IDCard;
	}
	public void setManager_IDCard(String manager_IDCard) {
		this.manager_IDCard = manager_IDCard;
	}
	public String getAgent_IDCard() {
		return agent_IDCard;
	}
	public void setAgent_IDCard(String agent_IDCard) {
		this.agent_IDCard = agent_IDCard;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getAgent_phone() {
		return agent_phone;
	}
	public void setAgent_phone(String agent_phone) {
		this.agent_phone = agent_phone;
	}
	public String getSocial_credit_code() {
		return social_credit_code;
	}
	public void setSocial_credit_code(String social_credit_code) {
		this.social_credit_code = social_credit_code;
	}
	public String getRegistered_capital() {
		return registered_capital;
	}
	public void setRegistered_capital(String registered_capital) {
		this.registered_capital = registered_capital;
	}
	public String getBusiness_scope() {
		return business_scope;
	}
	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}
	public String getDeposit_bank() {
		return deposit_bank;
	}
	public void setDeposit_bank(String deposit_bank) {
		this.deposit_bank = deposit_bank;
	}
	public String getBank_account_num() {
		return bank_account_num;
	}
	public void setBank_account_num(String bank_account_num) {
		this.bank_account_num = bank_account_num;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTotal_number() {
		return total_number;
	}
	public void setTotal_number(String total_number) {
		this.total_number = total_number;
	}
	public String getManagers_number() {
		return managers_number;
	}
	public void setManagers_number(String managers_number) {
		this.managers_number = managers_number;
	}
	public String getMain_equi_num() {
		return main_equi_num;
	}
	public void setMain_equi_num(String main_equi_num) {
		this.main_equi_num = main_equi_num;
	}
	public String getEqui_assets_orig_val() {
		return equi_assets_orig_val;
	}
	public void setEqui_assets_orig_val(String equi_assets_orig_val) {
		this.equi_assets_orig_val = equi_assets_orig_val;
	}
	public String getEqui_assets_now_val() {
		return equi_assets_now_val;
	}
	public void setEqui_assets_now_val(String equi_assets_now_val) {
		this.equi_assets_now_val = equi_assets_now_val;
	}
	public String getBusiness_place() {
		return business_place;
	}
	public void setBusiness_place(String business_place) {
		this.business_place = business_place;
	}
	public String getAsset_liability_ratio() {
		return asset_liability_ratio;
	}
	public void setAsset_liability_ratio(String asset_liability_ratio) {
		this.asset_liability_ratio = asset_liability_ratio;
	}
	public String getConstruction_project() {
		return construction_project;
	}
	public void setConstruction_project(String construction_project) {
		this.construction_project = construction_project;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "QylrEntity [reserve1=" + reserve1 + ", reserve2=" + reserve2
				+ ", reserve3=" + reserve3 + ", oilfield=" + oilfield
				+ ", dwdm=" + dwdm + ", unitname=" + unitname + ", dwmc="
				+ dwmc + ", manager=" + manager + ", phone=" + phone
				+ ", datatime=" + datatime + ", input_person=" + input_person
				+ ", dwlb=" + dwlb + ", dwlbid=" + dwlbid + ", unitname1="
				+ unitname1 + ", iphone=" + iphone + ", qx=" + qx + ", endRow="
				+ endRow + ", startRow=" + startRow + ", row_num=" + row_num
				+ ", el=" + el + ", is=" + is + ", whc=" + whc + ", parm="
				+ parm + ", ord=" + ord + ", getReserve1()=" + getReserve1()
				+ ", getReserve2()=" + getReserve2() + ", getReserve3()="
				+ getReserve3() + ", getOilfield()=" + getOilfield()
				+ ", getDwdm()=" + getDwdm() + ", getUnitname()="
				+ getUnitname() + ", getDwmc()=" + getDwmc()
				+ ", getManager()=" + getManager() + ", getPhone()="
				+ getPhone() + ", getDatatime()=" + getDatatime()
				+ ", getInput_person()=" + getInput_person() + ", getDwlb()="
				+ getDwlb() + ", getDwlbid()=" + getDwlbid()
				+ ", getUnitname1()=" + getUnitname1() + ", getIphone()="
				+ getIphone() + ", getQx()=" + getQx() + ", getEndRow()="
				+ getEndRow() + ", getStartRow()=" + getStartRow()
				+ ", getRow_num()=" + getRow_num() + ", getEl()=" + getEl()
				+ ", getIs()=" + getIs() + ", getWhc()=" + getWhc()
				+ ", getParm()=" + getParm() + ", getOrd()=" + getOrd()
				+ ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}
