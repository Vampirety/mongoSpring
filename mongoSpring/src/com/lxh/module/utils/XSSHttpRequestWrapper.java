/*     */ package com.lxh.module.utils;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletRequestWrapper;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class XSSHttpRequestWrapper extends HttpServletRequestWrapper
/*     */ {
/*     */   HttpServletRequest request;
/*     */ 
/*     */   public XSSHttpRequestWrapper(HttpServletRequest request)
/*     */   {
/*  34 */     super(request);
/*  35 */     this.request = request;
/*     */   }
/*     */ 
/*     */   public String getHeader(String name)
/*     */   {
/*  40 */     String value = super.getHeader(name);
/*     */ 
/*  42 */     if (XSSSecurityConfig.REPLACE) {
/*  43 */       XSSSecurityManager.securityReplace(name);
/*     */     }
/*  45 */     return value;
/*     */   }
/*     */ 
/*     */   public String getParameter(String name)
/*     */   {
/*  50 */     String value = super.getParameter(name);
/*     */ 
/*  52 */     if (XSSSecurityConfig.REPLACE) {
/*  53 */       XSSSecurityManager.securityReplace(name);
/*     */     }
/*  55 */     return value;
/*     */   }
/*     */ 
/*     */   private boolean checkHeader()
/*     */   {
/*  65 */     Enumeration headerParams = getHeaderNames();
/*  66 */     while (headerParams.hasMoreElements()) {
/*  67 */       String headerName = (String)headerParams.nextElement();
/*  68 */       String headerValue = getHeader(headerName);
/*  69 */       if (XSSSecurityManager.matches(headerValue)) {
/*  70 */         return true;
/*     */       }
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */   public Map getParameterMap()
/*     */   {
/*  78 */     return super.getParameterMap();
/*     */   }
/*     */ 
/*     */   private boolean checkParameter()
/*     */   {
/*  91 */     Map submitParams = getParameterMap();
/*  92 */     Set<String> submitNames = (Set<String>)submitParams.keySet();
/*  93 */     for (String submitName : submitNames) {
/*  94 */       Object submitValues = submitParams.get(submitName);
/*  95 */       if ((submitValues instanceof String)) {
/*  96 */         if (XSSSecurityManager.matches((String)submitValues))
/*  97 */           return true;
/*     */       }
/*  99 */       else if ((submitValues instanceof String[])) {
/* 100 */         for (String submitValue : (String[])submitValues) {
/* 101 */           if (XSSSecurityManager.matches(submitValue)) {
/* 102 */             return true;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean validateParameter(HttpServletResponse response)
/*     */     throws ServletException, IOException
/*     */   {
/* 142 */     if ((XSSSecurityConfig.IS_CHECK_HEADER) && 
/* 143 */       (checkHeader())) {
/* 144 */       return true;
/*     */     }
/*     */ 
/* 150 */     return (XSSSecurityConfig.IS_CHECK_PARAMETER) && 
/* 149 */       (checkParameter());
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator\桌面\core4.0.12003.jar
 * Qualified Name:     com.jshx.core.security.XSSHttpRequestWrapper
 * JD-Core Version:    0.6.0
 */