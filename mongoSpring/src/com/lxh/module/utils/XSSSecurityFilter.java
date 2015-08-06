/*     */ package com.lxh.module.utils;
/*     */ 
/*     */ import java.io.IOException;

/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/*     */ 
/*     */ 
/*     */ public class XSSSecurityFilter
/*     */   implements Filter
/*     */ {
/*  30 */   private static Logger logger = Logger.getLogger(XSSSecurityFilter.class);
/*     */ 
/*     */   public void destroy()
/*     */   {
/*  36 */     logger.info("XSSSecurityFilter destroy() begin");
/*  37 */     XSSSecurityManager.destroy();
/*  38 */     logger.info("XSSSecurityFilter destroy() end");
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*     */     throws IOException, ServletException
/*     */   {
/*  48 */     checkRequestResponse(request, response);
/*     */ 
/*  50 */     HttpServletRequest httpRequest = (HttpServletRequest)request;
/*  51 */     HttpServletResponse httpResponse = (HttpServletResponse)response;
/*     */ 
/*  57 */     XSSHttpRequestWrapper xssRequest = new XSSHttpRequestWrapper(httpRequest);
/*     */ 
/*  60 */     if (xssRequest.validateParameter(httpResponse)) {
/*  61 */       if (XSSSecurityConfig.IS_LOG)
/*     */       {
/*  64 */         Throwable t = new Throwable(httpRequest.getRequestURI() + " - " + httpRequest.getQueryString());
/*  65 */         BasalException e = new BasalException(Integer.valueOf(2), "请求中包含XSS攻击信息", t);
/*  66 */         logger.error(e.getMessage(), e);
/*     */       }
/*  68 */       if (XSSSecurityConfig.IS_CHAIN) {
/*  69 */         Throwable t = new Throwable(httpRequest.getRequestURI() + " - " + httpRequest.getQueryString());
/*  70 */         BasalException e = new BasalException(Integer.valueOf(2), "请求中包含XSS攻击信息", t);
/*  71 */         httpRequest.getSession().setAttribute("exceptionObject", e);
/*  72 */         httpRequest.getRequestDispatcher(XSSSecurityCon.FILTER_ERROR_PAGE).forward(httpRequest, httpResponse);
/*  73 */         return;
/*     */       }
/*     */     }
			  String url = httpRequest.getRequestURI().toString();
			  if(url.indexOf("saveAddFlow")==-1&&url.indexOf("saveOrUpdPublishInfo")==-1){
				  chain.doFilter(xssRequest, response);
			  }else{
				  chain.doFilter(request, response);
			  }
/*  76 */     
/*     */   }
/*     */ 
/*     */   public void init(FilterConfig filterConfig)
/*     */     throws ServletException
/*     */   {
/*  83 */     XSSSecurityManager.init(filterConfig);
/*     */   }
/*     */ 
/*     */   private void checkRequestResponse(ServletRequest request, ServletResponse response)
/*     */     throws ServletException
/*     */   {
/*  96 */     if (!(request instanceof HttpServletRequest)) {
/*  97 */       throw new ServletException("Can only process HttpServletRequest");
/*     */     }
/*     */ 
/* 100 */     if (!(response instanceof HttpServletResponse))
/* 101 */       throw new ServletException("Can only process HttpServletResponse");
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator\桌面\core4.0.12003.jar
 * Qualified Name:     com.jshx.core.security.XSSSecurityFilter
 * JD-Core Version:    0.6.0
 */