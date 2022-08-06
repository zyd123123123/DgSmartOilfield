package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "人员信息变更")
public class Person_changeEntity extends BaseEntity{
	@ApiModelProperty(value="变更id")
	private String bg_id;//变更id
	private String oilfield;
	private String ryid;
	@ApiModelProperty(value="姓名")
	private String  xm; //姓名
	@ApiModelProperty(value="身份证号")
	private String  sfzh; //身份证号
	@ApiModelProperty(value="单位代码——对应组织机构id")
	private String  dwdm_old; //单位代码——对应组织机构id
	@ApiModelProperty(value="单位名称 ")
	private String  dwmc_old; //单位名称
	@ApiModelProperty(value="单位代码——对应组织机构id")
	private String  dwdm_new; //单位代码——对应组织机构id
	@ApiModelProperty(value="单位名称")
	private String  dwmc_new; //单位名称
	@ApiModelProperty(value="申请人")
	private String apply_person;//申请人
	@ApiModelProperty(value="申请时间")
	private String apply_time;//申请时间
	@ApiModelProperty(value="审核人")
	private String audit_person;//审核人
	@ApiModelProperty(value="审核时间")
	private String audit_time;//审核时间
	@ApiModelProperty(value="审核状态")
	private String audit_tab;//审核状态
	@ApiModelProperty(value="审核原因")
	private String audit_reason;//审核原因
	@ApiModelProperty(value="证明材料扫描件标识0没有1有")
	private String filetab;//证明材料扫描件标识0没有1有
	@ApiModelProperty(value="图片路径")
	private String fileurl;//图片路径
	private String filetype;
	@ApiModelProperty(value="井控证编号")
	private String  jkzbh; //井控证编号
	@ApiModelProperty(value="性别")
	private String  xb; //性别
	@ApiModelProperty(value="学历")
	private String  xl; //学历
	@ApiModelProperty(value="职称")
	private String  zc; //职称
	@ApiModelProperty(value="培训时间")
	private Date  pxsj; //培训时间
	@ApiModelProperty(value="井控证有效期——开始时间")
	private Date kssj;//井控证有效期——开始时间
	@ApiModelProperty(value="井控证有效期——截止时间")
	private Date jzsj;//井控证有效期——截止时间
	@ApiModelProperty(value="井控证有效期——开始时间")
	private String kssjs;//井控证有效期——开始时间
	@ApiModelProperty(value="井控证有效期——截止时间")
	private String jzsjs;//井控证有效期——截止时间
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
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
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
	public String getDwdm_old() {
		return dwdm_old;
	}
	public void setDwdm_old(String dwdm_old) {
		this.dwdm_old = dwdm_old;
	}
	public String getDwmc_old() {
		return dwmc_old;
	}
	public void setDwmc_old(String dwmc_old) {
		this.dwmc_old = dwmc_old;
	}
	public String getDwdm_new() {
		return dwdm_new;
	}
	public void setDwdm_new(String dwdm_new) {
		this.dwdm_new = dwdm_new;
	}
	public String getDwmc_new() {
		return dwmc_new;
	}
	public void setDwmc_new(String dwmc_new) {
		this.dwmc_new = dwmc_new;
	}
	public String getApply_person() {
		return apply_person;
	}
	public void setApply_person(String apply_person) {
		this.apply_person = apply_person;
	}
	public String getApply_time() {
		return apply_time;
	}
	public void setApply_time(String apply_time) {
		this.apply_time = apply_time;
	}
	public String getAudit_person() {
		return audit_person;
	}
	public void setAudit_person(String audit_person) {
		this.audit_person = audit_person;
	}
	public String getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(String audit_time) {
		this.audit_time = audit_time;
	}
	public String getAudit_tab() {
		return audit_tab;
	}
	public void setAudit_tab(String audit_tab) {
		this.audit_tab = audit_tab;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getAudit_reason() {
		return audit_reason;
	}
	public void setAudit_reason(String audit_reason) {
		this.audit_reason = audit_reason;
	}
	public String getFiletab() {
		return filetab;
	}
	public void setFiletab(String filetab) {
		this.filetab = filetab;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public String getBg_id() {
		return bg_id;
	}
	public void setBg_id(String bg_id) {
		this.bg_id = bg_id;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getJkzbh() {
		return jkzbh;
	}
	public void setJkzbh(String jkzbh) {
		this.jkzbh = jkzbh;
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
	public Date getPxsj() {
		return pxsj;
	}
	public void setPxsj(Date pxsj) {
		this.pxsj = pxsj;
	}
	public Date getKssj() {
		return kssj;
	}
	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}
	public Date getJzsj() {
		return jzsj;
	}
	public void setJzsj(Date jzsj) {
		this.jzsj = jzsj;
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
	
	
}
