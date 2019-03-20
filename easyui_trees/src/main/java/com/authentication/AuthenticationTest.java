package com.authentication;



import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.TUser;
import com.service.TUserService;

public class AuthenticationTest {
	@Autowired
	private TUserService tUserService;

	//用户登录和退出
	@Test
	public void testLoginAndLogout(){
    //创建securityManager工厂
	Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-first.ini");
	//创建securityManager
	SecurityManager securityManager=factory.getInstance();
	//将securityManger设置到运行环境功能中
	SecurityUtils.setSecurityManager(securityManager);
	//SecurityUtils中创建一个subject
	org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
	//jdbc获取用户数据
	TUser user=tUserService.selectByPrimaryKey(1);
	String username=user.getUsername();
	String password=user.getPassword();
	//再认证提交前准备token(令牌)
	//UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","111111");
	UsernamePasswordToken token=new UsernamePasswordToken(username,password);
	//执行认证提交
	try {
		subject.login(token);
	} catch (AuthenticationException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	//是否认证通过
	Boolean isAuthenticated=subject.isAuthenticated();
	System.out.println("是否认证通过"+isAuthenticated);
	//退出操作
	subject.logout();
	isAuthenticated=subject.isAuthenticated();
	System.out.println("是否认证通过"+isAuthenticated);
	}
	
	//用户登录和退出
		@Test
		public void testDatebaseRealm(){
	    //创建securityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		//创建securityManager
		SecurityManager securityManager=factory.getInstance();
		//将securityManger设置到运行环境功能中
		SecurityUtils.setSecurityManager(securityManager);
		//SecurityUtils中创建一个subject
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		//再认证提交前准备token(令牌)
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","111111");
		//执行认证提交
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//是否认证通过
		Boolean isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过"+isAuthenticated);
		//退出操作
		/*subject.logout();
		isAuthenticated=subject.isAuthenticated();
		System.out.println("是否认证通过"+isAuthenticated);*/
		}
		
		//用户登录和退出
				@Test
				public void testDatebaseRealmMd5(){
			    //创建securityManager工厂
				Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm-Md5.ini");
				//创建securityManager
				SecurityManager securityManager=factory.getInstance();
				//将securityManger设置到运行环境功能中
				SecurityUtils.setSecurityManager(securityManager);
				//SecurityUtils中创建一个subject
				org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
				//再认证提交前准备token(令牌)
				UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","111111");
				//执行认证提交
				try {
					subject.login(token);
				} catch (AuthenticationException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				//是否认证通过
				Boolean isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过"+isAuthenticated);
				//退出操作
				/*subject.logout();
				isAuthenticated=subject.isAuthenticated();
				System.out.println("是否认证通过"+isAuthenticated);*/
				}
			
		
}
