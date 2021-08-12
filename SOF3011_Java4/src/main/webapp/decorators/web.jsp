<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">

    <!-- font google -->
    <link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&amp;display=swap" rel="stylesheet"/>

	<!-- fontawesome -->
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

    <!-- Bootstrap v5.0.2 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <!-- jQuery v3.6.0 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- WOWSlider -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/templates/web/engine0/style.css' />"/>
    <script type="text/javascript" src="<c:url value='/templates/web/engine0/jquery.js' />"></script>

    <!-- slick -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/templates/web/slick/slick.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/templates/web/slick/slick-theme.css' />">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/templates/web/css/style3.css' />">
    <link rel="stylesheet" href="<c:url value='/templates/web/css/slick-custom.css' />">
    <link rel="stylesheet" href="<c:url value='/templates/web/css/slider2.css' />">

    <!-- Favicon -->
    <link rel="icon" type="image/png" href="<c:url value='/templates/img/logo.png' />" sizes="32x32">

    <title><dec:title default="WaMo - Watch every Movie you want!"/></title>
</head>
<body>
<%@include file="/commons/web/header.jsp" %>
<%@include file="/commons/web/nav.jsp" %>

<div class="main-content">
    <dec:body/>
</div>

<%@include file="/commons/web/footer.jsp" %>

<script src="<c:url value='/templates/web/slider.js' />"></script>

<!-- wowSlider -->
<script type="text/javascript" src="<c:url value='/templates/web/engine0/wowslider.js' />"></script>
<script type="text/javascript" src="<c:url value='/templates/web/engine0/script.js' />"></script>

<!-- slick -->
<script src="<c:url value='/templates/web/slick/slick.js' />" type="text/javascript" charset="utf-8"></script>

<!-- sweetalert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>