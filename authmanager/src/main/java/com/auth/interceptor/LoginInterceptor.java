package com.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��¼��֤��������
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * Handlerִ�����֮������������
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc)
			throws Exception {

	}

	/**
	 * Handlerִ��֮��ModelAndView����֮ǰ�����������
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Handlerִ��֮ǰ�����������
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��ȡ�����URL
		String url = request.getRequestURI();
		// URL:�������ʵ�ַ��������URL���������ؿ���
		if (url.indexOf("/content/") >= 0 || url.indexOf("login.action") >= 0) {
			return true;
		}
		// ��ȡSession
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("name");

		if (username != null) {
			return true;
		}
		// �����������ģ���ת����¼����
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		return false;
	}
}