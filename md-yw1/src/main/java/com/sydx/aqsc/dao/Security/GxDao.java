package com.sydx.aqsc.dao.Security;

import com.sydx.aqsc.entity.Security.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
@Component
public interface GxDao {
	/**
	 * 查询总记录数
	 * 
	 * @param gx
	 * @return
	 */
	int selectCount(GxEntity gx);
	
	/**
	 * 查询工序列表
	 * 
	 * @param gx
	 * @return
	 */
	List<GxEntity> findAll(GxEntity gx);

	String selectMaxId(GxEntity gx);
	
	int insertGx(GxEntity a);

	List<GxnrmbEntity> selectGxProcess(GxnrmbEntity entity);
	
	void updateGxProcess(GxnrmbEntity entity);
	void gx_mb_remove(GxnrmbEntity entity);
	void insertGxProcess(GxnrmbEntity entity);
	
	int updateGx(GxEntity a);

	List<GxEntity> selectById(GxEntity gx);
	
	int deleteParam(Integer spid);

	
	List<GxEntity> findAll1(GxEntity gx);

	GxnrmbEntity gxmbSelect(GxnrmbEntity entity);

	List<GxEntity> select();

	int removeSave(GxEntity gx);

	List<GxcsEntity> findAll2(GxcsEntity gx);

	List<GxEntity> circuitSelect(GxEntity entity);
	List<SgdyEntity> sgdySelect(SgdyEntity entity);

	List<GxEntity>  tygxSelect(GxEntity entity);
	
//	 List<RbEntity> gjclSelect(RbEntity rb) ;
//
//	 void gjclDelete(RbEntity rb) ;
//	 void gjclSave(RbEntity rb) ;



	List<SgdyEntity> sgdyList(SgdyEntity entity);
	List<SgdyEntity> gx_sgdy_list(SgdyEntity entity);

	void  sgdyDelect(SgdyEntity entity);
	void  sgdyInsert(SgdyEntity entity);



	List<GxHseEntity> hseSelect(GxHseEntity entity);

	void  hse_bdDelete(GxHseEntity entity);
	void hse_bdInsert(GxHseEntity entity);

	List<GxHseEntity> gxhseList(GxHseEntity entity);

	List<GxHseEntity> hsenrSelect(GxHseEntity entity);

	int countSgmbdz(SgmbdzEntity entity);
	List<SgmbdzEntity> listSgmbdz(SgmbdzEntity entity);

	void sgmbdzInsert1(SgmbdzEntity entity);
	void sgmbdzInsert2(SgmbdzEntity entity);

	SgmbdzEntity sgmbdzEditSelect(SgmbdzEntity entity);
	List<SgmbdzEntity> sgmbdzEditList(SgmbdzEntity entity);

	void updateSgmbdzEdit(SgmbdzEntity entity);
	void deleteSgmbdzEdit(SgmbdzEntity entity);

	List<ZylxEntity> zylxselect(SgmbdzEntity entity);
	void sgmbdzRemove(SgmbdzEntity entity);


	/**
	 * 查询作业类型总数
	 * @param entity
	 * @return
	 */
	int  sgmbbdCount(ZylxEntity entity);
	/**
	 * 查询作业类型
	 * @param entity
	 * @return
	 */
	List<ZylxEntity>  sgmbbdList(ZylxEntity entity);

	List<MeasureEntity>jbSelect(MeasureEntity entity);
	List<MeasureEntity>csSelect(@Param("entity") MeasureEntity entity);
	List<String>checkSelect(@Param("entity") MeasureEntity entity, @Param("templateid") String templateid);

	List<SgmbdzEntity> gxmbList(SgmbbdEntity entity);

	void sgmbbdInsert(SgmbbdEntity entity);

	List<SgmbdzEntity> sgmbList(SgmbbdEntity entity);

	void sgmbbdRemove(SgmbbdEntity entity);

	List<GxEntity> getGxwh(GxEntity entity);

	GxEntity gxwh_ById(GxEntity entity);

	void update(GxEntity entity);


   List<SgmbbdEntity>	sgmbbd_zylx_List(SgmbbdEntity entity);
  int gmbbd_zylx_count(SgmbbdEntity entity);

	SgmbbdEntity zylxName(SgmbbdEntity entity);

    void sgmbbd_zylx_addSave(SgmbbdEntity entity);

    void  sgmbbd_zylx_remove(SgmbbdEntity entity);

	void  sgmbbd_remove(SgmbbdEntity entity);
	void  sgmbbd_Save(SgmbbdEntity entity);

	SgmbbdEntity zylx(SgmbbdEntity entity);

	//工时维护
	List<GxEntity> gxwh_list(GxEntity entity);
	void delete_workhours(WorkHoursEntity entity);
	void batch_insert(WorkHoursEntity entity);

	GxEntity use_hours(GxEntity entity);

    List<GxcsEntity> gxsgcs(GxcsEntity entity);
    List<GxcsEntity> sgdy_param_view_list(GxcsEntity entity);

    void updateParam(GxcsEntity gx);

    void removeParamBd(GxcsEntity gx);

	void saveParamBd(GxcsEntity gx);
	List<GxEntity> selectByParam1(GxEntity gx);
	List<AqhbwhEntity> selectByParam2(GxEntity gx);

	GxEntity circuit_id(GxEntity gx);
	String tableName(RbEntity rb);

	Map<String, Object> selectPPData(RbEntity rb);

	List<SgdygjclEntity> gjclList(SgdygjclEntity entity);
	void gjclDelete(SgdygjclEntity entity) ;
	void gjclSave(SgdygjclEntity entity) ;

	List<GxEntity> gx_mb_list(GxEntity entity);

	List<SgdyEntity> sgdy_List(SgdyEntity entity);
	int sgdy_count(SgdyEntity entity);
	void  sgdy_Save(SgdyEntity entity);
	void  sgdy_editAll_Save(SgdyEntity entity);
	void  sgdy_edit_Save(SgdyEntity entity);
	void  sgdy_remove(SgdyEntity entity);
	List<SgdyEntity> sgdy_editAllSelect(SgdyEntity entity);
	List<SgdyEntity> sgdy_editSelect(SgdyEntity entity);
	List<SgdygjclEntity> sgdy_gjcl_List(SgdygjclEntity entity);
	List<SgdygjclEntity> sgdy_gjcl_editList(SgdygjclEntity entity);
	void sgdy_gjclSave(SgdygjclEntity entity) ;
	void sgdy_gx_editSave(SgdyEntity entity);
	List<SgdyEntity> sgdy_gx_List(SgdyEntity entity);
	int sgdy_gx_count(SgdyEntity entity);
	void sgdy_param_Save(GxcsEntity gx);
	List<GxEntity> sgdy_mb_list(GxEntity entity);

	GxnrmbEntity sgdy_mbSelect(GxnrmbEntity entity);
	List<GxcsEntity> sgdy_paramSelect(GxcsEntity gx);

	void sgdy_mb_update(GxnrmbEntity entity);
	void sgdy_mb_Insert(GxnrmbEntity entity);
	void sgdy_mb_remove(GxnrmbEntity entity);
	void  gx_sgdy_bdSave(SgdyEntity entity);
	List<ZylxEntity> zylSelect(ZylxEntity entity);
	List<Gx_lbEntity> gx_lb_wh_List(Gx_lbEntity entity);
	void gx_lb_wh_Save(Gx_lbEntity entity);

	/**
	 * 查询工序类别
	 *
	 * @param gx
	 * @return
	 */
	List<GxEntity> getgxlb(GxEntity gx);
}
