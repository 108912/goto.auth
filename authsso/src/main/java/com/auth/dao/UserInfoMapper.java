package com.auth.dao;

import com.auth.condition.LoginCondition;
import com.auth.entity.UserInfo;

public interface UserInfoMapper {

	UserInfo LoginValid(LoginCondition condition);

}