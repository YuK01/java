<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실관리</title>
</head>
<body>
	<table>
		<tr>
			<td>
				<select id=selRoom style='width:200px' size=10>
<%-- 					<c:forEach var="room" items="${room }"> --%>
<%-- 						<option value=${room.code }>${room.name },${room.type_name },${room.howmany },${room.howmuch }</option> --%>
<%-- 					</c:forEach> --%>
				</select>
			</td>
			<td>
				<form id=frmRoom action="/study/addRoom">
					<input type=hidden id=code name=code>
					<table>
						<tr>
							<td align=right>객실명:</td>
							<td><input type=text name=roomname id=roomname></td>
						</tr>
						<tr>
							<td align=right>타입:</td>
							<td>
								<select id=roomtype name=roomtype>
									<option value="0">-</option>
<%-- 									<c:forEach var="type" items="${type }"> --%>
<%-- 										<option value=${type.code }>${type.name }</option> --%>
<%-- 									</c:forEach> --%>
								</select>
							</td>
						</tr>
						<tr>
							<td align=right>숙박가능인원:</td>
							<td><input type=number name=howmany id=howmany></td>
						</tr>
						<tr>
							<td align=right>숙박비:</td>
							<td><input type=number name=howmuch id=howmuch></td>
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
.ready(function(){
	$.ajax({url:"/study/roomlist",
			datatype:'json',
			method:'post',
			success:function(txt){
// 				console.log(txt);
				for(i=0;i<txt.length;i++){
					let str="<option value="+txt[i]['code']+">"+txt[i]['name']+","+
							txt[i]['type_name']+","+txt[i]['howmany']+","+txt[i]['howmuch']+"</option>"
					console.log(str);
					$('#selRoom').append(str);
				}
			}})
	$.ajax({url:"/study/typelist",
			datatype:'json',
			method:'post',
			success:function(txt){
// 				console.log(txt);
				for(i=0;i<txt.length;i++){
					let str="<option value="+txt[i]['code']+">"+txt[i]['name']+"</option>"
					console.log(str);
					$('#roomtype').append(str);
				}
			}})
})
.on('click','#selRoom option',function(){
	console.log($(this).val()+","+$(this).text());
	$('#code').val($(this).val());
	let str=$(this).text();
	let ar=str.split(',');
// 	console.log(ar);
	$('#roomname').val(ar[0]);
	$('#howmany').val(ar[2]);
	$('#howmuch').val(ar[3]);
	let roomtype=ar[1];
	console.log("roomtype:"+roomtype);
	$('#roomtype').val('');
	$('#roomtype option').each(function(){
		if($(this).text()==roomtype) {
			$(this).prop('selected','selected');
			return false;
		}
	})
	return false;
})
.on('click','#btnDelete',function(){
	let url="/study/deleteRoom?code="+$('#code').val();
	console.log(url);
	document.location=url;
	return false;
})
.on('submit','#frmRoom',function(){
	$('#roomname').val($.trim($('#roomname').val()));
	$('#roomtype').val($.trim($('#roomtype').val()));
	$('#howmany').val($.trim($('#howmany').val()));
	$('#howmuch').val($.trim($('#howmuch').val()));
	
	if($('#roomname').val()=="" || $('#roomtype').val()=="" || $('#howmany').val()=="" || $('#howmuch').val()=="") {
		alert("빈칸없이 채워주세요");
		return false;
	}		
	return true;
})
</script>
</html>