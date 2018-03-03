package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysProjectCondition;
import com.auth.dao.SysProjectMapper;
import com.auth.entity.SysProject;

@Service
public class SysProjectService {
	@Resource
	SysProjectMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysProject record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysProject record) {
		return servicedao.insertSelective(record);
	}

	public SysProject selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysProject record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysProject record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysProject> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysProject> selectByPagination(SysProjectCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysProjectCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}