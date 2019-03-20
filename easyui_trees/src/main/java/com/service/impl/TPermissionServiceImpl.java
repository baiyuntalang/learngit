package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TPermissionMapper;
import com.entity.TPermission;
import com.service.TPermissionService;
@Service
public class TPermissionServiceImpl implements TPermissionService {
@Autowired
private TPermissionMapper tPermissionMapper;

@Override
public List<TPermission> findAllMenu(int rid) {
	// TODO Auto-generated method stub
	return tPermissionMapper.findAllMenu(rid);
}

@Override
public List<TPermission> findPermissionByName(int uid) {
	// TODO Auto-generated method stub
	return tPermissionMapper.findPermissionByName(uid);
}




}
