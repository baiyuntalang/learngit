package com.service;

import org.apache.shiro.authz.annotation.RequiresRoles;

import com.entity.TUser;

public interface TUserService {
	 TUser selectByPrimaryKey(Integer id);
	 //admim角色权限
	  @RequiresRoles("admin")
	 void testService();
	  
	 TUser selectOne(String username);
	 Integer selectUsername(String username);
}
