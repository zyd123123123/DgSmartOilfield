package com.cyrj.jxzy.Controller.Constractor;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.cyrj.jxzy.util.ConfigureFileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;
import com.cyrj.jxzy.service.Constractor.UploadFilesService;


@RestController
@RequestMapping("/uploadFiles")
@Api(tags = "照片上传浏览处理接口")
public class UploadFilesController {

    @Autowired
    private UploadFilesService service;


    @GetMapping("/countImage")
    @ApiOperation(value = " 查询上传照片数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "filetype", value = "文件类型", paramType = "query", dataType = "String", required = true)
    })
    public Map countImage(String id, String filetype) {
        UploadFilesEntity entity = new UploadFilesEntity();
        entity.setId(id);
        entity.setFiletype(filetype);
        return service.countImage(entity);
    }


    @GetMapping("/imageView")
    @ApiOperation(value = "照片url查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "filetype", value = "文件类型", paramType = "query", dataType = "String", required = true)
    })
    public Map imageView(String id, String filetype) {
        UploadFilesEntity entity = new UploadFilesEntity();
        entity.setId(id);
        entity.setFiletype(filetype);
        List<UploadFilesEntity> list = service.imageView(entity);
        Map map = new HashMap();
        map.put("code", 200);
        map.put("msg", "成功");
        map.put("data", list);
        return map;
    }

    @PostMapping("/uploadFiles")
    @ApiOperation(value = " 批量上传，带水印")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "文件名", paramType = "form", dataType = "String", required = true)
    })
    public Map uploadFiles(UploadFilesEntity entity,@RequestPart(value = "files")  MultipartFile[] files) {

        return service.uploadFiles(entity, files);

    }

    @PostMapping("/upload_Ajax_wsy")
    @ApiOperation(value = " 批量上传，无水印")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "文件名", paramType = "form", dataType = "String", required = true)
    })
    public Map upload_Ajax_wsy(UploadFilesEntity entity, @RequestPart(value = "files") MultipartFile[] files) {

        return service.upload_Ajax_wsy(entity, files);
    }

    @PostMapping("/uploadFile_sbgl")
    @ApiOperation(value = " 批量上传，只上传图片，不保存数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "文件名", paramType = "form", dataType = "String", required = true),
            @ApiImplicitParam(name = "file_url", value = "文件存储路径", paramType = "query", dataType = "String", required = true)
    })
    public Map uploadFile_sbgl(String file_url,@RequestPart(value = "files")  MultipartFile[] files) {
        return service.uploadFile_sbgl(file_url, files);
    }

    @GetMapping(value = "/dqjxzyImage", produces = MediaType.IMAGE_PNG_VALUE)
    public void getImage(String address, HttpServletResponse response) throws Exception {
        String path = ConfigureFileUtil.FILE_SAVE_PATH + address;
        response.setContentType("image/png");
        File file = new File(path);
        InputStream is = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = response.getOutputStream();
        int ch = 0;
        while (-1 != (ch = is.read())) {
            baos.write(ch);
        }
        os.write(baos.toByteArray());
        is.close();
        baos.close();
        os.close();
    }


}
