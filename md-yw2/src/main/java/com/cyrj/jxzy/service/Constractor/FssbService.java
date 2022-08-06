package com.cyrj.jxzy.service.Constractor;

import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.FssbEntity;


public interface FssbService {

	Map showList(String sbbh,String bz,String sbmc,String dwdm,String dwmc,Pager pager);
	
	Map<String,String> sbbh_yz(String sbbh,String dwdm,String fssbid);
	
	 Map<String,String>insertSave(FssbEntity entity);
	 
	 Map<String,String>remove(FssbEntity entity);
	 
	 Map<String, String>updateSave(FssbEntity entity);
}
