<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta chatset="utf-8">
    <title>上传文件测试</title>
  </head>
  <body>
  <!-- upload/uploadImg.action错误：会在请求路径上把最后一个/之后的全部去掉 -->
  	<form action="uploadImg.action" method="post" enctype="multipart/form-data">
  		<c:if test="${image != null }">
  			<!-- server.xml中的配置<Context docBase="E:\test\upload" path="/pic" reloadable="false"/> -->
  			<img src="/pic/${image }" width=100 height=100/><br/>
  		</c:if>
  		<input type="file" name="file" /><br/>
  		<input type="submit" value="上传"/>
  	</form>
  </body>
</html>
