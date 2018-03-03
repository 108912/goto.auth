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
import com.auth.condition.SysActionCondition;
import com.auth.entity.SysAction;
import com.auth.queryentity.SysActionQuery;
import com.auth.service.SysActionService;
import com.auth.viewentity.SysActionView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysaction")
public class SysActionController {
	@Resource
	SysActionService sysactionService;

	@Resource
	SysAboutService sysAboutService;
	@RequestMapping("/index")
	public String Index(SysActionQuery queryparam,Model model) {
		 SysActionCondition condition=new SysActionCondition();
		 condition.SetQuery(queryparam);
		List<SysAction> datalist = sysactionService.selectByPagination(condition);
		model.addAttribute("querycount",sysactionService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr","name="+CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysaction/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysAction dbrecord = sysactionService.selectByPrimaryKey(id);
		SysActionView record = new SysActionView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setProjectid(dbrecord.getProjectid());
			record.setCode(dbrecord.getCode());
			record.setMenuid(dbrecord.getMenuid());
			record.setName(dbrecord.getName());
			record.setNote(dbrecord.getNote());
		}
		model.addAttribute("record", record);
		return "sysaction/addorupdate";
	}
	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysActionView record,BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysaction/addorupdate";
		}
		SysAction dbrecord = sysactionService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysAction();
			dbrecord.setCode(CommonHelper.GetGuid());
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setMenuid(record.getMenuid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysactionService.insertSelective(dbrecord);
		} else {
			dbrecord.setProjectid(record.getProjectid());
			dbrecord.setMenuid(record.getMenuid());
			dbrecord.setName(record.getName());
			dbrecord.setNote(record.getNote());
			sysactionService.updateByPrimaryKeySelective(dbrecord);
		}
		 return "redirect:/sysaction/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysactionService.deleteByPrimaryKey(id);
		sysAboutService.PermissionActionUpdateByAboutId2Del(id);
		return new ModelAndView("redirect:/sysaction/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysAction> datalist = sysactionService.selectAll();
		for (SysAction item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(0);
			m.setId(item.getId());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
