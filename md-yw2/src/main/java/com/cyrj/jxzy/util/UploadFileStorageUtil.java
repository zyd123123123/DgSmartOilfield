package com.cyrj.jxzy.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;
/**
 * 文件通用上传保持类 2019.02.01
 * @author admin
 *
 */
public class UploadFileStorageUtil {
	
	/**
	 * 上传文件保存方法
	 * @param files file文件
	 * @param path 保存路径格式为cbs/hetong/
	 * @return fileNameOld 原始文明名称，  fileNameNew 新文件名称， filepath 文件存储路径
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public List<Map<String, String>> uploadFileStorageList(MultipartFile[] files,String path) throws IllegalStateException, IOException{
		
		 List<Map<String, String>> list= new ArrayList<Map<String, String>>();
		 
		if(files!=null&&files.length>0){			
			Calendar cal = Calendar.getInstance();
			int year=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH)+1;
			File file = new File(ConfigureFileUtil.FILE_SAVE_PATH+path+year+"/"+month);
			if(!file.exists()){				
				file.mkdirs();				
			}
			
			for(int i=0;i<files.length;i++){
				if(!files[i].isEmpty()){
					String fileNameOld = files[i].getOriginalFilename();
					if(StringUtils.isNotEmpty(fileNameOld)){
						String suffix = fileNameOld.substring(fileNameOld.lastIndexOf(".")+1);
						String newName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()+"."+suffix;
						File file_new= new File(ConfigureFileUtil.FILE_SAVE_PATH+path+year+"/"+month+"/"+newName);
						files[i].transferTo(file_new);
						//图片尺寸不变，压缩图片文件大小outputQuality实现,参数1为最高质量
						Thumbnails.of(file_new).scale(1f).outputQuality(0.25f).toFile(file_new);
						Map<String, String> map = new HashMap<String, String>();
						map.put("fileNameOld", fileNameOld);//原始文明名称
						map.put("fileNameNew", newName);//新文件名称
						map.put("filepath", path+year+"/"+month+"/"+newName);//文件存储路径
						list.add(map);
					}
				}
			}
		}		
		return list;

	}
}
