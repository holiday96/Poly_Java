<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<form action="/lab/lab2/bai1/ok" method="post" class="mb-3 text-center">
    <button class="btn btn-primary me-2">OK 1</button>
    <button formmethod="get" class="btn btn-warning me-2">OK 2</button>
    <button formaction="/lab/lab2/bai1/ok3" class="btn btn-success">OK 3</button>
</form>
<c:if test="${not empty method}">
	<div class="result">
		<span class="title">Result: </span>${method}
	</div>
</c:if>

<script>
    $(document).ready(function () {
        $('#lab2').addClass("active");
    });
</script>