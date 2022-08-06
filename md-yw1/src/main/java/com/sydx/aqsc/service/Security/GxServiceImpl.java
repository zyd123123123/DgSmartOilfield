package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.dao.Security.GxDao;
import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.UserHeaderEntity;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.util.Common;
import com.sydx.aqsc.util.SetPageUtil;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GxServiceImpl implements GxServiceI {

    @Autowired
    private GxDao gxDao;
    @Autowired
    private HttpServletRequest request;

    private List<Map> list = new ArrayList<Map>();

    @Override
    public Map initComplate(GxEntity gx, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        gx.setOilfield(oilfield);
        int totalRows = gxDao.selectCount(gx);// 查询总记录
        SetPageUtil.setPage(gx, pager);
        List<GxEntity> gxs = gxDao.findAll(gx);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", gxs);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public Map initParam(GxcsEntity entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        List<GxcsEntity> gxs = gxDao.findAll2(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", gxs);
        return map;
    }

    @Override
    public List<SgdyEntity> sgdy_tiqu(int spid1) {
        SgdyEntity entity = new SgdyEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setYtid(oilfield);
        entity.setSpid(spid1);
        List<SgdyEntity> list = gxDao.sgdyList(entity);

        return list;
    }

    @Override
    public Map sgdySave(SgdyEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        //获取油田id
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setYtid(oilfield);
        entity.setLrr(username);
        try {
            if (StringUtils.isNotBlank(entity.getSpid().toString())) {
                List<SgdyEntity> list = entity.getEntityList();
                //生成自定义模板id
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                for (SgdyEntity ae : list) {
                    if (StringUtils.isBlank(ae.getSgdyid())) {
                        String date = sdf.format(new Date());
                        int dd = (int) (Math.random() * 900 + 100);
                        String sgdyid = date + dd;
                        ae.setSgdyid(sgdyid);
                    }
                }
                gxDao.sgdyDelect(entity);
                gxDao.sgdyInsert(entity);
                map.put("data", "1");
                map.put("msg", "保存成功。");
            } else {
                map.put("data", "0");
                map.put("msg", "id未接收，保存失败。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "数据库异常，保存失败。");
        }

        return map;
    }

    @Override
    public List<Map<String, Object>> hseSelect(GxHseEntity entity) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<GxHseEntity> gxHseEntities = gxDao.hseSelect(entity);

        for (GxHseEntity en : gxHseEntities) {
            Map<String, Object> map = new HashMap<>();
            map.put("key", en.getHsename());
            map.put("value", en.getHseid());
            list.add(map);
        }
        return list;
    }

    @Override
    public Map gxSelect(GxEntity entity) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> listEntity = gxDao.findAll(entity);
        for (GxEntity gx : listEntity) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("key", gx.getSpname());
            map.put("value", gx.getSpid());
            list.add(map);
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public List<GxHseEntity> gxhseList(GxHseEntity entity) {
        return gxDao.gxhseList(entity);
    }

    @Override
    @Transactional
    public Map hse_bd_save(GxHseEntity entity) {
        Map map = new HashMap();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            gxDao.hse_bdDelete(entity);
            gxDao.hse_bdInsert(entity);
            map.put("code", "1");
        } catch (Exception e) {
            map.put("code", "0");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<GxHseEntity> hsenr(GxHseEntity entity) {

        return gxDao.hsenrSelect(entity);
    }

    @Override
    public Map sgdyList(SgdyEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setYtid(oilfield);
        List<SgdyEntity> list = gxDao.sgdyList(entity);
        Map map = new HashMap<String, Object>();
        map.put("rows", list);
        return map;
    }

    @Override
    public Map gx_sgdy_list(SgdyEntity entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setYtid(oilfield);
        List<SgdyEntity> list = gxDao.gx_sgdy_list(entity);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    @Transactional
    public Map addSave(GxEntity gx) {
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        try {
            //查询工序最大id
            String xh = gxDao.selectMaxId(gx);
            int xhn = 0;
            if (xh == null) {
                xhn = 1;
            } else {
                xhn = Integer.parseInt(xh);
                xhn = xhn + 1;
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String username = userEntity.getUser_name();
            ;
            for (GxEntity a : gx.getEntityList()) {
                a.setIs_extra(gx.getIs_extra());
                a.setIs_use("1");
                a.setSpid(xhn);
                a.setOilfield(oilfield);
                a.setState(0);
                a.setUser_id(username);
                gxDao.insertGx(a);
                xhn++;

                //工序施工内容标准模板
                GxnrmbEntity entity = new GxnrmbEntity();
                entity.setOilfield(oilfield);

                //通用模板自定义名称即使工序名称
                entity.setSpid(a.getSpid());
                entity.setSpname(a.getSpname());
                entity.setCustomname(a.getSpname());
                resultMap.put("msg", "成功");
                resultMap.put("data", "1");
            }
        } catch (Exception e) {
            resultMap.put("data", "0");
            resultMap.put("msg", "保存失败。");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resultMap;
    }

    @Override
    public Map editAll(GxEntity gx) {
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            gx.setOilfield(oilfield);
            gxDao.updateGx(gx);
            resultMap.put("msg", "成功");
            resultMap.put("data", "1");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("data", "0");
            resultMap.put("msg", "保存失败。");
        }

        return resultMap;
    }

    @Override
    public List<GxEntity> paramSele(GxEntity gx, Integer spid, String spname, HttpSession session) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        gx.setOilfield(oilfield);
        return gxDao.selectById(gx);
    }

    @Override
    public Map circuitSelect(GxEntity entity) {
        Map resultMap = new HashMap();
        List<Map<String, String>> list = new ArrayList<>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> gxEntities = gxDao.circuitSelect(entity);
        for (GxEntity entity1 : gxEntities) {
            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getSpname());
            map.put("value", Integer.toString(entity1.getSpid()));
            map.put("suggest", entity1.getSpname());// 模糊查询条件
            list.add(map);
        }
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public Map sgdySelect(SgdyEntity entity) {
        List<Map<String, String>> list = new ArrayList<>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<SgdyEntity> gxEntities = gxDao.sgdySelect(entity);
        for (SgdyEntity entity1 : gxEntities) {
            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getSgdymc());
            map.put("value", entity1.getSgdyid());
            map.put("suggest", entity1.getSgdymc());// 模糊查询条件
            list.add(map);
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public List<Map<String, String>> tygxSelect(GxEntity entity) {

        List<Map<String, String>> list = new ArrayList<>();

        List<GxEntity> gxEntities = gxDao.tygxSelect(entity);
        for (GxEntity entity1 : gxEntities) {
            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getCircuit_name());
            map.put("value", entity1.getCircuit_id());
            map.put("suggest", entity1.getCircuit_name());// 模糊查询条件
            list.add(map);
        }
        return list;
    }


    @Override
    public Map gx_mb_addSave(GxnrmbEntity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        map.put("data", "1");
        map.put("msg", "保存成功。");
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        ;
        try {

            if (StringUtils.isNotBlank(entity.getCustomid())) {

                entity.setLast_user(username);
                gxDao.updateGxProcess(entity);
            } else {

                if (StringUtils.isEmpty(entity.getCustomtype())) {
                    entity.setCustomtype(oilfield);
                }
                //通用模板自定义名称即使工序名称
//                entity.setCustomname(entity.getSpname());
                //生成自定义模板id
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                String customid = date + dd;
                entity.setCustomid(customid);
                //录入人姓名
                entity.setCreate_user(username);
                gxDao.insertGxProcess(entity);
            }
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map gx_mb_remove(GxnrmbEntity entity) {

        Map<String, String> map = new HashMap<String, String>();

        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String username = userEntity.getUser_name();
            entity.setLast_user(username);
            gxDao.gx_mb_remove(entity);
            map.put("code", "1");
            map.put("msg", "废除成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "出错误啦，请重新操作。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map getPParamJSON(GxnrmbEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        entity.setCreate_user(username);
        //查询模板
        GxnrmbEntity gxnr = gxDao.gxmbSelect(entity);

        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("entity", gxnr);
        return map;
    }


    @Override
    public List<Map<String, String>> getCslb() {
        GxEntity bz = new GxEntity();
        List<GxEntity> bzsj = gxDao.select();
        List<Map<String, String>> shuju = new ArrayList<Map<String, String>>();
        for (GxEntity d : bzsj) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", d.getEng_code());
            map.put("key", d.getEng_code());
            shuju.add(map);
        }
        return shuju;
    }

    @Override
    public Map removeSave(GxEntity gx) {
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        try {
            gxDao.removeSave(gx);
            resultMap.put("data", "1");
            resultMap.put("msg", "删除成功");
        } catch (Exception e) {
            resultMap.put("data", "0");
            resultMap.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }
        return resultMap;
    }


    @Override
    public Map sgmbdzList(SgmbdzEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        entity.setCreate_user(username);
        String unitid = userEntity.getUnitid();
        if (unitid.length() > 8) {
            entity.setCustomtype(unitid.substring(0, 8));
        } else {
            entity.setCustomtype(unitid);
        }
        //总记录数
        int totalRows = gxDao.countSgmbdz(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgmbdzEntity> list = gxDao.listSgmbdz(entity);
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
    public Map sgmbdzSave(SgmbdzEntity entity) {

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            String unitid = userEntity.getUnitid();
            if (entity.getTab().equals("3")) {
                entity.setCustomtype(unitid.substring(0, 8));
            } else {
                entity.setCustomtype(oilfield);
            }

            //生成自定义模板id
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
            String date = sdf.format(new Date());
            int dd = (int) (Math.random() * 900 + 100);
            String templateid = date + dd;
            entity.setTemplateid(templateid);

            //插入主表数据
            gxDao.sgmbdzInsert1(entity);
            //插入定制工序数据表
            gxDao.sgmbdzInsert2(entity);

            resultMap.put("data", "1");
            resultMap.put("msg", "保存成功。");
        } catch (Exception e) {

            e.printStackTrace();
            resultMap.put("data", "0");
            resultMap.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resultMap;
    }

    @Override
    public SgmbdzEntity sgmbdzEditSelect(SgmbdzEntity entity) {
        return gxDao.sgmbdzEditSelect(entity);
    }

    @Override
    public List<SgmbdzEntity> sgmbdzEditList(SgmbdzEntity entity) {
        return gxDao.sgmbdzEditList(entity);
    }

    @Override
    public Map sgmbdzEditSave(SgmbdzEntity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            entity.setLast_user(username);

            //更改主表数据
            gxDao.updateSgmbdzEdit(entity);
            //删除原定制工序数据
            gxDao.deleteSgmbdzEdit(entity);
            //插入定制工序数据
            gxDao.sgmbdzInsert2(entity);


            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data", "0");
            map.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return map;
    }

    @Override
    public Map sgmbdzRemoveSave(SgmbdzEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            //查询当前模板是否已绑定作业类型
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            List<ZylxEntity> list = gxDao.zylxselect(entity);
            if (list.size() > 0) {
                StringBuffer sb = new StringBuffer();
                for (ZylxEntity zylx : list) {
                    sb.append(zylx.getZylx() + "，");
                }
                String str = sb.toString();
                if (str.length() > 0) {

                    str = str.substring(0, str.lastIndexOf("，"));
                }
                map.put("data", "0");
                map.put("msg", "该模板已绑定\"" + str + "\"，不可废除。");
            } else {
                gxDao.sgmbdzRemove(entity);
                map.put("data", "1");
                map.put("msg", "废除成功。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data", "0");
            map.put("msg", "废除失败。");
        }
        return map;
    }

    @Override
    public Map sgmbbdList(ZylxEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        int totalRows = gxDao.sgmbbdCount(entity);
        SetPageUtil.setPage(entity, pager);
        List<ZylxEntity> list = gxDao.sgmbbdList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", list);
        return map;
    }

    @Override
    public List<Map<String, String>> jbSelect(MeasureEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<MeasureEntity> list = gxDao.jbSelect(entity);
        List<Map<String, String>> li = new ArrayList<Map<String, String>>();
        for (MeasureEntity en : list) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", en.getName());
            map.put("value", en.getId());
            li.add(map);
        }
        return li;
    }

    @Override
    public Map csSelect(MeasureEntity entity, String tab, String templateid) {
        Map resultMap = new HashMap();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<MeasureEntity> li = gxDao.csSelect(entity);
        List<Map> list = new ArrayList<>();
        for (MeasureEntity entity1 : li) {
            if (entity1.getParentid().equals(oilfield)) {
                Map map = new HashMap();
                map.put("id", entity1.getId());
                map.put("label", entity1.getName());
                List<Map> childenList = digui(li, entity1.getId());
                map.put("children", childenList);
                list.add(map);
            }
        }
        List<String> checklist = new ArrayList<>();
        if ("1".equals(tab)) {
            checklist = gxDao.checkSelect(entity, templateid);
        }
        Map map = new HashMap();
        map.put("alllist", list);
        map.put("checklist", checklist);

        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    public List<Map> digui(List<MeasureEntity> li, String id) {
        List<Map> list = new ArrayList<>();
        for (MeasureEntity entity : li) {
            if (entity.getParentid().equals(id)) {
                Map map = new HashMap();
                map.put("id", entity.getId());
                map.put("label", entity.getName());
                List<Map> childenList = digui(li, entity.getId());
                map.put("children", childenList);
                list.add(map);
            }
        }
        return list;
    }

    public int digui2(List<MeasureEntity> li, String id, String tab) {
        int i = 0;
//        for (MeasureEntity entity : li) {
//            if (entity.getParentid().equals(id)) {
//
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("id", entity.getId());
//                map.put("name", entity.getName());
//                map.put("parentId", entity.getParentid());
//                map.put("open", "false");
//                if (StringUtils.isNotBlank(entity.getChecked())) {
//                    map.put("checked", "true");
//                }
//                list.add(map);
//                int k = digui(li, entity.getId(), tab);
//                if (tab.equals("1") && k > 0) {
//                    map.put("clickExpand", "true");
//                }
//                i++;
//            }
//        }
        return i;
    }

    @Override
    public List<Map<String, String>> gxmbSelect(SgmbbdEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String username = userEntity.getUser_name();
        ;
        entity.setOilfield(oilfield);
        entity.setCreate_user(username);

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<SgmbdzEntity> list_entity = gxDao.gxmbList(entity);
        for (SgmbdzEntity entity1 : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", entity1.getTemplateid());
            if (StringUtils.isBlank(entity1.getPurpose())) {
                map.put("key", entity1.getTemplatename() + "——" + entity1.getTabs());
                map.put("suggest", entity1.getTemplatename() + "——" + entity1.getTabs());// 模糊查询条件
            } else {
                map.put("key", entity1.getTemplatename() + "(" + entity1.getPurpose() + ")——" + entity1.getTabs());
                map.put("suggest", entity1.getTemplatename() + "(" + entity1.getPurpose() + ")——" + entity1.getTabs());// 模糊查询条件
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public Map sgmbbdSave(SgmbbdEntity entity) {

        HashMap<String, String> map = new HashMap<String, String>();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String username = userEntity.getUser_name();
            entity.setOilfield(oilfield);
            entity.setCreate_user(username);
            gxDao.sgmbbdInsert(entity);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<SgmbdzEntity> sgmbList(SgmbbdEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        entity.setCreate_user(username);
        return gxDao.sgmbList(entity);
    }

    @Override
    public Map sgmbbdRemove(SgmbbdEntity entity) {

        HashMap<String, String> map = new HashMap<String, String>();

        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String username = userEntity.getUser_name();
            entity.setOilfield(oilfield);
            entity.setLast_user(username);
            gxDao.sgmbbdRemove(entity);

            map.put("code", "1");
            map.put("msg", "撤销成功。");
        } catch (Exception e) {

            map.put("code", "0");
            map.put("msg", "撤销失败。");
            e.printStackTrace();
        }
        return map;
    }

    //标准工序维护分页查询
    @Override
    public Map getGxwh(HttpServletRequest request, HttpServletResponse response, GxEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        int totalRows = gxDao.selectCount(entity);
        List<GxEntity> entityList = gxDao.getGxwh(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("entityList", entityList);
        return map;
    }

    //修改页面跳转数据加载change

    @Override
    public String change(GxEntity entity, HttpSession session, Model model) {
        String jump = "";
        GxEntity obj = gxDao.gxwh_ById(entity);
        model.addAttribute("entity", obj);
        jump = "Security/gx/bzgxwh_edit";
        return jump;
    }

    @Override
    public void update(GxEntity entity) {
        gxDao.update(entity);
    }

    @Override
    public void batch_insert(WorkHoursEntity entity) {
//				for (int i=0;i<entity.getEntityList().size();i++){
//					int id = entity.getEntityList().get(i).getSpid();
//					String name = entity.getEntityList().get(i).getSpname();
//					double ys = entity.getEntityList().get(i).getUse_hours();
//					double gs = entity.getEntityList().get(i).getWorking_hours();
//					double xs = entity.getEntityList().get(i).getCoefficient();
//				}

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        entity.getEntityList();
        entity.setEl(entity.getEntityList());
        //先删除后增加
        gxDao.delete_workhours(entity);
        gxDao.batch_insert(entity);
    }

    @Override
    public Map sgmbbd_zylx_List(SgmbbdEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        SetPageUtil.setPage(entity, pager);
        int totalRows = gxDao.gmbbd_zylx_count(entity);
        List<SgmbbdEntity> list = gxDao.sgmbbd_zylx_List(entity);
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
    public SgmbbdEntity zylxName(SgmbbdEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        return gxDao.zylxName(entity);
    }

    @Override
    public Map sgmbbd_zylx_addSave(SgmbbdEntity entity) {


        Map map = new HashMap();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            //复合设计
            if ("2".equals(entity.getTab())) {
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                String jb = "";
                for (SgmbbdEntity entity1 : entity.getEntity_list()) {
                    sb1.append(entity1.getCsid() + ",");
                    sb2.append(entity1.getZylx() + ",");
                    jb = entity1.getJb();
                }

                String csid = sb1.toString();
                csid = csid.substring(0, csid.length() - 1);
                String zylx = sb2.toString();
                zylx = zylx.substring(0, zylx.length() - 1);
                SgmbbdEntity entity2 = new SgmbbdEntity();
                entity2.setCsid(csid);
                entity2.setZylx(zylx);
                entity2.setJb(jb);
                //生成自定义模板id
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                String bindingid = date + dd;
                entity2.setBindingid(bindingid);

                List<SgmbbdEntity> list = new ArrayList<>();
                list.add(entity2);
                entity.setEntity_list(list);
            } else {
                //生成自定义模板id
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                for (SgmbbdEntity entity1 : entity.getEntity_list()) {
                    String date = sdf.format(new Date());
                    int dd = (int) (Math.random() * 900 + 100);
                    String bindingid = date + dd;
                    entity1.setBindingid(bindingid);
                }
            }
            gxDao.sgmbbd_zylx_addSave(entity);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {

            map.put("code", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map sgmbbd_zylx_remove(SgmbbdEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            gxDao.sgmbbd_zylx_remove(entity);
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {

            map.put("data", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    @Transactional
    public Map sgmbbd_zylx_Save_tree(String templateid, String tab, String str) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String username = userEntity.getUser_name();

        Map map = new HashMap();
        map.put("code", 200);
        try {
            SgmbbdEntity sgmbbdentity = new SgmbbdEntity();
            sgmbbdentity.setOilfield(oilfield);
            sgmbbdentity.setCreate_user(username);
            sgmbbdentity.setTemplateid(templateid);
            JSONArray jsonArray = JSONArray.fromObject(str);
            Collection<String> collection = JSONArray.toCollection(jsonArray, String.class);
            List<SgmbbdEntity> list = new ArrayList<>();
            //生成自定义模板id
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
            if ("2".equals(tab)) {//复合措施
                for (String id : collection) {
                    SgmbbdEntity entity = new SgmbbdEntity();
                    entity.setCsid(id);
                    list.add(entity);
                }
                //查询拼接复合设计措施id及作业类型
                sgmbbdentity.setEntity_list(list);
                SgmbbdEntity zylx = gxDao.zylx(sgmbbdentity);
                //保存
                sgmbbdentity.setJb(list.get(0).getCsid().substring(0, 1));
                sgmbbdentity.setCsid(zylx.getCsid());
                sgmbbdentity.setZylx(zylx.getZylx());
                sgmbbdentity.setIs_use("1");
                sgmbbdentity.setIs_fh("2");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                String bindingid = date + dd;
                sgmbbdentity.setBindingid(bindingid);
                sgmbbdentity.setTemplateid(templateid);
                list = new ArrayList<>();
                list.add(sgmbbdentity);
                sgmbbdentity.setEntity_list(list);
                gxDao.sgmbbd_zylx_addSave(sgmbbdentity);
            } else if ("1".equals(tab)) {
                for (String id : collection) {
                    SgmbbdEntity entity = new SgmbbdEntity();
                    entity.setCsid(id);
                    entity.setIs_use("1");
                    entity.setIs_fh(tab);
                    String date = sdf.format(new Date());
                    int dd = (int) (Math.random() * 900 + 100);
                    String bindingid = date + dd;
                    entity.setBindingid(bindingid);
                    list.add(entity);
                }
                gxDao.sgmbbd_remove(sgmbbdentity);
                if (list.size() > 0) {
                    sgmbbdentity.setEntity_list(list);
                    gxDao.sgmbbd_Save(sgmbbdentity);
                }
            }
            map.put("data", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map gxwh_list(GxEntity entity) {
        List<GxEntity> entityList = new ArrayList();
        entityList = gxDao.gxwh_list(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entityList", entityList);
        return map;
    }

    @Override
    public Map use_hours(GxEntity entity) {
        Map map = new HashMap();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String unitid = userEntity.getUnitid();
        ;
        entity.setUnit_id(unitid.substring(0, 11));
        GxEntity entity1 = gxDao.use_hours(entity);
        if (entity1 == null) {
            entity1 = entity;
        }
        map.put("date", entity1);
        return map;
    }

    @Override
    public List<GxcsEntity> gxsgcs(GxcsEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String unit_id = userEntity.getUnitid();

        if (unit_id.length() > 8) {
            unit_id = unit_id.substring(0, 8);
        }
        entity.setUnit_id(unit_id);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        return gxDao.gxsgcs(entity);
    }

    @Override
    @Transactional
    public Map saveParamBd(GxcsEntity gx) {
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "保存失败。");
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        gx.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        ;
        gx.setCreate_user(username);
        try {
            for (GxcsEntity a : gx.getEntityList()) {
                if (a.getIs_show_oil() != null && a.getIs_show_oil().length() > 0) {
                    a.setIs_show_oil("1");
                }
                if (a.getIs_null_oil() != null && a.getIs_null_oil().length() > 0) {
                    a.setIs_null_oil("1");
                }
            }
            gxDao.removeParamBd(gx);
            gxDao.saveParamBd(gx);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {

            map.put("code", "0");
            map.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<SgdygjclEntity> gjclList(SgdygjclEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        return gxDao.gjclList(entity);
    }

    @Override
    @Transactional
    public Map<String, String> gjclSave(SgdygjclEntity entity) {

        Map<String, String> map = new HashMap<String, String>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String userid = userEntity.getUser_name();
        String oilfield = userEntity.getOilfield();
        entity.setCreate_user(userid);
        entity.setOilfield(oilfield);
        try {

            gxDao.gjclDelete(entity);
            gxDao.gjclSave(entity);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map gx_mb_list(GxEntity entity) {

        Map<String, Object> map = new HashMap<String, Object>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> list = gxDao.gx_mb_list(entity);
        map.put("rows", list);
        return map;
    }

    @Override
    public Map sgdy_List(SgdyEntity entity, Pager pager) {
        Map resultMap = new HashMap();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            int totalRows = gxDao.sgdy_count(entity);// 查询总记录
            SetPageUtil.setPage(entity, pager);
            List<SgdyEntity> list = gxDao.sgdy_List(entity);
            Map map = new HashMap();
            map.put("totalRows", totalRows);
            map.put("rows", list);
            resultMap.put("code", 200);
            resultMap.put("msg", "成功");
            resultMap.put("data", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    @Override
    public Map sgdy_Save(SgdyEntity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        //获取油田id
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        entity.setCreate_user(username);
        try {

            List<SgdyEntity> list = entity.getEntityList();
            //生成自定义模板id
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
            for (SgdyEntity ae : list) {
                if (StringUtils.isBlank(ae.getSgdyid())) {
                    String date = sdf.format(new Date());
                    int dd = (int) (Math.random() * 900 + 100);
                    String sgdyid = date + dd;
                    ae.setSgdyid(sgdyid);
                }
            }
            gxDao.sgdy_Save(entity);
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "数据库异常，保存失败。");
        }

        return map;
    }

    @Override
    public Map sgdy_remove(String sgdyid) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
//            JSONArray jsonArray = JSONArray.fromObject(shuzu);
//            List<SgdyEntity> list =(List<SgdyEntity>) JSONArray.toCollection(jsonArray, SgdyEntity.class);
            SgdyEntity entity1 = new SgdyEntity();
            entity1.setSgdyid(sgdyid);
            List<SgdyEntity> list = new ArrayList<>();
            list.add(entity1);
            SgdyEntity entity = new SgdyEntity();
            entity.setEntityList(list);
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String username = userEntity.getUser_name();
            entity.setLast_user(username);
            gxDao.sgdy_remove(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<SgdyEntity> sgdy_editAllSelect(String shuzu) {
        JSONArray jsonArray = JSONArray.fromObject(shuzu);
        List<SgdyEntity> list = (List<SgdyEntity>) JSONArray.toCollection(jsonArray, SgdyEntity.class);
        SgdyEntity entity = new SgdyEntity();
        entity.setEntityList(list);
        return gxDao.sgdy_editAllSelect(entity);
    }

    @Override
    public List<SgdyEntity> sgdy_editSelect(SgdyEntity entity) {
        return gxDao.sgdy_editSelect(entity);
    }

    @Override
    public Map sgdy_editAll_Save(SgdyEntity entity) {
        Map<String, String> map = new HashMap<String, String>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        //获取油田id
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        entity.setLast_user(username);
        try {
            gxDao.sgdy_editAll_Save(entity);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("code", "0");
            map.put("msg", "数据库异常，保存失败。");
        }
        return map;
    }

    @Override
    public Map sgdy_edit_Save(SgdyEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        //获取油田id
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        entity.setLast_user(username);
        try {
            gxDao.sgdy_edit_Save(entity);
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "数据库异常，保存失败。");
        }
        return map;
    }

    @Override
    public List<SgdygjclEntity> sgdy_gjcl_List(SgdygjclEntity entity) {
        //获取油田id
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        return gxDao.sgdy_gjcl_List(entity);
    }

    @Override
    public List<SgdygjclEntity> sgdy_gjcl_editList(SgdygjclEntity entity) {
        //获取油田id
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        return gxDao.sgdy_gjcl_editList(entity);
    }

    @Override
    @Transactional
    public Map<String, String> sgdy_gjclSave(SgdygjclEntity entity) {
        Map<String, String> map = new HashMap<String, String>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String userid = userEntity.getUser_name();
        String oilfield = userEntity.getOilfield();
        entity.setCreate_user(userid);
        entity.setOilfield(oilfield);
        try {

            gxDao.sgdy_gjclSave(entity);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map sgdy_gx_editSave(SgdyEntity entity) {
        Map map = new HashMap();
        try {
            gxDao.sgdy_gx_editSave(entity);
            map.put("code", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("code", "1");
            map.put("msg", "保存失败");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map sgdy_gx_List(SgdyEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        int totalRows = gxDao.sgdy_gx_count(entity);// 查询总记录
        SetPageUtil.setPage(entity, pager);
        List<SgdyEntity> list = gxDao.sgdy_gx_List(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", list);
        return map;
    }

    @Override
    public List<GxcsEntity> sgdy_param_view_list(GxcsEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String unit_id = userEntity.getUnitid();
        if (unit_id.length() > 8) {
            unit_id = unit_id.substring(0, 8);
        }
        entity.setUnit_id(unit_id);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        return gxDao.sgdy_param_view_list(entity);
    }

    @Override
    @Transactional
    public Map sgdy_param_Save(GxcsEntity gx) {
        Map map = new HashMap();
        map.put("code", "0");
        map.put("msg", "保存失败。");
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        gx.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        ;
        gx.setCreate_user(username);
        try {
            for (GxcsEntity a : gx.getEntityList()) {
                if (a.getIs_show_oil() != null && a.getIs_show_oil().length() > 0) {
                    a.setIs_show_oil("1");
                }
                if (a.getIs_null_oil() != null && a.getIs_null_oil().length() > 0) {
                    a.setIs_null_oil("1");
                }
            }
            gxDao.sgdy_param_Save(gx);
            map.put("code", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {

            map.put("code", "0");
            map.put("msg", "保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map sgdy_mb_list(GxEntity entity) {

        Map<String, Object> map = new HashMap<String, Object>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> list = gxDao.sgdy_mb_list(entity);
        map.put("rows", list);
        return map;
    }

    @Override
    public Map sgdy_mb_select(GxnrmbEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        entity.setCreate_user(username);
        GxnrmbEntity gxnr = null;
        gxnr = gxDao.sgdy_mbSelect(entity);
        GxcsEntity entitycs = new GxcsEntity();
        entitycs.setCircuit_id(entity.getCircuit_id());
        entitycs.setSgdyid(entity.getSgdyid());
        entitycs.setOilfield(oilfield);
        List<GxcsEntity> all2 = gxDao.sgdy_paramSelect(entitycs);

        String bstr = gxnr.getBuildcontent();
        if (!"".equals(bstr) && null != bstr) {

            int f = 0;
            for (GxcsEntity ppe : all2) {
                bstr = bstr.replace("${" + ppe.getTable_head_chs() + "}", "<span id='id" + f++ + "' style=\"width:70px;\" contenteditable=\"false\">${" + ppe.getTable_head_chs() + "}</span>");
            }
            gxnr.setBuildcontentTMP(bstr);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", gxnr);
        map.put("entity_param_list", all2);
        return map;
    }

    @Override
    public Map<String, String> sgdy_mb_addSave(GxnrmbEntity entity) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "1");
        map.put("msg", "保存成功。");
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String username = userEntity.getUser_name();
        ;
        try {
            if (StringUtils.isNotBlank(entity.getCustomid())) {
                entity.setLast_user(username);
                gxDao.sgdy_mb_update(entity);
            } else {
                //通用模板自定义名称即使工序名称
//                entity.setCustomname(entity.getSpname());
                //生成自定义模板id
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                String customid = date + dd;
                entity.setCustomid(customid);
                //录入人姓名
                entity.setCreate_user(username);
                gxDao.sgdy_mb_Insert(entity);
            }
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map sgdy_mb_remove(GxnrmbEntity entity) {

        Map<String, String> map = new HashMap<String, String>();

        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String username = userEntity.getUser_name();
            entity.setLast_user(username);
            gxDao.sgdy_mb_remove(entity);
            map.put("code", "1");
            map.put("msg", "废除成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "出错误啦，请重新操作。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map sgdy_aqhbys(SgdyEntity entity) {
        Map map1 = new HashMap();
        List<SgdyEntity> list_entity = gxDao.sgdy_editSelect(entity);
        if (list_entity != null && list_entity.size() > 0) {
            entity = list_entity.get(0);
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", "主要设备");
            map.put("value", entity.getZysb());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "配套设备");
            map.put("value", entity.getPtsb());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "人员要求");
            map.put("value", entity.getRyyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "井控要求");
            map.put("value", entity.getJkyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "安全要求");
            map.put("value", entity.getAqyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "环保要求");
            map.put("value", entity.getHbyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "工艺及质量要求");
            map.put("value", entity.getGyjzlyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "设备要求");
            map.put("value", entity.getSbyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "资料要求");
            map.put("value", entity.getZlyq());
            list.add(map);
            map = new HashMap<String, String>();
            map.put("name", "变更管理");
            map.put("value", entity.getBggl());
            list.add(map);

            map1.put("rows", list);
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map1);
        return resultMap;

    }

    @Override
    public Map gx_sgdy_bdSave(SgdyEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        //获取油田id
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setYtid(oilfield);
        entity.setLrr(username);
        try {
            if (StringUtils.isNotBlank(entity.getSpid().toString())) {
                gxDao.gx_sgdy_bdSave(entity);
                map.put("data", "1");
                map.put("msg", "保存成功。");
            } else {
                map.put("data", "0");
                map.put("msg", "id未接收，保存失败。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "数据库异常，保存失败。");
        }
        return map;
    }

    @Override
    public Map zylSelect(ZylxEntity entity) {


        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        List<ZylxEntity> zylx_list = gxDao.zylSelect(entity);
        List<Map<String, String>> list = new ArrayList<>();
        for (ZylxEntity en : zylx_list) {
            Map<String, String> map = new HashMap<>();
            map.put("key", en.getZylx());
            map.put("value", en.getZylx());
            list.add(map);
        }

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }

    @Override
    public Map cs_list(ZylxEntity entity) {
        Map map = new HashMap();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        List<ZylxEntity> zylx_list = gxDao.zylSelect(entity);
        map.put("rows", zylx_list);
        return map;
    }

    @Override
    public List<Gx_lbEntity> gx_lb_wh_List(Gx_lbEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();//单位代码
        entity.setOilfield(oilfield);
        return gxDao.gx_lb_wh_List(entity);
    }

    @Override
    public Map gx_lb_wh_Save(Gx_lbEntity entity) {
        Map map = new HashMap();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();//单位代码
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setCreate_user(username);
            if (entity.getEntityList() != null && entity.getEntityList().size() > 0) {
                for (Gx_lbEntity entity1 : entity.getEntityList()) {
                    if (StringUtils.isEmpty(entity1.getId())) {
                        //生成自定义模板id
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
                        String date = sdf.format(new Date());
                        int dd = (int) (Math.random() * 900 + 100);
                        String id = date + dd;
                        entity1.setId(id);
                    }
                }
                gxDao.gx_lb_wh_Save(entity);
            }
            map.put("code", "1");
        } catch (Exception e) {
            map.put("code", "0");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> getgxlb(GxEntity entity) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> listEntity = gxDao.getgxlb(entity);
        for (GxEntity gx : listEntity) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("key", gx.getGxlb());
            map.put("value", gx.getGxlb());
            list.add(map);
        }
        return list;
    }
}
