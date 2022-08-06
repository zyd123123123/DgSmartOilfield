package com.sydx.aqsc.dao.Security;

import com.sydx.aqsc.entity.Security.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SgjdDao {

    int djsgjd_count(WellEntity entity);

    List<WellEntity> djsgjd_List(WellEntity entity);

    List<Djsgjd_GxEntity> djsgjd_gx_Show(Djsgjd_GxEntity entity);

    List<Djsgjd_GxEntity> djsgjd_zt_Show(Djsgjd_GxEntity entity);

    List<ZyjdEntity> zyjd_dw(ZyjdEntity entity);

    List<Djsgjd_GxEntity> zyjd_gx(Djsgjd_GxEntity entity);

    Sgjd_configEntity sgjd_config(Sgjd_configEntity entity);

    void config_delete(Sgjd_configEntity entity);

    void config_save(Sgjd_configEntity entity);

    List<ReportWorkoveEntity> findAll(ReportWorkoveEntity sgjd);

    List<DjzyjdtEntity> spnameList(DjzyjdtEntity entity);

    List<AqhbwhEntity> sgdyList(DjzyjdtEntity entity);

    List<Map> ejList(@Param("oilfield") String oilfield,@Param("search")  String search);
    List<Map> sjList(@Param("parentid") String parentid,@Param("search")  String search );
    List<Map> sijList(@Param("parentid") String parentid );
}
