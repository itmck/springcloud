package com.itmck.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 自定义拦截器继承ZuulFilter类并重写其方法
 * 
 * @author 34745
 *
 */
@Component
public class MyFilter extends ZuulFilter {


	@Override
	public boolean shouldFilter() {
		// 这里可以写逻辑判断，是否要过滤，true表示执行此过滤器,false表示不执行
		return true;
	}

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： pre：路由之前
	 * routing：路由之时 post： 路由之后 error：发送错误调用
	 */
	@Override
	public String filterType() {

		return FilterConstants.PRE_TYPE;//这个不要忘记写,否则会报空指针异常
	}

	
	@Override
	public int filterOrder() {
		//执行顺序优先级.数值越小,先执行
		return 0;
	}

	// 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
	@Override
	public Object run() {
		System.out.println("==============================================================");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			System.out.println("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}else {
			ctx.setSendZuulResponse(true);//会进行路由，也就是会调用api服务提供者
        	ctx.setResponseStatusCode(200);
        	ctx.set("isOK",true);//可以把一些值放到ctx中，便于后面的filter获取使用
		}
		System.out.println("ok");
		return null;
	}
}
