package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.FssbEntity;

public interface FssbDao {
	
	int countShowList(FssbEntity entity);
	
	List<FssbEntity>listShowList(FssbEntity entity);
	
	List<FssbEntity> listSbbh_yz(FssbEntity entity);
	
	void insertSave(FssbEntity entity);
	//设备删除
	void updateRemove(FssbEntity entity);
	//设备修改
	void updateSave(FssbEntity entity);

}
