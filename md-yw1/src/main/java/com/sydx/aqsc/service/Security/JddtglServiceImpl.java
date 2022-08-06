package com.sydx.aqsc.service.Security;

import java.math.BigDecimal;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import com.sydx.aqsc.dao.Security.JddtglDao;
import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.UserHeaderEntity;
import com.sydx.aqsc.entity.Security.CamEntity;
import com.sydx.aqsc.entity.Security.JddtglEntity;
import com.sydx.aqsc.util.Common;
import com.sydx.aqsc.util.HanZiToPinYin;
import com.sydx.aqsc.util.SetPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public class JddtglServiceImpl implements JddtglServiceI {

	@Autowired
	private JddtglDao jddtDao;
	@Autowired
	private HttpServletRequest request;
	
//	@Autowired
//	private JdryglDao jdryglDao;
	
//	@Override
//	public Map sgjzydt_query(JddtglEntity entity, String search, Pager pager) {
//		int totalRows = jddtDao.count_jddtcx(entity);// 总条数
//		// 设置起始页
//		SetPageUtil.setPage(entity, pager);
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);// 数据详情
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNo", pager.getPageNo());
//		map.put("totalRows", totalRows);
//		map.put("rows", entity_list);
//		return map;
//	}
//
//	@Override
//	public String sgjxq_check(JddtglEntity entity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);//
//		List<JddtglEntity> entity_list_xq = jddtDao.jddtxq_query(entity);//详情
//		if(entity_list.size()>0) {
//			entity = entity_list.get(0);
//		}
//		int i = 0;
//		for(JddtglEntity a: entity_list_xq) {
//			a.setXh(++i);
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list_xq);
//		return "Construction/dzjd/sgjxq_check";
//	}
//
//	@Override
//	public List<Map> selectByParam1(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		 return jddtDao.selectByParam1(week);
//	}
//
//	@Override
//	public List<Map> selectByParam8(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam8(week);
//	}
//
//	@Override
//	public List<Map> selectByParam3(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam3(week);
//	}
//
//	@Override
//	public Object selectByParam6(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam6(week);
//	}
//
//	@Override
//	public String sgjjddt_check(JddtglEntity entity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);// 根据design_id查出数据基本信息
//		JdryglEntity jdryglEntity = new JdryglEntity();
//		jdryglEntity.setUser_id(entity.getMonitor_id());
//		List<JdryglEntity> jdrygl_query = jdryglDao.jdrygl_query(jdryglEntity);
//		JddtglEntity jb = new JddtglEntity();
//		if(entity_list.size()>0 && entity_list!=null) {
//			jb = entity_list.get(0);
//		}
//		if(jdrygl_query.size()>0 && jdrygl_query!=null) {
//			jb.setTrue_name(jdrygl_query.get(0).getTrue_name());
//			jb.setMonitor_id(jdrygl_query.get(0).getMonitor_id());
//		}
//
//		List<JddtglEntity> entity_list_bc = jddtDao.jddtbc_query(entity);// 查出监督动态信息
//		model.addAttribute("entity", jb);
//		model.addAttribute("entity_list", entity_list_bc);
//		return "Construction/dzjd/sgjzydt_check";
//	}
//
//	@Override
//	public String saveJddtxx(JddtglEntity entity, Model model) {
//		entity.setUpdate_userid(entity.getMonitor_id());
//		int num = jddtDao.insertJddtxx(entity);
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);// 根据design_id查出数据基本信息
//		JddtglEntity jb = new JddtglEntity();
//		if(entity_list.size()>0 && entity_list!=null) {
//			jb = entity_list.get(0);
//			jb.setMonitor_id(entity.getMonitor_id());
//			jb.setTrue_name(entity.getTrue_name());
//		}
//		List<JddtglEntity> entity_list_bc = jddtDao.jddtbc_query(entity);// 查出监督动态信息
//		model.addAttribute("entity", jb);
//		model.addAttribute("entity_list", entity_list_bc);
//		return "Construction/dzjd/sgjzydt_check";
//	}
//
//	@Override
//	public String jdlyb(JddthdEntity entity,JddtglEntity jddtglEntity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(jddtglEntity);// 根据design_id查出数据基本信息
//		if(entity_list.size()>0 && entity_list!=null) {
//			jddtglEntity = entity_list.get(0);
//			jddtglEntity.setTrue_name(entity.getMessage_truename());
//			jddtglEntity.setMonitor_id(entity.getMessage_userid());
//		}
//		List<JddthdEntity> entity_list_lyb = jddtDao.jddtlyb_query(entity);// 查出监督动态信息
//		for(JddthdEntity a:entity_list_lyb) {
//			if(a.getReply_truename()==null || a.getReply_truename()=="") {
//				a.setReply_truename(entity.getMessage_truename());
//			}
//		}
//		model.addAttribute("entity", jddtglEntity);
//		model.addAttribute("entity_list", entity_list_lyb);
//		return "Construction/dzjd/jddthd_lyb";
//	}
//
//	@Override
//	public String saveJddtly(JddthdEntity entity, JddtglEntity jddtglEntity, Model model) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
//		String date = df.format(new Date());
//		entity.setMessage_id("JDLY_"+date);//生成一个留言板id
//		entity.setReply_op("0");
//		int num = jddtDao.insertJddtly(entity);
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(jddtglEntity);// 根据design_id查出数据基本信息
//		if(entity_list.size()>0 && entity_list!=null) {
//			jddtglEntity = entity_list.get(0);
//			jddtglEntity.setTrue_name(entity.getMessage_truename());
//			jddtglEntity.setMonitor_id(entity.getMessage_userid());
//		}
//		List<JddthdEntity> entity_list_lyb = jddtDao.jddtlyb_query(entity);// 查出监督动态信息
//		for(JddthdEntity a:entity_list_lyb) {
//			if(a.getReply_truename()==null || a.getReply_truename()=="") {
//				a.setReply_truename(entity.getMessage_truename());
//			}
//		}
//		model.addAttribute("entity", jddtglEntity);
//		model.addAttribute("entity_list", entity_list_lyb);
//		return "Construction/dzjd/jddthd_lyb";
//	}
//
//	@Override
//	public String updately(JddthdEntity entity, JddtglEntity jddtglEntity, Model model) {
//		entity.setReply_op("1");
//		int num = jddtDao.updately(entity);
//		return num+"";
//	}
//
//	@Override
//	public String fjgxsq(FjgxEntity fjgxEntity, JddtglEntity jddtglEntity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(jddtglEntity);// 根据design_id查出数据基本信息
//		if(entity_list.size()>0 && entity_list!=null) {
//			jddtglEntity = entity_list.get(0);
//		}
//		JddthdEntity jddthdEntity = new JddthdEntity();
//		jddthdEntity.setDesign_id(jddtglEntity.getDesign_id());
//		List<JddthdEntity> entity_list_fjgx = jddtDao.fjgx_query(jddthdEntity);//附件工序申请数据
//		for(JddthdEntity a :entity_list_fjgx) {
//			a.setOilfield(jddtglEntity.getOilfield());
//		}
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date);// 默认获取当天
//		model.addAttribute("date", today);
//		model.addAttribute("entity", jddtglEntity);
//		model.addAttribute("entity_list", entity_list_fjgx);
//		return "Construction/dzjd/fjgx_add";
//	}
//
//	@Override
//	public String saveFjgx(JddthdEntity entity, JddtglEntity jddtglEntity, Model model) {
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
//		String date = df.format(new Date());
//		entity.setStep_id("FJGX_"+date);//生成一个留言板id
//		entity.setAudit_code("1");
//		int num = jddtDao.insertFjgx(entity);
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(jddtglEntity);// 根据design_id查出数据基本信息
//		JddtglEntity jb = new JddtglEntity();
//		if(entity_list.size()>0 && entity_list!=null) {
//			jb = entity_list.get(0);
//			jb.setDesign_id(jddtglEntity.getDesign_id());
//			jb.setOilfield(jddtglEntity.getOilfield());
//		}
//		List<JddthdEntity> entity_list_fjgx = jddtDao.fjgx_query(entity);//附件工序申请数据
//		for(JddthdEntity a :entity_list_fjgx) {
//			a.setOilfield(jddtglEntity.getOilfield());
//		}
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date1);// 默认获取当天
//		model.addAttribute("date", today);
//		model.addAttribute("entity", jddtglEntity);
//		model.addAttribute("entity_list", entity_list_fjgx);
//		return "Construction/dzjd/fjgx_add";
//	}
//
//	@Override
//	public String updateFjgx(JddthdEntity entity, JddtglEntity jddtglEntity, Model model) {
//		entity.setAudit_code("1");
//		int num = jddtDao.updateFjgx(entity);
//		return num+"";
//	}
//
//	@Override
//	public String fjgxsh(FjgxEntity fjgxEntity, JddtglEntity entity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);// 根据design_id查出数据基本信息
//		if(entity_list.size()>0 && entity_list!=null) {
//			entity = entity_list.get(0);
//		}
//		JddthdEntity jddthdEntity = new JddthdEntity();
//		jddthdEntity.setDesign_id(entity.getDesign_id());
//		jddthdEntity.setAudit_code("1");
//		List<JddthdEntity> entity_list_fjgx = jddtDao.fjgx_query(jddthdEntity);//附件工序申请数据
//		for(JddthdEntity a :entity_list_fjgx) {
//			a.setOilfield(entity.getOilfield());
//		}
//		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		Date date1 = new Date();// 创建一个时间对象，获取到当前的时间
//		String today = f.format(date1);// 默认获取当天
//		model.addAttribute("date", today);
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list_fjgx);
//		return "Construction/dzjd/fjgx_sh";
//	}
//
//	@Override
//	public String updateFjgxSh(JddthdEntity entity, JddtglEntity jddtglEntity, Model model,String bs) {
//		entity.setAudit_code(bs);
//		int num = jddtDao.updateFjgxSh(entity);
//		return num+"";
//	}
//
//	@Override
//	public List<Map> selectByParam10(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam10(week);
//	}
//
//	@Override
//	public Object selectByParam11(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam11(week);
//	}

