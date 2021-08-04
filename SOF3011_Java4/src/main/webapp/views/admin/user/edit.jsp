<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/user"/>
<c:url var="editURL" value="/admin/user/edit"/>
<c:url var="listURL" value="/admin/user"/>

<head>
    <title>User Management</title>
</head>
<body>

<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Edit user</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/user" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-left-arrow-circle bx-fade-left-hover'></i>
        </a>
    </div>
    <form id="formSubmit">
        <div class="row">
            <div class="col">
                <div class="row row-cols-auto">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="username" id="username" placeholder="username"
                                   value="${user.username}" <c:if test="${not empty param.id}">readonly</c:if>>
                            <label for="username">Username<span class="fw-bold"
                                                                style="color: red; font-size: 17px;">*</span></label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="role" id="role">
                                <option selected disabled>-- Select Role --</option>
                                <option value="1" ${user.role?"selected":""}>Admin</option>
                                <option value="0" ${user.role?"":"selected"}>User</option>
                            </select>
                            <label for="role">Role</label>
                        </div>
                    </div>
                </div>
                <div class="row row-cols-auto">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="password" class="form-control" name="password" id="password"
                                   placeholder="password" value="${user.password}">
                            <label for="password">Password<span class="fw-bold"
                                                                style="color: red; font-size: 17px;">*</span></label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <select class="form-select" name="status" id="status">
                                <option selected disabled>-- Select Status --</option>
                                <option value="1" ${user.status?"selected":""}>Active</option>
                                <option value="0" ${user.status?"":"selected"}>Block</option>
                            </select>
                            <label for="status">Status</label>
                        </div>
                    </div>
                </div>
                <div class="row row-cols-auto">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="fullname" id="fullname"
                                   placeholder="fullname" value="${user.fullname}">
                            <label for="fullname">Fullname</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <input type="email" class="form-control" name="email" id="email" placeholder="email"
                                   value="${user.email}" <c:if test="${not empty param.id}">readonly</c:if>>
                            <label for="email">Email<span class="fw-bold" style="color: red; font-size: 17px;">*</span></label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="verify" id="verify" placeholder="verify"
                                   value="${user.verify}">
                            <label for="verify">Verify link</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <input type="button" class="btn btn-primary" name="btnConfirm" id="btnConfirm" value="Confirm">
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" id="id" name="id" value="${user.id}">
    </form>
</div>
<script>
    //Button Submit form
    $('#btnConfirm').click(function (e) {
        e.preventDefault();
        if (!$('#username').val()) {
            $('#username').addClass("is-invalid");
        } else {
            $('#username').removeClass("is-invalid");
            $('#username').addClass("is-valid");

            if (!$('#password').val()) {
                $('#password').addClass("is-invalid");
            } else {
                $('#password').removeClass("is-invalid");
                $('#password').addClass("is-valid");

                if (!$('#email').val()) {
                    $('#email').addClass("is-invalid");
                } else {
                    $('#email').removeClass("is-invalid");
                    $('#email').addClass("is-valid");
                    var data = {};
                    var formData = $('#formSubmit').serializeArray();
                    $.each(formData, function (i, v) {
                        data["" + v.name + ""] = v.value;
                    });
                    if ($("#role option:selected").val() == "0") {
                        data["role"] = 0;
                    } else {
                        data["role"] = 1;
                    }
                    if ($("#status option:selected").val() == "0") {
                        data["status"] = 0;
                    } else {
                        data["status"] = 1;
                    }

                    var id = $('#id').val();
                    if (id == "") {
                        add(data);
                    } else {
                        update(data);
                    }
                }
            }
        }
    });

    //Post submit
    function add(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if (result == "email exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Email already exists!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else if (result == "username exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Username already exists!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else {
                    Swal.fire({
                        icon: 'success',
                        title: 'Hooray 🎊🎊',
                        text: 'User has been added!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    }).then(() => {
                        window.location.href = "${listURL}";
                    })
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

    //Put submit
    function update(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if (result == "email exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Email already exists!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else if (result == "username exist") {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: 'Username already exists!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    })
                } else {
                    Swal.fire({
                        icon: 'success',
                        title: 'Success 🥳🥳',
                        text: 'User has been updated!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    }).then(() => {
                        window.location.href = "${editURL}?id=" + result.id;
                    })
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
</body>