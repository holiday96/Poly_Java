<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/theme"/>
<c:url var="listURL" value="/admin/theme"/>

<head>
    <title>Themes Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Theme list</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <span onclick="btnAdd()" style="color: #2a8e00; font-size: 50px; cursor: pointer;">
            <i class='bx bxs-add-to-queue bx-tada-hover'></i>
        </span>
    </div>
    <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th></th>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${themes}" var="i" varStatus="count">
            <tr>
                <td class="text-center">${count.count}</td>
                <td class="text-center">
                    <a href="/admin/theme/edit?id=${i.id}" style="color: #3ac500">
                        <i class='bx bx-plus-circle bx-md bx-tada-hover'></i>
                    </a>
                    <span onclick="btnEdit(${i.id})" style="color: #a900d4; cursor: pointer;">
                    	<i class='bx bxs-edit bx-md bx-tada-hover'></i>
                    </span>
                    <span onclick="btnDelete(${i.id})" style="color: red; cursor: pointer;">
                    	<i class='bx bxs-trash bx-md bx-tada-hover'></i>
                    </span>
                </td>
                <td>${i.id}</td>
                <td>${i.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        var table = $('#example').DataTable({
            lengthChange: false,
            buttons: ['copy', 'excel', 'pdf'],
            colReorder: true,

            responsive: true,
            select: true
        });

        table.buttons().container()
            .appendTo('#example_wrapper .col-md-6:eq(0)');
    });

    //Button Add
    async function btnAdd() {
        const {value: name} = await Swal.fire({
            title: 'Add Theme',
            input: 'text',
            inputLabel: 'Input theme name',
            inputPlaceholder: 'Enter name'
        })

        if (name) {
            var data = {
                name: name
            };
            addTheme(data);
        }
    }

    //Call API Post
    function addTheme(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire({
                    icon: 'success',
                    title: 'Yay',
                    text: 'New Theme has been added!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                }).then(() => {
                    window.location.href = "${listURL}";
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
    }

    //Button Edit
    async function btnEdit(id) {
        const {value: name} = await Swal.fire({
            title: 'Input Theme name',
            input: 'text',
            inputLabel: 'ID = ' + id,
            inputPlaceholder: 'Enter name'
        })

        if (name) {
            var data = {
                id: id,
                name: name,
            };
            updateTheme(data);
        }
    }

    //Call API Put
    function updateTheme(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire({
                    icon: 'success',
                    title: 'Success 🎉🎉',
                    text: 'Theme has been updated!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                }).then(() => {
                    window.location.href = "${listURL}";
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
                deleteTheme(ids);
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
    function deleteTheme(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                Swal.fire(
                    'Nice!',
                    'The Theme has been deleted',
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