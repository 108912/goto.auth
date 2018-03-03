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
import com.auth.condition.SysDicCondition;
import com.auth.entity.SysDic;
import com.auth.queryentity.SysDicQuery;
import com.auth.service.SysDicService;
import com.auth.viewentity.SysDicView;
import com.auth.viewshow.ApiResponse;
import com.auth.viewshow.SelectModel;
import com.common.CommonHelper;

@Controller
@RequestMapping("/sysdic")
public class SysDicController {
	@Resource
	SysDicService sysdicService;

	@RequestMapping("/index")
	public String Index(SysDicQuery queryparam,Model model) {
		SysDicCondition condition=new SysDicCondition();
		 condition.SetQuery(queryparam);
		List<SysDic> datalist = sysdicService.selectByPagination(condition);
		model.addAttribute("querycount",sysdicService.selectByPaginationCount(condition));
		model.addAttribute("queryparam", queryparam);
		model.addAttribute("paramstr","name="+CommonHelper.GetStr(queryparam.getName()));
		model.addAttribute("datalist", datalist);
		return "sysdic/index";
	}

	@RequestMapping("/addorupdate")
	public String AddOrUpdate(long id, Model model) {
		SysDic dbrecord = sysdicService.selectByPrimaryKey(id);
		SysDicView record = new SysDicView();
		if (dbrecord != null) {
			record.setId(dbrecord.getId());
			record.setParentid(dbrecord.getParentid());
			record.setKindid(dbrecord.getKindid());
			record.setName(dbrecord.getName());
			record.setValue(dbrecord.getValue());
		}
		model.addAttribute("record", record);
		return "sysdic/addorupdate";
	}

	@RequestMapping("/addorupdate.do")
	public String AddOrUpdateDo(@Valid SysDicView record,BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("errors", Global.GetErrors(result.getAllErrors()));
			model.addAttribute("record", record);
			return "sysdic/addorupdate";
		}
		SysDic dbrecord = sysdicService.selectByPrimaryKey(record.getId());
		if (dbrecord == null) {
			dbrecord = new SysDic();
			dbrecord.setParentid(record.getParentid());
			dbrecord.setKindid(record.getKindid());
			dbrecord.setName(record.getName());
			dbrecord.setValue(record.getValue());
			sysdicService.insertSelective(dbrecord);
		} else {
			dbrecord.setParentid(record.getParentid());
			dbrecord.setKindid(record.getKindid());
			dbrecord.setName(record.getName());
			dbrecord.setValue(record.getValue());
			sysdicService.updateByPrimaryKeySelective(dbrecord);
		}
		 return "redirect:/sysdic/index";
	}

	@RequestMapping("/del")
	public ModelAndView Del(long id) {
		sysdicService.deleteByPrimaryKey(id);
		return new ModelAndView("redirect:/sysdic/index");
	}

	@RequestMapping(value = "selectjson")
	@ResponseBody
	public ApiResponse<List<SelectModel>> SelectJson(HttpServletResponse response) throws IOException {

		ApiResponse<List<SelectModel>> result = new ApiResponse<List<SelectModel>>();
		result.Data = new ArrayList<SelectModel>();
		List<SysDic> datalist = sysdicService.selectAll();
		for (SysDic item : datalist) {
			SelectModel m = new SelectModel();
			m.setParentid(item.getParentid());
			m.setId(item.getId());
			m.setName(item.getName());
			result.Data.add(m);
		}
		return result;
	}
}
