<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 2 Bài 1</title>
</head>
<body>
<div class="container py-5">
    <h1 class="title">Tam giác</h1>
    <form action="/lab/2/bai1" method="POST">
        <input class="input" type="text" name="a" placeholder="Nhập cạnh a"><br>
        <input class="input" type="text" name="b" placeholder="Nhập cạnh b"><br>
        <input class="input" type="text" name="c" placeholder="Nhập cạnh c"><br>
        <hr>
        <button class="button-custom" formaction="/lab/2/bai1?action=chu-vi">Tính chu vi</button>
        <button class="button-custom" formaction="/lab/2/bai1?action=dien-tich">Tính diện tích</button>
    </form>
    <h2 class="message">${message}</h2></div>
</body>