<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/templates/admin/css/stylee.css' /> ">

    <!-- Boxiocns CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>

    <!-- Favicon -->
    <link rel="icon" type="image/png" href="<c:url value='/templates/img/logo.png' />" sizes="32x32">

    <!-- Bootstrap v5.0.2 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <!-- jQuery v3.6.0 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <!-- DataTables -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/templates/admin/datatables/datatables.min.css' />"/>
    <script type="text/javascript" src="<c:url value='/templates/admin/datatables/datatables.min.js' />"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><dec:title default="Admin Page"/></title>
</head>
<body>
<div class="main">
    <%@include file="/commons/admin/nav.jsp" %>

    <section class="home-section">
        <dec:body/>
    </section>
</div>

<!-- Custom JS -->
<script type="text/javascript" src="<c:url value='/templates/admin/js/script.js' />"></script>

</body>
</html>