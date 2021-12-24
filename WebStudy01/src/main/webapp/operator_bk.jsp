<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String val1 = request.getParameter("val1");
	String val2 = request.getParameter("val2");
	String oper = request.getParameter("oper");
	if (val1 == null || val2 == null || oper == null) { // 유효성체크(validation)
		return;
	}
	// 연산부
	int v1 = Integer.parseInt(val1);
	int v2 = Integer.parseInt(val2);
	int result = 0;
	if (oper.equals("+")) {
		result = v1 + v2;
	} else if (oper.equals("-")) {
		result = v1 - v2;
	} else if (oper.equals("*")) {
		result = v1 * v2;
	} else if (oper.equals("/")){
		if (v2 == 0) {
			return;
		} else {
			result = v1 / v2;
		}
	} else return;
	// out.println("value1: " + v1 + "<br>value2: " + v2 + "<br>operator: " + oper + "<br>result: " + result);
	%>
	value1:<%=v1 %><br>
	value2:<%=v2 %><br>
	operator:<%=oper %><br>
	Result:<%=result %>
</body>
</html>