package com.example.job.dto;

import java.util.List;

/*
 * Please see the following example to know  how to use it.
 * NOTICE: the first row is 0, NOT 1
 * 
 * Example: 
 * 		PageBean pb = new PageBean();
 * 		pb.setPageSize(2);
 * 		pb.setDbCount(7);
 * 		pb.setPageNo(1);
 * 
 * 		System.out.println(" Page:" + pb.getPageNo() + "/" + pb.getPageCount()); 
 * 		System.out.println("    Pre page:" + pb.getPrePage() + "(" + pb.isPrePageExist() + ")"); 
 * 		System.out.println("    Next Page:" + pb.getNextPage() + "(" + pb.isNextPageExist() + ")");
 * 		System.out.println("    Row start ~ end:" + pb.getStartRow() + "~" + pb.getEndRow());
 *
 *  PS:
 * 	if setDbCount(0) {
 * 		getPageCount() = 1 
 * 		getPrePage() = 1 
 * 		getNextPage() = 1 
 * 		getStartRow() = 0 
 * 		getEndRow() = 0
 * 	}
 */


public class PageBean<T> {

	/**
	 * current page number
	 */
	private int pageNo = 1;

	/**
	 * total rows from the database
	 */
	private int dbCount;

	/**
	 * page size
	 */
	private int pageSize = 20;
	
	private List<? extends T> resultList;
	

	/*
	 * Set basic information
	 */
	public PageBean() {
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setDbCount(int dbCount) {
		this.dbCount = dbCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/*
	 * Get basic information
	 */
	public int getPageNo() {
		return pageNo;
	}

	public int getDbCount() {
		return dbCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	/*
	 * Get the other related information
	 */

	public int getStartRow() {
		// deal with a special case when no data found
		if (getDbCount() == 0) {
			return 0;
		}

		int startRow = (pageNo - 1) * pageSize;
		return startRow;
	}

	public int getEndRow() {
		if (getDbCount() == 0) {
			return 0;
		}
		int endRow = getStartRow() + pageSize - 1;
		if (endRow > dbCount - 1) {
			endRow = dbCount - 1;
		}
		return endRow;
	}

	public int getPageCount() {
		// deal with the special case when no data fund
		if (getDbCount() == 0) {
			return 1;
		}

		int pageCount = 0;
		if (dbCount % pageSize == 0)
			pageCount = dbCount / pageSize;
		else
			pageCount = dbCount / pageSize + 1;
		return pageCount;
	}

	public int getNextPage() {

		if (getPageNo() < getPageCount()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}

	public int getPrePage() {
		if (getPageNo() > 1) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}

	public boolean isNextPageExist() {
		if (getPageNo() < getPageCount()) {
			return true;
		}
		return false;
	}

	public boolean isPrePageExist() {
		if (getPageNo() > 1) {
			return true;
		}
		return false;
	}

	public List<? extends T> getResultList() {
		return resultList;
	}

	public void setResultList(List<? extends T> resultList) {
		this.resultList = resultList;
	}

	@Override
	public String toString() {
		return "PageBean [pageNo=" + pageNo + ", dbCount=" + dbCount + ", pageSize=" + pageSize 
				+ ", resultList=" + resultList.size()
				+ ",  pageCnt=" + getPageCount()
				+ ",  Pre page:" + getPrePage() + "(" + isPrePageExist() + ")"
				+ ",  Next Page:" + getNextPage() + "(" + isNextPageExist() + ")"
				+ ",  Row start ~ end:" + getStartRow() + "~" + getEndRow()
				+ "]";
	}

}
