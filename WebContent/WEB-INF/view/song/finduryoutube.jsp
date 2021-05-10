<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="song.VO.songVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%songVO svo = (songVO)request.getAttribute("svo"); %>
	<iframe width="720" height="420" 
		src="https://www.youtube.com/embed/<%=svo.getURLLINK()%>"
		frameborder="0" allow="accelerometer; autoplay;
			 encrypted-media; gyroscope; picture-in-picture" 
		 allowfullscreen></iframe>
</body>
</html>