<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset=UTF-8>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/updateProductConfirm_style.css">


<title>商品更新画面</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="contents">
<div id="admin">
<div id="box-wide">


<h1>商品更新画面</h1>
<div class="border_box">
<s:form action="UpdateProductCompleteAction">
<div id="parent">
<div id="child_left">
<table>
<colgroup>
        <col style='width:100px;'>
        <col style='width:450px;'>
    </colgroup>
	<tr><th>商品ID　　　</th><td><s:property value="#session.updateproductId"/></td></tr>
	<tr><th>商品名　　　</th><td style="word-break: break-all;"><s:property value="#session.updateproductName"/></td></tr>
	<tr><th>ふりがな　　</th><td style="word-break: break-all;"><s:property value="#session.updateproductNameKana"/></td></tr>
	<tr><th>値段　　　　</th><td><s:property value="#session.updateprice"/></td></tr>
	<tr><th>カテゴリ　　</th>
	<td>	<s:if test="#session.updatecategoryId==2"><s:property value="#session.mCategoryDtoList.get(1).getCategoryName()"/></s:if>
			<s:if test="#session.updatecategoryId==3"><s:property value="#session.mCategoryDtoList.get(2).getCategoryName()"/></s:if>
			<s:if test="#session.updatecategoryId==4"><s:property value="#session.mCategoryDtoList.get(3).getCategoryName()"/></s:if>
	</td></tr> <!-- "#session.updatecategoryId" -->
	<tr><th>発売会社　　</th><td style="word-break: break-all;"><s:property value="#session.updatereleaseCompany"/></td></tr>
	<tr><th>発売日　　　</th><td><s:property value="#session.updatereleaseDate"/></td></tr>
	<tr><th>商品詳細　　</th><td style="word-break: break-all;"><s:property value="#session.updateproductDescription"/></td></tr>
</table>
</div>
<div id="child_right">
	<img src='<s:property value="#session.image_file_path"/>/<s:property value="#session.image_file_name"/>'/>
</div>
</div>
<div class="submit_btn">
<div class="panel lime">
	<button>COMPLETE</button>
</div>
</div>
</s:form>

</div>
</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>