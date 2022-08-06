package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;

public interface QylrServiceI {

    Map unit_select1();

    Map unit_select(String id);

    Map check(String dwdm);

    Map save(QylrEntity entity);

    Map<String, Object> show_list(String dwlbid,String unitname,String dwmc, Pager pager);

    Map save_update(QylrEntity entity);

    Map selecltOne(String dwdm);
}
