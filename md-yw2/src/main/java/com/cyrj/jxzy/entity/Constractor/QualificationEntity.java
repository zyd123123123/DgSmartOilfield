package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "准入证管理")
public class
QualificationEntity extends BaseEntity{
	@ApiModelProperty(value="id")
	private Integer  id; //null
	@ApiModelProperty(value="单位类别")
	private String  dwlb; //单位类别
	@ApiModelProperty(value="编号")
	private String  bh; //编号
	@ApiModelProperty(value="企业名称")
	private String  qymc; //企业名称
	@ApiModelProperty(value="经理")
	private String  jl; //经理
	@ApiModelProperty(value="电话")
	private Integer  dh; //电话
	@ApiModelProperty(value="队伍名称")
	private String  dwmc; //队伍名称
	@ApiModelProperty(value="队伍资质证号")
	private String  dwzzbh; //队伍资质证号
	@ApiModelProperty(value="型号")
	private String  xh; //型号
	@ApiModelProperty(value="车辆识别号")
	private String  clsbh; //车辆识别号
	@ApiModelProperty(value="投产日期")
	private Date  dcrq; //投产日期
	@ApiModelProperty(value="生产厂家")
	private String  sccj; //生产厂家
	@ApiModelProperty(value="车牌号")
	private String  cph; //车牌号
	@ApiModelProperty(value="施工区域")
	private String  sgqy; //施工区域
	private String  sgxm; //null
	@ApiModelProperty(value="有效期1")
	private Date  yxq1; //有效期1
	@ApiModelProperty(value="发证部门")
	private String  ffbm; //发证部门
	@ApiModelProperty(value="资质设计id")
	private String  sjid; //资质设计id
	@ApiModelProperty(value="有效期2")
	private Date  yxq2; //有效期2
	@ApiModelProperty(value="复选框是否选中标记，空未选中，承包商合同信息创建页面使用")
	private String checkTab;//复选框是否选中标记，空未选中，承包商合同信息创建页面使用
	@ApiModelProperty(value="合同ID，承包商合同信息创建页面使用")
	private String contract_id;//合同ID，承包商合同信息创建页面使用
	@ApiModelProperty(value="单位id")
	private String dwdm;//单位id
	@ApiModelProperty(value="队伍id")
	private String termid;//队伍id
	private String fileuri;
//	private List<QualificationEntity> entity_q_list;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getJl() {
		return jl;
	}
	public void setJl(String jl) {
		this.jl = jl;
	}
	public Integer getDh() {
		return dh;
	}
	public void setDh(Integer dh) {
		this.dh = dh;
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
	public Date getDcrq() {
		return dcrq;
	}
	public void setDcrq(Date dcrq) {
		this.dcrq = dcrq;
	}
	public String getSccj() {
		return sccj;
	}
	public void setSccj(String sccj) {
		this.sccj = sccj;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	public String getSgqy() {
		return sgqy;
	}
	public void setSgqy(String sgqy) {
		this.sgqy = sgqy;
	}
	public String getSgxm() {
		return sgxm;
	}
	public void setSgxm(String sgxm) {
		this.sgxm = sgxm;
	}
	public Date getYxq1() {
		return yxq1;
	}
	public void setYxq1(Date yxq1) {
		this.yxq1 = yxq1;
	}
	public String getFfbm() {
		return ffbm;
	}
	public void setFfbm(String ffbm) {
		this.ffbm = ffbm;
	}
	public String getSjid() {
		return sjid;
	}
	public void setSjid(String sjid) {
		this.sjid = sjid;
	}
	public Date getYxq2() {
		return yxq2;
	}
	public void setYxq2(Date yxq2) {
		this.yxq2 = yxq2;
	}
	public String getCheckTab() {
		return checkTab;
	}
	public void setCheckTab(String checkTab) {
		this.checkTab = checkTab;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
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
	
	
	public String getFileuri() {
		return fileuri;
	}
	public void setFileuri(String fileuri) {
		this.fileuri = fileuri;
	}
//	public List<QualificationEntity> getEntity_q_list() {
//		return entity_q_list;
//	}
//	public void setEntity_q_list(List<QualificationEntity> entity_q_list) {
//		this.entity_q_list = entity_q_list;
//	}
	@Override
	public String toString() {
		return "QualificationEntity [id=" + id + ", dwlb=" + dwlb + ", bh="
				+ bh + ", qymc=" + qymc + ", jl=" + jl + ", dh=" + dh
				+ ", dwmc=" + dwmc + ", dwzzbh=" + dwzzbh + ", xh=" + xh
				+ ", clsbh=" + clsbh + ", dcrq=" + dcrq + ", sccj=" + sccj
				+ ", cph=" + cph + ", sgqy=" + sgqy + ", sgxm=" + sgxm
				+ ", yxq1=" + yxq1 + ", ffbm=" + ffbm + ", sjid=" + sjid
				+ ", yxq2=" + yxq2 + ", checkTab=" + checkTab
				+ ", contract_id=" + contract_id + ", dwdm=" + dwdm
				+ ", termid=" + termid + "]";
	}
	
}
