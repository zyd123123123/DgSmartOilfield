package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "设备统计")
public class SbtjEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="单位名称")
	private String dwmc;//单位名称
	@ApiModelProperty(value="单位简称")
	private String unitname;//单位简称
	@ApiModelProperty(value="单位名称")
	private String dwlb;//单位名称
	@ApiModelProperty(value="主要设备数量")
	private int zysb;//主要设备数量
	@ApiModelProperty(value="井控设备数量")
	private int jksb;//井控设备数量
	@ApiModelProperty(value="环保设备数量")
	private int hbsb;//环保设备数量
	@ApiModelProperty(value="附属设备数量")
	private int fssb;//附属设备数量
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
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getDwlb() {
		return dwlb;
	}
	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}
	public int getZysb() {
		return zysb;
	}
	public void setZysb(int zysb) {
		this.zysb = zysb;
	}
	public int getJksb() {
		return jksb;
	}
	public void setJksb(int jksb) {
		this.jksb = jksb;
	}
	public int getHbsb() {
		return hbsb;
	}
	public void setHbsb(int hbsb) {
		this.hbsb = hbsb;
	}
	public int getFssb() {
		return fssb;
	}
	public void setFssb(int fssb) {
		this.fssb = fssb;
	}

	
	
	

}
