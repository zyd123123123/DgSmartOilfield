package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "施工模板定制")
public class SgmbbdEntity extends BaseEntity {
	@ApiModelProperty(value = "措施id")
	private String csid;//措施id
	@ApiModelProperty(value = "井别（油井、水井）")
	private String jb;//井别（油井、水井）
	@ApiModelProperty(value = "井别（油井、水井）")
	private String jbname;//井别（油井、水井）
	@ApiModelProperty(value = "措施类型（地质、工程）")
	private String cslx;//措施类型（地质、工程）
	@ApiModelProperty(value = "措施一类")
	private String csyl;//措施一类
	@ApiModelProperty(value = "措施二类")
	private String csel;//措施二类
	@ApiModelProperty(value = "措施三类")
	private String cssl;//措施三类
	@ApiModelProperty(value = "作业类型")
	private String zylx;//作业类型
	@ApiModelProperty(value = "工序id")
	private Integer spid;//工序id
	@ApiModelProperty(value = "工序名称")
	private String spname;//工序名称
	@ApiModelProperty(value = "序号")
	private Integer sort;//序号
	@ApiModelProperty(value = "模板id")
	private String id;//模板id
	@ApiModelProperty(value = "模板id")
	private String templateid;//模板id
	@ApiModelProperty(value = "模板标记，默认1正在使用，0是被废弃")
	private String tab;//模板标记，默认1正在使用，0是被废弃
	@ApiModelProperty(value = "时间")
	private String datetime;//时间
	@ApiModelProperty(value = "定制人")
	private Integer userid;//定制人
	@ApiModelProperty(value = "油田")
	private String oilfield;
	@ApiModelProperty(value = "录入人")
	private String create_user;
	@ApiModelProperty(value = "修改人")
	private String last_user;
	@ApiModelProperty(value = "绑定id")
	private String bindingid;
	@ApiModelProperty(value = "标记:1正常，0废除")
	private String is_use;
	@ApiModelProperty(value = "是否为复合措施1不是，2是")
	private String is_fh;
	private List<SgmbbdEntity> entity_list = new ArrayList<SgmbbdEntity>();

	public String getJbname() {
		return jbname;
	}

	public void setJbname(String jbname) {
		this.jbname = jbname;
	}

	public String getCsid() {
		return csid;
	}

	public void setCsid(String csid) {
		this.csid = csid;
	}

	public String getJb() {
		return jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}

	public String getCslx() {
		return cslx;
	}

	public void setCslx(String cslx) {
		this.cslx = cslx;
	}

	public String getCsyl() {
		return csyl;
	}

	public void setCsyl(String csyl) {
		this.csyl = csyl;
	}

	public String getCsel() {
		return csel;
	}

	public void setCsel(String csel) {
		this.csel = csel;
	}

	public String getCssl() {
		return cssl;
	}

	public void setCssl(String cssl) {
		this.cssl = cssl;
	}

	public String getZylx() {
		return zylx;
	}

	public void setZylx(String zylx) {
		this.zylx = zylx;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String getOilfield() {
		return oilfield;
	}

	@Override
	public void setOilfield(String oilfield) {
		this.oilfield = oilfield;
	}

	@Override
	public String getCreate_user() {
		return create_user;
	}

	@Override
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	@Override
	public String getLast_user() {
		return last_user;
	}

	@Override
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}

	public String getBindingid() {
		return bindingid;
	}

	public void setBindingid(String bindingid) {
		this.bindingid = bindingid;
	}

	public String getIs_use() {
		return is_use;
	}

	public void setIs_use(String is_use) {
		this.is_use = is_use;
	}

	public String getIs_fh() {
		return is_fh;
	}

	public void setIs_fh(String is_fh) {
		this.is_fh = is_fh;
	}

	public List<SgmbbdEntity> getEntity_list() {
		return entity_list;
	}

	public void setEntity_list(List<SgmbbdEntity> entity_list) {
		this.entity_list = entity_list;
	}
}