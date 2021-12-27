<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method=post action="login_check.jsp">
<table>
<tr><td>아이디</td><td><input type=text name=userid></td></tr>
<tr><td>비밀번호</td><td><input type=password name=passcode></td></tr>
<tr><td colspan=2 align=center><input type=button id=btnCancle value='취소'>&nbsp;
<input type=submit value='로그인'></td></tr>
<tr><td colspan=2><a href="signon.jsp">회원가입</a>
</table>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#btnCancle',function(){
	document.location='home.jsp';
})
</script>
</html>