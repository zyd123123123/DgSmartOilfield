package com.cyrj.jxzy.service.Constractor;

import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CommitmentViewEntity;

public interface CommitmentViewServiceI {
	
	/**
	 * 承诺书查看
	 * 
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map show_list(CommitmentViewEntity entity, Pager pager);

	/**
	 * 承诺书打印
	 * 
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map getPrint(String contract_id);


}
