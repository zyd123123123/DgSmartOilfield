package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "许可证设备绑定")
public class Xkz_sbEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="单位代码")
	private String dwdm; //单位代码
	@ApiModelProperty(value="单位名称")
	private String dwmc; //单位名称
	@ApiModelProperty(value="队伍代码")
	private String termid;//队伍代码
	@ApiModelProperty(value="队伍名称")
	private String termname;//队伍名称
	@ApiModelProperty(value="设备id")
	private String sbid;//设备id
	@ApiModelProperty(value="设备编号")
	private String sbbh;//设备编号
	@ApiModelProperty(value="设备名称")
	private String sbmc;//设备名称
	@ApiModelProperty(value="日期（井控设备：有效截止日期，环保、附属设备：投产日期）")
	private String rq;//日期（井控设备：有效截止日期，环保、附属设备：投产日期）
	@ApiModelProperty(value="其他（井控设备：设备型号，环保设备：生产厂家，附属设备：车牌号）")
	private String qt;//其他（井控设备：设备型号，环保设备：生产厂家，附属设备：车牌号）
	@ApiModelProperty(value="tab 1代表井控设备，2代表环保设备，3代表附属设备")
	private String tab;//tab 1代表井控设备，2代表环保设备，3代表附属设备
	@ApiModelProperty(value="录入人")
	private String lrr;//录入人
	@ApiModelProperty(value="录入时间")
	private String lrsj;//录入时间
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getDwdm() {
		return dwdm;
	}
	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getTermname() {
		return termname;
	}
	public void setTermname(String termname) {
		this.termname = termname;
	}
	public String getSbid() {
		return sbid;
	}
	public void setSbid(String sbid) {
		this.sbid = sbid;
	}
	public String getSbbh() {
		return sbbh;
	}
	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}
	public String getSbmc() {
		return sbmc;
	}
	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}
	public String getRq() {
		return rq;
	}
	public void setRq(String rq) {
		this.rq = rq;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	@Override
	public String toString() {
		return "Xkz_sbEntity [oilfield=" + oilfield + ", dwdm=" + dwdm
				+ ", dwmc=" + dwmc + ", termid=" + termid + ", termname="
				+ termname + ", sbid=" + sbid + ", sbbh=" + sbbh + ", sbmc="
				+ sbmc + ", rq=" + rq + ", qt=" + qt + ", tab=" + tab
				+ ", lrr=" + lrr + ", lrsj=" + lrsj + "]";
	}
	
}
