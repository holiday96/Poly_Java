<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link rel="icon" type="image/png" href="https://image.flaticon.com/icons/png/512/184/184697.png" sizes="32x32">
    <!-- Bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom css -->
    <link href="<c:url value='/templates/lab/sidebar2.css' />" rel="stylesheet"/>
    <link href="<c:url value='/templates/lab/stylee1.css' />" rel="stylesheet"/>

    <!-- Bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!-- SweetAlert2 -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- lab5-bai4 -->
    <link rel="stylesheet" href="<c:url value='/templates/lab/lab5bai4.css' />">

    <!--datatable-->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.js"></script>

    <title><dec:title default="Bài tập Lab"/></title>
</head>

<body>
<%@include file="/commons/lab/sidebar.jsp" %>

<div class="containerr">
    <div class="position-absolute top-0 end-0">
        <p class="fst-italic text-danger fs-5">Visitors: ${applicationScope.visitors}</p>
    </div>
    <c:choose>
        <c:when test="${empty sessionScope.model}">
            <div class="position-absolute top-0 end-50 translate-middle-x" style="z-index: 1;">
                <a href="/lab/5/bai4" class="btn btn-warning">Login</a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="position-absolute top-0 start-50 translate-middle-x" style="z-index: 1;">
                <span class="fst-italic fs-5 me-2">Welcome <span class="fw-bold">${sessionScope.model.fullname}</span></span>
                <c:if test="${sessionScope.model.admin}">
                    <a href="/lab/5/bai3" class="btn btn-warning btn-sm">Admin</a>
                </c:if>
                <a href="/lab/5/bai4/signout" class="btn btn-danger btn-sm">Logout</a>
            </div>
        </c:otherwise>
    </c:choose>
    <dec:body/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>

</html>