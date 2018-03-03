package com.auth.dao;

import java.util.List;

import com.auth.condition.SysProjectCondition;
import com.auth.entity.SysProject;

public interface SysProjectMapper {

	List<SysProject> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysProject record);

	int insertSelective(SysProject record);

	SysProject selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysProject record);

	int updateByPrimaryKey(SysProject record);

	List<SysProject> selectByPagination(SysProjectCondition condition);

	int selectByPaginationCount(SysProjectCondition condition);
}