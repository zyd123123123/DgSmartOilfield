package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cyrj.jxzy.entity.Constractor.PersonEntity;
import com.cyrj.jxzy.entity.Constractor.Person_changeEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.entity.Constractor.VqqxtEntity;


 public interface PersonnelDao {

	  List<PersonEntity> selectByParam3(PersonEntity person_entity);

	  List<PersonEntity> selectByParam1(PersonEntity person_entity);


	  List<VqqxtEntity> selectByParam3(VqqxtEntity vqq);

	  int insert(PersonEntity person_entity);

	  int count4(PersonEntity entity);

	  List<PersonEntity> selectByParam4(PersonEntity person_entity);

	  int count(PersonEntity person_entity);


	  void update(PersonEntity person_entity);

	  List<PersonEntity> selectByParam(PersonEntity person_entity);

	  List<PersonEntity> ID_card(PersonEntity person_entity);


	void removeSave(PersonEntity entity);
	
	PersonEntity ryselect(PersonEntity entity);
	
	PersonEntity selectone(PersonEntity entity);
	
	String maxNum();
	
	String unitname(@Param("unitid") String unitid);

	  void import_edit(PersonEntity person_entity);
	
	void printSave(PersonEntity entity) ;

	List<PersonEntity> personnel_save_select(PersonEntity entity);
	
	void personnel_save_delete(PersonEntity entity);
	
	List<PersonEntity>	rybd_select(PersonEntity entity);
	
	void ry_bd_save(PersonEntity person_entity);
   List<PersonEntity>	ry_bd_select(PersonEntity person_entity);
   
   List<Person_changeEntity>	bg_select_list(Person_changeEntity person_entity);
   
   int bg_select_count(Person_changeEntity person_entity);
   
  List<Person_changeEntity>  bgsq_save_select(Person_changeEntity entity);
   void bgsq_save1(Person_changeEntity entity);
   
   void bgsq_save2(Person_changeEntity entity);
   
   void bgsq_th_delete(Person_changeEntity entity) ;
   
   List<UploadFilesEntity> imageView(UploadFilesEntity entity);
   
   void bgshSave(Person_changeEntity entity);
   
   List<PersonEntity> edit_yq(PersonEntity entity) ;

	 List<PersonEntity> select2(PersonEntity person_entity);
}
