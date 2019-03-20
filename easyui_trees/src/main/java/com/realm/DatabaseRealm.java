package com.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseRealm extends AuthorizingRealm {
	
	//设置realm的名称
    @Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("databaseRealm");
	}
	
    //用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		/* String account = (String)principals.getPrimaryPrincipal();
	        AdminUser pojo = new AdminUser();
	        pojo.setAccount(account);
	        Long userId = adminUserService.selectOne(pojo).getId();
	        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
	        *//**根据用户ID查询角色（role），放入到Authorization里.*//*
	        info.setRoles(adminUserService.findRoleByUserId(userId));
	        *//**根据用户ID查询权限（permission），放入到Authorization里.*//*
	        info.setStringPermissions(adminUserService.findPermissionByUserId(userId));*/
		    //从principals中获取主身份信息
	        //将getPrimaryPrincipal方法返回值转为真实身份类型（在下文中的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中的身份类型）
		    String usercode = (String)principals.getPrimaryPrincipal();
		    //根据身份信息获取权限信息
		    //模拟从数据库获取信息
		    List<String> permissions=new ArrayList<String>();
		    permissions.add("user:create");
		    permissions.add("Items:add");
		    System.out.println("授权");
		    //查到权限数据，返回授权信息
		    SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		    //将你上面查询到的授权信息填充到simpleAuthorizationInfo中
		    simpleAuthorizationInfo.addStringPermissions(permissions);
	        return simpleAuthorizationInfo; 
	}
    //用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//第一步从token中取出身份信息
		String  userCode=(String)token.getPrincipal();
		//通过用户输入的userCode在数据库中查询
		//模拟数据库查询密码
		String password="111111";
		SimpleAuthenticationInfo simpleAuthenticationInfo =  new SimpleAuthenticationInfo(userCode, password, this.getName());
		System.out.println("认证");
		  
		//查询不到返回null
		
		//查询到返回认证信息AuthenticationInfo
		return simpleAuthenticationInfo;
	}
	 

}

