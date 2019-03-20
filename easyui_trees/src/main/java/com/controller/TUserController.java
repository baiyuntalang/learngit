package com.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.TUser;
import com.service.ShiroService;
import com.service.TUserService;
import com.util.SecurityUtil;
import com.util.VerifyCode;

@Controller
@RequestMapping("/")
public class TUserController {
@Autowired
private TUserService tUserService;
/*@Autowired
private ShiroService shiroService;*/

//接收时间
@org.springframework.web.bind.annotation.InitBinder
public void InitBinder(HttpServletRequest request,
    ServletRequestDataBinder binder) {
// 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
// SimpleDateFormat dateFormat = new
// SimpleDateFormat(getText("date.format", request.getLocale()));
SimpleDateFormat dateFormat = new SimpleDateFormat(
        "yyyy-MM-dd HH:mm:ss");  // HH:mm:ss
dateFormat.setLenient(false);
binder.registerCustomEditor(java.util.Date.class, null, new CustomDateEditor(
        dateFormat, true));
}

@ResponseBody
@RequestMapping("login.do")
public Map<String,String> login(Model model,TUser tUser,HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
	Map<String,String> map=new HashMap<>(); 
	String rememberme = request.getParameter("rememberme");
	System.out.println("rememberme"+rememberme);
	//验证验证码
		String code = request.getParameter("code");
	    // 验证验证码
	    String sessionCode = request.getSession().getAttribute("code").toString();
	    if (code != null && !"".equals(code) && sessionCode != null && !"".equals(sessionCode)) {
	   	  // System.out.println("code:"+code);
	   	 //System.out.println("sessionCode:"+sessionCode);
	        if (code.equalsIgnoreCase(sessionCode)) {
	        	map.put("msgs","success");
	        } else {
	        	map.put("msgs","errorvd");
	        	 return map;
	        }
	    } else {
	    	    map.put("msgs","errorvd");
	    	    return map;
	    }
	//验证账号和密码
	System.out.println(tUser.getUsername());
	System.out.println(tUser.getPassword());
	Subject subject=SecurityUtils.getSubject();
	String username=tUser.getUsername();
	String password=tUser.getPassword();
	if(!subject.isAuthenticated()){
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		boolean  falg=rememberme==null?false:true;
		System.out.println(falg);
			token.setRememberMe(falg);	
		try{
			subject.login(token);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录失败"+e.getMessage());
			token.clear();  
			map.put("msgs","errorpd");
			return  map;
		}
		 Session session1 = subject.getSession();  
	     TUser currentUser =tUserService.selectOne(username);
	     session1.setAttribute("currentUser",currentUser);  
	}
	
	//map.put("msgs","success");
	return  map;
}

        @RequestMapping("testshiro.do")
		public String testshiro(HttpSession session)throws Exception{
        	session.setAttribute("key", "value");
        /*	shiroService.testMethod();*/
        	tUserService.testService();
			return "redirect:/success.jsp";
		}
        //验证码
        @ResponseBody
        @RequestMapping(value = "getSecurityCode.do", produces = {"application/json;charset=UTF-8"})
        public void getSecurityCode(HttpServletResponse response, HttpServletRequest request){
            // 通知浏览器不要缓存  
                    response.setHeader("Expires", "-1");  
                    response.setHeader("Cache-Control", "no-cache");  
                    response.setHeader("Pragma", "-1");  
                    SecurityUtil util = SecurityUtil.Instance();  
                    // 将验证码输入到session中，用来验证  
                    String code = util.getString();  
                    request.getSession().setAttribute("code", code);  
                    // 输出打web页面  
                    try {
                ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            } 
            }
        
        /* 获取验证码图片*/

        @RequestMapping("getVerifyCode ")

        public void getVerificationCode(HttpServletResponse response,HttpServletRequest request) {

                  try {

                           int width=200;

                           int height=69;

        BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

                           String randomText = VerifyCode.drawRandomText(width,height,verifyImg);

//单独的一个类方法，出于代码复用考虑，进行了封装。

//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   

request.getSession().setAttribute("verifyCode", randomText);

                  response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

                OutputStream os = response.getOutputStream(); //获取文件输出流    

                ImageIO.write(verifyImg,"png",os);//输出图片流

                os.flush();

                os.close();//关闭流

                  } catch (IOException e) {

                         //  this.logger.error(e.getMessage());

                           e.printStackTrace();

                  }

        }
} 
