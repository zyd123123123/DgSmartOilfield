package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;

public interface HtxxlrServiceI {

	/**
	 * 查询厂级单位下拉列表
	 * @return
	 */
	List<Map<String, String>> unit_select();
	
	/**
	 * 验证
	 * @param entity
	 * @return
	 */
	Map<String,Object> check(HtxxlrEntity entity);
	
	
	/**
	 * 承包商名称下拉列表
	 */
	  List<Map<String, String>> cbs_select();
	 
	 /**
	  * 查询承包商下小队id、名称、资质
	  */
	  List<QualificationEntity> qualification_select(HtxxlrEntity entity);
	 /**
	  * 合同录入保存
	  * @param entity
	  * @param files
	  * @return
	  */
	  Map save(HtxxlrEntity entity,MultipartFile[] files);
	  /**
	   * 合同修改保存
	   * @param entity
	   * @param entity_q
	   * @return
	   */
	  Map  updateSave(HtxxlrEntity entity, QualificationEntity entity_q);
	  
		/**
		 * 合同退回页面，删除功能 (根据合同id删除合同、合同绑定队伍、合同图片)
		 * @param entity
		 * @return
		 */
	  Map  removeContract(HtxxlrEntity entity);
	  
	  Map  htshth(HtxxlrEntity entity);
	  
	  Map  htwgth(HtxxlrEntity entity);
}
