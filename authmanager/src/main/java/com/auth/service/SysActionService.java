package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysActionCondition;
import com.auth.dao.SysActionMapper;
import com.auth.entity.SysAction;

@Service
public class SysActionService {
	@Resource
	SysActionMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysAction record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysAction record) {
		return servicedao.insertSelective(record);
	}

	public SysAction selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysAction record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysAction record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysAction> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysAction> selectByPagination(SysActionCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysActionCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}