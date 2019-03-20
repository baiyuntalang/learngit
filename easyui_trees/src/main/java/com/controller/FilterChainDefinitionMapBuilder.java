package com.controller;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String,String> buildFilterChainDefinitionMap(){
    	LinkedHashMap<String,String> map=new LinkedHashMap<>();
    	map.put("/login**", "anon");
    	map.put("/**", "authc");
    	return map;
    }
}
