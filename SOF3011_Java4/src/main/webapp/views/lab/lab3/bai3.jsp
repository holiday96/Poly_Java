<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 3</title>
</head>
<body>
<c:if test="${empty staff}">
    <h1>Thông tin nhân viên</h1>
    <form action="/lab/3/bai3" method="post" enctype="multipart/form-data">
        <label for="name">Họ và tên: </label>
        <input type="text" name="name" id="name" placeholder="Nhập tên nhân viên"><br>
        Hình ảnh: <input name="photo-file" type="file"><br>
        <label for="date">Ngày sinh</label>
        <input type="date" name="date" id="date"><br>
        <label for="country">Quốc tịch</label>
        <select name="country" id="country">
            <option selected disabled>--- Chọn Quốc tịch ---</option>
            <option value="us">United States</option>
            <option value="vn">Vietnam</option>
            <option value="fr">France</option>
        </select><br>
        <span>Giới tính</span>
        <input type="radio" name="gender" id="male"><label for="male">Nam</label>
        <input type="radio" name="gender" id="female"><label for="female">Nữ</label><br>
        <span>TT hôn nhân</span><input type="checkbox" name="married" id="married">
        <label for="married">Đã có gia đình?</label><br>
        <span>Sở thích: </span>
        <input type="checkbox" name="hobbies" id="read"><label for="read">Đọc sách</label>
        <input type="checkbox" name="hobbies" id="travel"><label for="travel">Du lịch</label>
        <input type="checkbox" name="hobbies" id="music"><label for="music">Âm nhạc</label>
        <input type="checkbox" name="hobbies" id="other"><label for="other">Khác</label><br>
        <label for="note">Ghi chú: </label><textarea name="note" id="note" cols="40" rows="7"></textarea>
        <hr>
        <button type="submit">Thêm mới</button>
    </form>
</c:if>
<c:if test="${not empty staff}">
    <ul>
        <li>Họ và tên: <b>${staff.name}</b></li>
        <li>Hình ảnh: <b>${staff.avatar}</b></li>
        <li>Ngày sinh: <b>${staff.date}</b></li>
        <li>Giới tính: <b>${staff.gender}</b></li>
        <li>Quốc tịch: <b>${staff.country}</b></li>
        <li>TT hôn nhân: <b>${staff.married}</b></li>
        <li>Sở thích: <b>${staff.hobbies}</b></li>
        <li>Ghi chú: <b>${staff.note}</b></li>
    </ul>
</c:if>
</body>