package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;
import com.sydx.aqsc.entity.Admin.Pager;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
@ApiModel(value = "工序管理类")
public class GxEntity extends BaseEntity {
	@ApiModelProperty(value="序号")
	private Integer xh;
	@ApiModelProperty(value="")
	private String eng_code;
	@ApiModelProperty(value="标准工序ID")
	private Integer spid; // 标准工序ID
	@ApiModelProperty(value="标准工序编号")
	private Integer pdid; // 标准工序编号
	@ApiModelProperty(value="工序名称")
	private String spname; // 工序名称
	@ApiModelProperty(value="自定义工序施工内容模板")
	private String customname;//自定义工序施工内容模板
	@ApiModelProperty(value="适用油田")
	private String oilfield; // 适用油田
	@ApiModelProperty(value="当前状态（默认0，备选1）")
	private Integer state; // 当前状态（默认0，备选1）
	@ApiModelProperty(value="施工内容拼接串")
	private String buildcontent; // 施工内容拼接串
	@ApiModelProperty(value=" 施工内容拼接串")
	private String buildcontentTMP; // 施工内容拼接串
	@ApiModelProperty(value="/要求")
	private  String requirement;//要求
	@ApiModelProperty(value="/编辑标识：默认1不可编辑，使用模板替换，2可编辑")
	private String edittab; //编辑标识：默认1不可编辑，使用模板替换，2可编辑
	@ApiModelProperty(value="")
	private String sels;//列表
	@ApiModelProperty(value="录入时间")
	private String intime;
	@ApiModelProperty(value="录入人")
	private String user_id;//用户（用于模板定制）
	@ApiModelProperty(value="工序别名")
	private String aothname;
	@ApiModelProperty(value="是否为空")
	private String is_extra;
	@ApiModelProperty(value="是否使用")
	private String is_use;
	@ApiModelProperty(value="是否为空")
	private String is_null;
	@ApiModelProperty(value="是否显示")
	private String is_show;
	@ApiModelProperty(value="")
	private String is_null_oil;
	@ApiModelProperty(value="")
	private String is_show_oil;
	@ApiModelProperty(value="")
	private String customid;
	@ApiModelProperty(value="")
	private String field_sq;
	@ApiModelProperty(value="")
	private String code_associate_table;
	@ApiModelProperty(value="")
	private String code_associate_field;
	@ApiModelProperty(value="工序字段名称")
	private String table_head;
	@ApiModelProperty(value="基础工序表")
	private String circuit_table;
	@ApiModelProperty(value="字段类型")
	private String field_type;
	@ApiModelProperty(value="模本类型")
	private String customtype;
	@ApiModelProperty(value="标准工时")
	private Double working_hours;//标准工时
	@ApiModelProperty(value="标准用时")
	private Double use_hours;//标准用时
	@ApiModelProperty(value="工序系数")
	private Double coefficient;//工序系数
	@ApiModelProperty(value="单位id")
	private String unit_id;
	@ApiModelProperty(value="设计模板id")
	private String customid_sj;//设计模板id
	@ApiModelProperty(value="设计模板内容")
	private String buildcontent_sj;//设计模板内容
	@ApiModelProperty(value="标识")
	private String tab;
	@ApiModelProperty(value="施工单元id")
	private String sgdyid;//施工单元id
	@ApiModelProperty(value="施工单元名称")
	private String sgdymc;//施工单元名称
	@ApiModelProperty(value="施工单元编号")
	private Integer sgdyNo;//施工单元编号
	@ApiModelProperty(value="泵注程序:压裂施工泵注、防砂施工泵注")
	private String bzcs;//泵注程序:压裂施工泵注、防砂施工泵注
	@ApiModelProperty(value="施工参数ID")
	private Integer id; // 施工参数ID
	@ApiModelProperty(value="施工参数名称")
	private String param; // 施工参数名称
	@ApiModelProperty(value="备注")
	private String remark; // 备注
	@ApiModelProperty(value="数据类型")
	private String datatype;//数据类型
	@ApiModelProperty(value="计量单位")
	private String units;//计量单位
	@ApiModelProperty(value="模板数据")
	private String tempdata;//模板数据
	@ApiModelProperty(value="录入数据")
	private String paramdata;//录入数据
	@ApiModelProperty(value="标准工时")
	private String bzgs;//标准工时
	@ApiModelProperty(value="基础工序id")
	private  String circuit_id;//基础工序id
	@ApiModelProperty(value="基础工序名称")
	private  String circuit_name;//基础工序名称
	@ApiModelProperty(value="参数id")
	private String parame_val_num;
	@ApiModelProperty(value="操作规程")
	private String czgc;//操作规程
	@ApiModelProperty(value="操作规程")
	private Integer czgcid;//操作规程
	@ApiModelProperty(value="风险提示")
	private String fxts;//风险提示
	@ApiModelProperty(value="风险提示")
	private Integer fxtsid;//风险提示

	private Pager pager;
	@ApiModelProperty(value="施工id")
	private  String did;
	@ApiModelProperty(value="井号")
	private  String well_common_name;
	@ApiModelProperty(value="查询条件")
	public String whc;
	@ApiModelProperty(value="工序定制状态")
	public String dzzt;//工序定制状态
	@ApiModelProperty(value="工序定制说明")
	public String dzsm;//工序定制说明
	@ApiModelProperty(value="工序类别")
	public String gxlb;//工序类别
	@ApiModelProperty(value="作业类型")
	public String zylx;//作业类型

	private byte[] bigtext;
	private String bigtexts;
	private List<GxEntity> entityList;

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getEng_code() {
		return eng_code;
	}

