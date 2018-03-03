package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysRolePermissionMapper;
import com.auth.entity.SysRolePermission;

@Service
public class SysRolePermissionService {
	@Resource
	SysRolePermissionMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysRolePermission record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysRolePermission record) {
		return servicedao.insertSelective(record);
	}

	public SysRolePermission selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysRolePermission record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysRolePermission record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysRolePermission> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}