package com.sydx.aqsc.entity.Admin;

import java.io.Serializable;

public class PcUnitEntity implements Serializable {//组织机构表
	private String id;
	private String parentid;
	private String username;
	private String unitname;
	private String oilfield;
	private String uniteproperty;
	private String uniteproperty1;
	private String uniteproperty2;
	private String parentname;
	private String org_id;
	private String parent_id;
	private Integer order_id;
	private Integer org_level;
	private Long a5dep_id;
	private String contrast_id;
	 
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private String search;
	private String attribute;
	private String org3_name;
	private String org3_id;
	private String sjqx;
	private String flag;
	private String whc;
	private String where_condition;
	
	public String getWhere_condition() {
		return where_condition;
	}

	public void setWhere_condition(String where_condition) {
		this.where_condition = where_condition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getUniteproperty() {
		return uniteproperty;
	}

	public void setUniteproperty(String uniteproperty) {
		this.uniteproperty = uniteproperty;
	}

	public String getUniteproperty1() {
		return uniteproperty1;
	}

	public void setUniteproperty1(String uniteproperty1) {
		this.uniteproperty1 = uniteproperty1;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getOrg_id() {
		return org_id;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getOrg_level() {
		return org_level;
	}

	public void setOrg_level(Integer org_level) {
		this.org_level = org_level;
	}

	public Long getA5dep_id() {
		return a5dep_id;
	}

	public void setA5dep_id(Long a5dep_id) {
		this.a5dep_id = a5dep_id;
	}

	public String getContrast_id() {
		return contrast_id;
	}

	public void setContrast_id(String contrast_id) {
		this.contrast_id = contrast_id;
	}

	 

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getUniteproperty2() {
		return uniteproperty2;
	}

	public void setUniteproperty2(String uniteproperty2) {
		this.uniteproperty2 = uniteproperty2;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getOrg3_name() {
		return org3_name;
	}

	public void setOrg3_name(String org3_name) {
		this.org3_name = org3_name;
	}

	public String getOrg3_id() {
		return org3_id;
	}

	public void setOrg3_id(String org3_id) {
		this.org3_id = org3_id;
	}

	public String getSjqx() {
		return sjqx;
	}

	public void setSjqx(String sjqx) {
		this.sjqx = sjqx;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWhc() {
		return whc;
	}

	public void setWhc(String whc) {
		this.whc = whc;
	}

	@Override
	public String toString() {
		return "PcUnitEntity [id=" + id + ", parentid=" + parentid + ", unitname=" + unitname + ", oilfield=" + oilfield
				+ ", uniteproperty=" + uniteproperty + ", uniteproperty1=" + uniteproperty1 + ", parentname="
				+ parentname + ", org_id=" + org_id + ", parent_id=" + parent_id + ", order_id=" + order_id
				+ ", org_level=" + org_level + ", a5dep_id=" + a5dep_id + ", contrast_id=" + contrast_id + ", row_num="
				+ row_num + ", endRow=" + endRow + ", startRow=" + startRow + ", where_condition=" + where_condition
				+ "]";
	}

 



}
