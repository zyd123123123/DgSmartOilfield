package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;

public interface UploadFilesDao {


	/**
	 * 查询照片数量
	 * @param entity
	 * @return
	 */
	int countImage(UploadFilesEntity entity);
	/**
	 * 查询照片
	 * @param entity
	 * @return
	 */
	List<UploadFilesEntity> listImageView(UploadFilesEntity entity);
	/**
	 * 删除照片
	 * @param entity
	 */
	void deleteImage(UploadFilesEntity entity);
	/**
	 * 批量保存照片
	 * @param entity
	 */
	void insertImage(UploadFilesEntity entity);
}
