package com.auth.dao;

import java.util.List;

import com.auth.condition.SysRoleCondition;
import com.auth.entity.SysRole;

public interface SysRoleMapper {

	List<SysRole> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	SysRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);

	List<SysRole> selectByPagination(SysRoleCondition condition);

	int selectByPaginationCount(SysRoleCondition condition);
}