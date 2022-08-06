package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "附件管理类")
public class FjglEntity extends BaseEntity {

	@ApiModelProperty(value="油田",hidden=true)
	private String oilfield;//油田
	@ApiModelProperty(value="附件id")
	private String id;//附件id
	@ApiModelProperty(value="附件名称")
	private String annex_name;//附件名称
	@ApiModelProperty(value="父级id")
	private String parent_id;//父级id
	@ApiModelProperty(value="父级名称")
	private String parent_name;//父级名称
	@ApiModelProperty(value="序号",hidden=true)
	private String num;//序号
	@ApiModelProperty(value="录入人",hidden=true)
	private String lrr;//录入人
	@ApiModelProperty(value="录入时间",hidden=true)
	private String lrsj;//录入时间

	private List el;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAnnex_name() {
		return annex_name;
	}
	public void setAnnex_name(String annex_name) {
		this.annex_name = annex_name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getLrr() {
		return lrr;
	}
	public void setLrr(String lrr) {
		this.lrr = lrr;
	}
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

	public List getEl() {
		return el;
	}

	public void setEl(List el) {
		this.el = el;
	}
}
