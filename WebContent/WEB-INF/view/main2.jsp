<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="spmem.VO.spmemVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to SpinUrOwn!</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<%spmemVO vo = (spmemVO)session.getAttribute("vo");
request.setAttribute("ID", vo.getID());%>

<%boolean genzero = vo.getPrefergenre().trim().equals("0"); 
boolean atmoszero = vo.getPreferAtmos().trim().equals("0");
request.setAttribute("ID", vo.getID());
session.setAttribute("ID", vo.getID());%>

<script type="text/javascript">
var count=0;
function tofindurmuse(){
	var sel =0;
	sel = document.getElementById("Atmosphere");
	var Atmos = "";
	for(i=0; i<sel.options.length; i++) {
	    if(sel.options[i].selected == true) {
	        Atmos = sel.options[i].value;
	        break;
	    }
	}
	var gen = "";
	gen = document.getElementById("genreaccept");
	const result = $('#view0');
	$.ajax({
		url:"/SpinUrOwn/discovermuse.ma",
		type:"POST",
		data:{
			ID : "0",
			Password : "0",
			count : count,
			Atmosphere : Atmos,
			genreaccept : gen.value
		},
		success : function(data) {
			console.log(data);
			result.html(data);
		}
	});//ajax end
	count++;
	return false;
}
window.onload = function toall(){
	const $result1 = $('#view1');
	$.ajax({
		url:"/SpinUrOwn/genreUpdate.ma",
		type:"POST",
		data:{
			ID : "0",
			Password : "0"	
		},
		success : function(data) {
			console.log(data);
			$result1.html(data);
		}
	});//ajax end
	const $result2 = $('#view2');
	$.ajax({
		url:"/SpinUrOwn/ASLUpdate.ma",
		type:"POST",
		success : function(data) {
			console.log(data);
			$result2.html(data);
		}
	});//ajax end
	const $result3 = $('#view3');
	$.ajax({
		url:"/SpinUrOwn/AtmosUpdate.ma",
		type:"POST",
		success : function(data) {
			console.log(data);
			$result3.html(data);
		}
	});//ajax end
	const $result4 = $('#view4');
	$.ajax({
		url:"/SpinUrOwn/rtowrite.ma",
		type:"POST",
		success : function(data) {
			console.log(data);
			$result4.html(data);
		}
	});//ajax end
	const $result5 = $('#slider-2');
	$.ajax({
		url:"/SpinUrOwn/rtoread.ma",
		type:"POST",
		success : function(data) {
			console.log(data);
			$result5.html(data);
		}
	});//ajax end
}
</script>
</head>
<body class="bg-black muli">

<nav class="w-100pc flex flex-column md-flex-row md-px-10 py-5 bg-black">
        <div class="flex justify-between">
            <a href="#" class="flex items-center p-2 mr-4 no-underline">
                <img class="max-h-l5 w-auto" src="/SpinUrOwn/img/logo3.png" 
                alt="SpinUrOwn" onclick="location.href='/SpinUrOwn/main.ma'"/>
            </a>
            <a data-toggle="toggle-nav" data-target="#nav-items" href="#"
                class="flex items-center ml-auto md-hidden indigo-lighter opacity-50 hover-opacity-100 ease-300 p-1 m-3">
                <i data-feather="menu"></i>
            </a>
        </div>
        <%if(genzero){%>
       		<div id="nav-items" class="hidden flex sm-w-100pc flex-column md-flex md-flex-row md-justify-end items-center">
            	<a href="#reggenre" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Register your genre</a>
            	<a href='/SpinUrOwn/logout.ma' class="button bg-white black fw-600 no-underline mx-5">logout</a>
        	</div>
		<%}else if(atmoszero){%>
		<div id="nav-items" class="hidden flex sm-w-100pc flex-column md-flex md-flex-row md-justify-end items-center">
           	<a href="#reggenre" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Register your genre</a>
            <a href="#regAtmos" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Register your Atmos</a>
            <a href='/SpinUrOwn/logout.ma' class="button bg-white black fw-600 no-underline mx-5">logout</a>
        </div>
		<%}else{%>
        <div id="nav-items" class="hidden flex sm-w-100pc flex-column md-flex md-flex-row md-justify-end items-center">
            <a href="#FindurMuse" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">FindurMuse</a>
            <a href="#assong" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Assessment songs</a>
            <a href="#reggenre" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Register your genre</a>
            <a href="#regAtmos" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Register your Atmos</a>
            <a href="#rto" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Recommand song</a>
            <a href="#myrto" class="fs-s1 mx-3 py-3 indigo no-underline hover-underline">Check from other</a>
            <a href='/SpinUrOwn/logout.ma' class="button bg-white black fw-600 no-underline mx-5">logout</a>
        </div>
        <%} %>
    </nav>
    <div id="view0" align="center" class="mx-auto py-10"></div>
    <%if(!genzero && !atmoszero){%>
	<section id="FindurMuse" class="p-10 md-py-10">
            <div class="w-100pc md-w-70pc mx-auto py-10">
                <h4 class="white fs-l1 lh-2 md-fs-xl1 md-lh-1 fw-700 ">Find your music rightnow!</h4>

                <div class="br-8 mt-10 inline-flex">
                <font class="white fs-m2 fw-200">
                    <select name="Atmosphere" id="Atmosphere"
                    class="input-lg half bw-0 fw-200 bg-indigo-lightest-10 white ph-indigo-lightest focus-white opacity-80 fs-s3 py-5 min-w-5vw br-r-0">
                        <option value="1" selected="selected">Atmos1</option>
                        <%if(!vo.getPreferAtmos2().toString().trim().equals("0")){ %>
							<option value="2">Atmos2</option>
						<%}
                        if(!vo.getPreferAtmos3().toString().trim().equals("0")){%>
            			<option value="3">Atmos3</option>
            			<%} %>
                    </select>
                    <input type="hidden" value="<%=vo.getID()%>" id="ID" name="ID"/>
                    <input type="hidden" value="<%=vo.getPassword()%>" id="Password" name="Password"/>
                    <input class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700" id="genreaccept"
                     name="genreaccept" type="range" min="50" max="500" maxlength="500"> 
                     <button value="Find my muse" onclick="tofindurmuse()"
                        class="button-lg bg-indigo-lightest-20 indigo-lightest 
                        focus-white fw-300 fs-s3 mr-0 br-l-0">listen muse</button>
                	</font>
                </div>
             </div>
    </section>
    <%} %>
    <%if(!genzero && !atmoszero){%>
    <section class="p-10 md-py-10" id="assong">
        <div id="view2"
        class="w-100pc md-w-70pc mx-auto py-10">
       		<h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700 ">assong</h1>
        </div>
    </section>
    <%} %>
    <section class="p-10 md-py-10" id="reggenre">
        <div id="view1"
        class="w-100pc md-w-70pc mx-auto py-10">
        	<h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700 ">reggenre</h1>
        </div>
    </section>
    <%if(!genzero){%>
    <section class="p-10 md-py-10" id="regAtmos">
        <div id="view3" class="w-100pc md-w-70pc mx-auto py-10">
        	<h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700 ">regAtmos</h1>
        </div>
    </section>
    <%} %>
    <%if(!genzero && !atmoszero){%>
    <section class="p-10 md-py-10" id="rto">
        <div id="view4" class="w-100pc md-w-70pc mx-auto py-10">
        	<h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700 ">rto</h1>
        </div>
    </section>
    <section class="p-10 md-py-10" id="myrto">
        <div id="slider-2" class="w-100pc md-w-70pc mx-auto py-10">
        	<h1 class="white fs-l3 lh-2 md-fs-xl1 md-lh-1 fw-700 ">myrto</h1>
        </div>
    </section>
     <%} %>


