<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<select id=selRoom style='width:200px' size=10>
					<c:forEach var="room" items="${room }">
						<option value=${room.code }>${room.name }&nbsp;&nbsp;${room.type_name }&nbsp;&nbsp;
													${room.howmany }&nbsp;&nbsp;${room.howmuch }</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<form id=frmRoom action="/study/addRoom">
					<table>
						<tr>
							<td align=right>객실명:</td>
							<td><input type=text name=roomname></td>
						</tr>
						<tr>
							<td align=right>타입:</td>
							<td><input type=number name=roomtype></td>
						</tr>
						<tr>
							<td align=right>숙박가능인원:</td>
							<td><input type=number name=howmany></td>
						</tr>
						<tr>
							<td align=right>숙박비:</td>
							<td><input type=number name=howmuch></td>
						</tr>
						<tr>
							<td colspan=2 align=right><input type=submit value="추가"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>