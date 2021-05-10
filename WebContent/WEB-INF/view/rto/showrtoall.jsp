<%@page import="rto.VO.rtoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<rtoVO> rvo = (List<rtoVO>)request.getAttribute("rvo"); %>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
	<table>
		<th>SendNick</th>
		<th>RecNick</th>
		<th>URLLINK</th>
		<th>RecTime</th>
		<%for(rtoVO ro : rvo){ %>
		<tr>
			<td><%=ro.getSendNick()%></td>
			<td><%=ro.getRecNick()%></td>
			<td><%=ro.getURLLINK()%></td>
			<td><%=ro.getRecTime()%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>