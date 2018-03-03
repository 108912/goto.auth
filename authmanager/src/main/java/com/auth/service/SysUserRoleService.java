package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysUserRoleMapper;
import com.auth.entity.SysUserRole;

@Service
public class SysUserRoleService {
	@Resource
	SysUserRoleMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysUserRole record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysUserRole record) {
		return servicedao.insertSelective(record);
	}

	public SysUserRole selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysUserRole record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysUserRole record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysUserRole> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}