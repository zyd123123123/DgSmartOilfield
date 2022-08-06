package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;

public interface QylrDao {

	int count(QylrEntity entity);
	
	public void qylrInsert(QylrEntity entity);
	
	public List<QylrEntity> selectByParam3(QylrEntity entity);
	
	public List<QylrEntity> selectByParam1(QylrEntity entity);

	public int selectByParam2(QylrEntity entity);

	void deleteParam(QylrEntity entity);

	int insert1(QylrEntity entity);

	List<QylrEntity> selectByParam(QylrEntity q);

	List<QylrEntity> selectByParam11(QylrEntity entity);

	int selectByParam22(QylrEntity entity);

	List<QylrEntity> selectZz1(QylrEntity q);

	List<QylrEntity> selectZz2(QylrEntity qylr);

}
