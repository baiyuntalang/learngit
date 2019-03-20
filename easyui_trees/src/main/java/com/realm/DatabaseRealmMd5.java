package com.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mysql.jdbc.Util;

public class DatabaseRealmMd5 extends AuthorizingRealm {
	
	//设置realm的名称
    @Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("databaseRealmMd5");
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
	        return null; 
	}
    //用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//第一步从token中取出身份信息
		String  userCode=(String)token.getPrincipal();
		//通过用户输入的userCode在数据库中查询
		//模拟数据库查询密码,散列后的值
		String password="9d84fdd4719fc1c93320d01de7d4aad7";
		//盐
		String salt="ffaf";
		SimpleAuthenticationInfo simpleAuthenticationInfo =  new SimpleAuthenticationInfo(userCode, password,ByteSource.Util.bytes(salt),this.getName());
		
		//查询不到返回null
		
		//查询到返回认证信息AuthenticationInfo
		return simpleAuthenticationInfo;
	}
	 

}

