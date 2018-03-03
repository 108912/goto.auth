package com.auth.dao;

import java.util.List;

import com.auth.condition.SysOrgCondition;
import com.auth.entity.SysOrg;

public interface SysOrgMapper {

	List<SysOrg> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysOrg record);

	int insertSelective(SysOrg record);

	SysOrg selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysOrg record);

	int updateByPrimaryKey(SysOrg record);

	List<SysOrg> selectByPagination(SysOrgCondition condition);

	int selectByPaginationCount(SysOrgCondition condition);
}