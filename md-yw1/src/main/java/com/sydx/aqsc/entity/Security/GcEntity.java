package com.sydx.aqsc.entity.Security;

import java.util.Date;
import java.util.List;

public class GcEntity {
	private String name;
	private String type;
	private String xhtype;
	private Double amout;
	private String unit;
	private Double length;
	private Double depth;
	private String bz;
	private String create_user;
	private Date create_time;
	private String ip;
	private String oilfield;
	private String last_user;
	private Date last_time;

	private Integer spid;//工序id
	private Integer pdid;//工序id
	private String did;
	private String sgdyid;
	private Integer sgdyNo;
	private String spname;
	private String report_time;
	private String order_classes;
	private String yl;
	private String el;
	private String tab;
	private String kind;//类型
	private String part;//（1、作业准备 2、井筒部分 3、地面部分）

	private int r;
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private List<GcEntity> entityList;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
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

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
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

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
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

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
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

	public List<GcEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<GcEntity> entityList) {
		this.entityList = entityList;
	}

	public Double getAmout() {
		return amout;
	}

	public void setAmout(Double amout) {
		this.amout = amout;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public String getXhtype() {
		return xhtype;
	}

	public void setXhtype(String xhtype) {
		this.xhtype = xhtype;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}

	public String getOrder_classes() {
		return order_classes;
	}

	public void setOrder_classes(String order_classes) {
		this.order_classes = order_classes;
	}

	public String getSgdyid() {
		return sgdyid;
	}

	public void setSgdyid(String sgdyid) {
		this.sgdyid = sgdyid;
	}

	public Integer getSgdyNo() {
		return sgdyNo;
	}

	public void setSgdyNo(Integer sgdyNo) {
		this.sgdyNo = sgdyNo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}