<%@include file="/commons/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>

<body>

	<div class="row">

		<div class="col-lg-3">
			<h1 class="my-4">Poly Mart</h1>
			<div class="list-group">
				<c:forEach var="item" items="${loaiSanPhamModel.listResult}">
					<a href="#" class="list-group-item">${item.tenLoaiSP}</a>
				</c:forEach>
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div class="card mt-4">
				<img class="card-img-top img-fluid"
					src="${pageContext.request.contextPath}/images/${model.images[0]}"
					alt="">
				<div class="card-body">
					<h3 class="card-title">${model.tenSP}</h3>
					<c:choose>
						<c:when test="${model.minPrice < model.maxPrice}">
							<h4 class="card-price">${model.minPrice}₫-${model.maxPrice}₫</h4>
						</c:when>
						<c:otherwise>
							<h4 class="card-price">${model.minPrice}₫</h4>
						</c:otherwise>
					</c:choose>
					
					<h4 class="card-sizes">Size: ${model.sizes}</h4>
					<h4 class="card-colors">Màu sắc: ${model.colors}</h4>
					<h4 class="card-amount">Số lượng hiện có: ${model.amount}</h4>
					
					<c:choose>
						<c:when test="${model.moTa != null }">
							<p class="card-text">${model.moTa}</p>
						</c:when>
						<c:otherwise>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque
								facere, soluta. Totam id dolores, sint aperiam sequi pariatur
								praesentium animi perspiciatis molestias iure, ducimus!</p>
						</c:otherwise>
					</c:choose>

					<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
						&#9734;</span> 4.0 stars
				</div>
			</div>
			<!-- /.card -->

			<!--                     <div class="card card-outline-secondary my-4">
                        <div class="card-header">
                            Product Reviews
                        </div>
                        <div class="card-body">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae
                                sint natus.</p>
                            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                            <hr>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae
                                sint natus.</p>
                            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                            <hr>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae
                                sint natus.</p>
                            <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                            <hr>
                            <a href="#" class="btn btn-success">Leave a Review</a>
                        </div>
                    </div> -->
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->
</body>

</html>