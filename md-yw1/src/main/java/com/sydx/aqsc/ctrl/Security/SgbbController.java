package com.sydx.aqsc.ctrl.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.PcUnitEntity;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.service.Security.SgbbServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * 施工工序
 */
@RestController
@RequestMapping(value = "/sgbb")
@Api(tags = "【施工管理】施工班报、日报管理")
public class SgbbController {

	@Autowired
	private SgbbServiceI service;


	@GetMapping("/sgbbList")
	@ApiOperation(value = "班报录入页列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "scdw", value = "生产单位代码", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sgdw", value = "施工单位代码", paramType = "query", dataType = "String")
	})
	public  Map sgbbList(String well_common_name,String scdw,String sgdw,  Pager pager){
		SgbbEntity entity= new SgbbEntity();
		entity.setWell_common_name(well_common_name);
		entity.setScdw(scdw);
		entity.setSgdw(sgdw);
		return service.sgbbList(entity,pager);
	}

	@GetMapping("/reportWorkoveSelect")
	@ApiOperation(value = "班报录入查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "report_time", value = "上报日期", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "order_classes", value = "班次", paramType = "query", dataType = "String",required = true)
	})
	public Map  reportWorkoveSelect(String did,String report_time,String order_classes){
		ReportWorkoveEntity entity= new ReportWorkoveEntity();
		entity.setDid(did);
		entity.setReport_time(report_time);
		entity.setOrder_classes(order_classes);
		return service.reportWorkoveSelect(entity);
	}

	@GetMapping("/getProcessParamJSON")
	@ApiOperation(value = "查询工序施工内容")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "spid", value = "工序id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "customid", value = "班报模板id", paramType = "query", dataType = "String")
	})
	public Map  getProcessParamJSON(int spid,String customid){
		RbEntity rb = new RbEntity();
		rb.setSpid(spid);
		rb.setCircuit_id(customid);
		return service.getProcessParamJSON(rb);
	}

	@GetMapping("/gxList")
	@ApiOperation(value = "主要、附加工序下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "gx_type", value = "标识：主要工序、附加工序", paramType = "query", dataType = "String",required = true)
	})
	public Map gxList(String did,String gx_type){
		ReportWorkoveEntity entity= new ReportWorkoveEntity();
		entity.setDid(did);
		entity.setGx_type(gx_type);
		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
		if(entity.getGx_type().equals("主要工序")){//获取模板主要工序下拉框
			list = service.sgbzgxList(entity);
		}else { //查询所有工序（包含标准和附加工序）
			list = service.allgxList(entity);
		}
		Map map = new HashMap();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data",list);
		return map;
	}

	@PostMapping("/sgbbSave")
	@ApiOperation(value = "施工班报保存")
	public Map  sgbbSave(@RequestBody ReportWorkoveEntity entity){
		return service.sgbbSave(entity);
	}

	@GetMapping("/bbList")
	@ApiOperation(value = "班报记录列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String",required = true)
	})
	public Map bbckList(String did){
		ReportWorkoveEntity entity= new ReportWorkoveEntity();
		entity.setDid(did);
		return service.bbckList(entity);
	}


	@GetMapping(value = { "/sgbbck" })
    @ApiOperation(value = "班报内容查看")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String",required = true),
            @ApiImplicitParam(name = "bb_id", value = "班报id", paramType = "query", dataType = "String",required = true)
    })
    public Map sgbbck(String did,String  bb_id) {
        ReportWorkoveEntity entity = new ReportWorkoveEntity();
        entity.setDid(did);
        entity.setBb_id(bb_id);
		List<ReportWorkoveEntity> entity_list = service.sgbbChaKan(entity);
		if(entity_list.size()>0){
			entity=entity_list.get(0);
		}

        Map map = new HashMap();
        map.put("entity", entity);
        map.put("entity_list", entity_list);
        Map resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
		return  resultMap;
	}


	@GetMapping("/showList")
	@ApiOperation(value = "班报、日报查看列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "scdw", value = "生产单位代码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "sgdw", value = "施工单位代码", paramType = "query", dataType = "String")
    })
    public Map showList(String well_common_name,String scdw,String sgdw,  Pager pager){
        SgbbEntity entity= new SgbbEntity();
        entity.setWell_common_name(well_common_name);
        entity.setScdw(scdw);
        entity.setSgdw(sgdw);
        return service.showList(entity,pager);
    }

    @GetMapping("/lsbb")
    @ApiOperation(value = "班报记录、历史记录数据查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String" ),
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "report_time", value = "上报时间", paramType = "query", dataType = "String")
    })
    public Map lsbb(String did, String well_common_name,String report_time){
        ReportWorkoveEntity entity = new ReportWorkoveEntity();
        entity.setDid(did);
        entity.setWell_common_name(well_common_name);
        entity.setReport_time(report_time);
        return service.lsbb(entity );
    }

    @GetMapping("/rbjl")
    @ApiOperation(value = "日报记录、历史记录数据查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "施工id", paramType = "query", dataType = "String" ),
            @ApiImplicitParam(name = "well_common_name", value = "井号", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "report_time", value = "上报时间", paramType = "query", dataType = "String")
    })
    public Map rbjl(String did, String well_common_name,String report_time){
		SgrbEntity entity = new SgrbEntity();
        entity.setDid(did);
        entity.setWell_common_name(well_common_name);
        entity.setReport_time(report_time);
        return service.rbjl(entity);
    }

	@GetMapping("/unit_select")
	@ApiOperation(value = "生产单位下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "parentid", value = "父级单位id", paramType = "query", dataType = "String")
	})
	public Map  unit_select(String parentid) {
		PcUnitEntity entity = new PcUnitEntity();
		entity.setParentid(parentid);
		Map  resultMap = new HashMap();
		resultMap.put("code",200);
		resultMap.put("msg","成功");
		resultMap.put("data",service.unit_select(entity));
		return  resultMap;
	}
	//班报录入页面
