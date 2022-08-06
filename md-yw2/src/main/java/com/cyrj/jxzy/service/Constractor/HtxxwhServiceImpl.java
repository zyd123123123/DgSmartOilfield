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
import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.dao.Constractor.HtxxlrDao;
import com.cyrj.jxzy.dao.Constractor.HtxxwhDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxwhEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.util.SetPageUtil;
import com.cyrj.jxzy.util.UploadFileStorageUtil;

@Service
public class HtxxwhServiceImpl implements HtxxwhService {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HtxxwhDao dao;
    @Autowired
    private HtxxlrDao htxxlrDao;

    /**
     * 合同信息维护列表数据
     *
     * @param entity
     * @param page
     * @return
     */
    @Override
    public Map  listHtxxwh(HtxxckEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);

        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        //总记录数
        int totalRows = dao.countHtxxwh(entity);
        SetPageUtil.setPage(entity, pager);
        //查询
        List<HtxxckEntity> list = dao.listHtxxwh(entity);
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
    public HtxxckEntity getHtxxck(String contract_id) {


        return dao.getHtxx(contract_id);
    }

    @Override
    @Transactional
    public Map<String, String> change_save(HtxxwhEntity entity_wh) {


        Map<String, String> map = new HashMap<String, String>();

        map.put("code", "1");
        map.put("msg", "保存成功。");

        try {

            //拼接ID
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
            String date = sdf.format(new Date());
            int dd = (int) (Math.random() * 900 + 100);
            String contract_bgid = "HTBG" + date + dd; //合同ID

            //变更前合同信息
            HtxxwhEntity entity_y = new HtxxwhEntity();
            entity_y.setContract_id(entity_wh.getContract_id());
            entity_y.setContractor_name(entity_wh.getContractor_name());
            entity_y.setContract_number(entity_wh.getContract_number());
            entity_y.setContract_bgid(contract_bgid);

            entity_y.setTab("1");//原始信息

            //变更后信息
            HtxxwhEntity entity_bg = new HtxxwhEntity();

            entity_bg.setContract_id(entity_wh.getContract_id());//合同ID
            entity_bg.setContractor_name(entity_wh.getContractor_name());//承包商名称
            entity_bg.setContract_number(entity_wh.getContract_number());//合同编号
            entity_bg.setChange_cause(entity_wh.getChange_cause());//变更原因
            entity_bg.setChange_cause_explain(entity_wh.getChange_cause_explain());//变更原因说明
            entity_bg.setTab("2");//变更信息
            entity_bg.setAudittab("1");//审核状态
            entity_bg.setContract_bgid(contract_bgid);

            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity_bg.setChang_person(userid);
            String oilfield = userEntity.getOilfield();


            StringBuffer sb = new StringBuffer();


            if (StringUtils.isNotBlank(entity_wh.getChange_matters1())) { //金额变更
                entity_y.setMoney(entity_wh.getMoney());
                entity_bg.setMoney(entity_wh.getChange_money());
                sb.append(entity_wh.getChange_matters1() + ",");
            }

            if (StringUtils.isNotBlank(entity_wh.getChange_matters2())) {//履行日期变更
                entity_y.setOperation_start_date(entity_wh.getOperation_start_date());
                entity_y.setCompletion_date(entity_wh.getCompletion_date());
                entity_bg.setOperation_start_date(entity_wh.getChange_operation_start_date());
                entity_bg.setCompletion_date(entity_wh.getChange_completion_date());
                sb.append(entity_wh.getChange_matters2() + ",");
            }
            if (StringUtils.isNotBlank(entity_wh.getChange_matters4())) {//合同签订时间
                entity_y.setEffective_date(entity_wh.getEffective_date());
                entity_bg.setEffective_date(entity_wh.getChang_time());
                sb.append(entity_wh.getChange_matters4() + ",");
            }

            if (StringUtils.isNotBlank(entity_wh.getChange_matters3())) {//其他变更
                entity_bg.setChange_other(entity_wh.getChange_other());
                sb.append(entity_wh.getChange_matters3() + ",");
            }
            if (StringUtils.isNotBlank(entity_wh.getChange_matters5())) {//工作量
                entity_y.setWorkload(entity_wh.getWorkload());
                entity_bg.setWorkload(entity_wh.getChange_workload());
                sb.append(entity_wh.getChange_matters5() + ",");
            }
            if (StringUtils.isNotBlank(entity_wh.getChange_matters6())) {//税率
                entity_y.setTax_rate(entity_wh.getTax_rate());
                entity_bg.setTax_rate(entity_wh.getChange_tax_rate());
                sb.append(entity_wh.getChange_matters6() + ",");
            }

            String str = sb.toString();
            if (str.length() > 0) {

                entity_bg.setChange_matters(str.substring(0, str.length() - 1));
            }


            //更改合同表合同信息 2018.9.26修改为审核后再修改原合同信息
            dao.updateHtxx(entity_bg);


            //保存原始信息和变更后信息记录
            List<HtxxwhEntity> entity_bg_list = new ArrayList<HtxxwhEntity>();
            entity_bg_list.add(entity_y);
            entity_bg_list.add(entity_bg);
            entity_wh.setEl(entity_bg_list);
            entity_wh.setOilfield(oilfield);
            dao.insertHtxxBg(entity_wh);


            //保存上传的照片----------------------------------------------
//			System.out.println("================================"+files.length);
//            if (files != null && files.length > 0) {
//
//                //调用文件通用上传保持类
//                UploadFileStorageUtil ufs = new UploadFileStorageUtil();
//                String path = "CBS/HETONG/";
//                List<Map<String, String>> list = ufs.uploadFileStorageList(files, path);//path 保存路径格式为cbs/hetong/
                List<String> list = entity_wh.getFile_list();
                if (list != null && list.size() > 0) {


                    List<UploadFilesEntity> list_uf = new ArrayList<UploadFilesEntity>();

                    for (String fileUrl : list) {

                        UploadFilesEntity uf = new UploadFilesEntity();
                        uf.setOilfield(oilfield);
                        uf.setId(contract_bgid);
                        uf.setContract_id(entity_wh.getContract_id());
                        uf.setContractor_id(entity_wh.getContractor_id());
                        uf.setContractor_name(entity_wh.getContractor_name());
                        uf.setFiletype("合同变更扫描件");
                        uf.setFileuri(fileUrl);
                        uf.setFileoldname("");
                        uf.setUpload_person(userid);
                        list_uf.add(uf);
                    }

                    UploadFilesEntity uf = new UploadFilesEntity();
                    uf.setOilfield(oilfield);
                    uf.setId(contract_bgid);
                    uf.setFiletype("合同变更扫描件");
                    uf.setEl(list_uf);
                    htxxlrDao.insertUploadFiles(uf);

                }
//            }


        } catch (Exception e) {

            map.put("code", "0");
            map.put("msg", "出错了，保存失败。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();

        }


        return map;
    }

    /**
     * 查询承包商施工队伍，及合同绑定的队伍
     *
     * @param entity
     * @return
     */
    @Override
    public List<QualificationEntity> listQualification(
            QualificationEntity entity) {

        return dao.listQualification(entity);
    }

    /**
     * 根据合同id查询合同变更记录
     *
     * @param contract_id
     * @return
     */
    @Override
    public Map<String, Object> change_Record(String contract_id) {

        Map<String, Object> map = new HashMap<String, Object>();
        List<HtxxwhEntity> list = dao.listchange_Record(contract_id);
        map.put("rows", list);

        return map;
    }

    @Override
    @Transactional
    public Map  changeAuditSave(HtxxwhEntity entity) {

        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            //审核通过，修改合同信息
            if ("2".equals(entity.getAudittab())) {
                List<HtxxwhEntity> list = dao.changeAuditSelect(entity);
                if (list.size() > 0) {
                    dao.changeAuditUpdate(list.get(0));
                }
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setAuditperson(userid);
            dao.changeAuditSave(entity);

            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map  completionConfirmation(HtxxwhEntity entity) {


        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setWgqrr(userid);
            dao.completionConfirmation(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map  bgRemove(HtxxwhEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            dao.bgRemove(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，请重新操作");
            e.printStackTrace();
        }
        return map;
    }

}
