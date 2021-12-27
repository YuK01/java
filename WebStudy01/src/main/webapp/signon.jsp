<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style>
	table{border-collapse:collapse}
	td{border:1px solid blue}
</style>
<body>
<%
request.setCharacterEncoding("UTF-8");
%>
	<form method=POST action=sign_check.jsp>
		<table>
			<tr>
				<td align=right>실명</td>
				<td><input type=text name=Name size=12></td>
				<td align=right>성별</td>
				<td><input type=radio name=gender value="남성">남성&nbsp;&nbsp;
					<input type=radio name=gender value="여성">여성</td>
			</tr>
			<tr>
				<td align=right>아이디</td>
				<td colspan=3 align=left><input type=text name=userid size=12></td>
			</tr>
			<tr>
				<td align=right>비밀번호</td>
				<td><input type=password name=passcode size=12></td>
				<td>비밀번호 확인</td>
				<td><input type=password name=passcode1 size=12></td>
			</tr>
			<tr>
				<td valign=top>관심분야</td>
				<td colspan=3><input type=checkbox name=interest value="정치">정치&nbsp;&nbsp;
					<input type=checkbox name=interest value="경제">경제&nbsp;&nbsp;
					<input type=checkbox name=interest value="사회">사회&nbsp;&nbsp;
					<input type=checkbox name=interest value="문화">문화<br>
					<input	type=checkbox name=interest value="역사">역사&nbsp;&nbsp;
					<input	type=checkbox name=interest value="연예">연예&nbsp;&nbsp;
					<input	type=checkbox name=interest value="스포츠">스포츠&nbsp;&nbsp;
					<input	type=checkbox name=interest value="예술">예술</td>
			</tr>
			<tr>
				<td colspan=4 align=center><input type=submit value="가입완료">
				<input type=button id=btnCancle value="취소"></td>
			</tr>
		</table>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#btnCancle',function(){
	document.location='home.jsp';
})
.on('submit',function(){
	if($('input[name=Name]').val()=='') {
		alert('실명을 입력하세요.');
		return false;
	}
	if($('input[name=gender]').val()=='') {
		alert('성별을 선택하세요.');
		return false;
	}
	if($('input[name=userid]').val()=='') {
		alert('아이디를 입력하세요.');
		return false;
	}
	if($('input[name=passcode]').val()=='') {
		alert('비밀번호를 입력하세요.');
		return false;
	}
	console.log($('input[name=passcode]').val());
	console.log($('input[name=passcode1]').val());
	if($('input[name=passcode1]').val()=='') {
		alert('비밀번호확인을 입력하세요.');
		return false;
	}
	if($('input[name=passcode1]').val()!=$('input[name=passcode]').val()) {
		alert('비밀번호와 비밀번호입력이 같지 않습니다.');
		return false;
	}
	for(;;$('input[name=interest]').val()){
		return false;
	}
	return true;
})
</script>
</html>