package com.cyrj.jxzy.entity.Constractor;

import java.util.List;
import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "队伍人员类")
public class DwryEntity extends BaseEntity{
	@ApiModelProperty(value="null")
private String  yrid; //null
	@ApiModelProperty(value="资质设计id")
private String  sjid; //资质设计id
	@ApiModelProperty(value="企业名称")
private String  dwmc; //企业名称
	@ApiModelProperty(value="队伍名称")
private String  termname; //队伍名称
	@ApiModelProperty(value="队伍资质证号")
private String  dwzzbh; //队伍资质证号
	@ApiModelProperty(value="岗位")
private String  gw; //岗位
	@ApiModelProperty(value="姓名")
private String  xm; //姓名
	@ApiModelProperty(value="身份证号")
private String  sfzh; //身份证号
	@ApiModelProperty(value="井控证编号")
private String  jkzbh; //井控证编号
	@ApiModelProperty(value="存储路径")
private String  fileuri; //存储路径

private String  fileuri2;
	@ApiModelProperty(value="存储路径")
private String  xh; //存储路径
	@ApiModelProperty(value="录入人")
private String  lrr; //存储路径

//确定数据类型，set&get 

private List<DwryEntity> person_entityList;

public List<DwryEntity> getPerson_entityList() {
	return person_entityList;
}
public void setPerson_entityList(List<DwryEntity> person_entityList) {
	this.person_entityList = person_entityList;
}
public String getYrid() {
	return yrid;
}
public String getFileuri2() {
	return fileuri2;
}
public void setFileuri2(String fileuri2) {
	this.fileuri2 = fileuri2;
}
public void setYrid(String yrid) {
	this.yrid = yrid;
}
public String getSjid() {
	return sjid;
}
public void setSjid(String sjid) {
	this.sjid = sjid;
}
public String getDwmc() {
	return dwmc;
}
public void setDwmc(String dwmc) {
	this.dwmc = dwmc;
}
public String getTermname() {
	return termname;
}
public void setTermname(String termname) {
	this.termname = termname;
}
public String getDwzzbh() {
	return dwzzbh;
}
public void setDwzzbh(String dwzzbh) {
	this.dwzzbh = dwzzbh;
}
public String getGw() {
	return gw;
}
public void setGw(String gw) {
	this.gw = gw;
}
public String getXm() {
	return xm;
}
public void setXm(String xm) {
	this.xm = xm;
}
public String getSfzh() {
	return sfzh;
}
public void setSfzh(String sfzh) {
	this.sfzh = sfzh;
}
public String getJkzbh() {
	return jkzbh;
}
public void setJkzbh(String jkzbh) {
	this.jkzbh = jkzbh;
}
public String getFileuri() {
	return fileuri;
}
public void setFileuri(String fileuri) {
	this.fileuri = fileuri;
}
public String getXh() {
	return xh;
}
public void setXh(String xh) {
	this.xh = xh;
}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
}
