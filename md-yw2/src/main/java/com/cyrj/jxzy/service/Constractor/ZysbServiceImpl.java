package com.cyrj.jxzy.service.Constractor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.cyrj.jxzy.dao.Constractor.ZysbDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class ZysbServiceImpl implements ZysbService {

    @Autowired
    private ZysbDao dao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Map<String, Object> showList(ZysbEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        if (attribute.equals("1")) {
            entity.setDwdm(search);
        }
        //总记录数
        int totalRows = dao.countShow(entity);
        SetPageUtil.setPage(entity, pager);
        List<ZysbEntity> list = dao.listShow(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    @Transactional
    public Map  updateSave(ZysbEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);

            String userid = userEntity.getUser_name();
            entity.setLrr(userid);
            if ("1".equals(entity.getSbbz())) {
                entity.setSb("设备一");
            } else {
                entity.setSb("设备二");
            }

            if (StringUtils.isNotBlank(entity.getZysbid())) {
                //删除当前所修改数据
                dao.deleteUpdateSave(entity);
                dao.insertUpdateSave(entity);
                map.put("data", "1");
                map.put("msg", "修改成功。");
            } else {

                map.put("data", "0");
                map.put("msg", "未接收到设备id，修改失败。");
            }


        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，修改失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }


        return map;
    }

    @Override
    public List<Map<String, String>> termSelect_Zysb(String dwdm) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<ZysbEntity> entity_list = dao.listTermSelect_Zysb(dwdm);
        for (ZysbEntity zys : entity_list) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", zys.getTermname()); //key存名字
            map.put("value", zys.getTermid());     //value存编号
            list.add(map);
        }

        return list;
    }

    @Override
    @Transactional
    public Map  insertSave(ZysbEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String userid = userEntity.getUser_name();
            entity.setLrr(userid);

            List<ZysbEntity> entity_list = entity.getEntity_list();
            if (entity_list.size() > 0) {

                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
                for (ZysbEntity jk : entity_list) {

                    if (StringUtils.isNotBlank(jk.getSbbz())) {
                        if ("1".equals(jk.getSbbz())) {
                            jk.setSb("设备一");
                        } else {
                            jk.setSb("设备二");
                        }
                    }
//                    if (StringUtils.isBlank(jk.getZysbid())) {
                        String date = sdf.format(new Date());
                        int dd = (int) (Math.random() * 900 + 100);
                        String zysbid = "ZYSB" + date + dd; //合同ID
                        jk.setZysbid(zysbid);
//                    }

                }
                ZysbEntity entity1 = entity_list.get(1);
                if (StringUtils.isBlank(entity1.getXhjcs()) && StringUtils.isBlank(entity1.getZzcj()) &&
                        StringUtils.isBlank(entity1.getTcrq()) && StringUtils.isBlank(entity1.getCph()) && StringUtils.isBlank(entity1.getSbm())) {
                    List<ZysbEntity> el = new ArrayList<ZysbEntity>();
                    el.add(entity_list.get(0));
                    entity.setEntity_list(el);
                } else {
                    entity.setEntity_list(entity_list);
                }
                dao.delete(entity);
                dao.insertSave(entity);
                map.put("data", "1");
                map.put("msg", "保存成功。");

            } else {


                map.put("data", "0");
                map.put("msg", "未接受到数据，保存失败。");
            }
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<Map<String, String>> unit_select() {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        QylrEntity qylr = new QylrEntity();
        qylr.setOilfield(oilfield);

        if (attribute.equals("1")) {
            qylr.setDwdm(search);
        }


        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<QylrEntity> entity_list_qy = dao.unit_select(qylr);

        for (QylrEntity qylr1 : entity_list_qy) {

            Map<String, String> map = new HashMap<String, String>();

            map.put("key", qylr1.getUnitname()); //key存名字
            map.put("value", qylr1.getDwdm());     //value存编号
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, String>> term_select(String id) {

        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (StringUtils.isNotBlank(id)) {
            pcUnitEntity.setParentid(id);
            List<PcUnitEntity> entity_list_PcUnit = dao.term_select(pcUnitEntity);
            for (PcUnitEntity pcUnit : entity_list_PcUnit) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", pcUnit.getUnitname()); //key存名字
                map.put("value", pcUnit.getId());     //value存编号
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public List<ZysbEntity> updateSelect(ZysbEntity entity) {

        return dao.selectByParam(entity);
    }

}
