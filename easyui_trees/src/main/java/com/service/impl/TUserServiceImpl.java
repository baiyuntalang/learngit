package com.service.impl;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TUserMapper;
import com.entity.TUser;
import com.service.TUserService;
@Service
public class TUserServiceImpl implements TUserService {
@Autowired
private TUserMapper tUserMapper;
	@Override
	public TUser selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("1");
		return tUserMapper.selectByPrimaryKey(id);
	}
	@Override
	public void testService() {
		// TODO Auto-generated method stub
		  Session session=SecurityUtils.getSubject().getSession();
    	  System.out.println("testMethod+time:"+new Date());
    	  Object value=session.getAttribute("key");
    	  System.out.println("service:"+value);
	}
	@Override
	public TUser selectOne(String username) {
		// TODO Auto-generated method stub
		return tUserMapper.selectOne(username);
	}
	@Override
	public Integer selectUsername(String username) {
		// TODO Auto-generated method stub
		System.out.println("selectUsernames");
		return tUserMapper.selectUsername(username);
	}



}
