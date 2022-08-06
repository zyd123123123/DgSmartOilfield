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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cyrj.jxzy.dao.Constractor.HtxxlrDao;
import com.cyrj.jxzy.dao.Constractor.PcUnitCuopDao;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.util.Common;
import com.cyrj.jxzy.util.UploadFileStorageUtil;

@Service
public class HtxxlrServiceImpl implements HtxxlrServiceI {

    @Autowired
    private PcUnitCuopDao pcUnitCuopDao;
    @Autowired
    private HtxxlrDao htxxlrDao;
    @Autowired
    private HttpServletRequest request;

    /**
     * 查询厂级单位下拉列表
     *
     * @return
     */
    @Override
    public List<Map<String, String>> unit_select() {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        pcUnitEntity.setOilfield(oilfield);
        if (attribute.equals("2")) {
            pcUnitEntity.setId(search);
        }
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam4(pcUnitEntity);
        for (PcUnitEntity pcUnit : entity_list_PcUnit) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", pcUnit.getUnitname());
            map.put("value", pcUnit.getId());

            list.add(map);
        }
        return list;
    }

    /**
     * 合同编号校验
     *
     * @param entity
     * @return
     */
    @Override
    public Map<String, Object> check(HtxxlrEntity entity) {
        int rows = htxxlrDao.count(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", rows);
        return map;
    }

    /**
     * 承包商名称下拉列表
     */
    @Override
    public List<Map<String, String>> cbs_select() {

        QylrEntity entity = new QylrEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        if (attribute.equals("1")) {
            entity.setDwdm(search);
        }
        List<QylrEntity> list_entity = htxxlrDao.cbs_select(entity);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (QylrEntity hc : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", hc.getDwmc());
            map.put("value", hc.getDwdm());
            list.add(map);
        }

        return list;
    }

    @Override
    public List<QualificationEntity> qualification_select(HtxxlrEntity entity) {

        return htxxlrDao.qualification_select(entity);
    }

    @Override
    @Transactional
    public Map save(HtxxlrEntity entity, MultipartFile[] files) {

        Map map = new HashMap();
        map.put("code", 200);
        String data = "0";
        String msg = "";
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setInput_person(username);

            if (StringUtils.isNotBlank(entity.getContract_number())) {

                entity.setContract_number(entity.getContract_number().toUpperCase());
            }

            //拼接合同ID
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
            String date = sdf.format(new Date());
            int dd = (int) (Math.random() * 900 + 100);
            String contract_id = "HT" + date + dd; //合同ID
            entity.setContract_id(contract_id);
            //判断合同编号是否存在---------------------------------------------------
            int rows = htxxlrDao.count(entity);

            if (rows > 0) {

                map.put("data", "2");
                map.put("msg", "合同编号已存在，不可重复录入。");
                return map;
            }


            //保存合同绑定队伍-------------------------------------------------
            //判断选择的队伍在合同开工年份是否已绑定其他队伍
            List<QualificationEntity> entity_q_list = entity.getEntity_q_list();
            if (entity_q_list != null && entity_q_list.size() > 0) {

                entity.setEl(entity_q_list);
                //保存队伍资质
                List<ContractTeamEntity> list_c = new ArrayList<ContractTeamEntity>();
                for (QualificationEntity qf : entity_q_list) {

                    ContractTeamEntity ct = new ContractTeamEntity();
                    ct.setOilfield(oilfield);
                    ct.setContract_id(contract_id);
                    ct.setContractor_id(entity.getContractor_id());
                    ct.setTermid(qf.getTermid());
                    ct.setTeam_name(qf.getDwmc());//队伍名称
                    ct.setTeam_qualification(qf.getDwzzbh());//队伍资质
                    ct.setApply_person(username);
                    ct.setUnit_id(entity.getUnit_id());
                    list_c.add(ct);
                }

                ContractTeamEntity ce = new ContractTeamEntity();
                ce.setEl(list_c);
                // 插入新数据
                htxxlrDao.contractTeamInsert(ce);
//			
            }

            //保存上传的照片----------------------------------------------
            List<String> file_list = entity.getFile_list();
            if (file_list != null && file_list.size() > 0) {
                List<UploadFilesEntity> list_uf = new ArrayList<UploadFilesEntity>();
                for (String fileurl : file_list) {
                    UploadFilesEntity uf = new UploadFilesEntity();
                    uf.setId(contract_id);
                    uf.setOilfield(oilfield);
                    uf.setContract_id(contract_id);
                    uf.setContractor_id(entity.getContractor_id());
                    uf.setFiletype("合同附件");
                    uf.setFileuri(fileurl);
                    uf.setUpload_person(username);
                    list_uf.add(uf);
                }
                UploadFilesEntity uf = new UploadFilesEntity();
                uf.setId(entity.getContract_id());
                uf.setFiletype("合同附件");
                uf.setEl(list_uf);
                htxxlrDao.insertUploadFiles(uf);
            }
//            if (files != null && files.length > 0) {
//
//                //调用文件通用上传保持类
//                UploadFileStorageUtil ufs = new UploadFileStorageUtil();
//                String path = "CBS/HETONG/";
//                List<Map<String, String>> list = ufs.uploadFileStorageList(files, path);//path 保存路径格式为cbs/hetong/
//
//                if (list != null && list.size() > 0) {
//
//                    List<UploadFilesEntity> list_uf = new ArrayList<UploadFilesEntity>();
//
//                    for (Map<String, String> map1 : list) {
//
//
//                        UploadFilesEntity uf = new UploadFilesEntity();
//                        uf.setId(contract_id);
//                        uf.setOilfield(oilfield);
//                        uf.setContract_id(contract_id);
//                        uf.setContractor_id(entity.getContractor_id());
//                        uf.setFiletype("合同附件");
//                        uf.setFileuri(map1.get("filepath"));
//                        uf.setFileoldname(map1.get("fileNameOld"));
//                        uf.setUpload_person(username);
//                        list_uf.add(uf);
//                    }
//
//                    UploadFilesEntity uf = new UploadFilesEntity();
//                    uf.setEl(list_uf);
//                    htxxlrDao.insertUploadFiles(uf);
//
//                }
//            }
            //保存合同信息----------------------------------

            htxxlrDao.htxxlrInsert(entity);
            data = "1";
            msg = "保存成功。";

        } catch (Exception e) {

            data = "0";
            msg = "出错了，保存失败。";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

        }
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }

    @Override
    @Transactional
    public Map updateSave(HtxxlrEntity entity,
                                          QualificationEntity entity_q) {


        Map  map = new HashMap ();
        map.put("code",200);
        String data = "0";
        String msg = "";
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String username = userEntity.getUser_name();
            entity.setInput_person(username);
            if (StringUtils.isNotBlank(entity.getContract_number())) {
                entity.setContract_number(entity.getContract_number().toUpperCase());
            }

            //判断合同编号是否存在---------------------------------------------------
            int rows = htxxlrDao.count(entity);
            if (rows > 0) {
                map.put("data", "2");
                map.put("msg", "合同编号已存在，不可重复录入。");
                return map;
            }

            //保存队伍---------------------------------------
            //先删除合同绑定队伍
            htxxlrDao.deletecontractTeam(entity.getContract_id());

            //判断选择的队伍在合同开工年份是否已绑定其他队伍
            List<QualificationEntity> entity_q_list = entity.getEntity_q_list();
            if (entity_q_list != null && entity_q_list.size() > 0) {
                entity.setEl(entity_q_list);
                //保存队伍资质
                List<ContractTeamEntity> list_c = new ArrayList<ContractTeamEntity>();
                for (QualificationEntity qf : entity_q_list) {
                    ContractTeamEntity ct = new ContractTeamEntity();
                    ct.setOilfield(oilfield);
                    ct.setContract_id(entity.getContract_id());
                    ct.setContractor_id(entity.getContractor_id());
                    ct.setTermid(qf.getTermid());
                    ct.setTeam_name(qf.getDwmc());//队伍名称
                    ct.setTeam_qualification(qf.getDwzzbh());//队伍资质
                    list_c.add(ct);
                }
                ContractTeamEntity ce = new ContractTeamEntity();
                ce.setEl(list_c);
                // 插入新数据
                htxxlrDao.contractTeamInsert(ce);
            }
             //保存图片
            List<String> file_list = entity.getFile_list();
            if (file_list != null && file_list.size() > 0) {
                List<UploadFilesEntity> list_uf = new ArrayList<UploadFilesEntity>();
                for (String fileurl : file_list) {
                    UploadFilesEntity uf = new UploadFilesEntity();
                    uf.setId(entity.getContract_id());
                    uf.setOilfield(oilfield);
                    uf.setContract_id(entity.getContract_id());
                    uf.setContractor_id(entity.getContractor_id());
                    uf.setFiletype("合同附件");
                    uf.setFileuri(fileurl);
                    uf.setUpload_person(username);
                    list_uf.add(uf);
                }
                UploadFilesEntity uf = new UploadFilesEntity();
                uf.setId(entity.getContract_id());
                uf.setFiletype("合同附件");
                uf.setEl(list_uf);
                htxxlrDao.insertUploadFiles(uf);
            }
            //修改合同信息----------------------------------

            htxxlrDao.htxxlrUpdate(entity);
            data = "1";
            msg = "保存成功。";

        } catch (Exception e) {
            data = "0";
            msg = "出错了，保存失败。";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }


        map.put("data", data);
        map.put("msg", msg);
        return map;
    }

    @Override
    public Map  removeContract(HtxxlrEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            int mm = htxxlrDao.removeSelect(entity);
            if (mm > 0) {
                map.put("data", "0");
                map.put("msg", "已申请HSE证书，不能删除");
            } else {
                htxxlrDao.removeContract(entity);

                map.put("data", "1");
                map.put("msg", "删除成功");
            }
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map  htshth(HtxxlrEntity entity) {
        Map map = new HashMap ();
        map.put("code",200);
        try {

            htxxlrDao.htshth(entity);
            map.put("data", "1");
            map.put("msg", "退回成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map htwgth(HtxxlrEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            htxxlrDao.htwgth(entity);
            map.put("data", "1");
            map.put("msg", "退回成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }
        return map;
    }

}
