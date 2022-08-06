package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "队伍资质")
public class DwzzEntity extends BaseEntity{
	@ApiModelProperty(value="备用",hidden = true)
private String  reserve1; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  reserve2; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  reserve3; //备用
	@ApiModelProperty(value="资质设计id")
private String  sjid; //资质设计id
	@ApiModelProperty(value="企业名称")
private String  dwmc; //企业名称
	@ApiModelProperty(value="企业代码")
private String  dwdm; //企业代码
	@ApiModelProperty(value="企业简称")
private String  unitname; //企业简称
	@ApiModelProperty(value="队伍名称")
private String  termname; //队伍名称
	@ApiModelProperty(value="队伍id")
private String  termid; //队伍id
	@ApiModelProperty(value="单位类别")
private String  dwlb; //单位类别
	@ApiModelProperty(value="编号")
private String  bh; //编号
	@ApiModelProperty(value="队伍资质证号")
private String  dwzzbh; //队伍资质证号
	@ApiModelProperty(value="经理")
private String  jl; //经理
	@ApiModelProperty(value="电话")
private String  dh;
	@ApiModelProperty(value="有效期1")
private String  yxq1; //有效期1
	@ApiModelProperty(value="有效期2")
private String  yxq2; //有效期2
	@ApiModelProperty(value="发证部门")
private String  ffbm; //发证部门
	@ApiModelProperty(value="施工项目")
private String  sgxm;
	@ApiModelProperty(value="施工区域")
private String  sgqy; //施工区域
	@ApiModelProperty(value="队伍资质等级")
private String  dwzzdj; //队伍资质等级
	@ApiModelProperty(value="备用",hidden = true)
private String  bz; //备注
	@ApiModelProperty(value="备用",hidden = true)
private String  by3; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by4; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by5; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by6; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by7; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by8; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by9; //备用
	@ApiModelProperty(value="备用",hidden = true)
private String  by10; //备用
	@ApiModelProperty(value="审核标记：0，5退回、1待审核(申请)、2通过、3待审核(换证)、4过期  0初次申请退回 5换证退回")
private String  audit_tab; //审核标记：0，5退回、1待审核(申请)、2通过、3待审核(换证)、4过期  0初次申请退回 5换证退回
	@ApiModelProperty(value="录入人")
private String  lrr; //录入人
	@ApiModelProperty(value="录入时间")
private String  lrsj; //录入时间
	@ApiModelProperty(value="审核人")
private String  shr; //审核人
	@ApiModelProperty(value="审核时间")
private String  shsj; //审核时间
	@ApiModelProperty(value="作废标识，0作废，1或空正常")
private String  abolish_tab; //作废标识，0作废，1或空正常

//确定数据类型，set&get
	@ApiModelProperty(value="有效期1")
private String  syxq1; //有效期1
	@ApiModelProperty(value="有效期2")
private String  syxq2; //有效期2
	@ApiModelProperty(value="单位类别id")
private String  dwlbid;
	@ApiModelProperty(value="年份")
private String  year;
	@ApiModelProperty(value="油田")
private String  oilfield;
	@ApiModelProperty(value="队伍人员信息")
private List<PersonEntity> person_entityList;
	@ApiModelProperty(value="队伍设备信息")
private List<ZysbEntity> sb_entityList;
	@ApiModelProperty(value="parentid")
private String  parentid;


public String getOilfield() {
	return oilfield;
}
public void setOilfield(String oilfield) {
	this.oilfield = oilfield;
}
public String getParentid() {
	return parentid;
}
public void setParentid(String parentid) {
	this.parentid = parentid;
}
public List<PersonEntity> getPerson_entityList() {
	return person_entityList;
}
public void setPerson_entityList(List<PersonEntity> person_entityList) {
	this.person_entityList = person_entityList;
}
public List<ZysbEntity> getSb_entityList() {
	return sb_entityList;
}
public void setSb_entityList(List<ZysbEntity> sb_entityList) {
	this.sb_entityList = sb_entityList;
}
public String getDwlbid() {
	return dwlbid;
}
public void setDwlbid(String dwlbid) {
	this.dwlbid = dwlbid;
}
public String getBz() {
	return bz;
}
public void setBz(String bz) {
	this.bz = bz;
}
public String getReserve1() {
	return reserve1;
}
public void setReserve1(String reserve1) {
	this.reserve1 = reserve1;
}
public String getReserve2() {
	return reserve2;
}
public void setReserve2(String reserve2) {
	this.reserve2 = reserve2;
}
public String getReserve3() {
	return reserve3;
}
public void setReserve3(String reserve3) {
	this.reserve3 = reserve3;
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
public String getDwdm() {
	return dwdm;
}
public void setDwdm(String dwdm) {
	this.dwdm = dwdm;
}
public String getUnitname() {
	return unitname;
}
public void setUnitname(String unitname) {
	this.unitname = unitname;
}
public String getTermname() {
	return termname;
}
public void setTermname(String termname) {
	this.termname = termname;
}
public String getTermid() {
	return termid;
}
public void setTermid(String termid) {
	this.termid = termid;
}
public String getDwlb() {
	return dwlb;
}
public void setDwlb(String dwlb) {
	this.dwlb = dwlb;
}
public String getBh() {
	return bh;
}
public void setBh(String bh) {
	this.bh = bh;
}
public String getDwzzbh() {
	return dwzzbh;
}
public void setDwzzbh(String dwzzbh) {
	this.dwzzbh = dwzzbh;
}
public String getJl() {
	return jl;
}
public void setJl(String jl) {
	this.jl = jl;
}
public String getDh() {
	return dh;
}
public void setDh(String dh) {
	this.dh = dh;
}

	public String getYxq1() {
		return yxq1;
	}

	public void setYxq1(String yxq1) {
		this.yxq1 = yxq1;
	}

	public String getYxq2() {
		return yxq2;
	}

	public void setYxq2(String yxq2) {
		this.yxq2 = yxq2;
	}

	public String getFfbm() {
	return ffbm;
}
public void setFfbm(String ffbm) {
	this.ffbm = ffbm;
}
public String getSgxm() {
	return sgxm;
}
public void setSgxm(String sgxm) {
	this.sgxm = sgxm;
}
public String getSgqy() {
	return sgqy;
}
public void setSgqy(String sgqy) {
	this.sgqy = sgqy;
}
public String getBy3() {
	return by3;
}
public void setBy3(String by3) {
	this.by3 = by3;
}
public String getBy4() {
	return by4;
}
public void setBy4(String by4) {
	this.by4 = by4;
}
public String getBy5() {
	return by5;
}
public void setBy5(String by5) {
	this.by5 = by5;
}
public String getBy6() {
	return by6;
}
public void setBy6(String by6) {
	this.by6 = by6;
}
public String getBy7() {
	return by7;
}
public void setBy7(String by7) {
	this.by7 = by7;
}
public String getBy8() {
	return by8;
}
public void setBy8(String by8) {
	this.by8 = by8;
}
public String getBy9() {
	return by9;
}
public void setBy9(String by9) {
	this.by9 = by9;
}
public String getBy10() {
	return by10;
}
public void setBy10(String by10) {
	this.by10 = by10;
}
public String getAudit_tab() {
	return audit_tab;
}
public void setAudit_tab(String audit_tab) {
	this.audit_tab = audit_tab;
}
public String getLrr() {
	return lrr;
}
public void setLrr(String lrr) {
	this.lrr = lrr;
}
public String getShr() {
	return shr;
}
public void setShr(String shr) {
	this.shr = shr;
}

	public String getLrsj() {
		return lrsj;
	}

	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

	public String getShsj() {
		return shsj;
	}

	public void setShsj(String shsj) {
		this.shsj = shsj;
	}

	public String getDwzzdj() {
	return dwzzdj;
}
public void setDwzzdj(String dwzzdj) {
	this.dwzzdj = dwzzdj;
}
public String getSyxq1() {
	return syxq1;
}
public void setSyxq1(String syxq1) {
	this.syxq1 = syxq1;
}
public String getSyxq2() {
	return syxq2;
}
public void setSyxq2(String syxq2) {
	this.syxq2 = syxq2;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getAbolish_tab() {
	return abolish_tab;
}
public void setAbolish_tab(String abolish_tab) {
	this.abolish_tab = abolish_tab;
}

}
