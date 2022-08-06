package com.sydx.aqsc.entity.Admin;

import java.util.List;

public class UserHeaderEntity {
    private String user_name;
    private String real_name;
    private Integer userId;
    private List scope;
    private String id;
    private String exp;
    private List authorities;
    private String jti;
    private String client_id;
    private String oilfield;
    private String attribute;
    private String search;
    private String unitid;
    private String unitname;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public List getScope() {
        return scope;
    }

    public void setScope(List scope) {
        this.scope = scope;
    }

    public List getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List authorities) {
        this.authorities = authorities;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getOilfield() {
        return oilfield;
    }

    public void setOilfield(String oilfield) {
        this.oilfield = oilfield;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }
}
