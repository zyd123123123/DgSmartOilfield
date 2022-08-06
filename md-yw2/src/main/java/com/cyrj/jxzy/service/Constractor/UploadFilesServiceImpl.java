package com.cyrj.jxzy.service.Constractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.cyrj.jxzy.dao.Constractor.UploadFilesDao;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.util.ConfigureFileUtil;
import com.cyrj.jxzy.util.UploadFileStorageUtil;

@Service
public class UploadFilesServiceImpl implements UploadFilesService {

    @Autowired
    private UploadFilesDao dao;
    @Autowired
    private HttpServletRequest request;

    /**
     * 查询上传照片数量
     *
     * @param entity
     * @return
     */
    @Override
    public Map countImage(UploadFilesEntity entity) {
        int num = dao.countImage(entity);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", num);
        return map;
    }

    @Override
    public List<UploadFilesEntity> imageView(UploadFilesEntity entity) {

        if (StringUtils.isNoneBlank(entity.getFiletype())) {
            try {
                String filetype = URLDecoder.decode(entity.getFiletype(), "UTF-8");
                entity.setFiletype(filetype);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        List<UploadFilesEntity> list = dao.listImageView(entity);
        return list;
    }

    @Override
    @Transactional
    public Map  uploadFiles(UploadFilesEntity entity,MultipartFile[] files) {

        Map  map = new HashMap ();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", "1");
        try {
            String path = "";

            if ("HSE承诺书".equals(entity.getFiletype())) {

                path = "CBS/HSE/";

            } else if ("施工许可证".equals(entity.getFiletype())) {


                path = "CBS/XKZ/";

            } else if ("能力评估表".equals(entity.getFiletype())) {


                path = "CBS/PGB/";

            } else if ("合同附件".equals(entity.getFiletype())) {


                path = "CBS/HETONG/";

            }
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
                    List<UploadFilesEntity> list_uf = new ArrayList<UploadFilesEntity>();
                    for (Map<String, String> map1 : list) {
                        UploadFilesEntity uf = new UploadFilesEntity();
                        uf.setOilfield(oilfield);
                        uf.setId(entity.getId());
                        uf.setTeam_id(entity.getTeam_id());
                        uf.setTeam_qualification(entity.getTeam_qualification());
                        uf.setContract_id(entity.getContract_id());
                        uf.setContractor_id(entity.getContractor_id());
                        uf.setFiletype(entity.getFiletype());
                        uf.setFileuri(map1.get("filepath"));
                        uf.setFileoldname(map1.get("fileNameOld"));
                        uf.setUpload_person(userid);
                        list_uf.add(uf);
                    }
                    entity.setEl(list_uf);
                    dao.deleteImage(entity);
                    dao.insertImage(entity);
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
    public Map  uploadFile_sbgl(String file_url,
                                               MultipartFile[] files) {
        Map  map = new HashMap ();
        map.put("code", 200);
        try {
            if (files != null && files.length > 0) {
                UploadFileStorageUtil ufs = new UploadFileStorageUtil();
                List<Map<String, String>> list = ufs.uploadFileStorageList(files, file_url);//path 保存路径格式为cbs/hetong/
                map.put("msg", "上传成功");
                map.put("data", list.get(0).get("filepath"));
            } else {
                map.put("code", "上传失败");
                map.put("data", "");
            }
        } catch (Exception e) {
            map.put("code", "上传失败");
            map.put("data", "");
            e.printStackTrace();
        }
        return map;
    }


    @Override
    public Map upload_Ajax_wsy(UploadFilesEntity entity, MultipartFile[] files) {

        Map  map = new HashMap ();

        String path = entity.getFile_url();
        List<String> dbnames = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        if (files != null && files.length > 0) {
            File file = new File(ConfigureFileUtil.FILE_SAVE_PATH + path + year + "/" + month);
            if (!file.exists()) {
                file.mkdirs();
            }
            for (int i = 0; i < files.length; i++) {
                String fileNameOld = files[i].getOriginalFilename();
                String suffix = fileNameOld.substring(fileNameOld.lastIndexOf(".") + 1);
                String newName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + "." + suffix;
                File file_new = new File(ConfigureFileUtil.FILE_SAVE_PATH + path + year + "/" + month + "/" + newName);
                try {
                    files[i].transferTo(file_new);
                    map.put("fileNameOld", fileNameOld);//原始文明名称
                    map.put("fileNameNew", newName);//新文件名称
                    map.put("filepath", path + year + "/" + month + "/" + newName);//文件存储路径
                    dbnames.add(path + year + "/" + month + "/" + newName);

                } catch (IllegalStateException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (dbnames.size() > 0) {
                map.put("fileurl", dbnames);
                map.put("fileurl2", ConfigureFileUtil.DQJXZYIMAGE);
            } else {
                map.put("fileurl", dbnames);
            }
        }
        Map  resultMmap = new HashMap ();
        resultMmap.put("code", 200);
        resultMmap.put("msf", "成功");
        resultMmap.put("data",map);
        return resultMmap;
    }

}
