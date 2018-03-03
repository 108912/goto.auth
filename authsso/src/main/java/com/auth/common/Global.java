package com.auth.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ObjectError;

import com.common.RedisHelper;

public class Global {

	public static RedisHelper redisConn = new RedisHelper("127.0.0.1", 6379, "pwd123456");
	/**
	 * 缓存登录用户信息(秒)
	 */
	public static int cacheuserlogindefault = 3600;

	public static String Cache_Prefix_Token_UserID = "sysadmin_token_userid_";
	public static String Cache_Prefix_Token_UserInfo = "sysadmin_token_userinfo_";

	public static List<String> GetErrors(List<ObjectError> errors) {
		List<String> result = new ArrayList<String>();
		if (errors != null) {
			for (ObjectError item : errors) {
				result.add(item.getDefaultMessage());
			}
		}
		return result;
	}
}
