package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;

public interface Xkz_sbService {

	List<Xkz_sbEntity> showView(Xkz_sbEntity entity);
	
	List<Xkz_sbEntity> select(Xkz_sbEntity entity);
	
	Map bangding_save(Xkz_sbEntity entity);
}
