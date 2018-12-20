package com.weina.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weina.dao.IClassInfoDao;
import com.weina.entity.ClassInfo;
import com.weina.service.IClassInfoService;
import com.weina.util.PageModel;

@Service("classInfoService")
public class ClassInfoService implements IClassInfoService {

	@Autowired
	private IClassInfoDao iclassDao;
	
	private static Logger log;
	static{
		log = Logger.getLogger(ClassInfoService.class);
	}
	
	@Override
	public PageModel<ClassInfo> queryAllByPage(int pageNum, int pageSize, String key) {
		// TODO Auto-generated method stub
		List<ClassInfo> list = iclassDao.queryAllClassByPage((pageNum-1)*pageSize, pageSize, key);
		//获取总条数
		int count = iclassDao.queryCount(key);
		PageModel<ClassInfo> pm = new PageModel<ClassInfo>();
		//设置pageModel
		if(list!=null&&count>0&&list.size()>0){
			pm.setPageNum(pageNum);
			pm.setCount(count);
			pm.setPageSize(pageSize);
			pm.setArr(list);
			return pm;
		}else{
			return null;
		}
	}

	@Override
	public int delClaCid(int cid) {
		// TODO Auto-generated method stub
		try {
			iclassDao.delClaInt(cid);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

}
