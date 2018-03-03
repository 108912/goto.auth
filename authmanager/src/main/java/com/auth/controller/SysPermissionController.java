package com.auth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth.common.Global;
import com.auth.common.SysAboutService;
import com.auth.condition.SysPermissionCondition;
import com.auth.entity.SysPermission;
import com.auth.queryentity.SysPermissionQuery;
import com.auth.service.SysPermissionService;
import com.auth.viewentity.SysPermissionView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/syspermission")
public class SysPermissionController {
	@Resource
	SysPermissionService syspermissionService;

	@Resource
	SysAboutService sysAboutService;

	@RequestMapping("/index")
	public String Index(SysPermissionQuery queryparam, Model model) {
		SysPermissionCondition condition = new SysPermissionCondition();
		condition.SetQuery(queryparam);
		List<SysPermission> datalist = syspermissionService.selectByPagination(condition);
		model.addAttribute("querycount", syspermissionService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "syspermission/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysPermission dbrecord = syspermissionService.selectByPrimaryKey(id);
		SysPermissionView record = new SysPermissionView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setProjectid(dbrecord.getProjectid());
			record.setName(dbrecord.getName());
			record.setNote(dbrecord.getNote());
			record.setMenuidlist(sysAboutService.GetPermissionMenuIdList(dbrecord.getId()));
			record.setActionidlist(sysAboutService.GetPermissionActionIdList(dbrecord.getId()));
		}
		model.addAttribute("record", record);
		return "syspermission/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysPermissionView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "syspermission/addorupdate";
		}
		SysPermission dbrecord = syspermissionService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysPermission();
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			syspermissionService.insertSelective(dbrecord);
		} else {
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			syspermissionService.updateByPrimaryKeySelective(dbrecord);
		}
		sysAboutService.SavePermissionMenu(record.getId(), record.getMenuidlist());
		sysAboutService.SavePermissionAction(record.getId(), record.getActionidlist());
		return "redirect:/syspermission/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		syspermissionService.deleteByPrimaryKey(id);
		sysAboutService.OrgPermissionUpdateByAboutId2Del(id);
		sysAboutService.RolePermissionUpdateByAboutId2Del(id);
		return new ModelAndView("redirect:/syspermission/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysPermission> datalist = syspermissionService.selectAll();
		for (SysPermission item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(0);
			m.setId(item.getId());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
