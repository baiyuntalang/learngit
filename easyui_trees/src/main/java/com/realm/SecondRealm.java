package com.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.TUser;
import com.service.TUserService;

public class SecondRealm extends AuthenticatingRealm {
	@Autowired
	private TUserService tUserService;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("SecondRealm");
		//1.AuthenticationToken强转为UsernamePasswordToken
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		//2.从UsernamePasswordToken获取username
		String username=upToken.getUsername();
		//3.从数据查询用户记录
		
		//4.用户不存在，抛出异常
		/*if("unknown".equals(username)){
			throw new UnknownAccountException("用户不存在!");
		}*/
		/*int a=tUserService.selectUsername(username);
		if(a<0){
			throw new UnknownAccountException("用户不存在!");
		}*/
		//5.用户锁定异常
		if("monster".equals(username)){
			throw new LockedAccountException("该用户锁定!");
		}
		//根据用户情况，构建AuthenticationInfo对象并返回，通常使用的实现类为：SimpleAuthenticationInfo
		//以下信息从数据库获取
		//1、principle：既可以为username，也可以为对应用户的实体类
		String principal=username;
		//2、credentials：密码
		//String credentials=null;//"123456";
		TUser tuser=tUserService.selectOne(principal);
		String credentials=tuser.getPassword();
		System.out.println("password"+credentials);
		System.out.println("tuser:"+tuser.getUsername());
		/*if("admin".equals(username)){
			credentials="ce2f6417c7e1d32c1d81a797ee0b499f87c5de06";
		}else if("user".equals(username)){
			credentials="073d4c3ae812935f23cb3f2a71943f49e082a718";
		}*/
		//3、realmName：当前realm对象的name,调用父类的getName()方法即可
		String realmName=getName();
		SimpleAuthenticationInfo info=null;//new SimpleAuthenticationInfo(principal, credentials, realmName);
		//4.盐值
		ByteSource credentialsSalt=ByteSource.Util.bytes(username);
		info=new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		System.out.println("info2"+info);
		return null;
	}
public static void main(String[] args) {
	String hashAlgorithmName="SHA1";
	Object credentials="123456";
	Object salt="user";
	int hashIterations=1024;
	Object result=new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
	System.out.println("result:"+result);
}
	
}
