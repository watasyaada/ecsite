package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;



public class HomeAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	public String execute(){

		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
			ProductInfoDAO productInfoDao = new ProductInfoDAO();
			productInfoDtoList = productInfoDao.getProductInfoList();
			session.put("productInfoDtoList", productInfoDtoList);
			return "admin";
		}

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

		// dtoのpriceには合計値ではなく、単体の価格をいれること

		RPGrankList   = dao.getRPGrankList();
		ShotrankList  = dao.getShotrankList();
		PuzzlerankList= dao.getPuzzlerankList();

		return SUCCESS;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getmCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
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
	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

}
