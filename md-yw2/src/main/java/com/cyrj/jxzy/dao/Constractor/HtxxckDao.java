package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;

public interface HtxxckDao {

	
	List<HtxxckEntity> cbs_select(HtxxckEntity entity);
	
	List<HtxxckEntity> nf_select();
	
	/**
	 * 合同信息维护列表总记录数
	 */
	int countHtxxck(HtxxckEntity entity); 
	/**
	 * 合同信息维护列表记录
	 * @param entity
	 * @return
	 */
	List<HtxxckEntity>listHtxxck(HtxxckEntity entity);
	
	/**
	 * 合同创建审核总记录数
	 */
	int count_Audit_cj(HtxxckEntity entity); 
	/**
	 * 合同创建审核列表记录
	 * @param entity
	 * @return
	 */
	List<HtxxckEntity>list_Audit_cj(HtxxckEntity entity);
	
	
	int countHtxxckChang(HtxxckEntity entity); 
	
	List<HtxxckEntity>listHtxxckChang(HtxxckEntity entity);
	List<ContractTeamEntity> listTerm(ContractTeamEntity entity);
	
	void updateAuditSave(HtxxckEntity entity);
}
