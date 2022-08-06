package com.sydx.aqsc.entity.Admin;

import java.util.List;

public class BaseEntity {

	private int pageNo;
	private int pageSize;
	private long totalRows;
	private int row_id;
	public String qx;
	public int endRow;//结束行
	public int startRow;//开始行
	public int row_num;
	public List el;//实体集合
	public int is;
	public String whc;
	public String parm;//参数传递
	public String ord;
	public String create_user;
	public String oilfield;
	public String create_time;
	public String ip;
	public String last_user;
	public String last_time;
	//session字段
	private String attribute;
	private String search;
	private  String username;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public int getRow_id() {
		return row_id;
	}

	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}

	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
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
	public int getRow_num() {
		return row_num;
	}
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	public List getEl() {
		return el;
	}
	public void setEl(List el) {
		this.el = el;
	}
	public int getIs() {
		return is;
	}
	public void setIs(int is) {
		this.is = is;
	}
	public String getWhc() {
		return whc;
	}
	public void setWhc(String whc) {
		this.whc = whc;
	}
	public String getParm() {
		return parm;
	}
	public void setParm(String parm) {
		this.parm = parm;
	}
	public String getOrd() {
		return ord;
	}
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
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

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "BaseEntity [qx=" + qx + ", endRow=" + endRow + ", startRow=" + startRow + ", row_num=" + row_num
				+ ", el=" + el + ", is=" + is + ", whc=" + whc + ", parm=" + parm + ", ord=" + ord + ", attribute="
				+ attribute + ", search=" + search + "]";
	}

	
}
