package com.sydx.aqsc.entity.Security;

import java.io.Serializable;

public class SgrbEntity implements Serializable {

	private  int row_num;
	private String oilfield;//油田
	private String did;//施工id
	private String team_name;//队伍名称
	private String well_common_name;//井号
	private String report_time;//上报日期
	private String content;//	内容	

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getWell_common_name() {
		return well_common_name;
	}

	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
}
