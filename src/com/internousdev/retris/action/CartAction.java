/**
 *
 */
package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.CartInfoDAO;
import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dto.CartInfoDTO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;

	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	public String execute() {
		String result = ERROR;

		if(!(keywords==null)){
			keywords="";
		}

		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
			ProductInfoDAO productInfoDao = new ProductInfoDAO();
			productInfoDtoList = productInfoDao.getProductInfoList();
			session.put("productInfoDtoList", productInfoDtoList);
			return "admin";
		}

		String userId = null;
		session.put("createdestinationflg",false);
		session.put("checkListErrorMessageList", null);
		CartInfoDAO cartInfoDao = new CartInfoDAO();
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		//ログインまたは仮ログイン状態の確認
		if(session.get("logined").equals(1)) {
			userId = String.valueOf(session.get("loginId"));
		}else if (session.containsKey("tempUserId")) {
			userId = String.valueOf(session.get("tempUserId"));
		}
		System.out.println(userId);
		//idでカートの中身を検索
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		//cartの中身がなければnullを入れる
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		if(!(iterator.hasNext())) {
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);

		//合計金額を求める
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		result = SUCCESS;
		//ｍCategoryListがなければ代入する
		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
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
}
