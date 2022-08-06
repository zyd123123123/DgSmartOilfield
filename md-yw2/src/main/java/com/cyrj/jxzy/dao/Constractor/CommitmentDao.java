package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.CnsflbEntity;

public interface CommitmentDao {

	public List<CnsflbEntity> cnsflbSelect(CnsflbEntity entity);
	
	public void cnsflbDelete(CnsflbEntity entity);
	
	public void cnsflbInsert(CnsflbEntity entity);
}
