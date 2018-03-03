package com.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth.viewshow.ShowMsgModel;

@Controller
@RequestMapping("/common")
public class CommonController {
	@RequestMapping("/showmsg")
	public String Showmsg(ShowMsgModel viewdata, Model model) {
		model.addAttribute("viewdata", viewdata);
		return "common/showmsg";
	}

	@RequestMapping("/index")
	public String Index(Model model) {
		return "common/index";
	}
}