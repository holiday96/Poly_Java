<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/user/login"/>

<div class="bg-image-login"></div>
<div class="bg-image-hover"></div>
<c:if test="${not empty param.message}">
    <div class="position-fixed start-50 translate-middle-x alert alert-${param.alert} alert-dismissible fade show"
         role="alert" style="top: 15%">
        <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
            <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
                <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
            </symbol>
        </svg>
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:">
            <use xlink:href="#exclamation-triangle-fill"/>
        </svg>
        <strong>${param.message}</strong>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<div class="wrapper">
    <div class="title">Welcome Back</div>
    <form action="/login" id="formSubmit" method="POST">
        <div class="field">
            <input type="text" name="username" id="username" value="${cookie.username.value}" required>
            <label>Username</label>
        </div>
        <div class="field">
            <input type="password" name="password" id="password" value="${cookie.password.value}" required>
            <label>Password</label>
        </div>
        <div class="content">
            <div class="checkbox">
                <input type="checkbox" name="remember" id="remember"
                       <c:if test="${not empty cookie.remember}">checked</c:if>>
                <label for="remember">Remember me</label>
            </div>
            <div class="pass-link">
                <a href="#">Forgot password?</a>
            </div>
        </div>
        <div class="field">
            <input type="submit" id="btnSubmit" value="Login">
        </div>
        <div class="signup-link">Not a member?
            <a href="<c:url value='/register' />">Signup now</a>
        </div>
    </form>
</div>
<script>
    //Button Submit form
    $('#btnSubmit').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        login(data);
    })

    //Call API Post submit
    function login(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if (result == "failed") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Username or Password incorrect!',
                        showConfirmButton: false,
                        timer: 3000,
                        timerProgressBar: true,
                    })
                } else {
                    Swal.fire({
                        title: `Hi ` + result.fullname + `!`,
                        text: "Let's checkout some movie 😉",
                        icon: "success",
                        timer: 3000,
                        timerProgressBar: true,
                        backdrop: `
	                    rgba(3, 86, 252,0.2)
	                    url("../templates/img/peachcat-go.gif")
	                    center top
	                    no-repeat
	                    `,
                    }).then(() => {
                        $('#formSubmit').submit();
                    });
                }
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                })
            }
        })
    }
</script>