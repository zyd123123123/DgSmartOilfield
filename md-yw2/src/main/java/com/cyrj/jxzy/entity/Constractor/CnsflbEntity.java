package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "承诺书附件类")
public class CnsflbEntity extends BaseEntity{
	@ApiModelProperty(value="HSE承诺书内容")
	private String  content; //HSE承诺书内容
	@ApiModelProperty(value="排序")
	private String  sort; //排序
	@ApiModelProperty(value="时间")
	private Date  datatime; //时间

	private List<CnsflbEntity> entity_list;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	
	public List<CnsflbEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<CnsflbEntity> entity_list) {
		this.entity_list = entity_list;
	}
	@Override
	public String toString() {
		return "CnsflbEntity [content=" + content + ", sort=" + sort + ", datatime=" + datatime + ", qx=" + qx
				+ ", endRow=" + endRow + ", startRow=" + startRow + ", row_num=" + row_num + ", el=" + el + ", is=" + is
				+ ", whc=" + whc + ", parm=" + parm + ", ord=" + ord + ", getContent()=" + getContent() + ", getSort()="
				+ getSort() + ", getDatatime()=" + getDatatime() + ", getQx()=" + getQx() + ", getEndRow()="
				+ getEndRow() + ", getStartRow()=" + getStartRow() + ", getRow_num()=" + getRow_num() + ", getEl()="
				+ getEl() + ", getIs()=" + getIs() + ", getWhc()=" + getWhc() + ", getParm()=" + getParm()
				+ ", getOrd()=" + getOrd() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
