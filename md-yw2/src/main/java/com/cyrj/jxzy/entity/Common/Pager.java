package com.cyrj.jxzy.entity.Common;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value = "分页类")
public class Pager implements Serializable {
	@ApiModelProperty(value="页码",required = true)
	private int pageNo;
	@ApiModelProperty(value="每页行数",required = true)
	private int pageSize;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Pager [pageNo=" + pageNo + ", pageSize=" + pageSize + ", getPageNo()=" + getPageNo()
				+ ", getPageSize()=" + getPageSize() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
