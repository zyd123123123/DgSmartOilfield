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

import com.cyrj.jxzy.dao.Constractor.FssbDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.FssbEntity;
import com.cyrj.jxzy.entity.Constractor.HbsbEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class FssbServiceImpl implements FssbService {

    @Autowired
    private FssbDao dao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Map<String, Object> showList(String sbbh, String bz, String sbmc, String dwdm, String dwmc, Pager pager) {
        FssbEntity entity = new FssbEntity();
        entity.setSbbh(sbbh);
        entity.setBz(bz);
        entity.setSbmc(sbmc);
        entity.setDwdm(dwdm);
        entity.setDwmc(dwmc);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();
        String search = userEntity.getSearch();
        String oilfield = userEntity.getOilfield();

        entity.setOilfield(oilfield);
        if (attribute.equals("1")) {
            entity.setDwdm(search);
        }

        int totalRows = dao.countShowList(entity);
        SetPageUtil.setPage(entity, pager);
        List<FssbEntity> list = dao.listShowList(entity);
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
    public Map sbbh_yz(String sbbh, String dwdm, String fssbid) {
        FssbEntity entity = new FssbEntity();
        entity.setSbbh(sbbh);
        entity.setDwdm(dwdm);
        entity.setFssbid(fssbid);
        Map map = new HashMap();
        List<FssbEntity> list = dao.listSbbh_yz(entity);
        map.put("code", 200);
        if (list.size() > 0) {
            map.put("data", "0");
            map.put("msg", "设备编号已存在，不可重复");
        } else {

            map.put("data", "1");
            map.put("msg", "设备编号不存在，验证通过");
        }
        return map;
    }

    @Override
    public Map insertSave(FssbEntity entity) {

        Map ro = new HashMap<String, String>();
        ro.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String userid = userEntity.getUser_name();
            entity.setLrr(userid);

            List<FssbEntity> entity_list = entity.getEntity_list();
            if (entity_list != null && entity_list.size() > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");

                int i = 0;
                for (FssbEntity jk : entity_list) {
                    String date = sdf.format(new Date());
                    int dd = (int) (Math.random() * 900 + 100);
                    String fssbid = "FSSB" + date + dd; //合同ID
                    jk.setFssbid(fssbid);
                    i++;
                }
                entity.setEl(entity_list);
                dao.insertSave(entity);
                ro.put("msg", "保存成功");
                ro.put("data", "1");
            } else {

                ro.put("msg", "未接收到数据");
                ro.put("data", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ro.put("msg", "保存出错，请重新提交");
            ro.put("data", "0");
        }
        return ro;
    }

    @Override
    public Map remove(FssbEntity entity) {
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String userid =userEntity.getUser_name();
        entity.setLrr(userid);
        Map map = new HashMap<>();
        map.put("code", 200);
        try {
            dao.updateRemove(entity);
            map.put("msg", "删除成功");
            map.put("data", "1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "出错了，请重新提交");
            map.put("data", "0");
        }
        return map;
    }

    @Override
    public Map updateSave(FssbEntity entity) {
        Map ro = new HashMap();
        ro.put("code", 200);
        try {
            if (StringUtils.isNotBlank(entity.getFssbid())) {
                entity.setSbbh(entity.getSbbh().toUpperCase());
                List<FssbEntity> list = dao.listSbbh_yz(entity);
                if (list != null && list.size() > 0) {
                    ro.put("data", "0");
                    ro.put("msg", "设备编号已存在，不可重复。");

                } else {
                    String user = request.getHeader("user");
                    UserHeaderEntity userEntity = Common.getUserHeader(user);
                    String userid = userEntity.getOilfield();
                    entity.setLrr(userid);
                    dao.updateSave(entity);
                    ro.put("data", "1");
                    ro.put("msg", "修改成功。");
                }
            } else {
                ro.put("data", "0");
                ro.put("msg", "未接收到设备id，修改失败。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ro.put("data", "0");
            ro.put("msg", "出错误了，修改失败。");
        }
        return ro;
    }

}
