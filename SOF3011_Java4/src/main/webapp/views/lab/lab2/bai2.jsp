<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 2 Bài 2</title>
</head>
<body>
<div class="container py-5">
    <c:if test="${empty result }">
        <form action="/lab/2/bai2" method="post" id="register">
            <h1>Đăng Ký</h1><br>
            <div style="width: 400px; ">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="username" id="username"
                           placeholder="Nhập tên đăng nhập"
                           required>
                    <label for="username" class="form-label">Tên đăng nhập</label>
                </div>
                <div class="form-floating mb-3">
                    <input type="password" class="form-control" name="password" id="password"
                           placeholder="Nhập mật khẩu"
                           required>
                    <label for="password" class="form-label">Mật khẩu</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="Nam" checked>
                    <label class="form-check-label" for="male">Nam</label>
                </div>
                <div class="form-check form-check-inline mb-3">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="Nữ">
                    <label class="form-check-label" for="female">Nữ</label>
                </div>
                <div class="form-check form-check-inline mb-3">
                    <input class="form-check-input" type="checkbox" name="married" id="married">
                    <label class="form-check-label" for="married">Đã có gia đình?</label>
                </div>
                <div class="form-floating mb-3">
                    <select class="form-select" name="nationality" id="nationality">
                        <option selected disabled>-- Chọn Quốc gia --</option>
                        <option value="United States">United States</option>
                        <option value="Vietnam">Vietnam</option>
                        <option value="Germany">Germany</option>
                        <option value="France">France</option>
                    </select>
                    <label for="nationality">Quốc tịch</label>
                </div>
                <div class="form-floating mb-3">
                <textarea class="form-control" style="height: 100px;" placeholder="Leave a note here" id="note"
                          name="note"></textarea>
                    <label for="note">Ghi chú:</label>
                </div>
                <button class="btn btn-primary" type="submit" form="register">Đăng ký</button>
            </div>
        </form>
    </c:if>
    <c:if test="${not empty result }">
        <div class="page-content page-container" id="page-content">
            <div class="padding">
                <div class="row container d-flex justify-content-center">
                    <div class="col-xl-6 col-md-12">
                        <div class="card user-card-full">
                            <div class="row m-l-0 m-r-0">
                                <div class="col-sm-4 bg-c-lite-green user-profile">
                                    <div class="card-block text-center text-white">
                                        <div class="m-b-25"><img src="<c:url value='/templates/img/avatar.jpg' />"
                                                                 class="img-radius" alt="User-Profile-Image"></div>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="card-block">
                                        <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Thông tin đăng ký</h6>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Tên đăng nhập</p>
                                                <h6 class="text-muted f-w-400">${param.username}</h6>
                                            </div>
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Mật khẩu</p>
                                                <input type="password" id="pw" class="text-muted f-w-400" readonly
                                                       style="border-style: none; width: 150px;" value="${param.password}"/>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Giới tính</p>
                                                <h6 class="text-muted f-w-400">${param.gender}</h6>
                                            </div>
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Tình trạng hôn nhân</p>
                                                <h6 class="text-muted f-w-400">${married}</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm">
                                                <p class="m-b-10 f-w-600">Quốc tịch</p>
                                                <h6 class="text-muted f-w-400">${param.nationality}</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm">
                                                <p class="m-b-10 f-w-600">Ghi chú</p>
                                                <h6 class="text-muted f-w-400">${param.note}</h6>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>

<script type="text/javascript">
    var $pw = $("#pw");
    $pw.focus(function () {
        $pw.get(0).type = "text";
    });
    $pw.blur(function () {
        $pw.get(0).type = "password";
    });
</script>
</body>