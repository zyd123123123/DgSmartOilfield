package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.HbsbEntity;

public interface HbsbDao {

	int countShowList(HbsbEntity entity);
	
	List<HbsbEntity>listShowList(HbsbEntity entity);
	
	List<HbsbEntity> listSbbh_yz(HbsbEntity entity);
	
	void insertSave(HbsbEntity entity);
	//设备删除
	void updateRemove(HbsbEntity entity);
	//设备修改
	void updateSave(HbsbEntity entity);
}
