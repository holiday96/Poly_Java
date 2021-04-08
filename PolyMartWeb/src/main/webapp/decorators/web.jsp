<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>
		<dec:title default="Trang chủ" />
	</title>

	<!-- css -->
	<link href="<c:url value='/templates/web/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">
	<link href='<c:url value='/templates/web/css/shop-homepage.css' />' rel="stylesheet">
</head>

<body>
	<!-- header -->
	<%@include file="/commons/web/header.jsp" %>
	<!-- end-header -->

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@include file="/commons/web/footer.jsp" %>
	<!-- end-footer -->

	<script src="<c:url value='/templates/web/jquery/jquery.min.js' />"></script>
	<script src="<c:url value='/templates/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>

</body>

</html>