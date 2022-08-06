package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Constractor.BigTextEntity;

public interface BigTextDao {

	
	
	List<BigTextEntity> listBigText(BigTextEntity entity);
	void updateBigText(BigTextEntity entity);
	void insertBigText(BigTextEntity entity);
	BigTextEntity bigTextShow(BigTextEntity entity);
}
