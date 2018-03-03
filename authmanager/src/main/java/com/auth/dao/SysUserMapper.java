package com.auth.dao;

import java.util.List;

import com.auth.condition.SysUserCondition;
import com.auth.entity.SysUser;

public interface SysUserMapper {

	List<SysUser> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);

	List<SysUser> selectByPagination(SysUserCondition condition);

	int selectByPaginationCount(SysUserCondition condition);
}