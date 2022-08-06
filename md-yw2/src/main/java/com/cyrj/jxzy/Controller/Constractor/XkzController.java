package com.cyrj.jxzy.Controller.Constractor;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.entity.Constractor.Qualification_personEntity;
import com.cyrj.jxzy.entity.Constractor.XkzEntity;
import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;
import com.cyrj.jxzy.entity.Constractor.XkzhtEntity;
import com.cyrj.jxzy.entity.Constractor.XkzshEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;
import com.cyrj.jxzy.service.Constractor.XkzService;
import com.cyrj.jxzy.util.HttpUtil;

@Api(tags = "施工许可证")
@RestController
@RequestMapping("/xkz")
public class XkzController {

	@Autowired
	private XkzService service;

	@GetMapping("/xkzsqList")
	@ApiOperation(value = "申请页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map  xkzsqList(String effective_dates,String unit_id,String contractor_id, Pager pager){
		NlpgshEntity entity = new NlpgshEntity();
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.xkzsqList(entity, pager);		
	}

	@GetMapping("/xkzsqyz")
	@ApiOperation(value = "验证队伍是否能申请许可证")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "team_id", value = " 队伍id", paramType = "query", dataType = "String",required = true)
	})
	public Map xkzsqyz(String contract_id,String team_id){
		XkzhtEntity entity = new XkzhtEntity();
		entity.setContract_id(contract_id);
		entity.setTeam_id(team_id);
		return service.xkzsqyz(entity);
	}

	@GetMapping("/xzksp")
	@ApiOperation(value = "许可证申请")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "team_id", value = " 队伍id", paramType = "query", dataType = "String",required = true)
	})
	public Map xzksp(String contract_id,String team_id){
		XkzhtEntity entity = new XkzhtEntity();
		entity.setContract_id(contract_id);
		entity.setTeam_id(team_id);
		//查询合同信息
		HtxxckEntity entity_ht = service.contract(entity.getContract_id());
		//开工日期
		String operation_start_dates = entity_ht.getOperation_start_dates();
		//完工日期
		String completion_dates = entity_ht.getCompletion_dates();
		String ks = null;
		String jz = null;
		if(StringUtils.isNotBlank(operation_start_dates)&&StringUtils.isNotBlank(completion_dates)){
			 ks = operation_start_dates.substring(0, 4)+"."+operation_start_dates.substring(5, 7)+"."+operation_start_dates.substring(8, 10);
			 jz = completion_dates.substring(0, 4)+"."+completion_dates.substring(5, 7)+"."+completion_dates.substring(8, 10);
		}
		  //根据队伍id查询队伍准入证信息
		XkzEntity entity_dy = service.term(entity.getTeam_id());
		//查询队伍人员信息
		List<Qualification_personEntity> list = service.person(entity.getTeam_id());
		Qualification_personEntity qp_dz = new Qualification_personEntity();//队长
		Qualification_personEntity qp_fdz= new Qualification_personEntity();//副队长
		Qualification_personEntity qp_jsy= new Qualification_personEntity();//技术员
		Qualification_personEntity qp_czs= new Qualification_personEntity();//操作手
		Qualification_personEntity qp_bz= new Qualification_personEntity();//班长
		Qualification_personEntity qp_jkg1= new Qualification_personEntity();//井口工1
		Qualification_personEntity qp_jkg2= new Qualification_personEntity();//井口工2
		Qualification_personEntity qp_cdg= new Qualification_personEntity();//场地工
		Qualification_personEntity qp_cly= new Qualification_personEntity();//材料员
		int i=0;
		for(Qualification_personEntity qq:list){
//			if(StringUtils.isNotBlank(qq.getFileuri())){
//				qq.setFileuri("../../"+qq.getFileuri());
//			}
			if(i==0){			
				qp_dz=qq;				
			}else if(i==1){
				qp_fdz=qq;
			}else if(i==2){				
				qp_jsy=qq;
			}else if(i==3){				
				qp_czs=qq;
			}else if(i==4){				
				qp_bz=qq;
			}else if(i==5){				
				qp_jkg1=qq;
			}else if(i==6){				
				qp_jkg2=qq;
			}
			else if(i==7){				
				qp_cdg=qq;
			}else if(i==8){				
				qp_cly=qq;
			}
			i++;
		}
		
		//查询主要是设备信息
		ZysbEntity zysb = service.zysb(entity.getTeam_id());
		//主要配套设备		
		Xkz_sbEntity jk = new Xkz_sbEntity();//井控设备（防喷器）
		Xkz_sbEntity hb = new Xkz_sbEntity();//环保装置
		Xkz_sbEntity fs1 = new Xkz_sbEntity();//水泥车
		Xkz_sbEntity fs2 = new Xkz_sbEntity();//罐车
		List<Xkz_sbEntity> li = service.zyptsb(entity.getTeam_id());
				
		for(Xkz_sbEntity xkz:li){
			if("防喷器".equals(xkz.getSbmc())){
				jk=xkz;
			}else if("环保装置".equals(xkz.getSbmc())){
				hb=xkz;
			}else if("水泥车".equals(xkz.getSbmc())){
				fs1=xkz;
			}else if("罐车".equals(xkz.getSbmc())){
				fs2=xkz;
			}
		}	
		
		Calendar cal = Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int date=cal.get(Calendar.DATE);

		Map map = new HashMap();
		map.put("entity_ht", entity_ht);//合同
		map.put("operation_start_dates", ks+"~"+ jz);//合同有效期
		map.put("contract_id()", entity.getContract_id());//合同id
		map.put("entity_dy", entity_dy);//合同队伍信息
		map.put("qp_dz", qp_dz);//队长
		map.put("qp_fdz", qp_fdz);//副队长
		map.put("qp_jsy", qp_jsy);//技术员
		map.put("qp_czs", qp_czs);//操作手
		map.put("qp_bz", qp_bz);//队长
		map.put("qp_jkg1", qp_jkg1);//井口工1
		map.put("qp_jkg2", qp_jkg2);//井口工2
		map.put("qp_cdg", qp_cdg);//场地工
		map.put("qp_cly", qp_cly);//材料员
		
		map.put("zysb", zysb);//主要设备
		map.put("jk", jk);//防喷器
		map.put("hb", hb);//环保装置
		map.put("fs1", fs1);//水泥车
		map.put("fs2", fs2);//罐车
		map.put("year", year);//年份
		map.put("month", month);//月份
		map.put("date", date);//天

		Map resultMap = new HashMap();
		resultMap.put("code", 200);
		resultMap.put("msg", "成功");
		resultMap.put("data", map);
		return resultMap;
	}

	@PostMapping("/xkzsqSave")
	@ApiOperation(value = "申请保存")
	public Map xkzsqSave(@RequestBody XkzhtEntity entity){
		return service.xkzsqSave(entity);
	}
	

	@GetMapping("/xkzshList")
	@ApiOperation(value = "审核页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "audit_tab", value = "核状态：0待审核，1审核通过，2审核未通过,3作废", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map  xkzshList(String audit_tab, String effective_dates,String unit_id,String contractor_id,  Pager pager){
		XkzshEntity entity = new XkzshEntity();
		entity.setAudit_tab(audit_tab);
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.xkzshList(entity, pager);		
	}

	@PutMapping("/auditSave")
	@ApiOperation(value = "审核保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "permit_id", value = "许可证id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_tab", value = " 审核状态：2审核通过，0审核未通过", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_cause", value = " 审核原因", paramType = "query", dataType = "String")
	})
	public Map uditSave(@RequestBody XkzshEntity entity){
//		XkzshEntity entity= new XkzshEntity();
//		entity.setPermit_id(permit_id);
//		entity.setAudit_tab(audit_tab);
//		entity.setAudit_cause(audit_cause);
		return service.auditSave(entity);
	}
	@GetMapping("/xkzckList")
	@ApiOperation(value = "撤回页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map  xkzckList(String effective_dates,String unit_id,String contractor_id, Pager pager){
		XkzshEntity entity = new XkzshEntity();
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.xkzckList(entity, pager);		
	}

	@GetMapping("/xkzck_ht_List")
	@ApiOperation(value = "查看页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map xkzck_ht_List(String effective_dates,String unit_id,String contractor_id,Pager pager){
		XkzshEntity entity = new XkzshEntity();
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.xkzck_ht_List(entity, pager);		
	}

	@GetMapping("/xkzck_term_List")
	@ApiOperation(value = "发证队伍列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true)
	})
	public Map xkzck_term_List(String contract_id){
		XkzshEntity entity = new XkzshEntity();
		entity.setContract_id(contract_id);
		return service.xkzck_term_List(entity);		
	}
	

	@GetMapping("/xkz_List")
	@ApiOperation(value = "发证次数列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "term_id", value = "队伍id", paramType = "query", dataType = "String",required = true)
	})
	public Map  xkz_List(String contract_id,String term_id){
		XkzshEntity entity = new XkzshEntity();
		entity.setContract_id(contract_id);
		entity.setTerm_id(term_id);
		return service.xkz_List(entity);		
	}

	@PutMapping("/revokeSave")
	@ApiOperation(value = "撤回保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "permit_id", value = "许可证id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_tab", value = " 状态:3作废", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_cause", value = " 退回原因", paramType = "query", dataType = "String")
	})
	public Map revokeSave(@RequestBody XkzshEntity entity  ){
//		XkzshEntity entity = new XkzshEntity();
//		entity.setPermit_id(permit_id);
//		entity.setAudit_tab(audit_tab);
//		entity.setAudit_cause(audit_cause);
		return service.revokeSave(entity);
	}
	
}
