package com.sydx.aqsc.entity.Security;

import com.sydx.aqsc.entity.Admin.BaseEntity;

public class Sgjd_configEntity extends BaseEntity {

    private String oilfield;
    private String unitid;
    private String unitname;

    private int request_duration;//定时刷新时长
    private String sp_font_family;//工序名称字体
    private int sp_font_size;//工序名称字体大小
    private String team_font_family;//作业队名称字体
    private int team_font_size;//作业队字体大小
    private String op_font_family;//施工项目字体
    private int op_font_size;//施工项目字体大小
    private String well_font_family;//井号字体
    private int well_font_size;//井号字体大小


    private String w_sp_font;//未开始工序字体颜色
    private String zt_sp_background;//暂停工序背景色
    private String zt_sp_font;//暂停工序字体颜色
    private String zz_sp_background;//终止工序背景色
    private String zz_sp_font;//终止工序字体颜色
    private String wc_sp_background;//完成工序背景色
    private String wc_sp_font;//完成工序字体颜色
    private String cs_sp_background;//超时工序背景色
    private String js_sp_background;//节时工序背景色
    private String bk_sp_background;//工序边框颜色
    private String fj_sp_background;//附加工序标识颜色


    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public int getRequest_duration() {
        return request_duration;
    }

    public void setRequest_duration(int request_duration) {
        this.request_duration = request_duration;
    }

    public String getSp_font_family() {
        return sp_font_family;
    }

    public void setSp_font_family(String sp_font_family) {
        this.sp_font_family = sp_font_family;
    }

    public int getSp_font_size() {
        return sp_font_size;
    }

    public void setSp_font_size(int sp_font_size) {
        this.sp_font_size = sp_font_size;
    }

    public String getTeam_font_family() {
        return team_font_family;
    }

    public void setTeam_font_family(String team_font_family) {
        this.team_font_family = team_font_family;
    }

    public int getTeam_font_size() {
        return team_font_size;
    }

    public void setTeam_font_size(int team_font_size) {
        this.team_font_size = team_font_size;
    }

    public String getOp_font_family() {
        return op_font_family;
    }

    public void setOp_font_family(String op_font_family) {
        this.op_font_family = op_font_family;
    }

    public int getOp_font_size() {
        return op_font_size;
    }

    public void setOp_font_size(int op_font_size) {
        this.op_font_size = op_font_size;
    }

    public String getWell_font_family() {
        return well_font_family;
    }

    public void setWell_font_family(String well_font_family) {
        this.well_font_family = well_font_family;
    }

    public int getWell_font_size() {
        return well_font_size;
    }

    public void setWell_font_size(int well_font_size) {
        this.well_font_size = well_font_size;
    }

    public String getW_sp_font() {
        return w_sp_font;
    }

    public void setW_sp_font(String w_sp_font) {
        this.w_sp_font = w_sp_font;
    }

    public String getZt_sp_background() {
        return zt_sp_background;
    }

    public void setZt_sp_background(String zt_sp_background) {
        this.zt_sp_background = zt_sp_background;
    }

    public String getZt_sp_font() {
        return zt_sp_font;
    }

    public void setZt_sp_font(String zt_sp_font) {
        this.zt_sp_font = zt_sp_font;
    }

    public String getZz_sp_background() {
        return zz_sp_background;
    }

    public void setZz_sp_background(String zz_sp_background) {
        this.zz_sp_background = zz_sp_background;
    }

    public String getZz_sp_font() {
        return zz_sp_font;
    }

    public void setZz_sp_font(String zz_sp_font) {
        this.zz_sp_font = zz_sp_font;
    }

    public String getWc_sp_background() {
        return wc_sp_background;
    }

    public void setWc_sp_background(String wc_sp_background) {
        this.wc_sp_background = wc_sp_background;
    }

    public String getWc_sp_font() {
        return wc_sp_font;
    }

    public void setWc_sp_font(String wc_sp_font) {
        this.wc_sp_font = wc_sp_font;
    }

    public String getCs_sp_background() {
        return cs_sp_background;
    }

    public void setCs_sp_background(String cs_sp_background) {
        this.cs_sp_background = cs_sp_background;
    }

    public String getJs_sp_background() {
        return js_sp_background;
    }

    public void setJs_sp_background(String js_sp_background) {
        this.js_sp_background = js_sp_background;
    }

    public String getBk_sp_background() {
        return bk_sp_background;
    }

    public void setBk_sp_background(String bk_sp_background) {
        this.bk_sp_background = bk_sp_background;
    }

    public String getFj_sp_background() {
        return fj_sp_background;
    }

    public void setFj_sp_background(String fj_sp_background) {
        this.fj_sp_background = fj_sp_background;
    }
}
