<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="text-center">
    <a href="/lab/lab2/bai5/b" class="btn btn-primary text-center">Press B</a>
    <a href="/lab/lab2/bai5/c" class="btn btn-warning text-center">Press C</a>
    <a href="/lab/lab2/bai5/d" class="btn btn-success text-center">Press D</a>
    <h1>${message}</h1>
    <h1>${param.message}</h1>
</div>

<script>
    $(document).ready(function () {
        $('#lab2').addClass("active");
    });
</script>