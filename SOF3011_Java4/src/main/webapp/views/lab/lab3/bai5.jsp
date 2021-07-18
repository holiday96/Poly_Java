<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 5</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute; top: 10px; right: 10px;">
        <div class="toast-header">
            <img src="https://img.icons8.com/officel/16/fa314a/information.png" class="rounded me-2" alt="...">
            <strong class="me-auto">Thông báo</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
                ${message}
        </div>
    </div>
</c:if>
<div class="container py-5">
    <h1>Send Mail</h1><br>
    <div style="width: 500px;">
        <form action="/lab/3/bai5" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="to" id="to" placeholder="Type destination email address"
                       required>
                <label for="to" class="form-label">Email</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject Email"
                       required>
                <label for="subject" class="form-label">Subject</label>
            </div>
            <div class="form-floating mb-3">
            <textarea class="form-control" style="height: 100px;" placeholder="Your message" id="message"
                      name="message"></textarea>
                <label for="message">Message</label>
            </div>
            <button class="btn btn-primary">Send</button>
        </form>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: false});
        $("#myToast").toast('show');
    });
</script>
</body>