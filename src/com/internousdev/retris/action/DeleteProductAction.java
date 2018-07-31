package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.CartInfoDAO;
import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport implements SessionAware{
	private int productId;
	private String errorMessage;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();


	public String execute(){
		String result = ERROR;
		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
			ProductInfoDAO productInfoDao = new ProductInfoDAO();
			PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();
			CartInfoDAO cartInfoDao = new CartInfoDAO();
			int count = 0;
			int i = 0;
			int product = 0;

			// 購入履歴からの削除
			i = purchaseHistoryInfoDao.deleteProduct(productId);

			// 商品一覧からの削除
			count = productInfoDao.delete(productId);

			// カートからの削除
			product = cartInfoDao.deleteProduct(productId);


			// エラーメッセージの格納
			if(i <= 0){
				errorMessage = "商品の削除に失敗しました。";
				session.put("errorMessage", errorMessage);
			}else{
				if(count <= 0){
					errorMessage = "商品の削除に失敗しました。";
					session.put("errorMessage", errorMessage);
				}else{
					System.out.println(product);
					errorMessage = "";
					session.put("errorMessage", errorMessage);
					result = SUCCESS;
				}

			}

			// 更新された商品一覧を取得
			productInfoDtoList = productInfoDao.getProductInfoList();
			session.put("productInfoDtoList", productInfoDtoList);
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


	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
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
