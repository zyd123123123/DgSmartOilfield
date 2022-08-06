package com.cyrj.jxzy.service.Constractor;

import java.text.SimpleDateFormat;
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
import com.cyrj.jxzy.dao.Constractor.BigTextDao;
import com.cyrj.jxzy.dao.Constractor.XkzDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.BigTextEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.entity.Constractor.NlpgshEntity;
import com.cyrj.jxzy.entity.Constractor.Qualification_personEntity;
import com.cyrj.jxzy.entity.Constractor.XkzEntity;
import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;
import com.cyrj.jxzy.entity.Constractor.XkzhtEntity;
import com.cyrj.jxzy.entity.Constractor.XkzshEntity;
import com.cyrj.jxzy.entity.Constractor.ZysbEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class XkzServiceImpl implements XkzService {

    @Autowired
    private XkzDao dao;
    @Autowired
    private BigTextDao bigTextDao;
    @Autowired
    private HttpServletRequest request;

    /**
     * 许可证申请list
     */
    @Override
    public Map  xkzsqList(NlpgshEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);


        //总记录数
        int totalRows = dao.countXkzsq(entity);
        SetPageUtil.setPage(entity, pager);
        List<NlpgshEntity> list = dao.listXkzsq(entity);
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
    public Map  xkzsqyz(XkzhtEntity entity) {

        Map  map = new HashMap ();
        map.put("code", 200);
        List<XkzhtEntity> list = dao.xkzsqyz(entity);

        if (list.size() > 0) {

            map.put("data", "0");
            map.put("msg", "队伍已申请施工许可证，不可重复申请.");
        } else {
            //验证是否上传能力评估表扫描件
            int mm = dao.nlpgfile(entity);
            if (mm > 0) {
                map.put("data", "1");
                map.put("msg", "无许可证，可以申请");
            } else {
                map.put("data", "0");
                map.put("msg", "未上传能力评估表扫描件，不可申请.");
            }
        }

        return map;
    }

    @Override
    public HtxxckEntity contract(String contract_id) {

        return dao.contract(contract_id);
    }

    @Override
    public XkzEntity term(String term_id) {

        return dao.term(term_id);
    }

    @Override
    public List<Qualification_personEntity> person(String term_id) {

        return dao.person(term_id);
    }

    @Override
    public ZysbEntity zysb(String term_id) {

        return dao.zysb(term_id);
    }

    @Override
    public List<Xkz_sbEntity> zyptsb(String term_id) {

        return dao.zyptsb(term_id);
    }

    @Override
    @Transactional
    public Map  xkzsqSave(XkzhtEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
            String date = sdf.format(new Date());
            int dd = (int) (Math.random() * 900 + 100);
            String xkz_id = "XKZ" + date + dd; //合同ID
            entity.setPermit_id(xkz_id);

            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String userid = userEntity.getUser_name();
            entity.setOilfield(oilfield);
            entity.setApply_person(userid);

            BigTextEntity entity_dwb = new BigTextEntity();
            entity_dwb.setOilfield(oilfield);
            entity_dwb.setText_id(entity.getPermit_id());
            entity_dwb.setContract_id(entity.getContract_id());
            entity_dwb.setTeam_id(entity.getTeam_id());
            entity_dwb.setTeam_qualification(entity.getTeam_qualification());
            entity_dwb.setContractor_name(entity.getDwmc());
            entity_dwb.setType(entity.getType());
            entity_dwb.setText(entity.getNeirong().getBytes("UTF-8"));

            //按文本id，文本类型查询,若已存在就update，不存在用insert
            List<BigTextEntity> li = bigTextDao.listBigText(entity_dwb);
            if (li.size() > 0) {
                bigTextDao.updateBigText(entity_dwb);
            } else {
                bigTextDao.insertBigText(entity_dwb);
            }
            dao.insertXkzsqSave(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "申请失败了。");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> xkzshList(XkzshEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限

        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        //总记录数
        int totalRows = dao.countXkzsh(entity);
        SetPageUtil.setPage(entity, pager);
        List<XkzshEntity> list = dao.listXkzsh(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", list);
        return map;
    }

    @Override
    public Map  auditSave(XkzshEntity entity) {
        Map map = new HashMap ();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setAudit_person(userid);
            dao.updateAuditSave(entity);
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
    public Map  xkzckList(XkzshEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);


        //总记录数
        int totalRows = dao.countXkzck(entity);
        SetPageUtil.setPage(entity, pager);
        List<XkzshEntity> list = dao.listXkzck(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    /**
     * 撤回保存
     */
    @Override
    public Map  revokeSave(XkzshEntity entity) {

        Map  map = new HashMap();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setAudit_person(userid);

            dao.updatetRevokeSave(entity);
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
    public Map  xkzck_ht_List(XkzshEntity entity, Pager pager) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search =userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);


        //总记录数
        int totalRows = dao.countxkzck_ht(entity);
        SetPageUtil.setPage(entity, pager);
        List<XkzshEntity> list = dao.listxkzck_ht(entity);
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
    public Map  xkzck_term_List(XkzshEntity entity) {


        List<XkzshEntity> list = dao.listxkzck_term(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", list);
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public Map  xkz_List(XkzshEntity entity) {

        List<XkzshEntity> list = dao.xkz_List(entity);
        Map  map = new HashMap ();
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }
}
