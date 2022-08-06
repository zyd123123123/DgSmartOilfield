package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxwhEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;

public interface HtxxwhDao {

	/**
	 * 合同信息维护列表总记录数
	 */
	int countHtxxwh(HtxxckEntity entity); 
	/**
	 * 合同信息维护列表记录
	 * @param entity
	 * @return
	 */
	List<HtxxckEntity>listHtxxwh(HtxxckEntity entity);
	/**
	 * 根据合同id查询单个合同信息
	 * @param contract_id
	 * @return
	 */
	HtxxckEntity getHtxx(String contract_id);
	/**
	 * 更改合同表合同信息
	 * @param entity
	 */
	void updateHtxx(HtxxwhEntity entity);
	/**
	 * 保存变更的合同信息
	 * @param entity
	 */
	void insertHtxxBg(HtxxwhEntity entity);
	 /**
	  * 查询承包商施工队伍，及合同绑定的队伍
	  * @param entity
	  * @return
	  */
	List<QualificationEntity> listQualification(QualificationEntity entity);
	
	/**
	 * 根据合同id查询合同变更记录
	 * @param contract_id
	 * @return
	 */
	List<HtxxwhEntity> listchange_Record(String contract_id);
	/**
	 * 合同变更信息审核保存
	 * @param entity
	 */
	 void changeAuditSave(HtxxwhEntity entity);
	 
	 List<HtxxwhEntity>changeAuditSelect(HtxxwhEntity entity);
	 
	 void changeAuditUpdate(HtxxwhEntity entity);
	 /**
	  * 合同完工确认
	  * @param entity
	  */
	 void completionConfirmation(HtxxwhEntity entity);
	 //合同变更记录删除
	 void  bgRemove(HtxxwhEntity entity);
}
