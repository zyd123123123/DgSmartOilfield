package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.AnnexEntity;
import com.cyrj.jxzy.entity.Constractor.FjglEntity;

public interface FjglDao {

	public List<FjglEntity> setId_ReturnFj(FjglEntity fjglEntity);
	
	int countShow_list(FjglEntity entity);
	
	List<FjglEntity> listShow_list(FjglEntity entity);
	
	void insertAdd(FjglEntity entity);
	
	void updateEdit(FjglEntity entity);
	
	List<FjglEntity>listFjgl(FjglEntity entity);
	
	void updateRemove(FjglEntity entity);

	List<AnnexEntity> selectA1(AnnexEntity entity);
	
}
