package com.sydx.aqsc.entity.znjs;

/**
 * @author zyd
 * @create 2022-05-07-11:20
 */
public class OptResult {
    private Integer TIME;
    private Integer YEARS;
    private Float FOPT;
    private Float FWIT;
    private Float FWPT;
    private Float FWIR;
    private Float FOPR;
    private Float FWPR;
    private Float FWCT;
    private Float FPR;

    public OptResult(Integer TIME, Integer YEARS, Float FOPT, Float FWIT, Float FWPT, Float FWIR, Float FOPR, Float FWPR, Float FWCT, Float FPR) {
        this.TIME = TIME;
        this.YEARS = YEARS;
        this.FOPT = FOPT;
        this.FWIT = FWIT;
        this.FWPT = FWPT;
        this.FWIR = FWIR;
        this.FOPR = FOPR;
        this.FWPR = FWPR;
        this.FWCT = FWCT;
        this.FPR = FPR;
    }

    public Integer getTIME() {
        return TIME;
    }

    public void setTIME(Integer TIME) {
        this.TIME = TIME;
    }

    public Integer getYEARS() {
        return YEARS;
    }

    public void setYEARS(Integer YEARS) {
        this.YEARS = YEARS;
    }

    public Float getFOPT() {
        return FOPT;
    }

    public void setFOPT(Float FOPT) {
        this.FOPT = FOPT;
    }

    public Float getFWIT() {
        return FWIT;
    }

    public void setFWIT(Float FWIT) {
        this.FWIT = FWIT;
    }

    public Float getFWPT() {
        return FWPT;
    }

    public void setFWPT(Float FWPT) {
        this.FWPT = FWPT;
    }

    public Float getFWIR() {
        return FWIR;
    }

    public void setFWIR(Float FWIR) {
        this.FWIR = FWIR;
    }

    public Float getFOPR() {
        return FOPR;
    }

    public void setFOPR(Float FOPR) {
        this.FOPR = FOPR;
    }

    public Float getFWPR() {
        return FWPR;
    }

    public void setFWPR(Float FWPR) {
        this.FWPR = FWPR;
    }

    public Float getFWCT() {
        return FWCT;
    }

    public void setFWCT(Float FWCT) {
        this.FWCT = FWCT;
    }

    public Float getFPR() {
        return FPR;
    }

    public void setFPR(Float FPR) {
        this.FPR = FPR;
    }
}
