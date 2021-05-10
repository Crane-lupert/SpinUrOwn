<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="spmem.VO.spmemVO"%>
<%@page import="song.VO.songVO"%>
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
 
function checkValue()
{	
	inputForm = eval("document.rtoInfo");
    if(!inputForm.URLLINK.value)
    {
        alert("empty URLLINK, type VIDEOID");    
        inputForm.URLLINK.focus();
    } 
}
function reggenre(){
	SNICK = document.getElementById("SNICK")
	RNICK = document.getElementById("RNICK")
	URLLINK = document.getElementById("URLLINK")
	$.ajax({
		url:"/SpinUrOwn/rtosend.ma",
		type:"POST",
		data: {
			SNICK : SNICK.value,
			RNICK : RNICK.value,
			URLLINK : URLLINK.value
		},
		success : function(data) {
			alert("song update done!")
			return false;
		}
	});//ajax end
}
</script>
<style type="text/css">
.tab { white-space: pre; }
</style>
</head>
<body>
<%spmemVO vo = (spmemVO)session.getAttribute("vo"); %>
<%List<spmemVO> spmvo =(List<spmemVO>)request.getAttribute("spmvo"); %>
	<!-- <form name="rtoInfo" method="post" action="/SpinUrOwn/rtosend.ma"> -->
	<%--onsubmit="return checkValue()" --%>
		<font class="white fs-m3 fw-200" size="12">
		From<span class="tab">&#9;</span><input type="text" readonly="readonly" name="SNICK" id="SNICK" 
			value="<%=vo.getNickname().toString().trim()%>"<%--여긴 왜 또 문제임? --%>
			class="input-lg flex-grow-1 bw-0 fw-200 bg-indigo-lightest-10 
			white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 br-r-0"
        	placeholder="<%=vo.getNickname().toString().trim()%>"/><br/>
		TO<span class="tab">&#9;&#9;</span><select name="RNICK" id="RNICK"
		class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0"><%for(spmemVO spm : spmvo){
		%><option><%=spm.getNickname()%></option>
		<%}%>
		</select><br/>
		<span class="tab">&#9;&#9;</span><input type="text" id="URLLINK" width="40" maxlength="20"
		class="input-lg flex-grow-1 bw-0 fw-200 bg-indigo-lightest-10 
			white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 br-r-0"
        	placeholder="VIDEOID"/><br/></font>
		<input type="button" value="send rto!" onclick="return reggenre()"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
		<input type="button" value="re-write"
		class="button-lg bg-indigo-lightest-20 indigo-lightest 
		focus-white fw-300 fs-s3 mr-0 br-l-0">
	<!-- </form> -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll@15.0.0/dist/smooth-scroll.polyfills.min.js"></script>
</body>
</html>