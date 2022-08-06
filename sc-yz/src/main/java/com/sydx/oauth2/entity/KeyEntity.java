package com.sydx.oauth2.entity;

public class KeyEntity {
    private String keyname;//秘钥标识
    private String privatekey;//私钥 加密
    private String publickey;//公钥 解密

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public String getPrivatekey() {
        return privatekey;
    }

    public void setPrivatekey(String privatekey) {
        this.privatekey = privatekey;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }
}