//	@GetMapping("/sgbbAddVeiw")
//	@ApiOperation(value = "班报录入查询")
//	public Map sgbbAddVeiw(Model model, ReportWorkoveEntity entity){
	//查询队伍班次及班次时间
//	BcwhEntity entity1= new BcwhEntity();
//		if (entity.getOp_team()!=null&&entity.getOp_team().length()>11){
//		entity1.setUnitid(entity.getOp_team().substring(0,11));
//	}else{
//		entity1.setUnitid(entity.getOp_team());
//	}
//	List<BcwhEntity> bcwhEntities = service.bcList(entity1);
//	//查询日报上报限制天数
//	String bbqx = service.bbqx(entity.getDid());
//	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//	String date = sdf.format(new Date());
//
//	int date1=1;
//		if(StringUtils.isNotBlank(bbqx)){
//		date1=Integer.parseInt(bbqx);
//	}
//	Calendar cal= Calendar.getInstance();
//		cal.setTime(new Date());
//		cal.add(Calendar.DATE,-date1);
//	String date2=sdf.format(cal.getTime());
//		entity.setWork_date(date);
//	//		//根据did从开工井表查询井号、队伍、队伍资质、开工时间等
////		ReportWorkoveEntity entity1 = service.rbAddVeiwSelect1(entity);
//	//从班报记录表查询最新班报记录
//	List<ReportWorkoveEntity> entity_list= new ArrayList<>();
//		if(entity.getBb_id()!=null&&entity.getBb_id().length()>0){
//		entity_list = service.bbxg(entity);
//		if(entity_list.size()>0){
//			entity=entity_list.get(0);
//		}
//	}
//		entity.setGx_type("主要工序");
//
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list);
//		model.addAttribute("bc_list", bcwhEntities);
//		model.addAttribute("date", date);
//		model.addAttribute("date2", date2);
//		return "Security/sgdt/bbcj_dq";
//	}


//	/**
//	 * 查看班报
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = { "/tab_select" })
//	private String tab_select(Model model) {
//		return service.tab_select();
//	}
//
//	/**
//	 * 标准工序展示
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = "/initComplate")
//	@ResponseBody
//	public Map initComplate(ReportWorkoveEntity entity, Pager pager) {
//
//		return service.initComplate(entity, pager);
//	}
//	/**

//	/**




