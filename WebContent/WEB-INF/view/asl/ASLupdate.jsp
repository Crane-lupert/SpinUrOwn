<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript">
function regsong(){
	URLLINK = document.getElementById("URLLINK")
	cent1option = document.getElementById("cent1option")
	cent2option = document.getElementById("cent2option")
	cent3option = document.getElementById("cent3option")
	cent4option = document.getElementById("cent4option")
	cent5option = document.getElementById("cent5option")
	cent6option = document.getElementById("cent6option")
	cent1 = document.getElementById("cent1")
	cent2 = document.getElementById("cent2")
	cent3 = document.getElementById("cent3")
	cent4 = document.getElementById("cent4")
	cent5 = document.getElementById("cent5")
	cent6 = document.getElementById("cent6")
	Classic = document.getElementById("Classic")
	Jazz = document.getElementById("Jazz")
	Rock = document.getElementById("Rock")
	Metal = document.getElementById("Metal")
	Rap = document.getElementById("Rap")
	Electronic = document.getElementById("Electronic")
	Meaningful_Joyful = document.getElementById("Meaningful~Joyful")
	$.ajax({
		url:"/SpinUrOwn/ASLregister.ma",
		type:"POST",
		data: {
			URLLINK : URLLINK.value,
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
			cent6 : cent6.value,
			Classic : Classic.value,
			Jazz : Jazz.value,
			Rock : Rock.value,
			Metal : Metal.value,
			Rap : Rap.value,
			Electronic : Electronic.value,
			Meaningful_Joyful : Meaningful_Joyful.value
		},
		success : function(data) {
			alert("song assessment done!")
		}
	});//ajax end
}
</script>
</head>
<body><hr>
	<form method="post">
	<font class="white fs-m3 fw-200" size="12">
		<input type="text" name="URLLINK" id="URLLINK"
		class="input-lg flex-grow-1 bw-0 fw-200 bg-indigo-lightest-10 
		white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 br-r-0"
        placeholder="Youtube VIDEOID"><br>
		<font color="red">WARNING : it must be ID of that VIDEO, NOT the Full URL!</font>
		<br>
		describe feeling of this song!<br/>
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
		<br>
		describe the genre of this song!<br/>
		Classic :  <span class="tab">&#9;&#9;&#9;</span> 
		<input type="range" name="Classic" id="Classic"
			 value="${classic}" min="1" max="9" maxlength="40"><br/>
		Jazz : <span class="tab">&#9;&#9;&#9;&#9;</span> 
		<input type="range" name="Jazz" id="Jazz"
			 value="${Jazz}" min="1" max="9" maxlength="40"><br/>
		Rock :<span class="tab">&#9;&#9;&#9;&#9;</span> 
		<input type="range" name="Rock" id="Rock"
			 value="${Rock}" min="1" max="9" maxlength="40"><br/>
		Metal : <span class="tab">&#9;&#9;&#9;&#9;</span>             
		<input type="range" name="Metal" id="Metal"
			 value="${Metal}" min="1" max="9" maxlength="40"><br/>
		Rap : <span class="tab">&#9;&#9;&#9;&#9;</span>  
		<input type="range" name="Rap" id="Rap"
			 value="${Rap}" min="1" max="9" maxlength="40"><br/>
		Electronic :<span class="tab">&#9;&#9;&#9;</span> 
		<input type="range" name="Electronic" id="Electronic"
			 value="${Electronic}" min="1" max="9" maxlength="40"><br/>
		Meaningful~Joyful :<span class="tab">&#9;</span> 
		<input type="range" name="Meaningful_Joyful" id="Meaningful~Joyful"
		 value="${Meaningful_Joyful}" min="1" max="9" maxlength="40"><br/></font>
		<input type="button" value="submit" onclick="return regsong()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<input type="button" value="cancel"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<hr>
	
	</form>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll@15.0.0/dist/smooth-scroll.polyfills.min.js"></script>
</body>
</html>