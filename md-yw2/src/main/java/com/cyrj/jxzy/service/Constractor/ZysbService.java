package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;

public interface ZysbService {

	 Map<String, Object>showList(ZysbEntity entity, Pager pager);
	
	 Map updateSave(ZysbEntity entity);

	 List<Map<String, String>>termSelect_Zysb(String dwdm);

	 Map insertSave(ZysbEntity entity);

	 List<Map<String, String>> unit_select();

	 List<Map<String, String>> term_select(String id);
	 
	 List<ZysbEntity>updateSelect(ZysbEntity entity);
}
