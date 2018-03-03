package com.auth.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.LoginCondition;
import com.auth.dao.UserInfoMapper;
import com.auth.entity.UserInfo;

@Service
public class UserInfoService {
	@Resource
	UserInfoMapper servicedao;

	public UserInfo LoginValid(LoginCondition condition) {
		return servicedao.LoginValid(condition);
	}

}