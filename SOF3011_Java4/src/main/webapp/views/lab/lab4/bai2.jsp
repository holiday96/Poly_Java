<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 4 Bài 2</title>
</head>
<body>
<div class="container my-5 py-5 rounded"
     style="background-color: #D9AFD9; background-image: linear-gradient(30deg, #D9AFD9 0%, #97D9E1 100%);">
    <h1 class="text-primary">User Management</h1>
    <div class="row g-5">
        <div class="col-md-4">
            <h4 class="text-secondary">User Edition</h4>
            <%@include file="/views/lab/lab4/bai2form.jsp" %>
        </div>
        <div class="col-md-8 px-3">
            <h4 class="text-secondary">User List</h4>
            <%@include file="/views/lab/lab4/bai2table.jsp" %>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#table_id').DataTable({});
    });
</script>
</body>