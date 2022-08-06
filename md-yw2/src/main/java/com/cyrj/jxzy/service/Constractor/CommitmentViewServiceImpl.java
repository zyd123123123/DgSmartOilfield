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
import com.cyrj.jxzy.dao.Constractor.CommitmentDao;
import com.cyrj.jxzy.dao.Constractor.CommitmentViewDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.CnsflbEntity;
import com.cyrj.jxzy.entity.Constractor.CommitmentViewEntity;
import com.cyrj.jxzy.util.SetPageUtil;

/*承诺书查看*/
@Service
public class CommitmentViewServiceImpl implements CommitmentViewServiceI {

    @Autowired
    private CommitmentViewDao commitmentviewDao;
    @Autowired
    private CommitmentDao commitmentDao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public Map show_list(CommitmentViewEntity entity, Pager pager) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        entity.setOilfield(oilfield);
        entity.setAttribute(attribute);
        entity.setSearch(search);

        if (StringUtils.isBlank(entity.getEffective_dates())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(new Date());
            entity.setEffective_dates(year);
        }

        int totalRows = commitmentviewDao.count(entity);//查询总记录
        SetPageUtil.setPage(entity, pager);
        List<CommitmentViewEntity> CommitmentView_list = commitmentviewDao.select(entity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("totalRows", totalRows);
        map.put("rows", CommitmentView_list);
        return map;
    }

    /*承诺书打印*/
    @Override
    public Map getPrint(String contract_id) {
        //entity.getContract_id();
        //查询合同数据表中承包商名称，甲方单位等信息
        CommitmentViewEntity entity = commitmentviewDao.getPrint(contract_id);

        //截取合同生效日期
        String effective_dates = entity.getEffective_dates();
        if (StringUtils.isNotBlank(effective_dates))
            entity.setYear(effective_dates.substring(0, 4));
        entity.setMonth(effective_dates.substring(5, 7));
        entity.setDate(effective_dates.substring(8, 10));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("entity", entity);

        //查询HSE附录表数据
        CnsflbEntity entity1= new CnsflbEntity();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity1.setOilfield(userEntity.getOilfield());
        List<CnsflbEntity> entity_list_flb = commitmentDao.cnsflbSelect(entity1);
        map.put("entity_list_flb", entity_list_flb);

        return map;
    }


}