//	@Override
//	public String jdtjxq_check(JddtglEntity entity, Model model) {
//		List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);//
//		List<JddtglEntity> entity_list_xq = jddtDao.jddtxq_query(entity);//详情
//		List<JddtglEntity> entity_list_jdtj = jddtDao.jdtj_query(entity);//详情
//		if(entity_list.size()>0) {
//			entity = entity_list.get(0);
//		}
//		int i = 0;
//		for(JddtglEntity a: entity_list_xq) {
//			a.setXh(++i);
//		}
//		int ii = 0;
//		for(JddtglEntity a: entity_list_jdtj) {
//			a.setXh(++ii);
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list_xq);
//		model.addAttribute("entity_list_tj", entity_list_jdtj);
//		return "Construction/dzjd/jddtxq_check";
//	}
//
//	@Override
//	public List<Map> selectByParam88(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam88(week);
//	}
//
//	@Override
//	public Object selectByParam66(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam66(week);
//	}

//	@Override
//	public String zydtxq_check(JddtglEntity entity, Model model) {
//		//List<JddtglEntity> entity_list = jddtDao.jddtcx_query(entity);//
//		List<JddtglEntity> entity_list_xq = jddtDao.zydtxq_query(entity);//详情
//		if(entity_list_xq.size()>0) {
//			entity = entity_list_xq.get(0);
//			entity.setSgdw(entity.getConstruction_name()+"."+entity.getTeam_name());
//			entity.setScdw(entity.getCyc()+"."+entity.getZyq()+"."+entity.getCyd());
//		}
//		int i = 0;
//		for(JddtglEntity a: entity_list_xq) {
//			a.setXh(++i);
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list_xq);
//		return "Construction/dzjd/zydtxq_check";
//	}
//
//	@Override
//	public List<Map> selectByParam33(Xlt_cqjEntity week) {
//		// TODO Auto-generated method stub
//		return jddtDao.selectByParam33(week);
//	}
//
//	@Override
//	public Map jdjl_query(JddtglEntity entity, String search, Pager pager) {
//		int totalRows = jddtDao.count_jdjlcx(entity);// 总条数
//		// 设置起始页
//		SetPageUtil.setPage(entity, pager);
//		List<JddtglEntity> entity_list = jddtDao.jdjlcx_query(entity);// 数据详情
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pageNo", pager.getPageNo());
//		map.put("totalRows", totalRows);
//		map.put("rows", entity_list);
//		return map;
//	}

