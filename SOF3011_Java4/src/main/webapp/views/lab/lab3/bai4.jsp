<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 4</title>
</head>
<body>
<h1>Login</h1><br>
<c:if test="${not empty message}">
    <div class="alert alert-info" style="width: 300px;" role="alert">
            ${message}
    </div>
</c:if>
<form action="/lab/3/bai4" method="post" id="formLogin">
    <div style="width: 300px;">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="username" id="username" value="${username}"
                   placeholder="Nhập tên đăng nhập"
                   required>
            <label for="username" class="form-label">Tên đăng nhập</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" name="password" id="password" value="${password}"
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

<script>
    //     $('#submitLogin').click(function (e) {
    //         e.preventDefault();
    //         Swal.fire({
    //             position: 'top-end',
    //             icon: 'success',
    //             title: '${message}',
    //             showConfirmButton: false,
    //             timer: 1500
    //         }).then(function () {
    //                 $('#formLogin').submit()
    //             }
    //         )
    //     })
</script>
</body>