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
import com.auth.condition.SysRoleCondition;
import com.auth.entity.SysRole;
import com.auth.queryentity.SysRoleQuery;
import com.auth.service.SysRoleService;
import com.auth.viewentity.SysRoleView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysrole")
public class SysRoleController {
	@Resource
	SysRoleService sysroleService;

	@Resource
	SysAboutService sysAboutService;

	@RequestMapping("/index")
	public String Index(SysRoleQuery queryparam, Model model) {
		SysRoleCondition condition = new SysRoleCondition();
		condition.SetQuery(queryparam);
		List<SysRole> datalist = sysroleService.selectByPagination(condition);
		model.addAttribute("querycount", sysroleService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysrole/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysRole dbrecord = sysroleService.selectByPrimaryKey(id);
		SysRoleView record = new SysRoleView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setProjectid(dbrecord.getProjectid());
			record.setName(dbrecord.getName());
			record.setNote(dbrecord.getNote());
			record.setPermissionidlist(sysAboutService.GetRolePermissionIdList(dbrecord.getId()));
		}
		model.addAttribute("record", record);
		return "sysrole/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysRoleView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysrole/addorupdate";
		}
		SysRole dbrecord = sysroleService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysRole();
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysroleService.insertSelective(dbrecord);
		} else {
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysroleService.updateByPrimaryKeySelective(dbrecord);
		}
		sysAboutService.SaveRolePermission(record.getId(), record.getPermissionidlist());
		return "redirect:/sysrole/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysroleService.deleteByPrimaryKey(id);
		sysAboutService.UserRoleUpdateByAboutId2Del(id);
		return new ModelAndView("redirect:/sysrole/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysRole> datalist = sysroleService.selectAll();
		for (SysRole item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(0);
			m.setId(item.getId());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
