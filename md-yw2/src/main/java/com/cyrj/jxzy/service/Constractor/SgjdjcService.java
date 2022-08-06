package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cyrj.jxzy.entity.Constractor.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.entity.Common.Pager;

public interface SgjdjcService {

	List<CbsFj4Entity>listFlb(CbsFj4Entity entity);
	
   Map flbSave(CbsFj4Entity entity);
   
   Map showList(Sgjdjc_J_ListEntity entity, Pager pager);
   
   Map  sgjdjclrSave(SgjdjclrEntity entity);
   
   Map showList_jl(Sgjdjc_J_ListEntity entity, Pager pager);
   
   Map jdjcmxList(SgjdjclrEntity entity);
   
   SgjdjclrEntity   jcjl_liulanSelect(SgjdjclrEntity entity);
   
   List<SgjdjclrEntity>   jcjl_liulanList(SgjdjclrEntity entity);
   
   Map jcjlRemove(SgjdjclrEntity entity);
   
   List<SgjdjclrEntity> sgjdjcjl_hzList(SgjdjclrEntity entity);
   SgjdjclrEntity   sgjdjcjl_hzSelect(SgjdjclrEntity entity);
   
   Map uploadFiles(SgjdjcUploadEntity entity, MultipartFile[] files);
   
   List<SgjdjcUploadEntity> imageView(SgjdjcUploadEntity entity);
   
   String select(Sgjdjc_J_ListEntity entity);
   
   Map  sgjdjczgSave(SgjdjclrEntity entity);

   List<Map<String, String>> unit_select(PcUnitEntity entity);
}
