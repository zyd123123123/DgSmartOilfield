package com.cyrj.jxzy.entity.Constractor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "绩效评估合同队伍信息")
public class Jxpg_Ht_DwEntity extends BaseEntity{
	@ApiModelProperty(value="合同ID——系统生成")
	private String contract_id;//合同ID——系统生成
	@ApiModelProperty(value="承包商名称")
	private String contractor_name; // 承包商名称
	@ApiModelProperty(value="承包商ID")
	private String contractor_id; // 承包商ID
	@ApiModelProperty(value="施工项目")
	private String construction_project; // 施工项目
	@ApiModelProperty(value="合同名称")
	private String contract_name; // 合同名称
	@ApiModelProperty(value="合同编号")
	private String contract_number; // 合同编号
	@ApiModelProperty(value="合同来源")
	private String contract_source; // 合同来源
	@ApiModelProperty(value="履行期限——开工日期")
	private Date operation_start_date; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private Date completion_date; // 履行期限—完工日期
	@ApiModelProperty(value="履行期限——开工日期")
	private String operation_start_dates; // 履行期限——开工日期
	@ApiModelProperty(value="履行期限—完工日期")
	private String completion_dates; // 履行期限—完工日期
	@ApiModelProperty(value="工作量(井次)-合同")
	private int workload_ht; // 工作量(井次)-合同
	@ApiModelProperty(value="标的金额-合同")
	private String money_ht; // 标的金额-合同
	@ApiModelProperty(value="合同是否履行完毕")
	private String whether_to_perform; // 合同是否履行完毕
	@ApiModelProperty(value="甲方单位名称")
	private String unit_name; // 甲方单位名称
	@ApiModelProperty(value="甲方单位ID")
	private String unit_id; // 甲方单位ID
	@ApiModelProperty(value="二级单位名称（承包商名称简称）")
	private String ejdwmc;//二级单位名称（承包商名称简称）
	@ApiModelProperty(value="队伍名称")
	private String team_name;//队伍名称
	@ApiModelProperty(value="队伍资质")
	private String team_qualification;//队伍资质
	@ApiModelProperty(value="工作量(井次)-队伍")
	private int workload_dw; // 工作量(井次)-队伍
	@ApiModelProperty(value="标的金额-队伍")
	private String money_dw; // 标的金额-队伍
	@ApiModelProperty(value="施工总结平均上传周期")
	private String sgzj_pj;//施工总结平均上传周期
	@ApiModelProperty(value="平均交井周期")
	private String jj_pj;//平均交井周期
	@ApiModelProperty(value="施工总结平均上传周期备注")
	private String sgzj_pj_bz;//施工总结平均上传周期备注
	@ApiModelProperty(value="平均交井周期备注")
	private String jj_pj_bz;//平均交井周期备注
	@ApiModelProperty(value="施工总结平均上传周期得分")
	private String sgzjpjzq;//施工总结平均上传周期得分
	@ApiModelProperty(value="平均交井周期得分")
	private String jjpjzq;//平均交井周期得分
	@ApiModelProperty(value="评估总分数（不包含防砂布铺设5.00和质量评价10.00，共计15分）")
	private String zfs;//评估总分数（不包含防砂布铺设5.00和质量评价10.00，共计15分）
	@ApiModelProperty(value="评估总分数（包含防砂布铺设5.00和质量评价10.00，共计15分）")
	private String zfs_qb;//评估总分数（包含防砂布铺设5.00和质量评价10.00，共计15分）
	@ApiModelProperty(value="绩效评估id")
	private String jxpgid;//绩效评估id
	@ApiModelProperty(value="项目概况")
	private String project_overview;//项目概况
	private String oilfield;
	private List<Jxpg_Ht_DwEntity> entity_list=  new ArrayList<Jxpg_Ht_DwEntity>();
	public String getContract_id() {
		return contract_id;
	}
	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
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
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getContract_number() {
		return contract_number;
	}
	public void setContract_number(String contract_number) {
		this.contract_number = contract_number;
	}
	public String getContract_source() {
		return contract_source;
	}
	public void setContract_source(String contract_source) {
		this.contract_source = contract_source;
	}
	public Date getOperation_start_date() {
		return operation_start_date;
	}
	public void setOperation_start_date(Date operation_start_date) {
		this.operation_start_date = operation_start_date;
	}
	public Date getCompletion_date() {
		return completion_date;
	}
	public void setCompletion_date(Date completion_date) {
		this.completion_date = completion_date;
	}
	public String getOperation_start_dates() {
		return operation_start_dates;
	}
	public void setOperation_start_dates(String operation_start_dates) {
		this.operation_start_dates = operation_start_dates;
	}
	public String getCompletion_dates() {
		return completion_dates;
	}
	public void setCompletion_dates(String completion_dates) {
		this.completion_dates = completion_dates;
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
	public String getWhether_to_perform() {
		return whether_to_perform;
	}
	public void setWhether_to_perform(String whether_to_perform) {
		this.whether_to_perform = whether_to_perform;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getEjdwmc() {
		return ejdwmc;
	}
	public void setEjdwmc(String ejdwmc) {
		this.ejdwmc = ejdwmc;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_qualification() {
		return team_qualification;
	}
	public void setTeam_qualification(String team_qualification) {
		this.team_qualification = team_qualification;
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
	public String getSgzj_pj() {
		return sgzj_pj;
	}
	public void setSgzj_pj(String sgzj_pj) {
		this.sgzj_pj = sgzj_pj;
	}
	public String getJj_pj() {
		return jj_pj;
	}
	public void setJj_pj(String jj_pj) {
		this.jj_pj = jj_pj;
	}
	public String getSgzj_pj_bz() {
		return sgzj_pj_bz;
	}
	public void setSgzj_pj_bz(String sgzj_pj_bz) {
		this.sgzj_pj_bz = sgzj_pj_bz;
	}
	public String getJj_pj_bz() {
		return jj_pj_bz;
	}
	public void setJj_pj_bz(String jj_pj_bz) {
		this.jj_pj_bz = jj_pj_bz;
	}
	public String getSgzjpjzq() {
		return sgzjpjzq;
	}
	public void setSgzjpjzq(String sgzjpjzq) {
		this.sgzjpjzq = sgzjpjzq;
	}
	public String getJjpjzq() {
		return jjpjzq;
	}
	public void setJjpjzq(String jjpjzq) {
		this.jjpjzq = jjpjzq;
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
	public String getJxpgid() {
		return jxpgid;
	}
	public void setJxpgid(String jxpgid) {
		this.jxpgid = jxpgid;
	}
	public String getProject_overview() {
		return project_overview;
	}
	public void setProject_overview(String project_overview) {
		this.project_overview = project_overview;
	}
	
	public String getOilfield() {
		return oilfield;
	}
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}
	
	
	public List<Jxpg_Ht_DwEntity> getEntity_list() {
		return entity_list;
	}
	public void setEntity_list(List<Jxpg_Ht_DwEntity> entity_list) {
		this.entity_list = entity_list;
	}
	@Override
	public String toString() {
		return "Jxpg_Ht_DwEntity [contract_id=" + contract_id + ", contractor_name=" + contractor_name
				+ ", contractor_id=" + contractor_id + ", construction_project=" + construction_project
				+ ", contract_name=" + contract_name + ", contract_number=" + contract_number + ", contract_source="
				+ contract_source + ", operation_start_date=" + operation_start_date + ", completion_date="
				+ completion_date + ", operation_start_dates=" + operation_start_dates + ", completion_dates="
				+ completion_dates + ", workload_ht=" + workload_ht + ", money_ht=" + money_ht + ", whether_to_perform="
				+ whether_to_perform + ", unit_name=" + unit_name + ", unit_id=" + unit_id + ", ejdwmc=" + ejdwmc
				+ ", team_name=" + team_name + ", team_qualification=" + team_qualification + ", workload_dw="
				+ workload_dw + ", money_dw=" + money_dw + ", sgzj_pj=" + sgzj_pj + ", jj_pj=" + jj_pj + ", sgzj_pj_bz="
				+ sgzj_pj_bz + ", jj_pj_bz=" + jj_pj_bz + ", sgzjpjzq=" + sgzjpjzq + ", jjpjzq=" + jjpjzq + ", zfs="
				+ zfs + ", zfs_qb=" + zfs_qb + ", jxpgid=" + jxpgid + ", project_overview=" + project_overview
				+ ", getContract_id()=" + getContract_id() + ", getContractor_name()=" + getContractor_name()
				+ ", getContractor_id()=" + getContractor_id() + ", getConstruction_project()="
				+ getConstruction_project() + ", getContract_name()=" + getContract_name() + ", getContract_number()="
				+ getContract_number() + ", getContract_source()=" + getContract_source()
				+ ", getOperation_start_date()=" + getOperation_start_date() + ", getCompletion_date()="
				+ getCompletion_date() + ", getOperation_start_dates()=" + getOperation_start_dates()
				+ ", getCompletion_dates()=" + getCompletion_dates() + ", getWorkload_ht()=" + getWorkload_ht()
				+ ", getMoney_ht()=" + getMoney_ht() + ", getWhether_to_perform()=" + getWhether_to_perform()
				+ ", getUnit_name()=" + getUnit_name() + ", getUnit_id()=" + getUnit_id() + ", getEjdwmc()="
				+ getEjdwmc() + ", getTeam_name()=" + getTeam_name() + ", getTeam_qualification()="
				+ getTeam_qualification() + ", getWorkload_dw()=" + getWorkload_dw() + ", getMoney_dw()="
				+ getMoney_dw() + ", getSgzj_pj()=" + getSgzj_pj() + ", getJj_pj()=" + getJj_pj() + ", getSgzj_pj_bz()="
				+ getSgzj_pj_bz() + ", getJj_pj_bz()=" + getJj_pj_bz() + ", getSgzjpjzq()=" + getSgzjpjzq()
				+ ", getJjpjzq()=" + getJjpjzq() + ", getZfs()=" + getZfs() + ", getZfs_qb()=" + getZfs_qb()
				+ ", getJxpgid()=" + getJxpgid() + ", getProject_overview()=" + getProject_overview() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
