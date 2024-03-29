<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 4</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute; top: 10px; right: 10px;">
        <div class="toast-header">
            <img src="https://img.icons8.com/officel/16/fa314a/information.png" class="rounded me-2" alt="...">
            <strong class="me-auto">Thông báo</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
                ${message}
        </div>
    </div>
</c:if>
<div class="container py-5">
    <h1>Login</h1><br>
    <form action="/lab/3/bai4" method="post" id="formLogin">
        <div style="width: 300px;">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="username" id="username" value="${username}"
                       placeholder="Nhập tên đăng nhập"
                       required>
                <label for="username" class="form-label">Tên đăng nhập</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" id="password"
                       value="${password}"
                       placeholder="Nhập mật khẩu"
                       required>
                <label for="password" class="form-label">Mật khẩu</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" name="remember" id="remember"
                       <c:if test="${not empty remember}">checked</c:if>>
                <label class="form-check-label" for="remember">Remember me?</label>
            </div>
            <hr>
            <button class="btn btn-primary" id="submitLogin">Login</button>
        </div>
    </form>
</div>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: false});
        $("#myToast").toast('show');
    });
</script>
</body>