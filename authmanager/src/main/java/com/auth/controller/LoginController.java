package com.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.auth.condition.LoginCondition;
import com.auth.entity.SysAdmin;
import com.auth.service.SysAdminService;
import com.common.CommonHelper;

/**
 * 用户验证
 */
@Controller
public class LoginController {

	@Resource
	SysAdminService sysadminService;

	/**
	 * 登录
	 * 
	 * @param session
	 *            HttpSession
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(LoginCondition param, HttpSession session) throws Exception {
		if (param != null && CommonHelper.StrIsNotNull(param.getName()) && CommonHelper.StrIsNotNull(param.getPwd())) {
			SysAdmin dbrecord = sysadminService.selectByLogin(param);
			if (dbrecord != null) {
				session.setAttribute("name", param.getName());
			}
		}
		return new ModelAndView("redirect:/common/index");
	}

	/**
	 * 退出
	 * 
	 * @param session
	 *            Session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) throws Exception {
		session.invalidate();
		return new ModelAndView("redirect:/common/showmsg?msg=logout success");
	}
}