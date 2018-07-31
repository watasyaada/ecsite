package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.PaginationDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;

	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

    private Map<String,Object> session;

    public String execute(){
    	String result = ERROR;
    	if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
			ProductInfoDAO productInfoDao = new ProductInfoDAO();
			productInfoDtoList = productInfoDao.getProductInfoList();
			session.put("productInfoDtoList", productInfoDtoList);
			return "admin";
		}

    	ProductInfoDAO productInfoDao = new ProductInfoDAO();
    	productInfoDtoList = productInfoDao.getProductInfoList();
    	Pagination pagination = new Pagination();
    	PaginationDTO paginationDTO = pagination.initialize(productInfoDtoList,9);
    	session.put("totalPageSize", paginationDTO.getTotalPageSize());
    	session.put("currentPageNo", paginationDTO.getCurrentPageNo());
    	session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
    	session.put("startRecordNo", paginationDTO.getStartRecordNo());
    	session.put("endRecordNo", paginationDTO.getEndRecordNo());
    	session.put("pageNumberList", paginationDTO.getPageNumberList());

    	session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());

    	session.put("hasNextPage", paginationDTO.isNextPage());
    	session.put("hasPreviousPage", paginationDTO.isPreviousPage());
    	session.put("nextPageNo", paginationDTO.getNextPageNo());
    	session.put("previousPageNo", paginationDTO.getPreviousPageNo());

        if(!session.containsKey("mCategoryList")){
        	MCategoryDAO mCategoryDao = new MCategoryDAO();
        	mCategoryDtoList = mCategoryDao.getMCategoryList();
        	session.put("mCategoryDtoList", mCategoryDtoList);
        }


		if(!(keywords==null)){
			keywords="";
		}

        result = SUCCESS;
        return result;

    }


	public String getProductName() {
	    return productName;
	}
	public void setProductName(String productName) {
	    this.productName = productName;
	}


	public String getProductNameKana() {
	    return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
	    this.productNameKana = productNameKana;
	}


	public String getImageFilePath() {
	    return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
	    this.imageFilePath = imageFilePath;
	}


	public String getImageFileName() {
	    return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
	    this.imageFileName = imageFileName;
	}


	public int getPrice() {
	    return price;
	}
	public void setPrice(int price) {
	    this.price = price;
	}


	public String getCategoryId() {
	    return categoryId;
	}
	public void setCategoryId(String categoryId) {
	    this.categoryId = categoryId;
	}


	public String getKeywords() {
	    return keywords;
	}
	public void setKeywords(String keywords) {
	    this.keywords = keywords;
	}


	public List<MCategoryDTO> getmCategoryDtoList() {
	    return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
	    this.mCategoryDtoList = mCategoryDtoList;
	}


	public List<ProductInfoDTO> getProductInfoDtoList() {
	    return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
	    this.productInfoDtoList = productInfoDtoList;
	}


	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}



}
