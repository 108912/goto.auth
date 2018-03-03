package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysOrgCondition;
import com.auth.dao.SysOrgMapper;
import com.auth.entity.SysOrg;

@Service
public class SysOrgService {
	@Resource
	SysOrgMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysOrg record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysOrg record) {
		return servicedao.insertSelective(record);
	}

	public SysOrg selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysOrg record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysOrg record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysOrg> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysOrg> selectByPagination(SysOrgCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysOrgCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}