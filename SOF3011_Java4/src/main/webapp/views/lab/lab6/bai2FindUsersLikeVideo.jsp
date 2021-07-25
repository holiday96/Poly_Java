<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 2 Find Users like movie</title>
</head>
<body>
<div class="container p-4"
     style="margin-top: 6%;background-color: #FF3CAC;background-image: linear-gradient(15deg, #FF3CAC 0%, #784BA0 50%, #2B86C5 100%);">
    <div class="text-end">
        <a href="/lab/6/bai2" class="btn btn-warning">Back</a>
    </div>
    <div class="p-4 m-2 bg-light rounded">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Fullname</th>
                <th>Email</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="i" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${i.id}</td>
                    <td>${i.fullname}</td>
                    <td>${i.email}</td>
                    <td>${i.admin?"Admin":"User"}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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