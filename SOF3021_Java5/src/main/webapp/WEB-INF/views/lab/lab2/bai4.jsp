<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<form action="/lab/lab2/bai4" method="post" class="mb-3">
    <div class="col-4 mb-3 form-floating">
        <input type="text" class="form-control" name="name" id="name" placeholder="name" required>
        <label for="name">Name</label>
    </div>
    <div class="col-4 mb-3 form-floating">
        <input type="number" class="form-control" name="price" id="price" placeholder="price" required>
        <label for="price">Price</label>
    </div>
    <button class="btn btn-primary">Save</button>
</form>
<div class="result">
    <div class="row">
        <c:if test="${not empty p}">
        	<div class="col-4 mx-2 card" style="width: 200px;">
	            <img src="https://picsum.photos/300/200" class="card-img-top" alt="img">
	            <div class="card-body text-center">
	                <h5 class="card-title">${p.name}</h5>
	                <p class="card-text" style="color: red;">${p.price}
	                	<i class='bx bx-dollar-circle fs-5' style='color:#015a0a'></i>
	                </p>
	            </div>
	        </div>
        </c:if>
        <c:if test="${not empty product}">
            <div class="col-4 mx-2 card" style="width: 200px;">
                <img src="https://picsum.photos/300/200" class="card-img-top" alt="img">
                <div class="card-body text-center">
                    <h5 class="card-title">${product.name}</h5>
                    <p class="card-text" style="color: red;">${product.price}
                    	<i class='bx bx-dollar-circle fs-5' style='color:#015a0a'></i>
                    </p>
                </div>
            </div>
        </c:if>
        <c:forEach var="i" items="${list}">
        	<div class="col-4 mx-2 card" style="width: 200px;">
                <img src="https://picsum.photos/300/200" class="card-img-top" alt="img">
                <div class="card-body text-center">
                    <h5 class="card-title">${i.name}</h5>
                    <p class="card-text" style="color: red;">${i.price}
                    	<i class='bx bx-dollar-circle fs-5' style='color:#015a0a'></i>
                    </p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#lab2').addClass("active");
    });
</script>