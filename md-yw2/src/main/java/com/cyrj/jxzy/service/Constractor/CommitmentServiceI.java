package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CnsflbEntity;



public interface CommitmentServiceI {

	 List<CnsflbEntity> cnsflbSelect();
	
	 Map  save(CnsflbEntity entity);

}
