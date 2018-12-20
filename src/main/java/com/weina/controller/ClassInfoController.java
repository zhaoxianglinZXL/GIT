package com.weina.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.weina.dao.IClassInfoDao;
import com.weina.entity.ClassInfo;
import com.weina.service.IClassInfoService;
import com.weina.util.PageModel;

@Controller
@Scope("singleton")
@RequestMapping("/classInfoController")
public class ClassInfoController {
	@Autowired
	@Qualifier("classInfoService")
	private IClassInfoService iclassInfoService;
	//分页查询的方法
	/*@RequestMapping(value="queryAllClassByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageModel<ClassInfo> queryAllClassByPage(@RequestParam(value="current",defaultValue="1")int pageNum,@RequestParam(value="size",defaultValue="1")int pageSize,@RequestParam(defaultValue="",value="key")String key){
		System.out.println("进入controller类");
		System.out.println("当前也"+pageNum+"\t大小"+pageSize);
		PageModel<ClassInfo> pm = iclassInfoService.queryAllByPage(pageNum, 5, key);
		return pm;
	}*/
	@RequestMapping(value="queryAllClassByPage",method=RequestMethod.GET)
	@ResponseBody
	public PageModel<ClassInfo> queryAllClassByPage(@RequestParam(value="current",defaultValue="1")int pageNum,@RequestParam(value="size",defaultValue="1")int pageSize,@RequestParam(defaultValue="",value="key")String key){
		System.out.println("进入controller类");
		System.out.println("当前也"+pageNum+"\t大小"+pageSize);
		PageModel<ClassInfo> pm = iclassInfoService.queryAllByPage(pageNum, 5, key);
		return pm;
	}
	
	@RequestMapping(value="delClaOne",method=RequestMethod.GET)
	public ModelAndView delClaOne(int cid){
		System.out.println("进入方法"+cid);
		ModelAndView m = new ModelAndView("error");
		int i = iclassInfoService.delClaCid(cid);
		if(i>1){
			return m;
		}else{
			m.setViewName("showClass");
			return m;
		}
	}
}
