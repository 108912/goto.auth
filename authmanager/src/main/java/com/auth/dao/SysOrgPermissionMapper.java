package com.auth.dao;

import java.util.List;

import com.auth.entity.SysOrgPermission;

public interface SysOrgPermissionMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SysOrgPermission record);

	int insertSelective(SysOrgPermission record);

	SysOrgPermission selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysOrgPermission record);

	int updateByPrimaryKey(SysOrgPermission record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysOrgPermission> selectByAboutId(Long aboutid);
}