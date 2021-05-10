<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/SpinUrOwn/backtomain.ma">back to main</a><br/>
	for security, please write your password down again
	<form method="post" action="/SpinUrOwn/farewell.ma">
		<input type="password" name="pw" id="pw">
		<input type="submit" value="submit">
		<input type="reset" value="cancel">
	</form>
</body>
</html>