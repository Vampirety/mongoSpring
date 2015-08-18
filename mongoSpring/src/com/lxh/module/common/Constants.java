package com.lxh.module.common;

public class Constants {
	
	/**
	 * 返回客户端的接口格式
	 * */
	public static class InterfacesResult{
    	public final static String TSR_MSGCODE_SUCCESS="S000";//成功
    	public final static String TSR_MSGCODE_NODATA="E000";//无数据
    	public final static String TSR_MSGCODE_NOLOGIN="E001";//未登陆
    	public final static String TSR_MSGCODE_NOINTERCODE="E002";//接口编号为空
    	public final static String TSR_MSGCODE_INTERCODEERROR="E003";//接口编号错误
    	public final static String TSR_MSGCODE_SYSERROR="E004";//系统错误
    	public final static String TSR_MSGCODE_PARAMERROR="E005";//入参错误
    	public final static String TSR_MSGCODE_ERROR="E006";//错误
    	public final static String TSR_MSGCODE_CODEERROR="E007";//错误
    	public final static String TSR_MSGCODE_WIFIERROR="E008";//错误
    	public final static String TSR_MSGCODE_GAY="E009";//错误
    	public final static String TSR_MSGCODE_ANS="E010";//错误
    	public final static String TSR_MSGCODE_INVITE="E011";//错误
    	public final static String TSR_MSGCODE_PASSERROR="E012";//错误
    	public final static String TSR_MSGCODE_ACCOUNTERROR="E013";//错误
    	public final static String TSR_MSGCODE_FRIERROR="E014";//错误
    	
    	public final static String TSR_MSG_SUCCESS="成功";//成功
    	public final static String TSR_MSG_NODATA="无数据";//无数据
    	public final static String TSR_MSG_NOLOGIN="未登陆";//未登陆
    	public final static String TSR_MSG_NOINTERCODE="接口编号为空";//接口编号为空
    	public final static String TSR_MSG_INTERCODEERROR="接口编号错误";//接口编号错误
    	public final static String TSR_MSG_SYSERROR="系统错误";//系统错误
    	public final static String TSR_MSG_PARAMERROR="入参错误";//入参错误
    	public final static String TSR_MSG_ERROR="错误";//错误
    	public final static String TSR_MSG_CODEERROR="验证码错误";//错误
    	public final static String TSR_MSG_WIFIERROR="绑定wifi错误";//错误
    	public final static String TSR_MSG_GAY="帐号被禁言";//错误
    	public final static String TSR_MSG_ANS="您已经回答过了";//错误
    	public final static String TSR_MSG_INVITE="您已经邀请过了";//错误
    	public final static String TSR_MSG_PASSERROR="密码错误";//错误
    	public final static String TSR_MSG_ACCOUNTERROR="帐号不存在";//错误
    	public final static String TSR_MSG_FRIERROR="对方已经是您的好友了";//错误
    }
	
	/**
	 * 返回客户端的接口格式
	 * */
	public static class LoginResult{
		public final static String TSR_MSGCODE_SUCCESS="S000";//成功
		public final static String TSR_MSGCODE_LOGINFAIL="E000";//帐号或者密码错
		public final static String TSR_MSG_SUCCESS="成功";//成功
		public final static String TSR_MSG_LOGINFAIL="帐号或者密码错";//帐号或者密码错
	}
	
	/**
	 * 返回客户端的接口格式
	 * */
	public static class Session{
		public final static String current_user="current_user";
	}

}
