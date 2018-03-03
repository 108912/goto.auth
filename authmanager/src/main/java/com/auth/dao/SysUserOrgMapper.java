package com.auth.dao;

import java.util.List;

import com.auth.entity.SysUserOrg;

public interface SysUserOrgMapper {
	int deleteByPrimaryKey(Long id);

	int insert(SysUserOrg record);

	int insertSelective(SysUserOrg record);

	SysUserOrg selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUserOrg record);

	int updateByPrimaryKey(SysUserOrg record);

	int updateByAboutIdDel(Long aboutid);

	int updateByAboutId2Del(Long aboutid);

	List<SysUserOrg> selectByAboutId(Long aboutid);
}