package com.lxh.module.entity;

import com.lxh.module.base.BaseModel;

public class Right extends BaseModel{

	private static final long serialVersionUID = 1L;
	private String rightName;
	private String delFlag="0";
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
