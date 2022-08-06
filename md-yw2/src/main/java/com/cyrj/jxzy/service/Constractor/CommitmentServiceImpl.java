package com.cyrj.jxzy.service.Constractor; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.cyrj.jxzy.dao.Constractor.CommitmentDao;
import com.cyrj.jxzy.entity.Constractor.CnsflbEntity;

import javax.servlet.http.HttpServletRequest;


@Service
public class CommitmentServiceImpl implements CommitmentServiceI {

@Autowired
private CommitmentDao dao;
	@Autowired
	private HttpServletRequest request;


@Override
public List<CnsflbEntity> cnsflbSelect() {

	CnsflbEntity entity= new CnsflbEntity();
	String user = request.getHeader("user");
	UserHeaderEntity userEntity = Common.getUserHeader(user);
	entity.setOilfield(userEntity.getOilfield());
	
	return dao.cnsflbSelect(entity);
}

@Override
@Transactional
public Map  save(CnsflbEntity entity) {
	
	Map  map= new HashMap ();
	map.put("code", 200);
	map.put("msg", "保存成功。");
	map.put("data", "1");
	try{
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		entity.setOilfield(userEntity.getOilfield());
		dao.cnsflbDelete(entity);
		dao.cnsflbInsert(entity);
		
	}catch(Exception e){
		e.printStackTrace();
		 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		map.put("data", "0");
		map.put("msg", "保存失败。");
	}
	return map;
} 



}
