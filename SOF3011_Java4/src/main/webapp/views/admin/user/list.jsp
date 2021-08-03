<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/user"/>
<c:url var="listURL" value="/admin/user"/>

<head>
    <title>Users Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">User list</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/user/edit" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-user-plus bx-tada-hover'></i>
        </a>
    </div>
    <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th></th>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Status</th>
            <th>Fullname</th>
            <th>Email</th>
            <th>Verify</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="i" varStatus="count">
            <tr>
                <td class="text-center">${count.count}</td>
                <td class="text-center">
                    <c:url var="editURL" value="/admin/user/edit">
                        <c:param name="id" value="${i.id}"/>
                    </c:url>
                    <a href="${editURL}" style="color: #a900d4;"><i class='bx bxs-edit bx-md bx-tada-hover'></i></a>
                    <span onclick="btnDelete(${i.id})" style="color: red; cursor: pointer;">
                    	<i class='bx bxs-trash bx-md bx-tada-hover'></i>
                    </span>
                    <c:if test="${i.status}">
                    <span onclick="btnLock(${i.id})" style="color: #004ad2; cursor: pointer;">
                    	<i class='bx bxs-lock-alt bx-md bx-tada-hover'></i>
                    </span>
                    </c:if>

                    <c:if test="${!i.status}">
                    <span onclick="btnUnlock(${i.id})" style="color: #4fb700; cursor: pointer;">
                    	<i class='bx bx-lock-open-alt bx-md bx-tada-hover'></i>
                    </span>
                    </c:if>
                </td>
                <td>${i.id}</td>
                <td>${i.username}</td>
                <td><input type="password" class="form-control" value="${i.password}" disabled></td>
                <td>${i.role?"Admin":"User"}</td>
                <td>${i.status?"Active":"Blocked"}</td>
                <td>${i.fullname}</td>
                <td>${i.email}</td>
                <td>${i.verify}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        var table = $('#example').DataTable({
            lengthChange: false,
            buttons: ['copy', 'excel', 'pdf', 'colvis'],
            colReorder: true,

            responsive: true,
            select: true
        });

        table.buttons().container()
            .appendTo('#example_wrapper .col-md-6:eq(0)');
    });

    //Button Lock
    function btnLock(id) {
        var data = {};
        data["id"] = id;
        data["status"] = 0;
        changeStatus(data);
    }

    //Button Unlock
    function btnUnlock(id) {
        var data = {};
        data["id"] = id;
        data["status"] = 1;
        changeStatus(data);
    }

    //Call API Put change status (lock/unlock)
    function changeStatus(data) {
        $.ajax({
            url: '${apiURL}/status',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if (result.status) {
                    Swal.fire({
                        icon: 'success',
                        title: 'User unlocked! 🎉🎉',
                        text: 'User is active now',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                    }).then(() => {
                        window.location.href = "${listURL}";
                    })
                } else {
                    Swal.fire({
                        icon: 'success',
                        title: 'User blocked! 🔒🔒',
                        text: 'User is inactive',
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
                    text: 'Something went wrong! 😶😶',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                })
            }
        })
    }


    //Button Delete
    function btnDelete(id) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                var ids = {"ids": [id]};
                deleteUser(ids);
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your data is safe 😘',
                    'error'
                )
            }
        })
    }

    //Call API Delete
    function deleteUser(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                Swal.fire(
                    'Nice!',
                    'The user has been deleted',
                    'success'
                ).then(() => {
                    window.location.href = "${listURL}";
                })
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong!',
                })
            }
        });
    }
</script>
</body>