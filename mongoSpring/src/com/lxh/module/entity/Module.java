package com.lxh.module.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Module implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String moduleName;
	private String moduleCode;
	private String moduleUrl;
	private Integer sort;
	private String hasChild;
	private String parentModuleId;
	private String iconUrl;
	private String delFlag="0";
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	public String getParentModuleId() {
		return parentModuleId;
	}
	public void setParentModuleId(String parentModuleId) {
		this.parentModuleId = parentModuleId;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
