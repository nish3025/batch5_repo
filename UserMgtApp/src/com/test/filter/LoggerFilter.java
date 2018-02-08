package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggerFilter implements Filter{
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		System.out.println("LoggerFilter.....");
		long startTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time Taken to complete request :: "+(endTime-startTime)+" MS");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
