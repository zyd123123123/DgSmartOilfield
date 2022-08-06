package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj6Entity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.JxpgEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_Ht_DwEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_cbsEntity;

public interface JxpgService {

    Map contractorList(HtxxckEntity entity, Pager pager);

    Map contractList(HtxxckEntity entity);

    Map jxpgSave(JxpgEntity entity);

    Map jxpgckList(JxpgEntity entity, Pager pager);

    JxpgEntity jxpgckSelect1(JxpgEntity entity);

    List<Jxpg_Ht_DwEntity> jxpgckSelect2(JxpgEntity entity);

    List<Jxpg_Ht_DwEntity> jxpgTeam(Jxpg_Ht_DwEntity entity);

    Map cbs_pg(Jxpg_cbsEntity entity);

    Map jxpg_cbs_ht(Jxpg_cbsEntity entity);

    String jxpg_cbs_one_select0(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select1(Jxpg_cbsEntity entity);

    List<CbsFj6Entity> jxpg_cbs_one_select2(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select3(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select4(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select5(Jxpg_cbsEntity entity);

    Map zyd_pg(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select1(Jxpg_cbsEntity entity);

    List<CbsFj6Entity> jxpg_zyd_one_select2(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select4(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select5(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_newSelect1(Jxpg_Ht_DwEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_newSelect2(Jxpg_Ht_DwEntity entity);

    List<CbsFj6Entity> jxpg_newSelect3(CbsFj6Entity entity);

    List<Jxpg_Ht_DwEntity> jxpg_newSelect4(Jxpg_Ht_DwEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_newSelect5(Jxpg_Ht_DwEntity entity);

    int jxpg_newSelect6(Jxpg_Ht_DwEntity entity);
}
