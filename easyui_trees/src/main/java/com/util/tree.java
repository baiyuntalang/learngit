package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.entity.Menu;
import com.entity.TPermission;

public class tree {
	/**
	   * 获取子节点
	   * @param id 父节点id
	   * @param allMenu 所有菜单列表
	   * @return 每个根节点下，所有子菜单列表
	   */
	  public static List<Menu> getChild(Integer id,List<Menu> allMenu){
	    //子菜单
	    List<Menu> childList = new ArrayList<Menu>();
	    for (Menu nav : allMenu) {
	      // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
	      //相等说明：为该根节点的子节点。
	      if(nav.getParantid()!=null){
	    	  if(nav.getParantid().equals(id)){
	  	        childList.add(nav);
	  	      }
	      }
	    }
	    //递归
	    for (Menu nav : childList) {
	      nav.setChildren(getChild(nav.getId(), allMenu));
	    }
	   // Collections.sort(childList,order());//排序
	    //如果节点下没有子节点，返回一个空List（递归退出）
	    if(childList.size() == 0){
	      return new ArrayList<Menu>();
	    }
	    return childList;
	  }
	  
	  /*
	   * 排序,根据order排序
	   */
	  public static Comparator<TPermission> order(){
	    Comparator<TPermission> comparator = new Comparator<TPermission>() {
	      @Override
	      public int compare(TPermission o1, TPermission o2) {
	        if(o1.getZindex() != o2.getZindex()){
	          return o1.getZindex() - o2.getZindex();
	        }
	        return 0;
	      }
	    };
	    return comparator;
	  }
}
