<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="APIurl" value="/lab/lab5/category"/>

<div class="col-auto me-auto text-uppercase fw-bold fs-1 mb-3" style="color: yellow">Category Management</div>
<div class="form">
    <form:form action="/lab/lab5/category/create" modelAttribute="categoryItem" method="post">
        <div class="row mb-3">
            <div class="col">
                <div class="form-floating">
                    <form:input path="code" cssClass="form-control" placeholder="Code"/>
                    <form:label path="code">Code</form:label>
                 	<form:errors path="code" cssClass="error"/>
                </div>
            </div>
            <div class="col">
                <div class="form-floating">
                    <form:input path="name" cssClass="form-control" placeholder="Name"/>
                    <form:label path="name">Name</form:label>
                 	<form:errors path="name" cssClass="error"/>
                </div>
            </div>
            <form:button class="col-auto btn btn-success">
                <i class='bx bx-plus-medical'></i>
            </form:button>
        </div>
        <div class="row mb-3">
            <div class="success">${param.success}</div>
            <div class="error">${param.error}</div>
        </div>
    </form:form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Code</th>
            <th scope="col">Name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="i">
            <tr>
                <th>${i.id}</th>
                <td>${i.code}</td>
                <td>${i.name}</td>
                <td>
                    <i onclick="edit(${i.id}, '${i.code}', '${i.name}')" class='bx bxs-edit bx-flashing-hover'
                       style='color:#ba20f9; font-size: 32px;'></i>
                    <i onclick="deleteCategory(${i.id})" class='bx bxs-trash bx-flashing-hover'
                       style='color:#de0303; font-size: 32px;'></i>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit</h5>
            </div>
            <div class="modal-body">
                <form action="/lab/lab5/category" method="post">
                    <div class="row mb-3">
                        <div class="col">
                            <div class="form-floating">
                                <input id="codeModal" name="code" class="form-control" placeholder="Code"/>
                                <label for="codeModal">Code</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-floating">
                                <input id="nameModal" name="name" class="form-control" placeholder="Name"/>
                                <label for="nameModal">Name</label>
                            </div>
                        </div>
                        <div class="col-auto align-self-center">
                            <button class="btn btn-primary">Save</button>
                        </div>
                        <input type="hidden" id="idModal" name="id"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#lab5').addClass("active");
    });

    function edit(id, code, name) {
        $('#codeModal').val(code);
        $('#nameModal').val(name);
        $('#idModal').val(id);
        $('#editModal').modal('toggle');
    }

    function deleteCategory(data) {
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
                $.ajax({
                    url: '${APIurl}',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'Your file has been deleted.',
                            'success'
                        ).then(() => {
                            window.location.href = "${APIurl}"
                        });
                    },
                    error: function (error) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Oops...',
                            text: 'Something went wrong!'
                        })
                        console.log(error);
                    }
                });
            } else if (
                result.dismiss === Swal.DismissReason.cancel
            ) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your imaginary file is safe 🥳🥳',
                    'error'
                )
            }
        })

    }
</script>