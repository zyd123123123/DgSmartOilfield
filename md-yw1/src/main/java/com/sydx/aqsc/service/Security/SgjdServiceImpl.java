package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.dao.Security.SgjdDao;
import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.UserHeaderEntity;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.util.Common;
import com.sydx.aqsc.util.SetPageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SgjdServiceImpl  implements  SgjdService{

    @Autowired
    private SgjdDao dao;
    @Autowired
    private HttpServletRequest request;
//    @Autowired
//    private RbDao rbDao;

    @Override
    public Map djsgjd_Show(WellEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search =  userEntity.getSearch();
        entity.setAttribute(attribute);
        entity.setSearch(search);
        entity.setUsername(username);

        int totalRows = dao.djsgjd_count(entity);
        SetPageUtil.setPage(entity, pager);
        List<WellEntity> list = dao.djsgjd_List(entity);
        Map<String, Object> map = new HashMap<>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map  resultMap = new HashMap ();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public Map djsgjd_gx_Show(Djsgjd_GxEntity entity) {
        List<Djsgjd_GxEntity> list = dao.djsgjd_gx_Show(entity);

        double jh_time=0;//计划
        double lj_time=0;//累计
        double zt_time=0;//暂停
        double sj_time=0;//实际
        double z_time=0;//增
        double j_time=0;//减
        for(Djsgjd_GxEntity entity1 :list){
            //计划
            BigDecimal a1 = new BigDecimal(Double.toString(jh_time));
            BigDecimal a2 = new BigDecimal(Double.toString(entity1.getJh_time()));
            jh_time= a1.add(a2).doubleValue();
            //累计
            BigDecimal b1 = new BigDecimal(Double.toString(lj_time));
            BigDecimal b2 = new BigDecimal(Double.toString(entity1.getLj_time()));
            lj_time= b1.add(b2).doubleValue();
            //暂停
            BigDecimal c1 = new BigDecimal(Double.toString(zt_time));
            BigDecimal c2 = new BigDecimal(Double.toString(entity1.getZt_time()));
            zt_time= c1.add(c2).doubleValue();
            //实际
            BigDecimal d1 = new BigDecimal(Double.toString(sj_time));
            BigDecimal d2 = new BigDecimal(Double.toString(entity1.getSj_time()));
            sj_time= d1.add(d2).doubleValue();
            //增
            BigDecimal e1 = new BigDecimal(Double.toString(z_time));
            BigDecimal e2 = new BigDecimal(Double.toString(entity1.getZ_time()));
            z_time= e1.add(e2).doubleValue();
            //减
            BigDecimal f1 = new BigDecimal(Double.toString(j_time));
            BigDecimal f2 = new BigDecimal(Double.toString(entity1.getJ_time()));
            j_time= f1.add(f2).doubleValue();
        }

        if(list.size()>0){
            Djsgjd_GxEntity entity1= new Djsgjd_GxEntity();
            entity1.setSpname("共计");
            entity1.setJh_time(jh_time);
            entity1.setLj_time(lj_time);
            entity1.setZt_time(zt_time);
            entity1.setSj_time(sj_time);
            entity1.setZ_time(z_time);
            entity1.setJ_time(j_time);
            list.add(entity1);
        }
        Map  resultMap = new HashMap ();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public Map djsgjd_zt_Show(Djsgjd_GxEntity entity) {

        List<Djsgjd_GxEntity> list = dao.djsgjd_zt_Show(entity);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        return map;
    }

    @Override
    public Map zyjd_dw(ZyjdEntity entity) {
        List<ZyjdEntity> list = dao.zyjd_dw(entity);
        Map  resultMap = new HashMap ();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public Map zyjd_gx(Djsgjd_GxEntity entity) {

        List<Djsgjd_GxEntity> list = dao.zyjd_gx(entity);
        Map  resultMap = new HashMap ();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public Sgjd_configEntity sgjd_config(Sgjd_configEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String unitid = userEntity.getUnitid();
        entity.setUnitid(unitid.substring(0,11));
        Sgjd_configEntity entity1= dao.sgjd_config(entity);
        if(entity1==null){
            entity.setUnitid("pc");
            entity1= dao.sgjd_config(entity);
        }
        return entity1;
    }

    @Override
    @Transactional
    public Map config_save(Sgjd_configEntity entity) {

        Map map= new HashMap();
        try{
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String unitid = userEntity.getUnitid();
            entity.setUnitid(unitid.substring(0,11));
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            dao.config_delete(entity);
            dao.config_save(entity);
            map.put("code","1");
        }catch (Exception e){
            map.put("code","0");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map config_remove(Sgjd_configEntity entity) {

        Map map= new HashMap();
        try{
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String unitid = userEntity.getUnitid();
            entity.setUnitid(unitid.substring(0,11));
            dao.config_delete(entity);
            map.put("code","1");
        }catch (Exception e){
            map.put("code","0");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map config_select(Sgjd_configEntity entity) {
        Map map = new HashMap();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String unitid = userEntity.getUnitid();
        entity.setUnitid(unitid.substring(0,11));
        Sgjd_configEntity entity1= dao.sgjd_config(entity);
        if(entity1==null){
            entity.setUnitid("pc");
            entity1= dao.sgjd_config(entity);
        }
        map.put("entity",entity1);
        return map;
    }

    @Override
    public Map sgjd_list(ReportWorkoveEntity sgjd, Pager pager) {
        // 获取油田id
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();;
        sgjd.setOilfield(oilfield);
        String attribute= userEntity.getAttribute();
        String search= userEntity.getSearch();
        sgjd.setAttribute(attribute);
        sgjd.setSearch(search);

        List<ReportWorkoveEntity> sgjdList = dao.findAll(sgjd);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", sgjdList);
        return map;
    }

    @Override
    public List<RbEntity> initSjcj(RbEntity rb) {

//        return rbDao.findSjAll(rb);
        return null;
    }

    @Override
    public Map<String, Object> spnameList(DjzyjdtEntity entity) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<DjzyjdtEntity> list = dao.spnameList(entity);

        int num=0;
        for(DjzyjdtEntity entity1:list){
            List<AqhbwhEntity> list1 = dao.sgdyList(entity1);
            if(list1.size()>num){
                num=list1.size();
            }
            entity1.setList_sgdy(list1);
        }

        map.put("data", list);
        map.put("num", num);
        return map;
    }

    @Override
    public Map ejList() {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();
        String search = "";
        if("1".equals(attribute)){
            search = userEntity.getSearch();
            if(StringUtils.isNotEmpty(search)&&search.length()>8){
                search=search.substring(0,8);
            }
        }

        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",dao.ejList(oilfield,search));
        return map;
    }

    @Override
    public Map sjList(String parentid) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();
        String search = "";
        if("1".equals(attribute)){
            search = userEntity.getSearch();
            if(StringUtils.isNotEmpty(search)&&search.length()>8){
                search=search.substring(0,8);
            }
        }
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",dao.sjList(parentid,search));
        return map;
    }
        @Override
    public Map sijList(String parentid) {
        Map map = new HashMap();
        map.put("code",200);
        map.put("msg","成功");
        map.put("data",dao.sijList(parentid));
        return map;
    }

}
