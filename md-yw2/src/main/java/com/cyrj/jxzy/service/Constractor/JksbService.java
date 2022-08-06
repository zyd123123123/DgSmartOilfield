package com.cyrj.jxzy.service.Constractor;

import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.JksbEntity;

public interface JksbService {

	Map<String, Object>showList(JksbEntity entity, Pager pager);
	
	Map sbbh_yz(JksbEntity entity);
	
	Map insertSave(JksbEntity entity);
	
	Map remove(JksbEntity entity);
	
	Map updateSave(JksbEntity entity);
}
