<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="header fixed-top" style="background-color: #3f3567;">
    <div class="container d-flex justify-content-between p-2">
        <a class="logo" href="#" title="WaMo - Watch all Movie you want!">
            <span class="title-logo">wamo</span>
            <img src="../templates/img/logo.png " alt="logo">
        </a>
        <div class="search-container position-relative" style="align-self: center;">
            <form action="" class="form-search">
                <input type="text" id="keyword" name="keyword" placeholder="Type movie name...">
                <i class='bx bx-search' onclick="btnSearch()" style="cursor: pointer;"></i>
            </form>
        </div>
        <div style="align-self: center;">
            <a href="#" class="btn-favorite">
                <i class='bx bx-heart'></i>
                <span>Favorite</span>
                <span class="count-favor">0</span>
            </a>
            <a href="/register" class="btn-register">
                <i class='bx bx-user'></i>
                <span>Register</span>
            </a>
            <a href="/login" class="btn-login">
                <i class='bx bx-log-in'></i>
                <span>Login</span>
            </a>
        </div>
    </div>
</div>