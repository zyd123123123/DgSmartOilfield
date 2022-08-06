package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxwhEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;

public interface HtxxwhService {

	/**
	 * 合同信息维护列表数据
	 * @param entity
	 * @param page
	 * 
	 */
	 Map  listHtxxwh(HtxxckEntity entity, Pager pager);

	 /**
	  * 合同信息
	  * @param contract_id
	  * @return
	  */
	 HtxxckEntity getHtxxck(String contract_id);
	 /**
	  * 保存合同变更保存
	  * @param entity
	  * @return
	  */
	 Map  change_save(HtxxwhEntity entity);
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
	  Map change_Record(String contract_id);
		/**
		 * 合同变更信息审核保存
		 * @param entity
		 * @return
		 */
	  Map changeAuditSave(HtxxwhEntity entity);
		/**
		 * 合同完工确认
		 * @return
		 */
	  Map completionConfirmation(HtxxwhEntity entity);
	 
	  //合同变更记录删除
	  Map  bgRemove(HtxxwhEntity entity);
}
