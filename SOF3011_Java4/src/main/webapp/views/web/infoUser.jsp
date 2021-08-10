<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="container text-light">
    <table class="mx-auto mb-3">
        <tr>
            <th class="pe-5">Fullname</th>
            <td>${USER.fullname}</td>
        </tr>
        <tr>
            <th>Username</th>
            <td>${USER.username}</td>
        </tr>
        <tr>
            <th>Email</th>
            <td>${USER.email}</td>
        </tr>
        <tr>
            <th>Access</th>
            <th>${USER.role?"ADMIN":"USER"}</th>
        </tr>
    </table>
    <div class="text-center">
        <button onclick="changeEmail()" class="btn btn-primary btn-sm">Change Email</button>
        <button onclick="changePassword()" class="btn btn-warning btn-sm">Change Password</button>
    </div>
</div>
<script>
    async function changeEmail() {
        const {value: email} = await Swal.fire({
            title: 'Input email address',
            input: 'email',
            inputLabel: 'Make sure you enter it correctly',
            html: 'Email can be used to retrieve the password',
            inputPlaceholder: 'Enter your email address'
        })

        if (email) {
            var data = {};
            data["id"] = ${USER.id};
            data["email"] = email;
            apiChangeEmail(data);
        }
    }

    //Put submit
    function apiChangeEmail(data) {
        $.ajax({
            url: '/api/user/changeEmail',
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
                } else {
                    Swal.fire({
                        icon: 'success',
                        title: 'Success 🥳🥳',
                        text: 'User has been updated!',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    }).then(() => {
                        window.location.href = "/logout";
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

    async function changePassword() {
        const {value: formValues} = await Swal.fire({
            title: "Change Password",
            html:
                `<input type="password" placeholder="Current password" id="currentPassword" class="swal2-input">` +
                `<input type="password" placeholder="New password" id="newPassword" class="swal2-input">` +
                `<input type="password" placeholder="Confirm password" id="confirmPassword" class="swal2-input">`,
            focusConfirm: false,
            preConfirm: () => {
                return [
                    document.getElementById("currentPassword").value,
                    document.getElementById("newPassword").value,
                    document.getElementById("confirmPassword").value,
                ];
            },
        });
        if (formValues) {
            var current = '${USER.password}';
            if (formValues[0] == "") {
                Swal.fire({
                    icon: "info",
                    title: "Miss something??",
                    text: "Please type current password first!",
                });
            } else if (formValues[0] != current) {
                Swal.fire({
                    icon: "error",
                    title: "Oops...",
                    text: "Current password incorrect!",
                });
            } else {
                if (formValues[1] == "") {
                    Swal.fire({
                        icon: "info",
                        title: "One more step??",
                        text: "Please type new password!",
                    });
                } else if (formValues[1] != formValues[2]) {
                    Swal.fire({
                        icon: "error",
                        title: "Oops...",
                        text: "Confirm password incorrect!",
                    });
                } else {
                    Swal.fire("Nice work!", "Password has been changed!", "success").then(() => {
                        var data = {};
                        data["id"] = ${USER.id};
                        data['password'] = formValues[2];
                        apiChangePassword(data);
                    });
                }
            }
        }
    }

    //Put submit
    function apiChangePassword(data) {
        $.ajax({
            url: '/api/user/changePassword',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire({
                    icon: 'success',
                    title: 'Success 🥳🥳',
                    text: 'User has been updated!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                }).then(() => {
                    window.location.href = "/logout"
                })
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
    };
</script>