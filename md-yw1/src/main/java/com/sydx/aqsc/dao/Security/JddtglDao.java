package com.sydx.aqsc.dao.Security;

import java.util.List;
import java.util.Map;
import com.sydx.aqsc.entity.Security.CamEntity;
import com.sydx.aqsc.entity.Security.JddtglEntity;
import com.sydx.aqsc.entity.Security.JddthdEntity;
import com.sydx.aqsc.entity.Security.Xlt_cqjEntity;

public interface JddtglDao {

	/**
	 * 统计数量
	 * @param entity
	 * @return
	 */
	int count_jddtcx(JddtglEntity entity);

	/**
	 * 查询数据
	 * @param entity
	 * @return
	 */
	List<JddtglEntity> jddtcx_query(JddtglEntity entity);

	/**
	 * 根据design_id查找该串号下所有对应日报
	 * @param entity
	 * @return
	 */
	List<JddtglEntity> jddtxq_query(JddtglEntity entity);

	List<JddtglEntity> zydtxq_query(JddtglEntity entity);

	List<Map> selectByParam1(Xlt_cqjEntity week);

	List<Map> selectByParam8(Xlt_cqjEntity week);

	List<Map> selectByParam88(Xlt_cqjEntity week);

	List<Map> selectByParam3(Xlt_cqjEntity week);

	List<Map> selectByParam33(Xlt_cqjEntity week);

	List<Map> selectByParam6(Xlt_cqjEntity week);

	List<Map> selectByParam66(Xlt_cqjEntity week);

	/**
	 * 本次作业监督动态查询
	 * @param entity
	 * @return
	 */
	List<JddtglEntity> jddtbc_query(JddtglEntity entity);

	//监督动态信息保存
	int insertJddtxx(JddtglEntity entity);

	//根据design_id查询留言板内容
	List<JddthdEntity> jddtlyb_query(JddthdEntity entity);

	//监督留言板内容保存
	int insertJddtly(JddthdEntity entity);

	//监督留言板更新
	int updately(JddthdEntity entity);

	//附加工序申请
	List<JddthdEntity> fjgx_query(JddthdEntity jddthdEntity);

	//附加工序保存
	int insertFjgx(JddthdEntity entity);

	//附加工序修改
	int updateFjgx(JddthdEntity entity);

	//附加工序审核
	int updateFjgxSh(JddthdEntity entity);

	List<Map> selectByParam10(Xlt_cqjEntity week);

	List<Map> selectByParam11(Xlt_cqjEntity week);

	List<JddtglEntity> jdtj_query(JddtglEntity entity);

	int count_jdjlcx(JddtglEntity entity);

	List<JddtglEntity> jdjlcx_query(JddtglEntity entity);

	List<JddtglEntity> gxxq_query(JddtglEntity entity);

	List<JddtglEntity> jdjl_query(JddtglEntity entity);

	int insertJd(JddtglEntity a);

	int delJd(JddtglEntity entity);

	List<JddtglEntity> jdjl_query1(JddtglEntity entity);

	int updateJdjl(JddtglEntity entity);

	int count_jksb(CamEntity entity);

	List<CamEntity> jksb_query(CamEntity entity);

	int updateJksb(CamEntity entity);

	void insertPic(JddtglEntity a);

	CamEntity checkMaxId(CamEntity entity);

	int updateSb(CamEntity entity);

	int delSb(CamEntity entity);

	List<CamEntity> jksbtd_query(CamEntity entity);

	CamEntity checkMaxtdId(CamEntity entity);

	int insertJksbtd(CamEntity a);

	int updateJksbtd(CamEntity a);

	int count_sbtd(CamEntity entity);

	List<CamEntity> sbtd_query(CamEntity entity);

	int tdBindSave(CamEntity entity);

	List<CamEntity> td_bind_query(CamEntity entity);

	int updateTeam(CamEntity a);

	List<CamEntity> selectJh(CamEntity entity);

	List<CamEntity> bdjh_query(CamEntity entity);

	int count_bdjh(CamEntity entity);

	int delJh(CamEntity entity);
}
