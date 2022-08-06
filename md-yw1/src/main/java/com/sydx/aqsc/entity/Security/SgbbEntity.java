package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.Pager;

import java.util.Date;
import java.util.List;

public class SgbbEntity {

	private String eng_code;
	private String sgdw; // 施工单位
	private String zizj; // 资质证号
	private String cycdm;//采油厂代码
	private String oilfield; // 适用油田
	private String op_team; // 作业队,施工小队_代码
	private String cydid; // 采油队id
	private String team_name;//工序是否完成
	private String team_id;
	private String did;
	private String construction_department; // 施工单位代码
	private String well_common_name; // 井号
	private String stim_type; //措施类型大类
	private String item_name; // 项目名称(施工项目)
	private String cslb;//措施三类
	private String cssil;//措施四类
	private String start_time;//开工时间
	private String start_time_String;//开工时间
	private Date complete_time;//完工时间
	private String complete_time_String;//完工时间
	private String assignment_date;//搬家计划下达时间
	private String well_id;//井ID
	private String design_num;//设计串号
	private String construction_id;//施工id
	private String scdw;//生产单位
	private String rqhd;//日期核对 默认0，如果交接井日期有异议改为1
	private String dnow;//
	private String zylx;//作业类型
	private String search;//数据权限
	private String username;//用户
	private String attribute;//数据属性：1作业，2非作业（生产、设计、机关）
	private String work_team;
	private String intelligence_code;
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private Pager pager;
	private String well_code;
	private String work_content;
	private String zyq;
	private String create_user;

	private List<SgbbEntity> entityList;

	private String well_purpose;
	private String moving_plan_id;
	private String unit_id;//甲方单位id
	private String report_type;
	private String work_shift;
	private String end_time;
	private String is_done;
	private String jb;
	private String design_id;
	private String work_shift1;
	private String work_shift2;
	private String last_user;
	private String ip;
	private Date create_time;
	private Date last_time;
	private Integer pro_param_id;
	private String content;
	private String spname;
	private Integer spid;
	private Integer pdid;
	private String customid;
	private String buildcontent;
	private String starttime;
	private String endtime;
	private Integer xh;
	private String sgrq;
   private String configTab;//是否向油田数据库回写数据标识：0不回写1回写


	public String getWell_code() {
		return well_code;
	}

	public void setWell_code(String well_code) {
		this.well_code = well_code;
	}

	public String getWork_content() {
		return work_content;
	}

	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}

	public String getZyq() {
		return zyq;
	}

	public void setZyq(String zyq) {
		this.zyq = zyq;
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

	public String getWork_team() {
		return work_team;
	}
	public void setWork_team(String work_team) {
		this.work_team = work_team;
	}
	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getZylx() {
        return zylx;
    }

    public void setZylx(String zylx) {
        this.zylx = zylx;
    }

    public String getStart_time_String() {
		return start_time_String;
	}

	public void setStart_time_String(String start_time_String) {
		this.start_time_String = start_time_String;
	}

	public String getComplete_time_String() {
		return complete_time_String;
	}

	public void setComplete_time_String(String complete_time_String) {
		this.complete_time_String = complete_time_String;
	}

	public String getDnow() {
		return dnow;
	}

	public void setDnow(String dnow) {
		this.dnow = dnow;
	}

	public String getEng_code() {
		return eng_code;
	}

	public void setEng_code(String eng_code) {
		this.eng_code = eng_code;
	}

	public String getSgdw() {
		return sgdw;
	}

	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}

	public String getZizj() {
		return zizj;
	}

	public void setZizj(String zizj) {
		this.zizj = zizj;
	}

	public String getCycdm() {
		return cycdm;
	}

	public void setCycdm(String cycdm) {
		this.cycdm = cycdm;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getOp_team() {
		return op_team;
	}

	public void setOp_team(String op_team) {
		this.op_team = op_team;
	}

	public String getCydid() {
		return cydid;
	}

	public void setCydid(String cydid) {
		this.cydid = cydid;
	}

	public String getConstruction_department() {
		return construction_department;
	}

	public void setConstruction_department(String construction_department) {
		this.construction_department = construction_department;
	}

	public String getWell_common_name() {
		return well_common_name;
	}

	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
	}

	public String getStim_type() {
		return stim_type;
	}

	public void setStim_type(String stim_type) {
		this.stim_type = stim_type;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getCslb() {
		return cslb;
	}

	public void setCslb(String cslb) {
		this.cslb = cslb;
	}

	public String getCssil() {
		return cssil;
	}

	public void setCssil(String cssil) {
		this.cssil = cssil;
	}

	public Date getComplete_time() {
		return complete_time;
	}

	public void setComplete_time(Date complete_time) {
		this.complete_time = complete_time;
	}

	public String getWell_id() {
		return well_id;
	}

	public void setWell_id(String well_id) {
		this.well_id = well_id;
	}

	public String getDesign_num() {
		return design_num;
	}

	public void setDesign_num(String design_num) {
		this.design_num = design_num;
	}

	public String getConstruction_id() {
		return construction_id;
	}

	public void setConstruction_id(String construction_id) {
		this.construction_id = construction_id;
	}

	public String getScdw() {
		return scdw;
	}

	public void setScdw(String scdw) {
		this.scdw = scdw;
	}

	public String getRqhd() {
		return rqhd;
	}

	public void setRqhd(String rqhd) {
		this.rqhd = rqhd;
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

	public List<SgbbEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<SgbbEntity> entityList) {
		this.entityList = entityList;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getWell_purpose() {
		return well_purpose;
	}

	public void setWell_purpose(String well_purpose) {
		this.well_purpose = well_purpose;
	}

	public String getMoving_plan_id() {
		return moving_plan_id;
	}

	public void setMoving_plan_id(String moving_plan_id) {
		this.moving_plan_id = moving_plan_id;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public String getWork_shift() {
		return work_shift;
	}

	public void setWork_shift(String work_shift) {
		this.work_shift = work_shift;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getIs_done() {
		return is_done;
	}

	public void setIs_done(String is_done) {
		this.is_done = is_done;
	}

	public String getJb() {
		return jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}

	public String getDesign_id() {
		return design_id;
	}

	public void setDesign_id(String design_id) {
		this.design_id = design_id;
	}

	public String getWork_shift1() {
		return work_shift1;
	}

	public void setWork_shift1(String work_shift1) {
		this.work_shift1 = work_shift1;
	}

	public String getWork_shift2() {
		return work_shift2;
	}

	public void setWork_shift2(String work_shift2) {
		this.work_shift2 = work_shift2;
	}

	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
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
	public String getLast_user() {
		return last_user;
	}
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}

	public Date getLast_time() {
		return last_time;
	}

	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}

	public Integer getPro_param_id() {
		return pro_param_id;
	}

	public void setPro_param_id(Integer pro_param_id) {
		this.pro_param_id = pro_param_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public String getBuildcontent() {
		return buildcontent;
	}

	public void setBuildcontent(String buildcontent) {
		this.buildcontent = buildcontent;
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

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getSgrq() {
		return sgrq;
	}

	public void setSgrq(String sgrq) {
		this.sgrq = sgrq;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStart_time() {
		return start_time;
	}

	public String getAssignment_date() {
		return assignment_date;
	}

	public void setAssignment_date(String assignment_date) {
		this.assignment_date = assignment_date;
	}

	public String getConfigTab() {
		return configTab;
	}

	public void setConfigTab(String configTab) {
		this.configTab = configTab;
	}
}