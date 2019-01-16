package com.itmck.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter2 extends ZuulFilter {

	@Override
	public boolean shouldFilter() {

		// 返回true表示执行此过滤器
		return RequestContext.getCurrentContext().getBoolean("isOK");
	}

	@Override
	public String filterType() {
		
		return FilterConstants.PRE_TYPE;// 路由之后执行
	}

	@Override
	public int filterOrder() {
		
		return 2;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String MyFilter2 = request.getParameter("token");
		System.out.println("执行MyFilter2 .....MyFilter2=" + MyFilter2);

		// 如果用户名和密码都正确，则继续执行下一个filter
		if ("true".equals(MyFilter2)) {
			ctx.setSendZuulResponse(true);// 会进行路由，也就是会调用api服务提供者
			ctx.setResponseStatusCode(200);
			ctx.set("isOK", true);// 可以把一些值放到ctx中，便于后面的filter获取使用
		} else {
			ctx.setSendZuulResponse(false);// 不需要进行路由，也就是不会调用api服务提供者
			ctx.setResponseStatusCode(401);
			ctx.set("isOK", false);// 可以把一些值放到ctx中，便于后面的filter获取使用
			// 返回内容给客户端
			ctx.setResponseBody("{\"result\":\"pre01Filter auth not correct!\"}");// 返回错误内容
		}

		return null;

	}
}
