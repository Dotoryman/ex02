<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블은 반응형 불가, div쓰셈</title>
</head>
<body>
	<form action="param">
		<table>
			<tr>
				<td><input name="list[0].code" value="c1"></td>
				<td><input name="list[0].codeNm" value="Cherry"></td>
			</tr>
			<tr>
				<td><input name="list[1].code" value="c2"></td>
				<td><input name="list[1].codeNm" value="사과"></td>
			</tr>
			<tr>
				<td><input name="list[2].code" value="c3"></td>
				<td><input name="list[2].codeNm" value="샌드위치"></td>
			</tr>
		</table>
		<button>등록!</button>
	</form>


	<form id="frm">
		<table>
			<tr>
				<td><input name="code" value="c1"></td>
				<td><input name="codeNm" value="Cherry"></td>
			</tr>
			<tr>
				<td><input name="code" value="c2"></td>
				<td><input name="codeNm" value="사과"></td>
			</tr>
			<tr>
				<td><input name="code" value="c3"></td>
				<td><input name="codeNm" value="샌드위치"></td>
			</tr>
		</table>
		<button type="button" id="btnAdd">Ajax등록!</button>
	</form>
	<script src="/resources/vendor/jquery/jquery.min.js"></script>
	<script src="/resources/js/json.min.js"></script>
	<script>
	$("#btnAdd").on("click", function () {
		//전송할 데이터 준비
		let list = [];
		let arr = $("#frm").serializeArray();
		for(i=0; i<arr.length; i=i+2){
			list.push({ [arr[i].name] : arr[i].value,
						[arr[i+1].name] : arr[i+1].value })
		}
		console.log(list);
		//Ajax 요청
		$.ajax({
			url: "/sample/addlist",
			method: "post",				//?nm=asd&cdnm=dsa /   []{}
			data: JSON.stringify(list), //querystring 또는  /  jsonstring
			contentType: "application/json",
			success: function(result) {
				console.log(" 응답결과는 : " , result);
			},
			}) 
	})
	</script>
</body>
</html>