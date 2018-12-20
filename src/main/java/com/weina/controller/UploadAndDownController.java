package com.weina.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.Response;

/**
 * @author ZXL
 * @描述  上传和下载文件
 * @描述 jsp页面通过访问controller 获得流从而直接在页面回显
 */
@Controller
@RequestMapping("uploadAndDown")
public class UploadAndDownController {

	@RequestMapping("goToUploadAndDown")
	public ModelAndView goToUploadAndDown(){
		ModelAndView m = new ModelAndView("jsp/uploadAndDownLoad");
		return m;
	}
	
	/**
	 * @作者：ZXL
	 * @时间：2018年12月20日 下午2:11:08
	 * @parameter 
	 * @return String
	 * @描述：单文件上传方法
	 */
	@RequestMapping("uploadOneFile")
	public ModelAndView uploadFile(@RequestParam(defaultValue = "",value = "file") MultipartFile file,HttpServletRequest request){
		ModelAndView m = new ModelAndView();
		
		//获取文件名
		String imgName = file.getOriginalFilename();
		
		//获取当前项目的根路径
		String path = request.getSession().getServletContext().getRealPath("/resources")+ "/img/"+imgName;
		
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		System.out.println(path);
		
		//将路径转换为文件路径
		File f = new File(path);
		System.out.println("文件上传的位置"+f);
		//上传
		try {
			file.transferTo(f);
			m.setViewName("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("上传失败");
			e.printStackTrace();
			m.setViewName("error");
		} //E:\workspace\sts\.metadata\.plugins\org.eclipse.wst.server.core\tmp5\wtpwebapps\DemoSSM\resources\img\6659.jpg_wh300.jpg
		return m;
	}
	
	@RequestMapping("uploadMoreFile")
	public ModelAndView uploadMoreFile(@RequestParam(defaultValue = "",value = "file") MultipartFile[] file,HttpServletRequest request){
		ModelAndView m = new ModelAndView();
		
		//获取项目的根路径
		String path = request.getSession().getServletContext().getRealPath("/resources/img/");
		//循环遍历所有上传的file
		int i = 1;
		File f = null;
		//开始循环上传图片
		for(MultipartFile mfile :file){
			if(mfile.isEmpty()){
				System.out.println("第"+i+"个图片未上传成功");
			}else{
				path = path + mfile.getOriginalFilename();
				f = new File(path);
				try {
					mfile.transferTo(f);
					System.out.println("第"+i+"个图片上传成功");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("第"+i+"个图片未上传出现异常");
				} 
			}
			i++;
		}
		
		m.setViewName("success");
		return m;
	}
	
	@RequestMapping("downLoadFile")
	public void downLoadFile(HttpServletRequest request,HttpServletResponse response){
		ModelAndView m = new ModelAndView("success");
		//作用是指定对服务器响应进行重新编码的编码。 
		response.setCharacterEncoding("utf-8");
		//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
        response.setContentType("multipart/form-data"); 
        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)   
        response.setHeader("Content-Disposition", "attachment;fileName="+"a.jpg");   
       
        //获取图片所在文件夹路径  
        //注意图片是否存在该图片路径下
        String path = request.getSession().getServletContext().getRealPath("/resources/img/")+"video2.jpg";
		
        //通过文件路径获得File对象
        File f = new File(path);
        try {//通过输入流获取到file对象即获取到图片对象
			InputStream is = new FileInputStream(f);
			
			OutputStream os = response.getOutputStream();
			
			byte[] b = new byte[1024];
			int size = 0;
			while((size = is.read(b) )  > 0){
				os.write(b, 0, size);
			}
			
			os.close();
			is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        //return null;
	}
}
