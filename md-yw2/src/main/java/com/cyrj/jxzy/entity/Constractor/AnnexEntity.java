package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "附件管理类")
public class AnnexEntity extends BaseEntity{
	@ApiModelProperty(value="附录表id")
private String  annex_id; //附录表id
	@ApiModelProperty(value="附录表名称")
private String  annex_name; //附录表名称
	@ApiModelProperty(value="id")
private Integer  id; //id
	@ApiModelProperty(value="代码")
private String  code; //代码
	@ApiModelProperty(value="名称")
private String  name; //名称
	@ApiModelProperty(value="油田",hidden = true)
private String  oilfield; //油田
	@ApiModelProperty(value="录入人 ",hidden = true)
private String  login_people; //录入人
	@ApiModelProperty(value="录入时间",hidden = true)
private Date  login_time; //录入时间
	@ApiModelProperty(value="录入单位",hidden = true)
private String  unit; //录入单位
	@ApiModelProperty(value="录入单位",hidden = true)
private String  ids;//String类型id

//确定数据类型，set&get 
public String getAnnex_id() {
	return annex_id;
}
public void setAnnex_id(String annex_id) {
	this.annex_id = annex_id;
}
public String getAnnex_name() {
	return annex_name;
}
public void setAnnex_name(String annex_name) {
	this.annex_name = annex_name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getOilfield() {
	return oilfield;
}
public void setOilfield(String oilfield) {
	this.oilfield = oilfield;
}
public String getLogin_people() {
	return login_people;
}
public void setLogin_people(String login_people) {
	this.login_people = login_people;
}
public Date getLogin_time() {
	return login_time;
}
public void setLogin_time(Date login_time) {
	this.login_time = login_time;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getIds() {
	return ids;
}
public void setIds(String ids) {
	this.ids = ids;
}

}
