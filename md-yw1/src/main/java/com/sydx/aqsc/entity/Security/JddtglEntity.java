package com.sydx.aqsc.entity.Security;

import java.util.List;

public class JddtglEntity {

	private String oilfield;// 油田代码，如：pc0cq
	private String design_id;// 唯一主键日报ID
	private String well_common_name;// 井名
	private String well_id;// 井ID
	private String well_purpose;// 井别，代码（1：油，气：2，水：3）
	private String well_unitid;// 井单位ID
	private String plant_name;// 采油厂名称
	private String org_name;// 作业区名称
	private String stim_i_name;// 措施大类名称
	private String stim_ii_name;// 措施小类名称
	private String stim_key_id;// 措施ID
	private String start_date;// 开工时间
	private String rq1;// 开工时间
	private String rq2;// 开工时间
	private String end_date;// 完井时间
	private String construction_name;// 作业公司名称
	private String team_name;// 作业队名称
	private String team_unitid;// 作业队单位ID
	private String team_class;// 作业队属性
	private String reportflag;// 统计表措施类型对照标识
	private String update_date;// 日报更新日期
	private String daily_date;// 日报日期
	private String daily_content;// 作业内容
	private String note;// 备注
	private Integer xh;// 序号
	private String search;// 权限
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private String monitor_id;// 监督人员id
	private String true_name;// 监督人员姓名
	private String supervise_date;// 监督日期
	private String supervise_text;// 监督内容
	private String supervise_type;// 监督方式
	private String update_userid;// 更新用户id
	private String unit_name;// 单位名称
	private String month;
	private String cyc;
	private String zyq;
	private String cyd;
	private String scdw;
	private String sgdw;
	private String zylx;
	private Integer seq_no;// 序号
	private String sp_name;// 施工工序
	private String sup_text;// 监督内容
	private String sup_date;// 监督时间
	private Integer data_no;// 数据标识，默认0，提交记录后变成1
	private String pic;
	private String time;
	private String ms;
	private String text;
	private String pic_url;
	private List<JddtglEntity> entity_list;

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getZylx() {
		return zylx;
	}

	public void setZylx(String zylx) {
		this.zylx = zylx;
	}

