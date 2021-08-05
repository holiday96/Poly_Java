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
    <i class='bx bx-menu'></i> <span class="text">Edit theme</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/theme" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-left-arrow-circle bx-fade-left-hover'></i>
        </a>
    </div>
    <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th>Poster</th>
            <th>ID</th>
            <th>Title</th>
            <th>Director</th>
            <th>Actors</th>
            <th>Producer</th>
            <th>Country</th>
            <th>Runtime</th>
            <th>Release</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${moviesAdded}" var="i" varStatus="count">
            <tr>
                <td></td>
                <td class="text-center">
                    <input type="checkbox" class="idsMovie" name="idsMovie" value="${i.id}" checked>
                </td>
                <td>
                    <img src="${i.poster}" height="100" alt="">
                </td>
                <td>${i.id}</td>
                <td>${i.title}</td>
                <td>${i.director}</td>
                <td>${i.actors}</td>
                <td>${i.producer}</td>
                <td>${i.country}</td>
                <td>
                    <c:if test="${not empty i.runtime}">${i.runtime} min</c:if>
                </td>
                <td>${i.releaseYear}</td>
            </tr>
        </c:forEach>
        <c:forEach items="${movies}" var="i" varStatus="count">
            <tr>
                <td></td>
                <td class="text-center">
                    <input type="checkbox" class="idsMovie" name="idsMovie" value="${i.id}">
                </td>
                <td>
                    <img src="${i.poster}" height="100" alt="">
                </td>
                <td>${i.id}</td>
                <td>${i.title}</td>
                <td>${i.director}</td>
                <td>${i.actors}</td>
                <td>${i.producer}</td>
                <td>${i.country}</td>
                <td>
                    <c:if test="${not empty i.runtime}">${i.runtime} min</c:if>
                </td>
                <td>${i.releaseYear}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button id="btnConfirm" class="btn btn-primary">Confirm</button>
    <input type="hidden" id="listAdded" value="${listAdded}">
</div>
<script>
    var idsMovie = [];
    $(document).ready(function () {
        var table = $('#example').DataTable({
            lengthChange: false,
            colReorder: true,

            responsive: true,
        });

        table.buttons().container()
            .appendTo('#example_wrapper .col-md-6:eq(0)');
    });

    //Button Confirm
    $('#btnConfirm').click(function (e) {
        e.preventDefault();
        $.each($("input[name='idsMovie']:checked"), function () {
            idsMovie.push($(this).val());
        });
        var data = {};
        data['id'] =${param.id};
        data['idsMovie'] = idsMovie;
        update(data);
    });

    //Call API Put
    function update(data) {
        $.ajax({
            url: '${apiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire({
                    icon: 'success',
                    title: 'Yooo 🤩🤩',
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
</script>
</body>