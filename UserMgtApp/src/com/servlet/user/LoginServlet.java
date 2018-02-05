package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.user.UserDao;

public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usrname = request.getParameter("uname");
		String pwd = request.getParameter("pswrd");
		System.out.println("UserName :: " + usrname);
		System.out.println("Password :: " + pwd);
		response.setContentType("text/html");
		try {
			UserDao userDao = new UserDao();
			int count = userDao.checkUser(usrname, pwd);
			PrintWriter out = response.getWriter();
			if (count > 0) {
				out.println("Successfully loggedin...! ");
				Cookie cookie = new Cookie("ck-uname", usrname);
				cookie.setMaxAge(180);
				response.addCookie(cookie);
			} else {
				out.println("Invalid username or password");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.html");
			dispatcher.include(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
