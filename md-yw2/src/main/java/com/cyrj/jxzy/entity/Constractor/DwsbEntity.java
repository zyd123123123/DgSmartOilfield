package com.cyrj.jxzy.entity.Constractor;


import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "队伍绑定设备类")
public class DwsbEntity extends BaseEntity{
	@ApiModelProperty(value="主要设备id")
private String  zysbid; //主要设备id
	@ApiModelProperty(value="资质设计id")
private String  sjid; //资质设计id
	@ApiModelProperty(value="单位名称")
private String  dwmc; //单位名称
	@ApiModelProperty(value="队伍名称")
private String  termname; //队伍名称
	@ApiModelProperty(value="型号及参数")
private String  xhjcs; //型号及参数
	@ApiModelProperty(value="制造厂家")
private String  zzcj; //制造厂家
	@ApiModelProperty(value="车牌号")
private String  cph; //车牌号
	@ApiModelProperty(value="设备码")
private String  sbm; //设备码
	@ApiModelProperty(value="图片上传路径")
private String  fileurl; //图片上传路径
	@ApiModelProperty(value="图片上传路径")
private String  fileurl2; //图片上传路径
	@ApiModelProperty(value="设备一二")
private String  sb; //设备一二
	@ApiModelProperty(value="设备标志")
private String  sbbz; //设备标志
	@ApiModelProperty(value="队伍资质编号")
private String  dwzzbh; //队伍资质编号

//确定数据类型，set&get
	@ApiModelProperty(value="图片上传路径")
private String  fileurl21; //图片上传路径
	@ApiModelProperty(value="图片上传路径")
private String  fileurl22; //图片上传路径
private List<DwsbEntity> sb_entityList;


public List<DwsbEntity> getSb_entityList() {
	return sb_entityList;
}
public void setSb_entityList(List<DwsbEntity> sb_entityList) {
	this.sb_entityList = sb_entityList;
}
public String getFileurl21() {
	return fileurl21;
}
public void setFileurl21(String fileurl21) {
	this.fileurl21 = fileurl21;
}
public String getFileurl22() {
	return fileurl22;
}
public void setFileurl22(String fileurl22) {
	this.fileurl22 = fileurl22;
}
public String getZysbid() {
	return zysbid;
}
public String getFileurl2() {
	return fileurl2;
}
public void setFileurl2(String fileurl2) {
	this.fileurl2 = fileurl2;
}
public void setZysbid(String zysbid) {
	this.zysbid = zysbid;
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
public String getDwzzbh() {
	return dwzzbh;
}
public void setDwzzbh(String dwzzbh) {
	this.dwzzbh = dwzzbh;
}


}

