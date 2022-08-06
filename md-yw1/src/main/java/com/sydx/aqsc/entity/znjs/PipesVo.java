package com.sydx.aqsc.entity.znjs;

public class PipesVo {
    private String type ;
    private Double GKL ;
    private Double KHK ;
    private String Depth ;
    private String Material ;
    private Double Doout ;
    private Double Doin ;
    private Double bh ;
    private Double KWJ ;
    private Double KNY ;

    @Override
    public String toString() {
        return "PipesVo{" +
                "type='" + type + '\'' +
                ", GKL=" + GKL +
                ", KHK=" + KHK +
                ", Depth='" + Depth + '\'' +
                ", Material='" + Material + '\'' +
                ", Doout=" + Doout +
                ", Doin=" + Doin +
                ", bh=" + bh +
                ", KWJ=" + KWJ +
                ", KNY=" + KNY +
                ", savem=" + savem +
                ", MaxP=" + MaxP +
                '}';
    }

    private Double savem ;
    private Double MaxP ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getGKL() {
        return GKL;
    }

    public void setGKL(Double GKL) {
        this.GKL = GKL;
    }

    public Double getKHK() {
        return KHK;
    }

    public void setKHK(Double KHK) {
        this.KHK = KHK;
    }

    public String getDepth() {
        return Depth;
    }

    public void setDepth(String depth) {
        Depth = depth;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String material) {
        Material = material;
    }

    public Double getDoout() {
        return Doout;
    }

    public void setDoout(Double doout) {
        Doout = doout;
    }

    public Double getDoin() {
        return Doin;
    }

    public void setDoin(Double doin) {
        Doin = doin;
    }

    public Double getBh() {
        return bh;
    }

    public void setBh(Double bh) {
        this.bh = bh;
    }

    public Double getKWJ() {
        return KWJ;
    }

    public void setKWJ(Double KWJ) {
        this.KWJ = KWJ;
    }

    public Double getKNY() {
        return KNY;
    }

    public void setKNY(Double KNY) {
        this.KNY = KNY;
    }

    public Double getSavem() {
        return savem;
    }

    public void setSavem(Double savem) {
        this.savem = savem;
    }

    public Double getMaxP() {
        return MaxP;
    }

    public void setMaxP(Double maxP) {
        MaxP = maxP;
    }

    public PipesVo(String type, Double GKL, Double KHK, String depth, String material, Double doout, Double doin, Double bh, Double KWJ, Double KNY, Double savem, Double maxP) {
        this.type = type;
        this.GKL = GKL;
        this.KHK = KHK;
        Depth = depth;
        Material = material;
        Doout = doout;
        Doin = doin;
        this.bh = bh;
        this.KWJ = KWJ;
        this.KNY = KNY;
        this.savem = savem;
        MaxP = maxP;
    }
}
