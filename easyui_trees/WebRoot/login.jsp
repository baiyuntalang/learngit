<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@include file="common.jsp" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <style type="text/css">
    a{
  text-decoration:none;
}
body{
  margin:0px;
}
#header{
  width:100%;
  height:30px;
  background-color:#E0EFFF;
  padding-top: 5px;
  padding-bottom: 10px;
}
#header .logo{
  margin-left: 50px;
  font-size: 24px;
  font-family: 微软雅黑;
}
#picture{
  width:100%;
  height:450px;
}
.panel-title {
 text-align: center;
 font-size: 16px;
}
#bootom{
  padding-top:50px;
  width:100%;
  height:100px;
  background: #eaf2ff;
}
#bootom_content{
  margin-left:100px;
  width:80%;
  text-align: center;
  font-size:0.8em; 
}
p{
  line-height:20px; 
}

    </style>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script> -->
<script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.min.js"></script> 
     <script type="text/javascript" src="js/jquery-easyui-v1.6.1/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="js/jquery-easyui-v1.6.1/locale/easyui-lang-zh_CN.js"></script>
  <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/default/easyui.css"></link>
   <link  rel="stylesheet" href="js/jquery-easyui-v1.6.1/themes/icon.css"></link>
  <%--  --%>
      <script type="text/javascript" src=" ${ctx}/js/login/login.js"></script>
  <script type="text/javascript">
  $('#p').panel('move',{
    left:100,
    top:100
  });  
   $('#btn').bind('click', function(){
        alert('easyui');
    });
    /* $.extend($.fn.textbox.defaults.rules, {
    number : {
        validator : function(value, param) {
            return /^[0-9]*$/.test(value);
        },
        message : "请输入数字"
    },
    chinese : {
        validator : function(value, param) {
            var reg = /^[\u4e00-\u9fa5]+$/i;
            return reg.test(value);
        },
        message : "请输入中文"
    },
    checkLength: {
        validator: function(value, param){
            return param[0] >= get_length(value);
        },
        message: '请输入最大{0}位字符'
    },
    specialCharacter: {
        validator: function(value, param){
            var reg = new RegExp("[`~!@#$^&*()=|{}':;'\\[\\]<>~！@#￥……&*（）——|{}【】‘；：”“'、？]");
            return !reg.test(value);
        },
        message: '不允许输入特殊字符'
    }   
});  */
</script>
  </head>
  
  <body>
<!-- <div id="login" title="用户登录" style="width:300px;height:200px;">
	<form id="ff" method="post" action="login.do">
	<table>
		<tr>
			
			<th><label for="name">Name:</label></th>
			<td>
			<input class="easyui-validatebox" type="text" name="username" required="true"></input>
		</td>
		</tr>
        <tr>
		
		<th><label for="password">password:</label></th>
	     <td>
	     <input class="easyui-validatebox" prompt="Password"  name="password" iconWidth="28">
         </td>
         </tr>
         <tr>
			<td>
			<input type="submit" value="Submit">
			</td>
	    </tr>
	    </table>
	    </form>
	    </div> -->
	     <div id="header" >
   
  </div>
  <div id="picture" style="background-size: cover;">
  <div data-options=" region:'center',split:true,style:{position:'absolute',left:500,top:150}"
 class="easyui-panel " title="用户登录" style="width:300px;text-align: center;">
 <!-- <div id="ts" style="height: 5px;display: none;"> <p style="color: red; font-size: 10px;">您的账号或密码输入有误，请重新输入!</p> </div>  -->
      <div style="padding:10px 60px 20px 60px">
        <form id="ff" class="easyui-form" method="post" data-options="novalidate:true">
          <table cellpadding="5" style="line-height:10px;">
            <tr>
              <td><input id="user" class="easyui-textbox" name="username"  data-options="prompt:'账号'"  onfocus ="alert('a')" iconCls="icon-man" iconAlign=left style="width:100%;height:32px" required="true"/></td>
            </tr>
            <tr>
              <td><input class="easyui-passwordbox" name="password" prompt="密码"  iconAlign=left style="width:100%;height:32px" required="true"></input></td>
            </tr>
            <tr> 
              <td><input class="easyui-textbox" data-options="prompt:'验证码',validType:'validate'" iconCls="icon-filter" iconAlign=left style="width:55%;height:32px" name="code"/>    
              <img id="imgSignCode" src="getSecurityCode.do" alt="" width="56" height="32" align='absMiddle'  onclick="reloadCode()"/> </td>
         </tr>
         <tr>
                <td style="">
                    <%--这里为了方便我默认将value设置为true,shiro对value 的判断除了true这个状态位还有：t，1，enabled，y，yes，on这几种--%>
                    <input type="checkbox" value="true" name="rememberMe" style="float: left;"><span style="font-size: 10px;display:block;float: left;-moz-transform:translate(0px,5px);">记住我</span>
                </td>
            </tr>
          </table>
          <!--提示  -->
          <div id="ts" style="height: 5px;display: none;"> <p style="color: red; font-size: 10px;"></p> </div>
        </form>
        <div style="text-align:center;padding:5px; ">
          <a  class="easyui-linkbutton" style="width:45%;height:32px" onclick="submitForm();">登录</a>    
          <a href="#"  class="easyui-linkbutton" style="width:45%;height:32px">注册</a>
        </div>
      </div>
    </div>
  </div>
  <div id="bootom">
    <div id="bootom_content">
      <p><strong>关于我们      法律声明      服务条款     联系我们</strong></p>
      <p> 
        地址：湖北省武汉市洪山区雄楚大道    邮箱：430012 
           Copyright © 2018 - 2019   1486494826@qq.com 版权所有
      </p>
      <p>
        建议使用IE8以上版本浏览器    E-mail：1486494826@qq.com
      </p>
    </div>
  </div>
</body>
<script>
  function submitForm(){
   // console.info($("input[type='checkbox']").is(':checked'));
   
     $('#ff').form('submit',{
       url:"login.do",
       onSubmit:function(param){
          if($("input[type='checkbox']").is(':checked'))
          {
               param.rememberme=true;
           }
         return $(this).form('enableValidation').form('validate');  
      },
      success:function(data){
      reloadCode();
      var obj = JSON.parse(data);
	      if(obj.msgs!="errorpd"&&obj.msgs!="errorvd"){
	       //location.href("menu.jsp");
	       //window.navigate("menu.jsp");
	          self.location='menu.jsp';
	      }else if(obj.msgs=="errorvd"){
	        $('#ts').children("p").html("您输入验证码有误，请重新输入!");
	        $('#ts').css('display','block');    
	      }else{
	        $('#ts').children("p").html("您输入账号或密码有误，请重新输入!");
	        $('#ts').css('display','block');    
	      }
      }
    }); 
    }
  
/*     var browser = navigator.userAgent

if(browser.indexOf("Chrome“）!= -1 || browser.indexOf("Firefox") != -1)
 用chrome
else
 用ie
endif */
  function clearForm(){
    $('#ff').form('clear');
  };
 $(function() {
/* 	$("input",$("#user").next("span")).focus(function()
    	{
	     $('#ts').css('display','none');
    	}); */
        $("input").next("span").focus(function()
    	{
    	alert("a");
	     $('#ts').css('display','none');
    	});
}); 
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
</html>

