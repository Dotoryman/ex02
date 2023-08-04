<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel-heading">Board Modify Page</div>
		<div class="panel-body">
			<form role="form" action="/board/modify" method="post">
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name="bno" readonly
						value='<c:out value="${board.bno}"></c:out>'>
				</div>
				<div class="form-group">
					<label>Title</label> <input class="form-control" name="title"
						 value='<c:out value="${board.title}"></c:out>'>
				</div>
				<div class="form-group">
					<label>Content</label>
					<textarea class="form-control" rows="4" cols="30" name="content"><c:out
							value="${board.content}"></c:out></textarea>
				</div>
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name="writer"
						value='<c:out value="${board.writer}"></c:out>' readonly>
				</div>
				<div class="form-group">
					<label>RegDate</label> <input class="form-control" name="regDate"
						value=<fmt:formatDate pattern="yyyy-MM-dd" value= "${board.regdate }" />
						readonly>
				</div>
				<div class="form-group">
					<label>UpdateDate</label> <input class="form-control"
						name="updateDate"
						value=<fmt:formatDate pattern="yyyy-MM-dd" value= "${board.updatedate }" />
						readonly>
				</div>
				<button type="submit" class="btn btn-default" data-oper="modify">Submit</button>
				<button type="submit" class="btn btn-danger" data-oper="remove">Remove</button>
				<button type="reset" class="btn btn-info" data-oper="list">List</button>
			</form>
		</div>
	</div>
</div>

<script>
	$(document).ready(function () {
		var formObj = $('form');
		$('button').on('click', function () {
			//dataset.oper 속성값을 활용
			var operation = $(this).data('oper');
			if (operation == 'remove'){
				formObj.attr('action', '/board/remove'); // form.action = /board/remove
			} else if (operation =='list'){
				location.href = '/board/list'
				return;
			}
			formObj.submit(); // submit이벤트 호출~
		})
	})
</script>





<jsp:include page="../includes/footer.jsp"></jsp:include>