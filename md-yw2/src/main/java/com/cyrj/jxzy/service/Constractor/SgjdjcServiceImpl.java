package com.cyrj.jxzy.service.Constractor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import com.cyrj.jxzy.dao.Constractor.SgjdjcDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj4Entity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.SgjdjcUploadEntity;
import com.cyrj.jxzy.entity.Constractor.Sgjdjc_J_ListEntity;
import com.cyrj.jxzy.entity.Constractor.SgjdjclrEntity;
import com.cyrj.jxzy.util.SetPageUtil;
import com.cyrj.jxzy.util.UploadFileStorageUtil;

@Service
public class SgjdjcServiceImpl implements SgjdjcService {

    @Autowired
    private SgjdjcDao dao;
    @Autowired
    private HttpServletRequest request;


    @Override
    public List<CbsFj4Entity> listFlb(CbsFj4Entity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());

        return dao.listFlb(entity);
    }

    @Transactional
    @Override
    public Map  flbSave(CbsFj4Entity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            entity.setOilfield(userEntity.getOilfield());
            dao.deleteFlbSave(entity);
            dao.insertFlbSave(entity);
            map.put("data", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败");
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public Map  showList(Sgjdjc_J_ListEntity entity, Pager pager) {


        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String userid = userEntity.getUser_name();
        String search = userEntity.getSearch();
        String attribute = userEntity.getAttribute();
        entity.setOilfield(oilfield);
        entity.setUserid(userid);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        String scdw = "";//生产单位
        if (StringUtils.isNotEmpty(entity.getCyd())) {
            scdw = entity.getCyd();
        } else if (StringUtils.isNotEmpty(entity.getCyk())) {
            scdw = entity.getCyk();
        } else if (StringUtils.isNotEmpty(entity.getCyc())) {
            scdw = entity.getCyc();
        }
        entity.setScdw(scdw);

        String sgdw="";//施工单位
        if(StringUtils.isNotEmpty(entity.getSgdw2())){
            sgdw=entity.getSgdw2();
        }else if(StringUtils.isNotEmpty(entity.getSgdw1())){
            sgdw=entity.getSgdw1();
        }
        entity.setSgdw(sgdw);
        int totalRows = dao.contShowList(entity);

        SetPageUtil.setPage(entity, pager);
        List<Sgjdjc_J_ListEntity> list = dao.showList(entity);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;
    }


    @Transactional
    @Override
    public Map  sgjdjclrSave(SgjdjclrEntity entity) {
        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String userid = userEntity.getUser_name();
            entity.setLrr(userid);
            if ("null".equals(entity.getTeam_qualification())) {

                entity.setTeam_qualification(null);
            }
            //插入一条总的数据记录
            dao.insertSgjdjclrSave1(entity);

            if (entity.getEntity_list() != null && entity.getEntity_list().size() > 0) {
//				
//				//保存检查记录明细
//				dao.insertSgjdjclrSave2(entity);
//				//合并问题项数
//				dao.deleteSgjdjclrSave(entity);
//				dao.insertSgjdjclrSave3(entity);


                //把检查项1、检查项2、检查项3相同的检查内容合并
                List<SgjdjclrEntity> list = entity.getEntity_list();
                Map<String, SgjdjclrEntity> map1 = new HashMap<String, SgjdjclrEntity>();
                for (SgjdjclrEntity entity1 : list) {
                    SgjdjclrEntity entity2 = map1.get(entity1.getJcxm1() + entity1.getJcxm2() + entity1.getJcxm3());
                    if (entity2 != null) {//已存在拼接存在问题、整改情况、合计问题项数
                        if (StringUtils.isNotEmpty(entity1.getCzwt())&& StringUtils.isNoneBlank(entity1.getCzwt().trim())) {
                            Integer czwtTotal = entity2.getCzwtallm();
                            entity2.setCzwtallm(czwtTotal + 1);
                            String czwt = entity2.getCzwt() + "</br>" + entity2.getCzwtallm() + "、" + entity1.getCzwt();
                            entity2.setCzwt(czwt);

                            if (StringUtils.isNoneBlank(entity1.getZgqk())) {
                                if (StringUtils.isNoneBlank(entity2.getZgqk())) {
                                    String zgqk = entity2.getZgqk() + "</br>" + entity2.getCzwtallm() + "、" + entity1.getZgqk();
                                    entity2.setZgqk(zgqk);
                                } else {
                                    entity2.setZgqk(entity2.getCzwtallm() + "、" + entity1.getZgqk());
                                }
                            }
                            map1.put(entity1.getJcxm1() + entity1.getJcxm2() + entity1.getJcxm3(), entity2);
                        }
                    } else {//不存在添加到map中

                        if (entity1 != null && StringUtils.isNoneBlank(entity1.getCzwt())&& StringUtils.isNoneBlank(entity1.getCzwt().trim())) {
                            entity1.setJcid(entity.getJcid());
                            entity1.setCzwtallm(1);
                            entity1.setCzwt(1 + "、" + entity1.getCzwt());
                            if (StringUtils.isNoneBlank(entity1.getZgqk())) {
                                entity1.setZgqk(1 + "" + entity1.getZgqk());
                            }
                            entity1.setJcr(entity.getJcr());
                            entity1.setFcr(entity.getFcr());

                            map1.put(entity1.getJcxm1() + entity1.getJcxm2() + entity1.getJcxm3(), entity1);
                        }
                    }
                }
                Collection<SgjdjclrEntity> con = map1.values();

                if (con.size() > 0) {

                    //保存检查记录详情
                    List<SgjdjclrEntity> el = new ArrayList<SgjdjclrEntity>(con);
                    entity.setEl(el);
                    dao.insertSgjdjclrSave2(entity);
                    //合并问题项数
                    dao.deleteSgjdjclrSave(entity);
                    dao.insertSgjdjclrSave3(entity);
                }
            }
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {

            map.put("data", "0");
            map.put("msg", "出错了，请重新保存");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map  showList_jl(Sgjdjc_J_ListEntity entity, Pager pager) {


        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setAttribute(attribute);
        entity.setSearch_cbs(search);
        entity.setOilfield(userEntity.getOilfield());
        String scdw = "";//生产单位
        if (StringUtils.isNotEmpty(entity.getCyd())) {
            scdw = entity.getCyd();
        } else if (StringUtils.isNotEmpty(entity.getCyk())) {
            scdw = entity.getCyk();
        } else if (StringUtils.isNotEmpty(entity.getCyc())) {
            scdw = entity.getCyc();
        }
        entity.setScdw(scdw);
        String sgdw="";//施工单位
        if(StringUtils.isNotEmpty(entity.getSgdw2())){
            sgdw=entity.getSgdw2();
        }else if(StringUtils.isNotEmpty(entity.getSgdw1())){
            sgdw=entity.getSgdw1();
        }
        entity.setSgdw(sgdw);

        int totalRows = dao.contshowList_jl(entity);
        SetPageUtil.setPage(entity, pager);
        List<Sgjdjc_J_ListEntity> list = dao.showList_jl(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);
        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;
    }

    @Override
    public Map jdjcmxList(SgjdjclrEntity entity) {

        List<SgjdjclrEntity> list = dao.jdjcmxList(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);

        Map  resultMap = new HashMap();
        resultMap.put("code",200);
        resultMap.put("msg","成功");
        resultMap.put("data",map);
        return  resultMap;

    }

    @Override
    public SgjdjclrEntity jcjl_liulanSelect(SgjdjclrEntity entity) {
        return dao.jcjl_liulanSelect(entity);
    }

    @Override
    public List<SgjdjclrEntity> jcjl_liulanList(SgjdjclrEntity entity) {
        return dao.jcjl_liulanList(entity);
    }

    @Override
    public Map  jcjlRemove(SgjdjclrEntity entity) {
        Map  map = new HashMap ();
        map.put("code",200);
        try {
            SgjdjclrEntity entity1 = dao.jcjl_liulanSelect(entity);
            if (entity1 == null) {
                map.put("data", "0");
                map.put("msg", "未查询到检查记录！");
            } else {
                dao.jcjlRemove(entity1);
                map.put("data", "1");
                map.put("msg", "删除成功。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("data", "1");
            map.put("msg", "出错了,删除失败。");
        }

        return map;
    }

    @Override
    public List<SgjdjclrEntity> sgjdjcjl_hzList(SgjdjclrEntity entity) {

        return dao.sgjdjcjl_hzList(entity);
    }

    @Override
    public SgjdjclrEntity sgjdjcjl_hzSelect(SgjdjclrEntity entity) {

        return dao.sgjdjcjl_hzSelect(entity);
    }

    @Override
    @Transactional
    public Map uploadFiles(SgjdjcUploadEntity entity, MultipartFile[] files) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);

        try {
            String path = "CBS/JDJC/";
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String userid = userEntity.getUser_name();

            //保存上传的照片----------------------------------------------

            if (files != null && files.length > 0) {

                //调用文件通用上传保持类
                UploadFileStorageUtil ufs = new UploadFileStorageUtil();
                List<Map<String, String>> list = ufs.uploadFileStorageList(files, path);//path 保存路径格式为cbs/hetong/

                if (list != null && list.size() > 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
                    List<SgjdjcUploadEntity> list_uf = new ArrayList<SgjdjcUploadEntity>();
                    for (Map<String, String> map1 : list) {
                        SgjdjcUploadEntity uf = new SgjdjcUploadEntity();
                        String date = sdf.format(new Date());
                        int dd = (int) (Math.random() * 900 + 100);
                        String imgid = "IMG" + date + dd; //合同ID
                        uf.setImgid(imgid);
                        uf.setOilfield(oilfield);
                        uf.setJcid(entity.getJcid());
                        uf.setJcxm1(entity.getJcxm1());
                        uf.setJcxm2(entity.getJcxm2());
                        uf.setJcxm3(entity.getJcxm3());
                        uf.setTab(entity.getTab());
                        uf.setFileuri(map1.get("filepath"));
                        uf.setFileoldname(map1.get("fileNameOld"));
                        uf.setInperson(userid);
                        list_uf.add(uf);
                    }
                    entity.setEl(list_uf);
                    dao.deleteImage(entity);
                    dao.insertImage(entity);
                    map.put("data", entity);
                    map.put("msg", "保存成功");
                } else {
                    map.put("data", "0");
                    map.put("msg", "保存失败。");
                }
            } else {
                map.put("data", "0");
                map.put("msg", "上传失败。");
            }
        } catch (Exception e) {

            map.put("data", "0");
            map.put("msg", "处错误了，保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

        }

        return map;
    }

    @Override
    public List<SgjdjcUploadEntity> imageView(SgjdjcUploadEntity entity) {

        try {
            entity.setJcxm1(URLDecoder.decode(entity.getJcxm1(), "UTF-8"));
            entity.setJcxm2(URLDecoder.decode(entity.getJcxm2(), "UTF-8"));
            entity.setJcxm3(URLDecoder.decode(entity.getJcxm3(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dao.imageView(entity);
    }

    @Override
    public String select(Sgjdjc_J_ListEntity entity) {

        return dao.select(entity);
    }

    @Override
    @Transactional
    public Map  sgjdjczgSave(SgjdjclrEntity entity) {


        Map map = new HashMap();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setLrr(userid);
            //修改
            dao.sgjdjczgUpdate1(entity);
            if (entity.getEntity_list() != null && entity.getEntity_list().size() > 0) {
                dao.sgjdjczgUpdate2(entity);
            }
            map.put("data", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新保存");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
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
        List<PcUnitEntity> list1 = dao.unit_select(entity);

        for (PcUnitEntity entity1 : list1) {
            Map<String, String> map = new HashMap<>();
            map.put("key", entity1.getUnitname());
            map.put("value", entity1.getId());
            list.add(map);
        }

        return list;
    }
}
