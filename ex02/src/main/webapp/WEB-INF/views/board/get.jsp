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
			<button class="btn btn-default"
				onclick="location.href='modify?bno=${board.bno}'">Modify</button>
			<button type="submit" class="btn btn-info" data-oper="list">List</button>
			<!-- </form> -->
		</div>
	</div>
</div>


<script>
	$(document).ready(function() {
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
</script>





<jsp:include page="../includes/footer.jsp"></jsp:include>