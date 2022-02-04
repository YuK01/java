<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 관리</title>
</head>
<body>
<table>
	<tr>
		<td>
			<select id=selMenu style='width:200px' size=10>
				<c:forEach var="menu" items="${menu }">
					<option value=${menu.code }>${menu.name },${menu.price }</option>
				</c:forEach>
			</select>
		</td>
		<td>
			<form action="/study/addMenu" method="post" id=frmMenu>
			<input type=hidden id=code name=code>
			<table>
				<tr>
					<td align=right>메뉴명</td>
					<td><input type=text name=menuname id=menuname></td>
				</tr>
				<tr>
					<td align=right>가격</td>
					<td><input type=number name=price id=price></td>
				</tr>
				<tr>
					<td colspan=2 align=right>
						<input type=submit value="추가">
						<input type=button value="삭제" id=btnDelete>
						<input type=reset value="비우기">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>	
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#selMenu option',function(){
	console.log($(this).val()+","+$(this).text());
	$('#code').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
	$('#menuname').val(ar[0]);
	$('#price').val(ar[1]);
	return false;
})
.on('click','#btnDelete',function(){
	let url="/study/deleteMenu?code="+$('#code').val();
	console.log(url);
	document.location=url;
	return false;
})
.on('submit','#frmMenu',function(){
	if($('#menuname').val()=='' || $('#price').val()==''){
		alert('값을 입력해주세요');
		return false;
	}
	return true;
})
</script>
</html>