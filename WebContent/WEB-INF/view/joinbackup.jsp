<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script type="text/javascript">
 
        function checkValue()
        {
            inputForm = eval("document.loginInfo");
            if(!inputForm.Nickname.value)
            {
                alert("닉네임을 입력하세요");    
                inputForm.Nickname.focus();
                return false;
            }
            if(!${Nickcheck}.value){
            	alert("중복된 닉네임입니다.");    
                inputForm.Nickname.focus();
                return false;
            }
            if(!inputForm.ID.value)
            {
                alert("아이디를 입력하세요");    
                inputForm.ID.focus();
                return false;
            }
            if(!${IDcheck}.value){
            	alert("중복된 아이디입니다.");    
                inputForm.ID.focus();
                return false;
            }
            if(!inputForm.password.value)
            {
                alert("비밀번호를 입력하세요");    
                inputForm.password.focus();
                return false;
            }
        }
    </script>
</head>
<body>
	<h3>** 등록하려고 하는 고객 정보를 입력하시오 **
	${email}</h3>
	<!-- servlet에서 *.do로 url 맵핑, Controller로 이동한 -->
	<form name="loginInfo" action="/SpinUrOwn/spmemInsert.me" method="post"
	enctype="multipart/form-data" onsubmit="return checkValue()">
		닉네임 : <input type="text" name="Nickname"><br/>
		아이디 : <input type="text" name="ID"><br/>
		패스워드 : <input type="password" name="Password"><br/>
		이메일 : <input type="hidden" value="${email}" name="email"><br/>
		<input type="submit" value="등록">
		<input type="reset" value="재작성">
	</form>
</body>
</html>