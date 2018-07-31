<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset=UTF-8>
<script>

</script>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/admin_style.css">

<title>管理者画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="contents">
<div id="admin">
<div id="box-wide">


	<div id="text-link">
	<h3>既存商品一覧</h3>
	<s:form action="AddProductAction">		 <!-- 商品追加ボタン -->
	<div class="panel lime">
	<button>ADD</button>
	</div>
	</s:form>
	</div>
	<!-- 商品編集一覧表示させる 編集ボタンと削除ボタン-->


	<s:iterator value="#session.productInfoDtoList">

	<div class="table_box">

	<table class="vertical-list-table">


	<tr>
		<td class="image_column">
			<img src='<s:property value="%{imageFilePath}"/>/<s:property value="%{imageFileName}"/>'width="200"height="150"/>
		</td>
		<td class="description_column" style="word-break: break-all;">
			<div><span>商品ID　　 </span><s:property value="productId"/></div>
			<div><span>商品名　　 </span><s:property value="productName"/></div>
			<div><span>ふりがな　 </span><s:property value="productNameKana"/></div>
			<div><span>値段　　　 </span><s:property value="price"/><span>円</span></div>

			<div><span>カテゴリ　 </span>

			<s:if test="categoryId==2"><s:property value="#session.mCategoryDtoList.get(1).getCategoryName()"/></s:if>
			<s:if test="categoryId==3"><s:property value="#session.mCategoryDtoList.get(2).getCategoryName()"/></s:if>
			<s:if test="categoryId==4"><s:property value="#session.mCategoryDtoList.get(3).getCategoryName()"/></s:if>

			</div>

			<div><span>発売会社　 </span><s:property value="releaseCompany"/></div>
			<div><span>発売日　　 </span><s:property value="releaseDate"/></div>
			<div><span>商品詳細　 </span><s:property value="productDescription"/></div>
		</td>
		<td class="submit_btn_column">
			<s:form action="UpdateProductAction"> <!-- 更新ボタン -->
			<s:hidden name="imageFilePath" value= "%{imageFilePath}"/>
			<s:hidden name="imageFileName" value= "%{imageFileName}"/>
			<s:hidden name="productId" value= "%{productId}"/>
			<s:hidden name="productName" value= "%{productName}"/>
			<s:hidden name="productNameKana" value= "%{productNameKana}"/>
			<s:hidden name="productDescription" value= "%{productDescription}"/>
			<s:hidden name="categoryId" value= "%{categoryId}"/>
			<s:hidden name="price" value= "%{price}"/>
			<s:hidden name="releaseDate" value="%{releaseDate}"/>
			<s:hidden name="releaseCompany" value="%{releaseCompany}"/>
			<s:hidden name="updateDate" value="%{updateDate}"/>
			<div class="panel lime">
			<button>UPDATE</button>
			</div>
			</s:form><br>
			<s:form action="DeleteProductAction"><!-- 削除ボタン -->
			<s:hidden name="productId" value= "%{productId}"/>
			<div class="panel lime">
			<button onclick='return confirm("削除してもよろしいですか？")'>DELETE</button>
			</div>
			</s:form>
		</td>
	</tr>

</table>
</div>
</s:iterator>




</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>