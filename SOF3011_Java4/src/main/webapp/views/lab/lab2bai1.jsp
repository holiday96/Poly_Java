<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<h1>Tam giác</h1>
<form action="<c:url value='/lab/2/bai1' />" method="POST">
	<input type="text" name="a" placeholder="Nhập cạnh a"><br>
	<input type="text" name="b" placeholder="Nhập cạnh b"><br>
	<input type="text" name="c" placeholder="Nhập cạnh c"><br>
	<button formaction="/lab/2/bai1?action=chu-vi">Tính chu vi</button>
	<button formaction="/lab/2/bai1?action=dien-tich">Tính diện tích</button>
</form>
<h2>${message}</h2>