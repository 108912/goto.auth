package com.auth.dao;

import java.util.List;

import com.auth.entity.SysPermissionAction;

public interface SysPermissionActionMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysPermissionAction record);

	int insertSelective(SysPermissionAction record);

	SysPermissionAction selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysPermissionAction record);

	int updateByPrimaryKey(SysPermissionAction record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysPermissionAction> selectByAboutId(Long aboutid);
}