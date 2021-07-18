<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">Remember</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="item" varStatus="theUser">
    <tr>
        <th scope="row">${theUser.count}</th>
        <td>${item.username}</td>
        <td><input type="password" class="text-muted f-w-400 bg-transparent" readonly style="border-style: none; width: 150px;" value="${item.password}"/></td>
        <td>${item.remember?'Yes':'No'}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>