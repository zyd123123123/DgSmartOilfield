package com.cyrj.jxzy.service.Constractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrj.jxzy.dao.Constractor.SbtjDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.FssbEntity;
import com.cyrj.jxzy.entity.Constractor.SbtjEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class SbtjServiceImpl implements SbtjService{
	
	@Autowired
	private SbtjDao dao;
	@Autowired
	private HttpServletRequest request;
	@Override
	public Map<String, Object> showList(SbtjEntity entity, Pager pager) {

		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String oilfield = userEntity.getOilfield();
		entity.setOilfield(oilfield);
//		int totalRows=dao.countShowList(entity);
		
		SetPageUtil.setPage(entity, pager);
		List<SbtjEntity> list = dao.listShowList(entity);
    	Map<String, Object> map = new HashMap<String, Object>();
//    	map.put("totalRows", totalRows);
    	map.put("rows", list);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("code", 200);
		resultMap.put("msg", "成功");
		resultMap.put("data", map);
		return resultMap;
	}

}
