<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

<div class="bg-image-register"></div>
<div class="bg-image-hover"></div>
<div class="wrapper">
	<div class="title">Welcome to WaMo</div>
	<form action="#">
		<div class="field">
			<input type="text" required> <label>Username</label>
		</div>
		<div class="field">
			<input type="password" required> <label>Password</label>
		</div>
		<div class="field">
			<input type="password" required> <label>Repeat
				Password</label>
		</div>
		<div class="field">
			<input type="text" required> <label>Full Name</label>
		</div>
		<div class="field">
			<input type="email" required> <label>Email Address</label>
		</div>
		<div class="field">
			<input type="submit" value="Register">
		</div>
		<div class="content">
			<div class="pass-link">
				<a href="#">Forgot password?</a>
			</div>
		</div>
		<div class="signup-link">
			Already a member? <a href='<c:url value="/login" />'>Login now</a>
		</div>
	</form>
</div>