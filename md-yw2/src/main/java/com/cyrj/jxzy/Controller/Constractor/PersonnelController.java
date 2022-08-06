package com.cyrj.jxzy.Controller.Constractor;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cyrj.jxzy.entity.Constractor.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.service.Constractor.PersonnelServiceI;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import net.sf.json.JSONObject;


@RestController
@RequestMapping(value= {"/Personnel"})
@Api(tags = "人员管理")
public class PersonnelController {

	@Autowired
	private PersonnelServiceI personnelService;
	@Autowired
	private HttpSession session;
	

	@GetMapping("/personnel_select")
	@ApiOperation(value = "维护页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gw", value = "岗位", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "xm", value = "姓名", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sfzh", value = "身份证号", paramType = "query", dataType = "String")
	})
	public Map personnel_select( String dwdm, String gw,String xm,String sfzh,Pager pager) {
		PersonEntity person_entity= new PersonEntity();
		person_entity.setDwdm(dwdm);
		person_entity.setGw(gw);
		person_entity.setXm(xm);
		person_entity.setSfzh(sfzh);
		return personnelService.personnel_select(person_entity,pager);
	}

	@GetMapping("/ID_card")
	@ApiOperation(value ="身份证号验证" )
	@ApiImplicitParams({
			@ApiImplicitParam(name = "sfzh", value = "身份证号", paramType = "query", dataType = "String")
	})
	public Map ID_card(String sfzh) {
		PersonEntity person_entity=new PersonEntity();
		person_entity.setSfzh(sfzh);
		return personnelService.ID_card(person_entity);
		
	}

	@PostMapping("/personnel_save")
	@ApiOperation(value = "新增保存")
	public Map personnel_save(@RequestBody PersonEntity person_entity) {
		return personnelService.personnel_save(person_entity);
	}


	@GetMapping("/Person_update")
	@ApiOperation(value = "人员信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ryid", value = "人员id", paramType = "query", dataType = "String",required = true)
	})
	public Map  Person_update(String ryid){
		PersonEntity entity= new PersonEntity();
		entity.setRyid(ryid);
		PersonEntity entity1 = personnelService.selectone(entity);
		Map map= new HashMap();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data",entity1);
		return map;
	}

	@PutMapping("/update_save")
	@ApiOperation(value = "修改保存")
	public Map update_save(@RequestBody PersonEntity person_entity) {
		return personnelService.update_save(person_entity);
	}

	@GetMapping("/edit_yq")
	@ApiOperation(value = "人员绑定情况查询")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ryid", value = "人员id", paramType = "query", dataType = "String",required = true)
	})
	public Map edit_yq(String ryid){
		PersonEntity entity= new PersonEntity();
		entity.setRyid(ryid);
		return  personnelService.edit_yq(entity);
	}

	@DeleteMapping("/removeSave")
	@ApiOperation(value = "删除保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ryid", value = "人员id", paramType = "query", dataType = "String",required = true)
	})
	public Map removeSave(String ryid){
		PersonEntity entity= new PersonEntity();
		entity.setRyid(ryid);
		return personnelService.removeSave(entity);
	}
	

	@GetMapping("/Personnel_entry")
	@ApiOperation(value = "队伍人员绑定")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "rymb_id", value = "人数id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true)
	})
	public Map personnel_entry(String rymb_id,String termid){
		PersonEntity entity= new PersonEntity();
		entity.setTermid(termid);
		entity.setRymb_id(rymb_id);
		List<PersonEntity> person_entityList = personnelService.personnel_entry(entity);
		Map map = new HashMap();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data",person_entityList);
		return map;
	}
	

	@GetMapping("/rybd_select")
	@ApiOperation(value = "人员绑定下拉框")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "rymb_id", value = "人数id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "ryid", value = "人员id", paramType = "query", dataType = "String" )
	})
	public Map rybd_select(String rymb_id,String ryid,String dwdm){
		PersonEntity entity= new PersonEntity();
		entity.setRymb_id(rymb_id);
		entity.setDwdm(dwdm);
		entity.setRyid(ryid);
		List<Map>list =personnelService.rybd_select(entity);
		Map map= new HashMap();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data",list);
		return map;
	}
	

	@PutMapping("/ry_bd_save")
	@ApiOperation(value = "人员绑定保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "gw", value = "岗位", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "xh", value = "序号", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "ryid", value = "人员id", paramType = "query", dataType = "String" )
	})
	public Map ry_bd_save(String dwdm,String termid,String gw,String xh,String ryid){
		PersonEntity entity = new PersonEntity();
		entity.setDwdm(dwdm);
		entity.setTermid(termid);
		entity.setGw(gw);
		entity.setXh(xh);
		entity.setRyid(ryid);
		return personnelService.ry_bd_save(entity);
	}

	@GetMapping("/select_cx")
	@ApiOperation(value = "查询页面列表数据")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "dwdm", value = "单位代码", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "termid", value = "队伍id", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gw", value = "岗位", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "xm", value = "姓名", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sfzh", value = "身份证号", paramType = "query", dataType = "String")
	})
	public Map select_cx(String dwdm, String termid,String gw,String xm,String sfzh,Pager pager){
		PersonEntity person_entity= new PersonEntity();
		person_entity.setDwdm(dwdm);
		person_entity.setTermid(termid);
		person_entity.setGw(gw);
		person_entity.setXm(xm);
		person_entity.setSfzh(sfzh);
		return personnelService.select_cx(person_entity,pager);
		
	}