<footer class="p-10 md-py-10 md-p-l5 bg-indigo-lightest-10">
<div class="w-100pc md-w-70pc mx-auto py-10">
    <div class="flex justify-around">
		<div class="w-33pc md-px-10 mb-10">
			<h5 class="white">About your account</h5>
			<ul class="list-none mt-5 fs-s2">
				<li class="my-3">
					<a href="/SpinUrOwn/delaccount.ma" class="white opacity-70 no-underline hover-underline">
					Delete account</a>
				</li>
				<li class="my-3">
			 		<a href="#" class="white opacity-70 no-underline hover-underline">
			 		Change Password</a>
				</li>
				<li class="my-3">
					<font class="white opacity-70 no-underline hover-underline">
					Donate to hogu</font>
				</li>
				<li class="my-3">
					<font class="white opacity-70 no-underline hover-underline">
					paypal : haka4700@gmail.com</font>
				</li>
			</ul>
		</div>
		<%if(vo.getNickname().trim().equals("admin")){%>
		<div class="w-33pc md-px-10 mb-10">
			<h5 class="white">Console for admin</h5>
			<ul class="list-none mt-5 fs-s2">
				<li class="my-3">
					<a href="/SpinUrOwn/showASLall.ma" 
					class="white opacity-70 no-underline hover-underline">
					Show ASL all</a>
				</li>
				<li class="my-3">
			 		<a href="/SpinUrOwn/showLLall.ma" 
			 		class="white opacity-70 no-underline hover-underline">
			 		Show LL all</a>
				</li>
				<li class="my-3">
			 		<a href="/SpinUrOwn/showRTOall.ma" 
			 		class="white opacity-70 no-underline hover-underline">
			 		Show RTO all</a>
				</li>
			</ul>
		</div>
		<%} %>
		<div class="w-33pc md-px-10 mb-10">
			<h5 class="white">About your account</h5>
			<ul class="list-none mt-5 fs-s2">
				<li class="my-3">
					<a href="#" class="white opacity-70 no-underline hover-underline">
					<%=genzero%></a>
				</li>
				<li class="my-3">
			 		<a href="#" class="white opacity-70 no-underline hover-underline">
			 		<%=atmoszero %></a>
				</li>
				<li class="my-3">
					<font class="white opacity-70 no-underline hover-underline">
					<%=vo.getPreferAtmos() %></font>
				</li>
				<li class="my-3">
					<font class="white opacity-70 no-underline hover-underline">
					<%=vo.getPreferAtmos2() %></font>
				</li>
			</ul>
		</div>
	</div>
</div>
</footer>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll@15.0.0/dist/smooth-scroll.polyfills.min.js"></script>
</body>
</html>