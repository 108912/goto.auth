package com.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth.common.Global;
import com.auth.condition.LoginCondition;
import com.auth.entity.UserInfo;
import com.auth.queryentity.LoginModel;
import com.auth.service.UserInfoService;
import com.common.CommonHelper;

@Controller
@RequestMapping("/user")
public class UserActionContrller {

	@Resource
	UserInfoService userService;

	@RequestMapping(value = "/login.action")
	public String login(LoginModel param, HttpServletRequest req, HttpServletResponse resp, HttpSession session,
			Model model) throws Exception {
		model.addAttribute("param", param);
		if (param != null && CommonHelper.StrIsNotNull(param.getName()) && CommonHelper.StrIsNotNull(param.getPwd())) {
			if (session.getAttribute("name") != param.getName()) {
				LoginCondition condition = new LoginCondition();
				condition.setName(param.getName());
				condition.setPwd(param.getPwd());
				UserInfo dbrecord = userService.LoginValid(condition);
				if (dbrecord != null) {
					String Token = CommonHelper.GetGuid();
					Cookie TokenCookie = new Cookie("utoken", Token);
					TokenCookie.setMaxAge(60 * 60 * 24 * 30);
					resp.addCookie(TokenCookie);
					Global.redisConn.Set(Global.Cache_Prefix_Token_UserID + Token, dbrecord.getId().toString(),
							Global.cacheuserlogindefault);
					session.setAttribute("name", param.getName());
					session.setAttribute("token", Token);
					model.addAttribute("completeurl", CommonHelper.UrlAddParam(param.getTourl(), "token=" + Token));
					return "user/loginsuccess";
				}
			} else {
				model.addAttribute("completeurl", CommonHelper.UrlAddParam(param.getTourl(),
						"token=" + session.getAttribute("token").toString()));
				return "user/loginsuccess";
			}
		}
		return "user/login";
	}
}
