package com.cyrj.jxzy.service.Constractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrj.jxzy.dao.Constractor.HtxxckDao;
import com.cyrj.jxzy.dao.Constractor.PcUnitCuopDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class HtxxckServiceImpl implements HtxxckService{

	@Autowired
	private PcUnitCuopDao pcUnitCuopDao;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HtxxckDao dao;
	
	
	/**
	 * 查询厂级单位下拉列表
	 * @return
	 */
	@Override
	public List<Map<String, String>> unit_select() {
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		PcUnitEntity pcUnitEntity = new PcUnitEntity();
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield=userEntity.getOilfield();
		String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
		String search=userEntity.getSearch();//数据权限
		
		if("2".equals(attribute)){
			pcUnitEntity.setId(search);
		}
		pcUnitEntity.setOilfield(oilfield);
		List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam4(pcUnitEntity);

		for (PcUnitEntity pcUnit : entity_list_PcUnit) {

			Map<String, String> map = new HashMap<String, String>();
			map.put("key", pcUnit.getUnitname());
			map.put("value", pcUnit.getId());

			list.add(map);
		}
		return list;
	}



	@Override
	public List<Map<String, String>> cbs_select(HtxxckEntity entity) {


		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield=userEntity.getOilfield();
		entity.setOilfield(oilfield);
		
			String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
			String search=userEntity.getSearch();//数据权限
			entity.setAttribute(attribute);
			entity.setSearch(search);
			
		List<HtxxckEntity> list_ht = dao.cbs_select(entity);
		
		for(HtxxckEntity ht :list_ht){
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("key", ht.getContractor_name());
			map.put("value", ht.getContractor_id());
			list.add(map);
		}
		
		return list;
	}



	@Override
	public List<Map<String, String>> nf_select() {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		List<HtxxckEntity> li = dao.nf_select();
		
		for(HtxxckEntity he:li){
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("value",he.getEffective_dates());
			map.put("key", he.getEffective_dates());			
			list.add(map);
			
			
		}
		
		return list;
	}



	@Override
	public Map show_list(HtxxckEntity entity, Pager pager) {
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield=userEntity.getOilfield();
		String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
		String search=userEntity.getSearch();//数据权限
		entity.setOilfield(oilfield);
		entity.setAttribute(attribute);
		entity.setSearch(search);
				
		//总记录数
		int totalRows =dao.countHtxxck(entity);
		SetPageUtil.setPage(entity, pager);
		List<HtxxckEntity> list = dao.listHtxxck(entity);
		
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("totalRows", totalRows);
    	map.put("rows", list);

    	Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
    	return resultMap;
	}

@Override
public Map show_list_cj(HtxxckEntity entity, Pager pager) {

	String user = request.getHeader("user");
	UserHeaderEntity userEntity = Common.getUserHeader(user);

	String oilfield=userEntity.getOilfield();
	String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
	String search=userEntity.getSearch();//数据权限
	entity.setOilfield(oilfield);
	entity.setAttribute(attribute);
	entity.setSearch(search);
	//总记录数
	int totalRows =dao.count_Audit_cj(entity);
	SetPageUtil.setPage(entity, pager);
	List<HtxxckEntity> list = dao.list_Audit_cj(entity);
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("totalRows", totalRows);
	map.put("rows", list);
	Map resultMap= new HashMap();
	resultMap.put("code",200);
	resultMap.put("msg","成功");
	resultMap.put("data",map);
	return resultMap;
}


	@Override
	public Map term(ContractTeamEntity entity) {
		List<ContractTeamEntity> list = dao.listTerm(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return  resultMap;
	}



	@Override
	public Map auditSave(HtxxckEntity entity) {

		Map map = new HashMap();
		map.put("code", 200);
		try{
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			String userid=userEntity.getUser_name();
			entity.setAuditperson(userid);
			dao.updateAuditSave(entity);
			
			map.put("data", "1");
			map.put("msg", "成功");
		}catch(Exception e){
			map.put("data", "0");
			map.put("msg", "出错了，请重新操作");
			e.printStackTrace();
		}
		return map;
	}



	@Override
	public Map  show_list_Chang(HtxxckEntity entity, Pager pager) {


		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield=userEntity.getOilfield();
		String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
		String search=userEntity.getSearch();//数据权限
		entity.setOilfield(oilfield);
		entity.setAttribute(attribute);
		entity.setSearch(search);
		
	
		//总记录数
		int totalRows =dao.countHtxxckChang(entity);
		SetPageUtil.setPage(entity, pager);
		List<HtxxckEntity> list = dao.listHtxxckChang(entity);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("totalRows", totalRows);
    	map.put("rows", list);
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}



	@Override
	public Map  show_list_audit(HtxxckEntity entity, Pager pager) {

		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield=userEntity.getOilfield();
		String attribute=userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
		String search=userEntity.getSearch();//数据权限
		entity.setOilfield(oilfield);
		entity.setAttribute(attribute);
		entity.setSearch(search);
		
		if(StringUtils.isBlank(entity.getWhether_to_perform())){
			entity.setWhether_to_perform("否");
		}
    	
		//总记录数
		int totalRows =dao.countHtxxck(entity);
		SetPageUtil.setPage(entity, pager);
		List<HtxxckEntity> list = dao.listHtxxck(entity);
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("totalRows", totalRows);
    	map.put("rows", list);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

}
