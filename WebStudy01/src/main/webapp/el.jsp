<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
<%
	String greeting="Hello World";
    request.setAttribute("str",greeting);
	request.setAttribute("num1",3);
	request.setAttribute("num2",5);
// 	int num1=(Integer)request.getAttribute("num1");
// 	int num2=(Integer)request.getAttribute("num2");
%>
<%-- <%=greeting %><br> --%>
<%-- ${param.greeting=="hello"}<br> EL태그 --%>
${str}<br>
<%--<%=num1 %>+<%=num2 %>=<%=num1+num2 %><br> --%> <%-- JSP기본태그 --%>
${num1 }+${num2 }=${num1+num2 }<br>
x1값 : ${sessionScope.x1 } <%-- 아..데이터를 보내주는 elTest에서 와야함.ㅋㅋㅋ; 여기서 바로 시작하면 출력안됨. 왜냐면 보낸 데이터가 없어서 --%>
</body>
</html>