<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="row mb-3">
	<div class="col-auto me-auto fw-bold fs-1" style="color: yellow">Shopping Online</div>
	<div class="col-auto">
		<a href="/lab/lab4/part2/cart" class="btn btn-primary">
			<i class='bx bxs-cart bx-flashing-hover text-warning' style='color:#4f00a2; font-size: 40px;' ></i>
		</a>
	</div>
</div>
<div class="row row-cols-4 g-5">
    <c:forEach items="${items}" var="i">
        <div class="col">
            <div class="card">
                <img src="https://picsum.photos/300/200" class="card-img-top" alt="${i.id}">
                <div class="card-body text-center">
                    <h5 class="card-title fw-bold text-primary">${i.name}</h5>
                    <p class="card-text fw-bold text-danger">${i.price} $</p>
                    <a href="/lab/lab4/part2/${i.id}" class="btn btn-success">Add to Cart</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script>
    $(document).ready(function () {
        $('#lab4').addClass("active");
    });
</script>