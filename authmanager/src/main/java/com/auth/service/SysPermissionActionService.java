package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysPermissionActionMapper;
import com.auth.entity.SysPermissionAction;

@Service
public class SysPermissionActionService {
	@Resource
	SysPermissionActionMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysPermissionAction record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysPermissionAction record) {
		return servicedao.insertSelective(record);
	}

	public SysPermissionAction selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysPermissionAction record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysPermissionAction record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysPermissionAction> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}