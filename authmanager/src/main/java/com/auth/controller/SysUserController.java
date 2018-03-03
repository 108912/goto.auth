package com.auth.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.auth.common.Global;
import com.auth.common.SysAboutService;
import com.auth.condition.SysUserCondition;
import com.auth.entity.SysUser;
import com.auth.queryentity.SysUserQuery;
import com.auth.service.SysUserService;
import com.auth.viewentity.SysUserView;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
	@Resource
	SysUserService sysuserService;

	@Resource
	SysAboutService sysAboutService;

	@RequestMapping("/index")
	public String Index(SysUserQuery queryparam, Model model) {
		SysUserCondition condition = new SysUserCondition();
		condition.SetQuery(queryparam);
		List<SysUser> datalist = sysuserService.selectByPagination(condition);
		model.addAttribute("querycount", sysuserService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysuser/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysUser dbrecord = sysuserService.selectByPrimaryKey(id);
		SysUserView record = new SysUserView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setName(dbrecord.getName());
			record.setPwd(dbrecord.getPwd());
			record.setNote(dbrecord.getNote());
			record.setOrgidlist(sysAboutService.GetUserOrgIdList(record.getId()));
			record.setRoleidlist(sysAboutService.GetUserRoleIdList(record.getId()));
		}
		model.addAttribute("record", record);
		return "sysuser/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysUserView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysuser/addorupdate";
		}
		SysUser dbrecord = sysuserService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysUser();
			dbrecord.setName(record.getName());
			dbrecord.setCode(CommonHelper.GetGuid());
			dbrecord.setPwd(record.getPwd());
			dbrecord.setNote(record.getNote());
			sysuserService.insertSelective(dbrecord);
		} else {
			dbrecord.setName(record.getName());
			dbrecord.setPwd(record.getPwd());
			dbrecord.setNote(record.getNote());
			sysuserService.updateByPrimaryKeySelective(dbrecord);
		}
		sysAboutService.SaveUserOrg(record.getId(), record.getOrgidlist());
		sysAboutService.SaveUserRole(record.getId(), record.getRoleidlist());
		return "redirect:/sysuser/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysuserService.deleteByPrimaryKey(id);
		return new ModelAndView("redirect:/sysuser/index");
	}
}
