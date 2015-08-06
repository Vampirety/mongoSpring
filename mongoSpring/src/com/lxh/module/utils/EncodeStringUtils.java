package com.lxh.module.utils;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class EncodeStringUtils {
	
	private static final Log log = LogFactory.getLog(EncodeStringUtils.class);

	  public static String encodePassword(String password, String algorithm)
	  {
	    byte[] unencodedPassword = password.getBytes();
	    MessageDigest md = null;
	    try
	    {
	    	md = MessageDigest.getInstance(algorithm);
	    }
	    catch (Exception e)
	    {
	      log.error("Exception: " + e);

	      return password;
	    }
	    md.reset();

	    md.update(unencodedPassword);

	    byte[] encodedPassword = md.digest();
	    StringBuffer buf = new StringBuffer();
	    for (int i = 0; i < encodedPassword.length; i++) {
	      if ((encodedPassword[i] & 0xFF) < 16) {
	        buf.append("0");
	      }

	      buf.append(Long.toString(encodedPassword[i] & 0xFF, 16));
	    }

	    return buf.toString();
	  }

	  public static String randomString(int length)
	  {
	    StringBuffer password = new StringBuffer();
	    int index = 0;
	    while (index < length) {
	      char ascii = (char)(int)Math.floor(Math.random() * 125.0D);
	      if (((ascii >= 'a') && (ascii <= 'z')) || 
	        ((ascii >= 'A') && (ascii <= 'Z')) || (
	        (ascii >= '0') && (ascii <= '9'))) {
	        password.append(String.valueOf(ascii));
	        index++;
	      }
	    }
	    return password.toString();
	  }

	  public static String encodeString(String str)
	  {
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encodeBuffer(str.getBytes()).trim();
	  }

	  public static String decodeString(String str)
	  {
	    BASE64Decoder dec = new BASE64Decoder();
	    try {
	      return new String(dec.decodeBuffer(str));
	    }
	    catch (IOException io) {
	      throw new RuntimeException(io.getMessage());
	    }
	  }

	  public static String[] getContextLoaders(String str)
	  {
	    if (str == null)
	      return new String[0];
	    StringTokenizer stk = new StringTokenizer(str, "\n");
	    int size = stk.countTokens();
	    String[] s = new String[size];
	    for (int i = 0; i < size; i++) {
	      s[i] = stk.nextToken().trim();
	    }
	    return s;
	  }

	  public static boolean isNull(String str) {
	    return str == null;
	  }

	  public static boolean isEmpty(String str) {
	    return "".equals(str);
	  }

	  public static boolean isNotNull(String str) {
	    return !isNull(str);
	  }

	  public static boolean isNotEmpty(String str) {
	    return !isEmpty(str);
	  }

	  public static boolean isNullOrEmpty(String str) {
	    return (isNull(str)) || (isEmpty(str));
	  }

	  public static boolean isNotNullAndNotEmpty(String str) {
	    return !isNullOrEmpty(str);
	  }

	  public static String deNull(String str) {
	    return str == null ? "" : str;
	  }

	  public static List<String> getListByToken(String str, String token) {
	    if (str == null) {
	      return new ArrayList<String>();
	    }
	    StringTokenizer st = new StringTokenizer(str, token);
	    List<String> list = new ArrayList<String>();
	    while (st.hasMoreElements()) {
	      list.add(st.nextElement().toString().trim());
	    }
	    return list;
	  }

	  public static String getFirstUpperCaseVarName(String var) {
	    if ((var == null) || ("".equals(var))) {
	      return var;
	    }
	    return var.substring(0, 1).toUpperCase() + 
	      var.substring(1, var.length());
	  }

	  public static String getFirstLowerCaseVarName(String var) {
	    if ((var == null) || ("".equals(var))) {
	      return var;
	    }
	    return var.substring(0, 1).toLowerCase() + 
	      var.substring(1, var.length());
	  }

}
