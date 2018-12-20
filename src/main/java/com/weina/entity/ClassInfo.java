package com.weina.entity;

public class ClassInfo {
    private Integer cid;

    private String cname;

    private String remark;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getRemark() {
        return remark;
    }


	public ClassInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassInfo(Integer cid, String cname, String remark) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.remark = remark;
	}


}

