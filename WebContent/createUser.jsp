<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/createUser_style.css">

<title>ユーザー情報入力画面</title>


</head>
<body>

<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">

	<div class="title">新規ユーザー登録</div>

	<br><br>
	<div class="subtext">情報を入力してください</div>
	<br>
	<s:form action ="CreateUserConfirmAction">
		<table>
			<tr>
				<th>姓<br></th>
				<td>:</td>
				<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓"/><br></td>
				<s:if test="!#session.familyNameEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.familyNameEMessageList">
							<s:property/><br>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>名<br></th>
				<td>:</td>
				<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名"/><br></td>
				<s:if test="!#session.firstNameEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.firstNameEMessageList">
							<s:property/><br>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>姓ふりがな<br></th>
				<td>:</td>
				<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな"/><br></td>
				<s:if test="!#session.familyNameKanaEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.familyNameKanaEMessageList">
							<div class="little_text_size">
								<s:property/><br>
							</div>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>名ふりがな<br></th>
				<td>:</td>
				<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな"/><br></td>
				<s:if test="!#session.firstNameKanaEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.firstNameKanaEMessageList">
							<div class="little_text_size">
								<s:property/><br>
							</div>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>性別<br></th>
				<td>:</td>
				<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別"/><br></td>
				<td></td>
			</tr>
			<tr>
				<th>メールアドレス<br></th>
				<td>:</td>
				<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス"/><br></td>
				<s:if test="!#session.emailEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.emailEMessageList">
							<div class="little_text_size">
								<s:property/><br>
							</div>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>ログインＩＤ<br></th>
				<td>:</td>
				<td><s:textfield name="createuserId" value="%{#session.createuserId}" label="ログインID" placeholder="ログインID"/><br></td>
				<s:if test="!#session.createuserIdEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.createuserIdEMessageList">
							<s:property/><br>
						</s:iterator>
					</td>
				</s:if>
			</tr>
			<tr>
				<th>パスワード<br></th>
				<td>:</td>
				<td><s:password name="password" value="%{#session.password}" label="パスワード" placeholder="パスワード"/><br></td>
				<s:if test="!#session.passwordEMessageList.isEmpty()">
					<td class="errormessage">
						<s:iterator value="#session.passwordEMessageList">
							<div class="little_text_size">
								<s:property/><br>
							</div>
						</s:iterator>
					</td>
				</s:if>
			</tr>
		</table>

    <div  class="submit_btn_box">
<div class="button_base b05_3d_roll">
		<s:submit value="確認画面へ" class="submit"/>
		<s:submit value="確認画面へ" class="submit"/>
		</div>
		</div>
	</s:form>
	<div class="whitesubmitbox"></div>



</div>
</div>
</div>
	<s:include value="footer.jsp"/>

</body>
</html>