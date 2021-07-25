<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 4</title>
</head>
<body>
<div class="container bg-light p-4" style="margin-top: 6%;">
    <p class="fs-5">Truy vấn và hiển thị 10 videos ngẫu nhiên</p>
    <a href="/lab/6/bai4/random" class="btn btn-primary mb-3">Get random 10 videos</a>
    <p class="fs-5">Tổng số lượt thích video theo năm</p>
    <form action="/lab/6/bai4/year" method="get">
        <div class="row">
            <select name="year" class="col-sm-3">
                <option selected disabled>** Select year **</option>
                <c:forEach items="${years}" var="year">
                    <option value="${year}">${year}</option>
                </c:forEach>
            </select>
            <button class="col-sm-1 btn btn-primary">Find</button>
        </div>
    </form>
</div>
</body>