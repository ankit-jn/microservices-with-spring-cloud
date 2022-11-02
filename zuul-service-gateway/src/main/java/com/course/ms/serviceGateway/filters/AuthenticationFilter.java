package com.course.ms.serviceGateway.filters;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthenticationFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		System.out.println("Entered into pre filter ->>>>" + ctx.getRequest().getRequestURI());
		Object serviceId = ctx.get("serviceId");
		if (serviceId != null && FilterUtils.FLIGHT_SCHEDULE_SERVICE_NAME.equals(serviceId.toString())) {
			String token = ctx.getRequest().getParameter(FilterUtils.FLIGHT_SCHEDULE_AUTH_TOKEN_KEY);
			if (!FilterUtils.FLIGHT_SCHEDULE_AUTH_TOKEN_VALUE.equals(token)) {
				ctx.setResponseStatusCode(401);
				ctx.setResponseBody("The request is not authenticated");
				ctx.getResponse().setContentType("application/json");
				ctx.setSendZuulResponse(false);
			}
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterUtils.AUTHENTICATION_FILTER_ORDER;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
