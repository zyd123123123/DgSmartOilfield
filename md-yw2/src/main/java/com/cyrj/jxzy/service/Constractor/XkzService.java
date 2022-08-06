package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.entity.Constractor.Qualification_personEntity;
import com.cyrj.jxzy.entity.Constractor.XkzEntity;
import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;
import com.cyrj.jxzy.entity.Constractor.XkzhtEntity;
import com.cyrj.jxzy.entity.Constractor.XkzshEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;

public interface XkzService {

	/**
	 * 许可证申请list
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkzsqList(NlpgshEntity entity, Pager pager);
	/**
	 * 验证队伍是否已申请许可证
	 * @return
	 */
	Map xkzsqyz(XkzhtEntity entity);
	/**
	 * 查询合同信息
	 * @return
	 */
	HtxxckEntity contract(String contract_id);
	/**
	 * 队伍准入证信息
	 * @param term_id
	 * @return
	 */
	XkzEntity term(String term_id);
	/**
	 * 队伍人员
	 * @param term_id
	 * @return
	 */
	List<Qualification_personEntity>person(String term_id);
	/**
	 * 队伍主要设备
	 * @param term_id
	 * @return
	 */
	ZysbEntity zysb(String term_id);
	/**
	 * 队伍主要配套设备
	 * @param term_id
	 * @return
	 */
	List<Xkz_sbEntity> zyptsb(String term_id);
	/**
	 * 许可证申请保存
	 * @param entity
	 * @return
	 */
	Map xkzsqSave(XkzhtEntity entity);
	
	/**
	 * 许可证审核list
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkzshList(XkzshEntity entity, Pager pager);
	/**
	 * 审核保存
	 * @param entity
	 * @return
	 */
	Map auditSave(XkzshEntity entity);
	/**
	 * 许可证查看list
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkzckList(XkzshEntity entity, Pager pager);
	
	/**
	 * 许可证查看合同list
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkzck_ht_List(XkzshEntity entity, Pager pager);
	
	/**
	 * 许可证查看队伍list
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkzck_term_List(XkzshEntity entity);
	/**
	 * 许可证撤回保存
	 * @param entity
	 * @param pager
	 * @return
	 */
	Map  xkz_List(XkzshEntity entity);
	
	
	/**
	 * 许可证撤回保存
	 * @return
	 */
	Map revokeSave(XkzshEntity entity);
}