//	/**
//	 * 队伍名称下拉列表
//	 * 这是一个异类，传回来的数值是ID。并非parentID。传回来的值是Person_wh中的dwdm
//	 * @return
//	 */
//	@RequestMapping("/unit_select1")
//	@ResponseBody
//	public List<Map<String, String>> unit_select1(String parentid){
//
//		return personnelService.unit_select1(parentid);
//
//	}

//	/**
//	 * 队伍名称下拉列表表2
//	 * 查询不与资质表重复的小队，左联查询人员表
//	 * @return
//	 */
//	@RequestMapping("/unit_select11")
//	@ResponseBody
//	public List<Map<String, String>> unit_select11(String parentid){
//		return personnelService.unit_select11(parentid);
//	}
	

	//人员信息卡!
//	@RequestMapping("/ryxxk")
//	public String  ryxxk(PersonEntity entity,Model model){
//
//		PersonEntity entity1=personnelService.ryselect(entity);
//		if(StringUtils.isNotBlank(entity1.getFileuri())){
//			entity1.setFileuri("../../"+entity1.getFileuri());
//		}
//		model.addAttribute("entity", entity1);
//		//根据登录人单位id，查询采油厂名称
//		String unitid=(String) session.getAttribute("unitid");
//		if(unitid.length()>8){
//			String unitname=personnelService.unitname(unitid.substring(0, 8));
//			model.addAttribute("unitname", unitname);
//		}
//
//
//		return "Constractor/cbs/Person_xxk";
//	}
	
//	//人员信息卡打印预览
//	@RequestMapping("/ryxxk_dyyl")
//	public String  ryxxk_dyyl(PersonEntity entity,Model model){
//
//		PersonEntity entity1=personnelService.ryselect(entity);
//		if(StringUtils.isNotBlank(entity1.getFileuri())){
//			entity1.setFileuri("../../"+entity1.getFileuri());
//		}
//		model.addAttribute("entity", entity1);
//		//根据登录人单位id，查询采油厂名称
//		String unitid=(String) session.getAttribute("unitid");
//		if(unitid.length()>8){
//			String unitname=personnelService.unitname(unitid.substring(0, 8));
//			model.addAttribute("unitname", unitname);
//		}
//		return "Constractor/cbs/Person_xxk_dyyl";
//	}
	
//	//人员信息卡打印
//	@RequestMapping("/ryxxk_dy")
//	public String  ryxxk_dy(PersonEntity entity,Model model){
//
//		PersonEntity entity1=personnelService.ryselect(entity);
//		if(StringUtils.isNotBlank(entity1.getFileuri())){
//			entity1.setFileuri("../../"+entity1.getFileuri());
//		}
//		model.addAttribute("entity", entity1);
//		//根据登录人单位id，查询采油厂名称
//		String unitid=(String) session.getAttribute("unitid");
//		if(unitid.length()>8){
//			String unitname=personnelService.unitname(unitid.substring(0, 8));
//			model.addAttribute("unitname", unitname);
//		}
//		return "Constractor/cbs/Person_xxk_dy";
//	}
	
