package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;

import java.util.ArrayList;
import java.util.List;


public class ReportWorkoveEntity extends BaseEntity {

	private String well_common_name ;//井号
	private String did ;//唯一id（施工总结id或搬家计划id）
	private String intelligence_code ;//队伍资质
	private String construct_team ;//队伍名称
	private String team_id;
	private String work_brief ;//施工性质
	private String order_classes ;//班次	
	private String report_time ;//上报日期
	private String work_date ;//开工日期
	private String end_date ;//完工日期
	private String next_circuit ;//下一步工序
	private String bblx ;//班报类型
	private String construct_interval ;//施工井段
	private String density_straturm ;//厚度/层数
	private String stratigraphic_position ;//层位
	private String level_number;//层号
	//试油
	private String test_oil_interval;//试油井段
	private String ceng_wei_hao;//层位/层号
	private String test_oil_cengxu;//试油层序/设计层数
	private String test_oil_method;//试油方式
	private String liquidity;//液垫+井筒液（液性）
	private Double density;//液垫+井筒液（密度）
	private Double cubic_capacity;//液垫+井筒液（体积）
	private Double oil1;//当班产出量（油）
	private Double gas1;//当班产出量（气）
	private Double water1;//当班产出量（水）
	private Double oil2;//累计产出量（地层产出）（油）
	private Double gas2;//累计产出量（地层产出）（气）
	private Double water2;//累计产出量（地层产出）（水）
	private String yes_no;//是否排液：no不排液，yes排液

//	排液
//试油(抽汲排液)
	private Double chou_ci;//抽次
	private Double chou_shen;//抽深
	private Double producing_fluid_level;//动液面
	private Double submergence_depth;//沉没度
//	试油(氮气排液)
	private String pump_pressure;//泵压
	private Double nitrogen_gas_delivery;//氮气流量
	private Double nitrogen_gas_volume;//累计氮气用量
//	试油(连续油管氮气排液)
	private Double ju_shen;//举升
//	试油(自喷或放喷排液)
	private Double oil_pressure;//油压
	private Double casing_pressure;//套压
	private Double glib_talker;//油嘴
//	试油(螺杆泵排液)
private Double rotate_speed;//转速
//	排液通用
	private Double output_ye_volume;//产出液量
	private Double output_oil_volume;//产出油量
	private Double output_gas_volume;//产出气量
	private Double free_water_content;//水
	private Double emulsified_water;//
	private Double crude_oil_water;//

	private Double composite_water_cut;//综合含水%
	private Double cumulative_ye_production;//累计出液
	private Double cumulative_oil_production;//累计出油
	private Double cumulative_gas_production;//累计出气
	private Double cumulative_water_production;//累计出水
	private String jkwd;//井口温度
	private String height_level;//备注



	private String gx_type;//工序分类：施工步骤定制工序，附加工序
	private int spid;//工序id
	private int pdid;//工序id
	private int spno;//工序id
	private String spid_pdid;//
	private String circuit_name;//施工工序
	private int begin_time_hour;//起始时间——小时
	private int begin_time_minute;//起始时间——分钟
	private int end_time_hour;//截止时间——小时
	private int end_time_minute;//截止时间——分钟
	private String work_content;//工作内容(施工内容)
	private String is_complete;//工序是否完成
	private String oilfield;//工序是否完成
	private String cydid;//采油队id
	private String op_team;//采油队id
	private String team_name;//工序是否完成
	private String pro_status;//工序状态
	private String edittab; //编辑标识：默认1不可编辑，使用模板替换，2可编辑
	private String record_name;//记录
	private String class_monitor;//班长
	private String watch_cadre;//当班干部
	private String supervisor;//监督
	private String redaction_name;//录入员
	private String complete_judgement;//是否完井判断
	private String fangs;
	private String complete_cw;//完层判断
	private String bb_id;//班报id
	private int id;
	private String  tab;//标记，区分数据显示今天还是昨天和今天的，数据表中没有该字段
	private String unitid;//单位id
	private String termid;//队伍id
	private int row_num; // 序号
	private int endRow; // 结束行
	private int startRow; // 开始行
	private List<ReportWorkoveEntity> entity_list= new ArrayList<ReportWorkoveEntity>();
	private String jh;//日报井号
	private String rq;//日报上报日期
	private String text;//日报内容（工序名
	private String sjch;//设计串号
	private String login_people;//日报录入人
	private String login_time;//日报录入时间
	private String login_unit;//日报录入unit
	private String login_ip;//日报录入ip
    private String customid;//施工班报模板id
   private  String remarks;//备注
	private String parame_val_num;//参数数据值编号
	private String buildcontenttmp;//工序模板

