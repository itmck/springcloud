package com.itmck.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmck.api.anno.RoleSign;
import com.itmck.api.pojo.User;
import com.itmck.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String getLogin(HttpServletRequest req, HttpServletResponse resp) {
		String userName = req.getParameter("name");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		User user = userService.checkLogin(userName, password);
		if (user != null) {
			session.setAttribute("role", user.getRole());
			return "登陆成功";
		} else {
			return "登陆失败";
		}
		
	}
	@RoleSign(id=1,description="id为1才能进入")
	@RequestMapping("/crud")
	public String getcrud(HttpServletRequest req, HttpServletResponse resp) {
		
		return "hello  crud............";
	}

}
