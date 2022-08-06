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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrj.jxzy.dao.Constractor.FjglDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.FjglEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxckEntity;
import com.cyrj.jxzy.util.SetPageUtil;

@Service
public class FjglServiceImpl implements FjglServiceI {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FjglDao fjglDao;
    private List<FjglEntity> entity_list = new ArrayList<FjglEntity>();



    @Override
    public Map<String, Object> show_list(String parent_id,String annex_name, Pager pager) {

        FjglEntity entity = new FjglEntity();
        entity.setParent_id(parent_id);
        entity.setAnnex_name(annex_name);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        int totalRows = fjglDao.countShow_list(entity);
        SetPageUtil.setPage(entity, pager);
        List<FjglEntity> list = fjglDao.listShow_list(entity);
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("rows",list);
        map1.put("totalRows",totalRows);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", map1);
        return map;
    }

    @Override
    public Map addSave(FjglEntity entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        entity.setLrr(userEntity.getUser_name());

        //拼接附件ID
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
        String date = sdf.format(new Date());
        int dd = (int) (Math.random() * 900 + 100);
        String fjid = "FJ" + date + dd; //合同ID
        entity.setId(fjid);
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            fjglDao.insertAdd(entity);
            map.put("code", 200);
            map.put("msg", "添加成功。");
            map.put("data", "");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "出错误了，添加失败。");
            map.put("data", "");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map editSave(FjglEntity entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        entity.setLrr(userEntity.getUser_name());
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            fjglDao.updateEdit(entity);
            map.put("code", 200);
            map.put("msg", "添修改成功。");
            map.put("data", "");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "出错误了，修改失败。");
            map.put("data", "");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map removeSave(String id) {

        Map<String, Object> map = new HashMap<String, Object>();
        FjglEntity entity = new FjglEntity();
        entity.setId(id);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            entity.setOilfield(userEntity.getOilfield());
            entity.setLrr(userEntity.getUser_name());

            List<FjglEntity> list = fjglDao.listFjgl(entity);
            //递归查询所有子集
            digui(list, entity.getId());
            //添加上删除附录名称
            entity_list.add(entity);
            entity.setEl(entity_list);
            //批量处理，将tab改为0废弃
            fjglDao.updateRemove(entity);
            map.put("code", 200);
            map.put("msg", "删除成功。");
            map.put("data", "");
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "出错误了，删除失败。");
            map.put("data", "");
            e.printStackTrace();
        }
        return map;
    }


    //递归
    public void digui(List<FjglEntity> list, String id) {


        List<String> str = new ArrayList<String>();
        for (FjglEntity fh : list) {
            if (fh.getParent_id().equals(id)) {
                entity_list.add(fh);
                str.add(fh.getId());
            }
        }
        if (str.size() > 0) {
            for (String ss : str) {
                this.digui(list, ss);

            }
        }

    }

    @Override
    public Map setId_Returnid(String parent_id, String parent_name) {
        Map resultMap = new HashMap();
        FjglEntity entity = new FjglEntity();
        List<FjglEntity> entity_list = new ArrayList<FjglEntity>();
        //按附加id查询,返回key为附件名称，value为附件id
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        entity.setParent_id(parent_id);
        entity.setParent_name(parent_name);
        entity_list = fjglDao.setId_ReturnFj(entity);
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (FjglEntity fj : entity_list) {

            Map<String, String> map = new HashMap<String, String>();
            map.put("key", fj.getAnnex_name());
            map.put("value", fj.getId());

            list.add(map);
        }
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", list);
        return resultMap;

    }

    @Override
    public Map selectTree_name(String parent_id, String parent_name) {
        Map resultMap = new HashMap();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        FjglEntity entity = new FjglEntity();
        entity.setParent_id(parent_id);
        entity.setParent_name(parent_name);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        List<FjglEntity> list_entity = fjglDao.setId_ReturnFj(entity);
        for (FjglEntity entity1 : list_entity) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("id", entity1.getAnnex_name());
            map.put("name", entity1.getAnnex_name());
            map.put("parentId", entity1.getParent_id());
            list.add(map);
        }
        resultMap.put("code", 200);
        resultMap.put("msg", "成功。");
        resultMap.put("data", list);
        return resultMap;
    }

}
