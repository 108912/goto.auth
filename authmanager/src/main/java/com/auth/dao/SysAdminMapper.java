package com.auth.dao;

import com.auth.condition.LoginCondition;
import com.auth.entity.SysAdmin;

public interface SysAdminMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysAdmin record);

	int insertSelective(SysAdmin record);

	SysAdmin selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysAdmin record);

	int updateByPrimaryKey(SysAdmin record);

	SysAdmin selectByLogin(LoginCondition condition);
}