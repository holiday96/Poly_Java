<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<form action="/lab/lab2/bai2/2021" method="post" class="mb-3">
    <div class="col-3 mb-3 form-floating">
        <input type="text" class="form-control" name="x" id="x" placeholder="x" required>
        <label for="x">Input value of X</label>
    </div>
    <button class="btn btn-primary">Submit</button>
</form>
<c:if test="${not empty x}">
    <div class="result">
        <ul>
            <li><span class="title">Input value: </span>${x}</li>
            <li><span class="title">Path value: </span>${y}</li>
        </ul>
    </div>
</c:if>

<script>
    $(document).ready(function () {
        $('#lab2').addClass("active");
    });
</script>