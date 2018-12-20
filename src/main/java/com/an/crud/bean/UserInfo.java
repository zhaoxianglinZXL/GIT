package com.an.crud.bean;

public class UserInfo {
    private Integer uid;

    private String uname;

    private Integer uage;

    private String uremark;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public String getUremark() {
        return uremark;
    }

    public void setUremark(String uremark) {
        this.uremark = uremark == null ? null : uremark.trim();
    }
}