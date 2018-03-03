package com.auth.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.auth.entity.SysOrgPermission;
import com.auth.entity.SysPermissionAction;
import com.auth.entity.SysPermissionMenu;
import com.auth.entity.SysRolePermission;
import com.auth.entity.SysUserOrg;
import com.auth.entity.SysUserRole;
import com.auth.service.SysOrgPermissionService;
import com.auth.service.SysPermissionActionService;
import com.auth.service.SysPermissionMenuService;
import com.auth.service.SysRolePermissionService;
import com.auth.service.SysUserOrgService;
import com.auth.service.SysUserRoleService;
import com.common.CommonHelper;

@Service
public class SysAboutService {
	@Resource
	SysOrgPermissionService sysorgpermissionService;
	@Resource
	SysPermissionMenuService syspermissionmenuService;
	@Resource
	SysPermissionActionService syspermissionactionService;
	@Resource
	SysRolePermissionService sysrolepermissionService;
	@Resource
	SysUserOrgService sysuserorgService;
	@Resource
	SysUserRoleService sysuserroleService;

	public String GetOrgPermissionIdList(Long aboutid) {
		List<SysOrgPermission> dbabout = sysorgpermissionService.selectByAboutId(aboutid);
		String tempaboutidlist = "";
		for (SysOrgPermission item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getPermissionid();
		}
		return tempaboutidlist;
	}

	public int SaveOrgPermission(Long rid, String aboutidstr) {
		int result = 0;
		sysorgpermissionService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidstr)) {
			String[] aboutidlist = aboutidstr.split(",");
			for (String item : aboutidlist) {
				if (item != null && item.length() > 0) {
					SysOrgPermission m = new SysOrgPermission();
					m.setOrgid(rid);
					m.setPermissionid(Long.parseLong(item));
					result += sysorgpermissionService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int OrgPermissionUpdateByAboutId2Del(Long aboutid) {
		return sysorgpermissionService.updateByAboutId2Del(aboutid);
	}

	public String GetPermissionMenuIdList(Long aboutid) {
		List<SysPermissionMenu> dbabout = syspermissionmenuService.selectByAboutId(aboutid);
		String tempaboutidlist = "";
		for (SysPermissionMenu item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getMenuid();
		}
		return tempaboutidlist;
	}

	public int SavePermissionMenu(Long rid, String aboutidStr) {
		int result = 0;
		syspermissionmenuService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidStr)) {
			String[] aboutidlist = aboutidStr.split(",");
			for (String item : aboutidlist) {
				if (item != null && item.length() > 0) {
					SysPermissionMenu m = new SysPermissionMenu();
					m.setPermissionid(rid);
					m.setMenuid(Long.parseLong(item));
					result += syspermissionmenuService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int PermissionMenuUpdateByAboutId2Del(Long aboutid) {
		return syspermissionmenuService.updateByAboutId2Del(aboutid);
	}

	public String GetPermissionActionIdList(Long rid) {
		List<SysPermissionAction> dbabout = syspermissionactionService.selectByAboutId(rid);
		String tempaboutidlist = "";
		for (SysPermissionAction item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getActionid();
		}
		return tempaboutidlist;
	}

	public int SavePermissionAction(Long rid, String aboutidStr) {
		int result = 0;
		syspermissionactionService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidStr)) {
			String[] aboutididlist = aboutidStr.split(",");
			for (String item : aboutididlist) {
				if (item != null && item.length() > 0) {
					SysPermissionAction m = new SysPermissionAction();
					m.setPermissionid(rid);
					m.setActionid(Long.parseLong(item));
					result += syspermissionactionService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int PermissionActionUpdateByAboutId2Del(Long aboutid) {
		return syspermissionactionService.updateByAboutId2Del(aboutid);
	}

	public String GetRolePermissionIdList(Long rid) {
		List<SysRolePermission> dbabout = sysrolepermissionService.selectByAboutId(rid);
		String tempaboutidlist = "";
		for (SysRolePermission item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getPermissionid();
		}
		return tempaboutidlist;
	}

	public int SaveRolePermission(Long rid, String aboutidStr) {
		int result = 0;
		sysrolepermissionService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidStr)) {
			String[] aboutididlist = aboutidStr.split(",");
			for (String item : aboutididlist) {
				if (item != null && item.length() > 0) {
					SysRolePermission m = new SysRolePermission();
					m.setRoleid(rid);
					m.setPermissionid(Long.parseLong(item));
					result += sysrolepermissionService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int UserPermissionUpdateByAboutId2Del(Long aboutid) {
		return sysrolepermissionService.updateByAboutId2Del(aboutid);
	}

	public int RolePermissionUpdateByAboutId2Del(Long aboutid) {
		return sysrolepermissionService.updateByAboutId2Del(aboutid);
	}

	public String GetUserRoleIdList(Long rid) {
		List<SysUserRole> dbabout = sysuserroleService.selectByAboutId(rid);
		String tempaboutidlist = "";
		for (SysUserRole item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getRoleid();
		}
		return tempaboutidlist;
	}

	public int SaveUserRole(Long rid, String aboutidStr) {
		int result = 0;
		sysuserroleService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidStr)) {
			String[] aboutididlist = aboutidStr.split(",");
			for (String item : aboutididlist) {
				if (item != null && item.length() > 0) {
					SysUserRole m = new SysUserRole();
					m.setUserid(rid);
					m.setRoleid(Long.parseLong(item));
					result += sysuserroleService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int UserRoleUpdateByAboutId2Del(Long aboutid) {
		return sysuserroleService.updateByAboutId2Del(aboutid);
	}

	public String GetUserOrgIdList(Long rid) {
		List<SysUserOrg> dbabout = sysuserorgService.selectByAboutId(rid);
		String tempaboutidlist = "";
		for (SysUserOrg item : dbabout) {
			if (tempaboutidlist != null && tempaboutidlist != "") {
				tempaboutidlist += ",";
			}
			tempaboutidlist += item.getOrgid();
		}
		return tempaboutidlist;
	}

	public int SaveUserOrg(Long rid, String aboutidStr) {
		int result = 0;
		sysuserorgService.updateByAboutIdDel(rid);
		if (CommonHelper.StrIsNotNull(aboutidStr)) {
			String[] aboutididlist = aboutidStr.split(",");
			for (String item : aboutididlist) {
				if (item != null && item.length() > 0) {
					SysUserOrg m = new SysUserOrg();
					m.setUserid(rid);
					m.setOrgid(Long.parseLong(item));
					result += sysuserorgService.insertSelective(m);
				}
			}
		}
		return result;
	}

	public int UserOrgUpdateByAboutId2Del(Long aboutid) {
		return sysuserorgService.updateByAboutId2Del(aboutid);
	}
}
