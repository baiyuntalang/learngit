package com.service;

import java.util.List;

import com.entity.TPermission;

public interface TPermissionService {
	 List<TPermission> findAllMenu(int rid);
	 List<TPermission> findPermissionByName(int uid);
}
