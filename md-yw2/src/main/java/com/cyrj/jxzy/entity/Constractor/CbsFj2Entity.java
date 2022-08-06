package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "能力评估附件类")
public class CbsFj2Entity extends BaseEntity{
	@ApiModelProperty(value="类别")
	private String  lb; //类别
	@ApiModelProperty(value="审查项目")
	private String  scxm; //审查项目
	@ApiModelProperty(value="审查主要内容")
	private String  sczynr; //审查主要内容
	@ApiModelProperty(value="审查结果（合格、不合格）")
	private String  scjg; //审查结果（合格、不合格）
	@ApiModelProperty(value="审查人签字")
	private String  scrqz; //审查人签字
	@ApiModelProperty(value="排序")
	private String  sort; //排序
	@ApiModelProperty(value="时间")
	private Date  datatime; //时间

	private List<CbsFj2Entity> entity_list;
	public String getLb() {
		return lb;
	}
	public void setLb(String lb) {
		this.lb = lb;
	}
	public String getScxm() {
		return scxm;
	}
	public void setScxm(String scxm) {
		this.scxm = scxm;
	}
	public String getSczynr() {
		return sczynr;
	}
	public void setSczynr(String sczynr) {
		this.sczynr = sczynr;
	}
	public String getScjg() {
		return scjg;
	}
	public void setScjg(String scjg) {
		this.scjg = scjg;
	}
	public String getScrqz() {
		return scrqz;
	}
	public void setScrqz(String scrqz) {
		this.scrqz = scrqz;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Date getDatatime() {
		return datatime;
	}
	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}
	
	public List<CbsFj2Entity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<CbsFj2Entity> entity_list) {
		this.entity_list = entity_list;
	}
	@Override
	public String toString() {
		return "CbsFj2Entity [lb=" + lb + ", scxm=" + scxm + ", sczynr="
				+ sczynr + ", scjg=" + scjg + ", scrqz=" + scrqz + ", sort="
				+ sort + ", datatime=" + datatime + "]";
	}


	
	

}
