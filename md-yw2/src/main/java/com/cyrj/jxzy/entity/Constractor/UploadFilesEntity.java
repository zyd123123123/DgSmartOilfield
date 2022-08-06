package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "承包商文件上传类")
public class UploadFilesEntity extends BaseEntity{
	@ApiModelProperty(value="id")
	private String  id;
	@ApiModelProperty(value="油田")
	private String  oilfield; //油田
	@ApiModelProperty(value="合同id")
	private String  contract_id; //合同id
	@ApiModelProperty(value="承包商名称")
	private String  contractor_name; //承包商名称
	@ApiModelProperty(value="承包商id")
	private String  contractor_id; //承包商id
	@ApiModelProperty(value="队伍资质")
	private String  team_qualification; //队伍资质
	@ApiModelProperty(value="队伍id")
	private String  team_id; //队伍id
	@ApiModelProperty(value="文件类型（名称）")
	private String  filetype; //文件类型（名称）
	@ApiModelProperty(value="文件本地存储路径")
	private String  fileuri; //文件本地存储路径
	@ApiModelProperty(value="文件原名称")
	private String  fileoldname; //文件原名称
	@ApiModelProperty(hidden = true)
	private String  datetime;
	@ApiModelProperty(hidden = true)
	private String upload_person;
	@ApiModelProperty(value="url路径")
	private String file_url;
	
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
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
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getUpload_person() {
		return upload_person;
	}
	public void setUpload_person(String upload_person) {
		this.upload_person = upload_person;
	}	
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}
	
}
