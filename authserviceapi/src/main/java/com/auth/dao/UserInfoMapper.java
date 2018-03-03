package com.auth.dao;

import java.util.List;

import com.auth.condition.LoginCondition;
import com.auth.condition.UserAuthCondition;
import com.auth.entity.UserAuthActionInfo;
import com.auth.entity.UserAuthMenuInfo;
import com.auth.entity.UserInfo;

public interface UserInfoMapper {

	UserInfo LoginValid(LoginCondition condition);

	List<UserAuthMenuInfo> GetUserAuthMenu(UserAuthCondition condition);

	List<UserAuthActionInfo> GetUserAuthAction(UserAuthCondition condition);
}