<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/mypage_style.css">

<title>マイページ</title>

</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">


<div class="mypage">
<h1>マイページ</h1>
</div>
	<div class="user_info">
	<s:form action="PurchaseHistoryAction">
	<div class="info">
	<div id="sub_title">
	<h2>ユーザー情報</h2>
	</div>
	<table class="vertical-list-table">

		<tr>
			<th scope="row"><s:label value="姓"/></th>
			<td><s:property value="#session.familyName"/></td>
		</tr>

		<tr>
			<th scope="row"><s:label value="名"/></th>
			<td><s:property value="#session.firstName"/></td>
		</tr>

		<tr>
			<th scope="row"><s:label value="姓ふりがな"/></th>
			<td><s:property value="#session.familyNameKana"/></td>
		</tr>

		<tr>
		    <th scope="row"><s:label value="名ふりがな"/></th>
		    <td><s:property value="#session.firstNameKana"/></td>
        </tr>

		<tr>
			<th scope="row"><s:label value="性別"/></th>
			<td><s:if test="#session.sex==0">男性</s:if><s:if test="#session.sex==1">女性</s:if></td>
		</tr>

		<tr>
			<th scope="row"><s:label value="メールアドレス"/></th>
			<td><s:property value="#session.email"/></td>
		</tr>




	</table>
	</div>
	<div class="submit_btn_box">
	<div class="button_base b05_3d_roll">
	<s:submit value="購入履歴" class="submit" />
    <s:submit value="購入履歴" class="submit" />
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