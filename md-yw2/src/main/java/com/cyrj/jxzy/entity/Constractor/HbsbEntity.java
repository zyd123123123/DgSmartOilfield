package com.cyrj.jxzy.entity.Constractor;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "环保设备")
public class HbsbEntity extends BaseEntity{
	@ApiModelProperty(value="环保设备id")
	private String hbsbid;//环保设备id
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="单位名称")
	private String dwmc;//单位名称
	@ApiModelProperty(value="序号")
	private String xh;//序号
	@ApiModelProperty(value="设备名称")
	private String sbmc;//设备名称
	@ApiModelProperty(value="设备编号")
	private String sbbh;//设备编号
	@ApiModelProperty(value="投产日期")
	private String tcrq;//投产日期
	@ApiModelProperty(value="生产厂家")
	private String sccj;//生产厂家
	@ApiModelProperty(value="备注")
	private String bz;//备注
	@ApiModelProperty(value="状态：0退回，1待审核，2通过")
	private String state;//状态：0退回，1待审核，2通过
	@ApiModelProperty(value="录入人")
	private String lrr;//录入人
	@ApiModelProperty(value="录入时间")
	private String lrsj;//录入时间
	@ApiModelProperty(value="录入时间")
	private String lrsjs;//录入时间
	@ApiModelProperty(value="审核人")
	private String shr;//审核人
	@ApiModelProperty(value="审核时间")
	private String shsj;//审核时间
	@ApiModelProperty(value="审核时间")
	private String shsjs;//审核时间
	private String[] fileFileName;
	private String fileurl;
	private String filename;
	private String arr;
	private String fileurl2;
	
	private List<HbsbEntity> entity_list;

	public String getHbsbid() {
		return hbsbid;
	}

	public void setHbsbid(String hbsbid) {
		this.hbsbid = hbsbid;
	}

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

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getSbmc() {
		return sbmc;
	}

	public void setSbmc(String sbmc) {
		this.sbmc = sbmc;
	}

	public String getSbbh() {
		return sbbh;
	}

	public void setSbbh(String sbbh) {
		this.sbbh = sbbh;
	}


	public String getSccj() {
		return sccj;
	}

	public void setSccj(String sccj) {
		this.sccj = sccj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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


	public String getLrsjs() {
		return lrsjs;
	}

	public void setLrsjs(String lrsjs) {
		this.lrsjs = lrsjs;
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

	public String getShsjs() {
		return shsjs;
	}

	public void setShsjs(String shsjs) {
		this.shsjs = shsjs;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileurl() {
		return fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getFileurl2() {
		return fileurl2;
	}

	public void setFileurl2(String fileurl2) {
		this.fileurl2 = fileurl2;
	}

	public List<HbsbEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<HbsbEntity> entity_list) {
		this.entity_list = entity_list;
	}

	public String getTcrq() {
		return tcrq;
	}

	public void setTcrq(String tcrq) {
		this.tcrq = tcrq;
	}

	@Override
	public String toString() {
		return "HbsbEntity [hbsbid=" + hbsbid + ", oilfield=" + oilfield
				+ ", dwdm=" + dwdm + ", dwmc=" + dwmc + ", xh=" + xh
				+ ", sbmc=" + sbmc + ", sbbh=" + sbbh + ", tcrq=" + tcrq
				+ ", sccj=" + sccj + ", bz=" + bz + ", state=" + state
				+ ", lrr=" + lrr + ", lrsj=" + lrsj + ", lrsjs=" + lrsjs
				+ ", shr=" + shr + ", shsj=" + shsj + ", shsjs=" + shsjs
				 + ", fileFileName="
				+ Arrays.toString(fileFileName) + ", fileurl=" + fileurl
				+ ", filename=" + filename + ", arr=" + arr + ", fileurl2="
				+ fileurl2 + ", entity_list=" + entity_list + "]";
	}


	
	
}
