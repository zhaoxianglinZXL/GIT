package com.weina.service;

import com.weina.entity.ClassInfo;
import com.weina.util.PageModel;

public interface IClassInfoService {
	public PageModel<ClassInfo> queryAllByPage(int pageNum,int pageSize,String key);
	
	public int delClaCid(int cid);
}
