package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.DwzzEntity;

 public  interface AccessCardServiceI {

	 Map unit_select( String dwlbid);

	Map unit_select1(String parentid);

	 Map unit_select11(String parentid);

	 Map totalRows4(String termid);

	 Map unit_select3();

	 Map apply(String termid,String dwdm,String dwlbid);

	 Map select_manager(String parentid);

	 Map accessCard_save(DwzzEntity zz_entity);

	 Map accessCard_select(String dwdm,String audit_tab, Pager pager);

	 Map apply_audit_select(DwzzEntity zz_entity, Pager pager);

	 Map apply_audit(String sjid);

	 Map audit_sava(DwzzEntity zz_entity);

	 Map apply_completed_select(DwzzEntity zz_entity, Pager pager);

	 Map apply_fail_select(DwzzEntity zz_entity, Pager pager);

	 Map changeCertificate_select(DwzzEntity zz_entity, Pager pager);

	 Map changeCertificate(DwzzEntity zz_entity);
	 Map jiechu(DwzzEntity zz_entity);
	 Map feichu(DwzzEntity zz_entity);

	 Map apply_InReview_select(DwzzEntity zz_entity, Pager pager);

	 Map accessCard_print(DwzzEntity zz_entity);
	 Map changeCertificate_thisTeam_select(DwzzEntity zz_entity);
}
