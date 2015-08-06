package com.lxh.module.base;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SysPropertiesUtil {

	private static SysPropertiesUtil oInstance = new SysPropertiesUtil();
	private static Properties oProperties;
	protected final Log logger = LogFactory.getLog(getClass());
	
	protected void loadProperties(){
		try{
			oProperties = new Properties();
			ClassLoader oClassLoader = Thread.currentThread().getContextClassLoader();
			if (oClassLoader == null) {
				oClassLoader = oInstance.getClass().getClassLoader();
			}
			InputStream is = oClassLoader.getResourceAsStream("system.properties");
			if (is != null) {
				oProperties.load(is);
				is.close();
			}else{
				this.logger.error("SysPropertiesUtil can not load property files!");
			}
		}catch(Exception e){
			this.logger.error(e);
		    e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		if (oProperties == null) {
			oInstance.loadProperties();
		}
		return oProperties.getProperty(key);
	}
	
	public static int getInt(String sPropertyName, int iDefaultValue){
		try{
			String sProperty = getProperty(sPropertyName);
			return Integer.parseInt(sProperty);
		}catch(Exception e){
		    e.printStackTrace();
		}
		return iDefaultValue;
	}
	
	public static String getString(String sPropertyName, String sDefaultValue){
		try{
			return getProperty(sPropertyName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return sDefaultValue;
	}
	
	public static HashMap<String,Object> getProperties(String keyGroup){
		HashMap<String,Object> hashmap = new HashMap<String,Object>();
		if (oProperties == null) {
			oInstance.loadProperties();
		}
		Enumeration<Object> enumeration = oProperties.keys();
		while (enumeration.hasMoreElements()) {
			String tempKey = (String)enumeration.nextElement();
			if (tempKey.startsWith(keyGroup)) {
				hashmap.put(tempKey, oProperties.get(tempKey));
			}
		}
		return hashmap;
	}
	
	public static boolean getBoolean(String key, boolean bDefaultValue){
		try{
			String s = getProperty(key);
			if (s != null) {
				return (s.equalsIgnoreCase("true")) || (s.equalsIgnoreCase("t"));
			}
			return bDefaultValue;
		}catch(Exception e){
			e.printStackTrace();
		}
		return bDefaultValue;
	}
}
