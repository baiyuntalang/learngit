package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.TRoleMapper;
import com.entity.Menu;
import com.entity.TPermission;
import com.entity.TRole;
import com.entity.TUser;
import com.service.TPermissionService;
import com.service.TRoleService;
import com.service.TUserService;
import com.util.tree;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/")
public class MenuController {
@Autowired
private TPermissionService tPermissionService;
@Autowired
private TUserService tUserService;
@Autowired
private TRoleMapper tRoleMapper;

//接收时间
@org.springframework.web.bind.annotation.InitBinder
public void InitBinder(HttpServletRequest request,
      ServletRequestDataBinder binder) {
  // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
  // SimpleDateFormat dateFormat = new
  // SimpleDateFormat(getText("date.format", request.getLocale()));
  SimpleDateFormat dateFormat = new SimpleDateFormat(
          "yyyy-MM-dd HH:mm:ss");  // HH:mm:ss
  dateFormat.setLenient(false);
  binder.registerCustomEditor(java.util.Date.class, null, new CustomDateEditor(
          dateFormat, true));
}


@ResponseBody
@RequestMapping("getMenu.do")
public Map<String,Object> getCpuInfo(Model model)throws Exception{
	//获取用户
	String username=(String)SecurityUtils.getSubject().getPrincipal();
	System.out.println("menu:"+username);
	TUser tUser=tUserService.selectOne(username);
	 //获取用户角色
   // Set<TRole> roles =tRoleMapper.findRolesByUserId(tUser.getId());
    //获取权限
    List<TPermission> rootMenu=tPermissionService.findPermissionByName(tUser.getId());
	// 原始的数据
   // List<TPermission> rootMenu = tPermissionService.findAllMenu(tUser.getId());
    List<Menu> Menus=new ArrayList<Menu>();
    // 查看结果
    for (TPermission menu : rootMenu) {
       Menu m=new Menu();
       m.setId(menu.getId());
       m.setParantid(menu.getParantid());
       m.setText(menu.getName());
       JSONObject json = new JSONObject();
       json.accumulate("url", menu.getUrl());
       json.accumulate("zindex", menu.getZindex());
       m.setAttribute(json);
       Menus.add(m);
    }
    // 最后的结果
   List<Menu> menuList = new ArrayList<Menu>();
    // 先找到所有的一级菜单
    for (int i = 0; i < Menus.size(); i++) {
    	if(Menus.get(i).getParantid()!=null){
    	  if(Menus.get(i).getParantid()==0){
    		//System.out.println(Menus.get(i).getParantid());
    		menuList.add(Menus.get(i));	
    	  }
    	}
    }
    // 为一级菜单设置子菜单，getChild是递归调用的
    for (Menu menu : menuList) {
    	menu.setChildren(tree.getChild(menu.getId(),Menus));
    }
    Map<String,Object> jsonMap = new HashMap<>();
    jsonMap.put("menu", menuList);
   // System.out.println(gson.toJson(jsonMap));
   return jsonMap;
   
}
}
