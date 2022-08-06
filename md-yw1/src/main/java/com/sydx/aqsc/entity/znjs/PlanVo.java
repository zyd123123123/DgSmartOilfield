package com.sydx.aqsc.entity.znjs;

/**
 * @Description:
 * @Param: 'machine', 'Pmax', 'M', 'pump', 'DoCode', '泵径', '冲程', '冲次', '设计排量',
 *        '动液面深度', '泵深', '油管内径', 'XDPmax', 'XDPmin', 'EfficiencyLamada',
 *        'EfficiencyFull', 'EfficiencyBl', 'EfficiencyLeak', 'PumpEfficiency',
 *        'HPh', 'HPPR', 'LiftEfficiency', 'Mmax', 'Nr', 'GroundEfficiency',
 *        'SystemEfficiency', '计算排量','油管规格'
 */
public class PlanVo {
    Integer number;
    Float s;
    Float n;
    Float dp;
    Float doout;
    Float lf;
    Float lp;
    Float hcmd;
    Float qset;
    Float qcount;
    Float pe;
    Float lift;
    Float yxch;
    Float cmcd;
    Float systemef;
    Float groundef;
    Float dyhd;
    Float bmdyhd;
    Float pmax;
    Float pmin;
    Float mmax;

    public PlanVo(Integer number, Float s, Float n, Float dp, Float doout, Float lf, Float lp, Float hcmd, Float qset, Float qcount, Float pe, Float lift, Float yxch, Float cmcd, Float systemef, Float groundef, Float dyhd, Float bmdyhd, Float pmax, Float pmin, Float mmax) {
        this.number = number;
        this.s = s;
        this.n = n;
        this.dp = dp;
        this.doout = doout;
        this.lf = lf;
        this.lp = lp;
        this.hcmd = hcmd;
        this.qset = qset;
        this.qcount = qcount;
        this.pe = pe;
        this.lift = lift;
        this.yxch = yxch;
        this.cmcd = cmcd;
        this.systemef = systemef;
        this.groundef = groundef;
        this.dyhd = dyhd;
        this.bmdyhd = bmdyhd;
        this.pmax = pmax;
        this.pmin = pmin;
        this.mmax = mmax;
    }

    public Float getGroundef() {
        return groundef;
    }

    public void setGroundef(Float groundef) {
        this.groundef = groundef;
    }

    public Float getDyhd() {
        return dyhd;
    }

    public void setDyhd(Float dyhd) {
        this.dyhd = dyhd;
    }

    public Float getBmdyhd() {
        return bmdyhd;
    }

    public void setBmdyhd(Float bmdyhd) {
        this.bmdyhd = bmdyhd;
    }

    public Float getPmax() {
        return pmax;
    }

    public void setPmax(Float pmax) {
        this.pmax = pmax;
    }

    public Float getPmin() {
        return pmin;
    }

    public void setPmin(Float pmin) {
        this.pmin = pmin;
    }

    public Float getMmax() {
        return mmax;
    }

    public void setMmax(Float mmax) {
        this.mmax = mmax;
    }

    public PlanVo() {
    }

    public Float getSystemef() {
        return systemef;
    }

    public void setSystemef(Float systemef) {
        this.systemef = systemef;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getS() {
        return s;
    }

    public void setS(Float s) {
        this.s = s;
    }

    public Float getN() {
        return n;
    }

    public void setN(Float n) {
        this.n = n;
    }

    public Float getDp() {
        return dp;
    }

    public void setDp(Float dp) {
        this.dp = dp;
    }

    public Float getDoout() {
        return doout;
    }

    public void setDoout(Float doout) {
        this.doout = doout;
    }

    public Float getLf() {
        return lf;
    }

    public void setLf(Float lf) {
        this.lf = lf;
    }

    public Float getLp() {
        return lp;
    }

    public void setLp(Float lp) {
        this.lp = lp;
    }

    public Float getHcmd() {
        return hcmd;
    }

    public void setHcmd(Float hcmd) {
        this.hcmd = hcmd;
    }

    public Float getQset() {
        return qset;
    }

    public void setQset(Float qset) {
        this.qset = qset;
    }

    public Float getQcount() {
        return qcount;
    }

    public void setQcount(Float qcount) {
        this.qcount = qcount;
    }

    public Float getPe() {
        return pe;
    }

    public void setPe(Float pe) {
        this.pe = pe;
    }

    public Float getLift() {
        return lift;
    }

    public void setLift(Float lift) {
        this.lift = lift;
    }

    public Float getYxch() {
        return yxch;
    }

    public void setYxch(Float yxch) {
        this.yxch = yxch;
    }

    public Float getCmcd() {
        return cmcd;
    }

    public void setCmcd(Float cmcd) {
        this.cmcd = cmcd;
    }
}
