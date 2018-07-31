<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/resetPasswordConfirm_style.css">


<title>パスワード変更確認</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div id="contents">
<div id="ordinal">
<div id="box-narrow">


<h1>パスワード変更確認画面</h1>

<!-- パスワード変更確認表示！！！ -->
<div class="confirm">
<s:form action="ResetPasswordCompleteAction">
<table>
	<tr >
		<th>ログインID:</th>
		<td><s:property value="#session.resetLoginId"/></td>
	</tr>
	<tr >
		<th>新しいパスワード:</th>
		<td><s:property value="#session.concealedPassword"/></td>
	</tr>
	</table>


	<div class="submit_btn_box">
	<div class="button_base b05_3d_roll">
	<s:submit value="完了" class="submit" thema="simple"/>
	<s:submit value="完了" class="submit" thema="simple"/>
	</div>
	</div>
</s:form>
<s:form action="ResetPasswordAction">
<div class="submit_btn_box">


<div class="button_base b05_3d_roll">
<s:submit value="訂正" class="submit"  thema="simple"/>
<s:submit value="訂正" class="submit"  thema="simple"/>
</div>


</div>
</s:form>

<div class="clear"></div>

</div>
</div>
</div>
</div>


<s:include value="footer.jsp"/>
</body>
</html>