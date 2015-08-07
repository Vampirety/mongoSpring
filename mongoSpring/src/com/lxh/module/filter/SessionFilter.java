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
 * ��¼����
 * */
public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain arg2)
			throws ServletException, IOException {
		
		// �����˵�uri  
		String[] notFilter = new String[] { "login.action","logout.action"};
		// �����uri 
		String uri = request.getRequestURI();
		
		boolean doFilter = true; 
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// ���uri�а��������˵�uri���򲻽��й���  
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			// ִ�й���  
            // ��session�л�ȡ��¼��ʵ��
			Object obj = request.getSession().getAttribute(Constants.Session.current_user);
			if (null == obj) {
				//response.sendRedirect(request.getRequestURL().toString().replace(request.getServletPath(), "")+"/user/logout.action");
				request.setCharacterEncoding("UTF-8");  
                response.setCharacterEncoding("UTF-8");  
                PrintWriter out = response.getWriter();  
                String loginPage = request.getRequestURL().toString().replace(request.getServletPath(), "")+"/user/logout.action";  
                StringBuilder builder = new StringBuilder();  
                builder.append("<script type=\"text/javascript\">");  
                builder.append("alert('��ҳ���ڣ������µ�¼��');");  
                builder.append("window.top.location.href='");  
                builder.append(loginPage);  
                builder.append("';");  
                builder.append("</script>");  
                out.print(builder.toString());
			}else {
				// ���session�д��ڵ�¼��ʵ�壬�����  
				arg2.doFilter(request, response);
			}
		}else{
			// ���session�д��ڵ�¼��ʵ�壬�����  
			arg2.doFilter(request, response);
		}
	}

}
