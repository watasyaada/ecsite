<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/index_style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- <meta http-equiv="refresh" content="0;URL='HomeAction'"/> -->
<title>retris</title>
<style>



</style>
</head>
<body>



	<script type="text/javascript" src="./js/indexanimation.js">
	</script>

	<div class="whiteheader">
	</div>

	<s:form name="indexform">
	</s:form>



	<div class="retrisbox">

		<img src="./images/retrislogo.jpg" class="logo"/>

		<div class="firstbox">
			<img src="./images/blocks/retrissecondonlyone.jpg" class="threeline"/>
			<img src="./images/blocks/retrissecondonlytwo.jpg" class="firstboxtwo"/>
		</div>

		<div class="secondbox">
			<img src="./images/blocks/retrisseventhonly.jpg" class="twoline"/>
			<img src="./images/blocks/retrisseventhonly.jpg" class="secondboxtwo"/>
		</div>

		<div class="thirdbox">
			<img src="./images/blocks/retrissixthonlyone.jpg" class="threeline"/>
			<img src="./images/blocks/retrissixthonlytwo.jpg" class="thirdboxtwo"/>
		</div>

		<div class="fourthbox">
			<img src="./images/blocks/retrissixthonlyone.jpg" class="threeline"/>
			<img src="./images/blocks/retrissixthonlytwo.jpg" class="fourthboxtwo"/>
		</div>


		<div class="fifthbox">
			<img src="./images/blocks/retristhirdonlyone.jpg" class="threeline"/>
			<img src="./images/blocks/retristhirdonlytwo.jpg" class="fifthboxtwo"/>
		</div>

		<div class="sixthbox">
			<img src="./images/blocks/retrissecondonlyone.jpg" class="threeline"/>
			<img src="./images/blocks/retrissecondonlytwo.jpg" class="sixthboxtwo"/>
		</div>

		<div class="seventhbox">
			<img src="./images/blocks/retrisfirstonly.jpg" class="line"/>
		</div>

		<div class="scorepoint">
			1000
		</div>




	</div>

	<div class="nextbox">
			<img src="./images/blocks/retrisseventh.jpg" class="nextfirstbox"/>
			<img src="./images/blocks/retrissixth.jpg" class="nextsecondbox"/>
		<!--  ワンテンポおく-->
			<img src="./images/blocks/retristhird.jpg" class="nextthirdbox"/>
			<img src="./images/blocks/retrissecond.jpg" class="nextfourthbox"/>
			<img src="./images/blocks/retrisfirst.jpg" class="nextfifthbox"/>
	</div>

	<div class="scorebox">
		0
	</div>


	<div class="skipbox">
		press here to skip<br>
		<a href ='<s:url action="HomeAction"/>'>
			<img src ="./images/skip.jpg" class="skip"/>
		</a>
	</div>



<div id="footer">
      <s:include value="footer.jsp"/>
</div>
</body>
</html>