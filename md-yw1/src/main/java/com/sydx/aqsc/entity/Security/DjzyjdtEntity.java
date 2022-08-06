package com.sydx.aqsc.entity.Security;


import com.sydx.aqsc.entity.Admin.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class DjzyjdtEntity extends BaseEntity {

	private String did;//唯一标识
	private String well_common_name;//井号
	private int spid;//工序id
	private int pdid;//工序id
	private String spname;//工序
	private String is_complete;//工序是否完成
	private List<AqhbwhEntity>list_sgdy = new ArrayList<AqhbwhEntity>();
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
	public String getSpname() {
		return spname;
	}
	public void setSpname(String spname) {
		this.spname = spname;
	}
	public String getIs_complete() {
		return is_complete;
	}
	public void setIs_complete(String is_complete) {
		this.is_complete = is_complete;
	}
	public List<AqhbwhEntity> getList_sgdy() {
		return list_sgdy;
	}
	public void setList_sgdy(List<AqhbwhEntity> list_sgdy) {
		this.list_sgdy = list_sgdy;
	}
	
	
	
	
}
