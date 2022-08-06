package com.cyrj.jxzy.entity.Constractor;

import java.text.DecimalFormat;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "承包商队伍绩效评估")
public class Jxpg_cbsEntity extends BaseEntity{
	@ApiModelProperty(value="行号")
	private int row_num;//行号
	@ApiModelProperty(value="油田")
	private String oilfield;
	@ApiModelProperty(value="绩效评估年份")
	private String year;//绩效评估年份
	@ApiModelProperty(value="1油公司2厂级")
	private String tab;//1油公司2厂级
	@ApiModelProperty(value="队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）")
	private String team_class;//队伍类型：2大修、3带压、1小修（大修带压以外的都算小修）
	@ApiModelProperty(value="单位类别")
	private String dwlb;//单位类别
	@ApiModelProperty(value="承包商名称")
	private String contractor_name; // 承包商名称
	@ApiModelProperty(value="承包商ID")
	private String contractor_id; // 承包商ID
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	@ApiModelProperty(value="甲方单位")
	private String unit_id;//甲方单位
	@ApiModelProperty(value="队伍名称")
	private String team_name;//队伍名称
	@ApiModelProperty(value="队伍id")
	private String team_id;//队伍id
	@ApiModelProperty(value="合同数量")
	private int contractNum;//合同数量
	@ApiModelProperty(value="队伍资质数量")
	private int teamInfoNum;//队伍资质数量
	@ApiModelProperty(value="队伍动用数量")
	private int teamActualNum;//队伍动用数量
	@ApiModelProperty(value="施工井数")
	private int wellNum;//施工井数
	@ApiModelProperty(value="评估分数")
	private String fraction;//评估分数
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getTeam_class() {
		return team_class;
	}
	public void setTeam_class(String team_class) {
		this.team_class = team_class;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
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
	public int getContractNum() {
		return contractNum;
	}
	public void setContractNum(int contractNum) {
		this.contractNum = contractNum;
	}
	public int getTeamInfoNum() {
		return teamInfoNum;
	}
	public void setTeamInfoNum(int teamInfoNum) {
		this.teamInfoNum = teamInfoNum;
	}
	public int getTeamActualNum() {
		return teamActualNum;
	}
	public void setTeamActualNum(int teamActualNum) {
		this.teamActualNum = teamActualNum;
	}
	public int getWellNum() {
		return wellNum;
	}
	public void setWellNum(int wellNum) {
		this.wellNum = wellNum;
	}
	public String getFraction() {
		return fraction;
	}
	public void setFraction(String fraction) {
		DecimalFormat df = new DecimalFormat("######.00");	
		this.fraction =df.format(Double.valueOf(fraction)) ;
	}
	public int getRow_num() {
		return row_num;
	}
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	public String getDwlb() {
		return dwlb;
	}
	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	
	
}
