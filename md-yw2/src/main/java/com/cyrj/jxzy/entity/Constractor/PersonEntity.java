package com.cyrj.jxzy.entity.Constractor;

import java.util.ArrayList;
import java.util.List;
import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "人员管理")
public class PersonEntity extends BaseEntity{
@ApiModelProperty(value="单位代码——对应组织机构id")
private String  dwdm; //单位代码——对应组织机构id
@ApiModelProperty(value="单位类别")
private String  dwlb; //单位类别
@ApiModelProperty(value="队伍代码——对应组织机构id")
private String  termid; //队伍代码——对应组织机构id
@ApiModelProperty(value="单位名称")
private String  dwmc; //单位名称
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
@ApiModelProperty(value="存储路径")
private String  fileuri2; //存储路径
@ApiModelProperty(value="文件原名称")
private String  fileoldname; //文件原名称
@ApiModelProperty(value="性别")
private String  xb; //性别
@ApiModelProperty(value="学历")
private String  xl; //学历
@ApiModelProperty(value="职称")
private String  zc; //职称
@ApiModelProperty(value="井控证有效期——开始时间")
private String kssjs;//井控证有效期——开始时间
@ApiModelProperty(value="井控证有效期——截止时间")
private String jzsjs;//井控证有效期——截止时间
@ApiModelProperty(value="录入人")
private String  lrr; //录入人
@ApiModelProperty(value="人员id")
private  String ryid;//人员id
@ApiModelProperty(value="序号")
private  String xh;
@ApiModelProperty(value="手机号")
private  String phone;//手机号
@ApiModelProperty(value="省")
private  String province;//省
@ApiModelProperty(value="市")
private  String city;//市
@ApiModelProperty(value="县、区")
private  String counties;//县、区
@ApiModelProperty(value="乡、镇、街道")
private  String town;//乡、镇、街道
@ApiModelProperty(value="村、屯、小区")
private  String village;//村、屯、小区
@ApiModelProperty(value="人员编号")
private  String num;//人员编号
@ApiModelProperty(value="地址")
private String address;//地址
private Integer printnum;
private String state;
//确定数据类型，set&get
private String fileFileName;
private String fileContentType;
private String pxsj;
private String oilfield;
private List<PersonEntity> person_entityList;
@ApiModelProperty(value="实体集合")
public List el=new ArrayList();//实体集合
	@Override
	public List getEl() {
		return el;
	}

	@Override
	public void setEl(List el) {
		this.el = el;
	}

public String getOilfield() {
	return oilfield;
}
public void setOilfield(String oilfield) {
	this.oilfield = oilfield;
}
public List<PersonEntity> getPerson_entityList() {
	return person_entityList;
}
public void setPerson_entityList(List<PersonEntity> person_entityList) {
	this.person_entityList = person_entityList;
}
@ApiModelProperty(value="人员模板编号")
private String rymb_id;//人员模板编号

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
public String getTermname() {
	return termname;
}
public void setTermname(String termname) {
	this.termname = termname;
}
public String getDwmc() {
	return dwmc;
}
public void setDwmc(String dwmc) {
	this.dwmc = dwmc;
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
public String getFileoldname() {
	return fileoldname;
}
public void setFileoldname(String fileoldname) {
	this.fileoldname = fileoldname;
}
public String getXb() {
	return xb;
}
public void setXb(String xb) {
	this.xb = xb;
}
public String getXl() {
	return xl;
}
public void setXl(String xl) {
	this.xl = xl;
}
public String getZc() {
	return zc;
}
public void setZc(String zc) {
	this.zc = zc;
}
public String getFileFileName() {
	return fileFileName;
}
public void setFileFileName(String fileFileName) {
	this.fileFileName = fileFileName;
}
public String getFileContentType() {
	return fileContentType;
}
public void setFileContentType(String fileContentType) {
	this.fileContentType = fileContentType;
}
public String getRyid() {
	return ryid;
}
public void setRyid(String ryid) {
	this.ryid = ryid;
}
public String getXh() {
	return xh;
}
public void setXh(String xh) {
	this.xh = xh;
}
public String getFileuri2() {
	return fileuri2;
}
public void setFileuri2(String fileuri2) {
	this.fileuri2 = fileuri2;
}
public String getKssjs() {
	return kssjs;
}
public void setKssjs(String kssjs) {
	this.kssjs = kssjs;
}
public String getJzsjs() {
	return jzsjs;
}
public void setJzsjs(String jzsjs) {
	this.jzsjs = jzsjs;
}
public String getDwlb() {
	return dwlb;
}
public void setDwlb(String dwlb) {
	this.dwlb = dwlb;
}
public String getRymb_id() {
	return rymb_id;
}
public void setRymb_id(String rymb_id) {
	this.rymb_id = rymb_id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCounties() {
	return counties;
}
public void setCounties(String counties) {
	this.counties = counties;
}
public String getTown() {
	return town;
}
public void setTown(String town) {
	this.town = town;
}
public String getVillage() {
	return village;
}
public void setVillage(String village) {
	this.village = village;
}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

	public Integer getPrintnum() {
		return printnum;
	}

	public void setPrintnum(Integer printnum) {
		this.printnum = printnum;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public String getPxsj() {
		return pxsj;
	}

	public void setPxsj(String pxsj) {
		this.pxsj = pxsj;
	}
}
