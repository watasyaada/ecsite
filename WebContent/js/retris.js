var largementflg=false;
var startflg=false;
var rpgflg=false;
var actflg=false;
var puzflg=false;
var rankflg=false;
var rankkey=0;


function show(){
	$("h1").fadeOut(0);
	$("h1").animate({"top":"+=0px"},{'duration':100});
	$("h1").fadeIn(0);
	$("h1").animate({"top":"+=0px"},{'duration':1000});
};
function flash(){
	$(".flash").fadeOut(0);
	$(".flash").animate({"top":"+=0px"},{'duration':100});
	$(".flash").fadeIn(0);
	$(".flash").animate({"top":"+=0px"},{'duration':1000});
};
flashed= setInterval(flash,1100);

$(function(){
	$(".startminibox").click(function(){
		if(!largementflg){
			$(".main").fadeOut(500);
			$(".mainsecond").fadeIn(500);
			$(".keytop").fadeIn(500);
			$(".keybottom").fadeIn(500);
			$(".keyleft").fadeIn(500);
			$(".keyright").fadeIn(500);
			$(".Abutton").fadeIn(500);
			$(".Bbutton").fadeIn(500);
			largementflg=true;
			shows = setInterval(show,1100);
			clearInterval(flashed);
		};
	});

	$(".Abutton").click(function(){
		if(!startflg){
			clearInterval(shows);
			$(".startbox").fadeOut(0);
			$(".battlebox").fadeIn(0);
			$(".rpgrankbox").fadeIn(0);
			$(".presstartbox").fadeOut(0);
			startflg=true;
		}else if(startflg){
			if(rankkey==0){
				$(".actnamebox").fadeOut(0);
				$(".puznamebox").fadeOut(0);
				$(".rpgnamebox").fadeIn(0);
				$(".rpgkeybottom").fadeIn(0);
				$(".rpgafterAbutton").fadeIn(0);
				rpgflg=true;
			}else if(rankkey==1){
				$(".rpgnamebox").fadeOut(0);
				$(".puznamebox").fadeOut(0);
				$(".actnamebox").fadeIn(0);
				$(".actkeybottom").fadeIn(0);
				$(".actafterAbutton").fadeIn(0);
				actflg=true;
			}else if(rankkey==2){
				$(".actnamebox").fadeOut(0);
				$(".rpgnamebox").fadeOut(0);
				$(".puznamebox").fadeIn(0);
				$(".puzkeybottom").fadeIn(0);
				$(".puzafterAbutton").fadeIn(0);
				puzflg=true;
			};
			rankkey=0;
			rankflg=true;
			$(".secondselectbox").fadeIn(0);
			$(".Abutton").fadeOut(0);

			$(".keybottomafter").fadeIn(0);
			$(".keybottom").fadeOut(0);
			$(".key").css({position:"absolute",left:"270px",top:"225px"});
			$(".rankfirstbox").animate({opacity:'0.5'},200);
		};
	});

	$(".rpgafterAbutton").click(function(){
		if(rankkey==0 && rpgflg==true){
			document.getElementById("rpgrankform").productId[0].checked = true;
		}else if(rankkey==1 && rpgflg==true){
			document.getElementById("rpgrankform").productId[1].checked = true;
		}else if(rankkey==2 && rpgflg==true){
			document.getElementById("rpgrankform").productId[2].checked = true;
		};
	});

	$(".actafterAbutton").click(function(){
		if(rankkey==0 && actflg==true){
			document.getElementById("actrankform").productId[0].checked = true;
		}else if(rankkey==1 && actflg==true){
			document.getElementById("actrankform").productId[1].checked = true;
		}else if(rankkey==2 && actflg==true){
			document.getElementById("actrankform").productId[2].checked = true;
		};
	});

	$(".puzafterAbutton").click(function(){
		if(rankkey==0 && puzflg==true){
			document.getElementById("puzrankform").productId[0].checked = true;
		}else if(rankkey==1 && puzflg==true){
			document.getElementById("puzrankform").productId[1].checked = true;
		}else if(rankkey==2 && puzflg==true){
			document.getElementById("puzrankform").productId[2].checked = true;
		};
	});

	$(".Bbutton").click(function(){
		if(rankflg){
			rankflg=false;
			rpgflg=false;
			actflg=false;
			puzflg=false;
			rankkey=0;
			$(".secondselectbox").fadeOut(0);
			$(".Abutton").fadeIn(0);
			$(".rpgafterAbutton").fadeOut(0);
			$(".actafterAbutton").fadeOut(0);
			$(".puzafterAbutton").fadeOut(0);
			$(".rpgrankbox").fadeIn(0);
			$(".actrankbox").fadeOut(0);
			$(".puzrankbox").fadeOut(0);
			$(".key").css({position:"absolute",left:"40px",top:"225px"});
			$(".rankfirstbox").animate({opacity:'1'},200);
			$(".ranksecondbox").animate({opacity:'1'},200);
			$(".rankthirdbox").animate({opacity:'1'},200);
			$(".keybottomafter").fadeOut(0);
			$(".keybottom").fadeIn(0);
			$(".rpgkeybottom").fadeOut(0);
			$(".actkeybottom").fadeOut(0);
			$(".puzkeybottom").fadeOut(0);

		}else if(!rankflg && startflg){
			$(".startbox").fadeIn(0);
			$(".battlebox").fadeOut(0);
			$(".key").css({position:"absolute",left:"40px",top:"225px"});
			startflg=false;
			rankkey=0;
			$(".rpgrankbox").fadeOut(0);
			$(".actrankbox").fadeOut(0);
			$(".puzrankbox").fadeOut(0);
			$(".presstartbox").fadeIn(0);
			largementflg=false;
			shows = setInterval(show,1100);



		}else if(!startflg){

			$(".main").fadeIn(500);
			$(".mainsecond").fadeOut(500);
			$(".keytop").fadeOut(500);
			$(".keybottom").fadeOut(500);
			$(".keyleft").fadeOut(500);
			$(".keyright").fadeOut(500);
			$(".Abutton").fadeOut(500);
			$(".Bbutton").fadeOut(500);
			largementflg=false;
			clearInterval(shows);
			flashed= setInterval(flash,1100);
		};
	});

	$(".keytop").click(function(){
		if(!startflg){

		}else if(rankkey>0){
			$(".key").css({"top":"-=40px"});
			rankkey--;
			if(rankflg && rankkey==0){
				$(".rankfirstbox").animate({opacity:'0.5'},200);
				$(".ranksecondbox").animate({opacity:'1'},200);
				$(".rankthirdbox").animate({opacity:'1'},200);
			}else if(rankflg && rankkey==1){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'0.5'},200);
				$(".rankthirdbox").animate({opacity:'1'},200);
			}else if(rankkey==0){
				$(".actrankbox").fadeOut(0);
				$(".puzrankbox").fadeOut(0);
				$(".rpgrankbox").fadeIn(0);
			}else if(rankkey==1){
				$(".puzrankbox").fadeOut(0);
				$(".rpgrankbox").fadeOut(0);
				$(".actrankbox").fadeIn(0);
			};
		};
	});
	$(".keybottom").click(function(){
		if(!startflg){

		}else if(rankkey<2){
			$(".key").css({"top":"+=40px"});
		rankkey++;
			if(rankflg && rankkey==1){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'0.5'},200);
				$(".rankthirdbox").animate({opacity:'1'},200);
			}else if(rankflg && rankkey==2){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'1'},200);
				$(".rankthirdbox").animate({opacity:'0.5'},200);
			}else if(rankkey==1){
				$(".puzrankbox").fadeOut(0);
				$(".rpgrankbox").fadeOut(0);
				$(".actrankbox").fadeIn(0);
			}else if(rankkey==2){
				$(".rpgrankbox").fadeOut(0);
				$(".actrankbox").fadeOut(0);
				$(".puzrankbox").fadeIn(0);
			};
		};
	});
	$(".keybottomone").click(function(){
		if(rankkey<2){
			$(".key").css({"top":"+=40px"});
		rankkey++;
			if(rankflg && rankkey==1){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'0.5'},200);
				$(".rankthirdbox").animate({opacity:'1'},200);
			}else if(rankflg && rankkey==2){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'1'},200);
				$(".rankthirdbox").animate({opacity:'0.5'},200);
			};
		};
	});
	$(".keybottomtwo").click(function(){
		if(rankkey<1){
			$(".key").css({"top":"+=40px"});
		rankkey++;
			if(rankflg && rankkey==1){
				$(".rankfirstbox").animate({opacity:'1'},200);
				$(".ranksecondbox").animate({opacity:'0.5'},200);
				$(".rankthirdbox").animate({opacity:'1'},200);
			};
		};
	});
});


