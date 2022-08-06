package com.cyrj.jxzy.service.Constractor;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrj.jxzy.dao.Constractor.BigTextDao;
import com.cyrj.jxzy.entity.Constractor.BigTextEntity;

@Service
public class BigTextServiceImpl implements BigTextService {
	@Autowired
	private BigTextDao dao;
	@Autowired
	private HttpServletRequest request;

	@Override
	public Map  bigTextSave(BigTextEntity entity) {


		
		Map  map = new HashMap();
		map.put("code", 200);
		try {
			String user = request.getHeader("user");
			UserHeaderEntity userEntity = Common.getUserHeader(user);
			entity.setText(entity.getNeirong().getBytes("UTF-8"));
			String oilfield=userEntity.getOilfield();
			entity.setOilfield(oilfield);
			entity.setCreate_user(userEntity.getUser_name());
			List<BigTextEntity> list = dao.listBigText(entity);
			if(list!=null&&list.size()>0){
				dao.updateBigText(entity);
			}else {
				dao.insertBigText(entity);
							
			}
			map.put("msg", "保存成功");
			map.put("data", "1");
		} catch (Exception e) {
			map.put("msg", "出错了，保存失败");
			map.put("data", "0");
			e.printStackTrace();
		}
		
		
		return map;
	}

	@Override
	public Map  bigTextShow(BigTextEntity entity) {

		 Map  map =  new HashMap ();
		map.put("code",200);
		BigTextEntity en = dao.bigTextShow(entity);
		if(en!=null&&en.getText()!=null){
			try {
				String nr=new String(en.getText(),  "UTF-8");
				map.put("msg", "1");
				map.put("data", nr);
			} catch (UnsupportedEncodingException e) {
				map.put("msg", "0");
				map.put("data", "");
				e.printStackTrace();
			}
		}else {
			map.put("msg", "0");
			map.put("data", "");
		}
		return map;
	}

}
