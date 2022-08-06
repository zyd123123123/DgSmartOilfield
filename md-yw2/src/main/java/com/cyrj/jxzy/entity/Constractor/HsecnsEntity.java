package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HSE承诺书")
public class HsecnsEntity extends BaseEntity{
	@ApiModelProperty(value="合同id")
    private String 	contract_id;//合同id
	@ApiModelProperty(value="打印时间")
    private Date 	print_date;//打印时间
	@ApiModelProperty(value="打印时间")
    private String 	print_dates;//打印时间
	@ApiModelProperty(value="打印人")
    private String 	print_person;//打印人
	@ApiModelProperty(value="文件上传路径")
    private String 	upload_file_path; //文件上传路径
	@ApiModelProperty(value="文件上传时间")
    private Date 	upload_date;//文件上传时间
	@ApiModelProperty(value="文件上传时间")
    private String 	upload_dates;//文件上传时间
	@ApiModelProperty(value="文件上传人")
    private String 	upload_person;//文件上传人
	@ApiModelProperty(value="承包商名称")
    private String 	contractor_name;//承包商名称
	@ApiModelProperty(value="施工项目 ")
    private String 	construction_project;//施工项目
	@ApiModelProperty(value="甲方单位名称")
    private String 	unit_name;//甲方单位名称
	@ApiModelProperty(value="甲方单位id")
    private String 	unit_id;//甲方单位id
	@ApiModelProperty(value="承包商id")
    private String 	contractor_id;//承包商id
	@ApiModelProperty(value="合同名称")
    private String  contract_name;//合同名称
	@ApiModelProperty(value="合同编号")
    private String  contract_number;//合同编号
	@ApiModelProperty(value="合同生效日期")
    private Date 	effective_date;//合同生效日期
	@ApiModelProperty(value="合同生效日期")
    private String 	effective_dates;//合同生效日期
	@ApiModelProperty(value="合同生效日期——日")
    private String 	date;//合同生效日期——日
	@ApiModelProperty(value="合同生效日期——月")
    private String 	month;//合同生效日期——月
	@ApiModelProperty(value="合同生效日期——年")
    private String 	year;//合同生效日期——年
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getPrint_dates() {
		return print_dates;
	}
	public void setPrint_dates(String print_dates) {
		this.print_dates = print_dates;
	}
	public String getPrint_person() {
		return print_person;
	}
	public void setPrint_person(String print_person) {
		this.print_person = print_person;
	}
	public String getUpload_file_path() {
		return upload_file_path;
	}
	public void setUpload_file_path(String upload_file_path) {
		this.upload_file_path = upload_file_path;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}
	public String getUpload_dates() {
		return upload_dates;
	}
	public void setUpload_dates(String upload_dates) {
		this.upload_dates = upload_dates;
	}
	public String getUpload_person() {
		return upload_person;
	}
	public void setUpload_person(String upload_person) {
		this.upload_person = upload_person;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getConstruction_project() {
		return construction_project;
	}
	public void setConstruction_project(String construction_project) {
		this.construction_project = construction_project;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public Date getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}
	public String getEffective_dates() {
		return effective_dates;
	}
	public void setEffective_dates(String effective_dates) {
		this.effective_dates = effective_dates;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}
 
}
