package com.authorization;





import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthorizationTest {

	//角色授权测试
	@Test
	public void testAuthorization(){
		  //创建securityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-permission.ini");
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
		System.out.println("认证状态:"+isAuthenticated);
		//认证通过后授权
		//基于角色授权
		//hasRole中传的是基于角色的唯一标识
		//单个角色判断
		Boolean ishasRole1=subject.hasRole("role1");
		System.out.println("单个角色判断:"+ishasRole1);
		//多个角色判断
		Boolean ishasRole2=subject.hasAllRoles(Arrays.asList("role1","role2"));
		System.out.println("多个角色判断:"+ishasRole2);
		
		//使用check方法进行授权，如果不通过抛出异常
		/*subject.checkRole("role3");*/
		
		//基于资源授权
		//isPermitted传入权限标识符
		//单个权限
		boolean  isPermitted1=subject.isPermitted("user:create:1");
		System.out.println("单个权限判断:"+isPermitted1);
		//多个权限
		boolean  isPermitted2=subject.isPermitted("user:update");
		System.out.println("多个权限判断:"+isPermitted2);
		//使用check方法进行授权，如果不通过抛出异常
		subject.checkPermission("Items:update");
	}
		//资源授权测试
		@Test
		public void testAuthorizationDatabaseRealm(){
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
			System.out.println("认证状态:"+isAuthenticated);
			//认证通过后授权
			
			//基于资源授权,调用isPermitted方法会调用DatabaseRealm从数据库查询正确权限数据
			//isPermitted传入权限标识符,判断user:create:1是否在DatabaseRealm查询到的权限数据之内
			//单个权限
			boolean  isPermitted1=subject.isPermitted("user:create:1");
			System.out.println("单个权限判断:"+isPermitted1);
			//多个权限
			boolean  isPermitted2=subject.isPermittedAll("user:update","user:delete");
			System.out.println("多个权限判断:"+isPermitted2);
			//使用check方法进行授权，如果不通过抛出异常
			subject.checkPermission("Items:add");
	}

}
