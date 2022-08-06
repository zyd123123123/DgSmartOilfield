package com.cyrj.jxzy.service.Constractor;

import java.text.SimpleDateFormat;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.dao.Constractor.FjglDao;
import com.cyrj.jxzy.dao.Constractor.HtxxlrDao;
import com.cyrj.jxzy.dao.Constractor.PcUnitCuopDao;
import com.cyrj.jxzy.dao.Constractor.QylrDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.FjglEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.util.Common;
import com.cyrj.jxzy.util.SetPageUtil;


@Service
public class QylrServiceImpl implements QylrServiceI {

	@Autowired
	private PcUnitCuopDao pcUnitCuopDao;
	@Autowired
	private QylrDao qylrDao;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private FjglDao fjglDao;


	@Override
	public Map<String, Object> show_list(String dwlbid,String unitname,String dwmc, Pager pager) {
		QylrEntity entity= new QylrEntity();
		entity.setDwlbid(dwlbid);
		entity.setUnitname(unitname);
		entity.setDwmc(dwmc);
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setOilfield(userEntity.getOilfield());
		String attribute = userEntity.getAttribute();
		String search = userEntity.getSearch();

		List<QylrEntity> list = new ArrayList<QylrEntity>();
		//总记录数
		SetPageUtil.setPage(entity, pager);
		int totalRows;
		if(attribute.equals("1")){
			//查询
			entity.setDwdm(search);
	        list = qylrDao.selectByParam1(entity);
	        totalRows =qylrDao.selectByParam2(entity);
		}else{

			//查询
	        list = qylrDao.selectByParam11(entity);
	        totalRows =qylrDao.selectByParam22(entity);
		}
		
		//查询
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("totalRows", totalRows);
    	map.put("rows", list);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 200);
		resultMap.put("msg", "成功");
		resultMap.put("data", map);
    	return resultMap;
		    	
	}
	@Override
	@Transactional
	public Map save(QylrEntity entity) {

		Map  map  =  new HashMap();
		map.put("code", 200);
		String  data="1";
		String msg="保存成功。";
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setOilfield(userEntity.getOilfield());
		entity.setInput_person(userEntity.getUser_name());
		try {
			//队伍资质
			qylrDao.qylrInsert(entity);
		}catch (Exception e) {
			data="0";
			msg="出错了，保存失败。";
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}

		map.put("data", data);
		map.put("msg", msg);
		return map;

	}
	@Override
	@Transactional
	public Map save_update(QylrEntity entity) {
		Map  map  =  new HashMap();
		map.put("code", 200);
		String data="1";
		String msg="";
		
		//获取当前操作人员真实姓名
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setInput_person(userEntity.getUser_name());
		try {
			//删除当前所修改数据
			qylrDao.deleteParam(entity);
			entity.setOilfield(userEntity.getOilfield());
			//修改数据
			  qylrDao.qylrInsert(entity);
			msg="修改成功。";
		}catch (Exception e) {
			data="0";
			msg="出错了，修改失败。";
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
		}
		
		map.put("data", data);
		map.put("msg", msg);
		return map;
	}

	@Override
	public Map selecltOne(String dwdm ) {
		QylrEntity entity=new QylrEntity();
		entity.setDwdm(dwdm);
		List<QylrEntity> list = qylrDao.selectZz1(entity);
		if(list.size()>0){
			entity=list.get(0);
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",entity);
		return resultMap;
	}


	@Override
	public Map unit_select1() {

		PcUnitEntity pcUnitEntity= new PcUnitEntity();

		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		pcUnitEntity.setOilfield(userEntity.getOilfield());
		List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam5(pcUnitEntity);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for(PcUnitEntity pcUnit:entity_list_PcUnit){
			Map<String,String> map= new HashMap<String, String>();
			map.put("key",pcUnit.getUnitname() ); //key存名字
			map.put("value",pcUnit.getId() );     //value存编号
			list.add(map);
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",list);
		return resultMap;
	}

	@Override
	public Map unit_select(String id) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		FjglEntity fjgl = new FjglEntity();
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		fjgl.setOilfield(userEntity.getOilfield());
		fjgl.setParent_id(id);
		List<FjglEntity> entity_list=fjglDao.setId_ReturnFj(fjgl);
		for(FjglEntity entity:entity_list){

			Map<String,String> map= new HashMap<String, String>();
			map.put("key",entity.getAnnex_name());
			map.put("value",entity.getId());

			list.add(map);
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",list);
		return resultMap;
	}
	/**
	 * 组织机构校验
	 *
	 */
	@Override
	public Map check(String dwdm) {
		QylrEntity entity= new QylrEntity();
		entity.setDwdm(dwdm);
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setOilfield(userEntity.getOilfield());

		int rows = qylrDao.count(entity);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data", rows);
		return map;
	}
}
