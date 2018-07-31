package com.internousdev.retris.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.CartInfoDAO;
import com.internousdev.retris.dao.DestinationInfoDAO;
import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dao.UserInfoDAO;
import com.internousdev.retris.dto.DestinationInfoDTO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.dto.UserInfoDTO;
import com.internousdev.retris.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private Map<String, Object> session;


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

		// カテゴリリストチェック
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if(!session.containsKey("logined")){
			session.put("logined", 0);
		}
		if(session.get("logined").equals(1)){
			PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();

			RPGrankList   = purchaseHistoryInfoDao.getRPGrankList();
			ShotrankList  = purchaseHistoryInfoDao.getShotrankList();
			PuzzlerankList= purchaseHistoryInfoDao.getPuzzlerankList();
			return "home";
		}

		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageList", "");
		session.put("passwordIncorrectMessage", "");



		// ID保管チェック
		if(savedLoginId==true){
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.put("loginId", loginId);
		}


		// 正規表現チェック
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);


		// ログイン認証
		if(loginIdErrorMessageList.size()==0 && passwordErrorMessageList.size()==0){
			UserInfoDAO userInfoDao = new UserInfoDAO();
			if(!loginId.matches("[^A-Z]+")){
				password = "";
			}else if(!password.matches("[^A-Z]+")){
				password = "";
			}
			if(userInfoDao.isExistsUserInfo(loginId, password)){
				// 管理者チェック
				if(userInfoDao.adminCheck(loginId) > 0){
					ProductInfoDAO productInfoDao = new ProductInfoDAO();
					productInfoDtoList = productInfoDao.getProductInfoList();
					session.put("productInfoDtoList", productInfoDtoList);
					session.put("adminLogined", 1);
					result = "admin";
				}else if(userInfoDao.login(loginId, password) > 0){
					UserInfoDTO userInfoDto = userInfoDao.getUserInfo(loginId, password);
					session.put("logined", userInfoDto.getUserId());
					int count = 0;
					CartInfoDAO cartInfoDao = new CartInfoDAO();

					count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
					if(count > 0){
						if(session.get("goLoginFlg").equals(1)){
							PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();

							RPGrankList   = purchaseHistoryInfoDao.getRPGrankList();
							ShotrankList  = purchaseHistoryInfoDao.getShotrankList();
							PuzzlerankList= purchaseHistoryInfoDao.getPuzzlerankList();

							session.put("goLoginFlg", 0);


							result = SUCCESS;
						}else{
							DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
							try{
								List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
								destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
								Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
								if(!(iterator.hasNext())){
									destinationInfoDtoList = null;
								}
								session.put("destinationInfoDtoList", destinationInfoDtoList);
							}catch(SQLException e){
								e.printStackTrace();
							}
							result = "settlement";
						}
					}else{
						PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();

						RPGrankList   = purchaseHistoryInfoDao.getRPGrankList();
						ShotrankList  = purchaseHistoryInfoDao.getShotrankList();
						PuzzlerankList= purchaseHistoryInfoDao.getPuzzlerankList();


						result = SUCCESS;
					}
				}
				session.put("logined", 1);
				session.put("passwordIncorrectMessage", "");
			}else{
				session.put("passwordIncorrectMessage", "入力されたパスワードが異なります。");
			}
		}else{
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList",passwordErrorMessageList);
			session.put("logined", 0);
		}
		return result;
	}


	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId = loginId;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public boolean isSavedLoginId(){
		return savedLoginId;
	}
	public void setSavedLoginId(boolean savedLoginId){
		this.savedLoginId = savedLoginId;
	}

	public List<MCategoryDTO> getMCategoryDtoList(){
		return mCategoryDtoList;
	}
	public void setMCategoryDtoList(List<MCategoryDTO> mCategoryDtoList){
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public List<String> getLoginIdErrorMessageList(){
		return loginIdErrorMessageList;
	}
	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList){
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList){
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

	public List<PurchaseHistoryInfoDTO> getRPGrankList() {
	    return RPGrankList;
	}
	public void setRPGrankList(List<PurchaseHistoryInfoDTO> RPGrankList) {
	    this.RPGrankList = RPGrankList;
	}

	public List<PurchaseHistoryInfoDTO> getShotrankList() {
	    return ShotrankList;
	}
	public void setShotrankList(List<PurchaseHistoryInfoDTO> ShotrankList) {
	    this.ShotrankList = ShotrankList;
	}

	public List<PurchaseHistoryInfoDTO> getPuzzlerankList() {
	    return PuzzlerankList;
	}
	public void setPuzzlerankList(List<PurchaseHistoryInfoDTO> PuzzlerankList) {
	    this.PuzzlerankList = PuzzlerankList;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
