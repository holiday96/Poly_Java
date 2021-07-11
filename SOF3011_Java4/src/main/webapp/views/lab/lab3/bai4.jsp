<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 4</title>
</head>
<body>
<h1>Login</h1><br>
<h3>${message}</h3>
<form action="/lab/3/bai4" method="post">
    <label for="username">Username:</label>
    <input type="text" name="username" id="username" placeholder="Your Username" value="${username}"><br>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password" placeholder="1234678" value="${password}"><br>
    <input type="checkbox" name="remember" id="remember"><label for="remember">Remember me?</label>
    <hr>
    <button class="btn" type="submit">Login</button>
</form>
</body>