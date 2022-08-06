package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "大文本类")
public class BigTextEntity extends BaseEntity{
	@ApiModelProperty(value="备用字段1",hidden = true)
	private String reserve1; // 备用字段1
	@ApiModelProperty(value="备用字段2",hidden = true)
	private String reserve2; // 备用字段2
	@ApiModelProperty(value="大文本编号")
	private String text_id; // 大文本编号
	@ApiModelProperty(value="油田id")
	private String oilfield; // 油田id
	@ApiModelProperty(value="合同id")
	private String 	contract_id;//合同id
	@ApiModelProperty(value="承包商名称")
	private String 	contractor_name;//承包商名称
	@ApiModelProperty(value="队伍资质")
	private String  team_qualification;//队伍资质
	@ApiModelProperty(value="队伍id")
	private String  team_id;//队伍id
	@ApiModelProperty(value="HSE承诺书、准入评估表")
	private String  type;//HSE承诺书、准入评估表
	@ApiModelProperty(value="大文本内容")
	private String neirong;//
	@ApiModelProperty(hidden = true)
	private byte[] text;
	@ApiModelProperty(hidden = true)
	private String datetime;
	public String getReserve1() {
		return reserve1;
	}
	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}
	public String getReserve2() {
		return reserve2;
	}
	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}
	public String getText_id() {
		return text_id;
	}
	public void setText_id(String text_id) {
		this.text_id = text_id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public byte[] getText() {
		return text;
	}
	public void setText(byte[] text) {
		this.text = text;
	}
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	
}
