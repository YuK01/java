<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
	실명:<%=request.getParameter("name") %><br>
	성별:<%=request.getParameter("gender") %><br>
	아이디:<%=request.getParameter("userid") %><br>
	비밀번호:<%=request.getParameter("passcode") %><br>
	비밀번호 확인:<%=request.getParameter("passcode1") %><br>
	모바일번호:<%=request.getParameter("mobile") %><br>
	관심분야:
	<%
		//String[] arInter=request.getParameterValues("interest");
		/* for(int i=0; i<arInter.length; i++) {
			if(i!=0) out.println(",");
			out.println(arInter[i]);
		} */
		for(String area:request.getParameterValues("interest")){
			out.println(area+"<br>");
		}
	%>
	<!-- <input type=button onclick='showLogin()' value='로그인가기'>  -->
	<!-- <input type=button id=btnLogin value='로그인가기'> -->
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
/* function showLogin(){
	document.location='login.jsp';
} */
$(document)
.ready(function(){
	setTimeout(function(){
		document.location='login.jsp';
	},3000)
})
/* .on('click','#btnLogin',function(){
	document.location='login.jsp';
}) */
</script>
</html>