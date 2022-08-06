package com.sydx.aqsc.entity.znjs;

public class RODVo {
    private String type;
    private Double diameter ;
    private Double length ;
    private String deepth;
    private Double pl;
    private Double use;
    private Double sigmaallow;
    private Double sigmamax;
    private Double sigmamin;
    private Double pmax;
    private Double pmin;
    private Double mmax;

    public Double getMmax() {
        return mmax;
    }

    public void setMmax(Double mmax) {
        this.mmax = mmax;
    }

    @Override
    public String toString() {
        return "RODVo{" +
                "type='" + type + '\'' +
                ", diameter=" + diameter +
                ", length=" + length +
                ", deepth='" + deepth + '\'' +
                ", pl=" + pl +
                ", use=" + use +
                ", sigmaallow=" + sigmaallow +
                ", sigmamax=" + sigmamax +
                ", sigmamin=" + sigmamin +
                ", pmax=" + pmax +
                ", pmin=" + pmin +
                ", mmax=" + mmax +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getDeepth() {
        return deepth;
    }

    public void setDeepth(String deepth) {
        this.deepth = deepth;
    }

    public Double getPl() {
        return pl;
    }

    public void setPl(Double pl) {
        this.pl = pl;
    }

    public Double getUse() {
        return use;
    }

    public void setUse(Double use) {
        this.use = use;
    }

    public Double getSigmaallow() {
        return sigmaallow;
    }

    public void setSigmaallow(Double sigmaallow) {
        this.sigmaallow = sigmaallow;
    }

    public Double getSigmamax() {
        return sigmamax;
    }

    public void setSigmamax(Double sigmamax) {
        this.sigmamax = sigmamax;
    }

    public Double getSigmamin() {
        return sigmamin;
    }

    public void setSigmamin(Double sigmamin) {
        this.sigmamin = sigmamin;
    }

    public Double getPmax() {
        return pmax;
    }

    public void setPmax(Double pmax) {
        this.pmax = pmax;
    }

    public Double getPmin() {
        return pmin;
    }

    public void setPmin(Double pmin) {
        this.pmin = pmin;
    }

    public RODVo(String type, Double diameter, Double length, String deepth, Double pl, Double use, Double sigmaallow, Double sigmamax, Double sigmamin, Double pmax, Double pmin,Double mmax) {
        this.type = type;
        this.diameter = diameter;
        this.length = length;
        this.deepth = deepth;
        this.pl = pl;
        this.use = use;
        this.sigmaallow = sigmaallow;
        this.sigmamax = sigmamax;
        this.sigmamin = sigmamin;
        this.pmax = pmax;
        this.pmin = pmin;
        this.mmax = mmax;
    }
}