	public void setEng_code(String eng_code) {
		this.eng_code = eng_code;
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

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public String getCustomname() {
		return customname;
	}

	public void setCustomname(String customname) {
		this.customname = customname;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getBuildcontent() {
		return buildcontent;
	}

	public void setBuildcontent(String buildcontent) {
		this.buildcontent = buildcontent;
	}

	public String getBuildcontentTMP() {
		return buildcontentTMP;
	}

	public void setBuildcontentTMP(String buildcontentTMP) {
		this.buildcontentTMP = buildcontentTMP;
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

	public String getSels() {
		return sels;
	}

	public void setSels(String sels) {
		this.sels = sels;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAothname() {
		return aothname;
	}

	public void setAothname(String aothname) {
		this.aothname = aothname;
	}

	public String getIs_extra() {
		return is_extra;
	}

	public void setIs_extra(String is_extra) {
		this.is_extra = is_extra;
	}

	public String getIs_use() {
		return is_use;
	}

	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}

	public String getIs_null() {
		return is_null;
	}

	public void setIs_null(String is_null) {
		this.is_null = is_null;
	}

	public String getIs_show() {
		return is_show;
	}

	public void setIs_show(String is_show) {
		this.is_show = is_show;
	}

	public String getIs_null_oil() {
		return is_null_oil;
	}

	public void setIs_null_oil(String is_null_oil) {
		this.is_null_oil = is_null_oil;
	}

	public String getIs_show_oil() {
		return is_show_oil;
	}

	public void setIs_show_oil(String is_show_oil) {
		this.is_show_oil = is_show_oil;
	}

	public String getCustomid() {
		return customid;
	}

	public void setCustomid(String customid) {
		this.customid = customid;
	}

	public String getField_sq() {
		return field_sq;
	}

	public void setField_sq(String field_sq) {
		this.field_sq = field_sq;
	}

	public String getCode_associate_table() {
		return code_associate_table;
	}

	public void setCode_associate_table(String code_associate_table) {
		this.code_associate_table = code_associate_table;
	}

	public String getCode_associate_field() {
		return code_associate_field;
	}

	public void setCode_associate_field(String code_associate_field) {
		this.code_associate_field = code_associate_field;
	}

	public String getTable_head() {
		return table_head;
	}

	public void setTable_head(String table_head) {
		this.table_head = table_head;
	}

	public String getCircuit_table() {
		return circuit_table;
	}

	public void setCircuit_table(String circuit_table) {
		this.circuit_table = circuit_table;
	}

	public String getField_type() {
		return field_type;
	}

	public void setField_type(String field_type) {
		this.field_type = field_type;
	}

	public String getCustomtype() {
		return customtype;
	}

	public void setCustomtype(String customtype) {
		this.customtype = customtype;
	}

	public Double getWorking_hours() {
		return working_hours;
	}

	public void setWorking_hours(Double working_hours) {
		this.working_hours = working_hours;
	}

	public Double getUse_hours() {
		return use_hours;
	}

	public void setUse_hours(Double use_hours) {
		this.use_hours = use_hours;
	}

	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getCustomid_sj() {
		return customid_sj;
	}

	public void setCustomid_sj(String customid_sj) {
		this.customid_sj = customid_sj;
	}

	public String getBuildcontent_sj() {
		return buildcontent_sj;
	}

	public void setBuildcontent_sj(String buildcontent_sj) {
		this.buildcontent_sj = buildcontent_sj;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
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

	public String getBzcs() {
		return bzcs;
	}

	public void setBzcs(String bzcs) {
		this.bzcs = bzcs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getTempdata() {
		return tempdata;
	}

	public void setTempdata(String tempdata) {
		this.tempdata = tempdata;
	}

	public String getParamdata() {
		return paramdata;
	}

	public void setParamdata(String paramdata) {
		this.paramdata = paramdata;
	}

	public String getBzgs() {
		return bzgs;
	}

	public void setBzgs(String bzgs) {
		this.bzgs = bzgs;
	}

	public String getCircuit_id() {
		return circuit_id;
	}

	public void setCircuit_id(String circuit_id) {
		this.circuit_id = circuit_id;
	}

	public String getCircuit_name() {
		return circuit_name;
	}

	public void setCircuit_name(String circuit_name) {
		this.circuit_name = circuit_name;
	}

	public String getParame_val_num() {
		return parame_val_num;
	}

	public void setParame_val_num(String parame_val_num) {
		this.parame_val_num = parame_val_num;
	}

	public String getCzgc() {
		return czgc;
	}

	public void setCzgc(String czgc) {
		this.czgc = czgc;
	}

	public Integer getCzgcid() {
		return czgcid;
	}

	public void setCzgcid(Integer czgcid) {
		this.czgcid = czgcid;
	}

	public String getFxts() {
		return fxts;
	}

	public void setFxts(String fxts) {
		this.fxts = fxts;
	}

	public Integer getFxtsid() {
		return fxtsid;
	}

	public void setFxtsid(Integer fxtsid) {
		this.fxtsid = fxtsid;
	}


	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
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

	public String getWhc() {
		return whc;
	}

	public void setWhc(String whc) {
		this.whc = whc;
	}

	public String getDzzt() {
		return dzzt;
	}

	public void setDzzt(String dzzt) {
		this.dzzt = dzzt;
	}

	public String getDzsm() {
		return dzsm;
	}

	public void setDzsm(String dzsm) {
		this.dzsm = dzsm;
	}

	public String getGxlb() {
		return gxlb;
	}

	public void setGxlb(String gxlb) {
		this.gxlb = gxlb;
	}

	public String getZylx() {
		return zylx;
	}

	public void setZylx(String zylx) {
		this.zylx = zylx;
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

	public List<GxEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<GxEntity> entityList) {
		this.entityList = entityList;
	}
}