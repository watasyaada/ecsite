package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.DestinationInfoDAO;
import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private String email;
	private String telNumber;
	private String userAddress;
	private String defaultSexValue;
	private String categoryId;
	private String correctionFlg="0";
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private Map<String, Object> session;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	public String execute() {
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

		if(!session.containsKey("logined")){
			session.put("logined", 0);
		}
		if(!(session.get("logined").equals(1))) {

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

			PurchaseHistoryInfoDAO dao = new PurchaseHistoryInfoDAO();
			RPGrankList   = dao.getRPGrankList();
			ShotrankList  = dao.getShotrankList();
			PuzzlerankList= dao.getPuzzlerankList();

			return "home";
		}

		if(!session.containsKey("destinationFlg")){
			session.put("destinationFlg", 0);
		}
		if(session.get("destinationFlg").equals(1)){
			if(sex.equals("男性")){
				defaultSexValue=MALE;
			}else{
				defaultSexValue=FEMALE;
			}
			sexList.add(MALE);
			sexList.add(FEMALE);
			DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
			if(correctionFlg.equals("1")){
				session.remove("familyNameErrorMessageList");
				session.remove("firstNameErrorMessageList");
				session.remove("famimyNameKanaErrorMessageList");
				session.remove("firstNameKanaErrorMessageList");
				session.remove("emailErrorMessageList");
				session.remove("telNumberErrorMessageList");
				session.remove("userAddressErrorMessageList");
				return result;
			}else{
				int count = destinationInfoDao.insert(String.valueOf(session.get("loginId")), familyName, firstName, familyNameKana, firstNameKana, email, telNumber, userAddress);
				if(count > 0) {
					session.put("createdestinationflg",true);
					result = SUCCESS;
				}
			}
			session.put("destinationFlg", 0);
		}else{
			sexList.add(MALE);
			sexList.add(FEMALE);
			defaultSexValue=MALE;
		}
		return result;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	/**
	 * defaultSexValueを取得します。
	 * @return defaultSexValue
	 */
	public String getDefaultSexValue() {
	    return defaultSexValue;
	}

	/**
	 * defaultSexValueを設定します。
	 * @param defaultSexValue defaultSexValue
	 */
	public void setDefaultSexValue(String defaultSexValue) {
	    this.defaultSexValue = defaultSexValue;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * correctionFlgを取得します。
	 * @return correctionFlg
	 */
	public String getCorrectionFlg() {
	    return correctionFlg;
	}

	/**
	 * correctionFlgを設定します。
	 * @param correctionFlg correctionFlg
	 */
	public void setCorrectionFlg(String correctionFlg) {
	    this.correctionFlg = correctionFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

	public List<MCategoryDTO> getmCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
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