package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysRoleCondition;
import com.auth.dao.SysRoleMapper;
import com.auth.entity.SysRole;

@Service
public class SysRoleService {
	@Resource
	SysRoleMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysRole record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysRole record) {
		return servicedao.insertSelective(record);
	}

	public SysRole selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysRole record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysRole record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysRole> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysRole> selectByPagination(SysRoleCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysRoleCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}