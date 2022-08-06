package com.sydx.aqsc.entity.znjs;

/**
 * @author zyd
 * @create 2022-05-04-9:42
 */
public class WellVo {
    private int id;
    private String name;
    private String address;
    private String date;
    private String beizhu;

    public WellVo(int id, String name, String address, String date, String beizhu) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.beizhu = beizhu;
    }
    public WellVo(int id, String name, String beizhu, String date) {
        this.id = id;
        this.name = name;
        this.address = null;
        this.date = date;
        this.beizhu = beizhu;
    }

    public String getBeizhu() {
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
