package com.gitspringboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SessionIdLogFilter implements Filter {

	private final static Logger LOGGER = LoggerFactory.getLogger(SessionIdLogFilter.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		LOGGER.info("Ashraf logging filter");
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		LOGGER.info("Hey MyFilter invoked man");
		HttpServletRequest req=(HttpServletRequest)request;
		MDC.put("sessionID", req.getSession().getId());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		LOGGER.warn("Destruindo o filtro de logging");
	}

	// Now, confgure the Filter implemented above in Spring configuration class.
	// Take a look
	@Bean
	public FilterRegistrationBean myFilterBean() {
		final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new SessionIdLogFilter());
		filterRegBean.addUrlPatterns("/mvc/home");
		filterRegBean.setEnabled(Boolean.TRUE);
		filterRegBean.setName("Meu Filter");
		filterRegBean.setAsyncSupported(Boolean.TRUE);
		return filterRegBean;
	}
}