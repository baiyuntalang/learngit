<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'trees.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.min.js"></script>
     <script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-v1.6.1/locale/easyui-lang-zh_CN.js"></script>
  <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/default/easyui.css"></link>
   <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/icon.css"></link>
 
   <script type="text/javascript">

   </script>
  </head>
  
  <body>
  <h2>Tree Node Icons</h2>
	<p>This sample illustrates how to add icons to tree node.</p>
	<div style="margin:20px 0;"></div>
   <div class="easyui-panel" style="padding:5px">
		<ul class="easyui-tree" data-options="url:'getMenu.do',method:'get',animate:true"></ul>
	</div>
  </body>
</html>
