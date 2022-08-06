package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;

public class Djsgjd_GxEntity extends BaseEntity {

    private String construction_id;//施工总结id
    private String spname;//工序名称
    private int spid;//工序id
    private int pdid;//工序id
    private int sort;//排序
    private String state;//状态：1未开始、2施工中、3暂停、4暂停后开始、5未完成(终止）、6完成、7删除
    private String sign;//标记1定制工序2附加工序
    private String czgc;//操作规程
    private int czgcid;//操作规程
    private String fxts;//风险提示
    private int fxtsid;//风险提示
    private String ysyy;//延时原因
    private String ztyy;//延时原因
    private String csyy;//超时原因
    private String starttime;//开始时间
    private String endtime;//完成时间
    private double jh_time;//计划用时（h）
    private double lj_time;//累计用时（h）
    private double zt_time;//暂停时间（h）
    private double sj_time;//实际用时（h）
    private double z_time;//增（h）
    private double j_time;//减（h）
    private  double zj_time;//增减比例




    public String getConstruction_id() {
        return construction_id;
    }

    public void setConstruction_id(String construction_id) {
        this.construction_id = construction_id;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public String getCzgc() {
        return czgc;
    }

    public void setCzgc(String czgc) {
        this.czgc = czgc;
    }

    public String getFxts() {
        return fxts;
    }

    public void setFxts(String fxts) {
        this.fxts = fxts;
    }

    public String getYsyy() {
        return ysyy;
    }

    public void setYsyy(String ysyy) {
        this.ysyy = ysyy;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public double getJh_time() {
        return jh_time;
    }

    public void setJh_time(double jh_time) {
        this.jh_time = jh_time;
    }

    public double getLj_time() {
        return lj_time;
    }

    public void setLj_time(double lj_time) {
        this.lj_time = lj_time;
    }

    public double getZt_time() {
        return zt_time;
    }

    public void setZt_time(double zt_time) {
        this.zt_time = zt_time;
    }

    public double getSj_time() {
        return sj_time;
    }

    public void setSj_time(double sj_time) {
        this.sj_time = sj_time;
    }

    public double getZ_time() {
        return z_time;
    }

    public void setZ_time(double z_time) {
        this.z_time = z_time;
    }

    public double getJ_time() {
        return j_time;
    }

    public void setJ_time(double j_time) {
        this.j_time = j_time;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
    }

    public int getCzgcid() {
        return czgcid;
    }

    public void setCzgcid(int czgcid) {
        this.czgcid = czgcid;
    }

    public int getFxtsid() {
        return fxtsid;
    }

    public void setFxtsid(int fxtsid) {
        this.fxtsid = fxtsid;
    }

    public int getPdid() {
        return pdid;
    }

    public void setPdid(int pdid) {
        this.pdid = pdid;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getZtyy() {
        return ztyy;
    }

    public void setZtyy(String ztyy) {
        this.ztyy = ztyy;
    }

    public String getCsyy() {
        return csyy;
    }

    public void setCsyy(String csyy) {
        this.csyy = csyy;
    }

    public double getZj_time() {
        return zj_time;
    }

    public void setZj_time(double zj_time) {
        this.zj_time = zj_time;
    }
}
