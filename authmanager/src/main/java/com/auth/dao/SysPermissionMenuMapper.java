package com.auth.dao;

import java.util.List;

import com.auth.entity.SysPermissionMenu;

public interface SysPermissionMenuMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysPermissionMenu record);

	int insertSelective(SysPermissionMenu record);

	SysPermissionMenu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysPermissionMenu record);

	int updateByPrimaryKey(SysPermissionMenu record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysPermissionMenu> selectByAboutId(Long aboutid);
}