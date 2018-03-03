package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysPermissionMenuMapper;
import com.auth.entity.SysPermissionMenu;

@Service
public class SysPermissionMenuService {
	@Resource
	SysPermissionMenuMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysPermissionMenu record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysPermissionMenu record) {
		return servicedao.insertSelective(record);
	}

	public SysPermissionMenu selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysPermissionMenu record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysPermissionMenu record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysPermissionMenu> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}