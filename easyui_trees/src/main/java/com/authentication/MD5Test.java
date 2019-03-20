package com.authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//原始密码
		String source="111111";
		//盐
		String salt="ffaf";
		//散列次数
		int hashIterations=1;
		//第一个参数：原始密码
		//第二个参数：盐
		//第三个参数：散列次数
        Md5Hash md5Hash=new Md5Hash(source, salt, hashIterations);
	    String password_md5=md5Hash.toString();
	    System.out.println(password_md5);
	    //结果：9d84fdd4719fc1c93320d01de7d4aad7
	    //第一个为散列算法
	    SimpleHash simpleHash=new SimpleHash("md5", source, salt, hashIterations);
	    System.out.println(simpleHash.toString());
	}

}
