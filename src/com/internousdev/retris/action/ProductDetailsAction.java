package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {

	private int productId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private String categoryId;
	private Map<String,Object> session;
	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();
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

	ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	ProductInfoDTO productInfoDTO = new ProductInfoDTO();
	productInfoDTO = productInfoDAO.getProductInfo(productId);

	session.put("id", productInfoDTO.getId());
	session.put("productId", productInfoDTO.getProductId());
	session.put("productName", productInfoDTO.getProductName());
	session.put("productNameKana", productInfoDTO.getProductNameKana());
	session.put("imageFilePath", productInfoDTO.getImageFilePath());
	session.put("imageFileName", productInfoDTO.getImageFileName());
	session.put("price", productInfoDTO.getPrice());

	session.put("releaseCompany", productInfoDTO.getReleaseCompany());
	session.put("releaseDate", productInfoDTO.getReleaseDate());
	session.put("productDescription", productInfoDTO.getProductDescription());

	List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
	session.put("productCountList", productCountList);
	productInfoDtoList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(),productInfoDTO.getProductId(),0,3);
	Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
	if(!(iterator.hasNext())){
		productCountList = null;
	}
	if(productCountList != null){
		session.put("productInfoDtoList", productInfoDtoList);
		result = SUCCESS;
	}else{
		PurchaseHistoryInfoDAO purchasehistoryinfodao = new PurchaseHistoryInfoDAO();
		RPGrankList=purchasehistoryinfodao.getRPGrankList();
		ShotrankList=purchasehistoryinfodao.getShotrankList();
		PuzzlerankList=purchasehistoryinfodao.getPuzzlerankList();
	}
    return result;
	}




	public int getProductId() {
	    return productId;
	}
	public void setProductId(int productId) {
	    this.productId = productId;
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


	public String getCategoryId() {
	    return categoryId;
	}
	public void setCategoryId(String categoryId) {
	    this.categoryId = categoryId;
	}


	public Map<String,Object> getSession() {
	    return session;
	}
	public void setSession(Map<String,Object> session) {
	    this.session = session;
	}

	public List<PurchaseHistoryInfoDTO> getRPGrankList(){
		return RPGrankList;
	}
	public void setRPGrankList(List<PurchaseHistoryInfoDTO>RPGrankList){
		this.RPGrankList = RPGrankList;
	}
	public List<PurchaseHistoryInfoDTO> getShotrankList(){
		return ShotrankList;
	}
	public void setShotrankList(List<PurchaseHistoryInfoDTO>ShotrankList){
		this.ShotrankList = ShotrankList;
	}
	public List<PurchaseHistoryInfoDTO> getPuzzlerankList(){
		return PuzzlerankList;
	}
	public void setPuzzlerankList(List<PurchaseHistoryInfoDTO>PuzzlerankList){
		this.PuzzlerankList = PuzzlerankList;
	}

}
