package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyrj.jxzy.entity.Constractor.CbsFj2Entity;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;

public interface NlpgDao {
    /**
     * 查询能力评估附录表数据
     * @return
     */
	List<CbsFj2Entity> listNlpgflb(CbsFj2Entity entity);
	/**
	 * 能力评估附录表数据保存
	 * @param entity
	 */
	
	void insertflbSave(CbsFj2Entity entity);
	/**
	 * 能力评估附录表数据删除
	 * @param entity
	 */
	void deleteflbSave(CbsFj2Entity entity);
	/**
	 * 能力评估申请总数
	 * @param entity
	 * @return
	 */
	int countNlpgsq(ContractTeamEntity entity);
	/**
	 * 能力评估申请list
	 * @param entity
	 * @return
	 */
	List<ContractTeamEntity> listNlpgsq(ContractTeamEntity entity);
	
	   /**
	    * 能力评估申请，施工队伍下拉列表
	    * @param entity
	    * @return
	    */
	List<ContractTeamEntity>applyTerm(ContractTeamEntity entity);
	
	/**
	 * 查询队伍和合同是否已申请
	 */
	
	List<ContractTeamEntity>termList(ContractTeamEntity entity);
	/**
	    * 能力评估申请，保存
	    * @param entity
	    * @return
	 */
	void applySave(ContractTeamEntity entity);
	
	/**
	 * 能力评估申请记录查看总数
	 * @param entity
	 * @return
	 */
	int countNlpgsqjl(ContractTeamEntity entity);
	/**
	 * 能力评估申请查看list
	 * @param entity
	 * @return
	 */
	List<ContractTeamEntity> listNlpgsqjl(ContractTeamEntity entity);
	   /**
	    * 能力评估合同队伍信息
	    * @param pgb_id
	    * @return
	    */
	ContractTeamEntity contractTeam(String pgb_id);
	/**
	 * 保存能力评估审核记录
	 * @param entity
	 * @param entity1
	 */
	void insertAudit( NlpgshEntity entity);
	/**
	 * 保存能力评估审核记录
	 * @param entity
	 * @param entity1
	 */
	void updateAudit(NlpgshEntity entity1);
	/**
	 * 能力评估申请总数
	 * @param entity
	 * @return
	 */
	int countNlpgck(ContractTeamEntity entity);
	/**
	 * 能力评估申请list
	 * @param entity
	 * @return
	 */
	List<ContractTeamEntity> listNlpgck(ContractTeamEntity entity);
	  /**
	   * 评估审核记录
	   * @param pgb_id
	   * @return
	   */
	List<CbsFj2Entity> nlpgList(String pgb_id);
	
	void revokeSave(NlpgshEntity entity);
}

