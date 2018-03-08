package com.lw;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public Object run() {
		 RequestContext ctx = RequestContext.getCurrentContext();
		 HttpServletRequest request = ctx.getRequest();
		 logger.info("request:{}", request);
		 String ipAddress = ctx.getRequest().getHeader("x-ip-address");
		 logger.info("ipAddress:{}", ipAddress);
		return null;
	}
}
