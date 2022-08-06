package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 措施
 * @author admin
 *
 */
@ApiModel(value = "措施类型")
public class MeasureEntity extends BaseEntity {
	@ApiModelProperty(value="油田")
	private String oilfield;//
	@ApiModelProperty(value="措施id")
	private String id;//措施id
	@ApiModelProperty(value="父id")
	private String parentid;//父id
	@ApiModelProperty(value="措施名称")
	private String name;//措施名称
	@ApiModelProperty(value="排序")
	private String orderid;//排序
	@ApiModelProperty(value="父级名称")
	private String parentname;//父级名称
	@ApiModelProperty(value="老的措施id1")
	private String code1;//老的措施id1
	@ApiModelProperty(value="老的措施id2")
	private String code2;//老的措施id2
	@ApiModelProperty(value="对照id")
	private String contrast_id;//对照id
	@ApiModelProperty(value="是否选中")
	private String checked;//是否选中

	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public String getContrast_id() {
		return contrast_id;
	}
	public void setContrast_id(String contrast_id) {
		this.contrast_id = contrast_id;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
}
