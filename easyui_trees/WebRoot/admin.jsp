<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
 <script language="javascript">
    function reloadCode() {           
 
 document.getElementById("imgSignCode").src="getSecurityCode.do?r=" + new Date().getTime();     //这里为什么会加一个时间戳参数呢？  浏览器带有缓存功能
//当一个src中的URL请求一次后，再次请求浏览器就不会再去请求获得新数据，而是直接用
//上次请求返回的数据
    }
    function changeCode(){

         var src = "getVerifyCode.do?"+new Date().getTime(); //加时间戳，防止浏览器利用缓存

    $('.verifyCode').attr("src",src);                  //jQuery写法

}
  </script>
  </head>
  
  <body>
<h1>admin page</h1>
     <img id="imgSignCode" src="getSecurityCode.do" onclick="reloadCode()" title="重新获取" style="cursor:pointer;"/>  
 <input class="verifyInput"  name="verifyInput" placeholder="请输入验证码">   

 

/*验证码图片*/

<img class="verifyCode" onclick="changeCode()" src="getVerifyCode.do">
  </body>
</html>
