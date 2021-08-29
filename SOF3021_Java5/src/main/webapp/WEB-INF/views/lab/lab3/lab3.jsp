<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<c:if test="${empty message}">
    <form:form action="/lab/lab3" method="post" modelAttribute="student" cssClass="mx-auto mb-3 form"
               cssStyle="width: 500px" enctype="multipart/form-data">
        <div class="title mb-3">User Profile</div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text">Photo</span>
            </div>
            <div class="custom-file">
                <input class="form-control" type="file" name="photo" id="formFile" accept="image/png, image/jpeg">
            </div>
        </div>
        <div class="form-floating mb-3">
            <form:input cssClass="form-control" id="name" path="name" value="${model.name}" placeholder="name"/>
            <label for="name">Name</label>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="form-floating mb-3">
            <form:input cssClass="form-control" path="email" value="${model.email}" placeholder="email"/>
            <label for="name">Email</label>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div class="form-floating mb-3">
            <form:input cssClass="form-control" path="marks" value="${model.marks}" placeholder="marks"/>
            <label for="name">Marks</label>
            <form:errors path="marks" cssClass="error"/>
        </div>
        <div class="row">
            <div class="col-auto align-self-center">
                <div class="form-check form-check-inline">
                    <form:radiobutton cssClass="form-check-input" id="male" path="gender" value="true"/>
                    <label class="form-check-label" for="male">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <form:radiobutton cssClass="form-check-input" id="female" path="gender" value="false"/>
                    <label class="form-check-label" for="female">Female</label>
                    &nbsp;
                </div>
                <div class="mb-3">
                    <form:errors path="gender" cssClass="error"/>
                </div>
            </div>
            <div class="mb-3 col-auto">
                <form:select cssClass="form-select" path="faculty">
                    <form:option value="" label="-- Select Falcuty --" disabled="true" selected="true"/>
                    <form:options items="${faculties}"/>
                </form:select>
                <form:errors path="faculty" cssClass="error"/>
            </div>
        </div>
        <c:forEach items="${hobbies}" var="i">
            <div class="form-check form-check-inline">
                <form:checkbox cssClass="form-check-input" id="${i.key}" value="${i.key}" path="hobbies"/>
                <label for="${i.key}">${i.value}</label>
            </div>
        </c:forEach>
        <div class="mb-3">
            <form:errors path="hobbies" cssClass="error"/>
        </div>
        <button class="btn btn-primary">Submit</button>
        <br>
    </form:form>
</c:if>
<c:if test="${not empty message}">
    <div class="result">
        <div class="row">
            <div class="col-auto text-center border-end border-3 border-warning">
                <img class="rounded mb-2" src="
					<c:if test='${empty student.image and student.gender=="true"}'>https://bridgelawyers.ca/wp-content/uploads/2020/08/depositphotos_39258143-stock-illustration-businessman-avatar-profile-picture.jpg</c:if>
					<c:if test='${empty student.image and student.gender=="false"}'>https://simg.nicepng.com/png/small/356-3568165_blank-profile-picture-female.png</c:if>
					<c:if test='${not empty student.image}'>${student.image}</c:if>
				" id="thumbnail" alt="image_profile" width="200">
                <p class="fs-4 fw-bold">${student.name}</p>
            </div>
            <div class="col">
                <p class="align-middle"><i class='bx bx-mail-send' style='color:#6304bb; font-size: 30px;'></i> Email:
                    ${student.email}</p>
                <p>
                	<c:if test="${student.gender=='true'}">
                		<i class='bx bx-male' style='color:#020292; font-size: 30px;'></i> Male
                	</c:if>
                	<c:if test="${student.gender=='false'}">
                		<i class='bx bx-female' style='color:#9f05a4; font-size: 30px;'></i> Female
                	</c:if>
                </p>
                <p><i class='bx bx-bullseye' style='color:#9e0408; font-size: 30px;'></i> Marks: ${student.marks}</p>
                <p><i class='bx bx-book-reader' style='color:#03037d; font-size: 30px;'></i> Faculty: ${student.faculty}</p>
                <p><i class='bx bxs-heart-circle' style='color:#b70306; font-size: 30px;'></i> Hobbies: ${fn:replace(fn:replace(student.hobbies, ']', ''), '[', '')}</p>
            </div>
        </div>
    </div>
</c:if>

<script>
    $(document).ready(function () {
        $('#lab3').addClass("active");
    });
</script>