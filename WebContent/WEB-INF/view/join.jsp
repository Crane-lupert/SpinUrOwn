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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
<script type="text/javascript">
function checkNick() {
	$.ajax({
	    type:"POST",
	    url:"/SpinUrOwn/checkNick.me",
	    data:{
	           "Nickname":$('#Nickname').val()
	    },
	    success:function(data){	//data : checkSignup에서 넘겨준 결과값
           if($.trim(data)=="YES"){
              if($('#Nickname').val()!=''){ 
              	alert("You can use this Nickname.");
              }
          	}else{
              if($('#Nickname').val()!=''){
                 alert("Already used Nickname.");
                 $('#Nickname').val('');
                 $('#Nickname').focus();
              }
           }
	    }
	}) 
}
function checkID() {
	$.ajax({
	    type:"POST",
	    url:"/SpinUrOwn/checkID.me",
	    data:{
	           "ID":$('#ID').val()
	    },
	    success:function(data){	//data : checkSignup에서 넘겨준 결과값
          if($.trim(data)=="YES"){
             if($('#ID').val()!=''){ 
             	alert("You can use this ID.");
             }
         	}else{
             if($('#ID').val()!=''){
                alert("Already used ID.");
                $('#ID').val('');
                $('#ID').focus();
             }
          }
	    }
	}) 
}
</script>
</head>
<body class="bg-black muli">
<center>
<table border="1" width="300" height="300" align= "center">
	<span style="color: white; font-weight: bold;">** Write down your account info. **</span>
	<br/><br/>
	<div style="text-align:center;">
	<tr>        
		<td>
			<center>
	<!-- servlet에서 *.do로 url 맵핑, Controller로 이동한 -->
	<form name="loginInfo" action="/SpinUrOwn/spmemInsert.me" method="post"
	 onsubmit="return checkValue()">
	 <center>
		<br>
			<div>
		<input type="text" name="Nickname" id="Nickname" placeholder="Nickname">
		<input type="button" value="check" onclick="return checkNick()"><br/>
		<input type="text" name="ID" id="ID" placeholder="ID">
		<input type="button" value="check" onclick="return checkID()"><br/>
		<input type="password" name="Password" placeholder="Password">
		<input type="hidden" value="${e_mail}" name="Email"><br/>
		</div>
		<input type="submit" value="submit">
		<input type="reset" value="re-write">
		</div>
                    </td>
                </tr>
                    </center>
            </table>
	</form>
</center>
</body>
</html>