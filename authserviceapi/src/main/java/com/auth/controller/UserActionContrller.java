package com.auth.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth.common.Global;
import com.auth.condition.UserAuthCondition;
import com.auth.entity.UserAuthActionInfo;
import com.auth.entity.UserAuthMenuInfo;
import com.auth.queryentity.TokenAuthQuery;
import com.auth.queryentity.UserAuthQuery;
import com.auth.service.UserInfoService;
import com.auth.viewshow.ApiResponse;
import com.common.CommonHelper;

@Controller
@RequestMapping("/user")
public class UserActionContrller {

	@Resource
	UserInfoService userService;

	@RequestMapping(value = "/getuserauthmenu")
	@ResponseBody
	public ApiResponse<List<UserAuthMenuInfo>> GetUserAuthMenu(UserAuthQuery query) {
		ApiResponse<List<UserAuthMenuInfo>> result = new ApiResponse<List<UserAuthMenuInfo>>();
		if (query.getUserid() > 0 && query.getProjectid() > 0) {
			UserAuthCondition condition = new UserAuthCondition();
			condition.setUserid(query.getUserid());
			condition.setProjectid(query.getProjectid());
			result.Data = userService.GetUserAuthMenu(condition);
		}
		return result;
	}

	@RequestMapping(value = "/getuserauthaction")
	@ResponseBody
	public ApiResponse<List<UserAuthActionInfo>> GetUserAuthAction(UserAuthQuery query) {
		ApiResponse<List<UserAuthActionInfo>> result = new ApiResponse<List<UserAuthActionInfo>>();
		if (query.getUserid() > 0 && query.getProjectid() > 0) {
			UserAuthCondition condition = new UserAuthCondition();
			condition.setUserid(query.getUserid());
			condition.setProjectid(query.getProjectid());
			result.Data = userService.GetUserAuthAction(condition);
		}
		return result;
	}

	@RequestMapping(value = "/gettokenauthmenu")
	@ResponseBody
	public ApiResponse<List<UserAuthMenuInfo>> GetTokenAuthMenu(TokenAuthQuery query) {
		ApiResponse<List<UserAuthMenuInfo>> result = new ApiResponse<List<UserAuthMenuInfo>>();
		if (CommonHelper.StrIsNotNull(query.getToken()) && query.getProjectid() > 0) {
			String cacheuserid = Global.redisConn.Get(Global.Cache_Prefix_Token_UserID + query.getToken());
			if (CommonHelper.StrIsNotNull(cacheuserid)) {
				UserAuthCondition condition = new UserAuthCondition();
				condition.setUserid(Long.parseLong(cacheuserid));
				condition.setProjectid(query.getProjectid());
				result.Data = userService.GetUserAuthMenu(condition);
			}
		}
		return result;
	}

	@RequestMapping(value = "/gettokenauthaction")
	@ResponseBody
	public ApiResponse<List<UserAuthActionInfo>> GetTokenAuthAction(TokenAuthQuery query) {
		ApiResponse<List<UserAuthActionInfo>> result = new ApiResponse<List<UserAuthActionInfo>>();
		if (CommonHelper.StrIsNotNull(query.getToken()) && query.getProjectid() > 0) {
			String cacheuserid = Global.redisConn.Get(Global.Cache_Prefix_Token_UserID + query.getToken());
			if (CommonHelper.StrIsNotNull(cacheuserid)) {
				UserAuthCondition condition = new UserAuthCondition();
				condition.setUserid(Long.parseLong(cacheuserid));
				condition.setProjectid(query.getProjectid());
				result.Data = userService.GetUserAuthAction(condition);
			}
		}
		return result;
	}
}
