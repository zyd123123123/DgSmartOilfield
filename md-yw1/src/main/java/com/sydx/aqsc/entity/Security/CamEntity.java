package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.CommonEntity;

import java.util.ArrayList;
import java.util.List;

public class CamEntity extends CommonEntity {

	private List<CamEntity> entityList = new ArrayList<CamEntity>();// 当前实体集合

	private String dw;
	private String jh;
	private String oilfield;
	private String camid;
	private String token;

	private String deviceName;
	private String deviceID;
	private String channelID;
	private String deviceIP;
	private String deviceUser;
	private String devicePwd;
	private int devicePort;
	private String deviceVhost;
	private String deviceParams;
	private String deviceBrand;
	private String sipServerIP; // SIP服务器地址
	private Integer sipServerPort;
	private String smServerIP; // 流媒体服务器地址
	private Integer smServerPort; // 流媒体服务器推送端口
	private Integer smServerAdminPort;

	private String company_id;
	private String company_name;
	private String well_id;
	private String well_common_name;
	private String devicetype;
	private String binduser;
	private String model;
	private String manufacturer;
	private String firmware;
	private String if_online;
	private String updateuser;
	private String updatetime;
	private String id;
	private String unit_id;// 单位id
	private String unit_name;// 单位名称
	private String bs;
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String conpany_name) {
		this.company_name = conpany_name;
	}

	public String getWell_id() {
		return well_id;
	}

	public void setWell_id(String well_id) {
		this.well_id = well_id;
	}

	public String getWell_common_name() {
		return well_common_name;
	}

	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}

	public String getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}

	public String getBinduser() {
		return binduser;
	}

	public void setBinduser(String binduser) {
		this.binduser = binduser;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getIf_online() {
		return if_online;
	}

	public void setIf_online(String if_online) {
		this.if_online = if_online;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "CamEntity [entityList=" + entityList + ", dw=" + dw + ", jh=" + jh + ", oilfield=" + oilfield
				+ ", camid=" + camid + ", token=" + token + ", deviceName=" + deviceName + ", deviceID=" + deviceID
				+ ", channelID=" + channelID + ", deviceIP=" + deviceIP + ", deviceUser=" + deviceUser + ", devicePwd="
				+ devicePwd + ", devicePort=" + devicePort + ", deviceVhost=" + deviceVhost + ", deviceParams="
				+ deviceParams + ", deviceBrand=" + deviceBrand + ", sipServerIP=" + sipServerIP + ", sipServerPort="
				+ sipServerPort + ", smServerIP=" + smServerIP + ", smServerPort=" + smServerPort
				+ ", smServerAdminPort=" + smServerAdminPort + ", company_id=" + company_id + ", company_name="
				+ company_name + ", well_id=" + well_id + ", well_common_name=" + well_common_name + ", devicetype="
				+ devicetype + ", binduser=" + binduser + ", model=" + model + ", manufacturer=" + manufacturer
				+ ", firmware=" + firmware + ", if_online=" + if_online + ", updateuser=" + updateuser + ", updatetime="
				+ updatetime + ", id=" + id + ", unit_id=" + unit_id + ", unit_name=" + unit_name + ", bs=" + bs
				+ ", row_num=" + row_num + ", endRow=" + endRow + ", startRow=" + startRow + "]";
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getToken() {
		return token;
	}

	public String getDw() {
		return dw;
	}

	public String getDeviceBrand() {
		return deviceBrand;
	}

	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getJh() {
		return jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	public List<CamEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<CamEntity> entityList) {
		this.entityList = entityList;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getCamid() {
		return camid;
	}

	public void setCamid(String camid) {
		this.camid = camid;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getChannelID() {
		return channelID;
	}

	public void setChannelID(String channelID) {
		this.channelID = channelID;
	}

	public String getDeviceIP() {
		return deviceIP;
	}

	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}

	public String getDeviceUser() {
		return deviceUser;
	}

	public void setDeviceUser(String deviceUser) {
		this.deviceUser = deviceUser;
	}

	public String getDevicePwd() {
		return devicePwd;
	}

	public void setDevicePwd(String devicePwd) {
		this.devicePwd = devicePwd;
	}

	public int getDevicePort() {
		return devicePort;
	}

	public void setDevicePort(int devicePort) {
		this.devicePort = devicePort;
	}

	public String getDeviceVhost() {
		return deviceVhost;
	}

	public void setDeviceVhost(String deviceVhost) {
		this.deviceVhost = deviceVhost;
	}

	public String getDeviceParams() {
		return deviceParams;
	}

	public void setDeviceParams(String deviceParams) {
		this.deviceParams = deviceParams;
	}

	public String getSipServerIP() {
		return sipServerIP;
	}

	public void setSipServerIP(String sipServerIP) {
		this.sipServerIP = sipServerIP;
	}

	public Integer getSipServerPort() {
		return sipServerPort;
	}

	public void setSipServerPort(Integer sipServerPort) {
		this.sipServerPort = sipServerPort;
	}

	public String getSmServerIP() {
		return smServerIP;
	}

	public void setSmServerIP(String smServerIP) {
		this.smServerIP = smServerIP;
	}

	public Integer getSmServerPort() {
		return smServerPort;
	}

	public void setSmServerPort(Integer smServerPort) {
		this.smServerPort = smServerPort;
	}

	public Integer getSmServerAdminPort() {
		return smServerAdminPort;
	}

	public void setSmServerAdminPort(Integer smServerAdminPort) {
		this.smServerAdminPort = smServerAdminPort;
	}
}
