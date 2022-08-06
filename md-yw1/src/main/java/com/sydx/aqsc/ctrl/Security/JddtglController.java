package com.sydx.aqsc.ctrl.Security;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.CamEntity;
import com.sydx.aqsc.entity.Security.JddtglEntity;
import com.sydx.aqsc.service.Security.JddtglServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/jddtgl")
@Api(tags = "监控设备管理")
public class JddtglController {

    @Autowired
    private JddtglServiceI jddtglService;

//	/**
//	 * 施工井作业动态列表
//	 * @param entity
//	 * @param model
//	 * @param search 权限
//	 * @param session
//	 * @param oilfield 油田单位
//	 * @return
//	 */
//	@RequestMapping(value = "/sgjzydtcx")
//	public String sgjzydtcx(JddtglEntity entity, Model model, String search, HttpSession session, String oilfield) {
//		String userid = session.getAttribute("userid")+"";
//		String true_name = session.getAttribute("truename")+"";
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("userid", userid);
//		model.addAttribute("true_name", true_name);
//		return "Construction/dzjd/check_sgjzydtcx";
//	}
//
//	/**
//	 * 施工井作业动态列表数据
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/sgjzydt_query")
//	@ResponseBody
//	public Map sgjzydt_query(JddtglEntity entity, String search, Model model, Pager pager) {
//		return jddtglService.sgjzydt_query(entity, search, pager);
//	}
//
//	/**
//	 * 施工井动态详情页面
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/sgjxq_check")
//	public String sgjxq_check(JddtglEntity entity,Model model) {
//		return jddtglService.sgjxq_check(entity,model);
//	}
//
//	/**
//	 * 施工井作业动态统计
//	 * @param entity
//	 * @param model
//	 * @param search 权限
//	 * @param session
//	 * @param oilfield 油田单位
//	 * @return
//	 */
//	@RequestMapping(value = "/sgjzydttj")
//	public String sgjzydttj(JddtglEntity entity,Model model,String search,HttpSession session,String oilfield) {
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("thisYear", Calendar.getInstance().get(Calendar.YEAR));
//		return "Construction/dzjd/check_sgjzydttj";
//	}

//	/**
//	 * 施工井作业动态
//	 * @param week
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("data")
//	public List data(Xlt_cqjEntity week) {
//		Calendar calendar = Calendar.getInstance();
//        calendar.clear();
//        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
//        Date currYearFirst = calendar.getTime();
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        String begin_date = f.format(currYearFirst);//一年的开始
//        calendar.clear();
//        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
//        calendar.roll(Calendar.DAY_OF_YEAR, -1);
//        Date currYearLast = calendar.getTime();
//        String end_date = f.format(currYearLast);//一年的结束
//        week.setRq1(begin_date);
//        week.setRq2(end_date);
//        Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date);// 默认获取当天
//		week.setRq5(today);
//		int unit=week.getId().length()+3;
//		if(unit==14)
//			unit=11;
//		week.setParams(unit + "");
//		//先查出所有单位
//		List<Map> list = jddtglService.selectByParam1(week);
//		//统计数据
//		List<Map> list1 = jddtglService.selectByParam8(week);
//		//年累
//		//List<Map> list2 = jddtglService.selectByParam3(week);
//		for (Map m : list) {
//			//m.put("NL", 0);
//			m.put("HJ", 0);
//
//			m.put("YXJ", 0);
//			m.put("YCS", 0);
//			m.put("YDX", 0);
//			m.put("YBFFJ", 0);
//			m.put("YWH", 0);
//			m.put("YXJTC", 0);
//
//			m.put("SXJ", 0);
//			m.put("SCS", 0);
//			m.put("SDX", 0);
//			m.put("SBFFJ", 0);
//			m.put("SWH", 0);
//			m.put("STZZ", 0);
//
//			m.put("QXJ", 0);
//			m.put("QCS", 0);
//			m.put("QDX", 0);
//			m.put("QBFFJ", 0);
//			m.put("QWH", 0);
//			m.put("QXJTC", 0);
//			m.put("QQT", 0);
//
//
//			m.put("JT", 0);
//			m.put("NB", 0);
//			m.put("MY", 0);
//
//			for (Map m1 : list1) {
//				if (m.get("ID").equals(m1.get("UNIT"))) {
//
//					m.put("HJ", m1.get("HJ") == null ? 0 : m1.get("HJ"));
//
//					m.put("YXJ", m1.get("YXJ") == null ? 0 : m1.get("YXJ"));
//					m.put("YCS", m1.get("YCS") == null ? 0 : m1.get("YCS"));
//					m.put("YDX", m1.get("YDX") == null ? 0 : m1.get("YDX"));
//					m.put("YBFFJ", m1.get("YBFFJ") == null ? 0 : m1.get("YBFFJ"));
//					m.put("YWH", m1.get("YWH") == null ? 0 : m1.get("YWH"));
//					m.put("YXJTC", m1.get("YXJTC") == null ? 0 : m1.get("YXJTC"));
//
//					m.put("SXJ", m1.get("SXJ") == null ? 0 : m1.get("SXJ"));
//					m.put("SCS", m1.get("SCS") == null ? 0 : m1.get("SCS"));
//					m.put("SDX", m1.get("SDX") == null ? 0 : m1.get("SDX"));
//					m.put("SBFFJ", m1.get("SBFFJ") == null ? 0 : m1.get("SBFFJ"));
//					m.put("SWH", m1.get("SWH") == null ? 0 : m1.get("SWH"));
//					m.put("STZZ", m1.get("STZZ") == null ? 0 : m1.get("STZZ"));
//
//					m.put("QXJ", m1.get("QXJ") == null ? 0 : m1.get("QXJ"));
//					m.put("QCS", m1.get("QCS") == null ? 0 : m1.get("QCS"));
//					m.put("QDX", m1.get("QDX") == null ? 0 : m1.get("QDX"));
//					m.put("QBFFJ", m1.get("QBFFJ") == null ? 0 : m1.get("QBFFJ"));
//					m.put("QWH", m1.get("QWH") == null ? 0 : m1.get("QWH"));
//					m.put("QXJTC", m1.get("QXJTC") == null ? 0 : m1.get("QXJTC"));
//					m.put("QQT", m1.get("QQT") == null ? 0 : m1.get("QQT"));
//
//
//					m.put("JT", m1.get("JT") == null ? 0 : m1.get("JT"));
//					m.put("NB", m1.get("NB") == null ? 0 : m1.get("NB"));
//					m.put("MY", m1.get("MY") == null ? 0 : m1.get("MY"));
//
//				}
//			}
//			/*for (Map m2 : list2) {
//				if (m.get("ID").equals(m2.get("UNIT"))) {
//					m.put("NL", m2.get("NL") == null ? 0 : m2.get("NL"));
//				}
//			}*/
//		}
//		return list;
//	}
//
//	@RequestMapping(value = "sgjdt_check")
//	public String well_list(Model model,String measure_class,String	 id,String rq3,String rq4,int rows) {
//		model.addAttribute("measure_class",measure_class);
//		model.addAttribute("unitid",id);
//		model.addAttribute("beginDate",rq3);
//		model.addAttribute("endDate",rq4);
//		model.addAttribute("rows",rows);
//		return "Construction/dzjd/sgjdt_check";
//	}
//
//	@RequestMapping("sgjzydttj_dj")
//	@ResponseBody
//	public Map well_list(Pager pager,Xlt_cqjEntity week) {
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date);// 默认获取当天
//		week.setRq5(today);
//		// 设置起始页
//		SetPageUtil.setPage(week, pager);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNo", pager.getPageNo());
//		map.put("totalRows", week.getTotalRows());
//			map.put("rows", jddtglService.selectByParam6(week));
//		return map;
//	}
//
//	/**
//	 * 施工井作业动态_监督动态
//	 */
//	@RequestMapping(value = "/sgjjddt_check")
//	public String sgjjddt_check(JddtglEntity entity,Model model) {
//		return jddtglService.sgjjddt_check(entity,model);
//	}
//
//	/**
//	 * 监督动态信息维护保存
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/saveJddtxx")
//	public String saveJddtxx(JddtglEntity entity,Model model) {
//		return jddtglService.saveJddtxx(entity,model);
//	}
//
//	/**
//	 * 监督留言板页面
//	 * @param entity
//	 * @param model
//	 * @param search
//	 * @param session
//	 * @param oilfield
//	 * @return
//	 */
//	@RequestMapping(value = "/dthd")
//	public String dthd(JddtglEntity entity,Model model,String search,HttpSession session,String oilfield) {
//		String userid = session.getAttribute("userid")+"";
//		String true_name = session.getAttribute("truename")+"";
//		oilfield = session.getAttribute("oilfield")+"";
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("userid", userid);
//		model.addAttribute("true_name", true_name);
//		return "Construction/dzjd/jddthd";
//	}
//
//	/**
//	 * 监督留言板
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/jdlyb")
//	public String jdlyb(JddthdEntity entity,JddtglEntity jddtglEntity,Model model) {
//		return jddtglService.jdlyb(entity,jddtglEntity,model);
//	}
//
//	/**
//	 * 监督动态留言保存
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/saveJddtly")
//	public String saveJddtxx(JddthdEntity entity,JddtglEntity jddtglEntity,Model model) {
//		return jddtglService.saveJddtly(entity,jddtglEntity,model);
//	}
//
//	/**
//	 * 监督动态留言板回复
//	 * @param entity
//	 * @param jddtglEntity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/updately")
//	@ResponseBody
//	public String updately(JddthdEntity entity,JddtglEntity jddtglEntity,Model model) {
//		return jddtglService.updately(entity,jddtglEntity,model);
//	}
//
//	/**
//	 * 附加工序申请
//	 * @param entity
//	 * @param jddtglEntity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/fjgxsq")
//	public String check_fjgxsq(JddtglEntity entity,Model model,String search,HttpSession session,String oilfield) {
//		String userid = session.getAttribute("userid")+"";
//		String true_name = session.getAttribute("truename")+"";
//		oilfield = session.getAttribute("oilfield")+"";
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("userid", userid);
//		model.addAttribute("true_name", true_name);
//		return "Construction/dzjd/check_fjgxsq";
//	}
//
//	@RequestMapping(value = "/fjgxsq_query")
//	public String fjgxsq_query(FjgxEntity fjgxEntity,JddtglEntity entity,Model model) {
//		return jddtglService.fjgxsq(fjgxEntity, entity, model);
//	}
//
//	/**
//	 * 附加工序保存
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/saveFjgx")
//	public String saveFjgx(JddthdEntity entity,JddtglEntity jddtglEntity,Model model) {
//		return jddtglService.saveFjgx(entity,jddtglEntity,model);
//	}
//
//	/**
//	 * 附加工序修改
//	 * @param entity
//	 * @param jddtglEntity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/updateFjgx")
//	@ResponseBody
//	public String updateFjgx(JddthdEntity entity,JddtglEntity jddtglEntity,Model model) {
//		return jddtglService.updateFjgx(entity,jddtglEntity,model);
//	}
//
//	/**
//	 * 附加工序审核
//	 * @param entity
//	 * @param jddtglEntity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/fjgxsh")
//	public String check_fjgxsh(JddtglEntity entity,Model model,String search,HttpSession session,String oilfield) {
//		String userid = session.getAttribute("userid")+"";
//		String true_name = session.getAttribute("truename")+"";
//		oilfield = session.getAttribute("oilfield")+"";
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("userid", userid);
//		model.addAttribute("true_name", true_name);
//		return "Construction/dzjd/check_fjgxsh";
//	}
//
//	@RequestMapping(value = "/fjgxsh_query")
//	public String fjgxsh_query(FjgxEntity fjgxEntity,JddtglEntity entity,Model model) {
//		return jddtglService.fjgxsh(fjgxEntity, entity, model);
//	}
//
//	/**
//	 * 附加工序审核
//	 * @param entity
//	 * @param jddtglEntity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/updateFjgxSh")
//	@ResponseBody
//	public String updateFjgxSh(JddthdEntity entity,JddtglEntity jddtglEntity,Model model,String bs) {
//		return jddtglService.updateFjgxSh(entity,jddtglEntity,model,bs);
//	}
//
//	/**
//	 * 监督动态统计
//	 * @param entity
//	 * @param model
//	 * @param search 权限
//	 * @param session
//	 * @param oilfield 油田单位
//	 * @return
//	 */
//	@RequestMapping(value = "/jdtj")
//	public String jddttj(JddtglEntity entity,Model model,String search,HttpSession session,String oilfield) {
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0cq");
//		model.addAttribute("entity", entity);
//		model.addAttribute("thisYear", Calendar.getInstance().get(Calendar.YEAR));
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String month = f.format(date);// 默认获取当前月份
//		model.addAttribute("date", month);
//		return "Construction/dzjd/jddttj";
//	}
//
//	/**
//	 * 施工井作业动态
//	 * @param week
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("data_jd")
//	public List data_jd(Xlt_cqjEntity week) {
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String month = f.format(date);// 默认获取当前月份
//		if(week.getMonth()==null ||week.getMonth()=="" ||week.getMonth().equals("null")) {
//			week.setMonth(month);
//		}
//		int unit=week.getId().length()+3;
//		if(unit==14)
//			unit=11;
//		week.setParams(unit + "");
//		//先查出所有单位
//		List<Map> list = jddtglService.selectByParam1(week);
//		//统计数据
//		List<Map> list1 = jddtglService.selectByParam10(week);
//		//年累
//		//List<Map> list2 = jddtglService.selectByParam3(week);
//		for (Map m : list) {
//			//m.put("NL", 0);
//
//			m.put("JXCS", 0);
//			m.put("JXDX", 0);
//			m.put("JXBF", 0);
//			m.put("JXWH", 0);
//			m.put("JXTC", 0);
//			m.put("JXTZ", 0);
//			m.put("JXDY", 0);
//			m.put("JXQT", 0);
//			m.put("JXZS", 0);
//
//			m.put("JDCS", 0);
//			m.put("JDDX", 0);
//			m.put("JDBF", 0);
//			m.put("JDWH", 0);
//			m.put("JDTC", 0);
//			m.put("JDTZ", 0);
//			m.put("JDDY", 0);
//			m.put("JDQT", 0);
//			m.put("JDZS", 0);
//			m.put("JDFGL", 0);
//
//			for (Map m1 : list1) {
//				if (m.get("ID").equals(m1.get("UNIT"))) {
//
//
//					m.put("JXCS", m1.get("JXCS") == null ? 0 : m1.get("JXCS"));
//					m.put("JXDX", m1.get("JXDX") == null ? 0 : m1.get("JXDX"));
//					m.put("JXBF", m1.get("JXBF") == null ? 0 : m1.get("JXBF"));
//					m.put("JXWH", m1.get("JXWH") == null ? 0 : m1.get("JXWH"));
//					m.put("JXTC", m1.get("JXTC") == null ? 0 : m1.get("JXTC"));
//					m.put("JXTZ", m1.get("JXTZ") == null ? 0 : m1.get("JXTZ"));
//					m.put("JXDY", m1.get("JXDY") == null ? 0 : m1.get("JXDY"));
//					m.put("JXQT", m1.get("JXQT") == null ? 0 : m1.get("JXQT"));
//					m.put("JXZS", m1.get("JXZS") == null ? 0 : m1.get("JXZS"));
//					m.put("JDCS", m1.get("JDCS") == null ? 0 : m1.get("JDCS"));
//					m.put("JDDX", m1.get("JDDX") == null ? 0 : m1.get("JDDX"));
//					m.put("JDBF", m1.get("JDBF") == null ? 0 : m1.get("JDBF"));
//					m.put("JDWH", m1.get("JDWH") == null ? 0 : m1.get("JDWH"));
//					m.put("JDTC", m1.get("JDTC") == null ? 0 : m1.get("JDTC"));
//					m.put("JDTZ", m1.get("JDTZ") == null ? 0 : m1.get("JDTZ"));
//					m.put("JDDY", m1.get("JDDY") == null ? 0 : m1.get("JDDY"));
//					m.put("JDQT", m1.get("JDQT") == null ? 0 : m1.get("JDQT"));
//					m.put("JDZS", m1.get("JDZS") == null ? 0 : m1.get("JDZS"));
//					m.put("JDFGL", Double.parseDouble(m1.get("JDZS").toString())/Double.parseDouble(m1.get("JXZS").toString())==0 ? 0 : (Double.parseDouble(m1.get("JDZS").toString())/Double.parseDouble(m1.get("JXZS").toString()))*100);
//
//				}
//			}
//			/*for (Map m2 : list2) {
//				if (m.get("ID").equals(m2.get("UNIT"))) {
//					m.put("NL", m2.get("NL") == null ? 0 : m2.get("NL"));
//				}
//			}*/
//		}
//		return list;
//	}
//
//	//监督统计点击数据穿透页面
//	@RequestMapping(value = "jdtj_check")
//	public String jdtj_check(Model model,String measure_class,String id,String month,int rows) {
//		model.addAttribute("measure_class",measure_class);
//		model.addAttribute("unitid",id);
//		model.addAttribute("month",month);
//		model.addAttribute("rows",rows);
//		return "Construction/dzjd/jdtj_check";
//	}
//
//	//监督统计单井数据详情页面
//	@RequestMapping("jdtj_dj")
//	@ResponseBody
//	public Map jdtj_dj(Pager pager,Xlt_cqjEntity week) {
//		// 设置起始页
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String month = f.format(date);// 默认获取当前月份
//		if(week.getMonth()==null ||week.getMonth()=="" ||week.getMonth().equals("null")) {
//			week.setMonth(month);
//		}
//		SetPageUtil.setPage(week, pager);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNo", pager.getPageNo());
//		map.put("totalRows", week.getTotalRows());
//			map.put("rows", jddtglService.selectByParam11(week));
//		return map;
//	}
//
//	/**
//	 * 监督统计日报详情页面
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/jdtjxq_check")
//	public String jdtjxq_check(JddtglEntity entity,Model model) {
//		return jddtglService.jdtjxq_check(entity,model);
//	}
//
//	/**
//	 * 作业队伍统计
//	 */
//	@RequestMapping(value = "/zydwtj")
//	public String zydwtj(Model model,String search) {
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0dq");
//		model.addAttribute("thisYear", Calendar.getInstance().get(Calendar.YEAR));
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String month = f.format(date);// 默认获取当前月份
//		model.addAttribute("date", month);
//		return "Construction/dzjd/zydwtj";
//	}
//
//	/**
//	 * 作业动态数据
//	 * @param week
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("/zydwData")
//	public List zydwData(Xlt_cqjEntity week) {
//
//		Calendar calendar = Calendar.getInstance();
//        calendar.clear();
//        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
//        Date currYearFirst = calendar.getTime();
//        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        String begin_date = f.format(currYearFirst);//一年的开始
//        calendar.clear();
//        calendar.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
//        calendar.roll(Calendar.DAY_OF_YEAR, -1);
//        Date currYearLast = calendar.getTime();
//        String end_date = f.format(currYearLast);//一年的结束
//        week.setRq1(begin_date);
//        week.setRq2(end_date);
//        Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date);// 默认获取当天
//		week.setRq5(today);
//		int unit=week.getId().length()+3;
//		/*
//		 * if(unit==14) unit=11;
//		 */
//		week.setParams(unit + "");
//		//先查出所有单位
//		List<Map> list = jddtglService.selectByParam1(week);
//		//统计数据
//		List<Map> list1 = jddtglService.selectByParam88(week);
//		//年累
//	    List<Map> list2 = jddtglService.selectByParam33(week);
//		for (Map m : list) {
//			m.put("NL", 0);
//			m.put("HJ", 0);
//
//			m.put("DX", 0);
//			m.put("XX", 0);
//			m.put("DY", 0);
//
//			for (Map m1 : list1) {
//				if (m.get("ID").equals(m1.get("UNIT"))) {
//
//					m.put("HJ", m1.get("HJ") == null ? 0 : m1.get("HJ"));
//
//					m.put("DX", m1.get("DX") == null ? 0 : m1.get("DX"));
//					m.put("XX", m1.get("XX") == null ? 0 : m1.get("XX"));
//					m.put("DY", m1.get("DY") == null ? 0 : m1.get("DY"));
//
//
//				}
//			}
//			for (Map m2 : list2) {
//				if (m.get("ID").equals(m2.get("UNIT"))) {
//					m.put("NL", m2.get("NL") == null ? 0 : m2.get("NL"));
//				}
//			}
//		}
//		return list;
//	}
//	//作业动态队伍列表
//	@RequestMapping(value = "zydt_check")
//	public String zydt_check(Model model,String measure_class,String	 id,String rq3,String rq4,int rows) {
//		model.addAttribute("measure_class",measure_class);
//		model.addAttribute("unitid",id);
//		model.addAttribute("beginDate",rq3);
//		model.addAttribute("endDate",rq4);
//		model.addAttribute("rows",rows);
//		return "Construction/dzjd/zydt_check";
//	}
//
//	//作业动态队伍列表数据
//	@RequestMapping("zydt_data")
//	@ResponseBody
//	public Map zydt_data(Pager pager,Xlt_cqjEntity week) {
//		// 设置起始页
//		SetPageUtil.setPage(week, pager);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNo", pager.getPageNo());
//		map.put("totalRows", week.getTotalRows());
//		map.put("rows", jddtglService.selectByParam66(week));
//		return map;
//	}
//
//	/**
//	 * 作业动态详情
//	 * @param entity
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping(value = "/zydtxq_check")
//	public String zydtxq_check(JddtglEntity entity,Model model) {
//		return jddtglService.zydtxq_check(entity,model);
//	}
//
//	//监督记录页面
//	@RequestMapping(value = "/jdjl")
//	public String jdjl(String search,Model model) {
//		search = search.split(",")[0];
//		model.addAttribute("search", search);
//		model.addAttribute("oilfield", "pc0dq");
//		return "Construction/dzjd/jdjl";
//	}
//
//	//监督记录页面数据
//	@RequestMapping(value = "/jdjl_query")
//	@ResponseBody
//	public Map jdjl_query(JddtglEntity entity,String search,Model model,Pager pager) {
//		return jddtglService.jdjl_query(entity, search, pager);
//	}
//
//	@RequestMapping(value = "/jdjl_add")
//	public String jdjl_add(String design_id,String well_common_name,Model model) {
//		return jddtglService.jdjl_add(design_id,well_common_name,model);
//
//	}
//
//	@RequestMapping(value = "/saveJd")
//	public String saveJd(JddtglEntity entity,Model model) {
//		return jddtglService.saveJd(entity,model);
//	}
//
//	@RequestMapping(value = "/jdjl_ll")
//	public String jdjl_ll(String design_id,String well_common_name,Model model) {
//		return jddtglService.jdjl_ll(design_id,well_common_name,model);
//
//	}
//
//	@RequestMapping(value = "/jdjl_edit")
//	public String jdjl_edit(String design_id,String well_common_name,Model model) {
//		return jddtglService.jdjl_edit(design_id,well_common_name,model);
//
//	}
//
//	/**
//	 * 提交数据
//	 * @param entity
//	 */
//	@RequestMapping(value= {"/jdjltj"})
//	@ResponseBody
//	public Map<String,Boolean> jdjltj(JddtglEntity entity) {
//		Map<String,Boolean> map = new HashMap<String, Boolean>();
//		 if(jddtglService.jdjltj(entity)!=0) {
//			 map.put("message", true);
//			 return map;
//		 }else {
//			 map.put("message", false);
//			 return map;
//		 }
//	}
//
//视频截图保存
//@RequestMapping(value = "/uploadFiles")
//@ResponseBody
//public String uploadFiles(JddtglEntity entity,HttpServletRequest request) throws Exception {
//	return jddtglService.uploadFiles(entity,request);
//}
//	@RequestMapping(value = "/jksb")
//	public String jump(Model model) throws IOException {
//		String url = "{\"list\":[{\"name\":\"设备信息\",\"url\":\"../jddtgl/jksbxx\"},"
//				+ "{\"name\":\"设备绑定\",\"url\":\"../jddtgl/jksbbd\"}]}";
//		ObjectMapper objectMapper = new ObjectMapper();
//		JsonNode readTree = objectMapper.readTree(url);
//		model.addAttribute("address", readTree);
//		return "Construction/dzjd/common_tab";
//	}

