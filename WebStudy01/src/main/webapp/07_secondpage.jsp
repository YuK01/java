<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	out.println("secondPage.jsp<br>");
	out.println("하나의 PAGE속성:"+pageContext.getAttribute("name")+"<br>");
	out.println("하나의 REQUEST속성:"+request.getAttribute("name")+"<br>");
	out.println("하나의 SESSION속성:"+session.getAttribute("name")+"<br>"); // session="ture"가 생략되어있을뿐 적혀있음
	out.println("하나의 APPLICATION속성:"+application.getAttribute("name")+"<br>");
	
// 	request.setAttribute("name",request.getAttribute("name"));
// 	request.getRequestDispatcher("07_thirdpage.jsp").forward(request,response); //이게 없어서 전달 안 됨
%> --%>
secondPage.jsp<br>
하나의 PAGE속성:${pageScope.name}<br>
하나의 REQUEST속성:${param.name}<br>
하나의 SESSION속성:${sessionScope.name}<br>
하나의 APPLICATION속성:${applicationScope.name}<br>
<a href="07_thirdpage.jsp">또다른 페이지(third page)</a>
</body>
</html>