//	@RequestMapping(value="/qrimage")
//		public ResponseEntity<byte[]> getQRImage(PersonEntity entity) {
//			PersonEntity entity1=personnelService.ryselect(entity);
//			byte[] qrcode = null;
// 		//生成二维码
//                 StringBuffer sb= new StringBuffer();
//                if( StringUtils.isBlank(entity1.getSfzh())){
//                	sb.append("身份证号:无");
//                }else{
//                	sb.append("身份证号:"+entity1.getSfzh());
//                }
//                sb.append("\n");
//                if( StringUtils.isBlank(entity1.getJkzbh())){
//                	 sb.append("井控证编号:无");
//                }else{
//                	 sb.append("井控证编号:"+entity1.getJkzbh());
//                }
//                sb.append("\n");
//                if( StringUtils.isBlank(entity1.getKssjs())){
//                	 sb.append("井控证有效期:无"+"~");
//                }else{
//                	 sb.append("井控证有效期:"+entity1.getKssjs()+"-");
//                }
//                if( StringUtils.isBlank(entity1.getJzsjs())){
//               	 sb.append("无");
//               }else{
//               	 sb.append(entity1.getJzsjs());
//               }
////                 sb.append("\n");
//
//                 String text=sb.toString();
//			QRCodeWriter qrCodeWriter = new QRCodeWriter();
//	        BitMatrix bitMatrix;
//			try {
//				//设备二维码格式
//				Map<EncodeHintType, Object> hints = new HashMap<>(3);
//		        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//		        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//		        hints.put(EncodeHintType.MARGIN, 0);
//
//				bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 258,258,hints);
//		        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
//		        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
//		        qrcode = pngOutputStream.toByteArray();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		    // Set headers
//		    final HttpHeaders headers = new HttpHeaders();
//		    headers.setContentType(MediaType.IMAGE_PNG);
//		    return new ResponseEntity<byte[]> (qrcode, headers, HttpStatus.CREATED);
//
//		}
//	/**
//	 * 人员导入页面跳转
//	 */
//	@RequestMapping("/import_edit")
//	public String import_edit(Model model){
//		return "Constractor/cbs/ry_import";
//	}

//	/**
//	 * 人员导入保存
//	 * @return
//	 */
//	@RequestMapping("/ry_import")
//	//@ResponseBody
//	public String ry_import(Model model, MultipartFile file, String termid) {
//		Map<String, String> map = new HashMap<String, String>();
//		if (file.isEmpty()) {
//			System.out.println("文件为空");
//			map.put("code", "0");
//			map.put("msg", "文件为空");
//		}else{
//			List<String> error = personnelService.exportExcel(file,termid);
//			if(error.size()>0){
//				map.put("code", "0");
//				if(String.valueOf(error.get(0)).equals("文件上传失败！")){
//					map.put("msg", error.get(0));
//				}else {
//					map.put("msg", error.get(0));
//				}
//			}else {
//				map.put("code", "1");
//				map.put("msg", "数据导入成功。");
//			}
//		}
//		model.addAttribute("code",map.get("code"));
//		model.addAttribute("msg",map.get("msg"));
//		return "Constractor/cbs/import_msg";
//
//	}
	
//	//打印保存功能，增加打印次数！
//	@RequestMapping("/printSave")
//	@ResponseBody
//	public Map printSave(PersonEntity entity){
//		return personnelService.printSave(entity);
//	}

	@GetMapping("/bg_select")
	@ApiOperation(value = "变更页面列表数据",response = Person_changeEntity.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "audit_tab", value = "审核状态0待审核 ，1已通过、2未通过", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "dwdm_new", value = "申请单位代码", paramType = "query", dataType = "String")
	})
	public Map bg_select(String audit_tab,String dwdm_new, Pager pager){
		Person_changeEntity entity= new Person_changeEntity();
		entity.setAudit_tab(audit_tab);
		entity.setDwdm_new(dwdm_new);
		return personnelService.bg_select(entity, pager);	
	}
	@PostMapping("/bgsq_save")
	@ApiOperation(value = "变更申请保存")
	public Map bgsq_save( Person_changeEntity entity,@RequestPart("files")MultipartFile[] files){

		return  personnelService.bgsq_save(entity, files);
	}

	@DeleteMapping("/bgsq_th")
	@ApiOperation(value = "撤销变更申请")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bg_id", value = "变更id", paramType = "query", dataType = "String",required = true)
	})
	public Map bgsq_th(String  bg_id){
		Person_changeEntity entity = new Person_changeEntity();
		entity.setBg_id(bg_id);
		return personnelService.bgsq_th(entity);
	}
	
	/**
	 * 返回照片展示页面！
	 */
	@GetMapping("/imageView")
	@ApiOperation(value = "获取照片url")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "String",required = true)
	})
	public Map  imageView(String id){
		UploadFilesEntity entity= new UploadFilesEntity();
		entity.setId(id);
		List<UploadFilesEntity> list = personnelService.imageView(entity);
		Map map= new HashMap();
		map.put("code",200);
		map.put("msg","成功");
		map.put("data",list);
		return map;

	}

	@PutMapping("/bgshSave")
	@ApiOperation("变更审核保存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bg_id", value = "变更id", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_tab", value = "审核状态:1已通过、2未通过", paramType = "query", dataType = "String",required = true),
			@ApiImplicitParam(name = "audit_reason", value = "审核原因", paramType = "query", dataType = "String")
	})
	public Map bgshSave(@RequestBody Person_changeEntity entity ){
		return personnelService.bgshSave(entity);
	}
}
