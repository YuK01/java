<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align=right>
<%
	if(session.getAttribute("userid")==null){
		out.print("<a href='login.jsp'>로그인</a>&nbsp;<a href='signon.jsp'>회원가입</a>");
	} else {
		out.print(request.getAttribute("userid")+"<a id=logout href='logout.jsp'>로그아웃</a>");
	}
%>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#logout',function(){
	alert("로그아웃 하시겠습니까?");
})
</script>
</html>