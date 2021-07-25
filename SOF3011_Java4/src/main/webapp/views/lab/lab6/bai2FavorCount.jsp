<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 2 Favor Count</title>
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
                <th>Video's Title</th>
                <th>Favorite Count</th>
                <th>First like Date</th>
                <th>Most recent likes</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${movies}" var="i" varStatus="count">
                <tr>
                    <td>${count.count}</td>
                    <td>${i.title}</td>
                    <td>${i.likes}</td>
                    <td><fmt:formatDate value="${i.oldest}" type="date" pattern = "dd/MM/yyyy"/></td>
                    <td><fmt:formatDate value="${i.newest}" type="date" pattern = "dd/MM/yyyy"/></td>
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