package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.UserInfoDAO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String createuserId;
	private String password;
	private String sex;

	private List<String> familyNameEMessageList = new ArrayList<String>();
	private List<String> firstNameEMessageList = new ArrayList<String>();
	private List<String> familyNameKanaEMessageList = new ArrayList<String>();
	private List<String> firstNameKanaEMessageList = new ArrayList<String>();
	private List<String> emailEMessageList = new ArrayList<String>();
	private List<String> createuserIdEMessageList = new ArrayList<String>();
	private List<String> passwordEMessageList = new ArrayList<String>();

	private String categoryId;
	private List<String> sexList = new ArrayList<String>();
	private Map<String ,Object>session;

	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

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
		InputChecker inputchecker = new InputChecker();
		UserInfoDAO userInfodao = new UserInfoDAO();

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("email", email);
		session.put("createuserId", createuserId);

		session.put("sex", sex);

		familyNameEMessageList = inputchecker.doCheck("姓", familyName, 1, 16, true, true, true, false,false,false,false);
		firstNameEMessageList = inputchecker.doCheck("名", firstName, 1, 16, true, true, true, false,false,false,false);
		familyNameKanaEMessageList = inputchecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false,false,false,false);
		firstNameKanaEMessageList = inputchecker.doCheck("名ふりがな",firstNameKana, 1, 16,false,false,true,false,false,false,false);
		emailEMessageList = inputchecker.doCheck("メールアドレス",email,14, 32, true,false,false,true,true,false,false);
		createuserIdEMessageList = inputchecker.doCheck("ログインID",createuserId,1, 8, true,false,false,true,false,false,false);
		passwordEMessageList = inputchecker.doCheck("パスワード",password,1, 16, true,false,false,true,false,false,false);

		if(!createuserId.matches("[^A-Z]+") && !createuserId.equals("")){
			createuserIdEMessageList.add("ログインIDに半角大文字は使えません。");
		}else if(userInfodao.sameIdchecker(createuserId)){
			createuserIdEMessageList.add("既にそのIDは使われています。");
		}
		if(!password.matches("[^A-Z]+") && !password.equals("")){
			passwordEMessageList.add("パスワードに半角大文字は使えません。");
		}

		if(familyNameEMessageList.size()==0 &&
				firstNameEMessageList.size()==0 &&
				familyNameKanaEMessageList.size()==0 &&
				firstNameKanaEMessageList.size()==0 &&
				emailEMessageList.size()==0 &&
				createuserIdEMessageList.size()==0 &&
				passwordEMessageList.size()==0){
			result =SUCCESS;
		}else{
			session.put("familyNameEMessageList", familyNameEMessageList);
			session.put("firstNameEMessageList", firstNameEMessageList);
			session.put("familyNameKanaEMessageList", familyNameKanaEMessageList);
			session.put("firstNameKanaEMessageList", firstNameKanaEMessageList);
			session.put("emailEMessageList", emailEMessageList);
			session.put("createuserIdEMessageList", createuserIdEMessageList);
			session.put("passwordEMessageList", passwordEMessageList);
		}

		return result;
	}
	public Map<String ,Object> getSession(){
		return session;
	}
	public void setSession(Map<String ,Object>session){
		this.session = session;
	}
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName = familyName;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}
	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana = firstNameKana;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getCreateuserId(){
		return createuserId;
	}
	public void setCreateuserId(String createuserId){
		this.createuserId = createuserId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public List<String> getFamilyNameEMessageList(){
		return familyNameEMessageList;
	}
	public void setFamilyNameEMessageList(List<String>familyNameEMessageList){
		this.familyNameEMessageList = familyNameEMessageList;
	}

	public List<String> getFirstNameEMessageList(){
		return firstNameEMessageList;
	}
	public void setFirstNameEMessageList(List<String>firstNameEMessageList){
		this.firstNameEMessageList = firstNameEMessageList;
	}
	public List<String> getFamilyNameKanaEMessageList(){
		return familyNameKanaEMessageList;
	}
	public void setFamilyNameKanaEMessageList(List<String>familyNameKanaEMessageList){
		this.familyNameKanaEMessageList = familyNameKanaEMessageList;
	}
	public List<String> getFirstNameKanaEMessageList(){
		return firstNameKanaEMessageList;
	}
	public void setFirstNameKanaEMessageList(List<String>firstNameKanaEMessageList){
		this.firstNameKanaEMessageList = firstNameKanaEMessageList;
	}
	public List<String> getEmailEMessageList(){
		return emailEMessageList;
	}
	public void setEmailEMessageList(List<String>emailEMessageList){
		this.emailEMessageList = emailEMessageList;
	}
	public List<String> getCreateuserIdEMessageList(){
		return createuserIdEMessageList;
	}
	public void setCreateuserIdEMessageList(List<String>createuserIdEMessageList){
		this.createuserIdEMessageList = createuserIdEMessageList;
	}
	public List<String> getPasswordEMessageList(){
		return passwordEMessageList;
	}
	public void setPasswordEMessageList(List<String>passwordEMessageList){
		this.passwordEMessageList = passwordEMessageList;
	}



	public List<String> getSexList(){
		return sexList;
	}
	public void setSexList(List<String>sexList){
		this.sexList = sexList;
	}

	public List<ProductInfoDTO> getProductInfoDtoList(){
		return productInfoDtoList;
	}
	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList){
		this.productInfoDtoList = productInfoDtoList;
	}

}
