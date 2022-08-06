package com.sydx.aqsc.entity.znjs;

public class PumpsVo {
    private int key;
    private int code;
    private String name;
    private Float dp;
    private Float zs;
    private Float bt;
    private Float doout;
    private int docode;
    private Float dvgd;
    private Float dvyd;
    private int nk;
    private Float e;

    public PumpsVo(int key, int code, String name, Float dp, Float zs, Float bt, Float doout, int docode, Float dvgd, Float dvyd, int nk, Float e) {
        this.key = key;
        this.code = code;
        this.name = name;
        this.dp = dp;
        this.zs = zs;
        this.bt = bt;
        this.doout = doout;
        this.docode = docode;
        this.dvgd = dvgd;
        this.dvyd = dvyd;
        this.nk = nk;
        this.e = e;
    }

    @Override
    public String toString() {
        return "PumpsVo{" +
                "key=" + key +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", dp=" + dp +
                ", zs=" + zs +
                ", bt=" + bt +
                ", doout=" + doout +
                ", docode=" + docode +
                ", dvgd=" + dvgd +
                ", dvyd=" + dvyd +
                ", nk=" + nk +
                ", e=" + e +
                '}';
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDp() {
        return dp;
    }

    public void setDp(Float dp) {
        this.dp = dp;
    }

    public Float getZs() {
        return zs;
    }

    public void setZs(Float zs) {
        this.zs = zs;
    }

    public Float getBt() {
        return bt;
    }

    public void setBt(Float bt) {
        this.bt = bt;
    }

    public Float getDoout() {
        return doout;
    }

    public void setDoout(Float doout) {
        this.doout = doout;
    }

    public int getDocode() {
        return docode;
    }

    public void setDocode(int docode) {
        this.docode = docode;
    }

    public Float getDvgd() {
        return dvgd;
    }

    public void setDvgd(Float dvgd) {
        this.dvgd = dvgd;
    }

    public Float getDvyd() {
        return dvyd;
    }

    public void setDvyd(Float dvyd) {
        this.dvyd = dvyd;
    }

    public int getNk() {
        return nk;
    }

    public void setNk(int nk) {
        this.nk = nk;
    }

    public Float getE() {
        return e;
    }

    public void setE(Float e) {
        this.e = e;
    }
}
