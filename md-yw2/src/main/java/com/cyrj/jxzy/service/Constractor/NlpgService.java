package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj2Entity;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;

public interface NlpgService {

	/**
	 * 能力评估附录表数据
	 * @return
	 */
	List<CbsFj2Entity> ListNlpgflb();
	/**
	 * 能力评估附录表保存
	 * @param entity
	 * @return
	 */
	Map  flbSave(CbsFj2Entity entity);
	
	/**
	 * 能力评估申请
	 * @param entity
	 * @param pager
	 * @return
	 */
   Map nlgpsqList(ContractTeamEntity entity, Pager pager);
   /**
    * 能力评估申请，施工队伍下拉列表
    * @param entity
    * @return
    */
   List<Map<String, String>> applyTerm(ContractTeamEntity entity);
	/**
	 * 能力评估申请保存
	 * @param entity
	 * @return
	 */
   Map applySave(ContractTeamEntity entity);
	/**
	 * 能力评估申请记录（查看）list
	 * @param entity
	 * @param pager
	 * @return
	 */
   Map nlgpsqjlList(ContractTeamEntity entity, Pager pager);
   /**
    * 能力评估合同队伍信息
    * @param pgb_id
    * @return
    */
   ContractTeamEntity contractTeam(String pgb_id);
   /**
    * 能力评估审核保存
    * @param pgb_id
    * @return
    */
   Map auditSave(NlpgshEntity entity);
	/**
	 * 能力评估查看
	 * @param entity
	 * @param pager
	 * @return
	 */
  Map nlgpck(ContractTeamEntity entity, Pager pager);
  /**
   * 评估审核记录
   * @param pgb_id
   * @return
   */
  List<CbsFj2Entity>nlpgList(String pgb_id);
  
  Map revokeSave(NlpgshEntity entity);
}
