<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="controlCafe.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
<title>K Cafe</title>
</head>
<body>
	<div id=head>
		<div>
			<img src="${pageContext.request.contextPath}\image\coffeelogo.png">&nbsp;&nbsp;
			<span>k cafe</span>
		</div>
	</div>
	<hr>
    <table id=tb>
        <tr>
            <td valign=top>
                <table id='bound'>
                    <tr>
                    	<td colspan=2>
                    		<div class="hr-sect">메 뉴 목 록</div>
                    	</td>
                    </tr>
                    <tr>
                        <td colspan=2 align=right>
                            <button id=btnMenu>메뉴관리</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan=2 valign=top align=center>
                            <select id=selMenu size=13></select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td align=right style="width:100px; 
        				font-family: 'Nanum Gothic Coding', monospace;">메뉴명</td>
                        <td><input type=text id=name readonly></td>
                    </tr>
                    <tr>
                        <td align=right style="width:100px;
        				font-family: 'Nanum Gothic Coding', monospace;">금 액</td>
                        <td><input type=number id=price readonly></td>
                    </tr>
                    <tr>
                        <td align=right style="width:100px; 
        				font-family: 'Nanum Gothic Coding', monospace;">수 량</td>
                        <td><input type=number id=qty min=1 style='width:50px;'></td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan=2 align=center>
                        <button id=btnReset>비우기</button>
                        <button id=btnAdd>주문추가</button>
                        </td>
                    </tr>
                </table>
            </td>
            <td style="width:50px;"></td>
            <td valign=top>
                <table id='bound'>
                    <tr>
                    	<td colspan=2>
                    		<div class="hr-sect">주 문 목 록</div>
                    	</td>
                    </tr>
                    <tr>
                        <td colspan=2 align=right>
                            <button id=btnSum>매출내역</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan=2 valign=top align=center>
                            <select id=selOrder size=13></select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td align=right style="width:100px; 
                        font-family: 'Nanum Gothic Coding', monospace;">모바일</td>
                        <td><input type=phone id=mobile size=13></td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td align=right style="width:100px;
                        font-family: 'Nanum Gothic Coding', monospace;">총 액</td>
                        <td><input type=number id=total size=13></td>
                    </tr>
                    <tr>
                        <td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan=2 align=center>
                        <button id=btnCancel>주문취소</button>
                        <button id=btnOrder>주문완료</button></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <hr>
    <div id=foot>
    	<div>
		    카 페 명 : k cafe<br><br>
		    주 소 : 고객님이 있는 곳 어디든<br><br>
		    전화번호 : xxx)yyyy-xxxx<br><br>
    	</div>
    </div>
    <div id=dlgMenu style='display:none;' title='메뉴관리'>
        <table>
            <tr>
                <td>
                    <select id=selMenu1 size=10></select>
                </td>
                <td>&nbsp;&nbsp;</td>
                <td>
                    <table>
                    <tr>
                        <td>메뉴코드</td><td><input type=number id=code style="width:120px" readonly></td>
                    </tr>
                    <tr>
                        <td>메뉴명</td><td><input type=text id=_name style="width:120px"></td>
                    </tr>
                    <tr>
                        <td>단가(가격)</td><td><input type=number id=_price min=500 step=500 style='width:50px'>원</td>
                    </tr>
                    <tr>
                        <td colspan=2 align=center>
                            <button id=btnClean>비우기</button>&nbsp;
                            <button id=btnDone>작성완료</button>&nbsp;
                        </td>
                    </tr>                    
                    <tr>
                    	<td colspan=2>&nbsp;</td>
                    </tr>
                    <tr>
                    	<td colspan=2 align=center>
                    		<div>
                    		    - 사 용 방 법 -<br><br>
                    			① 새 메뉴 추가<br>
                    			메뉴명, 단가(가격) 입력<br><br>
                    			② 메뉴 수정<br>
                    			수정하고자하는 메뉴 클릭<br>
                    			메뉴코드 확인 및 메뉴명, 단가(가격) 입력<br><br>
                    			③ 메뉴 삭제<br>
                    			삭제하고자 하는 메뉴 클릭<br>
                    			메뉴코드 확인
                    		</div>
                    	</td>
                    </tr>
                    </table>
                </td>
            </tr>    
        </table>        
    </div>
    <div id=dlgSl style='display:none;' title='매출요약'>
        <table style="width:400px;">
        	<tr>
            	<th align=center>
                    판매내역
                </th>
                <th align=center>
                    메뉴별 판매내역
                </th>
            </tr>
            <tr>
            	<td>
                    <select id=selSales size=10></select>
                </td>
                <td>
                    <select id=SumMenu size=10></select>
                </td>
            </tr>
            <tr>
            	<td colspan=2 style="height:25px;"></td>
            </tr>
            <tr>            	
                <th align=center>
                    고객별 판매내역
                </th>
                <th align=center>
                    날짜별 판매금액
                </th>
            </tr>
            <tr>
                <td>
                    <select id=SumC size=10></select>
                </td>
                <td>
                    <select id=SumD size=10></select>
                </td>
            </tr>    
        </table>        
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
<script src="controlCafe.js">
</script>
</html>