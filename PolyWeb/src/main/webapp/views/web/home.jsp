<%@include file = "/commons/taglib.jsp" %>
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

                    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <div class="row">

                        <c:forEach var="item" items="${model.listResult}">
                            <div class="col-lg-4 col-md-6 mb-4">
                                <div class="card h-100">
                                    <a href="${pageContext.request.contextPath}/product?id=${item.id}"><img class="card-img-top" src="${pageContext.request.contextPath}/images/${item.images[0]}"
                                            alt=""></a>
                                    <div class="card-body">
                                        <h4 class="card-title">
                                            <a href="${pageContext.request.contextPath}/product?id=${item.id}">${item.tenSP}</a>
                                        </h4>
                                        <c:choose>
                                            <c:when test="${item.minPrice < item.maxPrice}">
                                                <h5 class="card-price">${item.minPrice}₫ - ${item.maxPrice}₫</h5>
                                            </c:when>
                                            <c:otherwise>
                                                <h5 class="card-price">${item.minPrice}₫</h5>
                                            </c:otherwise>
                                        </c:choose>
                                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!</p>
                                    </div>
                                    <div class="card-footer">
                                        <small class="text-muted">&#9733; &#9733; &#9733; &#9733;
								&#9734;</small>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->
        </body>

        </html>