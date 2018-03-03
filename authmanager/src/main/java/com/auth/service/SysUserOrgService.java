package com.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.dao.SysUserOrgMapper;
import com.auth.entity.SysUserOrg;

@Service
public class SysUserOrgService {
	@Resource
	SysUserOrgMapper servicedao;

	public int deleteByPrimaryKey(Long id) {
		return servicedao.deleteByPrimaryKey(id);
	}

	public int insert(SysUserOrg record) {
		return servicedao.insert(record);
	}

	public int insertSelective(SysUserOrg record) {
		return servicedao.insertSelective(record);
	}

	public SysUserOrg selectByPrimaryKey(Long id) {
		return servicedao.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(SysUserOrg record) {
		return servicedao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SysUserOrg record) {
		return servicedao.updateByPrimaryKey(record);
	}

	public List<SysUserOrg> selectByAboutId(Long aboutid) {
		return servicedao.selectByAboutId(aboutid);
	}

	public int updateByAboutIdDel(Long aboutid) {
		return servicedao.updateByAboutIdDel(aboutid);
	}

	public int updateByAboutId2Del(Long aboutid) {
		return servicedao.updateByAboutId2Del(aboutid);
	}
}