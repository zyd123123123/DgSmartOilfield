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
import com.cyrj.jxzy.dao.Constractor.NlpgDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CbsFj2Entity;
import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class NlpgServiceImpl implements NlpgService {

    @Autowired
    private NlpgDao dao;
    @Autowired
    private HttpServletRequest request;


    @Override
    public List<CbsFj2Entity> ListNlpgflb() {

        CbsFj2Entity entity= new CbsFj2Entity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());

        return dao.listNlpgflb(entity);
    }

    @Override
    @Transactional
    public Map flbSave(CbsFj2Entity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            entity.setOilfield(userEntity.getOilfield());
            dao.deleteflbSave(entity);
            dao.insertflbSave(entity);
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "保存成失败。");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map nlgpsqList(ContractTeamEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        //总记录数
        int totalRows = dao.countNlpgsq(entity);
        SetPageUtil.setPage(entity, pager);
        List<ContractTeamEntity> list = dao.listNlpgsq(entity);
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
    public List<Map<String, String>> applyTerm(ContractTeamEntity entity) {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<ContractTeamEntity> entity_list = dao.applyTerm(entity);
        for (ContractTeamEntity nb : entity_list) {

            Map<String, String> map = new HashMap<String, String>();
            map.put("key", nb.getTeam_name());
            map.put("value", nb.getSjid());
            list.add(map);

        }

        return list;
    }

    @Override
    public Map applySave(ContractTeamEntity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        try {
            List<ContractTeamEntity> enetity_list = dao.termList(entity);

            if (enetity_list.size() > 0) {
                map.put("msg", "已申请，不可重复申请。");
                map.put("data", "0");
            } else {
                String user = request.getHeader("user");
                UserHeaderEntity userEntity = Common.getUserHeader(user);
                String userid = userEntity.getUser_name();
                entity.setApply_person(userid);
                entity.setOilfield(userEntity.getOilfield());
//			//拼接评估表ID
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
                String date = sdf.format(new Date());
                int dd = (int) (Math.random() * 900 + 100);
                String pgb_id = "PGB" + date + dd; //合同ID
                entity.setPgb_id(pgb_id);

                dao.applySave(entity);
                map.put("msg", "申请成功。");
                map.put("data", "1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "申请失败。");
            map.put("data", "0");
        }
        return map;
    }

    @Override
    public Map nlgpsqjlList(ContractTeamEntity entity,
                            Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        //总记录数
        int totalRows = dao.countNlpgsqjl(entity);
        SetPageUtil.setPage(entity, pager);
        List<ContractTeamEntity> list = dao.listNlpgsqjl(entity);
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
    public ContractTeamEntity contractTeam(String pgb_id) {

        return dao.contractTeam(pgb_id);
    }

    @Override
    @Transactional
    public Map auditSave( NlpgshEntity entity) {

        Map map = new HashMap();
        map.put("code", 200);
        try {
            if (entity.getAudit_jg().equals("合格")) {
                entity.setAudit_tab("1");
            } else if (entity.getAudit_jg().equals("不合格")) {
                entity.setAudit_tab("2");
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            entity.setOilfield(userEntity.getOilfield());
            entity.setApply_person(userEntity.getUser_name());
            dao.insertAudit(entity);
            dao.updateAudit(entity);

            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("data", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public Map  nlgpck(ContractTeamEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        //总记录数
        int totalRows = dao.countNlpgck(entity);
        SetPageUtil.setPage(entity, pager);
        List<ContractTeamEntity> list = dao.listNlpgck(entity);
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
    public List<CbsFj2Entity> nlpgList(String pgb_id) {


        return dao.nlpgList(pgb_id);
    }

    @Override
    public Map revokeSave(NlpgshEntity entity) {

        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setBack_person(userid);
            dao.revokeSave(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，清楚重新操作");
            e.printStackTrace();
        }
        return map;
    }

}
