<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 2</title>
</head>
<body>
<c:if test="${empty staff}">
    <div style="width: 600px;"></div>
    <h1>Thông tin nhân viên</h1>
    <form action="/lab/3/bai2" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" name="name" id="name" placeholder="Nhập tên nhân viên" required>
            <label for="name" class="form-label">Họ và tên</label>
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
                <label>Sở thích</label>
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
            <textarea class="form-control" style="height: 100px;" placeholder="Leave a note here" id="note" name="note"></textarea>
            <label for="note">Ghi chú:</label>
        </div>
        <button class="btn btn-primary" type="submit">Thêm mới</button>
    </form>
</c:if>
<c:if test="${not empty staff}">
    <ul>
        <li>Họ và tên: <b>${staff.name}</b></li>
        <li>Ngày sinh: <b>${date}</b></li>
        <li>Giới tính: <b>${gender}</b></li>
        <li>Quốc tịch: <b>${staff.country}</b></li>
        <li>TT hôn nhân: <b>${married}</b></li>
        <li>Sở thích: <b>${hobbies}</b></li>
        <li>Ghi chú: <b>${staff.note}</b></li>
    </ul>
</c:if>
</body>