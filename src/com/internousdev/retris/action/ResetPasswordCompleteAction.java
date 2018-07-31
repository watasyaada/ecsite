package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.UserInfoDAO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String loginId;
	private String password;
	private Map<String,Object>session;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	public String execute(){
		String result=ERROR;
		if(!session.containsKey("adminLogined")){
			session.put("adminLogined", 0);
		}
		if(session.get("adminLogined").equals(1)){
			ProductInfoDAO productInfoDao = new ProductInfoDAO();
			productInfoDtoList = productInfoDao.getProductInfoList();
			session.put("productInfoDtoList", productInfoDtoList);
			return "admin";
		}
		UserInfoDAO userInfoDAO=new UserInfoDAO();
		int count=userInfoDAO.resetPassword(String.valueOf(session.get("resetLoginId")),String.valueOf(session.get("newPassword")));
		session.put("resetLoginId", "");
		if(count>0){
			result=SUCCESS;
		}else{
			result=ERROR;
		}
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
