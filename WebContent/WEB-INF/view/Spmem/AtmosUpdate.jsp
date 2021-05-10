<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="spmem.VO.spmemVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#tabs" ).tabs();
  } );
  function regAtmos1(){
		cent1option = document.getElementById("cent1option");
		cent2option = document.getElementById("cent2option");
		cent3option = document.getElementById("cent3option");
		cent4option = document.getElementById("cent4option");
		cent5option = document.getElementById("cent5option");
		cent6option = document.getElementById("cent6option");
		cent1 = document.getElementById("cent1")
		cent2 = document.getElementById("cent2")
		cent3 = document.getElementById("cent3")
		cent4 = document.getElementById("cent4")
		cent5 = document.getElementById("cent5")
		cent6 = document.getElementById("cent6")
		$.ajax({
			url:"/SpinUrOwn/regAtmos.ma",
			type:"POST",
			data: {
				cent1option : cent1option.value,
				cent2option : cent2option.value,
				cent3option : cent3option.value,
				cent4option : cent4option.value,
				cent5option : cent5option.value,
				cent6option : cent6option.value,
				cent1 : cent1.value,
				cent2 : cent2.value,
				cent3 : cent3.value,
				cent4 : cent4.value,
				cent5 : cent5.value,
				cent6 : cent6.value
			},
			success : function(data) {
				alert("AtmostUpdate1 done!")
			}
		});//ajax end
	}
  function regAtmos2(){
		cent1option = document.getElementById("2cent1option");
		cent2option = document.getElementById("2cent2option");
		cent3option = document.getElementById("2cent3option");
		cent4option = document.getElementById("2cent4option");
		cent5option = document.getElementById("2cent5option");
		cent6option = document.getElementById("2cent6option");
		cent1 = document.getElementById("2cent1")
		cent2 = document.getElementById("2cent2")
		cent3 = document.getElementById("2cent3")
		cent4 = document.getElementById("2cent4")
		cent5 = document.getElementById("2cent5")
		cent6 = document.getElementById("2cent6")
		$.ajax({
			url:"/SpinUrOwn/regAtmos.ma",
			type:"POST",
			data: {
				cent1option : cent1option.value,
				cent2option : cent2option.value,
				cent3option : cent3option.value,
				cent4option : cent4option.value,
				cent5option : cent5option.value,
				cent6option : cent6option.value,
				cent1 : cent1.value,
				cent2 : cent2.value,
				cent3 : cent3.value,
				cent4 : cent4.value,
				cent5 : cent5.value,
				cent6 : cent6.value
			},
			success : function(data) {
				alert("AtmostUpdate2 done!")
			}
		});//ajax end
	}
  function regAtmos3(){
		cent1option = document.getElementById("3cent1option");
		cent2option = document.getElementById("3cent2option");
		cent3option = document.getElementById("3cent3option");
		cent4option = document.getElementById("3cent4option");
		cent5option = document.getElementById("3cent5option");
		cent6option = document.getElementById("3cent6option");
		cent1 = document.getElementById("3cent1")
		cent2 = document.getElementById("3cent2")
		cent3 = document.getElementById("3cent3")
		cent4 = document.getElementById("3cent4")
		cent5 = document.getElementById("3cent5")
		cent6 = document.getElementById("3cent6")
		$.ajax({
			url:"/SpinUrOwn/regAtmos.ma",
			type:"POST",
			data: {
				cent1option : cent1option.value,
				cent2option : cent2option.value,
				cent3option : cent3option.value,
				cent4option : cent4option.value,
				cent5option : cent5option.value,
				cent6option : cent6option.value,
				cent1 : cent1.value,
				cent2 : cent2.value,
				cent3 : cent3.value,
				cent4 : cent4.value,
				cent5 : cent5.value,
				cent6 : cent6.value
			},
			success : function(data) {
				alert("AtmostUpdate3 done!")
			}
		});//ajax end
	}
  </script>
</head>
<body>
<hr/>
<%spmemVO vo = (spmemVO)session.getAttribute("vo");
String Atmos = vo.getPreferAtmos().toString();%>
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Atmosphere1</a></li>
    <li><a href="#tabs-2">Atmosphere2</a></li>
    <li><a href="#tabs-3">Atmosphere3</a></li>
  </ul>
  <div id="tabs-1">
<form method="post" class="white fs-m3 fw-200"
 action="/SpinUrOwn/regAtmos.ma">
