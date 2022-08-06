package com.cyrj.jxzy.entity.Constractor;

import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "施工过程监督检查")
public class Sgjdjc_J_ListEntity extends BaseEntity{

	private String jcid;
	@ApiModelProperty(value="施工单位名称")
	private String sgdw;//施工单位名称
	@ApiModelProperty(value="队伍资质")
	private String qualification_id;//队伍资质
	@ApiModelProperty(value="施工单位代码")
	private String construction_department;//施工单位代码
	@ApiModelProperty(value="施工小队名")
	private String sgxdss;//施工小队名
	@ApiModelProperty(value="施工小队代码")
	private String op_team;//施工小队代码
	@ApiModelProperty(value="井号")
	private String well_common_name;//井号
	@ApiModelProperty(value="措施类型大类")
	private String stim_type;//措施类型大类
	@ApiModelProperty(value="项目名称(施工项目)")
	private String item_name;//项目名称(施工项目)
	@ApiModelProperty(value="措施大类")
	private String csdl;//措施大类
	@ApiModelProperty(value="措施小类")
	private String csxl;//措施小类
	@ApiModelProperty(value="措施三类")
	private String cslb;//措施三类
	@ApiModelProperty(value="措施四类")
	private String cssil;//措施四类
	@ApiModelProperty(value="措施名字")
	private String cswl;//措施名字
	@ApiModelProperty(value="开工日期")
	private String start_time;//开工日期
	@ApiModelProperty(value="完工日期")
	private String complete_time;//完工日期
	@ApiModelProperty(value="井ID")
	private String well_id;//井ID
	@ApiModelProperty(value="设计串号")
	private String design_num;//设计串号
	@ApiModelProperty(value="施工总结ID_A5")
	private String construction_id;//施工总结ID_A5
	@ApiModelProperty(value="系统_所属单位代码")
	private String ssdwdm;//系统_所属单位代码
	@ApiModelProperty(value="分配时间")
	private String ffsj;//分配时间
	@ApiModelProperty(value="井别")
	private String well_purpose;//井别
	@ApiModelProperty(value="生产单位")
	private String scdw;//生产单位
	@ApiModelProperty(value="施工项目")
	private String item_sorte;//施工项目
	@ApiModelProperty(value="作业类型")
	private String zylx;//作业类型
    private String userid;
	@ApiModelProperty(value="采油厂")
    private String cyc;//采油厂
	@ApiModelProperty(value="采油矿")
    private String cyk;//采油矿
	@ApiModelProperty(value="采油队")
    private String cyd;//采油队
	@ApiModelProperty(value="施工单位")
    private String sgdw1;//施工单位
	@ApiModelProperty(value="施工小队")
    private String sgdw2;//施工小队
	@ApiModelProperty(value="标记1监督录入2承包商整改完成3复查完成")
	private String sign;//标记1监督录入2承包商整改完成3复查完成
	@ApiModelProperty(value="承包商查询权限")
	private String search_cbs;//承包商查询权限
	private List<Sgjdjc_J_ListEntity> entity_list;
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getSgdw() {
		return sgdw;
	}
	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}
	public String getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(String qualification_id) {
		this.qualification_id = qualification_id;
	}
	public String getConstruction_department() {
		return construction_department;
	}
	public void setConstruction_department(String construction_department) {
		this.construction_department = construction_department;
	}
	public String getSgxdss() {
		return sgxdss;
	}
	public void setSgxdss(String sgxdss) {
		this.sgxdss = sgxdss;
	}
	public String getOp_team() {
		return op_team;
	}
	public void setOp_team(String op_team) {
		this.op_team = op_team;
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
	public String getCswl() {
		return cswl;
	}
	public void setCswl(String cswl) {
		this.cswl = cswl;
	}

	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getComplete_time() {
		return complete_time;
	}
	public void setComplete_time(String complete_time) {
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
	public String getSsdwdm() {
		return ssdwdm;
	}
	public void setSsdwdm(String ssdwdm) {
		this.ssdwdm = ssdwdm;
	}
	public String getFfsj() {
		return ffsj;
	}
	public void setFfsj(String ffsj) {
		this.ffsj = ffsj;
	}
	public String getWell_purpose() {
		return well_purpose;
	}
	public void setWell_purpose(String well_purpose) {
		this.well_purpose = well_purpose;
	}
	public String getScdw() {
		return scdw;
	}
	public void setScdw(String scdw) {
		this.scdw = scdw;
	}
	public String getItem_sorte() {
		return item_sorte;
	}
	public void setItem_sorte(String item_sorte) {
		this.item_sorte = item_sorte;
	}
	public String getZylx() {
		return zylx;
	}
	public void setZylx(String zylx) {
		this.zylx = zylx;
	}
	public List<Sgjdjc_J_ListEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<Sgjdjc_J_ListEntity> entity_list) {
		this.entity_list = entity_list;
	}
	
	public String getCsdl() {
		return csdl;
	}
	public void setCsdl(String csdl) {
		this.csdl = csdl;
	}
	public String getCsxl() {
		return csxl;
	}
	public void setCsxl(String csxl) {
		this.csxl = csxl;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getCyc() {
		return cyc;
	}
	public void setCyc(String cyc) {
		this.cyc = cyc;
	}
	public String getCyk() {
		return cyk;
	}
	public void setCyk(String cyk) {
		this.cyk = cyk;
	}
	public String getCyd() {
		return cyd;
	}
	public void setCyd(String cyd) {
		this.cyd = cyd;
	}
	public String getSgdw1() {
		return sgdw1;
	}
	public void setSgdw1(String sgdw1) {
		this.sgdw1 = sgdw1;
	}
	public String getSgdw2() {
		return sgdw2;
	}
	public void setSgdw2(String sgdw2) {
		this.sgdw2 = sgdw2;
	}
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSearch_cbs() {
		return search_cbs;
	}

	public void setSearch_cbs(String search_cbs) {
		this.search_cbs = search_cbs;
	}

	@Override
	public String toString() {
		return "Sgjdjc_J_ListEntity [jcid=" + jcid + ", sgdw=" + sgdw
				+ ", qualification_id=" + qualification_id
				+ ", construction_department=" + construction_department
				+ ", sgxdss=" + sgxdss + ", op_team=" + op_team
				+ ", well_common_name=" + well_common_name + ", stim_type="
				+ stim_type + ", item_name=" + item_name + ", cslb=" + cslb
				+ ", cssil=" + cssil + ", cswl=" + cswl + ", start_time="
				+ start_time + ", complete_time=" + complete_time
				+ ", well_id=" + well_id + ", design_num=" + design_num
				+ ", construction_id=" + construction_id + ", ssdwdm=" + ssdwdm
				+ ", ffsj=" + ffsj + ", well_purpose=" + well_purpose
				+ ", scdw=" + scdw + ", item_sorte=" + item_sorte + ", zylx="
				+ zylx + ", entity_list=" + entity_list + "]";
	}

	
	
	
	
}
