package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;

import java.util.List;

public class SgdygjclEntity extends BaseEntity {

	private String did;
	private String well_common_name;
	private String toolid; // 工具材料id
	private Integer spid; // 工序id
	private Integer pdid;//工序id
	private String spname;
	private String sgdymc;//施工单元名称
	private String sgdyid;//施工单元名称
	private String sgdylb;//施工单元类别
	private Integer xh;
	private String bzhsg;//工具材料分类
	private String tool_name;//工具名称
	private String model;//型号规格
	private String unit;//计量单位
	private Integer numb; //数量
	private String product_unit;//生产厂家
	private String prepare_unit; //准备单位
	private String note;//数量
	
	private List<SgdygjclEntity>entityList ;

	public Integer getSpid() {
		return spid;
	}
	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	public void setXh(Integer xh) {
		this.xh = xh;
	}
	public String getSgdymc() {
		return sgdymc;
	}
	public void setSgdymc(String sgdymc) {
		this.sgdymc = sgdymc;
	}
	public String getSgdylb() {
		return sgdylb;
	}
	public void setSgdylb(String sgdylb) {
		this.sgdylb = sgdylb;
	}
	public String getBzhsg() {
		return bzhsg;
	}
	public void setBzhsg(String bzhsg) {
		this.bzhsg = bzhsg;
	}
	public String getTool_name() {
		return tool_name;
	}
	public void setTool_name(String tool_name) {
		this.tool_name = tool_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getNumb() {
		return numb;
	}
	public void setNumb(Integer numb) {
		this.numb = numb;
	}
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	public String getPrepare_unit() {
		return prepare_unit;
	}
	public void setPrepare_unit(String prepare_unit) {
		this.prepare_unit = prepare_unit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public Integer getXh() {
		return xh;
	}
	public List<SgdygjclEntity> getEntityList() {
		return entityList;
	}
	public void setEntityList(List<SgdygjclEntity> entityList) {
		this.entityList = entityList;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getWell_common_name() {
		return well_common_name;
	}
	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}
	public String getToolid() {
		return toolid;
	}
	public void setToolid(String toolid) {
		this.toolid = toolid;
	}
	public Integer getPdid() {
		return pdid;
	}
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}
	public String getSgdyid() {
		return sgdyid;
	}
	public void setSgdyid(String sgdyid) {
		this.sgdyid = sgdyid;
	}

	
	
	
}
