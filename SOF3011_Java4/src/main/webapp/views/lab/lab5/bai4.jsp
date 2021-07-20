<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <link rel="stylesheet" href="<c:url value='/templates/lab/lab5bai4.css' />">
    <title>Lab 5 Bài 4</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute;top: 10px;right: 10px;z-index: 1;">
        <div class="toast-header">
            <img src="https://img.icons8.com/officel/16/fa314a/information.png" class="rounded me-2" alt="...">
            <strong class="me-auto">Information</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
                ${message}
        </div>
    </div>
</c:if>
<c:if test="${empty model}">
    <div class="contain-lab5-bai4">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign
                In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                <div class="login-form">
                    <form action="/lab/5/bai4" method="post" class="sign-in-htm">
                        <div class="group">
                            <label for="id" class="label">Username</label>
                            <input id="id" name="id" type="text" class="input" value="${username}" required>
                        </div>
                        <div class="group">
                            <label for="password" class="label">Password</label>
                            <input id="password" name="password" type="password" class="input" value="${password}"
                                   data-type="password"
                                   required>
                        </div>
                        <div class="group">
                            <input id="remember" name="remember" type="checkbox" class="check"
                                   <c:if test="${not empty remember}">checked</c:if>>
                            <label for="remember"><span class="icon"></span> Keep me Signed in</label>
                        </div>
                        <div class="group">
                            <input formaction="/lab/5/bai4/signin" type="submit" class="button" value="Sign In">
                        </div>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a href="" id="btnForgotPass" data-bs-toggle="modal" data-bs-target="#forgotPassword">Forgot
                                Password?</a>
                        </div>
                    </form>
                    <form action="/lab/5/bai4" method="post" class="sign-up-htm">
                        <div class="group">
                            <label for="ids" class="label">Username</label>
                            <input id="ids" name="id" type="text" class="input" required>
                        </div>
                        <div class="group">
                            <label for="pass" class="label">Password</label>
                            <input id="pass" name="password" type="password" class="input" data-type="password"
                                   required>
                        </div>
                        <div class="group">
                            <label for="repass" class="label">Repeat Password</label>
                            <input id="repass" type="password" class="input" data-type="password" required>
                        </div>
                        <div class="group">
                            <label for="fullname" class="label">Fullname</label>
                            <input id="fullname" name="fullname" type="text" class="input" required>
                        </div>
                        <div class="group">
                            <label for="email" class="label">Email Address</label>
                            <input id="email" name="email" type="email" class="input" required>
                        </div>
                        <div class="group">
                            <input formaction="/lab/5/bai4/signup" type="submit" class="button" value="Sign Up">
                        </div>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a href="#"><label for="tab-1">Already Member? Sign In now</label></a>
                        </div>

                        <input type="hidden" name="admin" value="false"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:if>
