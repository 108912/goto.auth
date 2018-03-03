package com.auth.dao;

import java.util.List;

import com.auth.condition.SysDicCondition;
import com.auth.entity.SysDic;

public interface SysDicMapper {

	List<SysDic> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysDic record);

	int insertSelective(SysDic record);

	SysDic selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysDic record);

	int updateByPrimaryKey(SysDic record);

	List<SysDic> selectByPagination(SysDicCondition condition);

	int selectByPaginationCount(SysDicCondition condition);
}