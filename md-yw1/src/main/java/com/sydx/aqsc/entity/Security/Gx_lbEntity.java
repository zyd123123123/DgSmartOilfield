package com.sydx.aqsc.entity.Security;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "工序分类")
public class Gx_lbEntity {
    @ApiModelProperty(value="ID")
    private String id;
    @ApiModelProperty(value="措施类型")
    private String zylx;
    @ApiModelProperty(value="工序类别")
    private String gxlb;
    @ApiModelProperty(value="录入人")
    private String create_user;
    @ApiModelProperty(value="录入时间")
    private String create_time;
    @ApiModelProperty(value="录入IP")
    private String ip;
    @ApiModelProperty(value="油田")
    private String oilfield;
    private List<Gx_lbEntity> entityList;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZylx() {
        return zylx;
    }

    public void setZylx(String zylx) {
        this.zylx = zylx;
    }

    public String getGxlb() {
        return gxlb;
    }

    public void setGxlb(String gxlb) {
        this.gxlb = gxlb;
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

    public String getOilfield() {
        return oilfield;
    }

    public void setOilfield(String oilfield) {
        this.oilfield = oilfield;
    }

    public List<Gx_lbEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Gx_lbEntity> entityList) {
        this.entityList = entityList;
    }
}
