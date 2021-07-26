<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<fmt:setLocale value="${sessionScope.lang}" scope="request" />
<fmt:setBundle basename="global" scope="request" />

<head>
    <title>Lab 8</title>
</head>
<body>
<c:if test="${not empty message}">
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
<nav class="navbar navbar-expand-lg navbar-light bg-light"
     style="background-color: #FBAB7E;background-image: linear-gradient(33deg, #FBAB7E 0%, #F7CE68 100%);z-index: 2;">
    <div class="container-fluid">
        <a class="navbar-brand" href="/lab/8">
            <img src="https://image.flaticon.com/icons/png/512/48/48651.png" alt="brand-img"
                 class="d-inline-block align-text-top" style="width: 10%;">
            <span class="text-danger fw-bold fs-3 text-uppercase">online entertainment</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-primary fw-bold fs-5" href="/lab/8/home"><fmt:message key="menu.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-primary fw-bold fs-5" href="/lab/8/about"><fmt:message
                            key="menu.about"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-primary fw-bold fs-5" href="/lab/8/contact"><fmt:message
                            key="menu.contact"/></a>
                </li>
                <c:if test="${empty model}">
                    <li class="nav-item">
                        <a class="nav-link text-primary fw-bold fs-5" href="/lab/5/bai4"><fmt:message
                                key="menu.login"/></a>
                    </li>
                </c:if>
                <c:if test="${not empty model}">
                    <li class="nav-item">
                        <a class="nav-link text-primary fw-bold fs-5" href="#"><fmt:message key="menu.favorite"/></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link text-primary fw-bold fs-5 dropdown-toggle" href="#" id="navbarDropdown"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            My Account
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/lab/8/edit-profile">Edit Profile</a></li>
                            <li><a class="dropdown-item" href="/lab/8/change-password">Change Password</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/lab/5/bai4/signout">Logout</a></li>
                        </ul>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="?lang=vi">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/2560px-Flag_of_Vietnam.svg.png"
                             alt="Flag_of_Vietnam" style="width: 40px;">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="?lang=en">
                        <img src="https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1200px-Flag_of_the_United_Kingdom.svg.png"
                             alt="Flag_of_Vietnam" style="width: 40px;height: 26.67px;">
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
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
                                                    <button formaction="/lab/8/edit-profile" type="submit"
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
                                            <form action="/lab/8/change-password" method="post" id="formChangePass"
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
<jsp:include page="${view}"/>
<div class="position-absolute bottom-0 w-100 bg-dark text-light text-center" style="height: 50px; line-height: 50px;">
    &copy;2021 by XuShiTa. All rights reserved.
</div>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js "
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM "
        crossorigin="anonymous "></script>
</body>