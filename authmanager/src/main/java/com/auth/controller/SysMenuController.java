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
import com.auth.condition.SysMenuCondition;
import com.auth.entity.SysMenu;
import com.auth.queryentity.SysMenuQuery;
import com.auth.service.SysMenuService;
import com.auth.viewentity.SysMenuView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysmenu")
public class SysMenuController {
	@Resource
	SysMenuService sysmenuService;

	@Resource
	SysAboutService sysAboutService;

	@RequestMapping("/index")
	public String Index(SysMenuQuery queryparam, Model model) {
		SysMenuCondition condition = new SysMenuCondition();
		condition.SetQuery(queryparam);
		List<SysMenu> datalist = sysmenuService.selectByPagination(condition);
		model.addAttribute("querycount", sysmenuService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysmenu/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysMenu dbrecord = sysmenuService.selectByPrimaryKey(id);
		SysMenuView record = new SysMenuView();
		if (dbrecord != null) {
			record.setProjectid(dbrecord.getProjectid());
			record.setParentid(dbrecord.getParentid());
			record.setName(dbrecord.getName());
			record.setUrl(dbrecord.getUrl());
			record.setIcostyle(dbrecord.getIcostyle());
			record.setNote(dbrecord.getNote());
		}
		model.addAttribute("record", record);
		return "sysmenu/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysMenuView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysmenu/addorupdate";
		}
		SysMenu dbrecord = sysmenuService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysMenu();
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setCode(CommonHelper.GetGuid());
			dbrecord.setParentid(record.getParentid());
			dbrecord.setName(record.getName());
			dbrecord.setUrl(record.getUrl());
			dbrecord.setIcostyle(record.getIcostyle());
			dbrecord.setNote(record.getNote());
			sysmenuService.insertSelective(dbrecord);
		} else {
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setParentid(record.getParentid());
			dbrecord.setName(record.getName());
			dbrecord.setUrl(record.getUrl());
			dbrecord.setIcostyle(record.getIcostyle());
			dbrecord.setNote(record.getNote());
			sysmenuService.updateByPrimaryKeySelective(dbrecord);
		}
		return "redirect:/sysmenu/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysmenuService.deleteByPrimaryKey(id);
		sysAboutService.PermissionMenuUpdateByAboutId2Del(id);
		return new ModelAndView("redirect:/sysmenu/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysMenu> datalist = sysmenuService.selectAll();
		for (SysMenu item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(item.getParentid());
			m.setId(item.getId());
			m.setCode(item.getCode());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
