<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form method=POST action=memberServlet>
		<table>
			<tr>
				<td>실명</td>
				<td><input type=text name=name></td>
				<td>성별</td>
				<td><input type=radio name=gender value="남성">남성&nbsp;&nbsp;
					<input type=radio name=gender value="여성">여성</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type=text name=id></td>
				<td colspan=2></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type=password name=passcode></td>
				<td>비밀번호 확인</td>
				<td><input type=password name=re_passcode></td>
			</tr>
			<tr>
				<td>모바일번호</td>
				<td><input type=text name=mobile></td>
				<td colspan=2></td>
			</tr>
			<tr>
				<td>관심분야</td>
				<td><input type=checkbox name=interest value="정치">정치&nbsp;&nbsp;
					<input type=checkbox name=interest value="경제">경제&nbsp;&nbsp;
					<input type=checkbox name=interest value="사회">사회&nbsp;&nbsp;
					<input type=checkbox name=interest value="문화">문화<br>
					<input	type=checkbox name=interest value="역사">역사&nbsp;&nbsp;
					 <input	type=checkbox name=interest value="연예">연예&nbsp;&nbsp;
					 <input	type=checkbox name=interest value="스포츠">스포츠&nbsp;&nbsp;
					 <input	type=checkbox name=interest value="예술">예술</td>
			</tr>
			<tr>
				<td colspan=4 align=center><input type=submit value="작성완료"><input
					type=reset value="Reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>