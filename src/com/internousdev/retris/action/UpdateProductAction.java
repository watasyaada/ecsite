package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProductAction extends ActionSupport implements SessionAware{
	private String imageFilePath;
	private String imageFileName;
	private String productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String categoryId;
	private String price;
	private String releaseDate;
	private String releaseCompany;
	private String updateDate;

	private Map<String,Object> session;

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	public String execute(){

		session.put("compareProductName",productName);
		session.put("compareProductNameKana",productNameKana);

		session.put("preImageName",imageFileName);
		session.put("preImagePath",imageFilePath);

		session.put("productIdErrorMessageList","");
		session.put("errorProductId","");
		session.put("productNameErrorMessageList","");
		session.put("errorProductName","");
		session.put("productNameKanaErrorMessageList","");
		session.put("errorProductNameKana","");
		session.put("priceErrorMessageList","");
		session.put("releaseCompanyErrorMessageList","");
		session.put("errorReleaseDate","");
		session.put("productDescriptionErrorMessageList","");
		session.put("errorUserImage","");

		String result=SUCCESS;

		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
	        String[] releaseDateList = releaseDate.split("/");
	        if(Integer.parseInt(releaseDateList[0])<=18){
	        	releaseDate="20"+releaseDateList[0]+"-"+releaseDateList[1]+"-"+releaseDateList[2];
	        }else{
	        	releaseDate="19"+releaseDateList[0]+"-"+releaseDateList[1]+"-"+releaseDateList[2];
	        }
		}else{
			PurchaseHistoryInfoDAO purchaseHistoryInfodao = new PurchaseHistoryInfoDAO();

			RPGrankList=purchaseHistoryInfodao.getRPGrankList();
			ShotrankList=purchaseHistoryInfodao.getShotrankList();
			PuzzlerankList= purchaseHistoryInfodao.getPuzzlerankList();

			if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
				CommonUtility commonUtility = new CommonUtility();
				session.put("tempUserId", commonUtility.getRandomValue());
			}

			if(!session.containsKey("logined")){
				session.put("logined",0);
			}

			if(!session.containsKey("mCategoryList")){
				MCategoryDAO mCategoryDao = new MCategoryDAO();
				mCategoryDtoList = mCategoryDao.getMCategoryList();
				session.put("mCategoryDtoList", mCategoryDtoList);
			}
			result = "home";
		}
		return result;
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


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
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
