<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 6 Bài 3</title>
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
    <form action="/lab/6/bai3/keyword" method="post">
        <div class="row my-2">
            <input class="col-sm-4 mx-2" type="text" name="keyword" id="keyword" placeholder="Find Movies by Keyword"
                   required>
            <button class="col-sm-1 btn btn-primary">Search</button>
        </div>
    </form>
    <form action="/lab/6/bai3/user" method="post">
        <div class="row my-2">
            <input class="col-sm-4 mx-2" type="text" name="user" id="user" placeholder="Find Movies by User" required>
            <button class="col-sm-1 btn btn-primary">Search</button>
        </div>
    </form>
    <form action="/lab/6/bai3/like-date" method="post">
        <div class="row my-2">
            <input class="col-sm-2 mx-2" type="date" name="minDate" id="minDate" placeholder="Start date" required>
            <input class="col-sm-2 mx-2" type="date" name="maxDate" id="maxDate" placeholder="End date" required>
            <button class="col-sm-1 btn btn-primary">Filter</button>
        </div>
    </form>
    <form action="/lab/6/bai3/like-month" method="post">
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month1" value="1">
            <label class="form-check-label" for="month1">1</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month2" value="2">
            <label class="form-check-label" for="month2">2</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month3" value="3">
            <label class="form-check-label" for="month3">3</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month4" value="4">
            <label class="form-check-label" for="month4">4</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month5" value="5">
            <label class="form-check-label" for="month5">5</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month6" value="6">
            <label class="form-check-label" for="month6">6</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month7" value="7">
            <label class="form-check-label" for="month7">7</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month8" value="8">
            <label class="form-check-label" for="month8">8</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month9" value="9">
            <label class="form-check-label" for="month9">9</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month10" value="10">
            <label class="form-check-label" for="month10">10</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month11" value="11">
            <label class="form-check-label" for="month11">11</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="month" id="month12" value="12">
            <label class="form-check-label" for="month12">12</label>
        </div>
        <button class="col-sm-1 btn btn-primary">Filter</button>
    </form>
</div>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: true, delay: 3000});
        $("#myToast").toast('show');
    });
</script>
</body>