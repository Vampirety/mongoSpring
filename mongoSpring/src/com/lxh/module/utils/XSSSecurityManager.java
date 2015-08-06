/*     */ package com.lxh.module.utils;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentException;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class XSSSecurityManager
/*     */ {
/*  23 */   private static Logger logger = Logger.getLogger(XSSSecurityManager.class);
/*     */   public static String REGEX;
/*     */   private static Pattern XSS_PATTERN;
/*     */ 
/*     */   public static void init(FilterConfig config)
/*     */   {
/*  41 */     logger.info("XSSSecurityManager init(FilterConfig config) begin");
/*     */ 
/*  43 */     String xssPath = config.getServletContext().getRealPath("/") + 
/*  44 */       config.getInitParameter("securityconfig");
/*     */     try
/*     */     {
/*  48 */       if (initConfig(xssPath))
/*     */       {
/*  50 */         XSS_PATTERN = Pattern.compile(REGEX);
/*     */       }
/*     */     } catch (DocumentException e) {
/*  53 */       logger.error("安全过滤配置文件xss_security_config.xml加载异常", e);
/*     */     }
/*  55 */     logger.info("XSSSecurityManager init(FilterConfig config) end");
/*     */   }
/*     */ 
/*     */   public static boolean initConfig(String path)
/*     */     throws DocumentException
/*     */   {
/*  67 */     logger.info("XSSSecurityManager.initConfig(String path) begin");
/*  68 */     Element superElement = new SAXReader().read(path).getRootElement();
/*  69 */     XSSSecurityConfig.IS_CHECK_HEADER = new Boolean(getEleValue(superElement, XSSSecurityCon.IS_CHECK_HEADER)).booleanValue();
/*  70 */     XSSSecurityConfig.IS_CHECK_PARAMETER = new Boolean(getEleValue(superElement, XSSSecurityCon.IS_CHECK_PARAMETER)).booleanValue();
/*  71 */     XSSSecurityConfig.IS_LOG = new Boolean(getEleValue(superElement, XSSSecurityCon.IS_LOG)).booleanValue();
/*  72 */     XSSSecurityConfig.IS_CHAIN = new Boolean(getEleValue(superElement, XSSSecurityCon.IS_CHAIN)).booleanValue();
/*  73 */     XSSSecurityConfig.REPLACE = new Boolean(getEleValue(superElement, XSSSecurityCon.REPLACE)).booleanValue();
/*     */ 
/*  75 */     Element regexEle = superElement.element(XSSSecurityCon.REGEX_LIST);
/*     */ 
/*  77 */     if (regexEle != null) {
/*  78 */       Iterator regexIt = regexEle.elementIterator();
/*  79 */       StringBuffer tempStr = new StringBuffer("^");
/*     */ 
/*  81 */       while (regexIt.hasNext()) {
/*  82 */         Element regex = (Element)regexIt.next();
/*  83 */         String tmp = regex.getText();
/*  84 */         tmp = tmp.replaceAll("\\\\\\\\", "\\\\");
/*  85 */         tempStr.append(tmp);
/*  86 */         tempStr.append("|");
/*     */       }
/*  88 */       if (tempStr.charAt(tempStr.length() - 1) == '|') {
/*  89 */         REGEX = tempStr.substring(0, tempStr.length() - 1) + "$";
/*  90 */         logger.info("安全匹配规则" + REGEX);
/*     */       } else {
/*  92 */         logger.error("安全过滤配置文件加载失败:正则表达式异�?" + tempStr.toString());
/*  93 */         return false;
/*     */       }
/*     */     } else {
/*  96 */       logger.error("安全过滤配置文件中没�?" + XSSSecurityCon.REGEX_LIST + " 属�?");
/*  97 */       return false;
/*     */     }
/*  99 */     logger.info("XSSSecurityManager.initConfig(String path) end");
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   private static String getEleValue(Element element, String tagName)
/*     */   {
/* 111 */     if (isNullStr(element.elementText(tagName))) {
/* 112 */       logger.error("安全过滤配置文件中没�?" + XSSSecurityCon.REGEX_LIST + " 属�?");
/*     */     }
/* 114 */     return element.elementText(tagName);
/*     */   }
/*     */ 
/*     */   public static String securityReplace(String text)
/*     */   {
/* 123 */     if (isNullStr(text)) {
/* 124 */       return text;
/*     */     }
/* 126 */     return text.replaceAll(REGEX, XSSSecurityCon.REPLACEMENT);
/*     */   }
/*     */ 
/*     */   public static boolean matches(String text)
/*     */   {
/* 136 */     if (text == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     text = text.replaceAll("\n", "").replaceAll("\r", "");
/* 140 */     return XSS_PATTERN.matcher(text).matches();
/*     */   }
/*     */ 
/*     */   public static void destroy()
/*     */   {
/* 147 */     logger.info("XSSSecurityManager.destroy() begin");
/* 148 */     XSS_PATTERN = null;
/* 149 */     REGEX = null;
/* 150 */     logger.info("XSSSecurityManager.destroy() end");
/*     */   }
/*     */ 
/*     */   public static boolean isNullStr(String value)
/*     */   {
/* 159 */     return (value == null) || (value.trim().equals(""));
/*     */   }
/*     */ }

/* Location:           C:\Documents and Settings\Administrator\桌面\core4.0.12003.jar
 * Qualified Name:     com.jshx.core.security.XSSSecurityManager
 * JD-Core Version:    0.6.0
 */