//	@Override
//	public String jdjl_add(String design_id, String well_common_name, Model model) {
//		JddtglEntity entity = new JddtglEntity();
//		entity.setDesign_id(design_id);
//		List<JddtglEntity> gxxq_list = jddtDao.gxxq_query(entity);// 数据详情
//		List<JddtglEntity> jdjl_list = jddtDao.jdjl_query(entity);// 数据详情
//		// TODO Auto-generated method stub
//		model.addAttribute("gxxq_list", gxxq_list);
//		model.addAttribute("jdjl_list", jdjl_list);
//		model.addAttribute("design_id", design_id);
//		model.addAttribute("well_common_name", well_common_name);
//		return "Construction/dzjd/jdjl_add";
//	}
//
//	@Override
//	public String saveJd(JddtglEntity entity,Model model) {
//		jddtDao.delJd(entity);
//		int i = 0;
//		for(JddtglEntity a:entity.getEntity_list()) {
//			a.setDesign_id(entity.getDesign_id());
//			a.setSeq_no(++i);
//			a.setData_no(0);
//			jddtDao.insertJd(a);
//		}
//		model.addAttribute("message", "保存成功，关闭弹窗");
//		return "Construction/dzjd/tellMessage";
//	}
//
//	@Override
//	public String jdjl_ll(String design_id, String well_common_name, Model model) {
//		JddtglEntity entity = new JddtglEntity();
//		entity.setDesign_id(design_id);
//		List<JddtglEntity> jdxq_list = jddtDao.jdjlcx_query(entity);
//		List<JddtglEntity> jdjl_list = jddtDao.jdjl_query1(entity);
//		if(jdxq_list.size()>0) {
//			entity = jdxq_list.get(0);
//			entity.setScdw(entity.getCyc()+'.'+entity.getZyq()+'.'+entity.getCyd());
//			entity.setSgdw(entity.getConstruction_name()+'.'+entity.getTeam_name());
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", jdjl_list);
//		return "Construction/dzjd/jdjl_ll";
//	}
//
//	@Override
//	public String jdjl_edit(String design_id, String well_common_name, Model model) {
//		JddtglEntity entity = new JddtglEntity();
//		entity.setDesign_id(design_id);
//		List<JddtglEntity> gxxq_list = jddtDao.jdjl_query1(entity);// 数据详情
//		List<JddtglEntity> jdjl_list = jddtDao.jdjl_query(entity);// 数据详情
//		// TODO Auto-generated method stub
//		model.addAttribute("gxxq_list", gxxq_list);
//		model.addAttribute("jdjl_list", jdjl_list);
//		model.addAttribute("design_id", design_id);
//		model.addAttribute("well_common_name", well_common_name);
//		return "Construction/dzjd/jdjl_edit";
//	}

