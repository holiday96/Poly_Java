<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 4 Bài 1</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute; top: 10px; right: 10px;">
        <div class="toast-header">
            <img src="https://img.icons8.com/officel/16/fa314a/information.png" class="rounded me-2" alt="...">
            <strong class="me-auto">${title}</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
                ${message}
        </div>
    </div>
</c:if>
<div class="container rounded"
     style="background-color: #8BC6EC;
     		background-image: linear-gradient(135deg, #8BC6EC 0%, #9599E2 100%);">
    
    <div class="row">
        <div class="col-md-8 text-center align-self-center">
            <a href="#" class="fs-2 fw-bold text-success">Online Shopping Mall</a>
        </div>
        <div class="col-md-4 p-3 text-center">
            <a href="#">
                <img src="https://i.dlpng.com/static/png/1310221-png-svg-shopping-png-512_512_preview.png"
                     style="height: 70px;" alt="logo">
            </a>
        </div>
    </div>
    <%@include file="/views/lab/lab4/bai1menu.jsp" %>
    <div class="row">
        <div class="col-md-9 py-2">
            <div class="row">
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 1"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 2"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 3"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
            </div>
            <div class="row">
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 4"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 5"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
                <div class="col py-2">
                    <jsp:include page="bai1item.jsp">
                        <jsp:param name="name" value="Sản phẩm 6"/>
                        <jsp:param name="image" value="https://picsum.photos/500/500"/>
                    </jsp:include>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="row my-2 mx-0 border border-2 border-warning rounded-3">
                <%@include file="/views/lab/lab4/bai1login.jsp" %>
            </div>
            <div class="row list-group p-2">
                <%@include file="/views/lab/lab4/bai1category.jsp" %>
            </div>
        </div>
    </div>
    <div class="row py-2 bg-dark text-light" style="place-content: center;">
        FPT Polytechnic @2020. All rights reserved.
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: false});
        $("#myToast").toast('show');
    });
</script>
</body>