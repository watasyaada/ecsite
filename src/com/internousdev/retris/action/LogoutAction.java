package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dao.UserInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private Map<String, Object> session;

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();


	public String execute(){
		String result = ERROR;
		UserInfoDAO userInfoDao = new UserInfoDAO();

		String loginId = String.valueOf(session.get("loginId"));
		String tempUserId = String.valueOf(session.get("tempUserId"));
		boolean savedLoginId = Boolean.valueOf(String.valueOf(session.get("savedLoginId")));
		int count = userInfoDao.logout(loginId);

		if(count > 0){

				PurchaseHistoryInfoDAO purchaseHistoryInfodao = new PurchaseHistoryInfoDAO();

				RPGrankList=purchaseHistoryInfodao.getRPGrankList();
				ShotrankList=purchaseHistoryInfodao.getShotrankList();
				PuzzlerankList= purchaseHistoryInfodao.getPuzzlerankList();



				session.clear();
				session.put("savedLoginId", savedLoginId);
				session.put("loginId", loginId);
				session.put("tempUserId", tempUserId);
				session.put("adminLogined", 0);
				session.put("logined", 0);


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

				result = SUCCESS;

		}

		return result;
	}


	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
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
