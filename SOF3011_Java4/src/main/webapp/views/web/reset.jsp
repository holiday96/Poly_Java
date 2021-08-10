<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/user"/>

<div class="container text-center">
    <h1 style="color: #ffc107">
        Don' worry ${user.fullname}!!
    </h1>
    <h3 style="color: white;">One more step to get your account back</h3>
    <form id="submitForm" class="p-3 mx-auto rounded">
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="password" placeholder="Password">
            <label for="password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password">
            <label for="confirmPassword">Confirm Password</label>
        </div>
        <input id="btnConfirm" type="button" class="btn btn-primary" value="Confirm">
    </form>
    <div class="text-center">
        <img src="../templates/img/peachcat-wait.gif" alt=""/>
    </div>
</div>

<script>
    $('#btnConfirm').click(function (e) {
        e.preventDefault();
        var pass = $('#password').val();
        var confirmPass = $('#confirmPassword').val();
        if (pass != confirmPass) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Confirm password is not valid!",
            });
        } else {
            var data = {};
            data["id"] = ${user.id};
            data["password"] = pass;
            changePassword(data);
        }
    });

    //Call API change Pass
    function changePassword(data) {
        $.ajax({
            url: '${apiURL}/changePassword',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	Swal.fire({
                    title: "Welcome to back WaMo!",
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
                  }).then(() => window.location.href = "/home");
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something wrong!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                })
            }
        })
    }
</script>