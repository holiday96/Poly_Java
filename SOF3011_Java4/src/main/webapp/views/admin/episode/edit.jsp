<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/episode"/>
<c:url var="editURL" value="/admin/episode/edit"/>
<c:url var="listURL" value="/admin/episode"/>

<head>
    <title>Episodes Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Edit episode</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/episode" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-left-arrow-circle bx-fade-left-hover'></i>
        </a>
    </div>
    <div class="row row-cols-auto" style="color: darkblue;">
        <h3>Movie Detail</h3>
    </div>
    <div class="row row-cols-auto">
        <div class="col">
            <div><img class="rounded" src="https://picsum.photos/200/300" alt="poster.png"></div>
            <div class="row my-2 ps-2">
                <div class="col like position-relative">
                    <i class='bx bxs-heart' style="color: red; font-size: 20px;"></i>
                    <span class="position-absolute" style="font-size: 15px; left: 47px;">${movie.likeCount}</span>
                </div>
                <div class="col view position-relative">
                    <i class='bx bx-show' style="color: #2300e4; font-size: 20px;"></i>
                    <span class="position-absolute" style="font-size: 15px; left: 35px;">${movie.likeCount}</span>
                </div>
            </div>
        </div>
        <div class="col">
            <table class="table table-borderless">
                <tr>
                    <th class="fw-bold">Movie ID</th>
                    <td>${movie.id}</td>
                </tr>
                <tr>
                    <th class="fw-bold">Title</th>
                    <td>${movie.title}</td>
                </tr>
                <tr>
                    <th class="fw-bold">Director</th>
                    <td>${movie.director}</td>
                </tr>
                <tr>
                    <th class="fw-bold">Actors</th>
                </tr>
                <tr>
                    <th class="fw-bold">Producer</th>
                    <td>${movie.producer}</td>
                </tr>
                <tr>
                    <th class="fw-bold">Country</th>
                    <td>${movie.country}</td>
                <tr>
                    <th class="fw-bold">Categories</th>
                    <td>
                        <c:forEach items="${movie.categories}" var="cate">
                            ${cate.name}<br>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <th class="fw-bold">Runtime</th>
                    <td>
                        <c:if test="${not empty movie.runtime}">${movie.runtime} min</c:if>
                    </td>
                </tr>
                <tr>
                    <th class="fw-bold">Release</th>
                    <td>${movie.releaseYear}</td>
                </tr>
                <tr>
                    <th class="fw-bold">Trailer</th>
                    <td><a href="${movie.trailer}" style="text-decoration: none;">${movie.trailer}</a></td>
                </tr>
            </table>
        </div>
        <div class="col ps-5">
            <h5>Description</h5>
            ${movie.description}
        </div>
    </div>
    <form id="formSubmit">
        <div class="row row-cols-auto mt-4" style="color: darkblue;">
            <h3>Episode Detail</h3>
        </div>
        <div class="row-cols-auto">
            <c:if test="${not empty param.id}">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="id" placeholder="id"
                           value="${episode.id}" disabled>
                    <label for="id">ID</label>
                </div>
            </c:if>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="number" id="number" placeholder="number"
                       value="${episode.number}">
                <label for="number">Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" name="link" id="link" placeholder="link"
                       value="${episode.link}">
                <label for="link">Source</label>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <input type="button" class="btn btn-primary" name="btnConfirm" id="btnConfirm" value="Confirm">
            </div>
        </div>
        <input type="hidden" name="id" id="episodeId" value="${episode.id}">
        <input type="hidden" name="movieid" id="movieid" value="${movie.id}">
    </form>
</div>
<script>
    //Button Submit form
    $('#btnConfirm').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
		console.log(data);
        var id = $('#episodeId').val();
        if (id == "") {
            add(data);
        } else {
            update(data);
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
                Swal.fire({
                    icon: 'success',
                    title: 'Hooray 🎊🎊',
                    text: 'New episode has been added!',
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

    //Put submit
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
                    title: 'Success 🥳🥳',
                    text: 'Episode has been updated!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                }).then(() => {
                    window.location.href = "${editURL}?movieid=" + ${movie.id} +"&id=" + result.id;
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