<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

<meta charset=UTF-8>
<title>商品追加画面</title>
<script src="./js/jquery-ui.min.js"></script>
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/i18n/jquery.ui.datepicker-ja.js"></script>

  <link href="./css/admin-datepicker/jquery-ui.min.css" rel="stylesheet">
  <link href="./css/admin-datepicker/jquery-ui.structure.min.css" rel="stylesheet">
  <link href="./css/admin-datepicker/jquery-ui.theme.min.css" rel="stylesheet">

<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/addProduct_style.css">

<script type="text/javascript">
$(function(){
	$('#datepicker').datepicker({

		dateFormat: 'yy-mm-dd',
		changeYear: true, //年を表示
		changeMonth: true, //月を選択
		defaultDate: new Date(2000,3,1),
		yearRange: "1980:2018",
		minDate: new Date(1980, 1 - 1,1 ),
		maxDate: '0y'
	});


	$('#file').change(function(e){
	    //ファイルオブジェクトを取得する
	    var file = e.target.files[0];
	    var reader = new FileReader();

	    //画像でない場合は処理終了
	    if(file.type.indexOf("image") < 0){
	      alert("画像ファイルを指定してください。");
	      return false;
	    }

	    //アップロードした画像を設定する
	    reader.onload = (function(file){
	      return function(e){
	        $("#image_path").attr("src", e.target.result);
	        $("#image_path").attr("title", file.name);
	      };
	    })(file);
	    reader.readAsDataURL(file);

	  });
});
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="contents">
<div id="admin">
<div id="box-wide">

	<!-- 商品追加入力フォーム表示 -->

	<h3>商品情報を入力してください</h3>
<div class="table_box">
	<s:form action="AddProductConfirmAction" method="post" enctype="multipart/form-data">

		<table class="vertical-list-table">
		<tr>
			<th scope="row"><s:label value="商品ID"/></th>
			<td >
			<s:textfield name="productId" placeholder="商品ID" class="txt"/>

			</td>
			<td class="alert"><b>※8桁まで 半角数字のみ</b></td>
		</tr>
		<tr>
		<th></th>
		<td colspan="2">

			<s:if test="!#session.productIdErrorMessageList.isEmpty()">
					<div class="error">
					<div class="error-message">
					<s:iterator value="#session.productIdErrorMessageList"><s:property />
					<br></s:iterator>
					</div>
					</div>
				</s:if>
				<s:elseif test="!#session.errorProductId.isEmpty()">
					<div class="error">
					<s:property value="#session.errorProductId"/>
					</div>
				</s:elseif>
		</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="商品名"/></th>
			<td>
			<s:textfield name="productName" placeholder="商品名" class="txt"/>

			</td>
			<td class="alert"><b>※30文字まで</b></td>
		</tr>
		<tr>
		<th></th>
			<td colspan="2">
				<s:if test="!#session.productNameErrorMessageList.isEmpty()">
					<div class="error">
					<div class="error-message">
					<s:iterator value="#session.productNameErrorMessageList"><s:property />
					<br></s:iterator>
					</div>
					</div>
				</s:if>
				<s:elseif test="!#session.errorProductName.isEmpty()">
					<div class="error">
					<s:property value="#session.errorProductName"/>
					</div>
				</s:elseif>
			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="ふりがな"/></th>
			<td>
			<s:textfield  name="productNameKana" placeholder="ふりがな" class="txt"/>

			</td>
			<td class="alert"><b>※30文字まで ひらがなと半角数字のみ</b></td>
		</tr>
		<tr>
		<th></th>
			<td colspan="2">
				<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
					<div class="error">
					<div class="error-message">
					<s:iterator value="#session.productNameKanaErrorMessageList"><s:property />
					<br></s:iterator>
					</div>
					</div>
				</s:if>
				<s:if test="!#session.errorProductNameKana.isEmpty()">
				<div class="error">
					<s:property value="#session.errorProductNameKana"/>
				</div>
				</s:if>
			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="値段"/></th>

			<td>
			<s:textfield name="price" placeholder="値段" class="txt"/><span>円</span>

			</td>
			<td class="alert"><b>※8桁まで 半角数字のみ</b></td>
		</tr>
		<tr>
		<th></th>
			<td colspan="2">
				<s:if test="!#session.priceErrorMessageList.isEmpty()">
					<div class="error">
					<div class="error-message">
					<s:iterator value="#session.priceErrorMessageList"><s:property />
					<br></s:iterator>
					</div>
					</div>
				</s:if>
			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="カテゴリー"/></th>
			<td>
				<s:select name="categoryId" list="#session.adCategoryDtoList" listValue="categoryName" listKey="categoryId" class="txt"/>
			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="発売会社"/></th>
			<td>
			<s:textfield  name="releaseCompany" placeholder="発売会社" class="txt"/>

			</td>
			<td class="alert"><b>※50文字まで</b></td>
		</tr>
		<tr>
		<th></th>
			<td colspan="2">
				<s:if test="!#session.releaseCompanyErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
						<s:iterator value="#session.releaseCompanyErrorMessageList"><s:property />
						<br></s:iterator>
						</div>
					</div>
				</s:if>
			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="発売日"/></th>
			<td>
				<input type="text" id="datepicker" name="releaseDate" placeholder="年-月-日" readonly="readonly">
			</td>
			<td>
			</td>
		</tr>
		<tr>
		<th></th>
			<td colspan="2">

				<s:if test="!#session.errorReleaseDate.isEmpty()">
				<div class="error">
				<s:property value="#session.errorReleaseDate"/>
				</div>
				</s:if>

			</td>
		</tr>
		<tr>
			<th scope="row"><s:label value="商品詳細"/></th>
			<td>
			<s:textarea cols="22" rows="4" name="productDescription" placeholder="商品詳細" class="txt"/>

			</td>
			<td class="alert"><b>※80文字まで</b></td>

		</tr>
		<tr>
		<th></th>
			<td colspan="2">
				<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
					<div class="error">
					<div class="error-message">
					<s:iterator value="#session.productDescriptionErrorMessageList"><s:property />
					<br></s:iterator>
					</div>
					</div>
				</s:if>
			</td>
		</tr>
		</table>

			<div class="file">

			<img id="image_path" src="<s:property value="image_file_path"/>"width="200"height="150"/><br>
				<input type="file"  id="file" name="userImage" accept="image/jpeg"/><br>
			<b>※画像をアップロードしてください</b>

			<s:if test="!#session.errorUserImage.isEmpty()">
				<div class="error">
				<s:property value="#session.errorUserImage"/>
				</div>
			</s:if>
			</div>


	<div class="submit_btn">
	<div class="panel lime">
	<button>ADD</button>
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