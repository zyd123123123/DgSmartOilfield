package com.cyrj.jxzy.entity.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "施工监督检查照片类")
public class SgjdjcUploadEntity extends BaseEntity{

	private String oilfield;
	private String imgid;
	@ApiModelProperty(value="检查记录id")
	private String jcid;//检查记录id
	@ApiModelProperty(value="检查项目一类")
	private String jcxm1;//检查项目一类
	@ApiModelProperty(value="检查项目二类")
	private String jcxm2;//检查项目二类
	@ApiModelProperty(value="检查项目三类")
	private String jcxm3;//检查项目三类
	@ApiModelProperty(value="url路径")
	private String fileuri;//url路径
	@ApiModelProperty(value="文件原名称")
	private String fileoldname;//文件原名称
	@ApiModelProperty(value="标记1检查照片、2承包商整改回复照片，3、复查照片")
	private String tab;//标记1检查照片、2承包商整改回复照片，3、复查照片
	@ApiModelProperty(value="录入人")
	private String inperson;//录入人
	@ApiModelProperty(value="录入时间")
	private String intime;//录入时间
	private List<SgjdjcUploadEntity> entity_list;
	public String getImgid() {
		return imgid;
	}
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getJcxm1() {
		return jcxm1;
	}
	public void setJcxm1(String jcxm1) {
		this.jcxm1 = jcxm1;
	}
	public String getJcxm2() {
		return jcxm2;
	}
	public void setJcxm2(String jcxm2) {
		this.jcxm2 = jcxm2;
	}
	public String getJcxm3() {
		return jcxm3;
	}
	public void setJcxm3(String jcxm3) {
		this.jcxm3 = jcxm3;
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
	public List<SgjdjcUploadEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<SgjdjcUploadEntity> entity_list) {
		this.entity_list = entity_list;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getInperson() {
		return inperson;
	}
	public void setInperson(String inperson) {
		this.inperson = inperson;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	
	
	
}
