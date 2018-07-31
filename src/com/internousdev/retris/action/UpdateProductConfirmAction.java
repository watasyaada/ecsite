package com.internousdev.retris.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.internousdev.retris.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateProductConfirmAction extends ActionSupport implements SessionAware{

	private String productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private String preImageName;
	private String preImagePath;
	private String releaseDate;
	private String releaseCompany;
	private String errorUserImage;
	private String errorProductName;
	private String errorProductNameKana;


	private List<String> productNameErrorMessageList = new ArrayList<String>();
	private List<String> productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> productDescriptionErrorMessageList = new ArrayList<String>();
	private List<String> categoryIdErrorMessageList = new ArrayList<String>();
	private List<String> priceErrorMessageList = new ArrayList<String>();
	private List<String> releaseCompanyErrorMessageList = new ArrayList<String>();
	private List<String> productIdErrorMessageList=new ArrayList<String>();


	private File userImage;
	private String userImageFileName;
	private String userImageContentType;

	private Map<String,Object>session;

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();


	public String execute(){
		String result = ERROR;

		if(session.containsKey("preImageName")){
			preImageName=session.get("preImageName").toString();
		}else{
			preImageName=null;
		}
		if(session.containsKey("preImagePath")){
			preImagePath=session.get("preImagePath").toString();
		}else{
			preImagePath=null;
		}


		InputChecker inputChecker = new InputChecker();
		ProductInfoDAO productInfoDao = new ProductInfoDAO();

		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}

		if(session.get("adminLogined").equals(1)){
		productIdErrorMessageList = inputChecker.doCheck("商品ID", productId, 1, 8, false, false, false, true, false, false, false);
		productNameErrorMessageList = inputChecker.doCheck("商品名", productName, 1, 30, true, true, true, true, true, true, true);
		productNameKanaErrorMessageList = inputChecker.doCheck("商品名かな", productNameKana, 1, 30, false, false, true, true, false, false, false);
		productDescriptionErrorMessageList = inputChecker.doCheck("商品詳細", productDescription, 1, 80, true, true, true, true, true, true, true);
		categoryIdErrorMessageList = inputChecker.doCheck("カテゴリー", categoryId, 1, 6, false, false, false, true, false, false, false);
		priceErrorMessageList = inputChecker.doCheck("価格", price, 1, 16, false, false, false, true, false, false, false);
		releaseCompanyErrorMessageList = inputChecker.doCheck("発売会社", releaseCompany, 1, 50, true, true, true, true, true, true, true);

		if(!session.get("compareProductName").toString().equals(productName)){
			errorProductName = productInfoDao.checkProductName(productName);
		}else{
			errorProductName="";
		}
		if(!session.get("compareProductNameKana").toString().equals(productNameKana)){
			errorProductNameKana = productInfoDao.checkProductNameKana(productNameKana);
		}else{
			errorProductNameKana="";
		}

		if(userImage==null){
			errorUserImage="";
		}
		else if(!(userImageFileName.matches(".+(.jpe?g)"))){
			errorUserImage="jpgかjpegを選択してください。";
		}else if(preImageName!=userImageFileName && productInfoDao.checkImageFileName(userImageFileName) > 0){
			errorUserImage="画像ファイル名を変更してください。";
		}else{
			errorUserImage="";
		}


		if( productNameErrorMessageList.size()==0
				&& productNameKanaErrorMessageList.size()==0
				&& productDescriptionErrorMessageList.size()==0
				&& categoryIdErrorMessageList.size()==0
				&& priceErrorMessageList.size()==0
				&& releaseCompanyErrorMessageList.size()==0
				&& errorProductName==""
				&& errorProductNameKana==""
				&& errorUserImage==""
				&& (!(userImage==null)||(!(preImageName==null)&&!(preImagePath==null)))){

			session.put("updateproductId", productId);
			session.put("updateproductName", productName);
			session.put("updateproductNameKana", productNameKana);
			session.put("updateproductDescription", productDescription);
			session.put("updatecategoryId", categoryId);
			session.put("updateprice", price);
			session.put("updatereleaseDate", releaseDate);
			session.put("updatereleaseCompany", releaseCompany);

			if(!(session.containsKey("image_flg"))){
				session.put("image_file_name", imageFileName);
				session.put("image_file_path", imageFilePath);
			}

			if(!(userImageFileName==null)){
				String filePath=ServletActionContext.getServletContext().getRealPath("/").concat("images");
				System.out.println("Image Location:"+filePath);
				File fileToCreate = new File(filePath,userImageFileName);

			try{
				FileUtils.copyFile(userImage, fileToCreate);
				session.put("image_file_name", userImageFileName);
				session.put("image_file_path", "images/");
				session.put("image_flg", userImageFileName);
			}catch(IOException e){
				e.printStackTrace();
			}
			}else{
				session.put("image_file_name", preImageName);
				session.put("image_file_path", preImagePath);

			}
			result = SUCCESS;
		}else{
			session.put("productIdErrorMessageList", productIdErrorMessageList);
			session.put("productNameErrorMessageList", productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList", productNameKanaErrorMessageList);
			session.put("productDescriptionErrorMessageList", productDescriptionErrorMessageList);
			session.put("categoryIdErrorMessageList", categoryIdErrorMessageList);
			session.put("priceErrorMessageList", priceErrorMessageList);
			session.put("releaseCompanyErrorMessageList", releaseCompanyErrorMessageList);
			session.put("errorProductName",errorProductName);
			session.put("errorProductNameKana",errorProductNameKana);
			session.put("errorUserImage", errorUserImage);


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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<String> getProductNameErrorMessageList() {
		return productNameErrorMessageList;
	}

	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList) {
		this.productNameErrorMessageList = productNameErrorMessageList;
	}

	public List<String> getProductNameKanaErrorMessageList() {
		return productNameKanaErrorMessageList;
	}

	public void setProductNameKanaErrorMessageList(List<String> productNameKanaErrorMessageList) {
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}

	public List<String> getCategoryIdErrorMessageList() {
		return categoryIdErrorMessageList;
	}

	public void setCategoryIdErrorMessageList(List<String> categoryIdErrorMessageList) {
		this.categoryIdErrorMessageList = categoryIdErrorMessageList;
	}

	public List<String> getPriceErrorMessageList() {
		return priceErrorMessageList;
	}

	public void setPriceErrorMessageList(List<String> priceIncorrectErrorMessageList) {
		this.priceErrorMessageList = priceIncorrectErrorMessageList;
	}


	public List<String> getReleaseCompanyErrorMessageList() {
		return releaseCompanyErrorMessageList;
	}

	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList) {
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}

	public List<String> getProductDescriptionErrorMessageList() {
		return productDescriptionErrorMessageList;
	}

	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList) {
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}


	public List<String> getProductIdErrorMessageList() {
		return productIdErrorMessageList;
	}


	public void setProductIdErrorMessageList(List<String> productIdErrorMessageList) {
		this.productIdErrorMessageList = productIdErrorMessageList;
	}


	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getErrorUserImage() {
		return errorUserImage;
	}


	public void setErrorUserImage(String errorUserImage) {
		this.errorUserImage = errorUserImage;
	}


	public String getPreImageName() {
		return preImageName;
	}


	public void setPreImageName(String preImageName) {
		this.preImageName = preImageName;
	}


	public String getPreImagePath() {
		return preImagePath;
	}


	public void setPreImagePath(String preImagePath) {
		this.preImagePath = preImagePath;
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