	private byte[] bigtext;//泵注程序大文本
	private String bigtexts;//泵注程序大文本
	private String configTab;//是否向油田数据库回写数据标识：0不回写1回写

	private  Integer up_pipe;//起管数量
	private  Integer down_pipe;//下管数量
	private  Integer up_rod;//起杆数量
	private  Integer down_rod;//下杆数量


	public String getJh() {
		return jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	public String getRq() {
		return rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSjch() {
		return sjch;
	}

	public void setSjch(String sjch) {
		this.sjch = sjch;
	}

	public String getLogin_people() {
		return login_people;
	}

	public void setLogin_people(String login_people) {
		this.login_people = login_people;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public String getLogin_unit() {
		return login_unit;
	}

	public void setLogin_unit(String login_unit) {
		this.login_unit = login_unit;
	}

	public String getLogin_ip() {
		return login_ip;
	}

	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}

	public String getOp_team() {
		return op_team;
	}

	public void setOp_team(String op_team) {
		this.op_team = op_team;
	}

	public String getPro_status() {
		return pro_status;
	}
	public void setPro_status(String pro_status) {
		this.pro_status = pro_status;
	}
	@Override
	public int getRow_num() {
		return row_num;
	}
	@Override
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	@Override
	public int getStartRow() {
		return startRow;
	}
	@Override
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	@Override
	public int getEndRow() {
		return endRow;
	}
	@Override
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getCydid() {
		return cydid;
	}
	public void setCydid(String cydid) {
		this.cydid = cydid;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getWell_common_name() {
		return well_common_name;
	}
	public void setWell_common_name(String well_common_name) {
		this.well_common_name = well_common_name;
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
	public String getConstruct_team() {
		return construct_team;
	}
	public void setConstruct_team(String construct_team) {
		this.construct_team = construct_team;
	}
	public String getWork_brief() {
		return work_brief;
	}
	public void setWork_brief(String work_brief) {
		this.work_brief = work_brief;
	}
	public String getOrder_classes() {
		return order_classes;
	}
	public void setOrder_classes(String order_classes) {
		this.order_classes = order_classes;
	}
	public String getReport_time() {
		return report_time;
	}
	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}
	public String getWork_date() {
		return work_date;
	}
	public void setWork_date(String work_date) {
		this.work_date = work_date;
	}
	public String getNext_circuit() {
		return next_circuit;
	}
	public void setNext_circuit(String next_circuit) {
		this.next_circuit = next_circuit;
	}
	public String getConstruct_interval() {
		return construct_interval;
	}
	public void setConstruct_interval(String construct_interval) {
		this.construct_interval = construct_interval;
	}
	public String getDensity_straturm() {
		return density_straturm;
	}
	public void setDensity_straturm(String density_straturm) {
		this.density_straturm = density_straturm;
	}
	public String getStratigraphic_position() {
		return stratigraphic_position;
	}
	public void setStratigraphic_position(String stratigraphic_position) {
		this.stratigraphic_position = stratigraphic_position;
	}
	public String getBblx() {
		return bblx;
	}
	public void setBblx(String bblx) {
		this.bblx = bblx;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getLevel_number() {
		return level_number;
	}
	public void setLevel_number(String level_number) {
		this.level_number = level_number;
	}
	public List<ReportWorkoveEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<ReportWorkoveEntity> entity_list) {
		this.entity_list = entity_list;
	}
	public String getRecord_name() {
		return record_name;
	}
	public void setRecord_name(String record_name) {
		this.record_name = record_name;
	}
	public String getClass_monitor() {
		return class_monitor;
	}
	public void setClass_monitor(String class_monitor) {
		this.class_monitor = class_monitor;
	}
	public String getWatch_cadre() {
		return watch_cadre;
	}
	public void setWatch_cadre(String watch_cadre) {
		this.watch_cadre = watch_cadre;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getRedaction_name() {
		return redaction_name;
	}
	public void setRedaction_name(String redaction_name) {
		this.redaction_name = redaction_name;
	}
	public String getComplete_judgement() {
		return complete_judgement;
	}
	public void setComplete_judgement(String complete_judgement) {
		this.complete_judgement = complete_judgement;
	}

	public String getGx_type() {
		return gx_type;
	}
	public void setGx_type(String gx_type) {
		this.gx_type = gx_type;
	}

	public String getCircuit_name() {
		return circuit_name;
	}
	public void setCircuit_name(String circuit_name) {
		this.circuit_name = circuit_name;
	}
	public int getBegin_time_hour() {
		return begin_time_hour;
	}
	public void setBegin_time_hour(int begin_time_hour) {
		this.begin_time_hour = begin_time_hour;
	}
	public int getBegin_time_minute() {
		return begin_time_minute;
	}
	public void setBegin_time_minute(int begin_time_minute) {
		this.begin_time_minute = begin_time_minute;
	}
	public int getEnd_time_hour() {
		return end_time_hour;
	}
	public void setEnd_time_hour(int end_time_hour) {
		this.end_time_hour = end_time_hour;
	}
	public int getEnd_time_minute() {
		return end_time_minute;
	}
	public void setEnd_time_minute(int end_time_minute) {
		this.end_time_minute = end_time_minute;
	}
	public String getWork_content() {
		return work_content;
	}
	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}
	public String getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(String is_complete) {
		this.is_complete = is_complete;
	}
	public String getBb_id() {
		return bb_id;
	}
	public void setBb_id(String bb_id) {
		this.bb_id = bb_id;
	}

	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public int getPdid() {
		return pdid;
	}
	public void setPdid(int pdid) {
		this.pdid = pdid;
	}
	public String getSpid_pdid() {
		return spid_pdid;
	}
	public void setSpid_pdid(String spid_pdid) {
		this.spid_pdid = spid_pdid;
	}
	public String getFangs() {
		return fangs;
	}
	public void setFangs(String fangs) {
		this.fangs = fangs;
	}
	public String getComplete_cw() {
		return complete_cw;
	}
	public void setComplete_cw(String complete_cw) {
		this.complete_cw = complete_cw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTab() {
		return tab;
	}
	public void setTab(String tab) {
		this.tab = tab;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	public String getTermid() {
		return termid;
	}
	public void setTermid(String termid) {
		this.termid = termid;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParame_val_num() {
		return parame_val_num;
	}

	public void setParame_val_num(String parame_val_num) {
		this.parame_val_num = parame_val_num;
	}

	public String getEdittab() {
		return edittab;
	}

	public void setEdittab(String edittab) {
		this.edittab = edittab;
	}

	public String getBuildcontenttmp() {
		return buildcontenttmp;
	}

	public void setBuildcontenttmp(String buildcontenttmp) {
		this.buildcontenttmp = buildcontenttmp;
	}

	public int getSpno() {
		return spno;
	}

	public void setSpno(int spno) {
		this.spno = spno;
	}

	public String getConfigTab() {
		return configTab;
	}

	public void setConfigTab(String configTab) {
		this.configTab = configTab;
	}

	public String getTest_oil_interval() {
		return test_oil_interval;
	}

	public void setTest_oil_interval(String test_oil_interval) {
		this.test_oil_interval = test_oil_interval;
	}

	public String getCeng_wei_hao() {
		return ceng_wei_hao;
	}

	public void setCeng_wei_hao(String ceng_wei_hao) {
		this.ceng_wei_hao = ceng_wei_hao;
	}

	public String getTest_oil_cengxu() {
		return test_oil_cengxu;
	}

	public void setTest_oil_cengxu(String test_oil_cengxu) {
		this.test_oil_cengxu = test_oil_cengxu;
	}

	public String getTest_oil_method() {
		return test_oil_method;
	}

	public void setTest_oil_method(String test_oil_method) {
		this.test_oil_method = test_oil_method;
	}

	public String getLiquidity() {		return liquidity;
	}

	public void setLiquidity(String liquidity) {
		this.liquidity = liquidity;
	}

	public Double getDensity() {
		return density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Double getCubic_capacity() {
		return cubic_capacity;
	}

	public void setCubic_capacity(Double cubic_capacity) {
		this.cubic_capacity = cubic_capacity;
	}

	public Double getOil1() {
		return oil1;
	}

	public void setOil1(Double oil1) {
		this.oil1 = oil1;
	}

	public Double getGas1() {
		return gas1;
	}

	public void setGas1(Double gas1) {
		this.gas1 = gas1;
	}

	public Double getWater1() {
		return water1;
	}

	public void setWater1(Double water1) {
		this.water1 = water1;
	}

	public Double getOil2() {
		return oil2;
	}

	public void setOil2(Double oil2) {
		this.oil2 = oil2;
	}

	public Double getGas2() {
		return gas2;
	}

	public void setGas2(Double gas2) {
		this.gas2 = gas2;
	}

	public Double getWater2() {
		return water2;
	}

	public void setWater2(Double water2) {
		this.water2 = water2;
	}

	public String getYes_no() {
		return yes_no;
	}

	public void setYes_no(String yes_no) {
		this.yes_no = yes_no;
	}

	public Double getChou_ci() {
		return chou_ci;
	}

	public void setChou_ci(Double chou_ci) {
		this.chou_ci = chou_ci;
	}

	public Double getChou_shen() {
		return chou_shen;
	}

	public void setChou_shen(Double chou_shen) {
		this.chou_shen = chou_shen;
	}

	public Double getProducing_fluid_level() {
		return producing_fluid_level;
	}

	public void setProducing_fluid_level(Double producing_fluid_level) {
		this.producing_fluid_level = producing_fluid_level;
	}

	public Double getSubmergence_depth() {
		return submergence_depth;
	}

	public void setSubmergence_depth(Double submergence_depth) {
		this.submergence_depth = submergence_depth;
	}

	public String getPump_pressure() {
		return pump_pressure;
	}

	public void setPump_pressure(String pump_pressure) {
		this.pump_pressure = pump_pressure;
	}

	public Double getNitrogen_gas_delivery() {
		return nitrogen_gas_delivery;
	}

	public void setNitrogen_gas_delivery(Double nitrogen_gas_delivery) {
		this.nitrogen_gas_delivery = nitrogen_gas_delivery;
	}

	public Double getNitrogen_gas_volume() {
		return nitrogen_gas_volume;
	}

	public void setNitrogen_gas_volume(Double nitrogen_gas_volume) {
		this.nitrogen_gas_volume = nitrogen_gas_volume;
	}

	public Double getJu_shen() {
		return ju_shen;
	}

	public void setJu_shen(Double ju_shen) {
		this.ju_shen = ju_shen;
	}

	public Double getOil_pressure() {
		return oil_pressure;
	}

	public void setOil_pressure(Double oil_pressure) {
		this.oil_pressure = oil_pressure;
	}

	public Double getCasing_pressure() {
		return casing_pressure;
	}

	public void setCasing_pressure(Double casing_pressure) {
		this.casing_pressure = casing_pressure;
	}

	public Double getGlib_talker() {
		return glib_talker;
	}

	public void setGlib_talker(Double glib_talker) {
		this.glib_talker = glib_talker;
	}

	public Double getRotate_speed() {
		return rotate_speed;
	}

	public void setRotate_speed(Double rotate_speed) {
		this.rotate_speed = rotate_speed;
	}

	public Double getOutput_ye_volume() {
		return output_ye_volume;
	}

	public void setOutput_ye_volume(Double output_ye_volume) {
		this.output_ye_volume = output_ye_volume;
	}

	public Double getOutput_oil_volume() {
		return output_oil_volume;
	}

	public void setOutput_oil_volume(Double output_oil_volume) {
		this.output_oil_volume = output_oil_volume;
	}

	public Double getOutput_gas_volume() {
		return output_gas_volume;
	}

	public void setOutput_gas_volume(Double output_gas_volume) {
		this.output_gas_volume = output_gas_volume;
	}

	public Double getFree_water_content() {
		return free_water_content;
	}

	public void setFree_water_content(Double free_water_content) {
		this.free_water_content = free_water_content;
	}

	public Double getComposite_water_cut() {
		return composite_water_cut;
	}

	public void setComposite_water_cut(Double composite_water_cut) {
		this.composite_water_cut = composite_water_cut;
	}

	public Double getCumulative_ye_production() {
		return cumulative_ye_production;
	}

	public void setCumulative_ye_production(Double cumulative_ye_production) {
		this.cumulative_ye_production = cumulative_ye_production;
	}

	public Double getCumulative_oil_production() {
		return cumulative_oil_production;
	}

	public void setCumulative_oil_production(Double cumulative_oil_production) {
		this.cumulative_oil_production = cumulative_oil_production;
	}

	public Double getCumulative_gas_production() {
		return cumulative_gas_production;
	}

	public void setCumulative_gas_production(Double cumulative_gas_production) {
		this.cumulative_gas_production = cumulative_gas_production;
	}

	public Double getCumulative_water_production() {
		return cumulative_water_production;
	}

	public void setCumulative_water_production(Double cumulative_water_production) {
		this.cumulative_water_production = cumulative_water_production;
	}

	public String getJkwd() {
		return jkwd;
	}

	public void setJkwd(String jkwd) {
		this.jkwd = jkwd;
	}

	public String getHeight_level() {
		return height_level;
	}

	public void setHeight_level(String height_level) {
		this.height_level = height_level;
	}

	public Double getEmulsified_water() {
		return emulsified_water;
	}

	public void setEmulsified_water(Double emulsified_water) {
		this.emulsified_water = emulsified_water;
	}

	public Double getCrude_oil_water() {
		return crude_oil_water;
	}

	public void setCrude_oil_water(Double crude_oil_water) {
		this.crude_oil_water = crude_oil_water;
	}
	public byte[] getBigtext() {
		return bigtext;
	}

	public void setBigtext(byte[] bigtext) {
		this.bigtext = bigtext;
		if(bigtext!=null){
			this.bigtexts= new String (bigtext);
		}
	}

	public String getBigtexts() {
		return bigtexts;
	}

	public void setBigtexts(String bigtexts) {
		this.bigtexts = bigtexts;
	}

	public Integer getUp_pipe() {
		return up_pipe;
	}

	public void setUp_pipe(Integer up_pipe) {
		this.up_pipe = up_pipe;
	}

	public Integer getDown_pipe() {
		return down_pipe;
	}

	public void setDown_pipe(Integer down_pipe) {
		this.down_pipe = down_pipe;
	}

	public Integer getUp_rod() {
		return up_rod;
	}

	public void setUp_rod(Integer up_rod) {
		this.up_rod = up_rod;
	}

	public Integer getDown_rod() {
		return down_rod;
	}

	public void setDown_rod(Integer down_rod) {
		this.down_rod = down_rod;
	}
}
