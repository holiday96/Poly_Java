<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 1</title>
</head>
<body>
<div class="container py-5">
    <c:if test="${empty img && empty doc}">
        <div style="width: 500px;">
            <h1>Upload</h1><br>
            <form action="/lab/3/bai1" method="post" id="upload" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="photo-file" class="form-label">Hình ảnh</label>
                    <input class="form-control" type="file" name="photo-file" id="photo-file">
                </div>
                <div class="mb-3">
                    <label for="doc-file" class="form-label">Tài liệu</label>
                    <input class="form-control" type="file" name="doc-file" id="doc-file">
                </div>
            </form>
            <hr>
            <button class="btn btn-primary" type="submit" form="upload">Upload</button>
        </div>
    </c:if>
    <c:if test="${not empty img && not empty doc }">
        <h2>1/ Hình: </h2>
        <p>${img.name }</p>
        <div class="lab3-bai1-image">
            <img src="/files/${img.name }">
        </div>
        <br>
        <h2>2/ Tài liệu: </h2>
        <p>${doc.name }</p>
        <div class="btn">
            <a class="btn btn-success" href="/files/${doc.name }"> Tải về </a>
        </div>
    </c:if>
</div>
</body>