<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<c:if test="${empty user.movies}">
    <div class="container text-center">
        <h1 class="mb-5" style="color: #ff6500;">List Empty!!</h1>
        <h3 style="color: #ffa500e3;">Let's go back to the homepage<br/>And find something interesting.</h3>
        <div>
            <img src="../templates/img/peachcat-go.gif" alt="favorite-img"/>
        </div>
        <a href="/home" class="btn btn-warning">Go Home</a>
    </div>
</c:if>
<c:if test="${not empty user.movies}">
    <ul class="d-flex flex-wrap justify-content-evenly">
        <c:forEach items="${user.movies}" var="i">
            <li class="film-item item mx-3 mb-4" style="width: 140px;">
                <a href="/movie?id=${i.id}" class="rounded">
                    <img src="${i.poster}" class="rounded" height="200" alt="item-poster"/>
                </a>
                <a href="/movie?id=${i.id}" style="font-size: 15px;" class="d-flex text-warning text-center">${i.title}</a>
            </li>
        </c:forEach>
    </ul>
</c:if>