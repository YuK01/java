let total, mzxLn, price, menu_code;
$(document)
	.ready(function(){
		loadMenu();
		loadSales();
		total=maxLn=price=0;
		menu_code="";
		return false;
	})
//  --------------------------------------------------------------------- 메뉴선택
	.on('click','#selMenu',function() { // 주문추가
		menu1=$('#selMenu option:selected').text();
		ar=menu1.split('\u00A0');
		let menu=[];
		for(i = 0; i < ar.length; i++) {
			if($.trim(ar[i]) != '') menu.push(ar[i]);
		}
		price=menu[1];
		$('#name').val(menu[0]);
		$('#qty').val(1);
		$('#price').val(price);
	})
	.on('click','#btnReset',function() {
		$('#name,#price,#qty').val('');
	})
	.on('change','#qty',function() {
		$('#price').val(parseInt($('#qty').val())*price);
	})
	.on('click','#btnAdd',function() {
		if($('#name,#qty,#price').val()=='') return false;
		if(menu_code!='') menu_code+=';';
		menu_code+=$('#selMenu option:selected').val();
		if($('#name').val().length==maxLn) {
			order="<option>"+$('#name').val()+"\u00A0x"+$('#qty').val()+"\u00A0"+$('#price').val()+"</option>";
		} else {
			order="<option>"+$('#name').val().padEnd(2*(maxLn-$('#name').val().length)+1+$('#name').val().length,"\u00A0")+"x"+$('#qty').val()+
			"\u00A0"+$('#price').val()+"</option>";
		}
		total+=parseInt($('#price').val());
		$('#selOrder').append(order);
		$('#total').val(total);
		$('#name,#qty,#price').val('');
	})
//  --------------------------------------------------------------------- 주문확인
	.on('click','#btnOrder',function() {
		mcode=menu_code.split(';'); // 메뉴코드
		menu_code='';
		code=0;
		$('#selOrder option').each(function(){
			code=mcode[$(this).index()];
			if($('#mobile').val()!='') mobile=$('#mobile').val();
			else mobile='-';
			menu1=$(this).text();
			ar=menu1.split('\u00A0');
			let menu=[];
			for(i=0; i<ar.length; i++) {
				if ($.trim(ar[i]) != '') menu.push(ar[i]);
			}
			qty=menu[1].replace('x', '');
			total=menu[2];
			$.get('AddOrder', {mobile:mobile,menu_code:code,qty:qty,total:total},function(){
				
			})
		})
		$('#selOrder').empty();
		$('#mobile,#total').val('');
		total=0;
		return false;
	})
	.on('click','#btnCancel',function() {
		alert('주문을 취소하시겠습니까?');
		$('#selOrder').empty();
		$('#mobile,#total').val('');
		total=0;
		menu_code='';
	})
//  --------------------------------------------------------------------- 메뉴관리
	.on('click','#btnMenu',function() {
		$('#dlgMenu').dialog({
			width:600,
			open:function() {
				loadMenu1();
			},
			close:function() {
				//$('#selMenu').empty();
				loadMenu();
			}
		});
	})
	.on('click','#selMenu1',function() { // 주문추가
		$('#code').val($('#selMenu1 option:selected').val());
	})
	.on('click','#btnDone',function() {
		if($('#code').val()!=''){ // update/delete
			if($('#_name').val()!=''&& $('#_price').val()!='') {//update
				operation="UpdateMenu";
			} else {//delete
				operation = "DeleteMenu";
			}
		} else {
			if($('#_name').val()!='' && $('#_price').val()!='') {// insert
				operation="AddMenu";
			} else { // delete
				alert('사용방법을 확인하시고 입력해주세요.');
				return false;
			}
		}
		$.get(operation,{code:$('#code').val(),name:$('#_name').val(),price:$('#_price').val()},function(txt) {
			$('#_name,#_price,#code').val('');
			loadMenu1();
		}, 'text');
		return false;
	})
	.on('click','#btnClean',function(){
		$('#_name,#_price,#code').val('');
	})
//  --------------------------------------------------------------------- 판매내역
	.on('click','#btnSum',function() {
		$('#dlgSl').dialog({
			width: 630,
			height:700,
			open: function() {
				loadSales();
				loadSumM();
				loadSumC();
				loadSumD();
			}
		});
	})
