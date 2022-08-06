package com.cyrj.jxzy.entity.Constractor;

import java.text.DecimalFormat;
import java.util.Date;

import com.cyrj.jxzy.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "绩效评估类")
public class CbsFj6Entity extends BaseEntity{
	private String oilfield;
	@ApiModelProperty(value="甲方单位ID")
	private String unit_id; // 甲方单位ID
	@ApiModelProperty(value="承包商名称")
	private String contractor_name;//承包商名称
	@ApiModelProperty(value="承包商ID")
	private String contractor_id; // 承包商ID
	@ApiModelProperty(value="施工项目")
	private String  sgxm; //施工项目
	@ApiModelProperty(value="序号")
	private String  sort; //序号
	@ApiModelProperty(value="操作时间")
	private Date  datatime; //操作时间
	@ApiModelProperty(value="项目评估")
	private String  xmpg; //项目评估
	@ApiModelProperty(value="评估内容")
	private String  pgnr1; //评估内容
	@ApiModelProperty(value="评估内容")
	private String  pgnr2; //评估内容
	@ApiModelProperty(value="评估内容")
	private String  pgnr3; //评估内容
	@ApiModelProperty(value="评估依据及标准")
	private String  pgyjjbz; //评估依据及标准
	@ApiModelProperty(value="标准分")
	private String  bzf; //标准分
	@ApiModelProperty(value="实得分")
	private double  sdf; //实得分
	@ApiModelProperty(value="实得分")
	private String  sdfs; //实得分
	@ApiModelProperty(value="备注")
	private String  bz; //备注
	@ApiModelProperty(value="合同名称")
	private String  htmc; //合同名称
	@ApiModelProperty(value="合同编号")
	private String  htbh; //合同编号
	@ApiModelProperty(value="合同来源")
	private String  htly; //合同来源
	@ApiModelProperty(value="开工时间")
	private Date  kg_time; //开工时间
	@ApiModelProperty(value="完工时间")
	private Date  wg_time; //完工时间
	@ApiModelProperty(value="工作量")
	private String  gzl; //工作量
	@ApiModelProperty(value="标的金额")
	private String  bdje; //标的金额
	@ApiModelProperty(value="合同是否履行完毕")
	private String  htsflxwb; //合同是否履行完毕
	@ApiModelProperty(value="施工小队")
	private String  sgxd; //施工小队
	@ApiModelProperty(value="工作量")
	private String  gzl2; //工作量
	@ApiModelProperty(value="金额")
	private String  je; //金额

	//确定数据类型，set&get 
	private String unit_name;
	private String kg_times;
	private String wg_times;
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
	public String getSgxm() {
		return sgxm;
	}
	public void setSgxm(String sgxm) {
		this.sgxm = sgxm;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Date getDatatime() {
		return datatime;
	}
	public void setDatatime(Date datatime) {
		this.datatime = datatime;
	}
	public String getXmpg() {
		return xmpg;
	}
	public void setXmpg(String xmpg) {
		this.xmpg = xmpg;
	}
	public String getPgnr1() {
		return pgnr1;
	}
	public void setPgnr1(String pgnr1) {
		this.pgnr1 = pgnr1;
	}
	public String getPgnr2() {
		return pgnr2;
	}
	public void setPgnr2(String pgnr2) {
		this.pgnr2 = pgnr2;
	}
	public String getPgnr3() {
		return pgnr3;
	}
	public void setPgnr3(String pgnr3) {
		this.pgnr3 = pgnr3;
	}
	public String getPgyjjbz() {
		return pgyjjbz;
	}
	public void setPgyjjbz(String pgyjjbz) {
		this.pgyjjbz = pgyjjbz;
	}
	public String getBzf() {
		return bzf;
	}
	public void setBzf(String bzf) {
		this.bzf = bzf;
	}
	public double getSdf() {
		return sdf;
	}
	public void setSdf(double sdf) {
		
		if(sdf==0||sdf==0.0||sdf==0.00){
			this.sdfs = "0";
		}else{
			DecimalFormat df = new DecimalFormat("######.00");	
			String f1 = df.format(sdf);	
			this.sdfs = f1;
		}
		
		this.sdf = sdf;
	}
	public String getSdfs() {
		return sdfs;
	}
	public void setSdfs(String sdfs) {
		this.sdfs = sdfs;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getHtmc() {
		return htmc;
	}
	public void setHtmc(String htmc) {
		this.htmc = htmc;
	}
	public String getHtbh() {
		return htbh;
	}
	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}
	public String getHtly() {
		return htly;
	}
	public void setHtly(String htly) {
		this.htly = htly;
	}
	public Date getKg_time() {
		return kg_time;
	}
	public void setKg_time(Date kg_time) {
		this.kg_time = kg_time;
	}
	public Date getWg_time() {
		return wg_time;
	}
	public void setWg_time(Date wg_time) {
		this.wg_time = wg_time;
	}
	public String getGzl() {
		return gzl;
	}
	public void setGzl(String gzl) {
		this.gzl = gzl;
	}
	public String getBdje() {
		return bdje;
	}
	public void setBdje(String bdje) {
		this.bdje = bdje;
	}
	public String getHtsflxwb() {
		return htsflxwb;
	}
	public void setHtsflxwb(String htsflxwb) {
		this.htsflxwb = htsflxwb;
	}
	public String getSgxd() {
		return sgxd;
	}
	public void setSgxd(String sgxd) {
		this.sgxd = sgxd;
	}
	public String getGzl2() {
		return gzl2;
	}
	public void setGzl2(String gzl2) {
		this.gzl2 = gzl2;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getUnit_name() {
		return unit_name;
	}
	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}
	public String getKg_times() {
		return kg_times;
	}
	public void setKg_times(String kg_times) {
		this.kg_times = kg_times;
	}
	public String getWg_times() {
		return wg_times;
	}
	public void setWg_times(String wg_times) {
		this.wg_times = wg_times;
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
}
