<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 4 Bài 4</title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach items="${items}" var="item">
            <div class="col g-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-title text-center fs-3 fw-bold bg-dark text-light py-3 rounded-top">${item.name}</div>
                    <img src="${item.image}" class=" mx-2 rounded-2 " alt="image ">
                    <div class="card-body">
                        <div class="card-title text-center">
                            <span class="text-decoration-line-through px-2 fst-italic">
                            	<fmt:formatNumber value="${item.price}"/>
                            </span>
                            <span class="text-danger fs-5 fw-bold px-2">
                                <c:set var="newPrice" value="${item.price*(1-item.discount)}"/>
                                <fmt:formatNumber value="${newPrice}"/>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>