<%if(Atmos=="0"
	||Atmos.split(" ").length!=5){ %>
		<%=vo.getNickname()%>, plz show your prefer Atmos!<br/>
<%}else{ %>
		<%=vo.getNickname()%>, plz modify your prefer Atmos!<br/>
		<%} %>
		<select name="cent1option" id="cent1option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">gorgeous</option>
			<option value="2">amazing</option>
			<option value="3">nice</option>
			<option value="4">beautiful</option>
		</select> : <input type="range" min="1" max="9" name="cent1" id="cent1"> <br/>
		<select name="cent2option"id="cent2option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">honest</option>
			<option value="2">powerful</option>
			<option value="3">different</option>
			<option value="4">incredible</option>
		</select> : <input type="range" min="1" max="9" name="cent2" id="cent2"> <br/>
		<select name="cent3option" id="cent3option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">flawless</option>
			<option value="2">raw</option>
			<option value="3">curious</option>
			<option value="4">cute</option>
		</select> : <input type="range" min="1" max="9" name="cent3" id="cent3"> <br/>
		<select name="cent4option" id="cent4option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">pathetic</option>
			<option value="2">huge</option>
			<option value="3">special</option>
			<option value="4">crazy</option> 
		</select>: <input type="range" min="1" max="9" name="cent4" id="cent4"> <br/>
		<select name="cent5option" id="cent5option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">cool</option> 
			<option value="2">greatest</option> 
			<option value="3">adorable</option>
			<option value="4">unique</option>
		</select> : <input type="range" min="1" max="9" name="cent5" id="cent5"> <br/>
		<select name="cent6option" id="cent6option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">fine</option> 
			<option value="2">goosebumps</option>
			<option value="3">epic</option>
			<option value="4">funny</option>
		</select> : <input type="range" min="1" max="9" name="cent6" id="cent6"> <br/>
		<input type="button" value="submit" onclick="regAtmos1()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<input type="button" value="cancel"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		</form>
  </div>
  <div id="tabs-2">
<form method="post" class="white fs-m3 fw-200"
 action="/SpinUrOwn/regAtmos2.ma">
<%if(Atmos=="0"
	||Atmos.split(" ").length!=5){ %>
		<%=vo.getNickname()%>, plz show your prefer Atmos!<br/>
<%}else{ %>
		<%=vo.getNickname()%>, plz modify your prefer Atmos!<br/>
		<%} %>
		<select name="cent1option" id="2cent1option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">gorgeous</option>
			<option value="2">amazing</option>
			<option value="3">nice</option>
			<option value="4">beautiful</option>
		</select> : <input type="range" min="1" max="9" name="cent1" id="2cent1"> <br/>
		<select name="cent2option"id="2cent2option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">honest</option>
			<option value="2">powerful</option>
			<option value="3">different</option>
			<option value="4">incredible</option>
		</select> : <input type="range" min="1" max="9" name="cent2" id="2cent2"> <br/>
		<select name="cent3option" id="2cent3option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">flawless</option>
			<option value="2">raw</option>
			<option value="3">curious</option>
			<option value="4">cute</option>
		</select> : <input type="range" min="1" max="9" name="cent3" id="2cent3"> <br/>
		<select name="cent4option" id="2cent4option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">pathetic</option>
			<option value="2">huge</option>
			<option value="3">special</option>
			<option value="4">crazy</option> 
		</select>: <input type="range" min="1" max="9" name="cent4" id="2cent4"> <br/>
		<select name="cent5option" id="2cent5option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">cool</option> 
			<option value="2">greatest</option> 
			<option value="3">adorable</option>
			<option value="4">unique</option>
		</select> : <input type="range" min="1" max="9" name="cent5" id="2cent5"> <br/>
		<select name="cent6option" id="2cent6option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">fine</option> 
			<option value="2">goosebumps</option>
			<option value="3">epic</option>
			<option value="4">funny</option>
		</select> : <input type="range" min="1" max="9" name="cent6" id="2cent6"> <br/>
		<input type="button" value="submit" onclick="regAtmos2()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<input type="button" value="cancel"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		</form>
  </div>
  <div id="tabs-3">
<form method="post" class="white fs-m3 fw-200"
 action="/SpinUrOwn/regAtmos3.ma">
<%if(Atmos=="0"
	||Atmos.split(" ").length!=5){ %>
		<%=vo.getNickname()%>, plz show your prefer Atmos!<br/>
<%}else{ %>
		<%=vo.getNickname()%>, plz modify your prefer Atmos!<br/>
		<%} %>
		<select name="cent1option" id="3cent1option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">gorgeous</option>
			<option value="2">amazing</option>
			<option value="3">nice</option>
			<option value="4">beautiful</option>
		</select> : <input type="range" min="1" max="9" name="cent1" id="3cent1"> <br/>
		<select name="cent2option"id="3cent2option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">honest</option>
			<option value="2">powerful</option>
			<option value="3">different</option>
			<option value="4">incredible</option>
		</select> : <input type="range" min="1" max="9" name="cent2" id="3cent2"> <br/>
		<select name="cent3option" id="3cent3option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">flawless</option>
			<option value="2">raw</option>
			<option value="3">curious</option>
			<option value="4">cute</option>
		</select> : <input type="range" min="1" max="9" name="cent3" id="3cent3"> <br/>
		<select name="cent4option" id="3cent4option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">pathetic</option>
			<option value="2">huge</option>
			<option value="3">special</option>
			<option value="4">crazy</option> 
		</select>: <input type="range" min="1" max="9" name="cent4" id="3cent4"> <br/>
		<select name="cent5option" id="3cent5option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">cool</option> 
			<option value="2">greatest</option> 
			<option value="3">adorable</option>
			<option value="4">unique</option>
		</select> : <input type="range" min="1" max="9" name="cent5" id="3cent5"> <br/>
		<select name="cent6option" id="3cent6option"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
			<option value="1">fine</option> 
			<option value="2">goosebumps</option>
			<option value="3">epic</option>
			<option value="4">funny</option>
		</select> : <input type="range" min="1" max="9" name="cent6" id="3cent6"> <br/>
		<input type="button" value="submit" onclick="regAtmos3()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<input type="button" value="cancel"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		</form>
  </div>
</div>
		<hr/>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll@15.0.0/dist/smooth-scroll.polyfills.min.js"></script>
</body>
</html>