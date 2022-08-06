package com.sydx.aqsc.entity.Admin;

import java.util.ArrayList;
import java.util.List;

public class CommonEntity<T> {
    private String qx;
    private String id;
    private String unitid;
    private String unitname;

    private String userid;
    private String uid;
    private String uname;

    private int pageNo;
    private int pageSize;
    private long totalRows;
    private int row_id;

    private String op;
    private String ov;
    private String ot;
    private String os;
    private String oldid;
    private List<T> rows=new ArrayList<T>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOv() {
        return ov;
    }

    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }

    public void setOv(String ov) {
        this.ov = ov;
    }

    public String getOt() {
        return ot;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getQx() {
        return qx;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }

    public List<T> getRows() {
        return rows;
    }

    public String getUnitid() {
        return unitid;
    }

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
