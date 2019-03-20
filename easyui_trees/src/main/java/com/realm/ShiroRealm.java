package com.realm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.TPermissionMapper;
import com.dao.TRoleMapper;
import com.entity.TRole;
import com.entity.TUser;
import com.service.TUserService;

public class ShiroRealm extends AuthorizingRealm {
@Autowired
private TUserService tUserService;
@Autowired
private TRoleMapper tRoleMapper;
@Autowired
private TPermissionMapper tPermissionMapper;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("FirstRealm");
		//1.AuthenticationToken强转为UsernamePasswordToken
		UsernamePasswordToken upToken=(UsernamePasswordToken)token;
		//2.从UsernamePasswordToken获取username
		String username=upToken.getUsername();
		//3.从数据查询用户记录
		//4.用户不存在，抛出异常
	/*	if("unknown".equals(username)){
			throw new UnknownAccountException("用户不存在!");
		}*/
		System.out.println("username"+username);
		int a=tUserService.selectUsername(username);
		System.out.println(a);
		if(a<0){
			throw new UnknownAccountException("用户不存在!");
		}
		//5.用户锁定异常
		if("monster".equals(username)){
			throw new LockedAccountException("该用户锁定!");
		}
		//根据用户情况，构建AuthenticationInfo对象并返回，通常使用的实现类为：SimpleAuthenticationInfo
		//以下信息从数据库获取
		//1、principle：既可以为username，也可以为对应用户的实体类
		Object principal=username;
		//2、credentials：密码
		//String credentials=null;//"123456";
		System.out.println("b");
		TUser tuser=null;
		try {
			tuser=tUserService.selectOne(username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("tuser:"+tuser.getUsername());
		Object credentials=(Object)tuser.getPassword();
		System.out.println("password:"+credentials);		
		/*if("admin".equals(username)){
			credentials="038bdaf98f2037b31f1e75b5b4c9b26e";
		}else if("user".equals(username)){
			credentials="098d2c478e9c11555ce2823231e02ec1";
		}*/
		//3、realmName：当前realm对象的name,调用父类的getName()方法即可
		String realmName=getName();
		System.out.println(realmName);
		SimpleAuthenticationInfo info=null;//new SimpleAuthenticationInfo(principal, credentials, realmName);
		//4.盐值
		ByteSource credentialsSalt=ByteSource.Util.bytes(username);
		info=new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		System.out.println("info1"+info);
		return info;
	}
	
public static void main(String[] args) {
	String hashAlgorithmName="MD5";
	Object credentials="123456";
	Object salt="user";
	int hashIterations=1024;
	Object result=new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
	System.out.println("result:"+result);
}

@Override
protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	// TODO Auto-generated method stub
	System.out.println("doGetAuthorizationInfo");
	//1.从PrincipalCollection中获取登录用户信息
	String principal=(String)principals.getPrimaryPrincipal();
	TUser tUser=tUserService.selectOne(principal);
	//2.利用登录的信息获取当前用户的角色或权限（可能查询数据库）
	/*Set<String> roles=new HashSet<>();
	roles.add("user");
	if("admin".equals(principal)){
		roles.add("admin");
	}*/
	 //获取用户角色
	
    Set<TRole> roles =tRoleMapper.findRolesByUserId(tUser.getId());
    //添加角色
    SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
    for (TRole role : roles) {
        info.addRole(role.getSn());
    }
    //添加权限
    if("admin".equals(principal)){
    	  List<String> permissionList = new ArrayList<String>();
    	    permissionList.add("menu:book");
    	    info.addStringPermissions(permissionList);
    }
  
	//3.创建SimpleAuthorizationInfo，并设置roles属性
	//SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);
	
	//4.返回SimpleAuthorizationInfo对象
	return info;
}
	
}