//	@Override
//	public String uploadFiles(JddtglEntity entity,HttpServletRequest request) throws Exception {
//		// TODO Auto-generated method stub
//		Base64 base64 = new Base64();
//		for(JddtglEntity a:entity.getEntity_list()) {
//			String src = a.getPic().replace("data:image/png;base64,", "");
//			byte[] b = base64.decodeBase64(src);
//			for (int i = 0; i < b.length; ++i) {
//				if (b[i] < 0) {// 调整异常数据
//					b[i] += 256;
//				}
//			}
//			UUID uuid = UUID.randomUUID();
//			//String savePath = "Z:\\pc0cq" + File.separatorChar + "cqjxzy" + File.separatorChar + "uploads"
//			//+ File.separatorChar + "products" + File.separatorChar;
//			String savePath = "E:\\upload" + File.separatorChar
//					+ "products" + File.separatorChar;
//			String path = savePath +entity.getDesign_id()+"_"+ a.getTime() + ".jpg";
//			String saveUrl = request.getContextPath() + "\\loadImage\\image\\" +entity.getDesign_id()+"_"+ a.getTime() + ".jpg";
//			//designTextEntity.setText(designTextEntity.getText().replace(srcList.get(j), saveUrl));
//			Date format1 = null;
//			format1 = new SimpleDateFormat("yyyyMMddHHmmss").parse(a.getTime());
//			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(format1);//当前图片截图时间 有毫秒偏差
//			a.setTime(time);
//			a.setDesign_id(entity.getDesign_id());
//			a.setText(a.getMs());
//			a.setPic_url(saveUrl);
//			jddtDao.insertPic(a);
//			OutputStream out = new FileOutputStream(path);
//			out.write(b);
//			out.flush();
//			out.close();
//		}
//
//		return "true";
//	}
	@Override
	public int jdjltj(JddtglEntity entity) {
		entity.setData_no(1);
		int num = jddtDao.updateJdjl(entity);
		return num;
	}

	@Override
	public Map jksb_qyery(CamEntity entity, Pager pager) {
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setDeviceVhost(userEntity.getOilfield());
		int totalRows = jddtDao.count_jksb(entity);// 总条数
		// 设置起始页
		SetPageUtil.setPage(entity, pager);
		List<CamEntity> entity_list = jddtDao.jksb_query(entity);// 数据详情
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRows", totalRows);
		map.put("rows", entity_list);
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@Override
	public Map camSave(CamEntity entity) {
		Map map = new HashMap();
		map.put("code",200);

		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String oilfield = userEntity.getOilfield();
			String userid =userEntity.getUser_name();
			String truename = userEntity.getReal_name();
			int num  = 0;
			BigDecimal start = new BigDecimal("34020000001110000000");//初始
			BigDecimal max = new BigDecimal("0");
			CamEntity entity1 = jddtDao.checkMaxId(entity);
			if(entity1!=null) {
				max = new BigDecimal(entity1.getDeviceID());
			}
			for(CamEntity a :entity.getEntityList()) {
				UUID uuid = UUID.randomUUID();
				a.setUnitid(entity.getUnitid());
				a.setDeviceVhost(oilfield);
				a.setId(uuid.toString());
				a.setUpdateuser(userid);
				if(entity1!=null) {
					a.setDeviceID(max.add(new BigDecimal("1")).toString());
					max = max.add(new BigDecimal("1"));
				}else {
					a.setDeviceID(start.add(new BigDecimal("1")).toString());
					start = start.add(new BigDecimal("1"));
				}
				num += jddtDao.updateJksb(a);
			}
			map.put("msg","成功");
			map.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			map.put("msg","出错了，请重新保存");
			map.put("data","0");
		}
		return map;
	}


	@Override
	public Map jksb_edit(CamEntity entity) {
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setDeviceVhost(userEntity.getOilfield());
		List<CamEntity> jksb_query = jddtDao.jksb_query(entity);
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",jksb_query);
		return resultMap;
	}

	@Override
	public Map camEdit(CamEntity entity) {
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String userid =userEntity.getUser_name();
			entity.setUpdateuser(userid);
			jddtDao.updateSb(entity);

			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新保存");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map delSb(CamEntity entity) {
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {
			jddtDao.delSb(entity);
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map jksbtd_add(CamEntity entity) {

		List<CamEntity> jksbtd_query =  jddtDao.jksbtd_query(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity_list", jksbtd_query);
		map.put("deviceID", entity.getDeviceID());

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@Override
	public Map tdSave(CamEntity entity) {
		Map resultMap= new HashMap();
		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String userid = userEntity.getUser_name();
			int num  = 0;
			BigDecimal start = new BigDecimal("34020000001320000000");//初始
			BigDecimal max = new BigDecimal("0");
			CamEntity entity1 = jddtDao.checkMaxtdId(entity);
			if(entity1!=null) {
				max = new BigDecimal(entity1.getChannelID());
			}
			for(CamEntity a :entity.getEntityList()) {
				a.setDeviceID(entity.getDeviceID());
				UUID uuid = UUID.randomUUID();
				a.setDeviceVhost(userEntity.getOilfield());
				a.setUpdateuser(userid);
				if(entity1!=null) {

					a.setChannelID(max.add(new BigDecimal("1")).toString());
					max = max.add(new BigDecimal("1"));
				}else {
					a.setChannelID(start.add(new BigDecimal("1")).toString());
					start = start.add(new BigDecimal("1"));
				}
				num += jddtDao.insertJksbtd(a);
			}
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}

		return resultMap;
	}

	@Override
	public Map tdEdit(CamEntity entity) {

		Map resultMap= new HashMap();
		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String userid = userEntity.getUser_name();
			int num  = 0;
			for(CamEntity a :entity.getEntityList()) {
				a.setUpdateuser(userid);
				num += jddtDao.updateJksbtd(a);
			}
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map sbdk_query(CamEntity entity, Pager pager) {
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setDeviceVhost(userEntity.getOilfield());
		int totalRows = jddtDao.count_sbtd(entity);// 总条数
		// 设置起始页
		SetPageUtil.setPage(entity, pager);
		List<CamEntity> entity_list = jddtDao.sbtd_query(entity);// 数据详情
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRows", totalRows);
		map.put("rows", entity_list);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@Override
	public Map tdBindSave(CamEntity entity) {
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String oilfield = userEntity.getOilfield();
			entity.setDeviceVhost(oilfield);
			UUID uuid = UUID.randomUUID();
			entity.setBs(uuid.toString());
			entity.setUpdateuser(userEntity.getUser_name());
			 jddtDao.tdBindSave(entity);
			resultMap.put("msg","成功");
			resultMap.put("data","1");

		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map jksbtd_editTm(CamEntity entity) {

		List<CamEntity> entity_list = jddtDao.td_bind_query(entity);// 数据详情
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",entity_list);
		return resultMap;
	}

	@Override
	public Map jksbtd_saveEd(CamEntity entity) {
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {
			for(CamEntity a :entity.getEntityList()) {
				jddtDao.updateTeam(a);
			}
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map selectJh(CamEntity entity) {
		List<CamEntity> entity_list = jddtDao.selectJh(entity);//暂时取自已开工
		List list = new ArrayList();
		for (int i = 0; i < entity_list.size(); i++) {
			HashMap<String, String> e = new HashMap<String, String>();
			e.put("key", entity_list.get(i).getWell_common_name());
			e.put("value", entity_list.get(i).getWell_id());// 取出井号，为凑井id
			e.put("suggest", entity_list.get(i).getWell_common_name() + "|" + HanZiToPinYin.toPinYin(entity_list.get(i).getWell_common_name()));
			list.add(e);
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",list);
		return resultMap;
	}

	@Override
	public Map jhBindSave(CamEntity entity) {
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {

			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String oilfield = userEntity.getOilfield();
			UUID uuid = UUID.randomUUID();
			entity.setBs(uuid.toString());
			 jddtDao.tdBindSave(entity);
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}

	@Override
	public Map check_bindjh(CamEntity entity, Pager pager) {
		int totalRows = jddtDao.count_bdjh(entity);// 总条数
		// 设置起始页
		SetPageUtil.setPage(entity, pager);
		List<CamEntity> entity_list = jddtDao.bdjh_query(entity);// 数据详情
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRows", totalRows);
		map.put("rows", entity_list);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@Override
	public Map delJh(CamEntity entity) {

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		try {
			jddtDao.delJh(entity);
			resultMap.put("msg","成功");
			resultMap.put("data","1");
		}catch (Exception e){
			e.printStackTrace();
			resultMap.put("msg","出错了，请重新操作");
			resultMap.put("data","0");
		}
		return resultMap;
	}



}
