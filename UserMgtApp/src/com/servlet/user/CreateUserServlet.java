package com.servlet.user;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateUserServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String userName = null;
		/*Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if("ck-uname".equals(cookie.getName())){
				userName = cookie.getValue();
			}
		}*/
		
		String email = (String)getServletConfig().getInitParameter("email");
		System.out.println("from email in servlet config :"+email);
		HttpSession session = request.getSession();
		userName = (String)session.getAttribute("uname");
		ServletContext context = request.getServletContext();
		System.out.println((String)context.getInitParameter("company"));
		System.out.println(session.getId()+"Clicked user is :: "+userName);
		
	}

}
