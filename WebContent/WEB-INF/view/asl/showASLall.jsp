<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="asl.VO.aslVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
<%List<aslVO> avo = (List<aslVO>)request.getAttribute("avo"); %>
	<table>
		<th>URLLINK</th>
		<th>Nickname</th>
		<th>genre</th>
		<th>Atmos</th>
		<%for(aslVO ro : avo){ %>
		<tr>
			<td><%=ro.getURLLINK()%></td>
			<td><%=ro.getNickname()%></td>
			<td><%=ro.getGenre()%></td>
			<td><%=ro.getAtmos()%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>