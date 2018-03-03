package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysMenuCondition;
import com.auth.dao.SysMenuMapper;
import com.auth.entity.SysMenu;

@Service
public class SysMenuService {
	@Resource
	SysMenuMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysMenu record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysMenu record) {
		return servicedao.insertSelective(record);
	}

	public SysMenu selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysMenu record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysMenu record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysMenu> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysMenu> selectByPagination(SysMenuCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysMenuCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}