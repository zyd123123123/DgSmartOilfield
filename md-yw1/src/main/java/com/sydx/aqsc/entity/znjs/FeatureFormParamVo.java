package com.sydx.aqsc.entity.znjs;

import java.util.List;

public class FeatureFormParamVo {
    private Double yichang;
    private Double oilmidu;
    private Double rodmidu;
    private Boolean zaiheConfirm;
    private String drop;

    @Override
    public String toString() {
        return "FeatureFormParamVo{" +
                "yichang=" + yichang +
                ", oilmidu=" + oilmidu +
                ", rodmidu=" + rodmidu +
                ", zaiheConfirm=" + zaiheConfirm +
                ", drop=" + drop +
                '}';
    }

    public Double getYichang() {
        return yichang;
    }

    public void setYichang(Double yichang) {
        this.yichang = yichang;
    }

    public Double getOilmidu() {
        return oilmidu;
    }

    public void setOilmidu(Double oilmidu) {
        this.oilmidu = oilmidu;
    }

    public Double getRodmidu() {
        return rodmidu;
    }

    public void setRodmidu(Double rodmidu) {
        this.rodmidu = rodmidu;
    }

    public Boolean getZaiheConfirm() {
        return zaiheConfirm;
    }

    public void setZaiheConfirm(Boolean zaiheConfirm) {
        this.zaiheConfirm = zaiheConfirm;
    }

    public String getDrop() {
        return drop;
    }

    public void setDrop(String drop) {
        this.drop = drop;
    }

    public FeatureFormParamVo() {
    }

    public FeatureFormParamVo(Double yichang, Double oilmidu, Double rodmidu, Boolean zaiheConfirm, String drop) {
        this.yichang = yichang;
        this.oilmidu = oilmidu;
        this.rodmidu = rodmidu;
        this.zaiheConfirm = zaiheConfirm;
        this.drop = drop;
    }
}