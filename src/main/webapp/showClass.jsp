<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示班级信息</title>
</head>
<body>
	  <table id="table">
	  	<thead>
	  		<tr>
		  		<td>班级Id</td>
		  		<td>班级名称</td>
		  		<td>班级说明</td>
	  		</tr>
	  	</thead>
	  	<tbody>
	  	
	  	</tbody>
	  	<!-- 
	  	<c:forEach items="${pm.arr}" var="cla">
	  		<tr>
	  			<td>${cla.cid }</td>
	  			<td>${cla.cname }</td>
	  			<td>${cla.remark }</td>
	  		</tr>
	  	</c:forEach>
	  	 -->
	  </table>
	  <button id="btn1">首页</button>
	  <button id="btn2">上一页</button>
	  <button id="btn3">下一页</button>
	  <button id="btn4">尾页</button>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	  <script type="text/javascript">
	 
	  
	  	var pm = "";
			var target = "<tr><td></td><td></td><td></td></tr>"
	  		$.ajax({
	             type: "GET",
	             url: "${pageContext.request.contextPath}/classInfoController/queryAllClassByPage",
	             data: {current:"1",size:"5",keyWords:""},
	             dataType: "json",
	             success: function(dt){
	            	 pm=dt;
	            	 //循环添加节点
	            	 $.each(dt.arr, function(index, item){
	            		 $("#table tbody").append("<tr><td>"+item.cid+"</td><td>"+item.cname+"</td><td>"+item.remark+"</td><td> <a href='${pageContext.request.contextPath }/classInfoController/delClaOne?cid="+item.cid+"'>删除</a></td></tr>")
	            	 });
	             }
		  	 });
			
			
			$("#btn1").click(function(){
				$.ajax({
		             type: "GET",
		             url: "${pageContext.request.contextPath}/classInfoController/queryAllClassByPage",
		             data: {current:pm.firstPage,size:"5",keyWords:""},
		             dataType: "json",
		             success: function(dt){
		            	 pm=dt;
		            	 $("#table tbody tr").remove();
		            	 //循环添加节点
		            	 $.each(dt.arr, function(index, item){
		            		 $("#table tbody").append("<tr><td>"+item.cid+"</td><td>"+item.cname+"</td><td>"+item.remark+"</td><td> <a href='${pageContext.request.contextPath }/classInfoController/delClaOne?cid="+item.cid+"'>删除</a></td></tr>")
		            	 });
		             }
			  	 });
			});
			
			$("#btn2").click(function(){
				$.ajax({
		             type: "GET",
		             url: "${pageContext.request.contextPath}/classInfoController/queryAllClassByPage",
		             data: {current:pm.upPage,size:"5",keyWords:""},
		             dataType: "json",
		             success: function(dt){
		            	 pm=dt;
		            	 $("#table tbody tr").remove();
		            	 //循环添加节点
		            	 $.each(dt.arr, function(index, item){
		            		 $("#table tbody").append("<tr><td>"+item.cid+"</td><td>"+item.cname+"</td><td>"+item.remark+"</td><td> <a href='${pageContext.request.contextPath }/classInfoController/delClaOne?cid="+item.cid+"'>删除</a></td></tr>")
		            	 });
		             }
			  	 });
			});
			
			$("#btn3").click(function(){
				$.ajax({
		             type: "GET",
		             url: "${pageContext.request.contextPath}/classInfoController/queryAllClassByPage",
		             data: {current:pm.nextPage,size:"5",keyWords:""},
		             dataType: "json",
		             success: function(dt){
		            	 pm=dt;
		            	 $("#table tbody tr").remove();
		            	 //循环添加节点
		            	 $.each(dt.arr, function(index, item){
		            		 $("#table tbody").append("<tr><td>"+item.cid+"</td><td>"+item.cname+"</td><td>"+item.remark+"</td><td> <a href='${pageContext.request.contextPath }/classInfoController/delClaOne?cid="+item.cid+"'>删除</a></td></tr>")
		            	 });
		             }
			  	 });
			});
			
			$("#btn4").click(function(){
				$.ajax({
		             type: "GET",
		             url: "${pageContext.request.contextPath}/classInfoController/queryAllClassByPage",
		             data: {current:pm.lastPage,size:"5",keyWords:""},
		             dataType: "json",
		             success: function(dt){
		            	 pm=dt;
		            	 $("#table tbody tr").remove();
		            	 //循环添加节点
		            	 $.each(dt.arr, function(index, item){
		            		 $("#table tbody").append("<tr><td>"+item.cid+"</td><td>"+item.cname+"</td><td>"+item.remark+"</td><td> <a href='${pageContext.request.contextPath }/classInfoController/delClaOne?cid="+item.cid+"'>删除</a></td></tr>")
		            	 });
		             }
			  	 });
			});
	  </script>
	 
</body>
</html>