<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/botton_style.css">
<link rel="stylesheet" href="./css/productDetails_style.css">


<title>商品詳細</title>





</head>
<body>
<jsp:include page="header.jsp" />

<div id="contents">
<div id="ordinal">
<div id="box-wide">


<h1>商品詳細画面</h1>


    <s:form action="AddCartAction">
        <s:token/>

    <div class="box">
    <div  class="2column-container">

    <div class="reft">
         <img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' class="item-image-box-320" /><br>
    </div>

    <div class="right">
    <table class="vertical-list-table-mini">
        <tr valign="top">
        <td colspan="2" id="name" style="word-break: break-all;"><s:property value="%{#session.productName}"/></td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="ふりがな:" /></th>
        <td style="word-break: break-all;"><s:property value="%{#session.productNameKana}"/></td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="値段:"/></th>
        <td><s:property value="%{#session.price}"/>円</td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="購入個数:"/></th>
        <td><s:select name="productCount" list="%{#session.productCountList}"/>個</td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="発売会社:"/></th>
        <td style="word-break: break-all;"><s:property value="%{#session.releaseCompany}"/></td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="発売日:"/></th>
        <td><s:property value="%{#session.releaseDate}"/></td>
        </tr>
        <tr valign="top">
        <th scope="row"><s:label value="商品詳細:"/></th>
        <td style="word-break: break-all;"><s:property value="%{#session.productDescription}"/></td>
        </tr>
    </table>







    </div>

    <div  class="submit_btn_box">
<div class="button_base b05_3d_roll">
<s:submit  value="カートに追加" class="submit" />
<s:submit  value="カートに追加" class="submit" />
</div>
</div>

    </div>
    <s:hidden name="productId" value="%{#session.productId}"/>
    <s:hidden name="productName" value="%{#session.productName}"/>
    <s:hidden name="productNameKana" value="%{#session.productNameKana}" />
    <s:hidden name="imageFilePath" value="%{#session.imageFilePath}"/>
    <s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
    <s:hidden name="price" value="%{#session.price}"/>
    <s:hidden name="releaseCompany" value="%{#session.releaseCompany}"/>
    <s:hidden name="releaseDate" value="%{#session.releaseDate}"/>
    <s:hidden name="productDescription" value="%{#session.productDescription}"/>


    </div>





    </s:form>



    <div class="box">

    <div class="product-detail-recommend-box">

    <s:iterator value="#session.productInfoDtoList">



        <div class="recommend-box">



        <a href='<s:url action="ProductDetailsAction">
        <s:param name="productId" value="%{productId}"/>
        </s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-100"/></a><br>
        <s:property value="productName"/><br>

    </div>



    </s:iterator>

    </div>
    </div>

<div id="clear"></div>

</div>
</div>
</div>

<s:include value="footer.jsp" />
</body>
</html>