<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 5 Bài 3</title>
</head>
<body>
<c:if test="${not empty message }">
    <div class="toast" id="myToast" style="position: absolute; top: 10px; right: 10px;">
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
<div class="container my-5 py-5 rounded"
     style="background-color: #D9AFD9; background-image: linear-gradient(30deg, #D9AFD9 0%, #97D9E1 100%);">
    <h1 class="text-primary">User Management</h1>
    <div class="row g-5">
        <div class="col-md-4">
            <h4 class="text-secondary">User Edition</h4>
            <form action="/lab/5/bai3" class="p-3 rounded-2" id="userForm" method="post"
                  style="background-color: #FBAB7E; background-image: linear-gradient(244deg, #FBAB7E 0%, #F7CE68 100%);">
                <div class="mb-3">
                    <input type="text" class="form-control" name="id" id="id" placeholder="Username"
                           value="${user.id}" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" id="password" placeholder="Password"
                           value="${user.password}" required>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="fullname" id="fullname" placeholder="Fullname"
                           value="${user.fullname}" required>
                </div>
                <div class="mb-3">
                    <input type="email" class="form-control" name="email" id="email" placeholder="Email"
                           value="${user.email}" required>
                </div>
                <div class="mb-3">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="admin" id="admin"
                               value="true" ${user.admin?"checked":""} required>
                        <label class="form-check-label" for="admin">Admin</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="admin" id="user"
                               value="false" ${user.admin?"":"checked"} required>
                        <label class="form-check-label" for="user">User</label>
                    </div>
                </div>
                <div class="btn-group" role="group">
                    <button type="submit" formaction="/lab/5/bai3/add" id="btnAdd" class="btn btn-success btn-sm"
                            value="Add">Add
                    </button>
                    <button type="submit" formaction="/lab/5/bai3/edit" id="btnUpdate" class="btn btn-info btn-sm"
                            value="Update">Update
                    </button>
                    <input type="button" id="btnReset" class="btn btn-secondary btn-sm" value="Reset"/>
                </div>
            </form>
        </div>
        <div class="col-md-8 px-3">
            <h4 class="text-secondary">User List</h4>
            <div class="bg-light rounded p-2">
                <table class="display" id="table_id">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Username</th>
                        <th scope="col">Password</th>
                        <th scope="col">Fullname</th>
                        <th scope="col">Email</th>
                        <th scope="col">Role</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="item" varStatus="theUser">
                        <tr>
                            <th scope="row">${theUser.count}</th>
                            <td>${item.id}</td>
                            <td><input type="password" class="text-muted f-w-400 bg-transparent" readonly
                                       style="border-style: none; width: 150px;" value="${item.password}"/></td>
                            <td>${item.fullname}</td>
                            <td>${item.email}</td>
                            <td>${item.admin?"Admin":"User"}</td>
                            <td>
                                <c:url var="editURL" value="/lab/5/bai3">
                                    <c:param name="type" value="edit"/>
                                    <c:param name="id" value="${item.id}"/>
                                </c:url>
                                <c:url var="deleteURL" value="/lab/5/bai3">
                                    <c:param name="type" value="delete"/>
                                    <c:param name="id" value="${item.id}"/>
                                </c:url>
                                <a href="${editURL}" type="button" id="btnEdit" class="btn btn-primary btn-sm">Edit</a>
                                <a href="${deleteURL}" type="button" id="btnDelete"
                                   class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#table_id').DataTable({});

        $("#myToast").toast({autohide: true, delay: 3000});
        $("#myToast").toast('show');
    });

    $('#btnReset').click(function () {
        $('#id').val('');
        $('#password').val('');
        $('#fullname').val('');
        $('#email').val('');
        $('input[name="admin"]').prop('checked', false);
    })
</script>
</body>