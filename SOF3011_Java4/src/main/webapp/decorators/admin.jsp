<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/templates/admin/css/style.css' />">
<!-- Boxiocns CDN Link -->
<link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css'
	rel='stylesheet'>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
	<div class="main">
		<%@include file="/commons/admin/nav.jsp"%>
		<section class="home-section">
			<%@include file="/commons/admin/header.jsp"%>
			<dec:body />
		</section>
	</div>

	<script src="<c:url value='/templates/admin/js/script.js' />"></script>
</body>

</html>