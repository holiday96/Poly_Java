<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 3 Find by User</title>
</head>
<body>
<div class="container p-4"
     style="margin-top: 6%;background-color: #FF3CAC;background-image: linear-gradient(15deg, #FF3CAC 0%, #784BA0 50%, #2B86C5 100%);">
    <div class="text-end">
        <a href="/lab/6/bai3" class="btn btn-warning">Back</a>
    </div>
    <div class="row">
        <div class="col-sm-3 p-2 m-2 text-center rounded"
             style="background-color: #A9C9FF;background-image: linear-gradient(180deg, #A9C9FF 0%, #FFBBEC 100%);">
            <img class="rounded-circle my-4" style="width: 60%;" src="<c:url value='/templates/img/avatar.jpg' />"
                 alt="avatar">
            <p class="">${user.id}</p>
            <p class="py-2">${user.fullname}</p>
            <p class="">${user.email}</p>
        </div>
        <div class="col-sm p-4 m-2 bg-light rounded">
            <table id="table_id" class="display">
                <thead>
                <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Views</th>
                    <th>Active</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${videos}" var="i" varStatus="count">
                    <tr>
                        <td>${count.count}</td>
                        <td>${i.id}</td>
                        <td>${i.title}</td>
                        <td>${i.views}</td>
                        <td>${i.active}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#table_id').DataTable({
            searching: false,
        });
    });
</script>
</body>