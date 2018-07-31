<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/createUserConfirm_style.css">
<title>ユーザー登録確認</title>


<script>
function goCreateUserCompleteAction(){
	document.getElementById("createuserform").action="CreateUserCompleteAction";
}
function goCreateUserAction(){
	document.getElementById("createuserform").action="CreateUserAction";
}
</script>

</head>
<body>

<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">

	<div class="title">登録内容はこちらでよろしいですか？</div>

	<br><br>


	<s:form id="createuserform" name="createuserform">
		<table class="create_user_table">
			<tr>
				<th>姓</th>
				<td>:</td>
				<td><s:property value="familyName"/></td>
			</tr>
			<tr>
				<th>名</th>
				<td>:</td>
				<td><s:property value="firstName"/></td>
			</tr>
			<tr>
				<th>姓ふりがな</th>
				<td>:</td>
				<td><s:property value="familyNameKana"/></td>
			</tr>
			<tr>
				<th>名ふりがな</th>
				<td>:</td>
				<td><s:property value="firstNameKana"/></td>
			</tr>
			<tr>
				<th>性別</th>
				<td>:</td>
				<td><s:property value="sex"/></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td>:</td>
				<td><s:property value="email"/></td>
			</tr>
			<tr>
				<th>ログインID</th>
				<td>:</td>
				<td><s:property value="createuserId"/></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td>:</td>
				<td><s:property value="password"/></td>
			</tr>
		</table>
		<br><br>

		 <div class="button_base b05_3d_roll">
		<s:submit value="登録する" class="submit" onclick="goCreateUserCompleteAction();"/>
		<s:submit value="登録する" class="submit" onclick="goCreateUserCompleteAction();"/>
		</div>

		<s:hidden name="createuserId" value="%{createuserId}"/>
		<s:hidden name="password" value="%{password}"/>
		<s:hidden name="familyName" value="%{familyName}"/>
		<s:hidden name="firstName" value="%{firstName}"/>
		<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
		<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
		<s:hidden name="email" value="%{email}"/>
		<s:if test='sex.equals("男性")'>
			<s:hidden name="sex" value="0"/>
		</s:if>
		<s:else>
			<s:hidden name="sex" value="1"/>
		</s:else>

        <div class="button_base b05_3d_roll">
		<s:submit value="訂正する" class="submit" onclick="goCreateUserAction();"/>
		<s:submit value="訂正する" class="submit" onclick="goCreateUserAction();"/>
		</div>

        <div class="clear"></div>


	</s:form>
	<div class="whitesubmitbox"></div>



</div>
</div>
</div>
	<s:include value="footer.jsp"/>


</body>
</html>