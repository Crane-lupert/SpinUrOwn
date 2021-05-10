<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/shorthandcss@1.1.1/dist/shorthand.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:200,300,400,500,600,700,800,900&display=swap" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
<body class="bg-black muli">
<center>
<table border="1" width="300" height="300" align= "center">
<center>
<span style="color: white; font-weight: bold;">Type your Verification Code (If it's correct, You can go to next lv)</span> <br> <br>    
        <br> <br>
        <div style="text-align:center;">
            <tr>        
                <td>
                <center>
                    <form action="/SpinUrOwn/join_injeung.me" method="post">                 
                    <center>
                        <br>
                        <div>
                            <font color="white"> your validation code :</font> <input type="number" name="email_injeung"
                                placeholder=" Right here. "><br/>
                                <input type="hidden" name="dice" value="${dice}">
                                <input type="hidden" name="email" 
                                	value="<%=request.getAttribute("email").toString()%>">
                        </div> 
                        <br> <br>
                        <button type="submit" name="submit">Submit Validation Code</button>
 
                        </div>
                    </td>
                </tr>
                    </center>
            </table>
        </form>
</center>
 
 
</body>
</html>
