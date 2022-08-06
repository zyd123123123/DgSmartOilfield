package com.cyrj.jxzy.entity.Constractor;
import java.util.List;
import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "主要设备")
public class ZysbEntity extends BaseEntity{
	@ApiModelProperty(value="单位代码——对应组织机构id ")
private String  dwdm; //单位代码——对应组织机构id
	@ApiModelProperty(value="队伍代码——对应组织机构id")
private String  termid; //队伍代码——对应组织机构id
	@ApiModelProperty(value="企业名称 ")
private String  dwmc; //企业名称
	@ApiModelProperty(value="队伍名称")
private String  termname; //队伍名称
	@ApiModelProperty(value="型号及参数")
private String  xhjcs; //型号及参数
	@ApiModelProperty(value="制造厂家")
private String  zzcj; //制造厂家
	@ApiModelProperty(value="车牌号")
private String  cph; //车牌号
	@ApiModelProperty(value="识别码 ")
private String  sbm; //识别码
	@ApiModelProperty(value="存储路径 ")
private String  fileurl; //存储路径
	@ApiModelProperty(value="录入人 ")
private String  lrr; //录入人
	@ApiModelProperty(value="录入时间")
private String  lrsj; //录入时间
	@ApiModelProperty(value="投产日期")
private String  tcrq; //投产日期
//确定数据类型，set&get
	@ApiModelProperty(value="存储路径")
private String  fileurl2; //存储路径
	@ApiModelProperty(value="油田")
private String  oilfield;//油田
	@ApiModelProperty(value="主要设备id")
private String zysbid;//主要设备id
	@ApiModelProperty(value="设备标志")
private String sbbz;//设备标志
	@ApiModelProperty(value="设备")
private String sb;//设备
	@ApiModelProperty(value="投产日期string")
private String stcrq; //投产日期string
private List<ZysbEntity> entity_list;
private List<ZysbEntity> sb_entityList;

public String getStcrq() {
	return stcrq;
}
public void setStcrq(String stcrq) {
	this.stcrq = stcrq;
}
public String getSb() {
	return sb;
}
public void setSb(String sb) {
	this.sb = sb;
}
public String getSbbz() {
	return sbbz;
}
public void setSbbz(String sbbz) {
	this.sbbz = sbbz;
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
public String getXhjcs() {
	return xhjcs;
}
public void setXhjcs(String xhjcs) {
	this.xhjcs = xhjcs;
}
public String getZzcj() {
	return zzcj;
}
public void setZzcj(String zzcj) {
	this.zzcj = zzcj;
}
public String getCph() {
	return cph;
}
public void setCph(String cph) {
	this.cph = cph;
}
public String getSbm() {
	return sbm;
}
public void setSbm(String sbm) {
	this.sbm = sbm;
}
public String getFileurl() {
	return fileurl;
}
public void setFileurl(String fileurl) {
	this.fileurl = fileurl;
}
public String getLrr() {
	return lrr;
}
public void setLrr(String lrr) {
	this.lrr = lrr;
}
public String getFileurl2() {
	return fileurl2;
}
public void setFileurl2(String fileurl2) {
	this.fileurl2 = fileurl2;
}
public String getOilfield() {
	return oilfield;
}
public void setOilfield(String oilfield) {
	this.oilfield = oilfield;
}
public String getZysbid() {
	return zysbid;
}
public void setZysbid(String zysbid) {
	this.zysbid = zysbid;
}

public String getLrsj() {
	return lrsj;
}
public void setLrsj(String lrsj) {
	this.lrsj = lrsj;
}
public String getTcrq() {
	return tcrq;
}
public void setTcrq(String tcrq) {
	this.tcrq = tcrq;
}
public List<ZysbEntity> getEntity_list() {
	return entity_list;
}
public void setEntity_list(List<ZysbEntity> entity_list) {
	this.entity_list = entity_list;
}
@Override
public String toString() {
	return "ZysbEntity [dwdm=" + dwdm + ", termid=" + termid + ", dwmc=" + dwmc
			+ ", termname=" + termname + ", xhjcs=" + xhjcs + ", zzcj=" + zzcj
			+ ", cph=" + cph + ", sbm=" + sbm + ", fileurl=" + fileurl
			+ ", lrr=" + lrr + ", lrsj=" + lrsj + ", fileurl2=" + fileurl2
			+ ", oilfield=" + oilfield + ", zysbid=" + zysbid + "]";
}
public List<ZysbEntity> getSb_entityList() {
	return sb_entityList;
}
public void setSb_entityList(List<ZysbEntity> sb_entityList) {
	this.sb_entityList = sb_entityList;
}


}
