package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.SysDicCondition;
import com.auth.dao.SysDicMapper;
import com.auth.entity.SysDic;

@Service
public class SysDicService {
	@Resource
	SysDicMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysDic record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysDic record) {
		return servicedao.insertSelective(record);
	}

	public SysDic selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysDic record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysDic record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysDic> selectAll() {
		return servicedao.selectAll();
	}

	public List<SysDic> selectByPagination(SysDicCondition condition) {
		return servicedao.selectByPagination(condition);
	}

	public int selectByPaginationCount(SysDicCondition condition) {
		return servicedao.selectByPaginationCount(condition);
	}
}