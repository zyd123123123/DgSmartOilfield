package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.PersonEntity;
import com.cyrj.jxzy.entity.Constractor.Person_changeEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;

import org.springframework.web.multipart.MultipartFile;

 public interface PersonnelServiceI {

	  List<PersonEntity> personnel_entry(PersonEntity person_entity);
	
	List<Map> rybd_select(PersonEntity entity);

	  Map personnel_save(PersonEntity person_entity);

	  Map ID_card(PersonEntity person_entity);

	  List<Map<String, String>> unit_select1(String parentid);

	  Map update_save(PersonEntity person_entity);

	  Map personnel_select(PersonEntity person_entity, Pager pager);

	  Map select_cx(PersonEntity person_entity, Pager pager);

	  List<Map<String, String>> unit_select11(String parentid);
	
	Map removeSave(PersonEntity person_entity);

	PersonEntity ryselect(PersonEntity entity);
	
	PersonEntity selectone(PersonEntity entity);
	
	String unitname(String unitid);

	  List<String> exportExcel(MultipartFile file, String termid);
	
	Map printSave(PersonEntity entity);
	
	Map ry_bd_save(PersonEntity entity);
	
	Map bg_select(Person_changeEntity entity, Pager pager);
	
	Map  bgsq_save(Person_changeEntity entity, MultipartFile[] files);
	
	Map bgsq_th(Person_changeEntity entity);
	List<UploadFilesEntity>imageView(UploadFilesEntity entity);
	
	Map bgshSave(Person_changeEntity entity);

	Map edit_yq(PersonEntity entity);
	
}
