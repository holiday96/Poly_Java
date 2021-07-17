<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 1 😗😗</title>
</head>
<body>
<div class="container py-5">
    <c:if test="${empty name }">
        <form action="<c:url value='/lab/1' />" id="formName" method="GET">
            <p class="title-name">Please insert your name</p>
            <div class="input-group">
                <input type="text" name="name" id="name" placeholder="Nhập tên của bạn">
                <button type="submit" class="btn-name">Apply</button>
            </div>
        </form>
    </c:if>
    <c:if test="${not empty name }">
        <p class="title-name">Hi, ${name}</p>
        <form action="<c:url value='/lab/1' />" id="formName" method="GET">
            <div class="calculator-form">
                <p class="title-lab1">THÔNG TIN HÌNH CHỮ NHẬT</p>
                <div class="input-form">
                    <span>Chiều rộng: </span> <input type="text" name="height"
                                                     id="height" placeholder="Nhập chiều rộng">
                </div>
                <div class="input-form">
                    <span>Chiều dài: </span> <input type="text" name="width" id="width" placeholder="Nhập chiều dài">
                </div>
                <button id="calculate" type="submit">Tính</button>

                <input type="hidden" name="name" value="${name}">
            </div>
        </form>
        <c:if test="${not empty message }">${message}</c:if>
        <c:if test="${not empty c && not empty s}">
            <div class="result-form">
                <p class="title-result">KẾT QUẢ</p>
                <p class="result">Chu vi: ${c}</p>
                <p class="result">Diện tích: ${s}</p>
            </div>
        </c:if>
    </c:if>
</div>
</body>