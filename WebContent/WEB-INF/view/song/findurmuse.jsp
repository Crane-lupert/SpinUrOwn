<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="spmem.VO.spmemVO" %>
<%@page import="song.VO.songVO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%List<songVO> ver = (List<songVO>)request.getAttribute("llcand"); %>
<% int k = 0;
	for(songVO ve : ver){%>
	<%ve.setRowrow(k++);%>
	<%}%>
<%session.setAttribute("ver", ver);%>
<script type="text/javascript">
var count=0;
function process1(){
	alert(count)
	const $result = $('#view11');
	$.ajax({
		url:"/SpinUrOwn/listenmuse.ma",
		type:"GET",
		data: {
			count : count
		},
		success : function(data) {
			console.log(data);
			$result.html(data);
		}
	});//ajax end
	count++;
}
</script>
</head>
<body>
<%spmemVO vo = (spmemVO)session.getAttribute("vo");%><br/>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
	<%for(songVO ve : ver){%>
	<%=ve.getURLLINK()%>
	<%=ve.getDisAtmos()%>
	<%=ve.getDisgenre()%>
	<%=ve.getRowrow()%>
	<br><hr>
	<%}%>
<input type="button" value="show muse" id="ok" 
onclick="process1()"/>
</body>
</html>