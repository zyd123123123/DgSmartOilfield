package com.cyrj.jxzy.entity.Constractor;

import java.io.Serializable;
import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "组织机构")
public class PcUnitEntity extends BaseEntity {
	@ApiModelProperty(value="id")
	private String id; // id
	@ApiModelProperty(value="父id")
	private String parentid; // 父id
	@ApiModelProperty(value="单位名称")
	private String unitname; // 单位名称
	@ApiModelProperty(value="油田名称")
	private String oilfield; // 油田名称
	@ApiModelProperty(value="单位性质，内部，外部")
	private String uniteproperty; // 单位性质，内部，外部
	@ApiModelProperty(value="1、机关单位，2、科研单位，3、生产单位，4、作业单位")
	private String uniteproperty1; // 1、机关单位，2、科研单位，3、生产单位，4、作业单位
	@ApiModelProperty(value="父节点名称")
	private String parentname; // 父节点名称
	@ApiModelProperty(value="油田id")
	private String org_id; // 油田id
	@ApiModelProperty(value="父id")
	private String parent_id; // 父id
	private String dq_id;
	@ApiModelProperty(value="序号")
	private Integer order_id; // 序号
	@ApiModelProperty(value="油田等级")
	private Integer org_level; // 油田等级
	private String qualification_id;
	
	private String a5dep_id;
	private String where_condition;
	
	private Integer idlength;
	
	//关联字段
	private String cyc;
	private String cyk;
	private String cyd;
	private int glrbxs;
	private int rbxs;
	private String rqhdng;
	private String cycdm;
	private String zyd;
	private String zydd;
	private String cycmc;
	private String key;
	private String value;
	
	
	
	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getCycmc() {
		return cycmc;
	}



	public void setCycmc(String cycmc) {
		this.cycmc = cycmc;
	}



	public String getZyd() {
		return zyd;
	}



	public void setZyd(String zyd) {
		this.zyd = zyd;
	}



	public String getZydd() {
		return zydd;
	}



	public void setZydd(String zydd) {
		this.zydd = zydd;
	}



	public String getCycdm() {
		return cycdm;
	}



	public void setCycdm(String cycdm) {
		this.cycdm = cycdm;
	}



	public String getRqhdng() {
		return rqhdng;
	}



	public void setRqhdng(String rqhdng) {
		this.rqhdng = rqhdng;
	}



	public int getGlrbxs() {
		return glrbxs;
	}



	public void setGlrbxs(int glrbxs) {
		this.glrbxs = glrbxs;
	}



	public int getRbxs() {
		return rbxs;
	}



	public void setRbxs(int rbxs) {
		this.rbxs = rbxs;
	}



	public String getQualification_id() {
		return qualification_id;
	}



	public void setQualification_id(String qualification_id) {
		this.qualification_id = qualification_id;
	}

	public String getDq_id() {
		return dq_id;
	}

	public void setDq_id(String dq_id) {
		this.dq_id = dq_id;
	}

	public String getA5dep_id() {
		return a5dep_id;
	}

	public void setA5dep_id(String a5dep_id) {
		this.a5dep_id = a5dep_id;
	}

	public Integer getIdlength() {
		return idlength;
	}

	public void setIdlength(Integer idlength) {
		this.idlength = idlength;
	}

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
	

	public String getCyc() {
		return cyc;
	}

	public void setCyc(String cyc) {
		this.cyc = cyc;
	}

	public String getCyk() {
		return cyk;
	}

	public void setCyk(String cyk) {
		this.cyk = cyk;
	}

	public String getCyd() {
		return cyd;
	}

	public void setCyd(String cyd) {
		this.cyd = cyd;
	}

	@Override
	public String toString() {
		return "PcUnitEntity [id=" + id + ", parentid=" + parentid + ", unitname=" + unitname + ", oilfield=" + oilfield
				+ ", uniteproperty=" + uniteproperty + ", uniteproperty1=" + uniteproperty1 + ", parentname="
				+ parentname + ", org_id=" + org_id + ", parent_id=" + parent_id + ", order_id=" + order_id
				+ ", org_level=" + org_level + ", a5dep_id=" + a5dep_id + ", row_num=" + row_num + ", endRow=" + endRow
				+ ", startRow=" + startRow + ", where_condition=" + where_condition + ", idlength=" + idlength + "]";
	}

}
