<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value='/templates/lab/style4.css' />" rel="stylesheet"/>
    <title><dec:title default="Bài tập Lab"/></title>
</head>

<body>
<%@include file="/commons/lab/nav.jsp" %>

<div class="container">
    <div class="formRegister">
        <dec:body/>
    </div>
</div>
</body>

</html>