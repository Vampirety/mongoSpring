package com.lxh.module.entity;

import com.lxh.module.base.BaseModel;

public class UserRight extends BaseModel{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String moduleId;
	private String delFlag="0";
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
}
