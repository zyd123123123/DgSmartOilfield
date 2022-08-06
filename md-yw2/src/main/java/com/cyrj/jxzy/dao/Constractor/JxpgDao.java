package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj6Entity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.JxpgEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_Ht_DwEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_cbsEntity;

public interface JxpgDao {

    int countContractor(HtxxckEntity entity);

    List<HtxxckEntity> listContractor(HtxxckEntity entity);

    List<HtxxckEntity> contractList(HtxxckEntity entity);


    List<Jxpg_Ht_DwEntity> jxpgTeam(Jxpg_Ht_DwEntity entity);

    void jxpgSave1(JxpgEntity entity);

    void jxpgSave2(JxpgEntity entity);

    int jxpgckCount(JxpgEntity entity);

    List<JxpgEntity> jxpgckList(JxpgEntity entity);

    JxpgEntity jxpgckSelect1(JxpgEntity entity);

    List<Jxpg_Ht_DwEntity> jxpgckSelect2(JxpgEntity entity);

    int jxpgSelect6(Jxpg_Ht_DwEntity entity);

    List<Jxpg_cbsEntity> cbs_pg(Jxpg_cbsEntity entity);

    List<HtxxckEntity> jxpg_cbs_ht(Jxpg_cbsEntity entity);

    List<HtxxckEntity> jxpg_zyd_ht(Jxpg_cbsEntity entity);

    String jxpg_cbs_one_select0(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select1(Jxpg_cbsEntity entity);

    List<CbsFj6Entity> jxpg_cbs_one_select2(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select3(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select4(Jxpg_cbsEntity entity);

    List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select5(Jxpg_cbsEntity entity);

    List<Jxpg_cbsEntity> zyd_pg(Jxpg_cbsEntity entity);

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
