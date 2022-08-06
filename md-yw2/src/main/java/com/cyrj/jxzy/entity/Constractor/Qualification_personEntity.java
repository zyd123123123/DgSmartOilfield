package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "准入证人员信息")
public class Qualification_personEntity extends BaseEntity{
	@ApiModelProperty(value="人员id")
	private String yrid;//人员id
	@ApiModelProperty(value="资质设计id")
	private String sjid;//资质设计id
	@ApiModelProperty(value="单位名称")
	private String dwmc;//单位名称
	@ApiModelProperty(value="队伍名称")
	private String termname;//队伍名称
	@ApiModelProperty(value="队伍资质证号")
	private String dwzzbh;//队伍资质证号
	@ApiModelProperty(value="岗位")
	private String gw;//岗位
	@ApiModelProperty(value="姓名")
	private String xm;//姓名
	@ApiModelProperty(value="身份证号")
	private String sfzh;//身份证号
	@ApiModelProperty(value="井控证编号")
	private String jkzbh;//井控证编号
	@ApiModelProperty(value="存储路径")
	private String fileuri;//存储路径
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="队伍id")
	private String termid;//队伍id

	public String getYrid() {
		return yrid;
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
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	@Override
	public String toString() {
		return "Qualification_personEntity [yrid=" + yrid + ", sjid=" + sjid
				+ ", dwmc=" + dwmc + ", termname=" + termname + ", dwzzbh="
				+ dwzzbh + ", gw=" + gw + ", xm=" + xm + ", sfzh=" + sfzh
				+ ", jkzbh=" + jkzbh + ", fileuri=" + fileuri + ", dwdm="
				+ dwdm + ", termid=" + termid + "]";
	}
	
	
}
