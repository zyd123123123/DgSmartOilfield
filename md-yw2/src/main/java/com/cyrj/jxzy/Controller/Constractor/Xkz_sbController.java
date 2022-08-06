package com.cyrj.jxzy.Controller.Constractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;
import com.cyrj.jxzy.service.Constractor.Xkz_sbService;

@RestController
@RequestMapping("/xkz_sb")
@Api(tags = "【设备管理】许可证设备绑定")
public class Xkz_sbController {

	@Autowired
	private Xkz_sbService service;
	
	@GetMapping("/showView")
	@ApiOperation(value = "队伍绑定设备记录",response = Xkz_sbEntity.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true)
	})
	public Map Xkzsb(String dwdm,String termid){
		Xkz_sbEntity entity= new Xkz_sbEntity();
		entity.setDwdm(dwdm);
		entity.setTermid(termid);

		Map map= new HashMap();
		map.put("entity", entity);
		map.put("entity1", entity);
		map.put("entity2", entity);
		map.put("entity3", entity);
		map.put("entity4", entity);
		
		if(StringUtils.isNotBlank(entity.getTermid())){			
			List<Xkz_sbEntity> li = service.showView(entity);			
			if(li!=null&&li.size()>0&&li.get(0)!=null){								
				for(Xkz_sbEntity xkz:li){					
					if("防喷器".equals(xkz.getSbmc())){
						map.put("entity1", xkz);
					}else if("环保装置".equals(xkz.getSbmc())){
						map.put("entity2", xkz);
					}else if("水泥车".equals(xkz.getSbmc())){
						map.put("entity3", xkz);
					}else if("罐车".equals(xkz.getSbmc())){
						map.put("entity4",xkz);
					}												
				}						
			}			
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}
	

	@GetMapping("/select")
	@ApiOperation(value = "设备下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "sbmc", value = "设备名称", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "tab", value = "1是井控设备，2是环保设备，3是附属设备", paramType = "query", dataType = "String",required = true),
	})
	public Map select(String dwdm,String sbmc,String tab){
		Xkz_sbEntity entity= new Xkz_sbEntity();
		entity.setDwdm(dwdm);
		entity.setSbmc(sbmc);
		entity.setTab(tab);
		List<Xkz_sbEntity> entity_list = service.select(entity);
		List<Map<String,String>> list=  new ArrayList<Map<String,String>>();
		if(entity_list!=null&&entity_list.size()>0){
			for(Xkz_sbEntity xkz:entity_list){
				Map<String,String> map= new HashMap<String, String>();
				map.put("key",xkz.getSbbh() ); //key存名字
				map.put("value",xkz.getSbid() );     //value存编号
			   list.add(map);
			}
		}
		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",list);
		return resultMap;
	}
	

	@PostMapping("/bangding_save")
	@ApiOperation(value = "设备绑定保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "sbmc", value = "设备名称", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "sbid", value = "设备id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "tab", value = "1是井控设备，2是环保设备，3是附属设备", paramType = "query", dataType = "String",required = true)
	})
	public Map bangding_save(String dwdm,String termid,String sbmc,String sbid,String tab){

		Xkz_sbEntity entity = new Xkz_sbEntity();
		entity.setDwdm(dwdm);
		entity.setTermid(termid);
		entity.setSbmc(sbmc);
		entity.setSbid(sbid);
		entity.setTab(tab);
		return service.bangding_save(entity);	
	}
	
}
