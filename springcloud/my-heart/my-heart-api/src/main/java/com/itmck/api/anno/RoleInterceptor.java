package com.itmck.api.anno;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itmck.api.exception.NoRoleException;

public class RoleInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			// 获取方法上的注解
			RoleSign annotation = handlerMethod.getMethod().getAnnotation(RoleSign.class);
			if (annotation == null) {
				// 获取类上的注解
				annotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RoleSign.class);
			}
			if (annotation != null) {
				HttpSession session = request.getSession();
				Object attribute = session.getAttribute("role");
				if (attribute != null) {
					int role = (int) session.getAttribute("role");
					if (annotation.id() == role) {
						return true;
					} else {
						logger.info("没有权限................");
						throw new NoRoleException("没有权限...............");
					}
				} else {
					logger.info("未知权限,请确保登陆................");
					throw new NoRoleException("未知权限,请确保登陆.");
				}

			}
		}

		return super.preHandle(request, response, handler);
	}
}
