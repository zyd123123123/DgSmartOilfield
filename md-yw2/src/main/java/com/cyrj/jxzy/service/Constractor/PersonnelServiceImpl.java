package com.cyrj.jxzy.service.Constractor;

import java.text.SimpleDateFormat;


import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrj.jxzy.entity.Admin.UserHeaderEntity;
import com.cyrj.jxzy.util.Common;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.cyrj.jxzy.dao.Constractor.PcUnitCuopDao;
import com.cyrj.jxzy.dao.Constractor.PersonnelDao;
import com.cyrj.jxzy.entity.Common.Pager;
import com.cyrj.jxzy.entity.Constractor.PcUnitEntity;
import com.cyrj.jxzy.entity.Constractor.PersonEntity;
import com.cyrj.jxzy.entity.Constractor.Person_changeEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.util.ConfigureFileUtil;
import com.cyrj.jxzy.util.SetPageUtil;
import com.cyrj.jxzy.util.UploadFileStorageUtil;

import org.springframework.web.multipart.MultipartFile;


@Service
public class PersonnelServiceImpl implements PersonnelServiceI {

    @Autowired
    private PcUnitCuopDao pcUnitCuopDao;
    @Autowired
    private PersonnelDao personDao;
    @Autowired
    private HttpServletRequest request;

    @Override
    public List<PersonEntity> personnel_entry(PersonEntity person_entity) {

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        person_entity.setOilfield(userEntity.getOilfield());

        return personDao.selectByParam1(person_entity);
    }


