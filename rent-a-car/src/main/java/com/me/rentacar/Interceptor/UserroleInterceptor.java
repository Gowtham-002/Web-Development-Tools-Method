package com.me.rentacar.Interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.me.rentacar.pojo.User;

public class UserroleInterceptor {

	public boolean adminRoleIntercept(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User admin = (User) session.getAttribute("admin");
		if (admin == null) {
			return false;
		}
		if (admin.getUserrole().equalsIgnoreCase("admin")) {
			return true;
		}

		return false;

	}

	public boolean userRoleIntercept(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		if (user.getUserrole().equalsIgnoreCase("user")) {
			return true;
		}

		return false;
	}

}