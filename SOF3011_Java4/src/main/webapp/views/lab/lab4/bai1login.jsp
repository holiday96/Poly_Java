<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<form class="p-3 bg-light" id="loginForm" method="post">
    <div class="mb-3">
        <input type="text" class="form-control" name="username" id="username" value="${cookie.username.value}"
               placeholder="Username">
    </div>
    <div class="mb-3">
        <input type="password" class="form-control" name="password" id="password" value="${cookie.password.value}"
               placeholder="Password">
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" name="remember" id="remember"
               <c:if test="${not empty cookie.remember}">checked</c:if>>
        <label class="form-check-label" for="remember">Remember me?</label>
    </div>
    <button id="submitLogin" type="submit" class="btn btn-primary btn-sm">Login</button>
</form>

