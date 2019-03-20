package com.util;

import java.lang.reflect.Field;
import java.util.Iterator;



import com.entity.Menu;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Class c=Menu.class;
    System.out.println("name");
    Field[] fields = c.getDeclaredFields();
    for(Field field :fields){
    	System.out.println(field.getName());
    }
	}

}
