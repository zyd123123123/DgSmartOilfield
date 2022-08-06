package com.cyrj.jxzy.entity.Constractor;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "井控设备")
public class JksbEntity extends BaseEntity {
	@ApiModelProperty(value="设备id")
	private String jksbid;//设备id
	@ApiModelProperty(value="油田")
	private String oilfield;//油田
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="单位名称")
	private String dwmc;//单位名称
	@ApiModelProperty(value="序号")
	private String xh;//序号
	@ApiModelProperty(value="设备自编号")
	private String sbbh;//设备自编号
	@ApiModelProperty(value="设备名称")
	private String sbmc;//设备名称
	@ApiModelProperty(value="型号")
	private String sbxh;//型号
	@ApiModelProperty(value="压力级别")
	private String yljb;//压力级别
	@ApiModelProperty(value="检测有效期——开始日期")
	private String ksrq;//检测有效期——开始日期
	@ApiModelProperty(value="检测有效期——截止日期")
	private String jzrq;//检测有效期——截止日期
	@ApiModelProperty(value="生产厂家")
	private String sccj;//生产厂家
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
	private String fileurl;
	private String fileurl2;//
	private String filename;
	private String[] fileFileName;
	private String arr;	
	private List<JksbEntity> entity_list;
	public String getJksbid() {
		return jksbid;
	}
	public void setJksbid(String jksbid) {
		this.jksbid = jksbid;
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
	public String getSbxh() {
		return sbxh;
	}
	public void setSbxh(String sbxh) {
		this.sbxh = sbxh;
	}
	public String getYljb() {
		return yljb;
	}
	public void setYljb(String yljb) {
		this.yljb = yljb;
	}

	public String getKsrq() {
		return ksrq;
	}
	public void setKsrq(String ksrq) {
		this.ksrq = ksrq;
	}
	public String getJzrq() {
		return jzrq;
	}
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		this.sccj = sccj;
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
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public String getFileurl2() {
		return fileurl2;
	}
	public void setFileurl2(String fileurl2) {
		this.fileurl2 = fileurl2;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String[] getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public List<JksbEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<JksbEntity> entity_list) {
		this.entity_list = entity_list;
	}
	@Override
	public String toString() {
		return "JksbEntity [jksbid=" + jksbid + ", oilfield=" + oilfield
				+ ", dwdm=" + dwdm + ", dwmc=" + dwmc + ", xh=" + xh
				+ ", sbbh=" + sbbh + ", sbmc=" + sbmc + ", sbxh=" + sbxh
				+ ", yljb=" + yljb + ", ksrq=" + ksrq + ", jzrq=" + jzrq
				+ ", sccj=" + sccj + ", state=" + state + ", lrr=" + lrr
				+ ", lrsj=" + lrsj + ", lrsjs=" + lrsjs + ", shr=" + shr
				+ ", shsj=" + shsj + ", shsjs=" + shsjs + ", fileurl="
				+ fileurl + ", fileurl2=" + fileurl2 + ", filename=" + filename
			 + ", fileFileName="
				+ Arrays.toString(fileFileName) + ", arr=" + arr
				+ ", entity_list=" + entity_list + "]";
	}

	

}
