<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.tab { white-space: pre; }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script type="text/javascript">
function reggenre(){
	/* alert('regatmos1') */
	Classic = document.getElementById("Classic")
	Jazz = document.getElementById("Jazz")
	Rock = document.getElementById("Rock")
	Metal = document.getElementById("Metal")
	Rap = document.getElementById("Rap")
	Electronic = document.getElementById("Electronic")
	Meaningful_Joyful = document.getElementById("Meaningful~Joyful")
	$.ajax({
		url:"/SpinUrOwn/reggenre.ma",
		type:"POST",
		data: {
			Classic : Classic.value,
			Jazz : Jazz.value,
			Rock : Rock.value,
			Metal : Metal.value,
			Rap : Rap.value,
			Electronic : Electronic.value,
			Meaningful_Joyful : Meaningful_Joyful.value
		},
		success : function(data) {
			alert("genreUpdate1 done!")
		}
	});//ajax end
}
</script>
</head>
<body class="bg-black muli">
<hr/>
<form method="post">
<font class="white fs-m3 fw-200" size="12">
	Plz show your Prefered Component!
	<br/>
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
		<input type="button" value="submit" onclick="return reggenre()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
	</form>
</body>
</html>