<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/user"/>

<div class="bg-image-register"></div>
<div class="bg-image-hover"></div>
<div class="wrapper">
    <div class="title">Welcome to WaMo</div>
    <form id="formSubmit" method="post">
        <div class="field">
            <input id="username" name="username" type="text" required> <label>Username</label>
        </div>
        <div class="field">
            <input id="password" name="password" type="password" required> <label>Password</label>
        </div>
        <div class="field">
            <input id="repeatPassword" type="password" required> <label>Repeat
            Password</label>
        </div>
        <div class="field">
            <input id="fullname" name="fullname" type="text" required> <label>Full Name</label>
        </div>
        <div class="field">
            <input id="email" name="email" type="email" required> <label>Email Address</label>
        </div>
        <div class="field">
            <input id="btnSubmit" type="submit" value="Register">
        </div>
        <div class="content">
            <div class="pass-link">
                <div id="forgot">Forgot password?</div>
            </div>
        </div>
        <div class="signup-link">
            Already a member? <a href='<c:url value="/login" />'>Login now</a>
        </div>
    </form>
</div>

<script>
    $('#btnSubmit').click(function (e) {
        e.preventDefault();
        if ($('#password').val() != $('#repeatPassword').val()) {
            $('#repeatPassword').addClass('is-invalid');
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Confirm password is not valid!",
            });
        } else {
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });
            add(data);
        }
    })

    //Call API Post User
    function add(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if (result == "username exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Username already exits!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else if (result == "email exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Email already exits!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else {
                    sendEmail(result.verify);
                    Swal.fire({
                        title: "Welcome to WaMo!",
                        text: "A verification email has been sent. Please verify your email to complete the registration process. Pay attention to check your spam folder if you don't see our email in the main mailbox.",
                        icon: "success",
                        backdrop: `
	                    rgba(0,0,123,0.4)
	                    url("https://i.gifer.com/origin/fd/fdf70f5f4989f9c08f033da50c38170e.gif")
	                    left top
	                    no-repeat
	                  	`,
                    }).then(() => window.location.href = "login"
                    )
                }
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

    //Send email verify account
    function sendEmail(link_verify) {
        var data = {
            service_id: 'service_yeerrcb',
            template_id: 'template_4xht0cp',
            user_id: 'user_FT7XMLT9CwnjPstip5Dke',
            template_params: {
                'user_email': $('#email').val(),
                'to_name': $('#fullname').val(),
                'subject': "Verification Account from WaMo",
                'message': 'We are honored that you choose our service. Please click on the link below to activate your account.',
                'link_verify': 'http://localhost:8080/user?verify=' + link_verify,
            }
        };

        $.ajax('https://api.emailjs.com/api/v1.0/email/send', {
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json'
        }).done(function () {
            console.log('Your mail is sent!');
        }).fail(function (error) {
            console.log('Oops... ' + JSON.stringify(error));
        });
    }

    //Button Forgot Password
    $('#forgot').click(async function (e) {
        e.preventDefault();
        const {value: email} = await Swal.fire({
            title: 'Retrieve Account',
            input: 'email',
            inputLabel: 'Enter your email address',
            inputPlaceholder: 'Enter your email address'
        })

        if (email) {
            var data = {};
            data["email"] = email;
            reset(data);
        }
    })

    //Call API reset Pass
    function reset(object) {
        $.ajax({
            url: '${apiURL}/reset',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(object),
            dataType: 'json',
            success: function (result) {
                if (result != "failed") {
                    sendResetPass(result);
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Something wrong!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                }
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

    //Send email reset pass
    function sendResetPass(object) {
        var data = {
            user_id: 'user_FT7XMLT9CwnjPstip5Dke',
            service_id: 'service_yeerrcb',
            template_id: 'template_lt6hxfi',
            template_params: {
                'user_email': object.email,
                'to_name': object.fullname,
                'subject': "Reset Password Account from WaMo",
                'message': "We are honored that you choose our service. Please click on the link below to reset your password. Note that this link will expires in 15 minutes.",
                'link_verify': 'http://localhost:8080/user/reset?verify=' + object.verify,
            }
        };

        $.ajax('https://api.emailjs.com/api/v1.0/email/send', {
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json'
        }).done(function () {
            console.log('Your mail is sent!');
            Swal.fire({
                title: "A verification email has been sent!",
                text: "Check the email to reset password account. Pay attention to check your spam folder if you don't see our email in the main mailbox.",
                icon: "success",
                backdrop: `
                rgba(0,0,123,0.4)
                url("../templates/img/catzebra-ok.gif")
                center top
                no-repeat
                `,
            }).then(() => window.location.href = "login");
        }).fail(function (error) {
            console.log('Oops... ' + JSON.stringify(error));
        });
    }
</script>