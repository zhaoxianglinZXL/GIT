package com.weina.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页模型
 * @author Administrator
 *
 */
public class PageModel<T> {
	//定义变量
	private int pageNum=1;//页码
	private int pageSize=5;//每页显示的数据条数
	private int count;//总数据条数
	private int sumPage;//总页码
	private List<T> arr;
	
	//定义变量计算翻页
	private int firstPage;//第一页
	private int upPage;//上一页
	private int nextPage;//下一页
	private int lastPage;//尾页
	
	//定义get和set方法
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		//将总的数据条数查询到并赋值
		this.count = count;
		
		//判断计算总页数(方法1)
		/*if(this.sumCount%this.size==0){
			//说明没有余数，直接取商
			this.sumPage=this.sumCount/this.size;
		}else{
			//说明有余数，则为取商加1
			this.sumPage=this.sumCount/this.size+1;
		}*/
		//判断计算总页数(方法2)
		this.sumPage=this.count%this.pageSize==0?this.count/this.pageSize:this.count/this.pageSize+1;
		System.out.println(count+"总条数\t大小"+pageSize+"+++++++++++++++++++");
		System.out.println(sumPage+"总页数+++++++++++++++++++++++");
		//计算翻页数据
		this.firstPage=1;
		this.upPage=this.pageNum-1<=1?1:this.pageNum-1;
		this.nextPage=this.pageNum+1>=this.sumPage?this.sumPage:this.pageNum+1;
		this.lastPage=this.sumPage;
	}
	public int upPage(){
		//定义上一页
		int up=pageNum-1;
		//判断
		if(up<=1){
			//上一页赋值为1
			up=1;
		}
		//返回上一页	
		return up;
	}
	public List<T> getArr() {
		return arr;
	}
	public void setArr(List<T> arr) {
		this.arr = arr;
	}
	public int getSumPage() {
		return sumPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public int getUpPage() {
		return upPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	
}



