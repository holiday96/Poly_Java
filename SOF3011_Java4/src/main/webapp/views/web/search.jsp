<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<ul class="d-flex flex-wrap justify-content-evenly">
    <c:forEach items="${movies}" var="i">
        <li class="film-item item mx-3 mb-4" style="width: 140px;">
            <a href="/movie?id=${i.id}" class="rounded">
                <img src="${i.poster}" class="rounded" height="200" alt="item-poster"/>
            </a>
            <a href="/movie?id=${i.id}" style="font-size: 15px;" class="d-flex text-warning text-center">${i.title}</a>
        </li>
    </c:forEach>
</ul>
