<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/resetPassword_style.css">


<title>パスワード変更</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<div id="contents">
<div id="ordinal">
<div id="box-narrow">


<h1>パスワード変更画面</h1>

<!-- パスワード変更入力フォーム表示 -->
<div class="formbox">
<s:form action="ResetPasswordConfirmAction">
	<table class="vertical-list-table">
	<tr>
		<th scope="row"><s:label value="ログインID"/></th>
		<td><s:textfield name="loginId" placeholder="ログインID" value='%{#session.resetLoginId}' class="txt"/></td>
		<td>
			<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:if>
		</td>
	</tr>
	<tr>
		<th scope="row"><s:label value="現在のパスワード"/></th>
		<td><s:password name="password" placeholder="現在のパスワード" class="txt"/></td>
		<td>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.passwordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:if>
			<s:if test="!#session.passwordIncorrectErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.passwordIncorrectErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:if>
		</td>
	</tr>
	<tr>
		<th scope="row"><s:label value="新しいパスワード"/></th>
		<td><s:password name="newPassword" placeholder="新しいパスワード" class="txt"/></td>
		<td>
			<s:if test="!#session.newPasswordErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.newPasswordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:if>
		</td>
	</tr>
	<tr>
		<th scope="row"><s:label value="新しいパスワード(再確認)"/></th>
		<td><s:password  name="reConfirmationPassword" placeholder="新しいパスワード(再確認)" class="txt"/></td>
		<td>
			<s:if test="!#session.reConfirmationNewPasswordErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.reConfirmationNewPasswordErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:if>
			<s:elseif test="!#session.newPasswordIncorrectErrorMessageList.isEmpty()">
				<div class="error">
				<div class="error-message">
				<s:iterator value="#session.newPasswordIncorrectErrorMessageList"><s:property />
				<br></s:iterator>
				</div>
				</div>
			</s:elseif>
		</td>
	</tr>
	</table>
	<div class="submit">
	<div class="button_base b05_3d_roll">
<s:submit value="パスワード再設定" class="submit"/>
<s:submit value="パスワード再設定" class="submit"/>
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