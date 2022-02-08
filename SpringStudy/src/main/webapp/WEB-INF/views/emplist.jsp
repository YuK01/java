<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 명단</title>
</head>
<style>
	table{
		border-collapse:collapse;
	}
	td,th{
		border:1px solid black;
	}
</style>
<body>
<h3>직원 사번은 100~206까지 존재함</h3><br>
<input type=text id=txtKeyword>
<button id=btnShow>직원명단조회</button>
<table id=tblEmp>
	<thead>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>매니저아이디</th>
			<th>입사일자</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script>
$(document)
.on('click','#btnShow',function(){
	$('#txtKeyword').val($.trim($('#txtKeyword').val()));
	$.ajax({url:"/study/empview",
			data:{kw:$('#txtKeyword').val()},
			datatype:"json",
			method:"post",
			beforeSend:function(){
// 				console.log("ajax start");
				$('#tblEmp tbody').empty();
			},
			success:function(txt){
				console.log(txt)
				for(i=0;i<txt.length;i++){
					let str='<tr><td>'+txt[i]['emp_id']+'</td><td align=center>'+
							txt[i]['emp_name']+'</td><td align=center>'+txt[i]['phone']+
							'</td><td align=center>'+txt[i]['m_id']+'</td><td>'+
							txt[i]['hire_d']+'</td></tr>'
// 					console.log(str);
					$('#tblEmp tbody').append(str);
				}
			}})
})
</script>
</html>