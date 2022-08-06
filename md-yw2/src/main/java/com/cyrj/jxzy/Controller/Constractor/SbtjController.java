package com.cyrj.jxzy.Controller.Constractor;

import java.util.Map;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.SbtjEntity;
import com.cyrj.jxzy.service.Constractor.SbtjService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbtj")
@Api(tags = "【设备管理】设备统计")
public class SbtjController {

	@Autowired
	private SbtjService service;
	

	@GetMapping("/showList")
	@ApiOperation(value = "列表查询",response = SbtjEntity.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwlbid", value = "单位类别id", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String")
	})
	public Map<String, Object>showList(String dwlbid,String dwdm){
		SbtjEntity entity = new SbtjEntity();
		entity.setDwdm(dwdm);
		entity.setDwlb(dwlbid);
		 Pager pager = new Pager();
		return service.showList(entity, pager);
	}
	
	
}