//  --------------------------------------------------------------------- 함수
function loadMenu() { // 메뉴 불러오기
	$('#selMenu').empty();
	$.get('SelectMenu',{},function(txt) {
		if(txt=='') return false;
		let rec=txt.split(';');
		let field;
		for(i=0; i<rec.length; i++) {
			field=rec[i].split(',');
			if (field[1].length>maxLn) maxLn=field[1].length;
		}
		for(i=0; i<rec.length; i++) {
			field=rec[i].split(',');
			let Menu="";
			if (field[1].length==maxLn) {
				Menu="<option value='"+field[0]+"'>"+field[1]+"\u00A0"+field[2]+"</option>";
			} else {
				Menu="<option value='"+field[0]+"'>"+field[1]+field[2].padStart(2*(maxLn-field[1].length)+1+field[2].length,'\u00A0')+"</option>";
			}
			$('#selMenu').append(Menu);
		}
	}, 'text');
	return false;
}
function loadMenu1() { // (메뉴관리) 메뉴 불러오기
	$('#selMenu1').empty();
	$.get('SelectMenu', {}, function(txt) {
		if (txt=='') return false;
		let rec=txt.split(';');
		let field;
		for (i=0; i<rec.length; i++) { // 메뉴가 0일 경우 대비..
			field=rec[i].split(',');
			if (field[1].length>maxLn) maxLn=field[1].length;
		}
		for(i=0; i<rec.length; i++) {
			field=rec[i].split(',');
			let Menu="";
			if (field[1].length==maxLn) {
				Menu="<option value='"+field[0]+"'>"+field[1]+"\u00A0"+field[2]+"</option>";
			} else {
				Menu="<option value='"+field[0]+"'>"+field[1]+field[2].padStart(2*(maxLn-field[1].length)+1+field[2].length,'\u00A0')+"</option>";
			}
			$('#selMenu1').append(Menu);
		}
	}, 'text');
	return false;
}
function loadSales() { // 판매내역 불러오기
	$('#selSales').empty();
	$.get('SelectOrder',{},function(txt) {
		if (txt=='') return false;
		let rec=txt.split(';');
		let field;
		for (i=0; i<rec.length; i++) { // 메뉴가 0일 경우 대비..
			field=rec[i].split(',');
			if (field[1].length>maxLn) maxLn=field[1].length;
		}
		for (i=0; i<rec.length; i++){
			field=rec[i].split(',');
			let sales="";
			if (field[0].length==11){
				if(field[1].length==maxLn){
					sales="<option>"+field[0]+"\u00A0"+field[1]+"\u00A0x"+field[2]+"\u00A0"+field[3]+"</option>";
				} else {
					sales="<option>"+field[0]+"\u00A0"+field[1].padEnd(2*(maxLn-field[1].length)+1+field[1].length,"\u00A0")+"x"+field[2]+"\u00A0"+field[3]+"</option>";
				}
			} else {
				if(field[1].length==maxLn){
					sales="<option>"+field[0].padEnd(12,'\u00A0')+field[1]+"\u00A0x"+field[2]+"\u00A0"+field[3]+"</option>";
				} else {
					sales="<option>"+field[0].padEnd(12,'\u00A0')+field[1].padEnd(2*(maxLn-field[1].length)+1+field[1].length,"\u00A0")+"x"+field[2]+"\u00A0"+field[3]+"</option>";
				}
			}
			$('#selSales').append(sales);
		}
		$('#dlgSl h3').text('');
		$('#dlgSl table').before('<h3 align=center>판매일자: '+field[4]+'</h1>')
	},'text');
}
function loadSumM() {
	$('#SumMenu').empty();
	$.get('SumMenu',{},function(txt){
		if(txt=='') return false;
		let rec=txt.split(';');
		for(i=0;i<rec.length;i++){
			let field=rec[i].split(',');
			let sales="";
			if(field[0].length==maxLn){
				sales="<option>"+field[0]+"\u00A0x"+field[1]+"\u00A0"+field[2]+"</option>";
			}else{
				sales="<option>"+field[0].padEnd(2*(maxLn-field[0].length)+field[0].length+1,"\u00A0")+'x'+field[1]+'\u00A0'+field[2]+"</option>";
			}
			$('#SumMenu').append(sales);
		}
	},'text');
}
function loadSumC() {
	$('#SumC').empty();
	$.get('SumC',{},function(txt){
		if(txt=='') return false;
		let rec=txt.split(';');
		for(i=0;i<rec.length;i++){
			let field=rec[i].split(',');
			let sales="";
			if (field[0].length==11){
				sales="<option>"+field[0]+"\u00A0"+field[1]+"</option>";
			}else{
				sales="<option>"+field[0].padEnd(12,'\u00A0')+field[1]+"</option>";
			}
			$('#SumC').append(sales);
		}
	},'text');
}
function loadSumD() {
	$('#SumD').empty();
	$.get('SumD',{},function(txt){
		if(txt=='') return false;
		let rec=txt.split(';');
		for(i=0;i<rec.length;i++){
			let field=rec[i].split(',');
			let sales="<option>"+field[0]+"\u00A0"+field[1]+"</option>";
			$('#SumD').append(sales);
		}
	},'text');
}