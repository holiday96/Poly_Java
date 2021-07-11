<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 1</title>
</head>
<body>
<c:if test="${empty img && empty doc}">
    <h1>Upload</h1>
    <form action="/lab/3/bai1" method="post" id="upload" enctype="multipart/form-data">
        Hình ảnh: <input name="photo-file" type="file">
        <br>
        Tài liệu: <input name="doc-file" type="file">
    </form>
    <hr>
    <button type="submit" form="upload">Upload</button>
</c:if>
<c:if test="${not empty img && not empty doc }">
    <h2>1. Hình: ${img.name }</h2>
    <div class="lab3-bai1-image">
        <img src="/files/${img.name }">
    </div>
    <br>
    <h2>2. Tài liệu: ${doc.name }</h2>
    <div class="btn">
        <a href="/files/${doc.name }"> Tải về </a>
    </div>
</c:if>
</body>