package com.cyrj.jxzy.entity.Admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "通用属性类")
public class BaseEntity {

	@ApiModelProperty(value="权限",hidden=true)
	public String qx;
	@ApiModelProperty(value="结束行",hidden=true)
	public int endRow;//结束行
	@ApiModelProperty(value="开始行",hidden=true)
	public int startRow;//开始行
	@ApiModelProperty(value="行号",hidden=true)
	public int row_num;
	@ApiModelProperty(value="实体集合",hidden=true)
	public List el;//实体集合
	@ApiModelProperty(value="is",hidden=true)
	public int is;
	@ApiModelProperty(value="查询条件",hidden=true)
	public String whc;
	@ApiModelProperty(value="参数",hidden=true)
	public String parm;//参数传递
	@ApiModelProperty(value="ord",hidden=true)
	public String ord;
	@ApiModelProperty(value="创建人",hidden=true)
	public String create_user;
	@ApiModelProperty(value="油田",hidden=true)
	public String oilfield;
	@ApiModelProperty(value="创建时间",hidden=true)
	public String create_time;
	@ApiModelProperty(value="ip",hidden=true)
	public String ip;
	@ApiModelProperty(value="修改人",hidden=true)
	public String last_user;
	@ApiModelProperty(value="修改时间",hidden=true)
	public String last_time;
	//session字段
	@ApiModelProperty(value="单位属性",hidden=true)
	private String attribute;
	@ApiModelProperty(value="数据权限",hidden=true)
	private String search;
	@ApiModelProperty(value="用户名",hidden=true)
	private  String username;
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
