<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈 객체 생성하기(by useBean action tag)</title>
</head>
<body>
<jsp:useBean id="member" class="com.nsc7.javabeans.MemberBean" />
<!-- == MemberBean member=new com.nsc7.javabeans.MemberBean(); -->
<!-- member.setName("추수빈");
     member.setUserid("chsb"); -->
<%
// 	member.setName("추수빈");
// 	member.setUserid("chsb")
%>
<jsp:setProperty name="member" property="name" value="추수빈" />
<jsp:setProperty name="member" property="userid" value="chsb" />
<%-- 이름 : <%=member.getName()%><br> --%>
<%-- 아이디 : <%=member.getUserid() %> --%>
이름 : <jsp:getProperty name="member" property="name" /><br>
아이디 : <jsp:getProperty name="member" property="userid" />
</body>
</html>