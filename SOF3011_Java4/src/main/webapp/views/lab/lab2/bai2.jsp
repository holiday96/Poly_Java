<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 2 Bài 2</title>
</head>
<body>
<c:if test="${empty result }">
    <form action="/lab/2/bai2" method="post" id="register">
        <h1>Đăng Ký</h1><br>
        <div style="width: 400px; ">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="username" id="username" placeholder="Nhập tên đăng nhập"
                       required>
                <label for="username" class="form-label">Tên đăng nhập</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" name="password" id="password" placeholder="Nhập mật khẩu"
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
    <h1>Thông tin đăng ký</h1>
    <ul>
        <li>Tên đăng nhập: <b>${param.username}</b></li>
        <li>Mật khẩu: <b>${param.password}</b></li>
        <li>Giới tính: <b>${param.gender}</b></li>
        <li>Tình trạng hôn nhân: <b>${married}</b></li>
        <li>Quốc tịch: <b>${param.nationality}</b></li>
        <li>Ghi chú: <b>${param.note}</b></li>
    </ul>
</c:if>
</body>