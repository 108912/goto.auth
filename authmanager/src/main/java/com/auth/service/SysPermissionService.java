package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysPermissionCondition;
import com.auth.dao.SysPermissionMapper;
import com.auth.entity.SysPermission;

@Service
public class SysPermissionService {
	@Resource
	SysPermissionMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysPermission record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysPermission record) {
		return servicedao.insertSelective(record);
	}

	public SysPermission selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysPermission record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysPermission record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysPermission> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysPermission> selectByPagination(SysPermissionCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysPermissionCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}