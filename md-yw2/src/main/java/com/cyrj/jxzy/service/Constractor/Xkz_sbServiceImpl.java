package com.cyrj.jxzy.service.Constractor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import com.cyrj.jxzy.dao.Constractor.Xkz_sbDao;
import com.cyrj.jxzy.entity.Constractor.Xkz_sbEntity;

@Service
public class Xkz_sbServiceImpl implements Xkz_sbService {

    @Autowired
    private Xkz_sbDao dao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public List<Xkz_sbEntity> showView(Xkz_sbEntity entity) {

        return dao.listShowView(entity);
    }

    @Override
    public List<Xkz_sbEntity> select(Xkz_sbEntity entity) {

        String sbmc = "";
        try {
            sbmc = URLDecoder.decode(entity.getSbmc(), "UTF-8");
            entity.setSbmc(sbmc);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<Xkz_sbEntity> entity_list = dao.listSelect(entity);

        return entity_list;
    }

    @Override
    public Map  bangding_save(Xkz_sbEntity entity) {

        Map  map = new HashMap ();
        map.put("code",200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            String userid = userEntity.getUser_name();
            entity.setOilfield(oilfield);
            entity.setLrr(userid);
            List<Xkz_sbEntity> list = dao.listBangdingSave(entity);

            if (list != null && list.size() > 0) {
                dao.updateBangdingSave(entity);
            } else {
                dao.insertBangdingSave(entity);
            }
            map.put("data", "1");
            map.put("msg", "保存成功。");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败。");
            e.printStackTrace();
        }
        return map;
    }

}