    @Override
    @Transactional
    public Map personnel_save(PersonEntity person_entity) {
        Map map = new HashMap();
        map.put("code", 200);
        String ryid = "";
        // 获取当前操作人员真实姓名
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String userid = userEntity.getUser_name();
        person_entity.setLrr(userid);
        String oilfield = userEntity.getOilfield();
        person_entity.setOilfield(oilfield);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
        // 保存上传的图片文件,人员保存
        List<PersonEntity> person_entityList = person_entity.getPerson_entityList();
        if (person_entityList != null && person_entityList.size() > 0) {
            try {
                //根据身份证号批量查询
                Map sfz_map = new HashMap<String, Object>();
                List<PersonEntity> list_sfz = personDao.personnel_save_select(person_entity);
                if (list_sfz.size() > 0) {
                    for (PersonEntity entity : list_sfz) {
                        if ("1".equals(entity.getState())) {
                            map.put("data", "0");
                            map.put("msg", person_entity.getSfzh() + "已绑定" + entity.getDwmc() + "，修改失败。");
                            return map;
                        } else {
                            sfz_map.put(entity.getSfzh(), entity);
                        }
                    }
                    //删除存在用户
                    PersonEntity entity = new PersonEntity();
                    entity.setPerson_entityList(list_sfz);
                    entity.setOilfield(oilfield);
                    personDao.personnel_save_delete(entity);
                }
                String maxNum = personDao.maxNum();
                if (StringUtils.isBlank(maxNum)) {
                    maxNum = "dq000000";
                }
                int maxNum1 = Integer.parseInt("1" + maxNum.substring(2, 8));

                for (PersonEntity pe : person_entityList) {
                    String date = sdf.format(new Date());
                    int dd = (int) (Math.random() * 900 + 100);
                    PersonEntity en = (PersonEntity) sfz_map.get(pe.getSfzh());
                    if (en != null) {
                        pe.setRyid(en.getRyid());
                        pe.setNum(en.getNum());
                    } else {
                        ryid = "RYID" + date + dd;
                        pe.setRyid(ryid);
                        maxNum1 = maxNum1 + 1;
                        pe.setNum("DQ" + Integer.toString(maxNum1).substring(1, 7));
                    }
                }
                person_entity.setPerson_entityList(person_entityList);
                personDao.insert(person_entity);
                map.put("data", "1");
                map.put("msg", "保存成功。");

            } catch (Exception e) {
                map.put("data", "0");
                map.put("msg", "保存失败。");
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } else {
            map.put("data", "0");
            map.put("msg", "没有接收到数据");
        }

        return map;
    }

    @Override
    public Map ID_card(PersonEntity person_entity) {
        Map map = new HashMap();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        person_entity.setOilfield(oilfield);
        List<PersonEntity> list = personDao.ID_card(person_entity);

        if (list.size() > 0) {
            if ("0".equals(list.get(0).getState())) {
                map.put("entity", list.get(0));
                map.put("rows", "2");
            } else {
                map.put("entity", list.get(0));
                map.put("termname", list.get(0).getDwmc());
                map.put("rows", "0");
            }
        } else {
            map.put("rows", "1");
        }
        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public Map select_cx(PersonEntity person_entity, Pager pager) {

        Map<String, Object> map = new HashMap<String, Object>();

        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        if (attribute.equals("1")) {
            person_entity.setDwdm(search);

        }
        String oilfield = userEntity.getOilfield();
        person_entity.setOilfield(oilfield);
        SetPageUtil.setPage(person_entity, pager);

        //查询
        List<PersonEntity> person_entityList = personDao.selectByParam4(person_entity);
        if (person_entityList != null && person_entityList.size() > 0 && person_entityList.get(0) != null) {
            for (PersonEntity pe : person_entityList) {
                if (StringUtils.isNotBlank(pe.getFileuri())) {
//                    pe.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE + pe.getFileuri());
                    pe.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE);
                }
            }
        }
        //总记录数

        int totalRows = personDao.count4(person_entity);

        // 拼成所需数据返回前台
        map.put("pageNo", pager.getPageNo());
        map.put("totalRows", totalRows);
        map.put("rows", person_entityList);
        return map;
    }

    @Override
    public List<Map<String, String>> unit_select1(String id) {
        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        if (StringUtils.isNotBlank(id)) {
            pcUnitEntity.setOilfield(oilfield);
            pcUnitEntity.setId(id);
            List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectDq(pcUnitEntity);
            for (PcUnitEntity pcUnit : entity_list_PcUnit) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", pcUnit.getUnitname()); // key存名字
                map.put("value", pcUnit.getId()); // value存编号
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public Map update_save(PersonEntity person_entity) {
        Map map = new HashMap();
        map.put("code", 200);
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        person_entity.setOilfield(oilfield);

        if (StringUtils.isNotBlank(person_entity.getRyid())) {
            //删除当前所修改数据
            person_entity.setSfzh(person_entity.getSfzh().toUpperCase());
            List<PersonEntity> li = personDao.ID_card(person_entity);
            if (li != null && li.size() > 0) {
                map.put("data", "0");
                map.put("msg", person_entity.getSfzh() + "已绑定" + li.get(0).getDwmc() + "，修改失败。");
            } else {
                personDao.update(person_entity);
                map.put("data", "1");
                map.put("msg", "修改成功。");
            }
        } else {
            map.put("data", "0");
            map.put("msg", "未接收到人员编号，修改失败。");
        }
        return map;
    }

    @Override
    public Map personnel_select(PersonEntity person_entity, Pager pager) {

        Map<String, Object> map = new HashMap<String, Object>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        String oilfield = userEntity.getOilfield();
        person_entity.setOilfield(oilfield);
        if (attribute.equals("1")) {
            person_entity.setDwdm(search);
        }

        SetPageUtil.setPage(person_entity, pager);
        //查询
        List<PersonEntity> person_entityList = personDao.selectByParam(person_entity);
        if (person_entityList != null && person_entityList.size() > 0 && person_entityList.get(0) != null) {
            for (PersonEntity pe : person_entityList) {
                if (StringUtils.isNotBlank(pe.getFileuri())) {
                    pe.setFileuri2(ConfigureFileUtil.DQJXZYIMAGE + pe.getFileuri());
                }
            }
        }
        //总记录数
        int totalRows = personDao.count(person_entity);
        map.put("totalRows", totalRows);
        map.put("rows", person_entityList);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }

    @Override
    public List<Map<String, String>> unit_select11(String parentid) {
        PcUnitEntity pcUnitEntity = new PcUnitEntity();
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String oilfield = userEntity.getOilfield();
        pcUnitEntity.setOilfield(oilfield);
        if (StringUtils.isNotBlank(parentid)) {
            pcUnitEntity.setParentid(parentid);
            List<PcUnitEntity> entity_list_PcUnit = pcUnitCuopDao.selectByParam7(pcUnitEntity);
            for (PcUnitEntity pcUnit : entity_list_PcUnit) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("key", pcUnit.getUnitname()); //key存名字
                map.put("value", pcUnit.getId());     //value存编号
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public Map removeSave(PersonEntity person_entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            personDao.removeSave(person_entity);
            map.put("data", "1");
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败！");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public PersonEntity ryselect(PersonEntity entity) {

        return personDao.ryselect(entity);
    }

    @Override
    public String unitname(String unitid) {

        return personDao.unitname(unitid);
    }

    public List<String> exportExcel(MultipartFile file, String termid) {
        //错误返回
        List error = new ArrayList();
        //读取工作簿
        String fileName = file.getOriginalFilename();
        PersonEntity entity = new PersonEntity();
        entity.setTermid(termid);
        List<PersonEntity> person_entityList = new <PersonEntity>ArrayList();
        try {
            Workbook workBook = WorkbookFactory.create(file.getInputStream());
            //读取工作表
            Sheet sheet = workBook.getSheetAt(0);
            int rowNumber = sheet.getPhysicalNumberOfRows();
//			System.out.println("本次提交数据"+(rowNumber-3)+"条========================");
            //校验是否填写内容
            if (rowNumber <= 3) {
                error.add("文件无内容");
                return error;
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            // 获取油田id
            String oilfield = userEntity.getOilfield();
            // 获取当前操作人员真实姓名
            String truename = userEntity.getUser_name();
            //循环读取每一行数据并校验
            for (int i = 3; i < rowNumber; i++) {
                PersonEntity ry = new PersonEntity();
                //读取行
                Row row = sheet.getRow(i);

                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                ry.setPhone(row.getCell(2).getStringCellValue().trim());//手机号

                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                String sfzh = row.getCell(3).getStringCellValue();
                sfzh.replace("'", " ");
                if (sfzh != null && sfzh.length() == 18) {
                    ry.setSfzh(sfzh);//身份证号
                }

                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                ry.setCity(row.getCell(4).getStringCellValue().trim());//市

                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                ry.setCounties(row.getCell(5).getStringCellValue().trim());//县

                row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                ry.setTown(row.getCell(6).getStringCellValue().trim());//镇

                row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
                ry.setVillage(row.getCell(7).getStringCellValue().trim());//村

                if (ry.getSfzh() != null && ry.getSfzh().length() > 0) {
                    person_entityList.add(ry);
                }
            }
            if (person_entityList.size() > 0) {
                entity.setEl(person_entityList);
                try {
                    personDao.import_edit(entity);
                } catch (Exception e) {
                    error.add("文件上传失败！");
                    e.printStackTrace();
                    return error;
                }
            }
            workBook.close();
        } catch (Exception e) {
            e.printStackTrace();
            error.add("文件上传失败！");
            return error;
        }
        return error;
    }

    @Override
    public Map printSave(PersonEntity entity) {

        Map map = new HashMap();
        try {
            personDao.printSave(entity);
            map.put("code", "1");
        } catch (Exception e) {
            map.put("code", "0");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public PersonEntity selectone(PersonEntity entity) {

        return personDao.selectone(entity);
    }

    @Override
    public List<Map> rybd_select(PersonEntity entity) {
        List<Map> li = new ArrayList<Map>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        entity.setOilfield(userEntity.getOilfield());
        List<PersonEntity> list = personDao.rybd_select(entity);
        for (PersonEntity entity1 : list) {
            Map map = new HashMap<String, String>();
            map.put("key", entity1.getXm() + entity1.getSfzh());
            map.put("value", entity1.getRyid());
            li.add(map);
        }
        return li;
    }

    @Override
    public Map ry_bd_save(PersonEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        try {
            if(StringUtils.isNotEmpty(entity.getRyid())){
                List<PersonEntity> list = personDao.ry_bd_select(entity);
                if (list.size() > 0) {
                    map.put("data", "0");
                    map.put("msg", list.get(0).getSfzh() + "已绑定" + list.get(0).getDwmc() + "，不能重复绑定。");
                    return map;
                }
            }

            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setLrr(userid);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            personDao.ry_bd_save(entity);
            map.put("data", "1");
            map.put("msg", "成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "保存失败");
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public Map bg_select(Person_changeEntity entity, Pager pager) {

        Map<String, Object> map = new HashMap<String, Object>();
        String user = request.getHeader("user");
        UserHeaderEntity userEntity = Common.getUserHeader(user);
        String attribute = userEntity.getAttribute();//数据属性：1作业，2非作业（生产、设计、机关）
        String search = userEntity.getSearch();//数据权限
        if (attribute.equals("1")) {
            entity.setDwdm_new(search);

        }
        String oilfield = userEntity.getOilfield();
        entity.setOilfield(oilfield);
        SetPageUtil.setPage(entity, pager);

        //查询
        List<Person_changeEntity> list = personDao.bg_select_list(entity);
        //总记录数
        int totalRows = personDao.bg_select_count(entity);
        map.put("totalRows", totalRows);
        map.put("rows", list);

        Map resultMap = new HashMap();
        resultMap.put("code", 200);
        resultMap.put("msg", "成功");
        resultMap.put("data", map);
        return resultMap;
    }


    @Override
    @Transactional
    public Map  bgsq_save(Person_changeEntity entity, MultipartFile[] files) {
        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            List<Person_changeEntity> list1 = personDao.bgsq_save_select(entity);
            if (list1.size() > 0) {
                map.put("data", "0");
                map.put("msg", "该人员已被" + list1.get(0).getDwmc_new() + "申请待审核，不可重复申请！");
                return map;
            }
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String oilfield = userEntity.getOilfield();
            entity.setOilfield(oilfield);
            String userid = userEntity.getUser_name();
            entity.setApply_person(userid);
            SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmsssss");
            String date = sdf.format(new Date());
            int dd = (int) (Math.random() * 900 + 100);
            String bg_id = "BG" + date + dd; //合同ID
            entity.setBg_id(bg_id);
            entity.setFiletab("0");
            //保存上传的照片----------------------------------------------
            if (files != null && files.length > 0) {
                //调用文件通用上传保持类
                UploadFileStorageUtil ufs = new UploadFileStorageUtil();
                String path = "CBS/DWGL/RYGL/RYBG";
                List<Map<String, String>> list = ufs.uploadFileStorageList(files, path);//path 保存路径格式为cbs/hetong/
                if (list != null && list.size() > 0) {
                    entity.setFiletab("1");
                    List<Person_changeEntity> list_uf = new ArrayList<Person_changeEntity>();
                    for (Map<String, String> map1 : list) {
                        Person_changeEntity en = new Person_changeEntity();
                        en.setOilfield(oilfield);
                        en.setApply_person(userid);
                        en.setBg_id(bg_id);
                        en.setFileurl(map1.get("filepath"));
                        en.setFiletype("人员变更证明");
                        list_uf.add(en);
                    }
                        entity.setEl(list_uf);
                        personDao.bgsq_save1(entity);
                }
            }
            personDao.bgsq_save2(entity);
            map.put("data", "1");
            map.put("msg", "申请成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，保存失败!");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public Map bgsq_th(Person_changeEntity entity) {

        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            personDao.bgsq_th_delete(entity);
            map.put("data", "1");
            map.put("msg", "撤销成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，撤销失败");
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public List<UploadFilesEntity> imageView(UploadFilesEntity entity) {

        return personDao.imageView(entity);
    }


    @Override
    public Map bgshSave(Person_changeEntity entity) {

        Map map = new HashMap ();
        map.put("code", 200);
        try {
            String user = request.getHeader("user");
            UserHeaderEntity userEntity = Common.getUserHeader(user);
            String userid = userEntity.getUser_name();
            entity.setAudit_person(userid);
            personDao.bgshSave(entity);
            map.put("data", "1");
            map.put("msg", "保存成功");
        } catch (Exception e) {
            map.put("data", "0");
            map.put("msg", "出错了，保存失败");
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public Map edit_yq(PersonEntity entity) {
        Map map = new HashMap();
        map.put("code", 200);
        List<PersonEntity> list = personDao.edit_yq(entity);
        if (list.size() > 0) {
            map.put("msg", "人员已绑定" + list.get(0).getTermname() + ",解除绑定后才可修改。");
            map.put("data", "0");
        } else {
            map.put("data", "1");
        }
        return map;
    }

}
