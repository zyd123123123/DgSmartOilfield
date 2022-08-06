package com.sydx.aqsc.service.Security;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.CamEntity;
import com.sydx.aqsc.entity.Security.JddtglEntity;
import org.springframework.ui.Model;


public interface JddtglServiceI {

//	//监督人员考核数据列表
//		Map sgjzydt_query(JddtglEntity entity, String search, Pager pager);
//
//		//施工井作业动态详情
//		String sgjxq_check(JddtglEntity entity, Model model);
//
//		//查询单位
//		List<Map> selectByParam1(Xlt_cqjEntity week);
//
//		//统计数据
//		List<Map> selectByParam8(Xlt_cqjEntity week);
//
//		//统计数据
//		List<Map> selectByParam88(Xlt_cqjEntity week);
//
//		//年累
//		List<Map> selectByParam3(Xlt_cqjEntity week);
//
//		//施工井动态
//		Object selectByParam6(Xlt_cqjEntity week);
//
//		Object selectByParam66(Xlt_cqjEntity week);
//
//		//施工井作业监督动态
//		String sgjjddt_check(JddtglEntity entity, Model model);
//		//监督动态信息维护保存
//		String saveJddtxx(JddtglEntity entity, Model model);
//
//		//监督留言板
//		String jdlyb(JddthdEntity entity, JddtglEntity jddtglEntity, Model model);
//
//		//监督留言板内容保存
//		String saveJddtly(JddthdEntity entity, JddtglEntity jddtglEntity, Model model);
//
//		//监督留言更新
//		String updately(JddthdEntity entity, JddtglEntity jddtglEntity, Model model);
//
//		//附加工序申请
//		String fjgxsq(FjgxEntity fjgxEntity, JddtglEntity jddtglEntity, Model model);
//
//		//附加工序保存
//		String saveFjgx(JddthdEntity entity, JddtglEntity jddtglEntity, Model model);
//
//		//附加工序修改
//		String updateFjgx(JddthdEntity entity, JddtglEntity jddtglEntity, Model model);
//
//		//附加工序审核页面
//		String fjgxsh(FjgxEntity fjgxEntity, JddtglEntity entity, Model model);
//
//		//附加工序审核
//		String updateFjgxSh(JddthdEntity entity, JddtglEntity jddtglEntity, Model model, String bs);
//
//		List<Map> selectByParam10(Xlt_cqjEntity week);
//
//		Object selectByParam11(Xlt_cqjEntity week);
//
//		String jdtjxq_check(JddtglEntity entity, Model model);
//
//		String zydtxq_check(JddtglEntity entity, Model model);
//
//		List<Map> selectByParam33(Xlt_cqjEntity week);
//
//		Map jdjl_query(JddtglEntity entity, String search, Pager pager);
//
//		String jdjl_add(String design_id, String well_common_name, Model model);
//
//		String saveJd(JddtglEntity entity, Model model);
//
//		String jdjl_ll(String design_id, String well_common_name, Model model);
//
//		String jdjl_edit(String design_id, String well_common_name, Model model);

    int jdjltj(JddtglEntity entity);

    Map jksb_qyery(CamEntity entity, Pager pager);

    Map camSave(CamEntity entity);

//    String uploadFiles(JddtglEntity entity, HttpServletRequest request) throws Exception;

    Map jksb_edit(CamEntity entity);

    Map camEdit(CamEntity entity);

    Map delSb(CamEntity entity);

    Map jksbtd_add(CamEntity entity);

    Map tdSave(CamEntity entity);

    Map tdEdit(CamEntity entity);
    Map sbdk_query(CamEntity entity, Pager pager);

    Map tdBindSave(CamEntity entity);

    Map jksbtd_editTm(CamEntity entity);

    Map jksbtd_saveEd(CamEntity entity);

    Map selectJh(CamEntity entity);

    Map jhBindSave(CamEntity entity);

    Map check_bindjh(CamEntity entity, Pager pager);

    Map delJh(CamEntity entity);
}
