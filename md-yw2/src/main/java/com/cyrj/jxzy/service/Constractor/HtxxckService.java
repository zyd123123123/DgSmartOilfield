package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;

public interface HtxxckService {
	
	 List<Map<String, String>> unit_select();
	
	 List<Map<String, String>> cbs_select(HtxxckEntity entity);
	 
	 List<Map<String, String>> nf_select();
	 
	 Map show_list(HtxxckEntity entity, Pager pager);
	 
	 Map show_list_cj(HtxxckEntity entity, Pager pager);
	 
	 Map show_list_audit(HtxxckEntity entity, Pager pager);
	 
	 Map show_list_Chang(HtxxckEntity entity, Pager pager);
	 
	 Map  term(ContractTeamEntity entity);
	 
	 Map  auditSave(HtxxckEntity entity);

}
