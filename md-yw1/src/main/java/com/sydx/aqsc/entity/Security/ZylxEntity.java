package com.sydx.aqsc.entity.Security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "作业类型")
public class ZylxEntity {
	@ApiModelProperty(value="施工id")
	public Integer row_num;
	@ApiModelProperty(value="施工id")
	private  String oilfield;
	@ApiModelProperty(value="施工id")
	private Integer id;//措施id
	@ApiModelProperty(value="施工id")
	private String csid;//措施id
	@ApiModelProperty(value="施工id")
	private String jb;//井别（油井、水井）
	@ApiModelProperty(value="施工id")
	private String yl;//措施一类
	@ApiModelProperty(value="施工id")
	private String el;//措施二类
	@ApiModelProperty(value="措施san类")
	private String sl;//
	@ApiModelProperty(value="措施类型（地质、工程）")
	private String lx;//
	@ApiModelProperty(value="默认为1   0废除 1使用")
	private String tab;//
	@ApiModelProperty(value="作业类型")
	private String zylx;//
	@ApiModelProperty(value="查询条件")
	public String whc;
	@ApiModelProperty(value="结束行")
	public Integer endRow;//
	@ApiModelProperty(value="开始行")
	public Integer startRow;//
	private List<ZylxEntity>entity_list;
	@ApiModelProperty(value="录入人")
	public String create_user;
	@ApiModelProperty(value="修改人")
	public String last_user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
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



	public void setEl(String el) {
		this.el = el;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getZylx() {
		return zylx;
	}

	public void setZylx(String zylx) {
		this.zylx = zylx;
	}


	public List<ZylxEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<ZylxEntity> entity_list) {
		this.entity_list = entity_list;
	}

	public String getEl() {
		return el;
	}

	public String getWhc() {
		return whc;
	}

	public void setWhc(String whc) {
		this.whc = whc;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
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
}
