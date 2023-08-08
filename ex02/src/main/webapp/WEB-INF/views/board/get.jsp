<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel-heading">Board Register</div>
		<div class="panel-body">
			<!-- <form role="form" action="/board/register" method="post"> -->
			<div class="form-group">
				<label>Bno</label> <input class="form-control" name="bno" readonly
					value='<c:out value="${board.bno}"></c:out>'>
			</div>
			<div class="form-group">
				<label>Title</label> <input class="form-control" name="title"
					readonly value='<c:out value="${board.title}"></c:out>'>
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea class="form-control" rows="4" cols="30" name="content"
					readonly><c:out value="${board.content}"></c:out></textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input class="form-control" name="writer"
					value='<c:out value="${board.writer}"></c:out>' readonly>
			</div>
			<%-- 			<button class="btn btn-default"
				onclick="location.href='modify?bno=${board.bno}'">Modify</button>
			<button type="submit" class="btn btn-info" data-oper="list">List</button> --%>
			<!-- </form> -->


			<form id="operForm" action="/board/modify" method="get">
				<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }" />'> 
					<input	type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }" />'> 
					<input type="hidden" name="amount" value='<c:out value="${cri.amount }" />'>
					<input type="hidden" name="type" value='<c:out value="${cri.type }" />'>
					<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }" />'>
			</form>
			<button data-oper="modify" class="btn btn-default">Modify</button>
			<button data-oper="list" class="btn btn-default">list</button>
		</div>
	</div>
</div>
<!-- 댓글등록 시작 -->
<div>
	<form id="replyFrm">
		<input type="hidden" name="bno" value="294">
		<input type="hidden" name="replyer" value="카눈">
		<input type="text" name="reply">
		<button type="button" id="addReply">댓글등록</button>
	</form>
</div>
<!-- 댓글등록 끝 -->

<!-- 댓글목록 시작 -->
<div id="replyList"></div>
<!-- 댓글목록 끝 -->
<script src="/resources/js/reply.js"></script>

<script>
	/* 	$(document).ready(function() {
	 var formObj = $('form');
	 $('button').on('click', function() {
	 //dataset.oper 속성값을 활용
	 var operation = $(this).data('oper');
	 if (operation == 'list') {
	 location.href = '/board/list'
	 return;
	 }
	 formObj.submit(); // submit이벤트 호출~
	 })
	 })
	 */
	var operForm = $('form')
	$('button[data-oper="modify"]').on('click', function() {
		operForm.attr('action', '/board/modify').submit();
	})

	var operForm = $('form')
	$('button[data-oper="list"]').on('click', function() {
		operForm.find('#bno').remove()//파라미터로 글번호는 필요없어서 지우기
		operForm.attr('action', '/board/list').submit();
	})
</script>





<jsp:include page="../includes/footer.jsp"></jsp:include>