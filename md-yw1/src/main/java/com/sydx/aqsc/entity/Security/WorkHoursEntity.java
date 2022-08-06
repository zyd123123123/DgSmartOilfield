package com.sydx.aqsc.entity.Security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
@ApiModel(value = "工序工时类")
public class WorkHoursEntity {
 @ApiModelProperty(value="id")
private Integer  id; //id
 @ApiModelProperty(value="工序id")
private Integer  spid; //工序id
 @ApiModelProperty(value="工序名称")
private String  spname; //工序名称
 @ApiModelProperty(value="油田")
private String  oilfield; //油田
 @ApiModelProperty(value="标准工时")
private Double  working_hours; //标准工时
 @ApiModelProperty(value="标准用时")
private Double  use_hours; //标准用时
 @ApiModelProperty(value="工序系数")
private Double  coefficient; //工序系数
 @ApiModelProperty(value="单位名称")
private String  unit_name; //单位名称
 @ApiModelProperty(value="单位id")
private String  unit_id; //单位id
 private List<WorkHoursEntity> EntityList =new ArrayList<WorkHoursEntity>();
 public List el=new ArrayList();//实体集合

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public Integer getSpid() {
  return spid;
 }

 public void setSpid(Integer spid) {
  this.spid = spid;
 }

 public String getSpname() {
  return spname;
 }

 public void setSpname(String spname) {
  this.spname = spname;
 }

 public String getOilfield() {
  return oilfield;
 }

 public void setOilfield(String oilfield) {
  this.oilfield = oilfield;
 }

 public Double getWorking_hours() {
  return working_hours;
 }

 public void setWorking_hours(Double working_hours) {
  this.working_hours = working_hours;
 }

 public Double getUse_hours() {
  return use_hours;
 }

 public void setUse_hours(Double use_hours) {
  this.use_hours = use_hours;
 }

 public Double getCoefficient() {
  return coefficient;
 }

 public void setCoefficient(Double coefficient) {
  this.coefficient = coefficient;
 }

 public String getUnit_name() {
  return unit_name;
 }

 public void setUnit_name(String unit_name) {
  this.unit_name = unit_name;
 }

 public String getUnit_id() {
  return unit_id;
 }

 public void setUnit_id(String unit_id) {
  this.unit_id = unit_id;
 }

 public List<WorkHoursEntity> getEntityList() {
  return EntityList;
 }

 public void setEntityList(List<WorkHoursEntity> entityList) {
  EntityList = entityList;
 }

 public List getEl() {
  return el;
 }

 public void setEl(List el) {
  this.el = el;
 }
}
