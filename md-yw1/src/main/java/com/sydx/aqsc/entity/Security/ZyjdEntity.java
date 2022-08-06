package com.sydx.aqsc.entity.Security;

public class ZyjdEntity {


	private String parentid;//父节点id
	private String termid;//队伍id
	private String termname;//队伍名称
	private String oper_project;//作业类型
	private String well_common_name;//井号
	private String did;//唯一标识
	private String starttime;//开工日期
	private String endtime;//开工日期
    
	private int spid;//工序id
	private int pdid;//工序id
	private String spname;//工序
	private String is_complete;//工序是否完成

	private String attribute;//数据权限
	private String search;//权限

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getTermname() {
		return termname;
	}
	public void setTermname(String termname) {
		this.termname = termname;
	}
	public String getOper_project() {
		return oper_project;
	}
	public void setOper_project(String oper_project) {
		this.oper_project = oper_project;
	}
	public String getWell_common_name() {
		return well_common_name;
	}
	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public int getPdid() {
		return pdid;
	}
	public void setPdid(int pdid) {
		this.pdid = pdid;
	}
	

	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(String is_complete) {
		this.is_complete = is_complete;
	}
	@Override
	public String toString() {
		return "ZyjddwEntity [parentid=" + parentid + ", termid=" + termid + ", termname=" + termname
				+ ", oper_project=" + oper_project + ", well_common_name=" + well_common_name + ", starttime="
				+ starttime + ", endtime=" + endtime + "]";
	}
	
	
}
