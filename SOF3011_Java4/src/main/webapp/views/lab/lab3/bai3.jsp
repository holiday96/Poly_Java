<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 3</title>
</head>
<body>
<div class="container py-5">
    <c:if test="${empty staff}">
        <div style="width: 500px;">
            <h1>Thông tin nhân viên</h1><br>
            <form action="/lab/3/bai3" method="post" id="upload" enctype="multipart/form-data">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" name="name" id="name" placeholder="Nhập tên nhân viên"
                           required>
                    <label for="name" class="form-label">Họ và tên</label>
                </div>
                <div class="mb-3">
                    <label for="photo-file" class="form-label">Hình ảnh</label>
                    <input class="form-control" type="file" name="photo-file" id="photo-file" required>
                </div>
                <div class="form-floating mb-3">
                    <input type="date" class="form-control" name="date" id="date" placeholder="Nhập ngày sinh" required>
                    <label for="date" class="form-label">Ngày sinh</label>
                </div>
                <div class="form-floating mb-3">
                    <select class="form-select" name="country" id="country">
                        <option selected disabled>-- Chọn Quốc gia --</option>
                        <option value="United States">United States</option>
                        <option value="Vietnam">Vietnam</option>
                        <option value="Germany">Germany</option>
                        <option value="France">France</option>
                    </select>
                    <label for="country">Quốc tịch</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="male" value="Nam" checked>
                    <label class="form-check-label" for="male">Nam</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="female" value="Nữ">
                    <label class="form-check-label" for="female">Nữ</label>
                </div>
                <div class="form-check form-check-inline mb-3">
                    <input class="form-check-input" type="checkbox" name="married" id="married">
                    <label class="form-check-label" for="married">Đã có gia đình?</label>
                </div>
                <div>
                    <div class="form-check form-check-inline">
                        <label for="">Sở thích</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="hobbies" id="read" value="Đọc sách">
                        <label class="form-check-label" for="read">Đọc sách</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="hobbies" id="travel" value="Du lịch">
                        <label class="form-check-label" for="travel">Du lịch</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="hobbies" id="music" value="Âm nhạc">
                        <label class="form-check-label" for="music">Âm nhạc</label>
                    </div>
                    <div class="form-check form-check-inline mb-3">
                        <input class="form-check-input" type="checkbox" name="hobbies" id="other" value="Khác">
                        <label class="form-check-label" for="other">Khác</label>
                    </div>
                </div>
                <div class="form-floating mb-3">
                    <textarea class="form-control" style="height: 100px;" placeholder="Leave a note here" id="note"
                              name="note"></textarea>
                    <label for="note">Ghi chú:</label>
                </div>
                <button class="btn btn-primary" type="submit" form="upload">Thêm mới</button>
            </form>
        </div>
    </c:if>
    <c:if test="${not empty staff}">
        <div class="page-content page-container" id="page-content">
            <div class="padding">
                <div class="row container d-flex justify-content-center">
                    <div class="col-xl-6 col-md-12">
                        <div class="card user-card-full">
                            <div class="row m-l-0 m-r-0">
                                <div class="col-sm-4 bg-c-lite-green user-profile">
                                    <div class="card-block text-center text-white">
                                        <div class="m-b-25"><img src="/files/${staff.avatar}" class="img-radius"
                                                                 alt="User-Profile-Image"></div>
                                        <h6 class="f-w-600">${staff.name}</h6>
                                    </div>
                                </div>
                                <div class="col-sm-8">
                                    <div class="card-block">
                                        <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Thông tin nhân viên</h6>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Ngày sinh</p>
                                                <h6 class="text-muted f-w-400">${date}</h6>
                                            </div>
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Giới tính</p>
                                                <h6 class="text-muted f-w-400">${gender}</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Quốc tịch</p>
                                                <h6 class="text-muted f-w-400">${staff.country}</h6>
                                            </div>
                                            <div class="col-sm-6">
                                                <p class="m-b-10 f-w-600">Tình trạng hôn nhân</p>
                                                <h6 class="text-muted f-w-400">${married}</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm">
                                                <p class="m-b-10 f-w-600">Sở thích</p>
                                                <h6 class="text-muted f-w-400">${hobbies}</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm">
                                                <p class="m-b-10 f-w-600">Ghi chú</p>
                                                <h6 class="text-muted f-w-400">${staff.note}</h6>
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
</body>