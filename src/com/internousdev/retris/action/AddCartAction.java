/**
 *
 */
package com.internousdev.retris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.CartInfoDAO;
import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dao.PurchaseHistoryInfoDAO;
import com.internousdev.retris.dto.CartInfoDTO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.dto.PurchaseHistoryInfoDTO;
import com.internousdev.retris.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;

	private String categoryId;
	private String priceOver;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

	private List<PurchaseHistoryInfoDTO> RPGrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> ShotrankList = new ArrayList<PurchaseHistoryInfoDTO>();
	private List<PurchaseHistoryInfoDTO> PuzzlerankList = new ArrayList<PurchaseHistoryInfoDTO>();

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();


	private Map<String, Object> session;
	public String execute() {
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

		if(!session.get("productId").equals(productId)){
			return ERROR;
		}

		String userId = null;
		String tempUserId = null;
		session.put("checkListErrorMessageList", null);

		if(session.get("logined")==null){
			session.put("logined", 0);
		}
		//ログインまたは一時ログイン状態ではない場合
		 if (!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))) {
			 CommonUtility commonUtility = new CommonUtility();
			 //16桁の乱数を作成して一時idとしてセッションに保存
			 session.put("tempUserId", commonUtility.getRandomValue());
		}
		 //ログイン中の場合
		if(session.get("logined").equals(1)) {
			//ログインIDを、Stringに変換、userIdとして扱う
			userId = String.valueOf(session.get("loginId"));
		}
		//ログインしてないが、一時ログイン中の場合
		if (!(session.get("logined").equals(1)) && session.containsKey("tempUserId")) {
			//一時ログインID、userIdとtempUserIdとして扱う
			userId = String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}

		//空白やコロンで分割し,最初の要素をString化
		if(productCount!=null){
			productCount = String.valueOf((productCount.split(" ,",0))[0]);
		}

		CartInfoDAO cartInfoDao = new CartInfoDAO();
		//カート用DBtableに、insert
		 int i=Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		 int count=0;
		 int intproductCount = Integer.parseInt(productCount);

		 //overflow確認
		 try{
			 int totalPrice=Math.multiplyExact(price, intproductCount);
			 Math.addExact(i, totalPrice);


			//if(productCount<0){カートに入れない}else{カートに入れる}
			  if(!(intproductCount<=0 && intproductCount>5)){
					count = cartInfoDao.register(userId,tempUserId,productId,productCount,price);
					//insert成功時count>0以上
						if(count > 0) {
							session.put("createdestinationflg",false);
							result=SUCCESS;
						}
			  }


		}catch(Exception e){
			session.put("createdestinationflg",false);
			priceOver="最大購入可能価格を超えるためキャンセルされました。";
			result=SUCCESS;
			e.printStackTrace();
		}



		//insert成功時count>0以上
		if(count > 0) {
			session.put("createdestinationflg",false);
			result=SUCCESS;
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
		}
		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		cartInfoDtoList = cartInfoDao.getCartInfoDtoList(userId);
		//イテレーターObjectの作成
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
		//cartDTOListが空の場合nullにする。
		if(!(iterator.hasNext())) {
			cartInfoDtoList = null;
		}
		session.put("cartInfoDtoList", cartInfoDtoList);
		//ユーザーごとのトータルプライスを求める
		int totalPrice = Integer.parseInt(String.valueOf(cartInfoDao.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);
		return result;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * priceOverを取得します。
	 * @return priceOver
	 */
	public String getPriceOver() {
	    return priceOver;
	}
	/**
	 * priceOverを設定します。
	 * @param priceOver priceOver
	 */
	public void setPriceOver(String priceOver) {
	    this.priceOver = priceOver;
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
