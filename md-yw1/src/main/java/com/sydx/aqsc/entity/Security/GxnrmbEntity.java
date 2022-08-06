package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "工序施工内容模板")
public class GxnrmbEntity extends BaseEntity {

	@ApiModelProperty(value="油田")
	private String oilfield;
	@ApiModelProperty(value="录入人")
	private  String create_user;//录入人
	@ApiModelProperty(value="修改人")
	private  String last_user;//修改人
	@ApiModelProperty(value="ip")
	private String ip;
	@ApiModelProperty(value="标准工序ID")
	private Integer spid;//
	@ApiModelProperty(value="工序名称")
	private String spname;//工序名称
	@ApiModelProperty(value="自定义模板id")
	private String customid;//自定义模板id
	@ApiModelProperty(value="自定义模板名称")
	private String customname;//自定义模板名称
	@ApiModelProperty(value="施工内容")
	private String buildcontent;//施工内容
	@ApiModelProperty(value="施工内容")
	private  String buildcontentTMP;//施工内容
	@ApiModelProperty(value="要求")
	private  String requirement;//要求
	@ApiModelProperty(value="模板权限pc、pc0dq、pc0dq003")
	private String customtype;//模板权限pc、pc0dq、pc0dq003
	@ApiModelProperty(value="1正常，0废除")
	private String state;//1正常，0废除
	@ApiModelProperty(value="基础工序id")
	private  String circuit_id;//基础工序id
	@ApiModelProperty(value="类别：1班报模板，2设计模板")
	private String tab;//类别：1班报模板，2设计模板
	@ApiModelProperty(value="施工单元id")
	private String sgdyid;//施工单元id
	@ApiModelProperty(value="施工单元名称")
	private String sgdymc;//施工单元名称
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getCustomid() {
		return customid;
	}
	public void setCustomid(String customid) {
		this.customid = customid;
	}
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}
	public String getBuildcontent() {
		return buildcontent;
	}
	public void setBuildcontent(String buildcontent) {
		this.buildcontent = buildcontent;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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

	public String getLast_user() {
		return last_user;
	}

	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}

	public String getCircuit_id() {
		return circuit_id;
	}

	public void setCircuit_id(String circuit_id) {
		this.circuit_id = circuit_id;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getBuildcontentTMP() {
		return buildcontentTMP;
	}

	public void setBuildcontentTMP(String buildcontentTMP) {
		this.buildcontentTMP = buildcontentTMP;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getSgdyid() {
		return sgdyid;
	}

	public void setSgdyid(String sgdyid) {
		this.sgdyid = sgdyid;
	}

	public String getSgdymc() {
		return sgdymc;
	}

	public void setSgdymc(String sgdymc) {
		this.sgdymc = sgdymc;
	}
}
