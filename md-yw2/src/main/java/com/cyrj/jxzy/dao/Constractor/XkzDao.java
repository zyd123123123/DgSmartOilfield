package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.entity.Constractor.Qualification_personEntity;
import com.cyrj.jxzy.entity.Constractor.XkzEntity;
import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;
import com.cyrj.jxzy.entity.Constractor.XkzhtEntity;
import com.cyrj.jxzy.entity.Constractor.XkzshEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;

public interface XkzDao {

	
	int countXkzsq(NlpgshEntity entity);
	
	List<NlpgshEntity> listXkzsq(NlpgshEntity entity);
	
	List<XkzhtEntity>xkzsqyz(XkzhtEntity entity);
	
	int nlpgfile(XkzhtEntity entity);
	
	HtxxckEntity contract(String contract_id);
	
	XkzEntity term(String term_id);
	
	List<Qualification_personEntity> person(String term_id) ;
	
	ZysbEntity zysb(String term_id);
  
	List<Xkz_sbEntity>  zyptsb(String term_id);
	
	void insertXkzsqSave(XkzhtEntity entity);
	
	int countXkzsh(XkzshEntity entity);
	
	List<XkzshEntity> listXkzsh(XkzshEntity entity);
	
	void updateAuditSave(XkzshEntity entity);
	
	int countXkzck(XkzshEntity entity);
	
	List<XkzshEntity> listXkzck(XkzshEntity entity);
	
	void updatetRevokeSave(XkzshEntity entity);
	
	int countxkzck_ht(XkzshEntity entity);	
	List<XkzshEntity> listxkzck_ht(XkzshEntity entity);

	List<XkzshEntity> listxkzck_term(XkzshEntity entity);
	
	List<XkzshEntity> xkz_List(XkzshEntity entity);
}
