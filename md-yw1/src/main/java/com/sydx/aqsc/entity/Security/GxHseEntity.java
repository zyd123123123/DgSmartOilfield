package com.sydx.aqsc.entity.Security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "工序HSE")
public class GxHseEntity {
    @ApiModelProperty(value="油田")
    private  String  oilfield;
    @ApiModelProperty(value="录入人")
    private  String  create_user;
    @ApiModelProperty(value="录入时间")
    private String create_time;
    @ApiModelProperty(value="IP")
    private  String  ip;
    @ApiModelProperty(value="修改人")
    private  String  last_user;
    @ApiModelProperty(value="修改时间")
    private  String  last_time;
    @ApiModelProperty(value="工序id")
    private  Integer spid; //工序id
    @ApiModelProperty(value="工序名称")
    private  String spname;//工序名称
    @ApiModelProperty(value="HSE id")
    private  Integer hseid;//HSE id
    @ApiModelProperty(value="标识")
    private  String flag;//标识
    @ApiModelProperty(value="/hse文件名")
    private String hsename;//hse文件名
    private  byte[] content;
    private  String text;

    public String getOilfield() {
        return oilfield;
    }

    public void setOilfield(String oilfield) {
        this.oilfield = oilfield;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLast_user() {
        return last_user;
    }

    public void setLast_user(String last_user) {
        this.last_user = last_user;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    public Integer getHseid() {
        return hseid;
    }

    public void setHseid(Integer hseid) {
        this.hseid = hseid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getHsename() {
        return hsename;
    }

    public void setHsename(String hsename) {
        this.hsename = hsename;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
