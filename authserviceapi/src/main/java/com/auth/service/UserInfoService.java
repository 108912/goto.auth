package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.LoginCondition;
import com.auth.condition.UserAuthCondition;
import com.auth.dao.UserInfoMapper;
import com.auth.entity.UserAuthActionInfo;
import com.auth.entity.UserAuthMenuInfo;
import com.auth.entity.UserInfo;

@Service
public class UserInfoService {
	@Resource
	UserInfoMapper servicedao;

	public UserInfo LoginValid(LoginCondition condition) {
		return servicedao.LoginValid(condition);
	}

	public List<UserAuthMenuInfo> GetUserAuthMenu(UserAuthCondition condition) {
		return servicedao.GetUserAuthMenu(condition);
	}

	public List<UserAuthActionInfo> GetUserAuthAction(UserAuthCondition condition) {
		return servicedao.GetUserAuthAction(condition);
	}

}