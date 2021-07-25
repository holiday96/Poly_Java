<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 3 Movies favor by Months</title>
</head>
<body>
<div class="container p-4"
     style="margin-top: 6%;background-color: #FF3CAC;background-image: linear-gradient(15deg, #FF3CAC 0%, #784BA0 50%, #2B86C5 100%);">
    <div class="text-end">
        <a href="/lab/6/bai3" class="btn btn-warning">Back</a>
    </div>
    <div class="fw-bold">
        <p class="text-light fs-5">Những video được yêu thích trong các tháng: 
        	<c:forEach items="${months}" var="month">${month} - </c:forEach>
        </p>
    </div>
    <div class="p-4 m-2 bg-light rounded">
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
                    <td>${i.active?"Yes":"No"}</td>
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