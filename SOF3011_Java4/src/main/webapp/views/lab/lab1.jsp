<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>


<c:if test="${empty name }">
	<form action="<c:url value='/lab/1' />" id="formName" method="GET">
		<p class="fs-5">Please insert your name</p>
		<div class="input-group">
			<input type="text" name="name" id="name">
			<button type="submit" class="btn btn-primary">Apply</button>
		</div>
	</form>
</c:if>
<c:if test="${not empty name }">
	<p class="fs-5">Hi, ${name}</p>
	<div class="row">
		<div class="calculator-form col">
			<p class="title-lab1">THÔNG TIN HÌNH CHỮ NHẬT</p>
			<div class="height my-3">
				<span>Chiều rộng: </span> <input type="text" name="heightNumber"
					id="heightNumber">
			</div>
			<div class="width my-3">
				<span>Chiều dài: </span> <input type="text" name="widthNumber"
					id="widthNumber">
			</div>
			<button id="calculate" onclick="calculate()">Tính</button>
		</div>
		<div class="result-form col">
			<p class="title-result">KẾT QUẢ</p>
			<p class="result">
				Chu vi: <span id="result-c"></span>
			</p>
			<p class="result">
				Diện tích: <span id="result-s"></span>
			</p>
		</div>
	</div>
</c:if>

<script>
	function calculate() {
		var h = document.querySelector("#heightNumber").value;
		var w = document.querySelector("#widthNumber").value;

		document.querySelector("#result-c").innerHTML = (Number(h) + Number(w)) * 2;
		document.querySelector("#result-s").innerHTML = Number(h) * Number(w);
	}
</script>