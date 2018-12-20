package com.weina.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;



public class StuInfo {
    private Integer sid;

    private List<ClassInfo> classInfo;

    private String sname;

    private Integer age;

    private String sex;

    private String remark;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public List<ClassInfo> getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(List<ClassInfo> classInfo) {
		this.classInfo = classInfo;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public StuInfo(Integer sid, List<ClassInfo> classInfo, String sname, Integer age, String sex, String remark) {
		super();
		this.sid = sid;
		this.classInfo = classInfo;
		this.sname = sname;
		this.age = age;
		this.sex = sex;
		this.remark = remark;
	}

	public StuInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
}