package com.cyrj.jxzy.service.Constractor;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.cyrj.jxzy.dao.Constractor.*;
import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.AnnexEntity;
import com.cyrj.jxzy.entity.Constractor.DwryEntity;
import com.cyrj.jxzy.entity.Constractor.DwsbEntity;
import com.cyrj.jxzy.entity.Constractor.DwzzEntity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.PersonEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;
import com.cyrj.jxzy.util.ConfigureFileUtil;
import com.cyrj.jxzy.util.SetPageUtil;


@Service
public class AccessCardServiceImpl implements AccessCardServiceI {

    @Autowired
    private PcUnitCuopDao pcUnitCuopDao;
    @Autowired
    private QylrDao qylrDao;
    @Autowired
    private DwzzDao dwzzDao;
    @Autowired
    private DwsbDao dwsbDao;
    @Autowired
    private DwryDao dwryDao;
    @Autowired
    private ZysbDao zysbDao;
    @Autowired
    private PersonnelDao personDao;
    @Autowired
    private FjglDao annexDao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Map apply(String termid, String dwdm, String dwlbid) {

        DwzzEntity zz_entity = new DwzzEntity();
        zz_entity.setTermid(termid);
        zz_entity.setDwdm(dwdm);
        zz_entity.setDwlbid(dwlbid);

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();
        String search = userEntity.getSearch();

        zz_entity.setOilfield(oilfield);

        List<DwzzEntity> zz_entityList = new ArrayList<DwzzEntity>();
        ZysbEntity sb_entity = new ZysbEntity();//设备提取表
        PersonEntity person_entity = new PersonEntity();//人员提取
        List<ZysbEntity> sb_entityList = new ArrayList<ZysbEntity>();
        List<PersonEntity> person_entityList = new ArrayList<PersonEntity>();

        try {
            if (StringUtils.isNotBlank(zz_entity.getDwlb())) {
                zz_entity.setDwlb(java.net.URLDecoder.decode(zz_entity.getDwlb(), "UTF-8"));
            }
            if (StringUtils.isNotBlank(zz_entity.getJl())) {
                zz_entity.setJl(java.net.URLDecoder.decode(zz_entity.getJl(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        QylrEntity q = new QylrEntity();
        q.setDwdm(search);
        List<QylrEntity> list = qylrDao.selectZz1(q);
        String lb = "";
        if (list != null && list.size() > 0 && list.get(0) != null) {
            if (attribute.equals("1")) {
                //判断作业队伍能看到自己单位的经理姓名和电话
                zz_entity.setDwlbid(list.get(0).getDwlbid());
                zz_entity.setDwdm(list.get(0).getDwdm());
                zz_entity.setJl(list.get(0).getManager());
                zz_entity.setDh(list.get(0).getPhone());
            }
        }

        if (StringUtils.isNotBlank(zz_entity.getTermid())) {
            //查询设备一二
            sb_entity.setTermid(zz_entity.getTermid());
            sb_entityList = zysbDao.selectByParam(sb_entity);
            if (sb_entityList != null && sb_entityList.size() > 0 && sb_entityList.get(0) != null) {
                for (ZysbEntity jk : sb_entityList) {
                    if (StringUtils.isNotBlank(jk.getFileurl())) {
//                        jk.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE + jk.getFileurl());
                        jk.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE);
                    }
                }
            }
            //查询人员9人
            person_entity.setTermid(zz_entity.getTermid());
            person_entityList = personDao.select2(person_entity);
            if (person_entityList != null && person_entityList.size() > 0 && person_entityList.get(0) != null) {
                for (PersonEntity per : person_entityList) {
                    if (StringUtils.isNotBlank(per.getFileuri())) {
//                        per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE + per.getFileuri());
                        per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE );
                    }
                }
            }
        }
        zz_entityList = dwzzDao.select1(zz_entity);
        if (zz_entityList != null && zz_entityList.size() > 0 && zz_entityList.get(0) != null) {
            zz_entity.setFfbm(zz_entityList.get(0).getFfbm());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zz_entity", zz_entity);
        map.put("person_entityList", person_entityList);
        map.put("sb_entityList", sb_entityList);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;

    }


    @Override
    public Map<String, String> unit_select(String dwlbid) {
        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        QylrEntity qylr = new QylrEntity();
        qylr.setOilfield(oilfield);
        if (attribute.equals("1")) {
            //判断作业队伍能看到自己单位的经理姓名和电话
            qylr.setDwdm(search);
        }
        if (StringUtils.isNotBlank(dwlbid)) {//parentid
            qylr.setDwlbid(dwlbid);
        }
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<QylrEntity> entity_list_qy = qylrDao.selectByParam3(qylr);
        for (QylrEntity qylr1 : entity_list_qy) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", qylr1.getUnitname()); //key存名字
            map.put("value", qylr1.getDwdm());     //value存编号
            list.add(map);
        }

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }


    @Override
    public Map unit_select1(String parentid) {
        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (StringUtils.isNotBlank(parentid)) {
            pcUnitEntity.setParentid(parentid);
            List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam60(pcUnitEntity);
            for (PcUnitEntity pcUnit : entity_list_PcUnit) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", pcUnit.getUnitname()); //key存名字
                map.put("value", pcUnit.getId());     //value存编号
                list.add(map);
            }
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }


    @Override
    public Map unit_select11(String parentid) {
        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (StringUtils.isNotBlank(parentid)) {
            pcUnitEntity.setParentid(parentid);
            List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam61(pcUnitEntity);
            for (PcUnitEntity pcUnit : entity_list_PcUnit) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", pcUnit.getUnitname()); //key存名字
                map.put("value", pcUnit.getId());     //value存编号
                list.add(map);
            }
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;
    }


    @Override
    public Map totalRows4(String termid) {
        DwzzEntity zz_entity = new DwzzEntity();
        Map map = new HashMap();
        zz_entity.setTermid(termid);
        int rows = dwzzDao.countA1(zz_entity);
        map.put("code", 200);
        if (rows > 0) {
            map.put("msg", "该队伍准入证已存在，不能重复申请");
        } else {
            map.put("msg", "该队伍准入证不存在，可以申请");
        }
        map.put("data", rows);
        return map;
    }


    @Override
    public Map unit_select3() {
        List<Map<String, String>> treeNodes = new ArrayList<Map<String, String>>();
        AnnexEntity entity= new AnnexEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        List<AnnexEntity> entity_list_Annex = annexDao.selectA1(entity);
        for (AnnexEntity Annex : entity_list_Annex) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", Annex.getName()); //name存名字
            map.put("parentId", "0"); //name存名字
            map.put("id", Annex.getName());     //id存编号  Annex.getId().toString()
            treeNodes.add(map);
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", treeNodes);
        return resultMap;
    }


    @Override
    public Map select_manager(String parentid) {
        Map<String, Object> map = new HashMap<String, Object>();
        QylrEntity qylr = new QylrEntity();
        qylr.setDwdm(parentid);
        List<QylrEntity> list = qylrDao.selectZz2(qylr);
        if (list.size() > 0) {
            qylr = list.get(0);
        }
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", qylr);
        return map;
    }


    @Override
    @Transactional
    public Map accessCard_save(DwzzEntity zz_entity) {
        Map map = new HashMap();

        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        zz_entity.setOilfield(oilfield);
        String dwdm = zz_entity.getDwdm(), termid = zz_entity.getTermid(), dwzzbh = zz_entity.getDwzzbh();
        SimpleDateFormat f = new SimpleDateFormat("YYYYMMddHHmmsssss");
        int dd = (int) (Math.random() * 900 + 100);
        String sjid = "dwzz" + f.format(new Date()) + dd;
        int bz1 = 0, bz2 = 0, bz3 = 0;
        if (StringUtils.isNotBlank(zz_entity.getTermid())) {
            //0初次申请退回 、5换证退回
            zz_entity.setSjid(sjid);
            List<DwzzEntity> zz_entityList = dwzzDao.select2(zz_entity);
            if (zz_entityList != null && zz_entityList.size() > 0) {
                DwzzEntity zz = zz_entityList.get(0);
                zz_entity.setSjid(zz.getSjid());
                dwzzDao.update1(zz_entity);//删除退回数据,将退回的数据标记修改为6；audit_tab中6为删除标记
            }
        }
        zz_entity.setSjid(sjid);
        //为entity赋值   Audit_tab // 1待审核(申请)、3待审核(换证)
        if ("1".equals(zz_entity.getAudit_tab())) {
            zz_entity.setAudit_tab("1");
        } else {
            zz_entity.setAudit_tab("3");
        }
        DwryEntity zzry_entity = new DwryEntity();
        DwsbEntity zzsb_entity = new DwsbEntity();
        zz_entity.setSjid(sjid);
        zzry_entity.setSjid(sjid);
        zzsb_entity.setSjid(sjid);
        // 获取当前操作人员真实姓名
        String truename = userEntity.getUser_name();
        if (null != truename) {
            zz_entity.setLrr(truename);
        }
        List<PersonEntity> person_entityList = zz_entity.getPerson_entityList();
        List<ZysbEntity> sb_entityList = zz_entity.getSb_entityList();
        //保存上传的图片文件,人员保存
        List<DwryEntity> list_c = new ArrayList<DwryEntity>();
        //保存上传的图片文件,设备保存
        List<DwsbEntity> list_d = new ArrayList<DwsbEntity>();
        if (person_entityList != null && person_entityList.size() > 0 && sb_entityList != null && sb_entityList.size() > 0) {
            for (int i = 0; i < person_entityList.size(); i++) {
                PersonEntity qf = person_entityList.get(i);
                DwryEntity pe = new DwryEntity();
                pe.setOilfield(oilfield);
                pe.setLrr(userEntity.getUser_name());
                pe.setSjid(sjid);
                pe.setDwmc(dwdm);
                pe.setTermname(termid);
                pe.setDwzzbh(dwzzbh);
                pe.setGw(qf.getGw());
                pe.setXm(qf.getXm());
                pe.setSfzh(qf.getSfzh());
                pe.setXh(qf.getXh());
                pe.setJkzbh(qf.getJkzbh());
                pe.setFileuri(qf.getFileuri());
                list_c.add(pe);
            }
            zzry_entity.setEl(list_c);
            //PC_CBS_QUALIFICATION_PERSON 人员保存
            bz3 = dwryDao.insert1(zzry_entity);

            for (ZysbEntity qf : sb_entityList) {
                DwsbEntity dw = new DwsbEntity();
                dw.setOilfield(oilfield);
                dw.setCreate_user(userEntity.getUser_name());
                dw.setSjid(sjid);
                dw.setDwmc(dwdm);
                dw.setDwzzbh(dwzzbh);
                dw.setTermname(termid);
                dw.setSb(qf.getSb());
                dw.setSbbz(qf.getSbbz());
                dw.setFileurl(qf.getFileurl());
                dw.setXhjcs(qf.getXhjcs());
                dw.setZzcj(qf.getZzcj());
                dw.setCph(qf.getCph());
                dw.setSbm(qf.getSbm());
                list_d.add(dw);
            }
            zzsb_entity.setEl(list_d);

            //PC_CBS_QUALIFICATION_EQU 设备数据库保存
            bz2 = dwsbDao.insert1(zzsb_entity);

            //PC_CBS_QUALIFICATION_INFO 资质数据库保存
            bz1 = dwzzDao.insert(zz_entity);
            map.put("code", 200);
            if (bz1 != 0 && bz2 != 0 && bz3 != 0) {
                map.put("data", "1");
                map.put("msg", "保存成功。");
            } else {
                map.put("data", "2");
                map.put("msg", "出错了，保存失败。");
            }
        } else {
            map.put("data", "3");
            map.put("msg", "未接受到人员和设备数据，保存失败。");
        }
        return map;
    }


    @Override
    public Map accessCard_select(String dwdm, String audit_tab, Pager pager) {
        DwzzEntity zz_entity = new DwzzEntity();
        zz_entity.setDwdm(dwdm);
        zz_entity.setAudit_tab(audit_tab);
        Map<String, Object> map = new HashMap<String, Object>();
        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        zz_entity.setOilfield(oilfield);
        SetPageUtil.setPage(zz_entity, pager);
        List<DwzzEntity> zz_entityList = dwzzDao.select3(zz_entity);
        //总记录数
        int totalRows = dwzzDao.countA2(zz_entity);
        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    public Map apply_audit_select(DwzzEntity zz_entity, Pager pager) {
        Map<String, Object> map = new HashMap<String, Object>();

        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        zz_entity.setOilfield(oilfield);
        List<DwzzEntity> zz_entityList = null;

        SetPageUtil.setPage(zz_entity, pager);
        if (attribute.equals("1")) {
            //判断作业队伍能看到自己单位的经理姓名和电话
            zz_entity.setDwdm(search);
        } else {
            zz_entity.setDwdm("");
        }
        zz_entityList = dwzzDao.select4(zz_entity);
        //总记录数
        int totalRows = dwzzDao.countA3(zz_entity);
        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    public Map apply_audit(String sjid) {
        DwzzEntity zz_entity = new DwzzEntity();
        zz_entity.setSjid(sjid);
        List<DwzzEntity> zz_entityList = dwzzDao.select5(zz_entity);
        String[] sgxmArr=null;
        if (zz_entityList.size() > 0) {
            zz_entity = zz_entityList.get(0);
            String sgxm = zz_entity.getSgxm();
            if(StringUtils.isNotEmpty(sgxm)){
                sgxmArr = sgxm.split(",");
            }
        }
        DwryEntity zzry_entity = new DwryEntity();
        DwsbEntity zzsb_entity = new DwsbEntity();
        zzry_entity.setSjid(zz_entity.getSjid());
        zzsb_entity.setSjid(zz_entity.getSjid());
        List<DwryEntity> zzry_entityList = dwryDao.selectA1(zzry_entity);
        for (DwryEntity per : zzry_entityList) {
            if (StringUtils.isNotBlank(per.getFileuri())) {
//                per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE + per.getFileuri());
                per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE);
            }
        }

        List<DwsbEntity> zzsb_entityList = dwsbDao.selectA1(zzsb_entity);
        for (DwsbEntity sb : zzsb_entityList) {
            if (StringUtils.isNotBlank(sb.getFileurl())) {
//                sb.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE + sb.getFileurl());
                sb.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE );
            }
        }
        Map map = new HashMap();
        map.put("sgxmArr", sgxmArr);
        map.put("zz_entity", zz_entity);
        map.put("zzry_entityList", zzry_entityList);
        map.put("zzsb_entityList", zzsb_entityList);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }



    @Override
    public Map accessCard_print(DwzzEntity zz_entity) {


        DwryEntity zzry_entity = new DwryEntity();
        DwsbEntity zzsb_entity = new DwsbEntity();
        List<DwzzEntity> zz_entityList = dwzzDao.select5(zz_entity);
        if (zz_entityList.size() > 0) {
            zz_entity = zz_entityList.get(0);
        }
        zz_entity.setYear(zz_entity.getSyxq2().substring(0, 4));
        zzry_entity.setSjid(zz_entity.getSjid());
        zzsb_entity.setSjid(zz_entity.getSjid());

        List<DwryEntity> zzry_entityList = dwryDao.selectA1(zzry_entity);
        for (DwryEntity per : zzry_entityList) {
            if (StringUtils.isNotBlank(per.getFileuri())) {
//                per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE + per.getFileuri());
                per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE);
            }
        }

        List<DwsbEntity> zzsb_entityList = dwsbDao.selectA1(zzsb_entity);
        for (DwsbEntity sb : zzsb_entityList) {
            if (StringUtils.isNotBlank(sb.getFileurl())) {
//                sb.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE + sb.getFileurl());
                sb.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE);

                if ("1".equals(sb.getSbbz())) {
                    zzsb_entity.setFileurl21(sb.getFileurl());
                }
                if ("2".equals(sb.getSbbz())) {
                    zzsb_entity.setFileurl22(sb.getFileurl());
                }
            }
        }

        Map map = new HashMap();
        map.put("zzsb_entityList", zzsb_entityList);
        map.put("zzry_entityList", zzry_entityList);
        map.put("zz_entity", zz_entity);
        map.put("zzsb_entity", zzsb_entity);

        Map resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public Map audit_sava(DwzzEntity zz_entity) {

        Map map = new HashMap();
        map.put("code", 200);
        //获取oilfield
        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        zz_entity.setOilfield(oilfield);

        try {
            if (StringUtils.isNotBlank(zz_entity.getTermid()) && StringUtils.isNotBlank(zz_entity.getAudit_tab())) {
                if ("2".equals(zz_entity.getAudit_tab())) {
                    dwzzDao.update2(zz_entity);
                }
            }
            //获取当前操作人员真实姓名
            String truename = userEntity.getUser_name();
            //保存审核记录
            zz_entity.setShr(truename);
            //更改能力评估申请表中审核状态
            dwzzDao.update3(zz_entity);
            map.put("data", "1");
            map.put("msg", "保存成功！");

        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败，请重新保存！");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map apply_InReview_select(DwzzEntity zz_entity, Pager pager) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<DwzzEntity> zz_entityList = null;

        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        zz_entity.setOilfield(oilfield);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        String whc = "";


        SetPageUtil.setPage(zz_entity, pager);
        if (attribute.equals("1")) {
            //判断作业队伍能看到自己单位的经理姓名和电话
            zz_entity.setDwdm(search);
        } else {
            zz_entity.setDwdm("");
        }
        zz_entityList = dwzzDao.select4(zz_entity);
        //总记录数
        int totalRows = dwzzDao.countA3(zz_entity);

        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public Map apply_completed_select(DwzzEntity zz_entity, Pager pager) {

        Map map = new HashMap();
        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        zz_entity.setOilfield(oilfield);
        SetPageUtil.setPage(zz_entity, pager);
        if (attribute.equals("1")) {
            //判断作业队伍能看到自己单位的经理姓名和电话
            zz_entity.setDwdm(search);
        } else {
            zz_entity.setDwdm("");
        }

        List<DwzzEntity> zz_entityList = dwzzDao.select7(zz_entity);
        //总记录数
        int totalRows = dwzzDao.countA4(zz_entity);

        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    public Map apply_fail_select(DwzzEntity zz_entity, Pager pager) {

        Map map = new HashMap();

        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        zz_entity.setOilfield(oilfield);

        if ("1".equals(attribute)) {
            zz_entity.setDwdm(search);
        } else {
            zz_entity.setDwdm("");
        }
        SetPageUtil.setPage(zz_entity, pager);
        List<DwzzEntity> zz_entityList = dwzzDao.select8(zz_entity);
        //总记录数
        int totalRows = dwzzDao.countA5(zz_entity);
        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    public Map changeCertificate_select(DwzzEntity zz_entity, Pager pager) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<DwzzEntity> zz_entityList = null;
        ///获取用户角色
        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        zz_entity.setOilfield(oilfield);
        String whc = "";
        if (attribute.equals("1")) {
            //判断作业队伍能看到自己单位的经理姓名和电话
            zz_entity.setDwdm(search);
        } else {
            zz_entity.setDwdm("");
        }
        SetPageUtil.setPage(zz_entity, pager);
        zz_entityList = dwzzDao.select9(zz_entity);
        int totalRows = dwzzDao.countA6(zz_entity);
        // 拼成所需数据返回前台
        map.put("totalRows", totalRows);
        map.put("rows", zz_entityList);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    public Map changeCertificate(DwzzEntity zz_entity) {

        //获取用户角色
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        zz_entity.setOilfield(oilfield);
        int rows = dwzzDao.countA7(zz_entity);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        if(rows>0){
            resultMap.put("msg", "有待审核换证申请，不可重复申请");
        }else {
            resultMap.put("msg", "允许换证申请");
        }
        resultMap.put("data", rows);
        return resultMap;
    }


    @Override
    public Map jiechu(DwzzEntity zz_entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            dwzzDao.jiechu(zz_entity);
            map.put("data", "1");
            map.put("msg", "废除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
        }

        return map;
    }


    @Override
    public Map feichu( DwzzEntity zz_entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            dwzzDao.feichu(zz_entity);
            map.put("data", "1");
            map.put("msg", "废除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
        }

        return map;
    }

    @Override
    public Map changeCertificate_thisTeam_select(DwzzEntity zz_entity ) {

        List<DwzzEntity> zz_entityList = null;
        List<ZysbEntity> sb_entityList = null;
        List<PersonEntity> person_entityList = null;
        zz_entityList = dwzzDao.select5(zz_entity);
        String[] sgxmArr=null;
        if(zz_entityList.size()>0){
            zz_entity = zz_entityList.get(0);
            String sgxm = zz_entity.getSgxm();
            if(StringUtils.isNotEmpty(sgxm)){
                sgxmArr = sgxm.split(",");
            }
        }

        if(StringUtils.isNotBlank(zz_entity.getTermid())){
            ZysbEntity sb_entity = new ZysbEntity();
            PersonEntity person_entity = new PersonEntity();
            //查询设备一二
            sb_entity.setTermid(zz_entity.getTermid());
            sb_entityList = zysbDao.selectByParam(sb_entity);
            if(sb_entityList!=null&&sb_entityList.size()>0&&sb_entityList.get(0)!=null){
                for(ZysbEntity jk:sb_entityList){
                    if(StringUtils.isNotBlank(jk.getFileurl())){
//                        jk.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE+jk.getFileurl());
                        jk.setFileurl2(ConfigureFileUtil.DQJXZYIMAGE);
                    }
                }
            }
            //查询人员9人
            person_entity.setTermid(zz_entity.getTermid());
            person_entityList = personDao.select2(person_entity);
            if(person_entityList!=null&&person_entityList.size()>0&&person_entityList.get(0)!=null){
                for (PersonEntity per : person_entityList) {
                    if(StringUtils.isNotBlank(per.getFileuri())){
//                        per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE+per.getFileuri());
                        per.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE);
                    }
                }
            }
        }
      Map map = new HashMap();
        map.put("sgxmArr", sgxmArr);
        map.put("sb_entityList",sb_entityList);
        map.put("person_entityList",person_entityList);
        map.put("zz_entity",zz_entity);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

}
