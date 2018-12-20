<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片/文件的单个上传 多个上传 及下载  以及显示</title>
</head>
<body>
	<center>
		<p>单文件上传</p>
		<form action="${pageContext.request.contextPath}/uploadAndDown/uploadOneFile" method="post" enctype="multipart/form-data">
			<input name = "file" type="file">
			<button type="submit">图片/文件单个上传</button>
		</form>
		<br>
		<p>多文件上传</p>
		<form action="${pageContext.request.contextPath}/uploadAndDown/uploadMoreFile" method="post" enctype="multipart/form-data">
			<input name = "file" type="file"><br><br>
			<input name = "file" type="file"><br><br>
			<input name = "file" type="file"><br><br>
			<input name = "file" type="file"><br><br>
			<input name = "file" type="file"><br><br>
			<input name = "file" type="file"><br><br>
			<button type="submit">图片/文件单个上传</button>
		</form>
		
		<br>
		<br>
		
		<a href="${pageContext.request.contextPath}/uploadAndDown/downLoadFile">文件下载</a>
		
		<br>
		<br>
		<p>直接以流的方式访问  就可以得到流 用a标签访问则是下载 用容器访问则是上传</p>
		<img src="${pageContext.request.contextPath}/uploadAndDown/downLoadFile">
	</center>
</body>
</html>