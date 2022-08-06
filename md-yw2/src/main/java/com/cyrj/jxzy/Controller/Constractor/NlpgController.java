package com.cyrj.jxzy.Controller.Constractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj2Entity;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.service.Constractor.NlpgService;

@RestController
@RequestMapping("/nlpg")
@Api(tags = "施工前能力评估")
public class NlpgController {

	@Autowired
	private NlpgService service;
	@Autowired
	private HttpServletRequest request;

	@GetMapping("/flb")
	@ApiOperation(value = "能领评估附录表查询")
	public Map flb( ){
		Map map = new HashMap();
		map.put("code", 200);
		map.put("msg", "成功");
		map.put("data", service.ListNlpgflb());
		return map;
	}

	@PostMapping("/flbSave")
	@ApiOperation(value = "附录表数据保存")
	public Map  flbSave(@RequestBody CbsFj2Entity entity){
		return service.flbSave(entity);
	}

	@GetMapping("/nlgpsqList")
	@ApiOperation(value = "申请页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map nlgpsqList(String effective_dates, String unit_id, String contractor_id,Pager pager){
		ContractTeamEntity entity= new ContractTeamEntity();
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.nlgpsqList(entity, pager);
	}

	@GetMapping("/applyTerm")
	@ApiOperation(value = "申请，施工队伍下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位id", paramType = "query", dataType = "String", required = true)
	})
	public Map applyTerm(String contract_id,String contractor_id){
		ContractTeamEntity entity = new ContractTeamEntity();
		entity.setContractor_id(contractor_id);
		entity.setContract_id(contract_id);
		Map map = new HashMap();
		map.put("code", 200);
		map.put("msg", "成功");
		map.put("data",  service.applyTerm(entity));
		return map;
	}

	@PostMapping("/applySave")
	@ApiOperation(value = "申请保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "contract_id", value = "合同id", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "sjid", value = "准入证id", paramType = "query", dataType = "String", required = true)
	})
	public Map applySave(String  contract_id,String sjid){
		ContractTeamEntity entity =  new ContractTeamEntity();
		entity.setContract_id(contract_id);
		entity.setSjid(sjid);
		return service.applySave(entity);
	}

	@GetMapping("/nlgpsqjlList")
	@ApiOperation(value = "申请查询、审核中待审核、未通过、已通过列表数据",notes = "申请查询、审核中待审核、未通过、已通过列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "audit_tab", value = " 审核状态:0待审核，1通过，2未通过", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map nlgpsqjlList(String effective_dates,String audit_tab,String unit_id, String contractor_id, Pager pager){
		ContractTeamEntity entity= new ContractTeamEntity();
		entity.setEffective_dates(effective_dates);
		entity.setAudit_tab(audit_tab);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.nlgpsqjlList(entity, pager);

	}

	@GetMapping("/audit")
	@ApiOperation(value = "能力评估审核")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pgb_id", value = "能力评估id", paramType = "query", dataType = "String", required = true)
	})
	public Map audit(String pgb_id ){
		String user = request.getHeader("user");
		UserHeaderEntity userEntity = Common.getUserHeader(user);
		String truename=userEntity.getReal_name();
		List<CbsFj2Entity> entity_list = service.ListNlpgflb();
		for(CbsFj2Entity cbs:entity_list){
			if(StringUtils.isBlank(cbs.getScrqz())){
				cbs.setScrqz(truename);
			}
		}

		ContractTeamEntity entity = service.contractTeam(pgb_id);
		Map map = new HashMap();
		map.put("entity_list",entity_list);
		map.put("entity",entity);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@PostMapping("/auditSave")
	@ApiOperation(value = "审核保存")
	public Map auditSave(@RequestBody NlpgshEntity entity){
		return service.auditSave(entity);
	}

	@GetMapping("/nlgpck")
	@ApiOperation(value = "查询、退回页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "effective_dates", value = "年份", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "unit_id", value = " 厂级单位ID", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "contractor_id", value = " 施工单位ID", paramType = "query", dataType = "String")
	})
	public Map nlgpck(String effective_dates,String unit_id, String contractor_id,Pager pager){
		ContractTeamEntity entity = new ContractTeamEntity();
		entity.setEffective_dates(effective_dates);
		entity.setUnit_id(unit_id);
		entity.setContractor_id(contractor_id);
		return service.nlgpck(entity, pager);
	}

	@GetMapping("/print")
	@ApiOperation(value = "能力评估表打印")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pgb_id", value = "能力评估id", paramType = "query", dataType = "String", required = true)
	})
	public Map print(String pgb_id ){
		List<CbsFj2Entity> entity_list = service.nlpgList(pgb_id);
		ContractTeamEntity entity = service.contractTeam(pgb_id);

		Map map = new HashMap();
		map.put("entity_list",entity_list);
		map.put("entity",entity);

		Map resultMap= new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",map);
		return resultMap;
	}

	@PutMapping("/revokeSave")
	@ApiOperation(value = "退回保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pgb_id", value = "能力评估id", paramType = "query", dataType = "String", required = true),
			@ApiImplicitParam(name = "back_cause", value = "退回原因", paramType = "query", dataType = "String", required = true)
	})
	public Map revokeSave(@RequestBody NlpgshEntity entity){
//		NlpgshEntity entity= new NlpgshEntity();
//		entity.setPgb_id(pgb_id);
//		entity.setBack_cause(back_cause);
		return service.revokeSave(entity);
	}
}
