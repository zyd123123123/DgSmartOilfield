package com.cyrj.jxzy.dao.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Constractor.*;
import org.apache.ibatis.annotations.Param;

public interface SgjdjcDao {

	
	List<CbsFj4Entity> listFlb(CbsFj4Entity entity);
	
	void deleteFlbSave(CbsFj4Entity entity);
	
	void insertFlbSave(CbsFj4Entity entity);
	
	int contShowList(Sgjdjc_J_ListEntity entity);
	
	List<Sgjdjc_J_ListEntity> showList(Sgjdjc_J_ListEntity entity);
	//查询作业类型
	List<Sgjdjc_J_ListEntity> listZylx(Sgjdjc_J_ListEntity entity);

	
	
	void insertSgjdjclrSave1(SgjdjclrEntity entity);
	
	void insertSgjdjclrSave2(SgjdjclrEntity entity);
	
	void deleteSgjdjclrSave(SgjdjclrEntity entity);
	
	void insertSgjdjclrSave3(SgjdjclrEntity entity);
	
	int contshowList_jl(Sgjdjc_J_ListEntity entity);
	
	List<Sgjdjc_J_ListEntity> showList_jl(Sgjdjc_J_ListEntity entity);
	
	List<SgjdjclrEntity> jdjcmxList(SgjdjclrEntity entity);
	
	   SgjdjclrEntity   jcjl_liulanSelect(SgjdjclrEntity entity);	   
	   List<SgjdjclrEntity>   jcjl_liulanList(SgjdjclrEntity entity);
	   
	  void  jcjlRemove(SgjdjclrEntity entity);
	  
	  List<SgjdjclrEntity> sgjdjcjl_hzList(SgjdjclrEntity entity);
	  SgjdjclrEntity sgjdjcjl_hzSelect(SgjdjclrEntity entity);
	
	  void deleteImage(SgjdjcUploadEntity entity);
	  void insertImage(SgjdjcUploadEntity entity);
	  
	  List<SgjdjcUploadEntity> imageView(SgjdjcUploadEntity entity);
	  
	  String select(Sgjdjc_J_ListEntity entity);
	  
	  void sgjdjczgUpdate1(SgjdjclrEntity entity);
	  void sgjdjczgUpdate2(SgjdjclrEntity entity);
	  List<PcUnitEntity>unit_select(PcUnitEntity entity);
}
