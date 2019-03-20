<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
    function addTab(title, url){
    	if ($('#tt').tabs('exists', title)){
    		$('#tt').tabs('select', title);
    	} else {
    		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    		$('#tt').tabs('add',{
    			title:title,
    			content:content,
    			closable:true
    		});
    	}
    }
   </script>
  </head>
  
  <body>
     <div style="margin-bottom:10px">
    	<a href="#" class="easyui-linkbutton" onclick="addTab('google','http://www.google.com')">google</a>
    	<a href="#" class="easyui-linkbutton" onclick="addTab('jquery','http://jquery.com/')">jquery</a>
    	<a href="#" class="easyui-linkbutton" onclick="addTab('easyui','http://jeasyui.com/')">easyui</a>
    </div>
    <div id="tt" class="easyui-tabs" style="width:400px;height:250px;">
    	<div title="Home">
    	</div>
    </div>
  </body>
</html>
