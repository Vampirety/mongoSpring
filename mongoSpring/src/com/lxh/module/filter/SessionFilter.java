package com.lxh.module.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.lxh.module.common.Constants;

/**
 * 登录过滤
 * */
public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain arg2)
			throws ServletException, IOException {
		
		// 不过滤的uri  
		String[] notFilter = new String[] { "login.action","logout.action"};
		// 请求的uri 
		String uri = request.getRequestURI();
		
		boolean doFilter = true; 
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤  
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			// 执行过滤  
            // 从session中获取登录者实体
			Object obj = request.getSession().getAttribute(Constants.Session.current_user);
			if (null == obj) {
				//response.sendRedirect(request.getRequestURL().toString().replace(request.getServletPath(), "")+"/user/logout.action");
				request.setCharacterEncoding("UTF-8");  
                response.setCharacterEncoding("UTF-8");  
                PrintWriter out = response.getWriter();  
                String loginPage = request.getRequestURL().toString().replace(request.getServletPath(), "")+"/user/logout.action";  
                StringBuilder builder = new StringBuilder();  
                builder.append("<script type=\"text/javascript\">");  
                builder.append("alert('网页过期，请重新登录！');");  
                builder.append("window.top.location.href='");  
                builder.append(loginPage);  
                builder.append("';");  
                builder.append("</script>");  
                out.print(builder.toString());
			}else {
				// 如果session中存在登录者实体，则继续  
				arg2.doFilter(request, response);
			}
		}else{
			// 如果session中存在登录者实体，则继续  
			arg2.doFilter(request, response);
		}
	}

}