//	//班长下拉框
//	@RequestMapping("/monitorSelect")
//	@ResponseBody
//	public List<Map<String, String>> monitorSelect(TeamEntity entity){
//
//		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
//		list = service.monitorSelect(entity);
//		return list;
//	}
//	//干部下拉框
//	@RequestMapping("/cadreSelect")
//	@ResponseBody
//	public List<Map<String, String>> cadreSelect(TeamEntity entity){
//
//		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
//		list = service.cadreSelect(entity);
//		return list;
//	}
//	//填表人下拉框
//	@RequestMapping("/tbrSelect")
//	@ResponseBody
//	public List<Map<String, String>> tbrSelect(TeamEntity entity){
//
//		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
//		list = service.tbrSelect(entity);
//		return list;
//	}
//	/**
//	 * 保存施工参数数据
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value = { "/savaPPData" })
//	@ResponseBody
//	public Map<String,Object> savaPPData(@RequestParam Map<String,String> map) {
//
//		Map<String,Object> map1 = service.savePPData(map);
//		return map1;
//	}


//	/**
//	 * 查看班报——冀东
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = { "/chakan_jd" })
//	private String chakan_jd(ReportWorkoveEntity entity, Model model) {
//		ReportWorkoveEntity entity1=null;
//		List<ReportWorkoveEntity> entity_list = service.sgbbChaKan(entity);
//		if(entity_list.size()>0){
//			entity1=entity_list.get(0);
//		}else {
//			entity1=entity;
//		}
//		model.addAttribute("entity", entity1);
//		model.addAttribute("entity_list", entity_list);
//		if(StringUtils.isEmpty(entity.getBb_id())){
//			return "Security/sgdtjd/bbckAll_jd";
//		}else {
//			return "Security/sgdtjd/bbck_jd";
//		}
//	}
//
//	/**
//	 * 查看班报
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = { "/bbxg" })
//	private String bbxg(ReportWorkoveEntity entity, Model model) {
//
//		List<ReportWorkoveEntity> entity_list = service.bbxg(entity);
//		if(entity_list.size()>0){
//			entity=entity_list.get(0);
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list);
//		return "Security/sgdt/bbxg";
//	}
//
//
//   //完工确认，判断是否满足完工要求
//	@RequestMapping("/wgqr")
//	@ResponseBody
//	public  Map wgqr(CompleteReportEntity entity){
//
//		return service.wgqr(entity);
//	}
//
//	//完工确认时查询报表数据
//	@RequestMapping("/reportData")
//	@ResponseBody
//	public  Map reportData(CompleteReportEntity entity){
//
//		return  service.reportData(entity);
//	}
//
//	//措施类型下拉框
//	@RequestMapping("/cslx")
//	@ResponseBody
//	public List<Map<String,String>> cslx(MeasureEntity entity){
//
//		return service.cslx(entity);
//	}
//
//	/**

