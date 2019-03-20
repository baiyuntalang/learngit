<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="common.jsp" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>"> 
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#menu a {padding: 10px}
	</style>
	<script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.min.js"></script>
     <script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-v1.6.1/locale/easyui-lang-zh_CN.js"></script>
  <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/default/easyui.css"></link>
   <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/icon.css"></link>
   <script type="text/javascript" src=" ${ctx}/js/login/menu.js"></script>
   <script type="text/javascript">
   
  
   </script>
  </head>
  
  <body>

	<div id="menu" class="easyui-layout"  fit="true">
		<div data-options="region:'north'" style="height:50px;width:100%;float: hidden;" >
		   <div style="float: left;"></div>
		   <div style="float: right;padding:10px 20px 0 0px;">
		    <strong>欢迎&nbsp<shiro:principal></shiro:principal></strong>
			<a href="javacript:void(0);" onclick="" style="text-decoration: none;">修改密码</a>
			<a href="logout" style="text-decoration: none;">退出登录</a>
		   </span>
		   </div>
		</div>
		<div data-options="region:'south',split:true" style="height:50px;"></div>
		<div data-options="region:'east',split:true" title="East" style="width:150px;"></div>
		<div data-options="region:'west',split:true" title="West" style="width:200px;">
		    <div class="easyui-panel" style="padding:10px;width:180px" title="菜单" collapsible=true>
			<ul id="tt" ></ul>
			</div>
		</div>
		<div data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
		<div id="t" class="easyui-tabs" fit=true >
		 <div title="home">
			<table class="easyui-datagrid"
					data-options="url:'datagrid_data1.json',method:'get',border:false,singleSelect:true,fit:true,fitColumns:true">
				<thead>
					<tr>
						<th data-options="field:'itemid'" width="80">Item ID</th>
						<th data-options="field:'productid'" width="100">Product ID</th>
						<th data-options="field:'listprice',align:'right'" width="80">List Price</th>
						<th data-options="field:'unitcost',align:'right'" width="80">Unit Cost</th>
						<th data-options="field:'attr1'" width="150">Attribute</th>
						<th data-options="field:'status',align:'center'" width="60">Status</th>
					</tr>
				</thead>
			</table>
			</div>
		</div>
		</div>
	</div>
  </body>
</html>
