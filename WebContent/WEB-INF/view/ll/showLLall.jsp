<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="ll.VO.llVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
<%List<llVO> avo = (List<llVO>)request.getAttribute("avo"); %>
	<table>
		<th>URLLINK</th>
		<th>Nickname</th>
		<th>LisTime</th>
		<th>Disgenre</th>
		<th>DisAtmos</th>
		<th>IsSatisfied</th>
		<%for(llVO ro : avo){ %>
		<tr>
			<td><%=ro.getURLLINK()%></td>
			<td><%=ro.getNickname()%></td>
			<td><%=ro.getLisTime()%></td>
			<td><%=ro.getDisgenre()%></td>
			<td><%=ro.getDisAtmos()%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>