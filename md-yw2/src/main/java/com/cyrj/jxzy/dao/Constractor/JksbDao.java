package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.JksbEntity;

public interface JksbDao {

	int countShowList(JksbEntity entity);
	
	List<JksbEntity>listShowList(JksbEntity entity);
	
	List<JksbEntity> listSbbh_yz(JksbEntity entity);
	
	void insertSave(JksbEntity entity);
	//设备删除
	void updateRemove(JksbEntity entity);
	//设备修改
	void updateSave(JksbEntity entity);
}