<c:if test="${not empty model}">
    <div class="page-content page-container" id="page-content">
        <div class="padding">
            <div class="row container d-flex justify-content-center">
                <div class="col-xl-6 col-md-12">
                    <div class="card user-card-full">
                        <div class="row m-l-0 m-r-0">
                            <div class="col-sm-4 bg-c-lite-green user-profile">
                                <div class="card-block text-center text-white">
                                    <div class="m-b-25"><img src="<c:url value='/templates/img/avatar.jpg' />"
                                                             class="img-radius" alt="User-Profile-Image"></div>
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="card-block">
                                    <h4 class="m-b-20 p-b-5 b-b-default f-w-600">Profile</h4>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="m-b-10 f-w-600">Username</p>
                                            <h6 class="text-muted f-w-400">${model.id}</h6>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="m-b-10 f-w-600">Password</p>
                                            <input type="password" id="pw"
                                                   class="form-control-plaintext text-muted f-w-400" readonly
                                                   style="border-style: none; width: 150px;" value="${model.password}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="m-b-10 f-w-600">Fullname</p>
                                            <h6 class="text-muted f-w-400">${model.fullname}</h6>
                                        </div>
                                        <div class="col-sm-6">
                                            <p class="m-b-10 f-w-600">Email</p>
                                            <h6 class="text-muted f-w-400">${model.email}</h6>
                                        </div>
                                    </div>
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                            data-bs-target="#editProfile">
                                        Edit
                                    </button>
                                    <button type="button" class="btn btn-success btn-sm" data-bs-toggle="modal"
                                            data-bs-target="#changePassword">
                                        Change Password
                                    </button>
                                    <a href="/lab/5/bai4/signout" class="btn btn-danger btn-sm">Sign out</a>

                                    <!-- Modal-edit-Profile -->
                                    <div class="modal fade" id="editProfile" tabindex="-1"
                                         aria-labelledby="editProfileLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <form action="/lab/5/bai4" method="post" class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="editProfileLabel">Edit Profile</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="mb-3 row">
                                                        <label for="editId"
                                                               class="col-sm-3 col-form-label">Username</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="id" readonly
                                                                   class="form-control-plaintext" id="editId"
                                                                   value="${model.id}">
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="editPass"
                                                               class="col-sm-3 col-form-label">Password</label>
                                                        <div class="col-sm-9">
                                                            <input type="password" name="password"
                                                                   value="${model.password}"
                                                                   class="form-control-plaintext" id="editPass"
                                                                   readonly>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="editName"
                                                               class="col-sm-3 col-form-label">Fullname</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="fullname" value="${model.fullname}"
                                                                   class="form-control" id="editName">
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="editEmail"
                                                               class="col-sm-3 col-form-label">Email</label>
                                                        <div class="col-sm-9">
                                                            <input type="email" name="email" value="${model.email}"
                                                                   class="form-control" id="editEmail">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Close
                                                    </button>
                                                    <button formaction="/lab/5/bai4/edit-profile" type="submit"
                                                            class="btn btn-primary">Save changes
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>

                                    <!-- Modal-change-Password -->
                                    <div class="modal fade" id="changePassword" tabindex="-1"
                                         aria-labelledby="changePasswordLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <form action="/lab/5/bai4/change-password" method="post" id="formChangePass"
                                                  class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="changePasswordLabel">Edit Profile</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="mb-3 row">
                                                        <label for="editId" class="col-sm-4 col-form-label">Current
                                                            Password</label>
                                                        <div class="col-sm-8">
                                                            <input type="password" class="form-control" id="currentPass"
                                                                   required>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="editPass" class="col-sm-4 col-form-label">New
                                                            Password</label>
                                                        <div class="col-sm-8">
                                                            <input type="password" name="password" class="form-control"
                                                                   id="newPass" required>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="editName" class="col-sm-4 col-form-label">Repeat
                                                            Password</label>
                                                        <div class="col-sm-8">
                                                            <input type="password" class="form-control" id="repeatPass"
                                                                   required>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Close
                                                    </button>
                                                    <input value="Save changes" id="btnChangePass"
                                                           class="btn btn-primary">
                                                    <input type="hidden" name="id" value="${model.id}">
                                                    <input type="hidden" name="fullname" value="${model.fullname}">
                                                    <input type="hidden" name="email" value="${model.email}">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
<script>
    $(document).ready(function () {
        $("#myToast").toast({autohide: false});
        $("#myToast").toast('show');
    });

    var $pw = $("#pw");
    $pw.focus(function () {
        $pw.get(0).type = "text";
    });
    $pw.blur(function () {
        $pw.get(0).type = "password";
    });

    $('#btnChangePass').click(function () {
        if ($('#currentPass').val() == '${model.password}') {
            if ($('#newPass').val() == $('#repeatPass').val()) {
                Swal.fire({
                    icon: 'success',
                    title: 'Hooray!',
                    text: 'Password was changed!',
                }).then(function () {
                    $('#formChangePass').submit()
                })
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Repeat Password wrong!',
                })
            }
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Current Password wrong!',
            })
        }
    })

    $('#btnForgotPass').click(async function () {
        const {value: email} = await Swal.fire({
            title: 'Input email address',
            input: 'email',
            inputLabel: 'Your email address',
            inputPlaceholder: 'Enter your email address'
        })

        if (email) {
            Swal.fire(
                'Good job!',
                'An Email of your profile was sent to your email!',
                'success'
            ).then(function () {
                window.location.href = '/lab/5/bai4/forgot-password?email=' + email
            })
        }
    })
</script>
</body>