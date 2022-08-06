package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.BaseEntity;

import java.util.ArrayList;
import java.util.List;


public class SgmbdzEntity extends BaseEntity {

	private String templateid;//模板id
	private String templatename;//模板名称
	private String purpose;//用途
	private String tab;//1标准2自定义
	private String tabs;//1标准2自定义
	private String is_use;//1使用0废除
	
	private int csid;//作业类型id
	private int sort;//序号
	private int spid;//工序id
	private String  spname;//工序名称
	private String  oilfield; // 油田
	private String create_user; // 录入人
	private String create_time; // 录入时间
	private String ip;//ip
	private String last_user;//修改人
	private String last_time;//修改时间
	private double working_hours;//标准工时
	private double use_hours;//标准用时
	private double coefficient;//工序系数
	private  String customtype;//模板权限pc、pc0dq、pc0dq003
	private List<SgmbdzEntity> entity_list =new ArrayList<SgmbdzEntity>();
	
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getTemplatename() {
		return templatename;
	}
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getIs_use() {
		return is_use;
	}
	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}

	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSpid() {
		return spid;
	}

	public void setSpid(int spid) {
		this.spid = spid;
	}

	public double getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(double working_hours) {
		this.working_hours = working_hours;
	}

	public double getUse_hours() {
		return use_hours;
	}

	public void setUse_hours(double use_hours) {
		this.use_hours = use_hours;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public List<SgmbdzEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<SgmbdzEntity> entity_list) {
		this.entity_list = entity_list;
	}
	public String getTabs() {
		return tabs;
	}
	public void setTabs(String tabs) {
		this.tabs = tabs;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLast_user() {
		return last_user;
	}

	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}
}
