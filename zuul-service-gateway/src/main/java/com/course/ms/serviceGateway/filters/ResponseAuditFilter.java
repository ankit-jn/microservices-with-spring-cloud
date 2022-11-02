package com.course.ms.serviceGateway.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ResponseAuditFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("Response Audit in Post Filter->>>" + ctx.getResponse().getStatus());
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterUtils.RESPONSE_AUDIT_FILTER_ORDER;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

}
