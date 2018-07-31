<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/createUserComplete_style.css">
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>ユーザー登録完了画面</title>


</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">

	<div class="title">ユーザーの登録が完了しました</div>
	<div class="whitesubmitbox"></div>
	<div class="subtext">3秒後にホーム画面に戻ります</div>
	<div class="whitesubmitbox"></div>



</div>
</div>
</div>
<s:include value="footer.jsp"/>

</body>
</html>