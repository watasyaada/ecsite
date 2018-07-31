<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
		<link rel="stylesheet" href="./css/settlementComplete_style.css">

	<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
	<title>決済完了</title>

</head>
<body>
<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">

	<div class="title_box">
		<h1>THANK YOU!</h1>
	</div>
	<div class="success">
		<h2>決済が完了しました</h2>
		3秒後にホーム画面に戻ります
	</div>



</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>