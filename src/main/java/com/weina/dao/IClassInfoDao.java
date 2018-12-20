package com.weina.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.weina.entity.ClassInfo;

public interface IClassInfoDao {
	
	//分页查询
	public List<ClassInfo> queryAllClassByPage(int startPage,int pageSize,String key);
	//查询总条数
	public int queryCount(String key);
	
	//删除一条数据
	public void delClaInt(@Param("cid")int cid);
}
