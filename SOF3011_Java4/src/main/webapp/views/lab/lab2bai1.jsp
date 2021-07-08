<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<div class="formRegister">
	<h1 class="title">Tam giác</h1>
	<form action="<c:url value='/lab/2/bai1' />" method="POST">
		<input class="input" type="text" name="a" placeholder="Nhập cạnh a"><br>
		<input class="input" type="text" name="b" placeholder="Nhập cạnh b"><br>
		<input class="input" type="text" name="c" placeholder="Nhập cạnh c"><br>
		<hr>
		<button class="btn" formaction="/lab/2/bai1?action=chu-vi">Tính chu vi</button>
		<button class="btn" formaction="/lab/2/bai1?action=dien-tich">Tính diện tích</button>
	</form>
	<h2 class="message">${message}</h2>
</div>