package com.cyrj.jxzy.service.Constractor;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;

public interface UploadFilesService {

	 Map countImage(UploadFilesEntity entity);
	 
	 List<UploadFilesEntity> imageView(UploadFilesEntity entity);
	 
	 Map uploadFiles(UploadFilesEntity entity, MultipartFile[] files);

	Map upload_Ajax_wsy(UploadFilesEntity entity, MultipartFile[] files);
	
	 Map  uploadFile_sbgl(String file_url, MultipartFile[] files);
}
