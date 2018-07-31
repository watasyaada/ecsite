<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/login_style.css">
<link rel="stylesheet" href="./css/botton_style.css">


<title>ログイン</title>

</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<div id="ordinal">
<div id="box-narrow">


<div class="formbox">


<h1>ログイン画面</h1>
<s:form action="LoginAction">

    <table class="table-form">
    <tr>
    		<th scope="row"><s:label value="ログインID"/></th>
    	<s:if test="#session.savedLoginId==true">
    		<td><s:textfield name="loginId" class="txt" placeholder="ログインID" value='%{#session.loginId}' autocomplete="off"/></td>
    	</s:if>
    	<s:else>
    		<td><s:textfield name="loginId" class="txt" placeholder="ログインID" autocomplete="off"/></td>
    	</s:else>
    	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
        	<s:iterator value="#session.loginIdErrorMessageList"><td class="error-form"><s:property /></td></s:iterator>
    	</s:if>
    </tr>
    <tr>
    		<th scope="row"><s:label value="パスワード"/></th>
    		<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off"/></td>
    	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
    		<s:iterator value="#session.passwordErrorMessageList"><td class="error-form"><s:property /></td></s:iterator>
    	</s:if>
    	<s:if test="#session.passwordErrorMessageList.isEmpty()">
    	<s:if test="!#session.passwordIncorrectMessage.isEmpty()">
    		<td class="error-form"><s:property value="#session.passwordIncorrectMessage"/></td>
    	</s:if>
    	</s:if>
    </tr>
    </table>
    <s:if test="#session.savedLoginId==true">
    	<label for="checkbox" class="label">
    	<s:checkbox name="savedLoginId" checked="checked" id="checkbox"/>ログインID保存
    	</label>
    </s:if>
    <s:else>
    	<label for="checkbox" class="label">
    	<s:checkbox name="savedLoginId" id="checkbox"/>ログインID保存
    	</label>
    </s:else>
    <br>
    <br>



    	<div class="submit_btn_box">
	<div class="button_base b05_3d_roll">
	    <s:submit value="ログイン" class="submit" />
        <s:submit value="ログイン" class="submit" />
    </div>
	</div>


</s:form>

<div class="text-link">
	ユーザー登録がお済みでない方は<br>
	<a href='<s:url action="CreateUserAction"/>'>新規ユーザー登録</a><br><br>
	パスワードの変更は<br>
	<a href='<s:url action="ResetPasswordAction"/>'>パスワード再設定</a><br><br>
</div>


</div>


</div>
</div>
</div>
<s:include value="footer.jsp"/>

</body>
</html>