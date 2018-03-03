package com.auth.common;

import com.common.RedisHelper;

public class Global {

	public static RedisHelper redisConn = new RedisHelper("127.0.0.1", 6379, "pwd123456");
	public static String Cache_Prefix_Token_UserID = "sysadmin_token_userid_";
	public static String Cache_Prefix_Token_UserInfo = "sysadmin_token_userinfo_";
}
