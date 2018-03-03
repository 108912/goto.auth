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
import com.auth.condition.SysOrgCondition;
import com.auth.entity.SysOrg;
import com.auth.queryentity.SysOrgQuery;
import com.auth.service.SysOrgService;
import com.auth.viewentity.SysOrgView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysorg")
public class SysOrgController {
	@Resource
	SysOrgService sysorgService;

	@Resource
	SysAboutService sysAboutService;

	@RequestMapping("/index")
	public String Index(SysOrgQuery queryparam, Model model) {
		SysOrgCondition condition = new SysOrgCondition();
		condition.SetQuery(queryparam);
		List<SysOrg> datalist = sysorgService.selectByPagination(condition);
		model.addAttribute("querycount", sysorgService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysorg/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysOrg dbrecord = sysorgService.selectByPrimaryKey(id);
		SysOrgView record = new SysOrgView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setParentid(dbrecord.getParentid());
			record.setName(dbrecord.getName());
			record.setNote(dbrecord.getNote());
			record.setPermissionidlist(sysAboutService.GetOrgPermissionIdList(dbrecord.getId()));
		}
		model.addAttribute("record", record);
		return "sysorg/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysOrgView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysorg/addorupdate";
		}
		SysOrg dbrecord = sysorgService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysOrg();
			dbrecord.setParentid(record.getParentid());
			dbrecord.setCode(CommonHelper.GetGuid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysorgService.insertSelective(dbrecord);
		} else {
			dbrecord.setParentid(record.getParentid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysorgService.updateByPrimaryKeySelective(dbrecord);
		}
		sysAboutService.SaveOrgPermission(record.getId(), record.getPermissionidlist());
		return "redirect:/sysorg/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysorgService.deleteByPrimaryKey(id);
		sysAboutService.UserOrgUpdateByAboutId2Del(id);
		return new ModelAndView("redirect:/sysorg/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysOrg> datalist = sysorgService.selectAll();
		for (SysOrg item : datalist) {
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
