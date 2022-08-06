package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "许可证")
public class XkzEntity extends BaseEntity{
	@ApiModelProperty(value="施工项目名称")
	private String sgxm;//施工项目名称
	@ApiModelProperty(value="经理（项目负责人）")
	private String jl;//经理（项目负责人）
	@ApiModelProperty(value="单队名称")
	private String dwmc;//单队名称
	@ApiModelProperty(value="单位代码")
	private String dwdm;//单位代码
	@ApiModelProperty(value="单位简称")
	private String unitname;//单位简称
	@ApiModelProperty(value="资质编号")
	private String dwzzbh;//资质编号
	@ApiModelProperty(value="队伍id")
	private String team_id;//队伍id
	@ApiModelProperty(value="队伍名称")
	private String termname;//队伍名称
	@ApiModelProperty(value="单位类别")
	private String dwlb;//单位类别
	@ApiModelProperty(value="编号")
	private String bh;//编号
	@ApiModelProperty(value="设备型号")
	private String xh;//设备型号
	@ApiModelProperty(value="车辆识别号")
	private String clsbh;//车辆识别号
	@ApiModelProperty(value="投产日期")
	private String dcrq;//投产日期
	@ApiModelProperty(value="车牌号")
	private String cph;//车牌号
	@ApiModelProperty(value="资质设计id")
	private String sjid;//资质设计id
	@ApiModelProperty(value="电话")
	private String dh;//电话
	@ApiModelProperty(value="发证部门")
	private String ffbm;//发证部门
	@ApiModelProperty(value="施工区域")
	private String sgqy;//施工区域
	public String getSgxm() {
		return sgxm;
	}
	public void setSgxm(String sgxm) {
		this.sgxm = sgxm;
	}
	public String getJl() {
		return jl;
	}
	public void setJl(String jl) {
		this.jl = jl;
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
	public String getDwzzbh() {
		return dwzzbh;
	}
	public void setDwzzbh(String dwzzbh) {
		this.dwzzbh = dwzzbh;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTermname() {
		return termname;
	}
	public void setTermname(String termname) {
		this.termname = termname;
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
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getClsbh() {
		return clsbh;
	}
	public void setClsbh(String clsbh) {
		this.clsbh = clsbh;
	}
	public String getDcrq() {
		return dcrq;
	}
	public void setDcrq(String dcrq) {
		this.dcrq = dcrq;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getSjid() {
		return sjid;
	}
	public void setSjid(String sjid) {
		this.sjid = sjid;
	}
	public String getDh() {
		return dh;
	}
	public void setDh(String dh) {
		this.dh = dh;
	}
	public String getFfbm() {
		return ffbm;
	}
	public void setFfbm(String ffbm) {
		this.ffbm = ffbm;
	}
	public String getSgqy() {
		return sgqy;
	}
	public void setSgqy(String sgqy) {
		this.sgqy = sgqy;
	}
	@Override
	public String toString() {
		return "XkzEntity [sgxm=" + sgxm + ", jl=" + jl + ", dwmc=" + dwmc
				+ ", dwdm=" + dwdm + ", unitname=" + unitname + ", dwzzbh="
				+ dwzzbh + ", team_id=" + team_id + ", termname=" + termname
				+ ", dwlb=" + dwlb + ", bh=" + bh + ", xh=" + xh + ", clsbh="
				+ clsbh + ", dcrq=" + dcrq + ", cph=" + cph + ", sjid=" + sjid
				+ ", dh=" + dh + ", ffbm=" + ffbm + ", sgqy=" + sgqy + "]";
	}

}
