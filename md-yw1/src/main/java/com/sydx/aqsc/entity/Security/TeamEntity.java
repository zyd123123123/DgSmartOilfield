package com.sydx.aqsc.entity.Security;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class TeamEntity {
	private String dwdm;	//VARCHAR2	50	0	0	0		单位代码——对应组织机构id	BYTE
	private String termid;	//VARCHAR2	50	0	0	0		队伍代码——对应组织机构id	BYTE
	private String dwmc;	//VARCHAR2	100	0	0	0		企业名称	BYTE
	private String termname;	//VARCHAR2	100	0	0	0		队伍名称	BYTE
	private String gw;	//VARCHAR2	50	0	0	0		岗位	BYTE
	private String xm;	//VARCHAR2	100	0	0	0		姓名	BYTE
	private String sfzh;	//VARCHAR2	100	0	0	0		身份证号	BYTE
	private String jkzbh;	//VARCHAR2	100	0	-1	0		井控证编号	BYTE
	private String fileuri;	//VARCHAR2	255	0	0	0		存储路径	BYTE
	private String fileoldname;	//VARCHAR2	100	0	-1	0		文件原名称	BYTE
	private String xb;	//VARCHAR2	20	0	0	0		性别	BYTE
	private String xl;	//VARCHAR2	50	0	0	0		学历	BYTE
	private String zc;	//VARCHAR2	60	0	0	0		职称	BYTE
	private String pxsj;	//oracle.sql.DATE	7	0	-1	0		培训时间	BYTE
	private String lrr;	//VARCHAR2	25	0	-1	0		录入人	BYTE
	private String lrsj;	//DATE	7	0	0	0		录入时间	BYTE
	private String ryid;	//VARCHAR2	36	0	0	-1		人员id	BYTE
	private String xh;	//VARCHAR2	3	0	0	0		序号	BYTE
	private String kssj;	//DATE	7	0	-1	0		井控证有效期开始时间	BYTE
	private String jzsj;	//DATE	7	0	-1	0		井控证有效期截止时间	BYTE
	private String oilfield;

	private List<TeamEntity> teamlist;
//	private List<TeamEntity> el;
	private MultipartFile files;
	private String attribute;//数据权限
	private String search;//权限

	private String id;
	private String parentid;
	private String uniteproperty2;
	private String unitname;
	private String ytj;
	private String cj;
   private Long a5dep_id;
	public String getYtj() {
		return ytj;
	}

	public void setYtj(String ytj) {
		this.ytj = ytj;
	}

	public String getCj() {
		return cj;
	}

	public void setCj(String cj) {
		this.cj = cj;
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

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getTermid() {
		return termid;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getTermname() {
		return termname;
	}

	public void setTermname(String termname) {
		this.termname = termname;
	}

	public String getGw() {
		return gw;
	}

	public void setGw(String gw) {
		this.gw = gw;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getJkzbh() {
		return jkzbh;
	}

	public void setJkzbh(String jkzbh) {
		this.jkzbh = jkzbh;
	}

	public String getFileuri() {
		return fileuri;
	}

	public void setFileuri(String fileuri) {
		this.fileuri = fileuri;
	}

	public String getFileoldname() {
		return fileoldname;
	}

	public void setFileoldname(String fileoldname) {
		this.fileoldname = fileoldname;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getZc() {
		return zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getPxsj() {
		return pxsj;
	}

	public void setPxsj(String pxsj) {
		this.pxsj = pxsj;
	}

	public String getLrr() {
		return lrr;
	}

	public void setLrr(String lrr) {
		this.lrr = lrr;
	}

	public String getLrsj() {
		return lrsj;
	}

	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJzsj() {
		return jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getOilfield() {
		return oilfield;
	}

	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	public List<TeamEntity> getTeamlist() {
		return teamlist;
	}

	public void setTeamlist(List<TeamEntity> teamlist) {
		this.teamlist = teamlist;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

//	public List<TeamEntity> getEl() {
//		return el;
//	}
//
//	public void setEl(List<TeamEntity> el) {
//		this.el = el;
//	}
}
