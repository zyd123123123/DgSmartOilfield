package com.cyrj.jxzy.dao.Constractor;

import java.util.List;

import com.cyrj.jxzy.entity.Constractor.ContractTeamEntity;
import com.cyrj.jxzy.entity.Constractor.HtxxlrEntity;
import com.cyrj.jxzy.entity.Constractor.QualificationEntity;
import com.cyrj.jxzy.entity.Constractor.QylrEntity;
import com.cyrj.jxzy.entity.Constractor.UploadFilesEntity;

public interface HtxxlrDao {

	int count(HtxxlrEntity entity);
	List<QylrEntity> cbs_select(QylrEntity entity);
	
	List<QualificationEntity> qualification_select(HtxxlrEntity entity);
	
	List<ContractTeamEntity> contractTeamSelect(HtxxlrEntity entity);
	
	void contractTeamInsert(ContractTeamEntity ct);
	
	void htxxlrInsert(HtxxlrEntity entity);
	
	void insertUploadFiles(UploadFilesEntity up);
	
	void deletecontractTeam(String contract_id);
	
	void htxxlrUpdate(HtxxlrEntity entity);
	
	void removeContract(HtxxlrEntity entity);
	
	int removeSelect(HtxxlrEntity entity);
	
	void htshth(HtxxlrEntity entity);
	
	void htwgth(HtxxlrEntity entity);
}
