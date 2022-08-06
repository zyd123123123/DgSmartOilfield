package com.sydx.aqsc.entity.Security;

import java.util.Date;
import java.util.List;

public class SgbzEntity {
	private String sgid;
	private String name;
	private String create_user;
	private Date create_time;
	private String create_times;
	private String ip;
	private String oilfield;
	private String last_user;
	private Date last_time;
	
	private String well_common_name;
	private String did;
	private String jb;
	private String csid;
	private String templateid;
	private String yl;
	private String el;

	private int r;
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行

	private String search;//数据权限
	private String attribute;//数据属性：1作业，2非作业（生产、设计、机关）
	private String zyq;//作业区
	private String platform_id;//平台号
	private String team_name;//施工队伍
	private String intelligence_code;//施工资质
	private String jsdw;//建设单位
	private String work_content;//作业类型
	private String assignment_date;//搬家计划下达时间

	private List<SgbzEntity> entityList;
	
	
	public String getSgid() {
		return sgid;
	}
	public void setSgid(String sgid) {
		this.sgid = sgid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getLast_user() {
		return last_user;
	}
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
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
	public List<SgbzEntity> getEntityList() {
		return entityList;
	}
	public void setEntityList(List<SgbzEntity> entityList) {
		this.entityList = entityList;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public String getJb() {
		return jb;
	}
	public void setJb(String jb) {
		this.jb = jb;
	}
	public String getYl() {
		return yl;
	}
	public void setYl(String yl) {
		this.yl = yl;
	}
	public String getEl() {
		return el;
	}
	public void setEl(String el) {
		this.el = el;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getTemplateid() {
		return templateid;
	}
	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}
	public String getWell_common_name() {
		return well_common_name;
	}
	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}

	public String getZyq() {
		return zyq;
	}

	public void setZyq(String zyq) {
		this.zyq = zyq;
	}

	public String getPlatform_id() {
		return platform_id;
	}

	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getIntelligence_code() {
		return intelligence_code;
	}

	public void setIntelligence_code(String intelligence_code) {
		this.intelligence_code = intelligence_code;
	}

	public String getJsdw() {
		return jsdw;
	}

	public void setJsdw(String jsdw) {
		this.jsdw = jsdw;
	}

	public String getWork_content() {
		return work_content;
	}

	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}

	public String getAssignment_date() {
		return assignment_date;
	}

	public void setAssignment_date(String assignment_date) {
		this.assignment_date = assignment_date;
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

	public String getCreate_times() {
		return create_times;
	}

	public void setCreate_times(String create_times) {
		this.create_times = create_times;
	}
}