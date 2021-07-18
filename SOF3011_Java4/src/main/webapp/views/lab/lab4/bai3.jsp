<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 4 Bài 3</title>
</head>
<body>
<div class="container my-5 py-5 rounded">
    <div class="card" style="width: 18rem;">
        <div class="card-title text-center fs-3 fw-bold bg-dark text-light py-3 rounded-top">${item.name}</div>
        <img src="${item.image}" class="mx-2 rounded-2" alt="image">

        <ul class="list-group list-group-flush px-4">
            <li class="list-group-item fw-lighter fst-italic">Giá gốc: 
            	<span class="text-decoration-line-through">
            		<fmt:formatNumber value="${item.price}" />
            	</span>
            </li>
            <li class="list-group-item fs-5 text-danger">Giá mới: 
            	<c:set var="newPrice" value="${item.price*(1-item.discount)}" />
            	<fmt:formatNumber value="${newPrice}" />
            </li>
            <li class="list-group-item">Mức giá: 
            	<c:choose>
            		<c:when test="${newPrice < 10}"><span class="text-primary fw-bold fs-5">Giá thấp</span></c:when>
            		<c:when test="${newPrice > 100}"><span class="text-danger fw-bold fs-5">Giá cao</span></c:when>
            		<c:otherwise>Bình thường</c:otherwise>
            	</c:choose>
            </li>
        </ul>
        <div class="card-body">
            <h5 class="card-title text-center">Ngày: 
            	<fmt:formatDate value="${item.date}" type="date" pattern = "dd/MM/yyyy"/>
            </h5>
        </div>
    </div>
</div>
</body>