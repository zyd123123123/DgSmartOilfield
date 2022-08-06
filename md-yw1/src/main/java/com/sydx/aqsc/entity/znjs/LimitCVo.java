package com.sydx.aqsc.entity.znjs;
public class LimitCVo {
    private String name;
    private Double max;
    private Double min;
    private String dw;
    private Boolean use;

    public LimitCVo() {
    }

    @Override
    public String toString() {
        return "LimitCVo{" +
                "name='" + name + '\'' +
                ", max=" + max +
                ", min=" + min +
                ", dw='" + dw + '\'' +
                ", use=" + use +
                '}';
    }

    public LimitCVo(String name, Double max, Double min, String dw, Boolean use) {
        this.name = name;
        this.max = max;
        this.min = min;
        this.dw = dw;
        this.use = use;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public Boolean getUse() {
        return use;
    }

    public void setUse(Boolean use) {
        this.use = use;
    }
}