//	//监控设备信息
//	@RequestMapping(value = "/jksbxx")
//	public String jksb() {
//		return "Construction/dzjd/jksb";
//	}

    @GetMapping(value = "/jksb_query")
    @ApiOperation(value = "监控设备页面列表数据")
    public Map jksb_query(Pager pager) {
        CamEntity entity = new CamEntity();
        return jddtglService.jksb_qyery(entity, pager);
    }

    @PostMapping(value = "/camSave")
    @ApiOperation(value = "监控设备数据保存")
    public Map camSave(@RequestBody CamEntity entity) {
        return jddtglService.camSave(entity);
    }

    @GetMapping(value = "/jksb_edit")
    @ApiOperation(value = "监控设备修改查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "String", required = true)
    })
    public Map jksb_edit(String id) {
        CamEntity entity = new CamEntity();
        entity.setId(id);
        return jddtglService.jksb_edit(entity);
    }


    @PutMapping(value = "/camEdit")
    @ApiOperation(value = "监控设备修改数据保存")
    public Map camEdit(@RequestBody CamEntity entity) {
        return jddtglService.camEdit(entity);
    }


    @DeleteMapping(value = {"/delSb"})
    @ApiOperation(value = "监控设备删除数据保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "String", required = true)
    })
    public Map delSb(String id) {
        CamEntity entity = new CamEntity();
        entity.setId(id);
        return jddtglService.delSb(entity);
    }

    //通道添加
    @GetMapping(value = "/jksbtd_add")
    @ApiOperation(value = "查询通道数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceID", value = "设备id", paramType = "query", dataType = "String", required = true)
    })
    public Map jksbtd_add(String deviceID) {
        CamEntity entity= new CamEntity();
        entity.setDeviceID(deviceID);
        return jddtglService.jksbtd_add(entity);
    }

    @PostMapping(value = "/tdSave")
    @ApiOperation(value = "通道新增保存")
    public Map tdSave(@RequestBody CamEntity entity) {
        return jddtglService.tdSave(entity);
    }

    //
    @PostMapping(value = "/tdEdit")
    @ApiOperation(value = "通道修改保存")
    public Map tdEdit(@RequestBody  CamEntity entity) {
        return jddtglService.tdEdit(entity);
    }


    @GetMapping(value = "/sbdk_query")
    @ApiOperation(value = "监控设备绑定列表数据")
    public Map sbdk_query( Pager pager) {
        CamEntity entity= new CamEntity();

        return jddtglService.sbdk_query(entity, pager);
    }

