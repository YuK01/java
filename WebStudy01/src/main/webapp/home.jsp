<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="10_header.jsp" />
<%
	String id=(String)session.getAttribute("userid");
	if(session.getAttribute("userid")==null){
		out.print("<div align=right><a href='login.jsp'>로그인</a>&nbsp;<a href='signon.jsp'>회원가입</a></div>");
	} else {
		out.print(id+"<div align=right><a id=logout href='logout.jsp'>로그아웃</a></div>");
	}

// 	Cookie[] cookies=request.getCookies();
// 	boolean flag=true;
// 	for(Cookie c:cookies){
// 		if(c.getName().equals("userid")){
// 			out.println(c.getValue()+"&nbsp;&nbsp;<a href='logout.jsp'>로그아웃</a>");
// 			flag=false;
// 			break;
// 		}
// 	}
// 	if(flag==true){
// 		out.print("<a href='login.jsp'>로그인</a>&nbsp;&nbsp;<a href='signon.jsp'>회원가입</a>");
// 	}
	
%>
<jsp:include page="10_footer.jsp" />
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
// $(document)
// .on('click','#logout',function(){
// 	alert("로그아웃 하시겠습니까?");
// })
</script>
</html>