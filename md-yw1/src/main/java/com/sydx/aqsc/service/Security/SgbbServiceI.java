package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.PcUnitEntity;
import com.sydx.aqsc.entity.Security.*;

import java.util.List;
import java.util.Map;

public interface SgbbServiceI {

    Map sgbbList(SgbbEntity entity, Pager pager);

    Map showList(SgbbEntity entity, Pager pager);

    Map reportWorkoveSelect(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> rbAddVeiwSelect2(ReportWorkoveEntity entity);

    List<Map<String, String>> sgbzgxList(ReportWorkoveEntity entity);

    List<Map<String, String>> allgxList(ReportWorkoveEntity entity);

    Map getProcessParamJSON(RbEntity rb);

    List<Map<String, String>> tbrSelect(TeamEntity entity);

    List<Map<String, String>> cadreSelect(TeamEntity entity);

    List<Map<String, String>> monitorSelect(TeamEntity entity);

    Map<String, Object> savePPData(Map<String, String> map);

    Map  sgbbSave(ReportWorkoveEntity entity);

    Map  bbckList(ReportWorkoveEntity entity);

    Map  lsbb(ReportWorkoveEntity entity);
    Map  rbjl(SgrbEntity entity);

    List<ReportWorkoveEntity> sgbbChaKan(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> bbxg(ReportWorkoveEntity entity);

    List<BcwhEntity> bcList(BcwhEntity entity);

    String bbqx(String did);

    Map wgqr(CompleteReportEntity entity);

    Map reportData(CompleteReportEntity entity);

    List<Map<String,String>> cslx(MeasureEntity entity);

    Map initComplate(ReportWorkoveEntity entity, Pager pager);

    List<ReportWorkoveEntity> sgbbListjd(ReportWorkoveEntity entity);
    int max_spno(ReportWorkoveEntity entity);

    List<Map<String, String>> jhSelect();

    ReportWorkoveEntity rbAddVeiwSelect1(ReportWorkoveEntity entity);

    List<Map<String, String>> sgbzgxListJd(ReportWorkoveEntity entity);

    List<Map<String, String>> allgxListJd(ReportWorkoveEntity entity);

    List<Map<String, String>> ry(DwryEntity entity);

    Map<String, Object> savaPPDataJd(Map<String, String> map);

    Map<String, String> sgbbSaveJd(ReportWorkoveEntity entity);

    Map<String, String> sgbbRemove(ReportWorkoveEntity entity);

    String tab_select();

    Map xjkgList(SgbbEntity entity, Pager pager);

    Map<String, String> sgbz_yz(SgbzEntity entity);

    Object initSele(SgbbEntity sgbb);

    Map<String, String> xjkgSave(SgbbEntity entity);

    Map kgjList(SgbbEntity entity, Pager pager);

    List<Map> zyyy(CompleteReportEntity entity, String domain_level, String domain_code);

    List<Map>bgf(String ccfs);

    List<Map>bxx();

    Map yz_bxx(String id);

    Map bbSave(CompleteReportEntity entity);

    Map ztsg(SgbbEntity entity);

    Map<String, Object> bbckList2(ReportWorkoveEntity entity, Pager pager);

    Map zyrbList(ZyrbEntity entity, Pager pager);

    Map<String, String> gcSaveJd(GcEntity entity);

    Map gcSelect(GcEntity entity);

    List<Map<String, String>> gcname(GcEntity entity);

    List<Map<String, String>> gctype(GcEntity entity);

    List<Map<String,String>> shdw_select(PcUnitEntity entity);

    List<Map<String,String>> yldw_select(PcUnitEntity entity);

    List<Map<String,String>> lxygdw_select(PcUnitEntity entity);

    List<Map<String, String>> unit_select(PcUnitEntity entity);
}
