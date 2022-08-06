package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "监督检查细则类")
public class CbsFj4Entity extends BaseEntity{

	@ApiModelProperty(value="检查项目1")
	private String  jcxm1; //检查项目1
	@ApiModelProperty(value="检查项目2")
	private String  jcxm2; //检查项目2
	@ApiModelProperty(value="检查项目3")
	private String  jcxm3; //检查项目3
	@ApiModelProperty(value="监督检查内容")
	private String  jdjcnr; //监督检查内容
	@ApiModelProperty(value="null")
	private Date  datatime; //null
	@ApiModelProperty(value="编号")
	private int  id; //编号
	
	private String contract_id;
	private String tab;
	private String year;
	private String month;
	private String date;
	private String effective_dates;
	private List<CbsFj4Entity> entity_list;


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
	public String getJdjcnr() {
		return jdjcnr;
	}
	public void setJdjcnr(String jdjcnr) {
		this.jdjcnr = jdjcnr;
	}
	public Date getDatatime() {
		return datatime;
	}
	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEffective_dates() {
		return effective_dates;
	}
	public void setEffective_dates(String effective_dates) {
		this.effective_dates = effective_dates;
	}
	
	public List<CbsFj4Entity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<CbsFj4Entity> entity_list) {
		this.entity_list = entity_list;
	}

	
	
	
	
}
