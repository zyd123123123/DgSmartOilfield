package com.sydx.aqsc.entity.Security;

import java.util.List;

/**
 * @author tianshuai
 *
 */
public class JdryglEntity {

	private String monitor_id;// 监督人员ID，唯一主键
	private String update_date;// 更新日期
	private String update_userid;// 更新用户ID
	private String unit_name;// 单位名称
	private String true_name;// 姓名
	private String id_num;// 身份证号
	private String sex;// 性别
	private String nation;// 民族
	private String university;// 毕业院校
	private String education;// 学历
	private String political_outlook;// 政治面貌
	private String positional_titles;// 职称类别
	private String appointment_date;// 聘任时间
	private String underground_time;// 从事井下作业时间
	private String well_control_num;// 井控培训合格证编号
	private String supervision_time;// 从事井下作业监督工作时间
	private String supervise_date;// 初发监督证时间
	private String supervise_num;// 监督证编号
	private String supervise_unit;// 监督证发证单位
	private String validity_sta_date;// 监督证有效期_开始
	private String validity_end_date;// 监督证有效期_结束
	private String supervise_class;// 监督类（级）别
	private String license_num;// 上岗证编号
	private String remarks;// 备注
	private String address_id;// 身份证件上传地址
	private String address_contr;// 井控证件上传地址
	private String address_super;// 监督证件上传地址
	private String address_other;// 其他证件上传地址
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private String unit_id;// 单位id
	private String oilfield;// 油田
	private String zyqid;// 作业区id
	private String cyc_name;// 采油厂名称
	private String zyq_name;// 作业区名称
	private String work_condition;// 工作状态
	private String supervise_source;// 监督来源
	private String user_id;// 用户id

	public String getWork_condition() {
		return work_condition;
	}

	public void setWork_condition(String work_condition) {
		this.work_condition = work_condition;
	}

	public String getSupervise_source() {
		return supervise_source;
	}

	public void setSupervise_source(String supervise_source) {
		this.supervise_source = supervise_source;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private List<JdryglEntity> entity_list;

	public String getZyqid() {
		return zyqid;
	}

	public void setZyqid(String zyqid) {
		this.zyqid = zyqid;
	}

	public String getCyc_name() {
		return cyc_name;
	}

	public void setCyc_name(String cyc_name) {
		this.cyc_name = cyc_name;
	}

	public String getZyq_name() {
		return zyq_name;
	}

	public void setZyq_name(String zyq_name) {
		this.zyq_name = zyq_name;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
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

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public List<JdryglEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<JdryglEntity> entity_list) {
		this.entity_list = entity_list;
	}

	public String getMonitor_id() {
		return monitor_id;
	}

	public void setMonitor_id(String monitor_id) {
		this.monitor_id = monitor_id;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getUpdate_userid() {
		return update_userid;
	}

	public void setUpdate_userid(String update_userid) {
		this.update_userid = update_userid;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getTrue_name() {
		return true_name;
	}

	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}

	public String getId_num() {
		return id_num;
	}

	public void setId_num(String id_num) {
		this.id_num = id_num;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPolitical_outlook() {
		return political_outlook;
	}

	public void setPolitical_outlook(String political_outlook) {
		this.political_outlook = political_outlook;
	}

	public String getPositional_titles() {
		return positional_titles;
	}

	public void setPositional_titles(String positional_titles) {
		this.positional_titles = positional_titles;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getUnderground_time() {
		return underground_time;
	}

	public void setUnderground_time(String underground_time) {
		this.underground_time = underground_time;
	}

	public String getWell_control_num() {
		return well_control_num;
	}

	public void setWell_control_num(String well_control_num) {
		this.well_control_num = well_control_num;
	}

	public String getSupervision_time() {
		return supervision_time;
	}

	public void setSupervision_time(String supervision_time) {
		this.supervision_time = supervision_time;
	}

	public String getSupervise_date() {
		return supervise_date;
	}

	public void setSupervise_date(String supervise_date) {
		this.supervise_date = supervise_date;
	}

	public String getSupervise_num() {
		return supervise_num;
	}

	public void setSupervise_num(String supervise_num) {
		this.supervise_num = supervise_num;
	}

	public String getSupervise_unit() {
		return supervise_unit;
	}

	public void setSupervise_unit(String supervise_unit) {
		this.supervise_unit = supervise_unit;
	}

	public String getValidity_sta_date() {
		return validity_sta_date;
	}

	public void setValidity_sta_date(String validity_sta_date) {
		this.validity_sta_date = validity_sta_date;
	}

	public String getValidity_end_date() {
		return validity_end_date;
	}

	public void setValidity_end_date(String validity_end_date) {
		this.validity_end_date = validity_end_date;
	}

	public String getSupervise_class() {
		return supervise_class;
	}

	public void setSupervise_class(String supervise_class) {
		this.supervise_class = supervise_class;
	}

	public String getLicense_num() {
		return license_num;
	}

	public void setLicense_num(String license_num) {
		this.license_num = license_num;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getAddress_contr() {
		return address_contr;
	}

	public void setAddress_contr(String address_contr) {
		this.address_contr = address_contr;
	}

	public String getAddress_super() {
		return address_super;
	}

	public void setAddress_super(String address_super) {
		this.address_super = address_super;
	}

	public String getAddress_other() {
		return address_other;
	}

	public void setAddress_other(String address_other) {
		this.address_other = address_other;
	}

	@Override
	public String toString() {
		return "JdryglEntity [monitor_id=" + monitor_id + ", update_date=" + update_date + ", update_userid="
				+ update_userid + ", unit_name=" + unit_name + ", true_name=" + true_name + ", id_num=" + id_num
				+ ", sex=" + sex + ", nation=" + nation + ", university=" + university + ", education=" + education
				+ ", political_outlook=" + political_outlook + ", positional_titles=" + positional_titles
				+ ", appointment_date=" + appointment_date + ", underground_time=" + underground_time
				+ ", well_control_num=" + well_control_num + ", supervision_time=" + supervision_time
				+ ", supervise_date=" + supervise_date + ", supervise_num=" + supervise_num + ", supervise_unit="
				+ supervise_unit + ", validity_sta_date=" + validity_sta_date + ", validity_end_date="
				+ validity_end_date + ", supervise_class=" + supervise_class + ", license_num=" + license_num
				+ ", remarks=" + remarks + ", address_id=" + address_id + ", address_contr=" + address_contr
				+ ", address_super=" + address_super + ", address_other=" + address_other + ", row_num=" + row_num
				+ ", endRow=" + endRow + ", startRow=" + startRow + ", unit_id=" + unit_id + ", oilfield=" + oilfield
				+ ", zyqid=" + zyqid + ", cyc_name=" + cyc_name + ", zyq_name=" + zyq_name + ", work_condition="
				+ work_condition + ", supervise_source=" + supervise_source + ", user_id=" + user_id + ", entity_list="
				+ entity_list + "]";
	}

}
