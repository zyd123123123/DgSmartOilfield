package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;

public interface Xkz_sbDao {

	List<Xkz_sbEntity> listShowView(Xkz_sbEntity entity);
	
	List<Xkz_sbEntity> listSelect(Xkz_sbEntity entity);
	
	List<Xkz_sbEntity> listBangdingSave(Xkz_sbEntity entity);
	
	void insertBangdingSave(Xkz_sbEntity entity);
	
	void updateBangdingSave(Xkz_sbEntity entity);
}
