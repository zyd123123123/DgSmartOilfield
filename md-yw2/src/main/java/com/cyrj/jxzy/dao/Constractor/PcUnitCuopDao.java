package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.PersonEntity;

public interface PcUnitCuopDao {

	List<PcUnitEntity> selectByParam3(PcUnitEntity pcUnitEntity);
	List<PcUnitEntity> selectByParam4(PcUnitEntity pcUnitEntity);
	public List<PcUnitEntity> selectByParam8(PcUnitEntity pcUnitEntity);
	public List<PcUnitEntity> selectByParam5(PcUnitEntity pcUnitEntity);
	public List<PcUnitEntity> selectByParam60(PcUnitEntity pcUnitEntity);
	public List<PcUnitEntity> selectByParam61(PcUnitEntity pcUnitEntity);
	public List<PcUnitEntity> queryList(PcUnitEntity p);
	List<PcUnitEntity> selectByParam7(PcUnitEntity pcUnitEntity);
	List<PcUnitEntity> selectDq(PcUnitEntity pcUnitEntity);
	
	void removeSave(PersonEntity entity);
	
	
}
