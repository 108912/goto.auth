package com.auth.dao;

import java.util.List;

import com.auth.condition.SysActionCondition;
import com.auth.entity.SysAction;

public interface SysActionMapper {

	int deleteByPrimaryKey(Long id);

	int insert(SysAction record);

	int insertSelective(SysAction record);

	SysAction selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysAction record);

	int updateByPrimaryKey(SysAction record);

	List<SysAction> selectAll();

	List<SysAction> selectByPagination(SysActionCondition condition);

	int selectByPaginationCount(SysActionCondition condition);

}