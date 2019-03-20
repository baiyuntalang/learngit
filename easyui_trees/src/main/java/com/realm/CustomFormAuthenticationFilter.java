package com.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override	
	protected boolean onAccessDenied(ServletRequest request,
	            ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session =httpServletRequest.getSession();
        String validateCode = (String) session.getAttribute("validateCode");
        String randomcode = httpServletRequest.getParameter("randomcode");
        System.out.println("filter");
        if(randomcode!=null && validateCode!=null && !randomcode.equals(validateCode)){ 
        	//如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中 
        	httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
        	  //拒绝访问，不再校验账号和密码 
            return true; 
        }
        return super.onAccessDenied(request, response);
	}
}
