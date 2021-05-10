<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="rto.VO.rtoVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
</head>
<body>
<%List<rtoVO> rvo = (List<rtoVO>)request.getAttribute("rvo"); %>
	<%-- <table>
	
		<th>sender</th>
		<th>URLLINK</th>
		<th>RecommandTime</th>
		<%for(rtoVO ro : rvo){ %>
		<tr>
			<td><%=ro.getSendNick()%></td>
			<td><%=ro.getURLLINK()%></td>
			<td><%=ro.getRecTime()%></td>
		</tr>
		<%} %>
	</table> --%>
	<font class="white fs-m3 fw-200" size="12">
	<%for(rtoVO ro : rvo){ %>
	<div class="px-3">
        <div class="p-8 br-8 bg-indigo-lightest-10 relative">
			<span class="fs-l5 lh-1 white opacity-10 absolute top-0 z--1">&#10077;</span>
                    <!-- <p class="fw-600 fs-m1 indigo-lightest opacity-80 italic ls-wider">Lorem ipsum dolor sit amet,
                        consectetur adipiscing elit, sed do eiusmod tempor </p> -->
                        <iframe width="240" height="140" 
						src="https://www.youtube.com/embed/<%=ro.getURLLINK()%>"
						frameborder="0" allow="accelerometer; autoplay;
					 	encrypted-media; gyroscope; picture-in-picture" 
		 				allowfullscreen></iframe>
		 				<!-- <iframe width="240" height="140" 
						src="https://www.youtube.com/embed/k8JkHBcay0Q"
						frameborder="0" allow="accelerometer; autoplay;
					 	encrypted-media; gyroscope; picture-in-picture" 
		 				allowfullscreen></iframe> -->
                    <div class="flex items-center my-5">
                        <div class="block br-round border bc-black bw-4 w-l3 h-l3"></div>
                        <div class="ml-4 fs-s1">
                        	<!-- <div class="indigo-lightest">Enccc</div> -->
                            <div class="indigo-lightest"><%=ro.getURLLINK()%></div>
                            <!-- <div class="indigo-lightest opacity-20">24-SEP-20</div> -->
                            <div class="indigo-lightest opacity-20"><%=ro.getRecTime()%></div>
                        </div>
                    </div>
                </div>
            </div>
        <%} %>            
</font>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
    <script src="https://cdn.jsdelivr.net/gh/cferdinandi/smooth-scroll@15.0.0/dist/smooth-scroll.polyfills.min.js"></script>
</body>
</html>