<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/createDestination_style.css">


<title>宛先情報入力</title>
</head>

<body>

<jsp:include page="header.jsp" />

<div id="contents">
<div id="ordinal">
<div id="box-narrow">

<div class="formbox">

<br>
<div class="title">宛先情報入力画面</div>
<br>


<s:form action="CreateDestinationConfirmAction">

<div class="box1">

<table class="vertical-list-table">
	<tr>
		<th scope="row"><s:label value="お名前"/></th>
	</tr>

	<tr>
		<th scope="row"><s:label value="姓:"/></th>
		<td><s:textfield name="familyName" value="%{familyName}" class="txt" /></td>
		<td>
			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="名:"/></th>
		<td><s:textfield name="firstName" value="%{firstName}" class="txt" /></td>
		<td>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="姓ふりがな:"/></th>
		<td><s:textfield name="familyNameKana" value="%{familyNameKana}" class="txt" /></td>
		<td>
			<s:if test="!#session.famimyNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.famimyNameKanaErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="名ふりがな:"/></th>
		<td><s:textfield name="firstNameKana" value="%{firstNameKana}" class="txt" /></td>
		<td>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="性別"/></th>
		<td><s:radio name="sex" list="sexList" value="defaultSexValue" label="性別" placeholder="性別"/></td>
	</tr>

	<tr>
		<th scope="row"><s:label value="住所"/></th>
		<td><s:textfield name="userAddress" value="%{userAddress}" class="txt" /></td>
		<td>
			<s:if test="!#session.userAddressErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.userAddressErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="電話番号"/></th>
		<td><s:textfield name="telNumber" value="%{telNumber}" class="txt" /></td>
		<td>
			<s:if test="!#session.telNumberErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.telNumberErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>

	<tr>
		<th scope="row"><s:label value="メールアドレス"/></th>
		<td><s:textfield name="email" value="%{email}" class="txt" /></td>
		<td>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
					</div>
				</div>
			</s:if>
		</td>
	</tr>
</table>
</div>


<div class="submit_btn_box">
<div class="button_base b05_3d_roll">
<s:submit value="送信" class="submit" />
<s:submit value="送信" class="submit" />
</div>
</div>




</s:form>

<s:form action="SettlementConfirmAction">
<div class="submit_btn_box">
<div class="button_base b05_3d_roll">
<s:submit value="戻る" class="submit" />
<s:submit value="戻る" class="submit" />

<s:iterator value="#session.cartInfoDtoList" status="rs">
	<s:hidden name="productId"/>
	<s:hidden name="productName"/>
	<s:hidden name="productNameKana"/>
	<s:hidden name="imageFilePath"/>
	<s:hidden name="imageFileName"/>
	<s:hidden name="price"/>
	<s:hidden name="releaseCompany"/>
	<s:hidden name="releaseDate"/>
	<s:hidden name="productCount"/>
	<s:hidden name="subtotal"/>
	</s:iterator>

</div>
</div>
</s:form>

<div id="clear"></div>


</div>

</div>
</div>
</div>

<s:include value="footer.jsp"/>
</body>
</html>