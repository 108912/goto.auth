package com.auth.dao;

import java.util.List;

import com.auth.condition.SysMenuCondition;
import com.auth.entity.SysMenu;

public interface SysMenuMapper {

	List<SysMenu> selectAll();

	int deleteByPrimaryKey(Long id);

	int insert(SysMenu record);

	int insertSelective(SysMenu record);

	SysMenu selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysMenu record);

	int updateByPrimaryKey(SysMenu record);

	List<SysMenu> selectByPagination(SysMenuCondition condition);

	int selectByPaginationCount(SysMenuCondition condition);
}