<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
	table{border-collapse:collapse}
	td{border:1px solid blue}
</style>
<body>
<jsp:include page="10_header.jsp" />
<form method=post action="login_check.jsp">
<table align=center valign=middle>
<tr><td>아이디</td><td><input type=text name=userid id=userid></td></tr>
<tr><td>비밀번호</td><td><input type=password name=passcode id=passcode></td></tr>
<tr><td colspan=2 align=center><input type=button id=btnCancle value='취소'>&nbsp;
<input type=submit value='로그인'></td></tr>
<tr><td colspan=2 align=right><a href="signon.jsp">회원가입</a>
</table>
</form>
<jsp:include page="10_footer.jsp" />
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#btnCancle',function(){
	document.location='home.jsp';
})
.on('submit',function(){
	if($('input[name=userid]').val()=='') {
		alert('아이디를 입력하세요.');
		return false;
	}
	if($('input[name=passcode]').val()=='') {
		alert('비밀번호를 입력하세요.');
		return false;
	}
	return true;
})
</script>
</html>