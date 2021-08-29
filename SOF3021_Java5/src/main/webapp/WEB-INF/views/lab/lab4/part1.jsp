<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<c:if test="${empty result}">
    <c:if test="${not empty message}">
        <div class="result mb-3">${message}</div>
    </c:if>
    <form action="/lab/lab4/part1" method="post" class="form mx-auto" style="width: 450px" enctype="multipart/form-data">
        <div class="title mb-3">Login Form</div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Photo</span>
            </div>
            <div class="custom-file">
                <input class="form-control" type="file" name="photo" id="formFile" accept="image/png, image/jpeg">
            </div>
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" name="username" id="username" value="${cookie.user.value}">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" name="password" id="password">
        </div>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" name="remember" id="remember" checked>
            <label class="form-check-label" for="remember">Remember me</label>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</c:if>
<c:if test="${not empty result}">
    <div class="result mb-3">${message}</div>
    <div class="card form text-center mx-auto" style="width: 18rem;">
        <img src="${imageURL}" class="card-img-top" alt="imageURL">
        <div class="card-body">
            <p class="card-text fw-bold fs-3">${cookie.user.value}</p>
        </div>
    </div>
</c:if>

<script>
    $(document).ready(function () {
        $('#lab4').addClass("active");
    });
</script>