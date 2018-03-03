package com.auth.dao;

import java.util.List;

import com.auth.condition.SysPermissionCondition;
import com.auth.entity.SysPermission;

public interface SysPermissionMapper {

	List<SysPermission> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysPermission record);

	int insertSelective(SysPermission record);

	SysPermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysPermission record);

	int updateByPrimaryKey(SysPermission record);

	List<SysPermission> selectByPagination(SysPermissionCondition condition);

	int selectByPaginationCount(SysPermissionCondition condition);
}