package com.auth.dao;

import java.util.List;

import com.auth.entity.SysUserRole;

public interface SysUserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUserRole record);

	int insertSelective(SysUserRole record);

	SysUserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUserRole record);

	int updateByPrimaryKey(SysUserRole record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysUserRole> selectByAboutId(Long aboutid);
}