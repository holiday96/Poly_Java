<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<form action="/lab/lab2/bai3/save" method="post" class="mb-3 text-center">
    <div class="mb-3 form-floating mx-auto" style="width: 200px;">
        <input type="text" class="form-control" name="name" id="name" placeholder="name" required>
        <label for="name">Name</label>
    </div>
    <div class="col-4 mb-3 form-floating mx-auto" style="width: 200px;">
        <input type="number" class="form-control" name="price" id="price" placeholder="price" required>
        <label for="price">Price</label>
    </div>
    <button class="btn btn-primary">Save</button>
</form>
<c:if test="${not empty product}">
    <div class="result">
        <ul>
            <li><span class="title">Name: </span>${product.name}</li>
            <li><span class="title">Price: </span>${product.price}</li>
        </ul>
    </div>
</c:if>

<script>
    $(document).ready(function () {
        $('#lab2').addClass("active");
    });
</script>