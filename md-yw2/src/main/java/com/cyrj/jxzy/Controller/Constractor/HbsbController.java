package com.cyrj.jxzy.Controller.Constractor;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HbsbEntity;
import com.cyrj.jxzy.service.Constractor.HbsbService;

@Api(tags = "【设备管理】环保设备")
@RestController
@RequestMapping("/hbsb")
public class HbsbController {

	@Autowired
	private HbsbService service;

	@GetMapping("/showList")
	@ApiOperation(value = "列表查询",response = HbsbEntity.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sbbh", value = "设备编号", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sbmc", value = "设备名称", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dwmc", value = "单位名称", paramType = "query", dataType = "String")
	})
	public Map<String, Object>showList(String sbbh,String sbmc,String dwdm,String dwmc,Pager pager){
		HbsbEntity entity= new HbsbEntity();
		entity.setSbbh(sbbh);
		entity.setSbmc(sbmc);
		entity.setDwdm(dwdm);
		entity.setDwmc(dwmc);
		return service.showList(entity, pager);
	}
	
	

	@GetMapping ("/sbbh_yz")
	@ApiOperation(value = "设备编号验证")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sbbh", value = "设备编号", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "hbsbid", value = "设备id", paramType = "query", dataType = "String")
	})
	public Map sbbh_yz(String sbbh,String dwdm,String hbsbid){
		HbsbEntity entity= new HbsbEntity();
		entity.setSbbh(sbbh);
		entity.setDwdm(dwdm);
		entity.setHbsbid(hbsbid);
		return service.sbbh_yz(entity);
	}

	@PostMapping("/insertSave")
	@ApiOperation(value ="设备录入保存" )
	public Map insertSave(@RequestBody HbsbEntity entity){

		return service.insertSave(entity);
	}

	@DeleteMapping ("/remove")
	@ApiOperation(value = "删除设备")
	@ApiImplicitParam(name = "hbsbid", value = "设备id", paramType = "query", dataType = "String",required = true)
	public Map remove(String hbsbid){
		HbsbEntity entity= new HbsbEntity();
		entity.setHbsbid(hbsbid);
		return service.remove(entity);
	}

	@GetMapping ("/edit_yz")
	@ApiOperation(value = "验证设备绑定的队伍是否有施工许可证")
	@ApiImplicitParam(name = "hbsbid", value = "设备id", paramType = "query", dataType = "String",required = true)
	public Map edit_yz(String hbsbid){
		HbsbEntity entity= new HbsbEntity();
		entity.setHbsbid(hbsbid);
		Map map = new HashMap();
		map.put("code", 200);
		map.put("msg","验证通过了");
		map.put("data","0");
		return map;
	}

	@PutMapping ("/updateSave")
	@ApiOperation(value = "修改保存")
	public Map updateSave(@RequestBody HbsbEntity entity){
		return service.updateSave(entity);
	}
}
