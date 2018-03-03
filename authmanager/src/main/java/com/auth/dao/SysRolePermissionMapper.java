package com.auth.dao;

import java.util.List;

import com.auth.entity.SysRolePermission;

public interface SysRolePermissionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysRolePermission record);

	int insertSelective(SysRolePermission record);

	SysRolePermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysRolePermission record);

	int updateByPrimaryKey(SysRolePermission record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysRolePermission> selectByAboutId(Long aboutid);
}