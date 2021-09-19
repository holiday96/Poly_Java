<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="form mb-3 text-danger fw-bold">${uri}</div>
<c:if test="${not empty param.error or not empty message}">
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
        </symbol>
    </svg>
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
            <use xlink:href="#exclamation-triangle-fill"/>
        </svg>
        <strong>${param.error} ${message}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<c:if test="${empty content}">
    <div class="form mb-3">
        <c:if test="${empty user}">
            <div class="title mb-3">Login</div>
            <form action="/lab/lab7/account/login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" name="username" id="username"
                           value="${cookie.username.value}"
                           required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="password"
                           value="${cookie.password.value}"
                           required>
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" name="remember"
                           id="remember" ${not empty cookie.username.value?"checked":""}>
                    <label class="form-check-label" for="remember">Remember me</label>
                </div>
                <button class="btn btn-primary">Login</button>
            </form>
        </c:if>
        <c:if test="${not empty user}">
            <div class="title">User Info</div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><b>Username:</b> ${user.username}</li>
                <li class="list-group-item"><b>Fullname:</b> ${user.fullname}</li>
                <li class="list-group-item"><b>Email:</b> ${user.email?user.email:'none'}</li>
                <li class="list-group-item"><b>Role:</b> ${user.admin?'Admin':'User'}</li>
                <li class="list-group-item"><b>Active:</b> ${user.activated?'Yes':'No'}</li>
            </ul>
        </c:if>
    </div>
</c:if>
<c:if test="${not empty content}">
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z"/>
        </symbol>
    </svg>
    <div class="alert alert-info alert-dismissible fade show" role="alert">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
            <use xlink:href="#info-fill"/>
        </svg>
        <strong>${content}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>

<div class="row justify-content-center mb-3">
    <a href="/lab/lab7/account/edit" class="col-auto mx-2 btn btn-primary">Edit</a>
    <a href="/lab/lab7/account/chgpwd" class="col-auto mx-2 btn btn-info">Change Password</a>
    <a href="/lab/lab7/oder" class="col-auto mx-2 btn btn-warning">Oder</a>
</div>
<div class="row justify-content-center">
    <a href="/lab/lab7/admin/home/index" class="col-auto mx-2 btn btn-success">Admin Home</a>
    <a href="/lab/lab7/admin/#" class="col-auto mx-2 btn btn-secondary">Admin #</a>
    <c:if test="${not empty user}">
        <a href="/lab/lab7/logout" class="col-auto mx-2 btn btn-danger">Logout</a>
    </c:if>
</div>


<script>
    $(document).ready(function () {
        $('#lab1').addClass("active");
    });
</script>
