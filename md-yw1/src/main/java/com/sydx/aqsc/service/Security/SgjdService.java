package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Security.*;

import java.util.List;
import java.util.Map;

public interface SgjdService {

    Map djsgjd_Show(WellEntity entity, Pager pager);

    Map djsgjd_gx_Show(Djsgjd_GxEntity entity);

    Map djsgjd_zt_Show(Djsgjd_GxEntity entity);

    Map zyjd_dw(ZyjdEntity entity);

    Map zyjd_gx(Djsgjd_GxEntity entity);

    Sgjd_configEntity  sgjd_config(Sgjd_configEntity entity);

    Map config_save(Sgjd_configEntity entity);

    Map config_remove(Sgjd_configEntity entity);

    Map config_select(Sgjd_configEntity entity);

    Map sgjd_list(ReportWorkoveEntity sgjd, Pager pager);
    List<RbEntity> initSjcj(RbEntity rb);
    Map<String, Object> spnameList(DjzyjdtEntity entity);

    Map ejList();
    Map sjList(String parentid);
    Map sijList(String parentid);
}
