<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/cart_style.css">


<title>cart</title>

</head>
<body>
<header>
	<s:include value="header.jsp"></s:include>
</header>
<div id="contents">
<div id="ordinal">
<div id="box-wide">
<div id="cart-top">
<h1>カート内容</h1>
</div>


<s:if test="#session.checkListErrorMessageList!=null && #session.cartInfoDtoList.size()>0">
	<div class="Cerror">
		<div class="Cerror-message">
			<s:iterator value="#session.checkListErrorMessageList">
				<span><s:property /></span>
			</s:iterator>
		</div>
	</div>
</s:if>

<div class="cart">

<s:if test="#session.cartInfoDtoList.size()>0">
<s:form id="cartForm" action="SettlementConfirmAction">
<div id="cart-left">
<s:property value="priceOver"/>
<table border="1" class="cartTable">
	<thead>
	<tr>
		<th><input type="checkbox" id="delete" class="checkAll"></th>
		<th><s:label value="商品画像"/></th>
		<th><s:label value="商品詳細"/></th>
		<th><s:label value="単価"/></th>
		<th><s:label value="合計金額"/></th>
		<th><s:label value="購入個数"/></th>


	</tr>
	</thead>
	<tbody>
	<s:iterator value="#session.cartInfoDtoList" status="rs">
	<tr class="item">
		<td style="word-break: break-all;"><span class="cartCheck"><s:checkbox name="deleteList" value="false" fieldValue="%{productId}" class="delete"/></span></td>
		<td style="word-break: break-all;"><img src="<s:property value="%{imageFilePath}"/>/<s:property value="%{imageFileName}"/>" width="50px" height="50px"></td>
		<td id="cartItem" style="word-break: break-all;">
		<ul>
			<li><span>商品名 &nbsp;&nbsp;&nbsp;&nbsp;</span><s:property value="productName"/></li>
			<li>　</li>
			<li><span>ふりがな &nbsp;&nbsp;</span><s:property value="productNameKana"/></li>
			<li><span>発売会社 &nbsp;&nbsp;</span><s:property value="releaseCompany"/></li>
			<li><span>発売日 &nbsp;&nbsp;&nbsp;&nbsp;</span><s:property value="releaseDate"/></li>
		</ul>
	</td>

		<td><span><s:property value="price" /></span>円</td>
		<td><span><s:property value="subtotal"/></span>円</td>
		<td><span><s:property value="productCount" /></span></td>

	</tr>
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




	</tbody>
	</table>


</div>
	<div id="cart-right">
	<table class="cartTable">
		<tr><th><s:label value="カート合計金額"/></th></tr>
		<tr id="leftP"><td><span><s:property value="#session.totalPrice"/></span>円</td></tr>
	</table>
		<div id="Cbtn">
			<s:if test="(session.loginId)!=null">
			<div class="button_base b05_3d_roll">
				<input type="submit" value="ご購入手続き" class="submit">
				<input type="submit" value="ご購入手続き" class="submit">
			</div>
			</s:if>
			<s:else>

			<div class="button_base b05_3d_roll">
				<input type="button" value="ご購入手続き" onclick="loginSubmit();" class="submit">
				<input type="button" value="ご購入手続き" onclick="loginSubmit();" class="submit">
		    </div>

			</s:else>
			<div>
			<div class="button_base b05_3d_roll">
				<input type="submit" value="削除" onclick="this.form.action='DeleteCartAction';" class="submit">
				<input type="submit" value="削除" onclick="this.form.action='DeleteCartAction';" class="submit">
		    </div>
			</div>
		</div>
	</div>
</s:form>
</s:if>
<s:else>
<div id=Cp>
	<p>カート情報はありません</p>
</div>
</s:else>
</div>

</div>
</div>
</div>
<footer>
	<s:include value="footer.jsp"></s:include>
</footer>

<script type="text/javascript">
	//tableの高さを合わせる
	$(function(){
		var h=$(".item").eq(0).height();
		console.log(h);
		$("#leftP").css("height",h + "px");

		$(".checkAll").on("change", function() {
			$('.' + this.id).prop('checked', this.checked);
		});

		//全選択・解除
		$(".delete").on("click",function(){
			console.log($("td :checked").length);
			console.log($(".cartCheck").length);
			if($("td :checked").length == $(".cartCheck").length){
				$(".checkAll").prop("checked","checked");
			}else{
				$(".checkAll").prop("checked",false);
			}
		})
	})

	//login先変更
	function loginSubmit(){
		document.getElementById('form').action="GoLoginAction";
		document.getElementById('form').submit();
	}



</script>
</body>
</html>