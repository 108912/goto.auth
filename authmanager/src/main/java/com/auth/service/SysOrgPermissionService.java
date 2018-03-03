package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysOrgPermissionMapper;
import com.auth.entity.SysOrgPermission;

@Service
public class SysOrgPermissionService {
	@Resource
	SysOrgPermissionMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysOrgPermission record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysOrgPermission record) {
		return servicedao.insertSelective(record);
	}

	public SysOrgPermission selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysOrgPermission record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysOrgPermission record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysOrgPermission> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}