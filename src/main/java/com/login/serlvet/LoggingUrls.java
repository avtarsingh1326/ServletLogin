package com.login.serlvet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingUrls
 */
@WebFilter("/LoggingUrls")
public class LoggingUrls extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoggingUrls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		
		//System.out.println("Before Calling the Request");
		long currentMillisecondsBefore = System.currentTimeMillis();
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);

		long currentMillisecondsAfterRequestProcessed = System.currentTimeMillis();
		
		
//		System.out.println("Time Take by Request to complete " + (currentMillisecondsAfterRequestProcessed - currentMillisecondsBefore));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
