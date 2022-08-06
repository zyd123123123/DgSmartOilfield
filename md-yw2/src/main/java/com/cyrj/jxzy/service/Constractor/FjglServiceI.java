package com.cyrj.jxzy.service.Constractor;

import java.util.List;


import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.DwzzEntity;
import com.cyrj.jxzy.entity.Constractor.FjglEntity;

public interface FjglServiceI {

	 Map setId_Returnid(String parent_id,String parent_name);


	Map<String, Object>show_list(String parent_id,String annex_name, Pager pager);

	Map<String, String>addSave(FjglEntity entity);
	
	Map<String, String>editSave(FjglEntity entity);
	
	Map<String, String>removeSave(String id);

	Map selectTree_name(String parent_id,String parent_name);
}
