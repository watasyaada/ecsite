<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/home_style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>ホーム画面</title>
<style>

</style>
</head>
<body>



	<script type="text/javascript" src="./js/retris.js">
	</script>

	<jsp:include page="header.jsp" />

	<div class="whiteheader"></div>


<!-- 色はわかりやすくするためにつけてます(後ではずす) -->



<div class="main">
		<div class="startminibox">
			<div class="startminiinner">
				<img src="./images/Game-Ranking.jpg" class="icon"/>
				<div class="presstartminibox">
					<div class="flash">--PRESS　A　to　START--</div>
				</div>
			</div>
		</div>
	</div>


	<div class="mainsecond">
		<div class="startbox">
			<div class="startinner">
				<img src="./images/Game-Ranking.jpg" class="large"/>
				<div class="presstartbox">
					<h1>--PRESS　A　to　START--</h1>
				</div>
			</div>
		</div>

			<div class="battlebox">

				<div class="rpgrankbox">
					<s:iterator value="RPGrankList" status ="No">

						<s:if test="#No.count==1">
							<div class="rankfirstbox">
							<div class="detailsbox"><s:property value="#No.count"/>位</div>
								<a href ='<s:url action="ProductDetailsAction">
									<s:param name="productId" value="%{productId}"/></s:url>'>
									<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="firstranking"/>
								</a>
							</div>
						</s:if>
						<s:elseif test="#No.count==2">
							<div class="ranksecondbox">
							<div class="detailsbox"><s:property value="#No.count"/>位</div>
								<a href ='<s:url action="ProductDetailsAction">
									<s:param name="productId" value="%{productId}"/></s:url>'>
									<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="secondranking"/>
								</a>
							</div>
						</s:elseif>
						<s:elseif test="#No.count==3">
							<div class="rankthirdbox">
							<div class="detailsbox"><s:property value="#No.count"/>位</div>
								<a href ='<s:url action="ProductDetailsAction">
									<s:param name="productId" value="%{productId}"/></s:url>'>
									<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="thirdranking"/>
								</a>
							</div>
						</s:elseif>
					</s:iterator>
				</div>

			<div class="actrankbox">
				<s:iterator value="ShotrankList" status ="No">

					<s:if test="#No.count==1">
						<div class="rankfirstbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="firstranking"/>
							</a>
						</div>
					</s:if>
					<s:elseif test="#No.count==2">
						<div class="ranksecondbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="secondranking"/>
							</a>
						</div>
					</s:elseif>
					<s:elseif test="#No.count==3">
						<div class="rankthirdbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="thirdranking"/>
							</a>
						</div>
					</s:elseif>
				</s:iterator>
			</div>

			<div class="puzrankbox">
				<s:iterator value="PuzzlerankList" status ="No">

					<s:if test="#No.count==1">
						<div class="rankfirstbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="firstranking"/>
							</a>
						</div>
					</s:if>
					<s:elseif test="#No.count==2">
						<div class="ranksecondbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="secondranking"/>
							</a>
						</div>
					</s:elseif>
					<s:elseif test="#No.count==3">
						<div class="rankthirdbox">
						<div class="detailsbox"><s:property value="#No.count"/>位</div>
							<a href ='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/></s:url>'>
								<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="thirdranking"/>
							</a>
						</div>
					</s:elseif>

				</s:iterator>


			</div>

			<div class="firstselectbox">
				<div class="keyline">
					<div class="key">▼</div>
				</div>
				<div class="genrebox">ＲＰＧ</div>
				<div class="genrebox">アクション</div>
				<div class="genrebox">パズル</div>

			</div>



			<div class="secondselectbox">

				<div class="keyline">

				</div>

				<div class="rpgnamebox">
					<s:iterator value="RPGrankList" status="No">
						<div class="namebox">
							<s:property value="#No.count"/>位　
							<s:property value="productName"/>
						</div>
					</s:iterator>
					<s:if test="RPGrankList==null || RPGrankList.isEmpty()">
						<div class="namebox">
							商品がありません
						</div>
					</s:if>
				</div>
				<div class="actnamebox">
					<s:iterator value="ShotrankList" status="No">
						<div class="namebox">
							<s:property value="#No.count"/>位　
							<s:property value="productName"/>
						</div>
					</s:iterator>
					<s:if test="ShotrankList==null || ShotrankList.isEmpty()">
						<div class="namebox">
							商品がありません
						</div>
					</s:if>
				</div>
				<div class="puznamebox">
					<s:iterator value="PuzzlerankList" status="No">
						<div class="namebox">
							<s:property value="#No.count"/>位　
							<s:property value="productName"/>
						</div>
					</s:iterator>
					<s:if test="PuzzlerankList==null || PuzzlerankList.isEmpty()">
						<div class="namebox">
							商品がありません
						</div>
					</s:if>
				</div>
			</div>
		</div>
		<div class="keytop"></div>
		<div class="keyleft"></div>
		<div class="keyright"></div>
		<div class="keybottom">
		</div>
		<div class="keybottomafter">
			<div class="rpgkeybottom">
				<s:iterator value="RPGrankList" status="No">
					<s:if test="#No.last">
						<s:if test="#No.count==3">
							<div class="keybottomone"></div>
						</s:if>
						<s:elseif test="#No.count==2">
							<div class="keybottomtwo"></div>
						</s:elseif>
						<s:else>
							<div class="keybottomthree"></div>
						</s:else>
					</s:if>
				</s:iterator>
			</div>
			<div class="actkeybottom">
				<s:iterator value="ShotrankList" status="No">
					<s:if test="#No.last">
						<s:if test="#No.count==3">
							<div class="keybottomone"></div>
						</s:if>
						<s:elseif test="#No.count==2">
							<div class="keybottomtwo"></div>
						</s:elseif>
						<s:else>
							<div class="keybottomthree"></div>
						</s:else>
					</s:if>
				</s:iterator>
			</div>
			<div class="puzkeybottom">
				<s:iterator value="PuzzlerankList" status="No">
					<s:if test="#No.last">
						<s:if test="#No.count==3">
							<div class="keybottomone"></div>
						</s:if>
						<s:elseif test="#No.count==2">
							<div class="keybottomtwo"></div>
						</s:elseif>
						<s:else>
							<div class="keybottomthree"></div>
						</s:else>
					</s:if>
				</s:iterator>
			</div>
		</div>
		<div class="Abutton"></div>
		<div class="Bbutton"></div>

		<s:form id="rpgrankform" name="form" action="ProductDetailsAction">
			<s:iterator value="RPGrankList">
				<input type="radio" name="productId" value='<s:property value="%{productId}"/>' class="radionone" checked>
			</s:iterator>
			<s:if test="RPGrankList==null || RPGrankList.isEmpty()">
			</s:if>
			<s:else>
				<s:submit class="rpgafterAbutton"/>
			</s:else>
		</s:form>
		<s:form id="actrankform" name="form" action="ProductDetailsAction">
			<s:iterator value="ShotrankList">
				<input type="radio" name="productId" value='<s:property value="%{productId}"/>' class="radionone" checked>
			</s:iterator>
			<s:if test="ShotrankList==null || ShotrankList.isEmpty()">
			</s:if>
			<s:else>
				<s:submit class="actafterAbutton"/>
			</s:else>
		</s:form>
		<s:form id="puzrankform" name="form" action="ProductDetailsAction">
			<s:iterator value="PuzzlerankList">
				<input type="radio" name="productId" value='<s:property value="%{productId}"/>' class="radionone" checked>
			</s:iterator>
			<s:if test="PuzzlerankList==null || PuzzlerankList.isEmpty()">
			</s:if>
			<s:else>
				<s:submit class="puzafterAbutton"/>
			</s:else>
		</s:form>
	</div>
	<s:include value="footer.jsp"/>
</body>
</html>