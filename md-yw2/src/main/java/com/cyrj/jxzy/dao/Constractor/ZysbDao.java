package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;

public interface ZysbDao {

	public List<ZysbEntity> selectByParam(ZysbEntity sb_entity);

	int countShow(ZysbEntity entity);

	List<ZysbEntity> listShow(ZysbEntity entity);
	
	List<ZysbEntity> listTermSelect_Zysb(String dwdm);
	
	void insertSave(ZysbEntity entity);
	
	void deleteUpdateSave(ZysbEntity entity);
	
	void delete(ZysbEntity entity);
	
	void insertUpdateSave(ZysbEntity entity);
	
	 List<QylrEntity> unit_select(QylrEntity entity);
	 
	 List<PcUnitEntity> term_select(PcUnitEntity pcUnitEntity);
	 
}
