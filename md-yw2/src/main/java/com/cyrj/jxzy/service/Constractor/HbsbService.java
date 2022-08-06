package com.cyrj.jxzy.service.Constractor;

import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HbsbEntity;

public interface HbsbService {

	Map<String, Object>showList(HbsbEntity entity, Pager pager);
	
	Map sbbh_yz(HbsbEntity entity);
	
	Map insertSave(HbsbEntity entity);
	
	Map remove(HbsbEntity entity);
	
	Map updateSave(HbsbEntity entity);
}
