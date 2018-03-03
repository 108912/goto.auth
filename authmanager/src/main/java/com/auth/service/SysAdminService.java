package com.auth.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.condition.LoginCondition;
import com.auth.dao.SysAdminMapper;
import com.auth.entity.SysAdmin;

@Service
public class SysAdminService {
	@Resource
	SysAdminMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysAdmin record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysAdmin record) {
		return servicedao.insertSelective(record);
	}

	public SysAdmin selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysAdmin record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysAdmin record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public SysAdmin selectByLogin(LoginCondition condition) {
		return servicedao.selectByLogin(condition);
	}
}