	public List<JddtglEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<JddtglEntity> entity_list) {
		this.entity_list = entity_list;
	}

	public Integer getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(Integer seq_no) {
		this.seq_no = seq_no;
	}

	public String getSp_name() {
		return sp_name;
	}

	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}

	public String getSup_text() {
		return sup_text;
	}

	public void setSup_text(String sup_text) {
		this.sup_text = sup_text;
	}

	public String getSup_date() {
		return sup_date;
	}

	public void setSup_date(String sup_date) {
		this.sup_date = sup_date;
	}

	public Integer getData_no() {
		return data_no;
	}

	public void setData_no(Integer data_no) {
		this.data_no = data_no;
	}

	public String getCyc() {
		return cyc;
	}

	public void setCyc(String cyc) {
		this.cyc = cyc;
	}

	public String getZyq() {
		return zyq;
	}

	public void setZyq(String zyq) {
		this.zyq = zyq;
	}

	public String getCyd() {
		return cyd;
	}

	public void setCyd(String cyd) {
		this.cyd = cyd;
	}

	public String getScdw() {
		return scdw;
	}

	public void setScdw(String scdw) {
		this.scdw = scdw;
	}

	public String getSgdw() {
		return sgdw;
	}

	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonitor_id() {
		return monitor_id;
	}

	public void setMonitor_id(String monitor_id) {
		this.monitor_id = monitor_id;
	}

	public String getTrue_name() {
		return true_name;
	}

	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}

	public String getSupervise_date() {
		return supervise_date;
	}

	public void setSupervise_date(String supervise_date) {
		this.supervise_date = supervise_date;
	}

	public String getSupervise_text() {
		return supervise_text;
	}

	public void setSupervise_text(String supervise_text) {
		this.supervise_text = supervise_text;
	}

	public String getSupervise_type() {
		return supervise_type;
	}

	public void setSupervise_type(String supervise_type) {
		this.supervise_type = supervise_type;
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

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getDaily_date() {
		return daily_date;
	}

	public void setDaily_date(String daily_date) {
		this.daily_date = daily_date;
	}

	public String getDaily_content() {
		return daily_content;
	}

	public void setDaily_content(String daily_content) {
		this.daily_content = daily_content;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRq1() {
		return rq1;
	}

	public void setRq1(String rq1) {
		this.rq1 = rq1;
	}

	public String getRq2() {
		return rq2;
	}

	public void setRq2(String rq2) {
		this.rq2 = rq2;
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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getDesign_id() {
		return design_id;
	}

	public void setDesign_id(String design_id) {
		this.design_id = design_id;
	}

	public String getWell_common_name() {
		return well_common_name;
	}

	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}

	public String getWell_id() {
		return well_id;
	}

	public void setWell_id(String well_id) {
		this.well_id = well_id;
	}

	public String getWell_purpose() {
		return well_purpose;
	}

	public void setWell_purpose(String well_purpose) {
		this.well_purpose = well_purpose;
	}

	public String getWell_unitid() {
		return well_unitid;
	}

	public void setWell_unitid(String well_unitid) {
		this.well_unitid = well_unitid;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getStim_i_name() {
		return stim_i_name;
	}

	public void setStim_i_name(String stim_i_name) {
		this.stim_i_name = stim_i_name;
	}

	public String getStim_ii_name() {
		return stim_ii_name;
	}

	public void setStim_ii_name(String stim_ii_name) {
		this.stim_ii_name = stim_ii_name;
	}

	public String getStim_key_id() {
		return stim_key_id;
	}

	public void setStim_key_id(String stim_key_id) {
		this.stim_key_id = stim_key_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getConstruction_name() {
		return construction_name;
	}

	public void setConstruction_name(String construction_name) {
		this.construction_name = construction_name;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_unitid() {
		return team_unitid;
	}

	public void setTeam_unitid(String team_unitid) {
		this.team_unitid = team_unitid;
	}

	public String getTeam_class() {
		return team_class;
	}

	public void setTeam_class(String team_class) {
		this.team_class = team_class;
	}

	public String getReportflag() {
		return reportflag;
	}

	public void setReportflag(String reportflag) {
		this.reportflag = reportflag;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "JddtglEntity [oilfield=" + oilfield + ", design_id=" + design_id + ", well_common_name="
				+ well_common_name + ", well_id=" + well_id + ", well_purpose=" + well_purpose + ", well_unitid="
				+ well_unitid + ", plant_name=" + plant_name + ", org_name=" + org_name + ", stim_i_name=" + stim_i_name
				+ ", stim_ii_name=" + stim_ii_name + ", stim_key_id=" + stim_key_id + ", start_date=" + start_date
				+ ", rq1=" + rq1 + ", rq2=" + rq2 + ", end_date=" + end_date + ", construction_name="
				+ construction_name + ", team_name=" + team_name + ", team_unitid=" + team_unitid + ", team_class="
				+ team_class + ", reportflag=" + reportflag + ", update_date=" + update_date + ", daily_date="
				+ daily_date + ", daily_content=" + daily_content + ", note=" + note + ", xh=" + xh + ", search="
				+ search + ", row_num=" + row_num + ", endRow=" + endRow + ", startRow=" + startRow + ", monitor_id="
				+ monitor_id + ", true_name=" + true_name + ", supervise_date=" + supervise_date + ", supervise_text="
				+ supervise_text + ", supervise_type=" + supervise_type + ", update_userid=" + update_userid
				+ ", unit_name=" + unit_name + ", month=" + month + ", cyc=" + cyc + ", zyq=" + zyq + ", cyd=" + cyd
				+ ", scdw=" + scdw + ", sgdw=" + sgdw + ", zylx=" + zylx + ", seq_no=" + seq_no + ", sp_name=" + sp_name
				+ ", sup_text=" + sup_text + ", sup_date=" + sup_date + ", data_no=" + data_no + ", pic=" + pic
				+ ", time=" + time + ", ms=" + ms + ", text=" + text + ", pic_url=" + pic_url + ", entity_list="
				+ entity_list + "]";
	}

}
