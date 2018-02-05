package com.servlet.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String userName = null;
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if("ck-uname".equals(cookie.getName())){
				userName = cookie.getValue();
			}
		}
		
		System.out.println("Clicked user is :: "+userName);
		
	}

}
