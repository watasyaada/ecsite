package com.internousdev.retris.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {

	private int totalPageSize;
	private int currentPageNo;
	private int totalRecordSize;
	private int startRecordNo;
	private int endRecordNo;
	private List<Integer> pageNumberList = new ArrayList<Integer>();
	private List<ProductInfoDTO> currentProductInfoPage;

	// boolean型のためgetter名称を is○○ で作成

	private boolean NextPage;
	private boolean PreviousPage;


    private int nextPageNo;
    private int previousPageNo;


	public int getTotalPageSize() {
	    return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
	    this.totalPageSize = totalPageSize;
	}


	public int getCurrentPageNo() {
	    return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
	    this.currentPageNo = currentPageNo;
	}


	public int getTotalRecordSize() {
	    return totalRecordSize;
	}
	public void setTotalRecordSize(int totalRecordSize) {
	    this.totalRecordSize = totalRecordSize;
	}


	public int getStartRecordNo() {
	    return startRecordNo;
	}
	public void setStartRecordNo(int startRecordNo) {
	    this.startRecordNo = startRecordNo;
	}


	public int getEndRecordNo() {
	    return endRecordNo;
	}
	public void setEndRecordNo(int endRecordNo) {
	    this.endRecordNo = endRecordNo;
	}


	public List<Integer> getPageNumberList() {
	    return pageNumberList;
	}
	public void setPageNumberList(List<Integer> pageNumberList) {
	    this.pageNumberList = pageNumberList;
	}


	public List<ProductInfoDTO> getCurrentProductInfoPage() {
	    return currentProductInfoPage;
	}
	public void setCurrentProductInfoPage(List<ProductInfoDTO> currentProductInfoPage) {
	    this.currentProductInfoPage = currentProductInfoPage;
	}

	// boolean型

	public boolean isNextPage() {
	    return NextPage;
	}
	public void setNextPage(boolean hasNextPage) {
	    this.NextPage = hasNextPage;
	}

	//boolean型

	public boolean isPreviousPage() {
	    return PreviousPage;
	}
	public void setPreviousPage(boolean hasPreviousPage) {
	    this.PreviousPage = hasPreviousPage;
	}


	public int getNextPageNo() {
	    return nextPageNo;
	}
	public void setNextPageNo(int nextPageNo) {
	    this.nextPageNo = nextPageNo;
	}


	public int getPreviousPageNo() {
	    return previousPageNo;
	}
	public void setPreviousPageNo(int previousPageNo) {
	    this.previousPageNo = previousPageNo;
	}





}
