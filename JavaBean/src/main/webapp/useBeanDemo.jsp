<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="com.nsc7.javabeans.MemberBean" />
<jsp:setProperty name="member" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈 객체 생성하기(by useBean action tag)</title>
</head>
<body>
<%-- <jsp:useBean id="member" class="com.nsc7.javabeans.MemberBean" /> --%>
<!-- == MemberBean member=new com.nsc7.javabeans.MemberBean(); -->
<!-- member.setName("추수빈");
     member.setUserid("chsb"); -->
<%-- <% --%>
<!-- member.setName("추수빈"); -->
<!-- member.setUserid("chsb") -->
<%-- %> --%>
<%-- <jsp:setProperty name="member" property="name" value="추수빈" /> --%>
<%-- <jsp:setProperty name="member" property="userid" value="chsb" /> --%>
<%-- 이름 : <%=member.getName()%><br> --%>
<%-- 아이디 : <%=member.getUserid() %> --%>
<%-- 이름 : <jsp:getProperty name="member" property="name" /><br> --%>
<%-- 아이디 : <jsp:getProperty name="member" property="userid" /> --%>

<h2>입력 완료된 회원 정보</h2>
<table>
	<tr>
		<td>이름</td>
		<td><jsp:getProperty name="member" property="name" /></td>
	</tr>
	<tr>
		<td>별명</td>
		<td><jsp:getProperty name="member" property="nickname" /></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><jsp:getProperty name="member" property="userid" /></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><jsp:getProperty name="member" property="pwd" /></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><jsp:getProperty name="member" property="email" /></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><jsp:getProperty name="member" property="phone" /></td>
	</tr>
</table>
</body>
</html>