//    // 监控设备队伍绑定页面
//    @RequestMapping(value = "/jksbtd_bindTm")
//    public String jksbtd_bindTm(CamEntity entity, Model model) {
//        model.addAttribute("entity", entity);
//        return "Construction/dzjd/sbtd_tm";
//    }

    @PostMapping(value = "/tdBindSave")
    @ApiOperation(value = "队伍绑定数据保存")
    public Map tdBindSave(@RequestBody CamEntity entity) {
        return jddtglService.tdBindSave(entity);
    }

    @GetMapping(value = "/jksbtd_editTm")
    @ApiOperation(value = "队伍绑定数据修改查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "channelID", value = "通道号", paramType = "query", dataType = "String", required = true)
    })
    public Map jksbtd_editTm(String channelID) {
        CamEntity entity= new CamEntity();
        entity.setChannelID(channelID);
        return jddtglService.jksbtd_editTm(entity);
    }

    @PutMapping(value = "/jksbtd_saveEd")
    @ApiOperation(value = "队伍绑定修改数据保存")
    public Map jksbtd_saveEd(@RequestBody CamEntity entity) {
        return jddtglService.jksbtd_saveEd(entity);
    }

//    // 井号绑定页面
//    @RequestMapping(value = "/jksbtd_bindJh")
//    public String jksbtd_bindJh(CamEntity entity, Model model) {
//        model.addAttribute("entity", entity);
//        return "Construction/dzjd/sbtd_jh";
//    }

    @GetMapping(value = { "/getjh" })
    @ApiOperation(value = "获取井号(根据施工中井)")
    public Map getJh() {
        CamEntity entity = new CamEntity();
        return jddtglService.selectJh(entity);
    }

    //
    @PostMapping(value = "/jhBindSave")
    @ApiOperation("井号绑定保存")
    public Map jhBindSave(@RequestBody CamEntity entity) {
        return jddtglService.jhBindSave(entity);
    }

//    // 已绑定井号详情页
//    @RequestMapping(value = "/jksbtd_checkJh")
//    public String jksbtd_checkJh(CamEntity entity, Model model) {
//        model.addAttribute("entity", entity);
//        return "Construction/dzjd/check_bindjh";
//    }

    // 已绑定井号详情页数据
    @GetMapping(value = "/check_bindjh")
    @ApiOperation(value = "已绑定井号详情页数据")
    public Map check_bindjh(String channelID,  Pager pager) {
        CamEntity entity= new CamEntity();
        entity.setChannelID(channelID);
        return jddtglService.check_bindjh(entity, pager);
    }

    @DeleteMapping(value = { "/delJh" })
    @ApiOperation(value = "删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bs", value = "唯一标识", paramType = "query", dataType = "String", required = true)
    })
    public Map delJh(String bs ) {
        CamEntity entity = new CamEntity();
        entity.setBs(bs);
        return jddtglService.delJh(entity);
    }


}
