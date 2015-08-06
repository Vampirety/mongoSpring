package com.lxh.module.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class Pagination {
	
	public static final String SORT_DESC = "descending";
	public static final String SORT_ASC = "ascending";
	private int pageNumber;
	private int pageSize = Integer.parseInt(SysPropertiesUtil.getProperty("paging.size") == null ? "10" : 
	    SysPropertiesUtil.getProperty("paging.size"));
	private int firstResult;
	public int totalCount;
	public List<?> list;
	public List<?> listOfObject;
	private String sortCriterion;
	private String sortType;
	
	protected Pagination(){}
	
	public Pagination(int pageNumb, int pageSize){
		setPageNumber(pageNumb);
		setPageSize(pageSize);
	}
	
	public Pagination(HttpServletRequest request){
		init(request);
	}

	private void init(HttpServletRequest request) {
		String page = request.getParameter("page");
		if ((StringUtils.isEmpty(page)) || (!StringUtils.isNumeric(page))) {
			page = "1";
		}
		setPageNumber(Integer.parseInt(page));
		String sort = request.getParameter("order");
		setSortType(sort);
		String orderBy = request.getParameter("sort");
		if (StringUtils.isNotEmpty(orderBy)) {
			setSortCriterion(orderBy);
		}
		Integer pageSize1 = (Integer)request.getAttribute("rows");
		if (pageSize1 != null) {
			setPageSize(pageSize1.intValue());
		}else{
			String pagesizeStr = request.getParameter("rows");
			if ((pagesizeStr != null) && (!"".equals(pagesizeStr))){
				if (StringUtils.isNumeric(pagesizeStr)){
					setPageSize(Integer.parseInt(pagesizeStr));
				}else{
					setPageSize(2147483647);
				}
			}
		}
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstResult() {
		if (this.pageNumber > 0) {
	      return (this.pageNumber - 1) * this.pageSize;
	    }
	    return this.firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public List<?> getListOfObject() {
		return listOfObject;
	}

	public void setListOfObject(List<?> listOfObject) {
		this.listOfObject = listOfObject;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}
