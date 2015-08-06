package com.lxh.module.entity;

import java.util.Date;

import com.lxh.module.base.BaseModel;

public class OnlineUser extends BaseModel {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String sessionId;
	private Date loginTime;
	private String loginType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
}
