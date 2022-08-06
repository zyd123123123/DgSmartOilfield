package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Constractor.SbtjEntity;

public interface SbtjDao {

	
	 int countShowList(SbtjEntity entity);
	
	 List<SbtjEntity> listShowList(SbtjEntity entity);
}
