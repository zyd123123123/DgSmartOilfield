package com.cyrj.jxzy.entity.Constractor;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "绩效评估")
public class JxpgEntity extends BaseEntity{
	@ApiModelProperty(value="油田")
	private String oilfield;
	@ApiModelProperty(value="单位属性：1作业 2非作业")
	private String attribute;//单位属性：1作业 2非作业
	@ApiModelProperty(value="用户权限")
	private String search;//用户权限
	@ApiModelProperty(value="绩效评估年份")
	private String year;//绩效评估年份
	@ApiModelProperty(value="绩效评估id")
	private String jxpgid;//绩效评估id
	@ApiModelProperty(value="承包商名称")
	private String contractor_name; // 承包商名称
	@ApiModelProperty(value="承包商ID")
	private String contractor_id; // 承包商ID
	@ApiModelProperty(value="施工项目")
	private String construction_project; // 施工项目
	@ApiModelProperty(value="甲方单位")
	private String unit_name;//甲方单位
	@ApiModelProperty(value="甲方单位")
	private String unit_id;//甲方单位
	@ApiModelProperty(value="合计工作量(井次)-合同")
	private int workload_ht; // 合计工作量(井次)-合同
	@ApiModelProperty(value="合计标的金额-合同")
	private String money_ht; // 合计标的金额-合同
	@ApiModelProperty(value="合计工作量(井次)-队伍")
	private int workload_dw; // 合计工作量(井次)-队伍
	@ApiModelProperty(value="合计标的金额-队伍")
	private String money_dw; // 合计标的金额-队伍
	@ApiModelProperty(value="HSE承诺履行实得分")
	private String hse_score;//HSE承诺履行实得分
	@ApiModelProperty(value="HSE承诺履行备注")
	private String hse_remarks;//HSE承诺履行备注
	@ApiModelProperty(value="人员符合情况实得分")
	private String staff_compliance_score;//人员符合情况实得分
	@ApiModelProperty(value="人员符合情况备注")
	private String staff_compliance_remarks;//人员符合情况备注
	@ApiModelProperty(value="井下作业健康实得分")
	private String healthy_score;//井下作业健康实得分
	@ApiModelProperty(value="井下作业健康备注")
	private String healthy_remarks;//井下作业健康备注
	@ApiModelProperty(value="设备设施本质安全性能实得分")
	private String safety_performance_score;//设备设施本质安全性能实得分
	@ApiModelProperty(value="设备设施本质安全性能备注")
	private String safety_performance_remarks;//设备设施本质安全性能备注
	@ApiModelProperty(value="设备设施安全实得分")
	private String safety_score;//设备设施安全实得分
	@ApiModelProperty(value="设备设施安全备注")
	private String safety_remarks;//设备设施安全备注
	@ApiModelProperty(value="用电安全实得分")
	private String electrical_safety_score;//用电安全实得分
	@ApiModelProperty(value="用电安全备注")
	private String electrical_safety_remarks;//用电安全备注
	@ApiModelProperty(value="消防安全实得分")
	private String fire_safety_score;//消防安全实得分
	@ApiModelProperty(value="消防安全备注")
	private String fire_safety_remarks;//消防安全备注
	@ApiModelProperty(value="施工安全实得分")
	private String construction_safety_score;//施工安全实得分
	@ApiModelProperty(value="施工安全备注")
	private String construction_safety_remarks;//施工安全备注
	@ApiModelProperty(value="施工质量实得分")
	private String construction_quality_score;//施工质量实得分
	@ApiModelProperty(value="施工质量备注")
	private String construction_quality_remarks;//施工质量备注
	@ApiModelProperty(value="井控管理实得分")
	private String well_control_score;//井控管理实得分
	@ApiModelProperty(value="井控管理备注")
	private String well_control_remarks;//井控管理备注
	@ApiModelProperty(value="环保管理1实得分")
	private String environmentalprotection_score1;//环保管理1实得分
	@ApiModelProperty(value="环保管理1备注environmentalprotection_remar1")
	private String environmentalprotection_remar1;//环保管理1备注environmentalprotection_remar1
	@ApiModelProperty(value="环保管理2实得分")
	private String environmentalprotection_score2;//环保管理2实得分
	@ApiModelProperty(value="环保管理2备注")
	private String environmentalprotection_remar2;//环保管理2备注
	@ApiModelProperty(value="质量评价实得分")
	private String quality_evaluation_score;//质量评价实得分
	@ApiModelProperty(value="质量评价备注")
	private String quality_evaluation_remarks;//质量评价备注
	@ApiModelProperty(value="施工总结平均上传周期实得分")
	private String construction_summary_score;//施工总结平均上传周期实得分
	@ApiModelProperty(value="施工总结平均上传周期备注")
	private String construction_summary_remarks;//施工总结平均上传周期备注
	@ApiModelProperty(value="平均交井周期实得分")
	private String cross_well_score;//平均交井周期实得分
	@ApiModelProperty(value="平均交井备注")
	private String cross_well_remarks;//平均交井备注
	@ApiModelProperty(value="小计分数")
	private String small_plan_score;//小计分数
	@ApiModelProperty(value="小计备注")
	private String small_plan_remarks;//小计备注
	@ApiModelProperty(value="奖惩1实得分（发生一般B级及以下安全、环保责任事故的）")
	private String reward_punishment_score1;//奖惩1实得分（发生一般B级及以下安全、环保责任事故的）
	@ApiModelProperty(value="奖惩1备注（发生一般B级及以下安全、环保责任事故的）")
	private String reward_punishment_remarks1;//奖惩1备注（发生一般B级及以下安全、环保责任事故的）
	@ApiModelProperty(value="奖惩2实得分（因安全环保违法行为受到地方政府有关部门行政处罚的）")
	private String reward_punishment_score2;//奖惩2实得分（因安全环保违法行为受到地方政府有关部门行政处罚的）
	@ApiModelProperty(value="奖惩2备注（因安全环保违法行为受到地方政府有关部门行政处罚的）")
	private String reward_punishment_remarks2;//奖惩2备注（因安全环保违法行为受到地方政府有关部门行政处罚的）
	@ApiModelProperty(value="奖惩3实得分（因安全环保工怍突出受到地方政府有关部门或采油厂（公司）表彰的）")
	private String reward_punishment_score3;//奖惩3实得分（因安全环保工怍突出受到地方政府有关部门或采油厂（公司）表彰的）
	@ApiModelProperty(value="奖惩3备注（因安全环保工怍突出受到地方政府有关部门或采油厂（公司）表彰的）")
	private String reward_punishment_remarks3;//奖惩3备注（因安全环保工怍突出受到地方政府有关部门或采油厂（公司）表彰的）
	@ApiModelProperty(value="奖惩4实得分（污油污水回收装置配备使用情况）")
	private String reward_punishment_score4;//奖惩4实得分（污油污水回收装置配备使用情况）
	@ApiModelProperty(value="奖惩4备注（污油污水回收装置配备使用情况）")
	private String reward_punishment_remarks4;//奖惩4备注（污油污水回收装置配备使用情况）
	@ApiModelProperty(value="奖惩5实得分（井口集液装置配备使用情况）")
	private String reward_punishment_score5;//奖惩5实得分（井口集液装置配备使用情况）
	@ApiModelProperty(value="奖惩5备注（井口集液装置配备使用情况）")
	private String reward_punishment_remarks5;//奖惩5备注（井口集液装置配备使用情况）
	@ApiModelProperty(value="奖惩6实得分（高温超导热洗车（用于实现油管、抽油杆在线清洗）配备使用情况）")
	private String reward_punishment_score6;//奖惩6实得分（高温超导热洗车（用于实现油管、抽油杆在线清洗）配备使用情况）
	@ApiModelProperty(value="奖惩6备注（高温超导热洗车（用于实现油管、抽油杆在线清洗）配备使用情况）")
	private String reward_punishment_remarks6;//奖惩6备注（高温超导热洗车（用于实现油管、抽油杆在线清洗）配备使用情况）
	@ApiModelProperty(value="合计得分")
	private String total_score;//合计得分
	@ApiModelProperty(value="合计得分备注")
	private String total_remarks;//合计得分备注
	@ApiModelProperty(value="否决项1")
	private String vetoed1;//否决项1
	@ApiModelProperty(value="否决项备注1")
	private String vetoed_remarks1;//否决项备注1
	@ApiModelProperty(value="否决项2")
	private String vetoed2;//否决项2
	@ApiModelProperty(value="否决项备注2")
	private String vetoed_remarks2;//否决项备注2
	@ApiModelProperty(value="否决项3")
	private String vetoed3;//否决项3
	@ApiModelProperty(value="否决项备注3")
	private String vetoed_remarks3;//否决项备注3
	private String evaluation_conclusion;//
	@ApiModelProperty(value="承包商负责人")
	private String cbsfzr;//承包商负责人
	@ApiModelProperty(value="井下作业主管部门")
	private String jxzyzg;//井下作业主管部门
	@ApiModelProperty(value="安全环保部门")
	private String aqhbbm;//安全环保部门
	@ApiModelProperty(value="评估人")
	private String assessment_person;//评估人
	private String assessment_time;//
	@ApiModelProperty(value="评估总分数（不包含防砂布铺设5.00和质量评价10.00，共计15分）")
	private String zfs;//评估总分数（不包含防砂布铺设5.00和质量评价10.00，共计15分）
	@ApiModelProperty(value="评估总分数（包含防砂布铺设5.00和质量评价10.00，共计15分）")
	private String zfs_qb;//评估总分数（包含防砂布铺设5.00和质量评价10.00，共计15分）
	@ApiModelProperty(value="绩效评估标识：1原绩效评估，按合同开完工日期关联井完工日期查询，存在井数重复问题；2新绩效评估，井和合同绑定")
	private String  jxpg_tab;//绩效评估标识：1原绩效评估，按合同开完工日期关联井完工日期查询，存在井数重复问题；2新绩效评估，井和合同绑定
	private List<Jxpg_Ht_DwEntity> entity_list=  new ArrayList<Jxpg_Ht_DwEntity>();
	public String getJxpg_tab() {
		return jxpg_tab;
	}
	public void setJxpg_tab(String jxpg_tab) {
		this.jxpg_tab = jxpg_tab;
	}
	public String getJxpgid() {
		return jxpgid;
	}
	public void setJxpgid(String jxpgid) {
		this.jxpgid = jxpgid;
	}
	public String getContractor_name() {
		return contractor_name;
	}
	public void setContractor_name(String contractor_name) {
		this.contractor_name = contractor_name;
	}
	public String getContractor_id() {
		return contractor_id;
	}
	public void setContractor_id(String contractor_id) {
		this.contractor_id = contractor_id;
	}
	public String getConstruction_project() {
		return construction_project;
	}
	public void setConstruction_project(String construction_project) {
		this.construction_project = construction_project;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public int getWorkload_ht() {
		return workload_ht;
	}
	public void setWorkload_ht(int workload_ht) {
		this.workload_ht = workload_ht;
	}
	public String getMoney_ht() {
		return money_ht;
	}
	public void setMoney_ht(String money_ht) {
		this.money_ht = money_ht;
	}
	public int getWorkload_dw() {
		return workload_dw;
	}
	public void setWorkload_dw(int workload_dw) {
		this.workload_dw = workload_dw;
	}
	public String getMoney_dw() {
		return money_dw;
	}
	public void setMoney_dw(String money_dw) {
		this.money_dw = money_dw;
	}
	public String getHse_score() {
		return hse_score;
	}
	public void setHse_score(String hse_score) {
		this.hse_score = hse_score;
	}
	public String getHse_remarks() {
		return hse_remarks;
	}
	public void setHse_remarks(String hse_remarks) {
		this.hse_remarks = hse_remarks;
	}
	public String getStaff_compliance_score() {
		return staff_compliance_score;
	}
	public void setStaff_compliance_score(String staff_compliance_score) {
		this.staff_compliance_score = staff_compliance_score;
	}
	public String getStaff_compliance_remarks() {
		return staff_compliance_remarks;
	}
	public void setStaff_compliance_remarks(String staff_compliance_remarks) {
		this.staff_compliance_remarks = staff_compliance_remarks;
	}
	public String getHealthy_score() {
		return healthy_score;
	}
	public void setHealthy_score(String healthy_score) {
		this.healthy_score = healthy_score;
	}
	public String getHealthy_remarks() {
		return healthy_remarks;
	}
	public void setHealthy_remarks(String healthy_remarks) {
		this.healthy_remarks = healthy_remarks;
	}
	public String getSafety_performance_score() {
		return safety_performance_score;
	}
	public void setSafety_performance_score(String safety_performance_score) {
		this.safety_performance_score = safety_performance_score;
	}
	public String getSafety_performance_remarks() {
		return safety_performance_remarks;
	}
	public void setSafety_performance_remarks(String safety_performance_remarks) {
		this.safety_performance_remarks = safety_performance_remarks;
	}
	public String getSafety_score() {
		return safety_score;
	}
	public void setSafety_score(String safety_score) {
		this.safety_score = safety_score;
	}
	public String getSafety_remarks() {
		return safety_remarks;
	}
	public void setSafety_remarks(String safety_remarks) {
		this.safety_remarks = safety_remarks;
	}
	public String getElectrical_safety_score() {
		return electrical_safety_score;
	}
	public void setElectrical_safety_score(String electrical_safety_score) {
		this.electrical_safety_score = electrical_safety_score;
	}
	public String getElectrical_safety_remarks() {
		return electrical_safety_remarks;
	}
	public void setElectrical_safety_remarks(String electrical_safety_remarks) {
		this.electrical_safety_remarks = electrical_safety_remarks;
	}
	public String getFire_safety_score() {
		return fire_safety_score;
	}
	public void setFire_safety_score(String fire_safety_score) {
		this.fire_safety_score = fire_safety_score;
	}
	public String getFire_safety_remarks() {
		return fire_safety_remarks;
	}
	public void setFire_safety_remarks(String fire_safety_remarks) {
		this.fire_safety_remarks = fire_safety_remarks;
	}
	public String getConstruction_safety_score() {
		return construction_safety_score;
	}
	public void setConstruction_safety_score(String construction_safety_score) {
		this.construction_safety_score = construction_safety_score;
	}
	public String getConstruction_safety_remarks() {
		return construction_safety_remarks;
	}
	public void setConstruction_safety_remarks(String construction_safety_remarks) {
		this.construction_safety_remarks = construction_safety_remarks;
	}
	public String getConstruction_quality_score() {
		return construction_quality_score;
	}
	public void setConstruction_quality_score(String construction_quality_score) {
		this.construction_quality_score = construction_quality_score;
	}
	public String getConstruction_quality_remarks() {
		return construction_quality_remarks;
	}
	public void setConstruction_quality_remarks(String construction_quality_remarks) {
		this.construction_quality_remarks = construction_quality_remarks;
	}
	public String getWell_control_score() {
		return well_control_score;
	}
	public void setWell_control_score(String well_control_score) {
		this.well_control_score = well_control_score;
	}
	public String getWell_control_remarks() {
		return well_control_remarks;
	}
	public void setWell_control_remarks(String well_control_remarks) {
		this.well_control_remarks = well_control_remarks;
	}
	public String getEnvironmentalprotection_score1() {
		return environmentalprotection_score1;
	}
	public void setEnvironmentalprotection_score1(String environmentalprotection_score1) {
		this.environmentalprotection_score1 = environmentalprotection_score1;
	}
	public String getEnvironmentalprotection_remar1() {
		return environmentalprotection_remar1;
	}
	public void setEnvironmentalprotection_remar1(String environmentalprotection_remar1) {
		this.environmentalprotection_remar1 = environmentalprotection_remar1;
	}
	public String getEnvironmentalprotection_score2() {
		return environmentalprotection_score2;
	}
	public void setEnvironmentalprotection_score2(String environmentalprotection_score2) {
		this.environmentalprotection_score2 = environmentalprotection_score2;
	}
	public String getEnvironmentalprotection_remar2() {
		return environmentalprotection_remar2;
	}
	public void setEnvironmentalprotection_remar2(String environmentalprotection_remar2) {
		this.environmentalprotection_remar2 = environmentalprotection_remar2;
	}
	public String getQuality_evaluation_score() {
		return quality_evaluation_score;
	}
	public void setQuality_evaluation_score(String quality_evaluation_score) {
		this.quality_evaluation_score = quality_evaluation_score;
	}
	public String getQuality_evaluation_remarks() {
		return quality_evaluation_remarks;
	}
	public void setQuality_evaluation_remarks(String quality_evaluation_remarks) {
		this.quality_evaluation_remarks = quality_evaluation_remarks;
	}
	public String getConstruction_summary_score() {
		return construction_summary_score;
	}
	public void setConstruction_summary_score(String construction_summary_score) {
		this.construction_summary_score = construction_summary_score;
	}
	public String getConstruction_summary_remarks() {
		return construction_summary_remarks;
	}
	public void setConstruction_summary_remarks(String construction_summary_remarks) {
		this.construction_summary_remarks = construction_summary_remarks;
	}
	public String getCross_well_score() {
		return cross_well_score;
	}
	public void setCross_well_score(String cross_well_score) {
		this.cross_well_score = cross_well_score;
	}
	public String getCross_well_remarks() {
		return cross_well_remarks;
	}
	public void setCross_well_remarks(String cross_well_remarks) {
		this.cross_well_remarks = cross_well_remarks;
	}
	public String getSmall_plan_score() {
		return small_plan_score;
	}
	public void setSmall_plan_score(String small_plan_score) {
		this.small_plan_score = small_plan_score;
	}
	public String getSmall_plan_remarks() {
		return small_plan_remarks;
	}
	public void setSmall_plan_remarks(String small_plan_remarks) {
		this.small_plan_remarks = small_plan_remarks;
	}
	public String getReward_punishment_score1() {
		return reward_punishment_score1;
	}
	public void setReward_punishment_score1(String reward_punishment_score1) {
		this.reward_punishment_score1 = reward_punishment_score1;
	}
	public String getReward_punishment_remarks1() {
		return reward_punishment_remarks1;
	}
	public void setReward_punishment_remarks1(String reward_punishment_remarks1) {
		this.reward_punishment_remarks1 = reward_punishment_remarks1;
	}
	public String getReward_punishment_score2() {
		return reward_punishment_score2;
	}
	public void setReward_punishment_score2(String reward_punishment_score2) {
		this.reward_punishment_score2 = reward_punishment_score2;
	}
	public String getReward_punishment_remarks2() {
		return reward_punishment_remarks2;
	}
	public void setReward_punishment_remarks2(String reward_punishment_remarks2) {
		this.reward_punishment_remarks2 = reward_punishment_remarks2;
	}
	public String getReward_punishment_score3() {
		return reward_punishment_score3;
	}
	public void setReward_punishment_score3(String reward_punishment_score3) {
		this.reward_punishment_score3 = reward_punishment_score3;
	}
	public String getReward_punishment_remarks3() {
		return reward_punishment_remarks3;
	}
	public void setReward_punishment_remarks3(String reward_punishment_remarks3) {
		this.reward_punishment_remarks3 = reward_punishment_remarks3;
	}
	public String getReward_punishment_score4() {
		return reward_punishment_score4;
	}
	public void setReward_punishment_score4(String reward_punishment_score4) {
		this.reward_punishment_score4 = reward_punishment_score4;
	}
	public String getReward_punishment_remarks4() {
		return reward_punishment_remarks4;
	}
	public void setReward_punishment_remarks4(String reward_punishment_remarks4) {
		this.reward_punishment_remarks4 = reward_punishment_remarks4;
	}
	public String getReward_punishment_score5() {
		return reward_punishment_score5;
	}
	public void setReward_punishment_score5(String reward_punishment_score5) {
		this.reward_punishment_score5 = reward_punishment_score5;
	}
	public String getReward_punishment_remarks5() {
		return reward_punishment_remarks5;
	}
	public void setReward_punishment_remarks5(String reward_punishment_remarks5) {
		this.reward_punishment_remarks5 = reward_punishment_remarks5;
	}
	public String getReward_punishment_score6() {
		return reward_punishment_score6;
	}
	public void setReward_punishment_score6(String reward_punishment_score6) {
		this.reward_punishment_score6 = reward_punishment_score6;
	}
	public String getReward_punishment_remarks6() {
		return reward_punishment_remarks6;
	}
	public void setReward_punishment_remarks6(String reward_punishment_remarks6) {
		this.reward_punishment_remarks6 = reward_punishment_remarks6;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
	public String getTotal_remarks() {
		return total_remarks;
	}
	public void setTotal_remarks(String total_remarks) {
		this.total_remarks = total_remarks;
	}
	public String getVetoed1() {
		return vetoed1;
	}
	public void setVetoed1(String vetoed1) {
		this.vetoed1 = vetoed1;
	}
	public String getVetoed_remarks1() {
		return vetoed_remarks1;
	}
	public void setVetoed_remarks1(String vetoed_remarks1) {
		this.vetoed_remarks1 = vetoed_remarks1;
	}
	public String getVetoed2() {
		return vetoed2;
	}
	public void setVetoed2(String vetoed2) {
		this.vetoed2 = vetoed2;
	}
	public String getVetoed_remarks2() {
		return vetoed_remarks2;
	}
	public void setVetoed_remarks2(String vetoed_remarks2) {
		this.vetoed_remarks2 = vetoed_remarks2;
	}
	public String getVetoed3() {
		return vetoed3;
	}
	public void setVetoed3(String vetoed3) {
		this.vetoed3 = vetoed3;
	}
	public String getVetoed_remarks3() {
		return vetoed_remarks3;
	}
	public void setVetoed_remarks3(String vetoed_remarks3) {
		this.vetoed_remarks3 = vetoed_remarks3;
	}
	public String getEvaluation_conclusion() {
		return evaluation_conclusion;
	}
	public void setEvaluation_conclusion(String evaluation_conclusion) {
		this.evaluation_conclusion = evaluation_conclusion;
	}
	public String getCbsfzr() {
		return cbsfzr;
	}
	public void setCbsfzr(String cbsfzr) {
		this.cbsfzr = cbsfzr;
	}
	public String getJxzyzg() {
		return jxzyzg;
	}
	public void setJxzyzg(String jxzyzg) {
		this.jxzyzg = jxzyzg;
	}
	public String getAqhbbm() {
		return aqhbbm;
	}
	public void setAqhbbm(String aqhbbm) {
		this.aqhbbm = aqhbbm;
	}
	public String getAssessment_person() {
		return assessment_person;
	}
	public void setAssessment_person(String assessment_person) {
		this.assessment_person = assessment_person;
	}
	public String getAssessment_time() {
		return assessment_time;
	}
	public void setAssessment_time(String assessment_time) {
		this.assessment_time = assessment_time;
	}
	public String getZfs() {
		return zfs;
	}
	public void setZfs(String zfs) {
		this.zfs = zfs;
	}
	public String getZfs_qb() {
		return zfs_qb;
	}
	public void setZfs_qb(String zfs_qb) {
		this.zfs_qb = zfs_qb;
	}
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
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

	public List<Jxpg_Ht_DwEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<Jxpg_Ht_DwEntity> entity_list) {
		this.entity_list = entity_list;
	}
}
