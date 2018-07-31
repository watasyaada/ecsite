package com.internousdev.retris.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.retris.dao.MCategoryDAO;
import com.internousdev.retris.dao.ProductInfoDAO;
import com.internousdev.retris.dto.MCategoryDTO;
import com.internousdev.retris.dto.PaginationDTO;
import com.internousdev.retris.dto.ProductInfoDTO;
import com.internousdev.retris.util.InputChecker;
import com.internousdev.retris.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchProductAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private String keywords;
	private String pageNo;
	private String pageFlg;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<String> categoryErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;
	ProductInfoDAO productInfoDAO = new ProductInfoDAO();

	public String execute() throws SQLException{
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

		InputChecker inputChecker = new InputChecker();
		if(keywords==null) {
			keywords="";
		}


		String[] keywordList = keywords.replaceAll("　", " ").split(" ");
		for(int i=0;keywordList.length-1>=i && keywordsErrorMessageList.isEmpty();i++){
			keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywordList[i], 0, 16, true, true, true, true, false, true, false);
			session.put("keywordsErrorMessageList", keywordsErrorMessageList);
		}
		categoryErrorMessageList= inputChecker.doCheck("カテゴリID", categoryId,1,1,false,false,false,true,false,false,false);
		if(categoryErrorMessageList.isEmpty()){
			int intCategoryId =Integer.parseInt(categoryId);

			if(keywordsErrorMessageList.isEmpty()) {
				//categoryIdが0or1の時、すべてのカテゴリーからキーワード検索
				if (intCategoryId == 1 || intCategoryId == 0) {
					result = SUCCESS;
					productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
				} else if(intCategoryId==2 || intCategoryId==3 || intCategoryId==4){
					//categoryIdとキーワードから検索
					result = SUCCESS;
					productInfoDtoList = productInfoDAO.getProductInfoListByKeyWords(keywords.replaceAll("　", " ").split(" "),intCategoryId);
				}else{

				}
			}
		}


		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();

		if(!(iterator.hasNext())){
			productInfoDtoList = null;
		}

		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList",mCategoryDtoList);
		}

		if(!(productInfoDtoList==null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if(pageNo==null) {
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			}else {
				paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);
			}

			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.isPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.isNextPage());
			session.put("nextPageNo",paginationDTO.getNextPageNo());
		}else{
			session.put("productInfoDtoList",null);
		}
		return result;
	}

	public String getPageNo(){
		return pageNo;
	}

	public void setPageNo(String pageNo){
		this.pageNo =pageNo;
	}

	public String getPageFlg(){
		return pageFlg;
	}
	public void setPageFlg(String pageFlg){
		this.pageFlg = pageFlg;
	}

	public List<MCategoryDTO> getmCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList){
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<String> getCategoryErrorMessageList(){
		return categoryErrorMessageList;
	}
	public void setCategoryErrorMessageList(List<String> categoryErrorMessageList){
		this.categoryErrorMessageList = categoryErrorMessageList;
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

}
