<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/movie"/>
<c:url var="apiAddCategoryURL" value="/api/category"/>
<c:url var="editMovieURL" value="/admin/movie/edit"/>
<c:url var="listURL" value="/admin/movie"/>

<head>
    <title>Movies Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Edit movie</span>
</div>
<div class="container rounded bg-light p-3">
    <div class="d-flex flex-row-reverse">
        <a href="/admin/movie" style="color: #2a8e00; font-size: 50px;">
            <i class='bx bxs-left-arrow-circle bx-fade-left-hover'></i>
        </a>
    </div>
    <form id="formSubmit">
        <div class="row">
            <div class="col">
                <div class="row row-cols-auto">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="poster" id="poster" placeholder="poster"
                                   value="${movie.poster}">
                            <label for="poster">Poster</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="title" id="title" placeholder="title"
                                   value="${movie.title}">
                            <label for="title">Title</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col">
                                <select id="itemCategory" class="form-select mb-3" size="4"
                                        aria-label="size 3 select example">
                                    <c:forEach items="${categories}" var="i">
                                        <option value="${i.id}">${i.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-2">
                                <i id="btnAddCategory" class='bx bxs-chevrons-right bx-md bx-fade-right-hover'
                                   style="color: #298c00; cursor: pointer; margin-top: 8px;"></i>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-10">
                                <div class="input-group mb-3">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="newCategory"
                                               placeholder="newCategory">
                                        <label for="newCategory">New Category</label>
                                    </div>
                                    <div id="btnAddNewCategory" class="form-control" style="cursor: pointer;">
                                        <i class='bx bx-customize bx-md bx-burst-hover'
                                           style="color: #298c00;"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-5 mb-3">
                        <div class="row" style="height: 100%;">
                            <div class="col">
                                <div class="input-group mb-3" style="height: 100%;">
                                    <select id="showCategory" class="form-select mb-3" size="6" style="height: 100%;">
                                        <c:forEach items="${movie.categories}" var="i">
                                            <option value="${i.id}">${i.name}</option>
                                        </c:forEach>
                                    </select>
                                    <i id="btnDelete" class='bx bxs-trash bx-md text-danger bx-flashing-hover ms-2'
                                       style="align-self: center; cursor:pointer;"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="director" id="director"
                                   value="${movie.director}"
                                   placeholder="director">
                            <label for="director">Director</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="producer" id="producer"
                                   value="${movie.producer}"
                                   placeholder="producer">
                            <label for="producer">Producer</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="actors" id="actors" placeholder="actors"
                                   value="${movie.actors}">
                            <label for="actors">Actors</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="country" id="country" placeholder="country"
                                   value="${movie.country}">
                            <label for="country">Country</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" name="runtime" id="runtime" placeholder="runtime"
                                   value="${movie.runtime}">
                            <label for="runtime">Runtime</label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" name="releaseYear" id="releaseYear"
                                   value="${movie.releaseYear}"
                                   placeholder="release">
                            <label for="releaseYear">Release</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="trailer" id="trailer" placeholder="trailer"
                                   value="${movie.trailer}">
                            <label for="trailer">Trailer</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="banner" id="banner" placeholder="banner"
                                   value="${movie.banner}">
                            <label for="banner">Banner</label>
                        </div>
                    </div>
                </div>
                <div class="row row-cols-auto">
                    <div class="col">
                        <input type="button" class="btn btn-primary" name="btnConfirm" id="btnConfirm" value="Confirm">
                    </div>
                </div>
            </div>
            <div class="col">
                <label for="description" class="form-label fs-4">Description</label>
                <textarea class="form-control" name="description" id="description" placeholder="description"
                          style="height: 100%;">${movie.description}</textarea>
            </div>
        </div>
        <input type="hidden" id="id" name="id" value="${movie.id}">
    </form>
</div>
<script>
    var editor = '';
    var categories = [];
    $(document).ready(function () {
        editor = CKEDITOR.replace('description', {
            height: $('#formSubmit').height() * 0.8
        });

        $("#showCategory option").each(function () {
            categories.push($(this).val());
        });
    });

    //Add category movie
    $('#btnAddCategory').click(function (e) {
        e.preventDefault();
        var text = $("#itemCategory option:selected").text();
        var value = $("#itemCategory option:selected").val();
        if (!categories.includes(value)) {
            categories.push(value);
            $('#showCategory').append(new Option(text, value));
        } else {
            Swal.fire({
                icon: 'warning',
                title: 'Oops...',
                text: 'This category has been added to the movie!',
                confirmButtonText: 'OK',
                timer: 2000
            })
        }
    });

    //Button Delete
    $('#btnDelete').click(function (e) {
        e.preventDefault();
        var item = $("#showCategory option:selected").val();
        categories = $.grep(categories, function (value) {
            return value != item;
        });

        $("#showCategory option:selected").remove();
    });

    //Button Submit form
    $('#btnConfirm').click(function (e) {
        e.preventDefault();
        if ($('#poster').val() == "") {
            $('#poster').addClass("is-invalid");
        }
        if ($('#title').val() == "") {
            $('#title').addClass("is-invalid");
        }
        if ($('#trailer').val() == "") {
            $('#trailer').addClass("is-invalid");
        }
        if ($('#poster').val() != "" && $('#title').val() != "" && $('#trailer').val() != "") {
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });
            data["description"] = editor.getData();
            data["idsCategory"] = categories;

            var id = $('#id').val();
            if (id == "") {
                add(data);
            } else {
                update(data);
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
                Swal.fire({
                    icon: 'success',
                    title: 'Hooray',
                    text: 'Your movie has been added!',
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
                    title: 'Yay',
                    text: 'Your movie has been updated!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                }).then(() => {
                    window.location.href = "${editMovieURL}?id=" + result.id;
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

    //Button AddNewCategory
    $('#btnAddNewCategory').click(function (e) {
        e.preventDefault();
        if ($('#newCategory').val() == "") {
            $('#newCategory').addClass("is-invalid");
        } else {
            var data = {name: $('#newCategory').val()};
            addCategory(data);
        }
    });

    //API add NewCategory
    function addCategory(data) {
        $.ajax({
            url: '${apiAddCategoryURL}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#itemCategory').append(new Option(result.name, result.id));
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                })

                Toast.fire({
                    icon: 'success',
                    title: 'New Category has been added'
                })
            },
            error: function (error) {
                const Toast = Swal.mixin({
                    toast: true,
                    position: 'top-end',
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    didOpen: (toast) => {
                        toast.addEventListener('mouseenter', Swal.stopTimer)
                        toast.addEventListener('mouseleave', Swal.resumeTimer)
                    }
                })

                Toast.fire({
                    icon: 'error',
                    title: 'Error when adding category'
                })
            }
        })
    }
</script>
</body>