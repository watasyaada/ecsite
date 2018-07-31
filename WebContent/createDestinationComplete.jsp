<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/createDestinationComplete_style.css">



<meta http-equiv="refresh" content="3;URL='SettlementConfirmAction'"/>


<title>宛先情報完了</title>
</head>

<body>

<jsp:include page="header.jsp" />

<div id="contents">
<div id="ordinal">
<div id="box-narrow">

<div class="title">宛先情報の登録が完了しました</div>
	<br><br><br>
	<div class="success">3秒後に決算確認画面に戻ります</div>
	<br><br><br><br>



</div>
</div>
</div>

<s:include value="footer.jsp"/>
</body>
</html>