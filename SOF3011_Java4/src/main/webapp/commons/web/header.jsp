<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="header fixed-top" style="background-color: #3f3567;">
    <div class="container d-flex justify-content-between p-2">
        <a class="logo" href="/home" title="WaMo - Watch all Movie you want!">
            <span class="title-logo">wamo</span>
            <img src="../templates/img/logo.png " alt="logo">
        </a>
        <div class="search-container position-relative" style="align-self: center;">
            <form action="" class="form-search">
                <input type="text" id="keyword" name="keyword" placeholder="Type movie name...">
                <i class='bx bx-search' onclick="btnSearch()" style="cursor: pointer;"></i>
            </form>
        </div>
        <c:if test="${empty USER}">
            <div style="align-self: center;">
                <a href="/register" class="btn-register">
                    <i class='bx bx-user'></i>
                    <span>Register</span>
                </a>
                <a href="/login" class="btn-login">
                    <i class='bx bx-log-in'></i>
                    <span>Login</span>
                </a>
            </div>
        </c:if>
        <c:if test="${not empty USER}">

            <div style="align-self: center;">
                <a href="/favorite" class="btn-favorite">
                    <i class='bx bx-heart'></i>
                    <span>Favorite</span>
                    <span class="count-favor">${fn:length(user.movies)}</span>
                </a>
                <a href="/info" id="btnInfo" class="btn-register">
                    <i class='bx bxs-user-circle'></i>
                    <span>${USER.fullname}</span>
                </a>
                <a href="/logout" class="btn-login">
                    <i class='bx bx-log-out'></i>
                    <span>Logout</span>
                </a>
            </div>
        </c:if>
    </div>
</div>
<script>
	function btnSearch(){
		var keyword = $('#keyword').val();
		window.location.href = "/search?key="+keyword;
	}
</script>