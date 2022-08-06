package com.sydx.aqsc.service.Security;

import com.sydx.aqsc.dao.Security.SgbbDao;
import com.sydx.aqsc.entity.Admin.Pager;
import com.sydx.aqsc.entity.Admin.PcUnitEntity;
import com.sydx.aqsc.entity.Admin.UserHeaderEntity;
import com.sydx.aqsc.entity.Security.*;
import com.sydx.aqsc.util.Common;
import com.sydx.aqsc.util.CommonUtil;
import com.sydx.aqsc.util.SetPageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@Service
public class SgbbServiceImpl implements SgbbServiceI {

    @Autowired
    private SgbbDao sgbbDao;
//    @Autowired
//    private ParamTableDao paramDao;
    @Autowired
    private HttpServletRequest request;

    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();

    @Override
    public String tab_select() {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String url = "";
        if (oilfield.equals("pc0jd")) {
            url = "Security/sgdtjd/bbcj_list";
        } else if (oilfield.equals("pc0dq")) {
            url = "Security/sgdt/sgbb_select";
        }
        return url;
    }

    @Override
    public Map sgbbList(SgbbEntity entity, Pager pager) {

        if (entity.getWell_common_name() != null && entity.getWell_common_name().length() > 0) {
            entity.setWell_common_name(entity.getWell_common_name().toUpperCase());
        }

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();
        String search = userEntity.getSearch();
        entity.setAttribute(attribute);
        entity.setSearch(search);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        //总记录数
        int totalRows = sgbbDao.countSgbb(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> list = sgbbDao.listSgbb(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);
        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public Map reportWorkoveSelect(ReportWorkoveEntity entity) {

        entity.setReport_time(entity.getReport_time().trim());
        List<ReportWorkoveEntity> list_entity = sgbbDao.reportWorkoveSelect(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        if (list_entity.size() > 0) {
            map.put("code", "1");
            map.put("date", list_entity.get(0).getBb_id());
            map.put("entity_list", list_entity);
        } else {
            map.put("code", "0");
        }
        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public List<ReportWorkoveEntity> rbAddVeiwSelect2(ReportWorkoveEntity entity) {
        return sgbbDao.rbAddVeiwSelect2(entity);
    }

    @Override
    public List<Map<String, String>> sgbzgxList(ReportWorkoveEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<RbEntity> list_entity = sgbbDao.sgbzgxList(entity);
        for (RbEntity rbEntity : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", rbEntity.getSpname());
            map.put("value", rbEntity.getSpid() + "." + rbEntity.getPdid());
            list.add(map);
        }
        return list;
    }


    @Override
    public List<Map<String, String>> allgxList(ReportWorkoveEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> list_entity = sgbbDao.allgxList(entity);
        for (GxEntity rbEntity : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", rbEntity.getSpname());
            map.put("value", rbEntity.getSpid() + ".0" );
            list.add(map);
        }
        return list;
    }

    @Override
    public Map getProcessParamJSON(RbEntity rb) {

        Map<String, Object> map = new HashMap<String, Object>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        rb.setOilfield(oilfield);
        GxEntity gx = new GxEntity();

        //查询施工模板id,pdid!=0 根据pdid从施工步骤工序表查询,pdid==0 附加工序，查询通用模板;
        gx.setCustomid(rb.getCustomid());
        gx.setSpid(rb.getSpid());
        gx.setOilfield(oilfield);
        List<GxEntity> gxlist = sgbbDao.processParamSelect1(rb);// 根据工序id，查询通用及自定义个性施工模板
        List<Map> selList= new ArrayList<>();
        // 选择模板的sel
        String sels = "{\"list\":[";
        int is = 0;
        int tab = 0;
        String buildcontentTMP = "";
        for (GxEntity pe : gxlist) {
            if (pe.getSpname() == null || "null".equals(pe.getSpname())) {
                pe.setSpname("");
            }
            sels += "{\"value\":\"" + is + "\",\"key\":\"" + pe.getCustomname() + "\"}";
            Map selmap = new HashMap();
            selmap.put("value",is);
            selmap.put("key",pe.getCustomname());
            selList.add(selmap);

            String buildcontent = pe.getBuildcontent();
            pe.setBuildcontentTMP(buildcontent);
            if (pe.getCustomid().equals(gx.getCustomid())) {    //可不用
                buildcontentTMP = pe.getBuildcontentTMP();
                tab = is;
            }
            is++;
            if (is < gxlist.size()) {
                sels += ",";
            }
        }
        if (StringUtils.isNoneBlank(buildcontentTMP)) {
            gx.setBuildcontentTMP(buildcontentTMP);
        } else {
            if (gxlist != null && gxlist.size() > 0) {
                gx.setCustomid(gxlist.get(0).getCustomid());
                gx.setBuildcontentTMP(gxlist.get(0).getBuildcontentTMP());
            }
        }
        gx.setSels(sels + "]}");
        map.put("entity_list", gxlist);
        map.put("entity", gx);
        map.put("tab", tab);
        map.put("selList", selList);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;

    }

    @Override
    public List<Map<String, String>> tbrSelect(TeamEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<TeamEntity> list_entity = sgbbDao.tbrSelect(entity);
        for (TeamEntity en : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", en.getXm());
            map.put("value", en.getXm());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, String>> cadreSelect(TeamEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<TeamEntity> list_entity = sgbbDao.cadreSelect(entity);
        for (TeamEntity en : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", en.getXm());
            map.put("value", en.getXm());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, String>> monitorSelect(TeamEntity entity) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<TeamEntity> list_entity = sgbbDao.monitorSelect(entity);
        for (TeamEntity en : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", en.getXm());
            map.put("value", en.getXm());
            list.add(map);
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> savePPData(Map<String, String> map) {

        Map<String, Object> map1 = new HashMap<String, Object>();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            String oilfield = userEntity.getOilfield();
            String circuit_table = map.get("circuit_table");
            String did = map.get("did");
            String report_time = map.get("report_time");
            String order_classes = map.get("order_classes");
            Integer spid = Integer.parseInt(map.get("spid"));
            Integer pdid = Integer.parseInt(map.get("pdid"));
            String parame_val_num = map.get("parame_val_num");
            RbEntity rb = new RbEntity();
            rb.setOilfield(oilfield);
            rb.setDid(did);
            rb.setReport_time(report_time.trim());
            rb.setOrder_classes(order_classes);
            rb.setSpid(spid);
            rb.setCircuit_table(circuit_table);
            rb.setParame_val_num(parame_val_num);
            //删除施工参数数据
            sgbbDao.removePPData(rb);
            if (StringUtils.isBlank(parame_val_num)) {
//				RbEntity rbentity1 = sgbbDao.selectXh(rb);//
//				if(rbentity1!=null&&rbentity1.getXh()!=0) {
//					xh=rbentity1.getXh()+1;
//				}else {
//					xh=1;
//				}
                //拼接附件ID
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                parame_val_num = date + dd;

            }

            String ip = ""; //录入ip
            try {
                ip = InetAddress.getLocalHost().toString();
                ip = ip.split("/")[1];
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            //保存施工参数数据
            String whc = "insert into " + circuit_table + " (OILFIELD,parame_val_num,ip, tab,";
            Set<Entry<String, String>> sets = map.entrySet();
            for (Entry<String, String> entry : sets) {
                if (!entry.getKey().equals("content") && !entry.getKey().equals("buildcontent") && !entry.getKey().equals("circuit_table") && !entry.getKey().equals("customid") && !entry.getKey().equals("parame_val_num")) {
                    whc += entry.getKey() + ",";
                }
            }

            whc += "CREATE_USER,CREATE_TIME) values ('" + oilfield + "'," + parame_val_num + ",'" + ip + "','1',";
            for (Entry<String, String> entry : sets) {
                if (!entry.getKey().equals("content") && !entry.getKey().equals("buildcontent") && !entry.getKey().equals("circuit_table") && !entry.getKey().equals("customid") && !entry.getKey().equals("parame_val_num")) {
                    if (entry.getValue().equals("spid")) {
                        whc += entry.getValue() + ",";
                    } else {
                        whc += "'" + entry.getValue() + "',";
                    }
                }
            }
            whc += "'" + userid + "',sysdate)";
//			System.out.println(whc);
            rb.setWhc(whc);
            sgbbDao.savePPData(rb);
            map1.put("parame_val_num", parame_val_num);
            map1.put("code", "1");
            map1.put("msg", "保存成功");
        } catch (Exception e) {
            map1.put("code", "0");
            map1.put("msg", "保存失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map1;

    }

    @Override
    @Transactional
    public Map  sgbbSave(ReportWorkoveEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            if (entity.getEntity_list() == null || entity.getEntity_list().size() == 0) {

                map.put("data", "0");
                map.put("msg", "没有施工工序，保存失败。");
                return map;
            }

            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            String oilfield = userEntity.getOilfield();
//            String ip = ""; //录入ip
//            try {
//                ip = InetAddress.getLocalHost().toString();
//                ip = ip.split("/")[1];
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//            entity.setIp(ip);
            entity.setCreate_user(userid);
            entity.setOilfield(oilfield);
//            entity.setTeam_name(entity.getTeam_name().substring(entity.getTeam_name().lastIndexOf(".") + 1));
            entity.setWork_date(entity.getWork_date().trim());
            entity.setReport_time(entity.getWork_date());
            //更改开工井及搬家计划表开完工日期
            System.out.println(entity.getDid()+"//////////////////////////");
            sgbbDao.sgbbSaveupdate1(entity);

            // 班报ID
            if (StringUtils.isBlank(entity.getBb_id())) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmssSSS");
                String today = df.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                entity.setBb_id("BB" + "_" + today + dd);
            }

            //删除班报
            sgbbDao.sgbbSavedelete1(entity);

            //判断ID最大值
            int id = sgbbDao.sgbbSaveselect3(entity);
            for (ReportWorkoveEntity a : entity.getEntity_list()) {
                id += 1;
                a.setId(id);
            }
            //保存工序
            sgbbDao.sgbbSaveinsert1(entity);

            //日报保存
//			entity.setJh(entity.getWell_common_name());
//			entity.setRq(entity.getWork_date());
//			entity.setLogin_people(userid);
//			entity.setLogin_ip(ip);
//			List<ReportWorkoveEntity> list=sgbbDao.rbgx_cx(entity);
//			String gx_rb="";
//			for(ReportWorkoveEntity gx:list){
//				gx_rb+=gx.getCircuit_name()+",";
//			}
//			System.out.println(gx_rb.substring(0,gx_rb.lastIndexOf(",")));
//			entity.setText(gx_rb.substring(0,gx_rb.lastIndexOf(",")));
//			sgbbDao.removeRb(entity);
//			sgbbDao.insertRb(entity);

            map.put("data", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map  bbckList(ReportWorkoveEntity entity) {

        if (entity.getWell_common_name() != null && entity.getWell_common_name().length() > 0) {
            entity.setWell_common_name(entity.getWell_common_name().toUpperCase());
        }
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<SgbbEntity> sgbbs = sgbbDao.bbckList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", sgbbs);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public Map  lsbb(ReportWorkoveEntity entity) {

        if (entity.getWell_common_name() != null && entity.getWell_common_name().length() > 0) {
            entity.setWell_common_name(entity.getWell_common_name().toUpperCase());
        }
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());

        List<SgbbEntity> sgbbs = sgbbDao.lsbb(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", sgbbs);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public List<ReportWorkoveEntity> sgbbChaKan(ReportWorkoveEntity entity) {
        return sgbbDao.sgbbChaKan(entity);
    }

    @Override
    public List<ReportWorkoveEntity> bbxg(ReportWorkoveEntity entity) {
        return sgbbDao.bbxg(entity);
    }

    @Override
    public List<BcwhEntity> bcList(BcwhEntity entity) {

        List<BcwhEntity> bcwhEntities = sgbbDao.bcList(entity);
        if (bcwhEntities.size() == 0) {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setUnitid(oilfield);
            bcwhEntities = sgbbDao.bcList(entity);
        }
        return bcwhEntities;
    }

    @Override
    public String bbqx(String did) {

        return sgbbDao.bbqx(did);
    }

    @Override
    public Map wgqr(CompleteReportEntity entity) {

        Map map = new HashMap();
        map.put("code", "1");
        //结算单审核通过的井不能修改完工日期
        int ysjs = sgbbDao.ysjs(entity);
        if (ysjs > 0) {
            map.put("code", "0");
            map.put("msg", "该井结算单已经审核通过，不能修改完工日期;如果要修改，请先联系厂级管理员退回结算单");
            return map;
        }
        //判断井下作业公司是否有施工设计，
        CompleteReportEntity jxsgsj1 = sgbbDao.jxsgsj1(entity);
        if (jxsgsj1 != null && !"1".equals(jxsgsj1.getHas_sgsj())) {//没有授权，无施工设计不能完工
            //gysj_add表查询工程设计
            List<CompleteReportEntity> list = sgbbDao.jxsgsj2(entity);
            if (list.size() > 0 && StringUtils.isNotBlank(list.get(0).getSprq()) && list.get(0).getSprq().compareTo("2019-08-10") > 0) {
                //查询是否有工程设计
                List<CompleteReportEntity> list1 = sgbbDao.jxsgsj3(entity);
                if (list1.size() == 0) {
                    map.put("code", "0");
                    map.put("msg", "请联系井下分公司创建施工设计或者找井下分工司管理员金宏光解除限制");
                    return map;
                }
            }
        }

        return map;
    }

    @Override
    public Map reportData(CompleteReportEntity entity) {

        Map map = new HashMap();

        //查询施工总结表数据
        CompleteReportEntity entity1 = sgbbDao.reportData1(entity);

        if ("1A".equals(entity1.getCcfs())) {
            entity1.setCcfsmc("抽油机");
        }
        if ("1E".equals(entity1.getCcfs())) {
            entity1.setCcfsmc("螺杆泵");
        }
        if ("1B".equals(entity1.getCcfs())) {
            entity1.setCcfsmc("电泵");
        }

        //查询gysj_add表，判断大修、压裂、酸化、带压、井别
        List<CompleteReportEntity> list = sgbbDao.reportData2(entity);
        for (CompleteReportEntity entity2 : list) {
            if ("大修".equals(entity2.getCsdl()) || "顶驱修井".equals(entity2.getCsxl()) || "顶驱修井".equals(entity2.getCslb())) {
                entity1.setDxpd1("1");
            }
            if ("酸化".equals(entity2.getCsxl())) {
                entity1.setShpd1("1");
            }
            if ("压裂".equals(entity2.getCsxl())) {
                entity1.setShyl1("1");
            }
            if ("是".equals(entity2.getSfdy())) {//是否带压
                entity1.setSfdy1("1");
            }
            if ("1".equals(entity2.getJbdm())) {//井别判断
                entity1.setJbpd1("1");
            }
        }
        //查询报表数据
        CompleteReportEntity entity3 = sgbbDao.reportData3(entity);
        if (entity3 == null) {
            entity3 = new CompleteReportEntity();
        }
        //查询酸化数据
        List<CompleteReportEntity> list1 = sgbbDao.reportData4(entity);
        //查询工程作业类型
        List<CompleteReportEntity> list2 = sgbbDao.reportData5(entity);
        if (list2.size() == 0) {
            list2 = sgbbDao.reportData6(entity);
        }
//		list2.add(list2.get(0));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());

        map.put("today", today);//当前日期
        map.put("entity1", entity1);//施工总结数据
        map.put("entity3", entity3);//报表数据
        map.put("list1", list1);//报表酸化数据
        map.put("list2", list2);//查询工程作业类型
        return map;
    }

    @Override
    public List<Map<String, String>> cslx(MeasureEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        List<MeasureEntity> cslx = sgbbDao.cslx(entity);

        List<Map<String, String>> list = new ArrayList<>();
        for (MeasureEntity entity1 : cslx) {
            Map<String, String> map = new HashMap<>();
            map.put("value", entity1.getId());
            map.put("key", entity1.getName());
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map> zyyy(CompleteReportEntity entity, String domain_level, String domain_code) {

        List<Map> list = new ArrayList<>();
        String sql = "";
        if ("1".equals(domain_level)) {

            if ("1A".equals(entity.getCcfs())) {//抽油机
                sql = "AND DOMAIN_LEVEL='1' and domain_code in('01000000','09000000')";
            } else if ("1B".equals(entity.getCcfs())) {//电泵
                sql = "AND DOMAIN_LEVEL='1' and  domain_code in('02000000','09000000')";
            } else if ("1E".equals(entity.getCcfs())) {//螺杆泵
                sql = "AND DOMAIN_LEVEL='1' and domain_code in('03000000','09000000')";
            } else if ("3".equals(entity.getJbdm())) {
                sql = "AND DOMAIN_LEVEL='1' and domain_code not in('01000000','02000000','03000000')";
            } else {
                sql = "AND DOMAIN_LEVEL='1' and domain_code  in('09000000')";
            }

        } else if ("2".equals(domain_level)) {
            if (StringUtils.isBlank(domain_code)) {
                return null;
            }
            sql = "AND DOMAIN_LEVEL='" + domain_level + "' and domain_code  like '%" + domain_code.substring(0, 2) + "%'";
        } else if ("3".equals(domain_level)) {
            if (StringUtils.isBlank(domain_code)) {
                return null;
            }
            sql = "AND DOMAIN_LEVEL='" + domain_level + "' and domain_code  like '%" + domain_code.substring(0, 4) + "%'";
        } else if ("4".equals(domain_level)) {
            if (StringUtils.isBlank(domain_code)) {
                return null;
            }
            sql = "AND DOMAIN_LEVEL='" + domain_level + "' and domain_code  like '%" + domain_code.substring(0, 6) + "%'";
        }
        List<Map<String, String>> list1 = sgbbDao.zyyy(sql);
        for (Map<String, String> map : list1) {
            Map<String, String> map1 = new HashMap<>();
            map1.put("key", map.get("NAME"));
            map1.put("value", map.get("CODE"));
            list.add(map1);
        }

        return list;
    }

    //泵规范
    @Override
    public List<Map> bgf(String ccfs) {
        List<Map> list = new ArrayList<>();
        List<String> bxx = sgbbDao.bgf(ccfs);
        for (String str : bxx) {
            Map<String, String> map1 = new HashMap<>();
            map1.put("key", str);
            map1.put("value", str);
            list.add(map1);
        }
        return list;
    }

    //泵类型
    @Override
    public List<Map> bxx() {

        List<Map> list = new ArrayList<>();
        List<String> bxx = sgbbDao.bxx();
        for (String str : bxx) {
            Map<String, String> map1 = new HashMap<>();
            map1.put("key", str);
            map1.put("value", str);
            list.add(map1);
        }
        return list;
    }

    @Override
    public Map yz_bxx(String id) {

        Map map = new HashMap();
        int num = sgbbDao.yz_bxx(id);
        map.put("num", num);
        return map;
    }

    @Override
    @Transactional
    public Map bbSave(CompleteReportEntity entity) {
        Map map = new HashMap();
        try {
            String complete_time = entity.getComplete_time();
            if (StringUtils.isBlank(complete_time)) {//完工日期为空时
                //删除报表数据
                sgbbDao.bbSaveRemove1(entity);
            } else {
                //查询施工总结表数据
                CompleteReportEntity entity1 = sgbbDao.bbSaveSelect1(entity);
                //修改完工日期
                String user = request.getHeader("user");
                UserHeaderEntity userEntity = Common.getUserHeader(user);
                String username = userEntity.getUser_name();
                String unitid = userEntity.getUnitid();
                String unitname = userEntity.getUnitname();
                entity.setUsername(username);
                //修改施工总结表完工日期
                sgbbDao.bbSaveUpdate1(entity);
                //删除报表、酸化表数据
                sgbbDao.bbSaveRemove2(entity);

                entity.setWell_common_name(entity1.getWell_common_name());
                entity.setWell_id(entity1.getWell_id());
                entity.setStart_time(entity1.getStart_time());
                entity.setOp_team(entity1.getOp_team());
                entity.setSgdwmc(entity1.getSgdwmc());
                entity.setSsdwdm(entity1.getSsdwdm());
                if (!"1".equals(entity.getJbpd1())) {
                    CompleteReportEntity entity3 = sgbbDao.bbSaveSelect2(entity);
                    entity.setStim_i_appraise(entity3.getStim_i_appraise());
                    entity.setStim_ii_appraise(entity3.getStim_ii_appraise());
                    entity.setStim_iii_appraise(entity3.getStim_iii_appraise());
                    entity.setStim_iiii_appraise(entity3.getStim_iiii_appraise());
                }
                //保存报表数据
                sgbbDao.bbSaveInsert1(entity);
                if ("1".equals(entity.getShpd1())) {
                    List<CompleteReportEntity> entityList2 = entity.getEntityList2();
                    if (entityList2 != null && entityList2.size() > 0) {
                        //查询酸化表最大id
                        int id = sgbbDao.cwid();
                        for (CompleteReportEntity entity3 : entityList2) {
                            id = id + 1;
                            entity3.setCwid(id);
                            entity3.setConstruction_id(entity.getConstruction_id());
                            entity3.setWell_common_name(entity.getWell_common_name());
                        }
                        entity.setEntityList2(entityList2);
                        //保存酸化数据
                        sgbbDao.bbSaveInsert2(entity);
                    }
                }
                //是否带压
                if (StringUtils.isBlank(entity1.getIs_under_pressure())) {
                    if ("1".equals(entity.getSfdy1())) {
                        entity1.setIs_under_pressure("是");
                    }
                }
                //根据well_id井型
                List<Map> list = sgbbDao.bbSaveSelect3(entity1);
                String domain_description = "";
                if (list != null && list.size() > 0) {
                    Object obj = list.get(0).get("DOMAIN_DESCRIPTION");
                    if (obj != null) {
                        domain_description = obj.toString();

                    }
                }

                ArrayList<String> neibu = new ArrayList<String>();//内部队伍
                neibu.add("pc0dq023001");
                neibu.add("pc0dq023002");
                neibu.add("pc0dq023003");
                neibu.add("pc0dq023004");
                neibu.add("pc0dq023005");
                neibu.add("pc0dq023006");
                neibu.add("pc0dq023007");
                neibu.add("pc0dq023008");
                neibu.add("pc0dq023009");
                neibu.add("pc0dq023010");
                neibu.add("pc0dq023011");
                neibu.add("pc0dq023012");
                neibu.add("pc0dq023013");
                neibu.add("pc0dq023073");
                //内部外部队伍
                String dwsx = "";
                if (entity1.getOp_team().length() >= 8 && neibu.indexOf(entity1.getOp_team().substring(0, 11)) == -1 && "pc0dq023".indexOf(entity1.getOp_team().substring(0, 8)) != -1) {
                    dwsx = "out";
                } else {
                    dwsx = "in";
                }
                List<CompleteReportEntity> entitylist1 = entity.getEntityList1();
                if (entitylist1 != null && entitylist1.size() > 0) {
                    for (CompleteReportEntity entity4 : entitylist1) {
                        entity4.setConstruction_id(entity.getConstruction_id());
                        entity4.setWell_common_name(entity.getWell_common_name());
                        entity4.setNode_name("AQSCHTML日报完工参数插入，施工单位代码为：" + entity1.getOp_team() + "施工单位名称为:" + entity1.getSgdwmc());
                        entity4.setUnitid(unitid);
                        entity4.setUsername(username);
                        entity4.setUnitname(unitname);
                        entity4.setDesign_num(entity1.getDesign_num());
                        entity4.setWell_id(entity1.getWell_id());
                        entity4.setWell_purpose(entity1.getWell_purpose());
                        entity4.setJbdm(entity1.getJbdm());
                        entity4.setCydid(entity1.getCydid());
                        entity4.setStart_time(entity1.getStart_time());
                        entity4.setComplete_time(entity.getComplete_time());
                        String design_imei = Calendar.getInstance().getTimeInMillis() + "";
                        entity4.setDesign_imei(design_imei);
                        entity4.setDesign_num(entity1.getDesign_num());
                        entity4.setIs_under_pressure(entity1.getIs_under_pressure());
                        entity4.setReason(domain_description);//井型
                        entity4.setOp_team(entity1.getOp_team());
                        entity4.setSgdwmc(entity1.getSgdwmc());
                        //查询措施一类、二类、三类、四类，措施名称
                        CompleteReportEntity cslx = sgbbDao.bbSaveSelect4(entity4);
                        String gl = "";
                        if ("大修".equals(cslx.getCsdl_mc())) {
                            gl = cslx.getCsxl_mc();
                        } else if ("新井投产".equals(cslx.getCsdl_mc()) || "新井投注".equals(cslx.getCsdl_mc())) {
                            gl = cslx.getCsdl_mc();
                        } else if ("抽油泵".equals(cslx.getCsxl_mc()) || "螺杆泵".equals(cslx.getCsxl_mc()) || "电泵".equals(cslx.getCsxl_mc())) {
                            gl = cslx.getCslb_mc();
                        } else {
                            gl = cslx.getCsxl_mc();
                        }
                        entity4.setCsdl_mc(cslx.getCsdl_mc());
                        entity4.setCsxl_mc(cslx.getCsxl_mc());
                        entity4.setCslb_mc(cslx.getCslb_mc());
                        entity4.setCssil_mc(cslx.getCssil_mc());
                        entity4.setTypes_classified(gl);
                        //根据sjid去gysj_dd查询驱动方式、采出方式等数据
                        CompleteReportEntity entity5 = sgbbDao.bbSaveSelect5(entity4);
                        entity4.setCcfs(entity5.getCcfs());
                        entity4.setCcfsmc(entity5.getCcfsmc());
                        entity4.setQdfsdm(entity5.getQdfsdm());
                        entity4.setQdfs(entity5.getQdfs());
                        entity4.setScdw(entity5.getScdw());
                        //井次划分的措施id= 如果存在四类就是措施四类id，否则便是措施三类id
                        String csid = entity4.getCslb();
                        if (StringUtils.isNotBlank(entity4.getCssil())) {
                            csid = entity4.getCssil();
                        }
                        entity4.setCsid(csid);

                        //已施工查询日报的标志、报表分类标志
                        String biaozhi = "";
                        String reportflag = "";
                        String reportflag_name = "";
                        if ("1".equals(entity4.getNo_construction())) {
                            //日报的标志
                            List<Map> listMap1 = sgbbDao.bbSaveSelect6("," + csid + ",");
                            if (listMap1 != null && listMap1.size() > 0) {
                                biaozhi = listMap1.get(0).get("REPORTMEASURE").toString();
                                entity4.setReportflag_daily(biaozhi);
                            }
                            //报表分类标志
                            List<Map> listMap2 = sgbbDao.bbSaveSelect7("," + csid + ",");
                            if (listMap2 != null && listMap2.size() > 0) {
                                reportflag = listMap2.get(0).get("REPORTMEASURE").toString();
                                reportflag_name = listMap2.get(0).get("MEASURENAME").toString();
                                entity4.setReportflag(reportflag);
                                entity4.setReportflag_name(reportflag_name);
                            }
                            entity4.setNo_construction("");
                        } else {
                            entity4.setNo_construction("1");
                        }

                        //识别大规模压裂-------------------------------
                        if (csid.indexOf("10201") == 0 || csid.indexOf("30201") == 0) {
                            if (StringUtils.isNotBlank(entity5.getSfdgmyl())) {
                                entity4.setLargefract(entity5.getSfdgmyl());
                            }
                        }
                        //泵信息
                        entity4.setPumpcheck(entity.getStim_iii_appraise_code());//鉴定结果是3
                        entity4.setPump_cation(entity.getPump_specification());//泵规范
                        //单位属性
                        entity4.setUnitflag(dwsx);
                        //水井维护原因
                        List<Map> listMap3 = sgbbDao.bbSaveSelect8(entity4.getSjid());
                        if (listMap3 != null && listMap3.size() > 0) {
                            entity4.setConstruction_reason(listMap3.get(0).get("CONSTRUCTION_REASON").toString());
                        }
                        sgbbDao.bbSaveInsert3(entity4);
                    }
                }
                /***********以下为向总结表插入完工统计现措施数据*****应对一厂等不使用完工统计功能情况添加**************/

                //完工统计维护生成报表时间
                if (StringUtils.isBlank(entity1.getInput_date())) {
                    sgbbDao.bbSaveUpdate2(entity);
                }
                //提取完工统计现措施数据插入到 PC_CON_MANAGEMENT_INFO 表中
                List<CompleteReportEntity> list1 = sgbbDao.bbSaveSelect9(entity);
                int k = 1;
                if (list1 != null && list1.size() > 0) {
                    for (CompleteReportEntity entity7 : list1) {

                        String csdl1mc = entity7.getCsdl_mc();
                        String csxl1mc = entity7.getCsxl_mc();
                        String cslb1mc = entity7.getCslb_mc();
                        String cssl1mc = entity7.getCssil_mc();
                        String cssl1 = entity7.getCssil();
                        String csid1 = entity7.getCslb();

                        //王明义用作A5存储//
                        String sgxm = "";
                        String wgid = "";//施工项目作业类型确认，完工作业类型代码//
                        if (StringUtils.isBlank(csxl1mc)) {
                            sgxm = csdl1mc;
                        } else if (StringUtils.isBlank(cslb1mc)) {
                            sgxm = csdl1mc + "-" + csxl1mc;
                        } else if (StringUtils.isBlank(cssl1mc)) {
                            sgxm = csdl1mc + "-" + csxl1mc + "-" + cslb1mc;
                        } else {
                            sgxm = csdl1mc + "-" + csxl1mc + "-" + cslb1mc + "-" + cssl1mc;
                        }
                        if (StringUtils.isBlank(cssl1)) {
                            wgid = csid1;
                        } else {
                            wgid = cssl1;
                        }

                        String sql = "UPDATE DQJXZY.PC_CON_MANAGEMENT_INFO set item_sorte='" + sgxm + "',item_code_store='" + wgid + "'  WHERE CONSTRUCTION_ID='" + entity.getConstruction_id() + "'";
                        sgbbDao.bbSaveUpdate3(sql);
                        if (StringUtils.isNotBlank(cssl1)) {
                            csdl1mc = cssl1mc;
                            csid1 = cssl1;

                        } else {
                            if ("大修".equals(csdl1mc)) {
                                csdl1mc = csxl1mc;
                                csid1 = csid1;
                            } else {
                                csdl1mc = cslb1mc;
                                csid1 = csid1;
                            }

                        }
                        String sql1 = "";
                        if (k == 1) {
                            sql1 = "UPDATE DQJXZY.PC_CON_MANAGEMENT_INFO SET STIM_I_CATEGORY='" + csdl1mc + "',STIM_KEY_ID1='" + csid1 + "',UPDATE_DATE=sysdate,UPDATE_USER_ID='" + username + "',ITEM_NAME='" + csdl1mc + "',CONSTRUCTION_AIM='" + csdl1mc + "',ITEM_CODE='" + csid1 + "'   WHERE CONSTRUCTION_ID='" + entity.getConstruction_id() + "'";
                        } else if (k == 2) {
                            sql1 = "UPDATE DQJXZY.PC_CON_MANAGEMENT_INFO SET STIM_II_CATEGORY='" + csdl1mc + "',STIM_KEY_ID2='" + csid1 + "',UPDATE_DATE=sysdate,UPDATE_USER_ID='" + username + "'   WHERE CONSTRUCTION_ID='" + entity.getConstruction_id() + "'";
                        } else if (k == 3) {
                            sql1 = "UPDATE DQJXZY.PC_CON_MANAGEMENT_INFO SET STIM_III_CATEGORY='" + csdl1mc + "',STIM_KEY_ID3='" + csid1 + "',UPDATE_DATE=sysdate,UPDATE_USER_ID='" + username + "'   WHERE CONSTRUCTION_ID='" + entity.getConstruction_id() + "'";
                        }
                        sgbbDao.bbSaveUpdate3(sql1);
                        k++;

                    }
                }

            }
            map.put("code", "1");
        } catch (Exception e) {
            map.put("code", "0");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map initComplate(ReportWorkoveEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String sjqx = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        String dwsx = userEntity.getAttribute();//单位属性：0不分生产作业，1生产、2 作业 //1作业，2非作业
        String unitid = userEntity.getUnitid();
        entity.setSearch(sjqx);
        entity.setAttribute(dwsx);
//		if(sjqx.equals("1")){ //井下作业公司
//			if(unitid.length()>8){
//				entity.setTeam_id(unitid.substring(0,8));
//			}else {
//				entity.setTeam_id(unitid);
//			}
//		}else if(sjqx.equals("2")){//作业大队
//			if(unitid.length()>11){
//				entity.setTeam_id(unitid.substring(0,11));
//			}else {
//				entity.setTeam_id(unitid);
//			}
//		}else if(sjqx.equals("3")){//作业小队
//			entity.setTeam_id(unitid);
//		}


        Date date = new Date();
        entity.setTab("1");

        try {
            //18点
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 18);
            cal.set(Calendar.MINUTE, 0);
            Date time = cal.getTime();
            //获取当前时间（年月日时分）
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String currentdate = sdf.format(date);
            Date currenttime = sdf.parse(currentdate);
            if (currenttime.after(time)) { //18点以后只显示今天四点班次的
                entity.setTab("1");
            } else {//18点以前显示今天所有班次和昨天四点班次
                entity.setTab("2");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int totalRows = sgbbDao.selectCount(entity);// 查询总记录
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> sgbbs = sgbbDao.findAll(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", sgbbs);
        return map;
    }

    @Override
    public List<ReportWorkoveEntity> sgbbListjd(ReportWorkoveEntity entity) {

        return sgbbDao.sgbbList(entity);
    }

    @Override
    public List<Map<String, String>> jhSelect() {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        SgbbEntity entity = new SgbbEntity();
        entity.setOilfield(oilfield);
        String dwsx = userEntity.getAttribute();//单位属性：0不分生产作业，1生产、2 作业 //1作业，2非作业
        String sjqx = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        entity.setSearch(sjqx);
        entity.setAttribute(dwsx);
//		if(sjqx.equals("1")){ //井下作业公司
//			if(unitid.length()>8){
//				entity.setTeam_id(unitid.substring(0,8));
//			}else {
//				entity.setTeam_id(unitid);
//			}
//		}else if(sjqx.equals("2")){//作业大队
//			if(unitid.length()>11){
//				entity.setTeam_id(unitid.substring(0,11));
//			}else {
//				entity.setTeam_id(unitid);
//			}
//		}else if(sjqx.equals("3")){//作业小队
//			entity.setTeam_id(unitid);
//		}

        List<SgbbEntity> list_entity = sgbbDao.jhSelect(entity);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (SgbbEntity entity1 : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", entity1.getWell_common_name());
            map.put("value", entity1.getDid());
            list.add(map);
        }

        return list;
    }

    @Override
    public ReportWorkoveEntity rbAddVeiwSelect1(ReportWorkoveEntity entity) {
        return sgbbDao.rbAddVeiwSelect1(entity);
    }

    @Override
    public List<Map<String, String>> sgbzgxListJd(ReportWorkoveEntity entity) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<RbEntity> list_entity = sgbbDao.sgbzgxListJd(entity);
        for (RbEntity rbEntity : list_entity) {
//			   System.out.println(rbEntity.getCircuit_table());
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", rbEntity.getSpname());
            String circuit_id = rbEntity.getCircuit_id();
            if (StringUtils.isBlank(circuit_id)) {
                circuit_id = "";
            }
            String circuit_table = rbEntity.getCircuit_table();
            if (StringUtils.isBlank(circuit_table)) {
                circuit_table = "";
            }
            map.put("value", rbEntity.getSpid() + "." + rbEntity.getPdid() + "." + circuit_id + "." + circuit_table);
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, String>> allgxListJd(ReportWorkoveEntity entity) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        List<GxEntity> list_entity = sgbbDao.allgxListJd(entity);
        for (GxEntity rbEntity : list_entity) {

            Map<String, String> map = new HashMap<String, String>();
            map.put("key", rbEntity.getSpname());
            String circuit_id = rbEntity.getCircuit_id();
            if (StringUtils.isBlank(circuit_id)) {
                circuit_id = "";
            }
            String circuit_table = rbEntity.getCircuit_table();
            if (StringUtils.isBlank(circuit_table)) {
                circuit_table = "";
            }
            map.put("value", rbEntity.getSpid() + ".0" + "." + circuit_id + "." + circuit_table);
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, String>> ry(DwryEntity entity) {
        List<Map<String, String>> li = new ArrayList<>();

        List<DwryEntity> list = sgbbDao.ry(entity);
        for (DwryEntity en : list) {
            Map<String, String> map = new HashMap<>();
            map.put("key", en.getXm());
            map.put("value", en.getXm());
            li.add(map);
        }
        return li;
    }

    @Override
    @Transactional
    public Map<String, Object> savaPPDataJd(Map<String, String> map) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            String oilfield = userEntity.getOilfield();
            String circuit_table = map.get("circuit_table");
            String did = map.get("did");
            String report_time = map.get("report_time");
            String order_classes = map.get("order_classes");
            Integer spid = Integer.parseInt(map.get("spid"));
            Integer pdid = Integer.parseInt(map.get("pdid"));
            String parame_val_num = map.get("parame_val_num");
            RbEntity rb = new RbEntity();
            rb.setOilfield(oilfield);
            rb.setDid(did);
            rb.setReport_time(report_time);
            rb.setOrder_classes(order_classes);
            rb.setSpid(spid);
            rb.setCircuit_table(circuit_table);
            rb.setParame_val_num(parame_val_num);
            //删除施工参数数据
            sgbbDao.removePPDataJd(rb);
            if (StringUtils.isBlank(parame_val_num)) {
                //拼接附件ID
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                parame_val_num = date + dd;

            }
            //保存施工参数数据
            //保存施工参数数据
            String whc = "insert into " + circuit_table + " (OILFIELD,parame_val_num,ip, tab,";
            Set<Entry<String, String>> sets = map.entrySet();
            for (Entry<String, String> entry : sets) {
                if (!entry.getKey().equals("content") && !entry.getKey().equals("buildcontent") && !entry.getKey().equals("circuit_table") && !entry.getKey().equals("customid") && !entry.getKey().equals("parame_val_num")) {
                    whc += entry.getKey() + ",";
                }
            }
            String ip = ""; //录入ip
            try {
                ip = InetAddress.getLocalHost().toString();
                ip = ip.split("/")[1];
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            whc += "CREATE_USER,CREATE_TIME) values ('" + oilfield + "'," + parame_val_num + ",'" + ip + "','1',";
            for (Entry<String, String> entry : sets) {
                if (!entry.getKey().equals("content") && !entry.getKey().equals("buildcontent") && !entry.getKey().equals("circuit_table") && !entry.getKey().equals("customid") && !entry.getKey().equals("parame_val_num")) {
                    if (entry.getValue().equals("spid")) {
                        whc += entry.getValue() + ",";
                    } else {
                        whc += "'" + entry.getValue() + "',";
                    }
                }
            }
            whc += "'" + userid + "',sysdate)";
//			System.out.println(whc);
            rb.setWhc(whc);
            sgbbDao.savePPData(rb);


            map1.put("parame_val_num", parame_val_num);
            map1.put("code", "1");
            map1.put("msg", "保存成功");
        } catch (Exception e) {
            map1.put("code", "0");
            map1.put("msg", "保存失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map1;
    }

    @Override
    @Transactional
    public Map<String, String> sgbbSaveJd(ReportWorkoveEntity entity) {

        Map<String, String> map = new HashMap<String, String>();

        try {

            if (entity.getEntity_list() == null || entity.getEntity_list().size() == 0) {

                map.put("code", "0");
                map.put("msg", "没有施工工序，保存失败。");
                return map;
            }

            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            String oilfield = userEntity.getOilfield();
            entity.setCreate_user(userid);
            entity.setOilfield(oilfield);

            String end_time = "";//完工日期
            if (oilfield.equals("pc0jd") && entity.getComplete_judgement().equals("yes")) { //完工判断
                //没有施工总结不能完工
                int num = sgbbDao.sgbbSaveselect1(entity);
                if (num == 0) {
                    map.put("code", "0");
                    map.put("msg", "没有对应的施工设计不能完井");
                    return map;
                }
                //查询完工日期
                end_time = sgbbDao.sgbbSaveselect2(entity);
                if (StringUtils.isBlank(end_time)) {
                    end_time = entity.getReport_time();//如果完工日期为空，完工日期=当前班报上报日期
                }
            }
            entity.setEnd_date(end_time);
            //更改开工井及搬家计划表开完工日期
            sgbbDao.sgbbSaveupdate1(entity);


            // 班报ID
            if (StringUtils.isBlank(entity.getBb_id())) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHHmmssSSS");
                String today = df.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                entity.setBb_id("BB" + "_" + today + dd);
            }
            //删除班报
            sgbbDao.sgbbSavedelete1(entity);


            //判断ID最大值
            int id = sgbbDao.sgbbSaveselect3Jd(entity);
            for (ReportWorkoveEntity a : entity.getEntity_list()) {
                id += 1;
                a.setId(id);
            }

            //保存工序
            sgbbDao.sgbbSaveinsert1Jd(entity);

            map.put("code", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "出错了");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map<String, String> sgbbRemove(ReportWorkoveEntity entity) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            //查询删除施工单元参数
            List<SgdyEntity> table_list = sgbbDao.sgbbSaveselect_table(entity);
            if(table_list!=null&&table_list.size()>0){
                SgdyEntity sgdyEntity= new SgdyEntity();
                sgdyEntity.setEntityList(table_list);
                sgbbDao.sgbbSave_table_remove(sgdyEntity);
            }
            //删除班报数据
            AqscConfigEntity config = sgbbDao.config();
            entity.setConfigTab(config.getBanbao());
            sgbbDao.sgbbSavedelete1(entity);
            map.put("code", "1");
            map.put("msg", "删除成功。");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "删除失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map xjkgList(SgbbEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String sjqx = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        String dwsx = userEntity.getAttribute();//单位属性：1作业，2非作业（生产、设计、机关）
        String unitid = userEntity.getUnitid();
        entity.setSearch(sjqx);
        entity.setAttribute(dwsx);
        AqscConfigEntity config = sgbbDao.config();
         entity.setConfigTab(config.getXijing());
        int totalRows = sgbbDao.xjkgCount(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> sgbbs = sgbbDao.xjkgList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", sgbbs);
        return map;

    }

    @Override
    public Map<String, String> sgbz_yz(SgbzEntity entity) {

        Map<String, String> map = new HashMap<String, String>();
        List<SgbzEntity> list = sgbbDao.sgbz_yz(entity);
        if (list.size() > 0) {
            map.put("code", "1");
        } else {
            map.put("code", "0");
            map.put("msg", "该井未定制施工步骤，不能开工。");
        }
        return map;
    }

    @Override
    public Object initSele(SgbbEntity sgbb) {
        List<SgbbEntity> list = sgbbDao.findA(sgbb);
        for (SgbbEntity j1 : list) {
            if (j1.getJb() != null && j1.getJb().indexOf("1") != -1) {
                j1.setJb("油井");
            } else if (j1.getJb() != null && j1.getJb().indexOf("3") != -1) {
                j1.setJb("水井");
            }
        }
        return list;
    }

    @Override
    public Map<String, String> xjkgSave(SgbbEntity entity) {

        Map<String, String> map = new HashMap<String, String>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String username = userEntity.getUser_name();
        String oilfield = userEntity.getOilfield();
        entity.setCreate_user(username);
        entity.setOilfield(oilfield);

        try {
            AqscConfigEntity config = sgbbDao.config();
            entity.setConfigTab(config.getXijing());
            sgbbDao.insertXjkgSave(entity);
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
    public Map kgjList(SgbbEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String sjqx = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        String dwsx = userEntity.getAttribute();//单位属性：1作业，2非作业（生产、设计、机关）
        entity.setSearch(sjqx);
        entity.setAttribute(dwsx);

        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        int totalRows = sgbbDao.kgjCount(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> sgbbs = sgbbDao.kgjList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", sgbbs);
        return map;

    }

    @Override
    public Map ztsg(SgbbEntity entity) {

        Map<String, String> map = new HashMap<String, String>();
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String username = userEntity.getUser_name();
            entity.setUsername(username);
            sgbbDao.ztsgUpdate(entity);
            map.put("code", "1");
        } catch (Exception e) {
            map.put("code", "0");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 班报查询-wzw
     *
     * @param entity
     * @param pager
     * @return
     */
    @Override
    public Map<String, Object> bbckList2(ReportWorkoveEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String search = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        String attribute = userEntity.getAttribute();//单位属性：1作业，2非作业（生产、设计、机关）
        entity.setSearch(search);
        entity.setAttribute(attribute);

        int totalRows = sgbbDao.bbckCount2(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> sgbbs = sgbbDao.bbckList2(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", sgbbs);
        return map;
    }

    /**
     * 作业日报
     *
     * @param entity
     * @param pager
     * @return
     */
    @Override
    public Map zyrbList(ZyrbEntity entity, Pager pager) {
        if (StringUtils.isBlank(entity.getReport_time_Str()) && StringUtils.isBlank(entity.getOrder_classes())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            entity.setReport_time_Str(date);
        }
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        String search = userEntity.getSearch();//数据权限  0（油公司级）、一级单位 1二级单位（采油厂、井下作业公司等）2、三级单位3、四级单位
        String attribute = userEntity.getAttribute();//单位属性：1作业，2非作业（生产、设计、机关）
        entity.setSearch(search);
        entity.setAttribute(attribute);
        List<ZyrbEntity> kgj = sgbbDao.ykgjList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("rows", kgj);
        return map;
    }

    @Override
    public Map<String, String> gcSaveJd(GcEntity entity) {

        Map<String, String> map = new HashMap<String, String>();

        try {

            if (entity.getEntityList() == null || entity.getEntityList().size() == 0) {

                map.put("code", "0");
                map.put("msg", "没有接收到数据，保存失败。");
                return map;
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            String oilfield = userEntity.getOilfield();
            entity.setCreate_user(userid);
            entity.setLast_user(userid);
            entity.setOilfield(oilfield);

            //保存管串
            sgbbDao.gcSaveinsert1Jd(entity);

            map.put("code", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("code", "0");
            map.put("msg", "出错了");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map gcSelect(GcEntity entity) {
        Map map = new HashMap();
        map.put("rows", sgbbDao.gcSelect(entity));
        return map;
    }

    @Override
    public List<Map<String, String>> gcname(GcEntity entity) {
        List<Map<String, String>> li = new ArrayList<>();

        List<GcEntity> list = sgbbDao.gcname(entity);
        for (GcEntity en : list) {
            Map<String, String> map = new HashMap<>();
            map.put("key", en.getKind());
            map.put("value", en.getSpid().toString());
            li.add(map);
        }
        return li;
    }

    @Override
    public List<Map<String, String>> gctype(GcEntity entity) {
        List<Map<String, String>> li = new ArrayList<>();

        List<GcEntity> list = sgbbDao.gctype(entity);
        for (GcEntity en : list) {
            Map<String, String> map = new HashMap<>();
            map.put("key", en.getXhtype());
            map.put("value", en.getXhtype());
            li.add(map);
        }
        return li;
    }

    @Override
    public List<Map<String, String>> shdw_select(PcUnitEntity entity) {
        List<Map<String, String>> list = new ArrayList<>();

        if (StringUtils.isNotBlank(entity.getParentid()) && entity.getParentid().length() > 11) {
            entity.setParentid(entity.getParentid().substring(0, 11));
        }

        List<PcUnitEntity> listEntity = sgbbDao.shdw_select(entity);

        for (PcUnitEntity entity1 : listEntity) {

            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getUnitname());
            map.put("value", entity1.getId());
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, String>> yldw_select(PcUnitEntity entity) {
        List<Map<String, String>> list = new ArrayList<>();
        List<PcUnitEntity> listEntity = sgbbDao.yldw_select(entity);

        for (PcUnitEntity entity1 : listEntity) {

            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getUnitname());
            map.put("value", entity1.getId());
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, String>> lxygdw_select(PcUnitEntity entity) {
        List<Map<String, String>> list = new ArrayList<>();
        List<PcUnitEntity> listEntity = sgbbDao.lxygdw_select(entity);

        for (PcUnitEntity entity1 : listEntity) {

            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getUnitname());
            map.put("value", entity1.getId());
            list.add(map);
        }

        return list;
    }

    @Override
    public int max_spno(ReportWorkoveEntity entity) {
        return sgbbDao.max_spno(entity);
    }

    @Override
    public Map showList(SgbbEntity entity, Pager pager) {

        if (entity.getWell_common_name() != null && entity.getWell_common_name().length() > 0) {
            entity.setWell_common_name(entity.getWell_common_name().toUpperCase());
        }

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();
        String search = userEntity.getSearch();
        entity.setAttribute(attribute);
        entity.setSearch(search);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);

        //总记录数
        int totalRows = sgbbDao.showCount(entity);
        SetPageUtil.setPage(entity, pager);
        List<SgbbEntity> list = sgbbDao.showList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);
        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public Map rbjl(SgrbEntity entity) {
        if (entity.getWell_common_name() != null && entity.getWell_common_name().length() > 0) {
            entity.setWell_common_name(entity.getWell_common_name().toUpperCase());
        }
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());

        List<SgrbEntity> sgbbs = sgbbDao.rbjl(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", sgbbs);

        Map resultMap= new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return resultMap;
    }

    @Override
    public List<Map<String, String>> unit_select(PcUnitEntity entity) {
        List<Map<String, String>> list = new ArrayList<>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        if (StringUtils.isEmpty(entity.getParentid())) {
            entity.setParentid(oilfield);
        }
        String attribute = userEntity.getAttribute();
        String search = "";
        if("2".equals(attribute)){
            search = userEntity.getSearch();
            if(StringUtils.isNotEmpty(search)&&search.length()>8){
                search=search.substring(0,8);
            }
        }
        entity.setSearch(search);
        List<PcUnitEntity> list1 = sgbbDao.unit_select(entity);

        for (PcUnitEntity entity1 : list1) {
            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getUnitname());
            map.put("value", entity1.getId());
            list.add(map);
        }

        return list;
    }
}
