package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.*;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface GxServiceI {
	/**
	 * 查询
	 *
	 * @param gx
	 * @return
	 */
	Map initComplate(GxEntity gx, Pager pager);

	/**
	 * 查询
	 *
	 * @return
	 */
	Map initParam(GxcsEntity entity);

	/**
	 * 新增工序
	 *
	 * @return
	 */
	Map addSave(GxEntity gx);

	/**
	 * 修改工序
	 *
	 * @return
	 */
	Map editAll(GxEntity gx);

	/**
	 * 根据spid查询
	 *
	 * @param gx
	 * @return
	 */
	List<GxEntity> paramSele(GxEntity gx, Integer spid, String spname, HttpSession session);







	/**
	 * 施工单元查询
	 * @param entity
	 * @return
	 */
	Map sgdyList(SgdyEntity entity);
	Map gx_sgdy_list(SgdyEntity entity);
	/**
	 * 个人工序模板保存
	 *
	 * @param
	 * @return
	 */
	Map gx_mb_addSave(GxnrmbEntity entity) ;

	Map gx_mb_remove(GxnrmbEntity entity);

	/**
	 * 查询基础工序下拉框
	 * @return
	 */
	Map circuitSelect(GxEntity entity);
	Map sgdySelect(SgdyEntity entity);

	List<Map<String, String>> tygxSelect(GxEntity entity);

	/**
	 * 工序返回数据
	 *
	 * @param
	 * @return
	 */
	Map getPParamJSON(GxnrmbEntity entity);
	List<Map<String, String>> getCslb();
	Map removeSave(GxEntity gx);
	Map gxSelect(GxEntity entity);
	List<SgdyEntity> sgdy_tiqu(int spid1);
	Map sgdySave(SgdyEntity entity);
	List<Map<String,Object>> hseSelect(GxHseEntity entity);
	Map hse_bd_save(GxHseEntity entity);
	List<GxHseEntity> gxhseList(GxHseEntity entity);
	List<GxHseEntity> hsenr(GxHseEntity entity);
	Map sgmbdzList(SgmbdzEntity entity, Pager pager);
	Map sgmbdzSave(SgmbdzEntity entity);
	SgmbdzEntity sgmbdzEditSelect(SgmbdzEntity entity);
	List<SgmbdzEntity> sgmbdzEditList(SgmbdzEntity entity);
	Map sgmbdzEditSave(SgmbdzEntity entity);
	Map sgmbdzRemoveSave(SgmbdzEntity entity);
	Map sgmbbdList(ZylxEntity entity, Pager pager);
	List<Map<String, String>> jbSelect(MeasureEntity entity);
	Map csSelect(MeasureEntity entity, String tab, String templateid);
	List<Map<String, String>> gxmbSelect(SgmbbdEntity entity);
	Map sgmbbdSave(SgmbbdEntity entity);
	List<SgmbdzEntity> sgmbList(SgmbbdEntity entity);
	Map  sgmbbdRemove(SgmbbdEntity entity);
	public Map getGxwh(HttpServletRequest request, HttpServletResponse response, GxEntity entity);
	public String change(GxEntity entity, HttpSession session, Model model);
	public void update(GxEntity entity);
	Map sgmbbd_zylx_List(SgmbbdEntity entity, Pager pager);
	SgmbbdEntity zylxName(SgmbbdEntity entity);
    Map sgmbbd_zylx_addSave(SgmbbdEntity entity);
    Map sgmbbd_zylx_remove(SgmbbdEntity entity);
	Map sgmbbd_zylx_Save_tree(String templateid, String tab, String str);
	public Map gxwh_list(GxEntity entity);
	public void batch_insert(WorkHoursEntity entity);
	Map use_hours(GxEntity entity);
    List<GxcsEntity> gxsgcs(GxcsEntity entity);
    List<GxcsEntity> sgdy_param_view_list(GxcsEntity entity);
	Map saveParamBd(GxcsEntity gx);
	List<SgdygjclEntity> gjclList(SgdygjclEntity entity);
	Map<String, String>gjclSave(SgdygjclEntity rb);
	Map gx_mb_list(GxEntity entity);
	Map sgdy_List(SgdyEntity entity, Pager pager);
	Map sgdy_gx_List(SgdyEntity entity, Pager pager);
	Map sgdy_Save(SgdyEntity entity);
	Map sgdy_edit_Save(SgdyEntity entity);
	Map sgdy_editAll_Save(SgdyEntity entity);
	Map sgdy_remove(String sgdyid);
	List<SgdyEntity> sgdy_editAllSelect(String shuzu);
	List<SgdyEntity> sgdy_editSelect(SgdyEntity entity);
	List<SgdygjclEntity> sgdy_gjcl_editList(SgdygjclEntity entity);
	List<SgdygjclEntity> sgdy_gjcl_List(SgdygjclEntity entity);
	Map<String, String>sgdy_gjclSave(SgdygjclEntity entity);
	Map sgdy_gx_editSave(SgdyEntity entity);
	Map sgdy_param_Save(GxcsEntity gx);
	Map sgdy_mb_list(GxEntity entity);
	Map sgdy_mb_select(GxnrmbEntity entity);
	Map<String, String> sgdy_mb_addSave(GxnrmbEntity entity) ;
	Map sgdy_mb_remove(GxnrmbEntity entity);
	Map  sgdy_aqhbys(SgdyEntity entity);
	Map gx_sgdy_bdSave(SgdyEntity entity);
	Map  zylSelect(ZylxEntity entity);
	Map cs_list(ZylxEntity entity);
	List<Gx_lbEntity> gx_lb_wh_List(Gx_lbEntity entity);
	Map gx_lb_wh_Save(Gx_lbEntity entity);

	List<Map<String, Object>>getgxlb(GxEntity entity);
}
