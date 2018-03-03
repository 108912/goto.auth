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
import com.auth.condition.SysProjectCondition;
import com.auth.entity.SysProject;
import com.auth.queryentity.SysProjectQuery;
import com.auth.service.SysProjectService;
import com.auth.viewentity.SysOrgView;
import com.auth.viewentity.SysProjectView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysproject")
public class SysProjectController {
	@Resource
	SysProjectService sysprojectService;

	@RequestMapping("/index")
	public String Index(SysProjectQuery queryparam, Model model) {
		SysProjectCondition condition = new SysProjectCondition();
		condition.SetQuery(queryparam);
		List<SysProject> datalist = sysprojectService.selectByPagination(condition);
		model.addAttribute("querycount", sysprojectService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr", "name=" + CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysproject/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysProject dbrecord = sysprojectService.selectByPrimaryKey(id);
		SysOrgView record = new SysOrgView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setName(dbrecord.getName());
			record.setNote(dbrecord.getNote());
		}
		model.addAttribute("record", record);
		return "sysproject/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysProjectView record, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysproject/addorupdate";
		}
		SysProject dbrecord = sysprojectService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysProject();
			dbrecord.setCode(CommonHelper.GetGuid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysprojectService.insertSelective(dbrecord);
		} else {
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysprojectService.updateByPrimaryKeySelective(dbrecord);
		}
		return "redirect:/sysproject/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysprojectService.deleteByPrimaryKey(id);
		return new ModelAndView("redirect:/sysproject/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysProject> datalist = sysprojectService.selectAll();
		for (SysProject item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(0);
			m.setId(item.getId());
			m.setCode(item.getCode());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
