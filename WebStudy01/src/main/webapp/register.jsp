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
	<form method=POST action=validate.jsp>
		<table>
			<tr>
				<td align=right>실명</td>
				<td><input type=text name=name size=12></td>
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
				<td>모바일번호</td>
				<td colspan=3 align=left><input type=text name=mobile size=12></td>
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
				<input type=reset value="비우기"></td>
			</tr>
		</table>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('submit',function(){/* 유효성검사(validation) 결과가 허용범위이면 return true -> submit 계속 진행(서버쪽에 전달) */
	if($('input[name=passcode1]').val()==''){
		alert('false');
		return false; // submit이 취소된다.
	} else {
		alert('true');
		return true;
	}
})
</script>
</html>