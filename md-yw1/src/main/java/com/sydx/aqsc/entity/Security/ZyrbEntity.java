package com.sydx.aqsc.entity.Security;

import java.util.Date;
import java.util.List;

public class ZyrbEntity {
	private String well_common_name;//井号
	private String well_purpose;//井别
	private String stratigraphic_position;//层位
	private String construct_interval;//井段
	private String work_brief;//作业项目
	private String did;//施工步骤唯一id
	private String intelligence_code;//资质编码，队伍资质
	private String work_content;//工作内容
	private Date start_time;//开工时间
	private String start_time_Str;//开工时间
	private Date end_time;//完工时间
	private String end_time_Str;//完工时间
//	private int create_user;//
	private Date create_time;//
	private String ip;//
	private String oilfield;//
//	private int last_user;//
	private Date last_time;//
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private List<ZyrbEntity> entityList;//
	private String spname;//
	private Integer spid;//工序id
	private Integer pdid;//施工步骤工序id
	private Integer begin_time_our;//开始时间——小时
	private Integer end_time_hour;//结束时间——小时
    private String construction_department;//施工单位
    private String team_name;//队伍名
    private String team_id;//队伍id
    private String scdw;//生产单位（采油厂或作业区）
    private String scdwid;//生产单位（采油厂或作业区）
    private Date report_time;//上报时间
    private String report_time_Str;//上报时间
    private String next_circuit;//下步工序
    private String sgnr1;//施工内容
    private String sgnr2;//施工内容
    private String sgnr3;//施工内容
    private String order_classes;//班次
    private String work_content0;
    private String work_content8;
    private String work_content16;
    private String platform_id;
    private String search;
    private String attribute;
	public String getOrder_classes() {
		return order_classes;
	}
	public void setOrder_classes(String order_classes) {
		this.order_classes = order_classes;
	}
	public String getWell_common_name() {
		return well_common_name;
	}
	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}
	public String getWell_purpose() {
		return well_purpose;
	}
	public void setWell_purpose(String well_purpose) {
		this.well_purpose = well_purpose;
	}
	public String getStratigraphic_position() {
		return stratigraphic_position;
	}
	public void setStratigraphic_position(String stratigraphic_position) {
		this.stratigraphic_position = stratigraphic_position;
	}
	public String getConstruct_interval() {
		return construct_interval;
	}
	public void setConstruct_interval(String construct_interval) {
		this.construct_interval = construct_interval;
	}
	public String getWork_brief() {
		return work_brief;
	}
	public void setWork_brief(String work_brief) {
		this.work_brief = work_brief;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getIntelligence_code() {
		return intelligence_code;
	}
	public void setIntelligence_code(String intelligence_code) {
		this.intelligence_code = intelligence_code;
	}
	public String getWork_content() {
		return work_content;
	}
	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public String getStart_time_Str() {
		return start_time_Str;
	}
	public void setStart_time_Str(String start_time_Str) {
		this.start_time_Str = start_time_Str;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getEnd_time_Str() {
		return end_time_Str;
	}
	public void setEnd_time_Str(String end_time_Str) {
		this.end_time_Str = end_time_Str;
	}
//	public int getCreate_user() {
//		return create_user;
//	}
//	public void setCreate_user(int create_user) {
//		this.create_user = create_user;
//	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
//	public int getLast_user() {
//		return last_user;
//	}
//	public void setLast_user(int last_user) {
//		this.last_user = last_user;
//	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
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
	public List<ZyrbEntity> getEntityList() {
		return entityList;
	}
	public void setEntityList(List<ZyrbEntity> entityList) {
		this.entityList = entityList;
	}
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public Integer getSpid() {
		return spid;
	}
	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	public Integer getPdid() {
		return pdid;
	}
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}
	public Integer getBegin_time_our() {
		return begin_time_our;
	}
	public void setBegin_time_our(Integer begin_time_our) {
		this.begin_time_our = begin_time_our;
	}
	public Integer getEnd_time_hour() {
		return end_time_hour;
	}
	public void setEnd_time_hour(Integer end_time_hour) {
		this.end_time_hour = end_time_hour;
	}
	public String getConstruction_department() {
		return construction_department;
	}
	public void setConstruction_department(String construction_department) {
		this.construction_department = construction_department;
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
	public String getScdw() {
		return scdw;
	}
	public void setScdw(String scdw) {
		this.scdw = scdw;
	}
	public Date getReport_time() {
		return report_time;
	}
	public void setReport_time(Date report_time) {
		this.report_time = report_time;
	}
	public String getReport_time_Str() {
		return report_time_Str;
	}
	public void setReport_time_Str(String report_time_Str) {
		this.report_time_Str = report_time_Str;
	}
	public String getNext_circuit() {
		return next_circuit;
	}
	public void setNext_circuit(String next_circuit) {
		this.next_circuit = next_circuit;
	}
	public String getSgnr1() {
		return sgnr1;
	}
	public void setSgnr1(String sgnr1) {
		this.sgnr1 = sgnr1;
	}
	public String getSgnr2() {
		return sgnr2;
	}
	public void setSgnr2(String sgnr2) {
		this.sgnr2 = sgnr2;
	}
	public String getSgnr3() {
		return sgnr3;
	}
	public void setSgnr3(String sgnr3) {
		this.sgnr3 = sgnr3;
	}
	public String getWork_content0() {
		return work_content0;
	}
	public void setWork_content0(String work_content0) {
		this.work_content0 = work_content0;
	}
	public String getWork_content8() {
		return work_content8;
	}
	public void setWork_content8(String work_content8) {
		this.work_content8 = work_content8;
	}
	public String getWork_content16() {
		return work_content16;
	}
	public void setWork_content16(String work_content16) {
		this.work_content16 = work_content16;
	}
	public String getPlatform_id() {
		return platform_id;
	}
	public void setPlatform_id(String platform_id) {
		this.platform_id = platform_id;
	}
	public String getScdwid() {
		return scdwid;
	}
	public void setScdwid(String scdwid) {
		this.scdwid = scdwid;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}