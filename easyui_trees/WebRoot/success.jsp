<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <h1>You are success!</h1>
   Welcome:<shiro:principal></shiro:principal>
   <shiro:hasRole name="admin">
   <br> <br>
   <a href="admin.jsp">Admin Page</a>
   </shiro:hasRole>
   <shiro:hasRole name="user">
   <br> <br>
   <a href="user.jsp">User Page</a>
   </shiro:hasRole>
    <br> <br>
   <a href="testshiro.do">Testshiro</a>
   <shiro:hasPermission name="menu:book"><a href="main.jsp"> main</a></shiro:hasPermission>
   <br> <br>
   <a href="logout">Logout</a>
  </body>
</html>
