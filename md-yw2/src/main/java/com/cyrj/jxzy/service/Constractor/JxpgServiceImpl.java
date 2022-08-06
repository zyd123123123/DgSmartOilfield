package com.cyrj.jxzy.service.Constractor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cyrj.jxzy.dao.Constractor.JxpgDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj6Entity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.JxpgEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_Ht_DwEntity;
import com.cyrj.jxzy.entity.Constractor.Jxpg_cbsEntity;
import com.cyrj.jxzy.util.SetPageUtil;

import net.sf.json.JSONArray;

@Service
public class JxpgServiceImpl implements JxpgService {

    @Autowired
    private JxpgDao dao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Map contractorList(HtxxckEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setUnit_id(search);

        //总记录数
        int totalRows = dao.countContractor(entity);
        SetPageUtil.setPage(entity, pager);
        List<HtxxckEntity> list = dao.listContractor(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    @Transactional
    public Map jxpgSave( JxpgEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setAssessment_person(userid);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String search = userEntity.getSearch();//数据权限
            entity.setUnit_id(search);
            dao.jxpgSave1(entity);
            dao.jxpgSave2(entity);
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，保存失败。");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map jxpgckList(JxpgEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setAttribute(attribute);
        entity.setSearch(search);
        entity.setOilfield(oilfield);
        //总记录数
        int totalRows = dao.jxpgckCount(entity);
        SetPageUtil.setPage(entity, pager);
        List<JxpgEntity> list = dao.jxpgckList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public JxpgEntity jxpgckSelect1(JxpgEntity entity) {
        return dao.jxpgckSelect1(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpgckSelect2(JxpgEntity entity) {
        return dao.jxpgckSelect2(entity);
    }

    @Override
    public Map<String, Object> contractList(HtxxckEntity entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setUnit_id(search);

        List<HtxxckEntity> list = dao.contractList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpgTeam(Jxpg_Ht_DwEntity entity) {

        return dao.jxpgTeam(entity);
    }

    @Override
    public Map cbs_pg(Jxpg_cbsEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        if (StringUtils.isBlank(entity.getUnit_id()) && StringUtils.isNotBlank(search) && search.length() >= 8) {
            entity.setUnit_id(search.substring(0, 8));
        }
        List<Jxpg_cbsEntity> list = dao.cbs_pg(entity);
        Map map = new HashMap<>();

        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", list);
        return map;
    }

    @Override
    public Map jxpg_cbs_ht(Jxpg_cbsEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);

        if (StringUtils.isBlank(entity.getUnit_id()) && StringUtils.isNotBlank(search) && search.length() >= 8) {
            entity.setUnit_id(search.substring(0, 8));
        }
        Map map = new HashMap<>();
        List<HtxxckEntity> list = new ArrayList<HtxxckEntity>();
        if (StringUtils.isBlank(entity.getTeam_id())) {

            list = dao.jxpg_cbs_ht(entity);
        } else {
            list = dao.jxpg_zyd_ht(entity);
        }
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select1(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select1(entity);
    }

    @Override
    public List<CbsFj6Entity> jxpg_cbs_one_select2(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select2(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select3(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select3(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select4(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select4(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_cbs_one_select5(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select5(entity);
    }

    @Override
    public String jxpg_cbs_one_select0(Jxpg_cbsEntity entity) {

        return dao.jxpg_cbs_one_select0(entity);
    }

    @Override
    public Map zyd_pg(Jxpg_cbsEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        if (StringUtils.isBlank(entity.getUnit_id()) && StringUtils.isNotBlank(search) && search.length() >= 8) {
            entity.setUnit_id(search.substring(0, 8));
        }
        Map map = new HashMap<>();
        List<Jxpg_cbsEntity> list = dao.zyd_pg(entity);
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select1(Jxpg_cbsEntity entity) {

        return dao.jxpg_zyd_one_select1(entity);
    }

    @Override
    public List<CbsFj6Entity> jxpg_zyd_one_select2(Jxpg_cbsEntity entity) {

        return dao.jxpg_zyd_one_select2(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select4(Jxpg_cbsEntity entity) {

        return dao.jxpg_zyd_one_select4(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_zyd_one_select5(Jxpg_cbsEntity entity) {

        return dao.jxpg_zyd_one_select5(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_newSelect1(Jxpg_Ht_DwEntity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect1(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_newSelect2(Jxpg_Ht_DwEntity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect2(entity);
    }

    @Override
    public List<CbsFj6Entity> jxpg_newSelect3(CbsFj6Entity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect3(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_newSelect4(Jxpg_Ht_DwEntity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect4(entity);
    }

    @Override
    public List<Jxpg_Ht_DwEntity> jxpg_newSelect5(Jxpg_Ht_DwEntity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect5(entity);
    }

    @Override
    public int jxpg_newSelect6(Jxpg_Ht_DwEntity entity) {
        // TODO Auto-generated method stub
        return dao.jxpg_newSelect6(entity);
    }
}
