package com.sydx.aqsc.entity.Security;

import java.io.Serializable;

public class BcwhEntity implements Serializable {

	private String oilfield;//油田
	private String create_user;//录入人
	private String create_time;//录入时间
	private String ip;//录入ip
	private String name;//班次名称
	private String unitid;//适用单位（大队）
	private String unit;//适用单位id
	private String starttime;//计划开始时间
	private String endtime;//计划结束时间
	private String id;

	private String ytj;
	private String cj;

	public String getYtj() {
		return ytj;
	}

	public void setYtj(String ytj) {
		this.ytj = ytj;
	}

	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
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

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
