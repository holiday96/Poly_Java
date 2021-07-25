<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="bg-light rounded p-2">
    <table class="display" id="table_id">
        <thead>
        <tr>
            <th>#</th>
            <th>Username</th>
            <th>Password</th>
            <th>Remember</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="item" varStatus="theUser">
            <tr>
                <th>${theUser.count}</th>
                <td>${item.username}</td>
                <td><input type="password" class="text-muted f-w-400 bg-transparent" readonly
                           style="border-style: none; width: 150px;" value="${item.password}"/></td>
                <td>${item.remember?'Yes':'No'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>