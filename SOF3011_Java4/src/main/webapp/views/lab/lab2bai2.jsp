<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>

<c:if test="${empty result }">
	<form action="<c:url value='/lab/2/bai2' />" method="post" id="register">
	    <h1>Đăng Ký</h1>
	    <label for="username">Tên đăng nhập: </label>
	    <input type="text" name="username" id="username"><br>
	    <label for="password">Mật khẩu: </label>
	    <input type="password" name="password" id="password"><br>
	    <label for="male">Giới tính: </label>
	    <input type="radio" name="gender" id="male" value="male"><label for="male">Nam</label>
	    <input type="radio" name="gender" id="female" value="female"><label for="female">Nữ</label><br>
	    <input type="checkbox" name="married" id="married"><label for="married">Đã có gia đình?</label><br>
	    <label for="nationality">Quốc tịch</label>
	    <select name="nationality" id="nationality">
	        <option value="us">United States</option>
	        <option value="vn">Vietnam</option>
	        <option value="ger">Germany</option>
	        <option value="fr">France</option>
	    </select><br>
	    <label for="note">Ghi chú:</label><br>
	    <textarea name="note" id="note" cols="40" rows="5"></textarea>
	</form>
	<hr>
	<button type="submit" form="register">Đăng ký</button>
</c:if>
<c:if test="${not empty result }">
	<h1>Thông tin đăng ký</h1>
    <ul>
        <li>Tên đăng nhập: <b>${param.username}</b></li>
        <li>Mật khẩu: <b>${param.password}</b></li>
        <li>Giới tính: <b>${param.gender}</b></li>
        <li>Tình trạng hôn nhân: <b>${param.married}</b></li>
        <li>Quốc tịch: <b>${param.nationality}</b></li>
        <li>Ghi chú: <b>${param.note}</b></li>
    </ul>
</c:if>