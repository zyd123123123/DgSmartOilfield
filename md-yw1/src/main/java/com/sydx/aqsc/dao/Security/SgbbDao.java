package com.sydx.aqsc.dao.Security;

import com.sydx.aqsc.entity.Admin.PcUnitEntity;
import  com.sydx.aqsc.entity.Security.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SgbbDao {

    int countSgbb(SgbbEntity entity);

    List<SgbbEntity> listSgbb(SgbbEntity entity);

    int showCount(SgbbEntity entity);

    List<SgbbEntity> showList(SgbbEntity entity);

    List<ReportWorkoveEntity> reportWorkoveSelect(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> rbAddVeiwSelect2(ReportWorkoveEntity entity);

    List<GxEntity> allgxList(ReportWorkoveEntity entity);

    List<RbEntity> sgbzgxList(ReportWorkoveEntity entity);

    String processParamSelect4(RbEntity rb);

    List<GxEntity> processParamSelect1(RbEntity gx);

    List<GxEntity> processParamSelect2(RbEntity rb);

    Map<String, Object> selectPPData(RbEntity rb);

    List<TeamEntity> tbrSelect(TeamEntity entity);

    List<TeamEntity> cadreSelect(TeamEntity entity);

    List<TeamEntity> monitorSelect(TeamEntity entity);

    void savePPData(RbEntity rb);

    void removePPData(RbEntity rb);

    RbEntity selectXh(RbEntity rb);

    int sgbbSaveselect1(ReportWorkoveEntity entity);

    String sgbbSaveselect2(ReportWorkoveEntity entity);

    void sgbbSaveupdate1(ReportWorkoveEntity entity);

    void sgbbSavedelete1(ReportWorkoveEntity entity);

    void sgbbSaveinsert1(ReportWorkoveEntity entity);

    int bbckCount(ReportWorkoveEntity entity);

    List<SgbbEntity> bbckList(ReportWorkoveEntity entity);

    int lsbbCount(ReportWorkoveEntity entity);

    List<SgbbEntity> lsbb(ReportWorkoveEntity entity);
    List<SgrbEntity> rbjl(SgrbEntity entity);

    List<ReportWorkoveEntity> sgbbChaKan(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> bbxg(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> rbgx_cx(ReportWorkoveEntity entity);

    void removeRb(ReportWorkoveEntity entity);

    void insertRb(ReportWorkoveEntity entity);

    int sgbbSaveselect3(ReportWorkoveEntity entity);

    List<GxEntity> processParamSelect22(GxEntity gx);
    List<BcwhEntity> bcList(BcwhEntity entity);

    String bbqx(String did);

    int ysjs(CompleteReportEntity entity);

    CompleteReportEntity jxsgsj1(CompleteReportEntity entity);
    List<CompleteReportEntity> jxsgsj2(CompleteReportEntity entity);
    List<CompleteReportEntity> jxsgsj3(CompleteReportEntity entity);

    CompleteReportEntity reportData1(CompleteReportEntity entity);
    List<CompleteReportEntity> reportData2(CompleteReportEntity entity);
    CompleteReportEntity reportData3(CompleteReportEntity entity);
    List<CompleteReportEntity> reportData4(CompleteReportEntity entity);
    List<CompleteReportEntity> reportData5(CompleteReportEntity entity);
    List<CompleteReportEntity> reportData6(CompleteReportEntity entity);

    List<MeasureEntity> cslx(MeasureEntity entity);

    int selectCount(ReportWorkoveEntity entity);

    List<SgbbEntity> findAll(ReportWorkoveEntity entity);

    List<ReportWorkoveEntity> sgbbList(ReportWorkoveEntity entity);

    List<SgbbEntity> jhSelect(SgbbEntity entity);

    ReportWorkoveEntity rbAddVeiwSelect1(ReportWorkoveEntity entity);

    List<RbEntity> sgbzgxListJd(ReportWorkoveEntity entity);

    List<GxEntity> allgxListJd(ReportWorkoveEntity entity);

    List<DwryEntity> ry(DwryEntity entity);

    void removePPDataJd(RbEntity rb);

    int sgbbSaveselect3Jd(ReportWorkoveEntity entity);

    void sgbbSaveinsert1Jd(ReportWorkoveEntity entity);

    int xjkgCount(SgbbEntity entity);

    List<SgbbEntity> xjkgList(SgbbEntity entity);

    List<SgbzEntity> sgbz_yz(SgbzEntity entity);

    List<SgbbEntity> findA(SgbbEntity sgbb);

    void insertXjkgSave(SgbbEntity entity);

    int kgjCount(SgbbEntity entity);

    List<SgbbEntity> kgjList(SgbbEntity entity);

    List<String> bxx();
    List<String> bgf(@Param("ccfs") String ccfs);

   int yz_bxx(@Param("csid") String csid);

    CompleteReportEntity bbSaveSelect1(CompleteReportEntity entity);
    CompleteReportEntity bbSaveSelect2(CompleteReportEntity entity);
    List<Map> bbSaveSelect3(CompleteReportEntity entity);
    CompleteReportEntity bbSaveSelect4(CompleteReportEntity entity);
    CompleteReportEntity bbSaveSelect5(CompleteReportEntity entity);
    List<Map> bbSaveSelect6(@Param("csid") String csid);
    List<Map> bbSaveSelect7(@Param("csid") String csid);
    List<Map> bbSaveSelect8(@Param("sjid") String sjid);
    List<CompleteReportEntity> bbSaveSelect9(CompleteReportEntity entity);
    void bbSaveRemove1(CompleteReportEntity entity);
    void bbSaveRemove2(CompleteReportEntity entity);
    void bbSaveUpdate1(CompleteReportEntity entity);
    void bbSaveUpdate2(CompleteReportEntity entity);
    void bbSaveUpdate3(@Param("sql") String sql);
    void bbSaveInsert1(CompleteReportEntity entity);
    void bbSaveInsert2(CompleteReportEntity entity);
    void bbSaveInsert3(CompleteReportEntity entity);
    int cwid();

   void ztsgUpdate(SgbbEntity entity);

    List<Map<String, String>> zyyy(@Param("sql") String sql);

    int bbckCount2(ReportWorkoveEntity entity);

    List<SgbbEntity> bbckList2(ReportWorkoveEntity entity);

    List<ZyrbEntity> ykgjList(ZyrbEntity entity);

    void gcSaveinsert1Jd(GcEntity entity);

    List<GcEntity> gcSelect(GcEntity entity);

    List<GcEntity> gcname(GcEntity entity);

    List<GcEntity> gctype(GcEntity entity);

    List<PcUnitEntity> shdw_select(PcUnitEntity entity);
    List<PcUnitEntity> yldw_select(PcUnitEntity entity);
    List<PcUnitEntity> lxygdw_select(PcUnitEntity entity);
    AqscConfigEntity config();
    int max_spno(ReportWorkoveEntity entity);
    List<SgdyEntity> sgbbSaveselect_table(ReportWorkoveEntity entity);
    void sgbbSave_table_remove(SgdyEntity entity);

    List<PcUnitEntity>unit_select(PcUnitEntity entity);
}
