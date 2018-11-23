<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 文件上传表单开发要求：
		① 必须method="post"请求
		② 请求内容类型必须是enctype="multipart/form-data"
		③ 文件请求参数类型必须是type="file"
	 -->
			<form action="${pageContext.request.contextPath }/testUpload" method="post" 
				enctype="multipart/form-data" style="padding: 100px;margin: 200px;">
			文件: <input type="file" name="filename"/><br><br>
			名字: <input type="text" name="desc"/><br><br>
			<input type="submit" value="提交"/>
			</form>
	
</body>
</html>