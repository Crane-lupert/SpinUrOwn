<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to SpinUrOwn!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <!-- <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" /> -->
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
<style>
section{
  position:relative;
  top:50%;
  width:300px;
  max-width:96%;
  margin:0 auto;
  padding-top:120px;
	-webkit-transform:translateY(-50%);
	-ms-transform:translateY(-50%);
	transform:translateY(-50%);}
fieldset{
  	display: block;
  	width:100%;
	margin:0 auto;
  	padding:1em 0 1em 0;
  	border: none;
  	border-bottom: 1px solid #ccc;}
fieldset:first-child{
  margin-bottom:0;}
fieldset:last-child{
  border-bottom: none;
  margin-top:0;
  padding:0;}
</style>
<title>SpinUrOwn. The place you can find muse</title>
</head>
<link rel="stylesheet">
<body class="bg-black muli">
<div align="center">
	<!-- <h1>SpinUrOwn, find your muse</h1> -->
	<img class="max-h-l5 w-auto" src="/SpinUrOwn/img/logo3.png" 
                alt="SpinUrOwn" onclick="location.href='/SpinUrOwn/main.ma'"/>
	<br/>
	<form method="post" action="/SpinUrOwn/splogin.me">
		<fieldset>
			<input type="text" name="ID" id="ID" placeholder="ID"><br/>
		</fieldset>
		<fieldset>
			<input type="password" name="Password" id="Password" placeholder="Password"><br/>
		</fieldset>
		<fieldset>
		<input type="submit" value="Sign in">
		</fieldset>
	</form>
	<fieldset>
	<button id="cmbr" class="cmbr" 
		onclick="location.href='/SpinUrOwn/email.me'" 
		value="회원가입">Registration</button>
	</fieldset>
</div>
</body>
</html>