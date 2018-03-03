package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysUserCondition;
import com.auth.dao.SysUserMapper;
import com.auth.entity.SysUser;

@Service
public class SysUserService {
	@Resource
	SysUserMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysUser record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysUser record) {
		return servicedao.insertSelective(record);
	}

	public SysUser selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysUser record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysUser record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysUser> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysUser> selectByPagination(SysUserCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysUserCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}