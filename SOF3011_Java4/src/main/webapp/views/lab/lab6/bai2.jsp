<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 2</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute; top: 10px; right: 10px;">
        <div class="toast-header">
            <img src="https://img.icons8.com/officel/16/fa314a/information.png" class="rounded me-2" alt="...">
            <strong class="me-auto">Information</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
                ${message}
        </div>
    </div>
</c:if>
<div class="container bg-light p-4" style="margin-top: 6%;">
    <form action="/lab/6/bai2/user" method="post">
        <div class="row my-2">
            <input class="col-sm-4 mx-2" type="text" name="user" id="user" placeholder="Find Movies by User" required>
            <button class="col-sm-1 btn btn-primary">Search</button>
        </div>
    </form>
    <form action="/lab/6/bai2/keyword" method="post">
        <div class="row my-2">
            <input class="col-sm-4 mx-2" type="text" name="keyword" id="keyword" placeholder="Find Movies by Keyword"
                   required>
            <button class="col-sm-1 btn btn-primary">Search</button>
        </div>
    </form>
    <form action="/lab/6/bai2/movie" method="post">
        <div class="row my-2">
            <input class="col-sm-4 mx-2" type="text" name="movie" id="movie" placeholder="Find Users by Movie" required>
            <button class="col-sm-1 btn btn-primary">Search</button>
        </div>
    </form>
    <form action="/lab/6/bai2/favor" method="post">
        <div class="form-check form-check-inline">
            <input class="form-check-input" value="true" type="radio" name="favor" id="favor" checked>
            <label class="form-check-label" for="favor">Favorite</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" value="false" type="radio" name="favor" id="not_favor">
            <label class="form-check-label" for="not_favor">Not Favorite</label>
        </div>
        <button class="btn btn-primary">Display</button>
    </form>
    <a href="/lab/6/bai2/report" class="btn btn-primary" title="Show the number of likes per video">Report</a>
</div>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: true, delay: 3000});
        $("#myToast").toast('show');
    });
</script>
</body>