<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="spmem.VO.spmemVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
<%spmemVO vo = (spmemVO)session.getAttribute("vo");
String Atmos = vo.getPreferAtmos().toString();%>
<%if(Atmos=="0"
	||Atmos.split(" ").length!=5){ %>
	<form method="post" action="/SpinUrOwn/regAtmos2.ma">
		<%=vo.getNickname()%>, plz show your prefer Atmos2!<br/>
<%}else{ %>
	<form method="post" action="/SpinUrOwn/regAtmos2.ma">
		<%=vo.getNickname()%>, plz modify your prefer Atmos2!<br/>
	<%} %>
		<select name="cent1option">
			<option value="1">gorgeous</option>
			<option value="2">amazing</option>
			<option value="3">nice</option>
			<option value="4">beautiful</option>
		</select> : <input type="range" min="1" max="9" name="cent1" value="4"> <br/>
		<select name="cent2option">
			<option value="1">honest</option>
			<option value="2">powerful</option>
			<option value="3">different</option>
			<option value="4">incredible</option>
		</select> : <input type="range" min="1" max="9" name="cent2" value="4"> <br/>
		<select name="cent3option">
			<option value="1">flawless</option>
			<option value="2">raw</option>
			<option value="3">curious</option>
			<option value="4">cute</option>
		</select> : <input type="range" min="1" max="9" name="cent3" value="4"> <br/>
		<select name="cent4option">
			<option value="1">pathetic</option>
			<option value="2">huge</option>
			<option value="3">special</option>
			<option value="4">crazy</option> 
		</select>: <input type="range" min="1" max="9" name="cent4" value="4"> <br/>
		<select name="cent5option">
			<option value="1">cool</option> 
			<option value="2">greatest</option> 
			<option value="3">adorable</option>
			<option value="4">unique</option>
		</select> : <input type="range" min="1" max="9" name="cent5" value="4"> <br/>
		<select name="cent6option">
			<option value="1">fine</option> 
			<option value="2">goosebumps</option>
			<option value="3">epic</option>
			<option value="4">funny</option>
		</select> : <input type="range" min="1" max="9" name="cent6" value="4"> <br/>
		<input type="submit" value="submit">
		<input type="reset" value="cancel">
	</form>
</body>
</html>