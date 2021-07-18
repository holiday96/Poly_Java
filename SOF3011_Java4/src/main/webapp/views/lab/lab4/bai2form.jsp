<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<form class="p-3 rounded-2" id="loginForm" method="post"
      style="background-color: #FBAB7E; background-image: linear-gradient(244deg, #FBAB7E 0%, #F7CE68 100%);">
    <div class="mb-3">
        <input type="text" class="form-control" name="username" id="username" placeholder="Username"
               value="${users[0].username}">
    </div>
    <div class="mb-3">
        <input type="password" class="form-control" name="password" id="password" placeholder="Password"
               value="${users[0].password}">
    </div>
    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="remember"
               name="remember" ${users[0].remember? 'checked': ''}>
        <label class="form-check-label" for="remember">Remember me?</label>
    </div>
    <button type="submit" form="loginForm" class="btn btn-primary btn-sm">Login</button>
</form>