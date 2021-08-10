<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">

    <!-- Favicon -->
    <link rel="icon" type="image/png" href="<c:url value='/templates/img/logo.png' />" sizes="32x32">

    <!-- jQuery v3.6.0 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- SweetAlert2 -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <link rel="stylesheet" href="<c:url value='/templates/login/style3.css' />">
    <title><dec:title default="Register"/></title>
</head>
<body>
<dec:body/>
</body>
</html>