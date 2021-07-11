<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="wrapper">
    <div class="title">Welcome Back</div>
    <form action="/login">
        <div class="field">
            <input type="text" name="username" id="username" required>
            <label>Username</label>
        </div>
        <div class="field">
            <input type="password" name="password" id="password" required>
            <label>Password</label>
        </div>
        <div class="content">
            <div class="checkbox">
                <input type="checkbox" name="remember" id="remember">
                <label for="remember">Remember me</label>
            </div>
            <div class="pass-link">
                <a href="#">Forgot password?</a>
            </div>
        </div>
        <div class="field">
            <input type="submit" value="Login">
        </div>
        <div class="signup-link">Not a member?
            <a href="<c:url value='/register' />">Signup now</a>
        </div>
    </form>
</div>
