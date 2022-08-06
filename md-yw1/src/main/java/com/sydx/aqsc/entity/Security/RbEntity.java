package com.sydx.aqsc.entity.Security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;
@ApiModel(value = "报表管理")
public class RbEntity {
	@ApiModelProperty(value="施工id")
	private String did; // 数据存储位
	@ApiModelProperty(value="施工参数id")
	private Integer pro_param_id; // 施工参数id
	@ApiModelProperty(value="施工参数名称")
	private String  paramname;//施工参数名称
	@ApiModelProperty(value="工序id")
	private Integer spid; // 工序id
	@ApiModelProperty(value="模板id")
	private String customid;
	@ApiModelProperty(value="工序数据id")
	private Integer pdid; // 工序数据id
	@ApiModelProperty(value="工序数据id")
	private Integer abc; // 工序数据id
	@ApiModelProperty(value="工序名称")
	private String spname;//工序名称
	@ApiModelProperty(value="内容")
	private String content; // 内容
	@ApiModelProperty(value="施工内容")
	private String buildcontent; // 施工内容
	@ApiModelProperty(value="施工内容模板")
	private String buildcontenttmp; // 施工内容模板
	@ApiModelProperty(value="要求")
	private String requirement; // 要求
	@ApiModelProperty(value="编辑标识：默认1不可编辑，使用模板替换，2可编辑")
	private String edittab; //编辑标识：默认1不可编辑，使用模板替换，2可编辑
	@ApiModelProperty(value="工具名称")
	private String tool_name;
	@ApiModelProperty(value="工具类型")
	private String model;
	@ApiModelProperty(value="工具单位")
	private String unit;
	@ApiModelProperty(value="工具数量")
	private Integer numb;
	@ApiModelProperty(value="生产厂家")
	private String product_unit;
	@ApiModelProperty(value="准备单位")
	private String prepare_unit;
	@ApiModelProperty(value="备注")
	private String note;
	@ApiModelProperty(value="分类")
	private String bzhsg;
	@ApiModelProperty(value="序号")
	private Integer xh;
	@ApiModelProperty(value="")
	private String sfwc;
	@ApiModelProperty(value="/班次")
	private String order_classes ;//班次
	@ApiModelProperty(value="上报日期")
	private String report_time ;//上报日期
	@ApiModelProperty(value="录入人")
	private String create_user;
	@ApiModelProperty(value="录入时间")
	private String create_time;
	@ApiModelProperty(value="ip")
	private String ip;
	@ApiModelProperty(value="油田")
	private String oilfield;
	@ApiModelProperty(value="修改人")
	private String last_user;
	@ApiModelProperty(value="修改时间")
	private String last_time;
	@ApiModelProperty(value="基础工序表")
	private String circuit_table;
	@ApiModelProperty(value="工序字段名")
	private String table_head;
	@ApiModelProperty(value="查询条件")
	private String whc;
	@ApiModelProperty(value="施工单元id")
    private String sgdyid;//施工单元id
	@ApiModelProperty(value="/施工单元名称")
    private String sgdymc;//施工单元名称
	@ApiModelProperty(value="施工单元序号")
	private Integer sgdyNo;//施工单元序号
	@ApiModelProperty(value="基础工序id")
	private String circuit_id;
	@ApiModelProperty(value="工序字段")
	private String field_sq;
	@ApiModelProperty(value="")
	private String process;
	@ApiModelProperty(value="工序开始时间")
	private String starttime;// 工序开始时间
	@ApiModelProperty(value="工序结束")
	private String endtime;// 工序结束
	@ApiModelProperty(value="参数数据值编号")
	private String parame_val_num;//参数数据值编号
	@ApiModelProperty(value="备注")
	private String remarks;//备注
	private byte[] bigtext;
	private String bigtexts;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Integer getPro_param_id() {
		return pro_param_id;
	}

	public void setPro_param_id(Integer pro_param_id) {
		this.pro_param_id = pro_param_id;
	}

	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public Integer getPdid() {
		return pdid;
	}

	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}

	public Integer getAbc() {
		return abc;
	}

	public void setAbc(Integer abc) {
		this.abc = abc;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBuildcontent() {
		return buildcontent;
	}

	public void setBuildcontent(String buildcontent) {
		this.buildcontent = buildcontent;
	}

	public String getBuildcontenttmp() {
		return buildcontenttmp;
	}

	public void setBuildcontenttmp(String buildcontenttmp) {
		this.buildcontenttmp = buildcontenttmp;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getEdittab() {
		return edittab;
	}

	public void setEdittab(String edittab) {
		this.edittab = edittab;
	}

	public String getTool_name() {
		return tool_name;
	}

	public void setTool_name(String tool_name) {
		this.tool_name = tool_name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getNumb() {
		return numb;
	}

	public void setNumb(Integer numb) {
		this.numb = numb;
	}

	public String getProduct_unit() {
		return product_unit;
	}

	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}

	public String getPrepare_unit() {
		return prepare_unit;
	}

	public void setPrepare_unit(String prepare_unit) {
		this.prepare_unit = prepare_unit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBzhsg() {
		return bzhsg;
	}

	public void setBzhsg(String bzhsg) {
		this.bzhsg = bzhsg;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getSfwc() {
		return sfwc;
	}

	public void setSfwc(String sfwc) {
		this.sfwc = sfwc;
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

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public String getLast_user() {
		return last_user;
	}

	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	public String getCircuit_table() {
		return circuit_table;
	}

	public void setCircuit_table(String circuit_table) {
		this.circuit_table = circuit_table;
	}

	public String getTable_head() {
		return table_head;
	}

	public void setTable_head(String table_head) {
		this.table_head = table_head;
	}

	public String getWhc() {
		return whc;
	}

	public void setWhc(String whc) {
		this.whc = whc;
	}

	public String getSgdyid() {
		return sgdyid;
	}

	public void setSgdyid(String sgdyid) {
		this.sgdyid = sgdyid;
	}

	public String getSgdymc() {
		return sgdymc;
	}

	public void setSgdymc(String sgdymc) {
		this.sgdymc = sgdymc;
	}

	public Integer getSgdyNo() {
		return sgdyNo;
	}

	public void setSgdyNo(Integer sgdyNo) {
		this.sgdyNo = sgdyNo;
	}

	public String getCircuit_id() {
		return circuit_id;
	}

	public void setCircuit_id(String circuit_id) {
		this.circuit_id = circuit_id;
	}

	public String getField_sq() {
		return field_sq;
	}

	public void setField_sq(String field_sq) {
		this.field_sq = field_sq;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
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

	public String getParame_val_num() {
		return parame_val_num;
	}

	public void setParame_val_num(String parame_val_num) {
		this.parame_val_num = parame_val_num;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public byte[] getBigtext() {
		return bigtext;
	}

	public void setBigtext(byte[] bigtext) {
		this.bigtext = bigtext;
	}

	public String getBigtexts() {
		return bigtexts;
	}

	public void setBigtexts(String bigtexts) {
		this.bigtexts = bigtexts;
	}
}