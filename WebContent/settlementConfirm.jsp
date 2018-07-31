<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/botton_style.css">
	<link rel="stylesheet" href="./css/settlementConfirm_style.css">

	<title>決済確認</title>

</head>
<body>
	<jsp:include page="header.jsp" />
<div id="contents">
<div id="ordinal">
<div id="box-narrow">
	<div class="title_box">
		<h1>決済確認画面</h1>
			送り先情報を選択してください
	</div>
		<s:form id="form" action="SettlementCompleteAction" >
		<s:iterator value="#session.destinationInfoDtoList" status="st">
		<div class="address_box">
			<s:if test="#st.index == 0">
				<input type="radio" name="id" checked="checked" value="<s:property value='#st.index'/>"/>
			</s:if>
			<s:else>
				<input type="radio" name="id" value="<s:property value='#st.index'/>"/>
			</s:else>
				<span>お届け先住所</span>
			<table class="address_table">
					<tr>
						<th><s:label value="名前"/></th>
						<td><s:property value="familyName"/><span>　</span><s:property value="firstName"/><br></td>
					</tr>
					<tr>
						<th><s:label value="ふりがな"/></th>
						<td><s:property value="familyNameKana" /><span>　</span><s:property value="firstNameKana" /></td>
					</tr>
					<tr>
						<th><s:label value="住所"/></th>
						<td><s:property value="userAddress" /></td>
					</tr>
					<tr>
						<th><s:label value="電話番号"/></th>
						<td><s:property value="telNumber"/></td>
					</tr>
					<tr>
						<th><s:label value="メールアドレス"/></th>
						<td><s:property value="email"/></td>
					</tr>
			</table>
		</div>
		</s:iterator>
            <s:if test="#session.destinationInfoDtoList.size()>0">
			<div class="submit_btn_box">

					<div class="button_base b05_3d_roll">
						<s:submit value="決済" class="submit"/>
						<s:submit value="決済" class="submit"/>
					</div>
			</div>
			</s:if>
		</s:form>


        <s:if test="#session.destinationInfoDtoList.size()>0">
        		<div class="submit_btn_box">
			<div class="button_base b05_3d_roll">
				<s:form action="CreateDestinationAction">
					<s:submit value="新規登録" class="submit" />
					<s:submit value="新規登録" class="submit" />
				</s:form>
			</div>
		</div>
        </s:if>
        <s:else>
		<div class="submit_btn_box2">
			<div class="button_base b05_3d_roll">
				<s:form action="CreateDestinationAction">
					<s:submit value="新規登録" class="submit" />
					<s:submit value="新規登録" class="submit" />
				</s:form>
			</div>
		</div>
        </s:else>
		<div class="clear"></div>


</div>
</div>
</div>
<s:include value="footer.jsp"/>
</body>
</html>