//	/**
//	 * 修改班报
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = { "/sgbbEditVeiw" })
//	private String sgbbEditVeiw(ReportWorkoveEntity entity, Model model) {
//
//		List<ReportWorkoveEntity> entity_list = service.sgbbListjd(entity);
//		if(entity_list.size()>0){
//			entity=entity_list.get(0);
//		}
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity_list);
//		model.addAttribute("max_spno", service.max_spno(entity));
//
//		String url="";
//		if("修井".equals(entity.getBblx())){
//			//		原按工序采集
////		return "Security/sgdtjd/bbcj_gx";
////		按施工单元采集 2020.12.10改
//			url="Security/sgdtjd/bbcj";
//
//		}else if("试油".equals(entity.getBblx())){
//			url="Security/sgdtjd/bbcj_shiyou";
//		}else {
//			url="Security/sgdtjd/bbcj_paiye";
//		}
//		return url;
//	}
//	/**
//	 * 报班录入页面，井号下拉框
//	 * @return
//	 */
//	@RequestMapping("/jhSelect")
//	@ResponseBody
//	public List<Map<String, String>>  jhSelect(){
//		return service.jhSelect();
//	}
//	//班报录入页面
//	@RequestMapping("/sgbbAddVeiwJd")
//	public String sgbbAddVeiwJd(Model model, ReportWorkoveEntity entity, HttpSession session){
//		String truename=(String)session.getAttribute("realname");
//		entity.setRedaction_name(truename);
//		//根据did从开工井表查询井号、队伍、队伍资质、开工时间等
//		ReportWorkoveEntity entity1 = service.rbAddVeiwSelect1(entity);
//		//从班报记录表查询最新班报记录
//		List<ReportWorkoveEntity> entity_list = service.rbAddVeiwSelect2(entity);
//
//		entity.setWell_common_name(entity1.getWell_common_name());//井号
//		entity.setIntelligence_code(entity1.getIntelligence_code());//队伍资质
//		entity.setConstruct_team(entity1.getConstruct_team());//施工队伍名称
//		entity.setWork_brief(entity1.getWork_brief());//施工性质（施工内容）
//		entity.setWork_date(entity1.getWork_date());//开工日期
//		entity.setTeam_id(entity1.getTeam_id());
//		if(entity_list.size()>0){
//			ReportWorkoveEntity entity2 = entity_list.get(0);
//			entity.setConstruct_interval(entity2.getConstruct_interval());//施工井段
//			entity.setDensity_straturm(entity2.getDensity_straturm());//厚度/层数
//			entity.setStratigraphic_position(entity2.getStratigraphic_position());//层位
//			entity.setLevel_number(entity2.getLevel_number());//层号
//		}
//		entity.setGx_type("主要工序");
//		model.addAttribute("entity", entity);
//		model.addAttribute("entity_list", entity.getEntity_list());
//		model.addAttribute("max_spno",1);
//
//
//		String url="";
//		if("修井".equals(entity.getBblx())){
//			//		原按工序采集
////		return "Security/sgdtjd/bbcj_gx";
////		按施工单元采集 2020.12.10改
//			url="Security/sgdtjd/bbcj";
//
//		}else if("试油".equals(entity.getBblx())){
//			url="Security/sgdtjd/bbcj_shiyou";
//		}else {
//			url="Security/sgdtjd/bbcj_paiye";
//		}
//		return url;
//	}
//
//	@RequestMapping("/gcList")
//	@ResponseBody
//	public Map gcList(GcEntity entity){
//
//		return  service.gcSelect(entity);
//	}
//
//	//获取工序下拉框
//	@RequestMapping("/gxListJd")
//	@ResponseBody
//	public List<Map<String, String>> gxListJd(ReportWorkoveEntity entity){
//
//		List<Map<String, String>> list= new ArrayList<Map<String, String>>();
//		if(entity.getGx_type().equals("主要工序")){//获取模板主要工序下拉框
//			list = service.sgbzgxListJd(entity);
//		}else { //查询所有工序（包含标准和附加工序）
//			list = service.allgxListJd(entity);
//		}
//		return list;
//	}
//	//根据队伍id、人员岗位查询人员
//	@RequestMapping("/ry")
//	@ResponseBody
//	public List<Map<String, String>> ry(DwryEntity entity){
//
//		return service.ry(entity);
//	}
//
//	/**
//	 * 保存施工参数数据
//	 *
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value = { "/savaPPDataJd" })
//	@ResponseBody
//	public Map<String,Object> savaPPDataJd(@RequestParam Map<String,String> map) {
//
//		Map<String,Object> map1 = service.savaPPDataJd(map);
//		return map1;
//	}
//	//施工班报保存
//	@RequestMapping("/sgbbSaveJd")
//	@ResponseBody
//	public Map<String, String> sgbbSaveJd(ReportWorkoveEntity entity){
//		return service.sgbbSaveJd(entity);
//	}
//
//	//施工管串保存
//	@RequestMapping("/gcSaveJd")
//	@ResponseBody
//	public Map<String, String> gcSaveJd(GcEntity entity){
//		return service.gcSaveJd(entity);
//	}
//	//删除班报
//	@RequestMapping("/sgbbRemove")
//	@ResponseBody
//	public Map<String, String> sgbbRemove(ReportWorkoveEntity entity){
//		return service.sgbbRemove(entity);
//	}
//
//	/**
//	 * 查询泵类型
//	 * @return
//	 */
//	@RequestMapping("/bxx")
//	@ResponseBody
//	public List<Map>bxx(){
//
//		return service.bxx();
//	}
//
//	/**
//	 * 查询泵规范
//	 * @return
//	 */
//	@RequestMapping("/bgf")
//	@ResponseBody
//	public List<Map>bgf(String ccfs){
//
//		return service.bgf(ccfs);
//	}
//
//	/**
//	 * 作业原因描述下拉列表
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/zyyy")
//	@ResponseBody
//	public List<Map> zyyy(CompleteReportEntity entity,String domain_level,String domain_code){
//
//		return service.zyyy(entity,domain_level,domain_code);
//	}
//
//	/**
//	 *判断检泵类措施是否添加泵型号、泵径，如果没有填写将不能保存数据
//	 * @param id 措施四类id
//	 * @return
//	 */
//	@RequestMapping("/yz_bxx")
//	@ResponseBody
//	public Map yz_bxx(String id){
//		return service.yz_bxx(id);
//	}
//
//	/**
//	 * 报表数据保存
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/bbSave")
//	@ResponseBody
//	public Map bbSave(CompleteReportEntity entity){
//
//		return  service.bbSave(entity);
//	}
//
//	/**
//	 * 暂停施工
//	 * @return
//	 */
//	@RequestMapping("/ztsg")
//	@ResponseBody
//	public Map ztsg(SgbbEntity entity){
//
//		return  service.ztsg(entity);
//
//	}
//	/**
//	 * 新井开工
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping("/xjkgList")
//	@ResponseBody
//	public Map xjkgList(SgbbEntity entity,  Pager pager){
//		return service.xjkgList(entity, pager);
//	}
//	/**
//	 * 验证新开工井是否定制施工步骤
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/sgbz_yz")
//	@ResponseBody
//	public Map<String, String>sgbz_yz( SgbzEntity entity){
//
//		return service.sgbz_yz(entity);
//	}
//	/**
//	 * 添加工序
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = { "/createBB" })
//	private String createBB(ModelMap map, SgbbEntity sgbb) {
//
//		SimpleDateFormat  sdf= new SimpleDateFormat("yyyy-MM-dd");
//		String date=sdf.format(new Date());
//
//		map.addAttribute("entityList", service.initSele(sgbb));
//		map.addAttribute("did", sgbb.getDid());
//		map.addAttribute("date", date);
//		return "Security/sgdt/xjkg_add";
//
//	}
//	/**
//	 * 新井开工保存
//	 * @return
//	 */
//	@RequestMapping("/xjkgSave")
//	@ResponseBody
//	public Map<String, String> xjkgSave(SgbbEntity entity){
//		return service.xjkgSave(entity);
//	}
//	/**
//	 *开工井查询
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping("/kgjList")
//	@ResponseBody
//	public Map kgjList(SgbbEntity entity,  Pager pager){
//
//
//		return service.kgjList(entity, pager);
//	}
//
//
//	/**
//	 * 班报记录查询-wzw
//	 * @param entity
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping("/bbckList2")
//	@ResponseBody
//	public Map<String, Object>bbckList2(ReportWorkoveEntity entity, Pager pager){
//
//		return service.bbckList2(entity, pager);
//	}
//
//	/**
//	 * 作业日报
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping("/zyrbList")
//	@ResponseBody
//	public Map zyrbList(ZyrbEntity entity,  Pager pager){
//		return service.zyrbList(entity, pager);
//	}
//
//	//查询管串设备名称
//	@RequestMapping("/gcname")
//	@ResponseBody
//	public List<Map<String, String>> gcname(GcEntity entity){
//
//		return service.gcname(entity);
//	}
//	//查询管串设备型号
//	@RequestMapping("/gctype")
//	@ResponseBody
//	public List<Map<String, String>> gctype(GcEntity entity,String parentid){
////		System.out.println(entity.getKind()+"========================"+parentid);
//		entity.setSpid(Integer.valueOf(parentid));
//		return service.gctype(entity);
//	}
//
//	/**
//	 * 酸化队伍下拉框
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/shdw_select")
//	@ResponseBody
//	public List<Map<String,String>> shdw_select(PcUnitEntity entity){
//
//		return service.shdw_select(entity);
//	}
//
//	/**
//	 * 压裂队伍下拉框
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/yldw_select")
//	@ResponseBody
//	public  List<Map<String,String>> yldw_select(PcUnitEntity entity){
//
//		return service.yldw_select(entity);
//	}
//
//	/**
//	 * 酸化队伍下拉框
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping("/lxygdw_select")
//	@ResponseBody
//	public List<Map<String,String>>lxygdw_select(PcUnitEntity entity){
//
//		return service.lxygdw_select(entity);
//	}
}
