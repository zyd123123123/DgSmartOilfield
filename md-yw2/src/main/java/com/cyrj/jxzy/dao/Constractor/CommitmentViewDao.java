package com.cyrj.jxzy.dao.Constractor; 
import java.util.List;


 import com.cyrj.jxzy.entity.Constractor.CommitmentViewEntity;

public interface CommitmentViewDao { 

int   count(CommitmentViewEntity entity);

List<CommitmentViewEntity>   select(CommitmentViewEntity entity);

CommitmentViewEntity   selectById(CommitmentViewEntity entity);

void   deleteParam(CommitmentViewEntity entity);

void   insert(CommitmentViewEntity entity);

void   update(CommitmentViewEntity entity);

CommitmentViewEntity getPrint(String contract_id);

}
