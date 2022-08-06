package com.cyrj.jxzy.Controller.Constractor;

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Constractor.BigTextEntity;
import com.cyrj.jxzy.service.Constractor.BigTextService;

@RestController
@RequestMapping("/bigText")
@Api(tags = "大文本管理")
public class BigTextController {
	
	@Autowired
	private BigTextService service;

	@PostMapping("/bigTextSave")
	@ApiOperation(value = "大文本保存")
	public Map bigTextSave(BigTextEntity entity){
		return service.bigTextSave(entity);
	}

	@GetMapping("/bigTextShow")
	@ApiOperation(value = "大文本查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "text_id", value = "大文本编号", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "type", value = "HSE承诺书、准入评估表、施工许可证", paramType = "query", dataType = "String", required = true)
	})
	public  Map  bigTextShow(String  text_id, String type){
		BigTextEntity entity = new BigTextEntity();
		entity.setText_id(text_id);
		entity.setType(type);
		return service.bigTextShow(entity);
	}
}
