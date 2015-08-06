package com.lxh.module.entity;

import com.lxh.module.base.BaseModel;

public class ModuleRight extends BaseModel{

	private static final long serialVersionUID = 1L;
	private String moduleId;
	private String rightId;
	private String delFlag="0";
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getRightId() {
		return rightId;
	}
	public void setRightId(String rightId) {
		this.rightId = rightId;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
