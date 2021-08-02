<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/movie"/>
<c:url var="listMovieURL" value="/admin/movie"/>

<head>
    <title>Movies Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Movie list</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/movie/edit" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-video-plus bx-tada-hover'></i>
        </a>
    </div>
    <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th></th>
            <th>Poster</th>
            <th>Title</th>
            <th>Director</th>
            <th>Actors</th>
            <th>Producer</th>
            <th>Country</th>
            <th>Categories</th>
            <th>Runtime</th>
            <th>Release</th>
            <th>View</th>
            <th>Like</th>
            <th>Trailer</th>
            <th>ID</th>
            <th>Description</th>
            <th>Banner</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movies}" var="i" varStatus="count">
            <tr>
                <td class="text-center">${count.count}</td>
                <td class="text-center">
                    <c:url var="updateMovieURL" value="/admin/movie/edit">
                        <c:param name="id" value="${i.id}"/>
                    </c:url>
                    <a href="${updateMovieURL}" style="color: #a900d4;"><i class='bx bxs-edit bx-md bx-tada-hover'></i></a>
                    <span onclick="btnDelete(${i.id})" style="color: red; cursor: pointer;"><i
                            class='bx bxs-trash bx-md bx-tada-hover'></i></span>
                </td>
                <td>
                    <img src="${i.poster}" height="100" alt="">
                </td>
                <td>${i.title}</td>
                <td>${i.director}</td>
                <td>${i.actors}</td>
                <td>${i.producer}</td>
                <td>${i.country}</td>
                <td>
                    <c:forEach items="${i.categories}" var="cate">
                        ${cate.name},
                    </c:forEach>
                </td>
                <td>${i.runtime}</td>
                <td>${i.releaseYear}</td>
                <td>${i.viewCount}</td>
                <td>${i.likeCount}</td>
                <td>${i.trailer}</td>
                <td>${i.id}</td>
                <td>${i.description}</td>
                <td>
                    <img src="${i.banner}" height="100" alt="">
                </td>
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
                deleteNew(ids);
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your imaginary file is safe :)',
                    'error'
                )
            }
        })
    }

    function deleteNew(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                Swal.fire(
                    'Nice!',
                    'The movie has been deleted',
                    'success'
                ).then(() => {
                    window.location.href = "${listMovieURL}";
                })
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong!',
                }).then(() => {
                    window.location.href = "${listMovieURL}";
                })
            }
        });
    }
</script>
</body>