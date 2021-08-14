<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>
<c:url var="addFavorApiURL" value="/api/user/addFavor"/>
<c:url var="deleteFavorApiURL" value="/api/user/deleteFavor"/>
<c:url var="likeApiURL" value="/api/movie/like"/>

<head>
	<title>${movie.title}</title>
</head>
<body>
<div class="top-content iframe-container">
    <c:if test="${empty link}">
        <iframe width="100%" height="100%" src="${movie.trailer}" title="YouTube video player"
                frameborder="0" allow="fullscreen;"></iframe>
    </c:if>
    <c:if test="${not empty link}">
        <iframe width="100%" height="100%" src="${link}" frameborder="0" scrolling="0" allowfullscreen></iframe>
    </c:if>
</div>
<div class="episodes">
    <c:if test="${not empty param.ep}">
        <div class="episodes-title">Episodes</div>
        <c:forEach items="${episodes}" var="i">
            <a href="/movie?id=${movie.id}&ep=${i.id}" class="episode btn btn-warning btn-sm">${i.number}</a>
        </c:forEach>
    </c:if>
</div>
<div class="d-flex bottom-content mt-5">
    <div class="d-flex left-info col">
        <div class="detail-poster me-3 position-relative">
            <img src="${movie.poster}" alt=""/>
            <div id="btnAddFavor" class="movie-liked">
                <i class='bx bxs-bookmark-heart' style="color: red; fontSize: '25px';"></i> Add Favorite
            </div>
            <div id="btnDeleteFavor" class="movie-liked">
                <i class="fas fa-heart-broken" style="color: red; fontSize: '25px';"></i> Remove Favorite
            </div>
            <c:if test="${empty param.ep}">
                <div id="btnWatch" class="btnWatch-now">Watch Now</div>
            </c:if>
        </div>
        <div class="detail-info">
            <h4>${movie.title}</h4>
            <span>Content</span>
            <p>${movie.description}</p>
        </div>
    </div>
    <div class="right-info col-3">
        <table>
            <tbody>
            <tr>
                <td class="table-head">Episodes</td>
                <td class="table-value">
                    <c:if test="${countEpisode != 0}">${countEpisode} eps</c:if>
                    <c:if test="${countEpisode == 0}">Updating</c:if>
                </td>
            </tr>
            <tr>
                <td class="table-head">Runtime</td>
                <td class="table-value">
                    <c:if test="${movie.runtime > 0}">${movie.runtime} min</c:if>
                    <c:if test="${empty movie.runtime}">Updating</c:if>
                </td>
            </tr>
            <tr>
                <td class="table-head">Actors</td>
                <td class="table-value">
                    <c:if test="${not empty movie.actors}">${movie.actors}</c:if>
                    <c:if test="${empty movie.actors}">Updating</c:if>
                </td>
            </tr>
            <tr>
                <td class="table-head">Country</td>
                <td class="table-value">${movie.country}</td>
            </tr>
            <tr>
                <td class="table-head">Genre</td>
                <td class="table-value">
                    <c:if test="${not empty movie.categories}">
                        <c:forEach items="${movie.categories}" var="i">
                            ${i.name},
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty movie.categories}">Updating</c:if>
                </td>
            </tr>
            <tr>
                <td class="table-head">Releases</td>
                <td class="table-value">
                    <c:if test="${not empty movie.releaseYear}">${movie.releaseYear}</c:if>
                    <c:if test="${empty movie.releaseYear}">Updating</c:if>
                </td>
            </tr>
            <tr>
                <td class="table-head">View</td>
                <td class="table-value">${movie.viewCount}</td>
            </tr>
            <tr>
                <td class="table-head">Like</td>
                <td class="table-value">${movie.likeCount}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<input type="hidden" id="userId" value="${USER.id}">
<script>
    $(document).ready(function () {
        $('.episode').each(function (index) {
            if ($(this).html() == '${epNumber}') {
                $(this).css({"background-color": "#3f3567", "color": "white"});
            }
        })

        if (${countEpisode==0}) {
            $('#btnWatch').text("Updating");
            $('#btnWatch').css({"background-color": "#790b0b", "cursor": "default"});
        }

        var added = ${added};
        if (added != 0) {
            $('#btnDeleteFavor').css({"visibility": "visible"});
            $('#btnAddFavor').css({"visibility": "hidden"});
        } else {
            $('#btnDeleteFavor').css({"visibility": "hidden"});
            $('#btnAddFavor').css({"visibility": "visible"});
        }
    });

    $('#btnWatch').click(function btnWatch() {
        if (${countEpisode!=0}) {
            window.location.href = "movie?id=${movie.id}&ep=${episodes[0].id}";
        }
    });

    //Button Add favor
    $('#btnAddFavor').click(function (e) {
        if (${empty USER}) {
            Swal.fire({
                title: "Login to use the service!",
                showCancelButton: true,
                confirmButtonText: `Login`,
                confirmButtonColor: "#ff6500",
            }).then((result) => {
                if (result.isConfirmed)
                    window.location.href = "login";
            });
        } else {
            var data = {};
            data["id"] = $('#userId').val();
            data["idsMovie"] = [${param.id}];
            addFavor(data);
        }
    });

    function increaseCount() {
        var count = Number($('.count-favor').html()) + 1;
        $('.count-favor').text(count);
        var data = {};
        data["id"] = ${param.id};
        data["likeCount"] = ${movie.likeCount}+1;
        updateLike(data);
    }


    function decreaseCount() {
        var count = Number($('.count-favor').html()) - 1;
        $('.count-favor').text(count);
        var data = {};
        data["id"] = ${param.id};
        data["likeCount"] = ${movie.likeCount}-1;
        updateLike(data);
    }

    //Call API add favor user
    function addFavor(data) {
        $.ajax({
            url: '${addFavorApiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#btnDeleteFavor').css({"visibility": "visible"});
                $('#btnAddFavor').css({"visibility": "hidden"});
                increaseCount();
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                    backdrop: `
                        url("../templates/img/peachcat-love.gif")
                        right center
                        no-repeat
                      `,
                    didOpen: (toast) => {
                        toast.addEventListener("mouseenter", Swal.stopTimer);
                        toast.addEventListener("mouseleave", Swal.resumeTimer);
                    },
                });
                Toast.fire({
                    icon: "success",
                    title: "Added to your library successfully",
                });
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong! Please try again!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                })
            }
        })
    }

    //Button Remove favor
    $('#btnDeleteFavor').click(function (e) {
        var data = {};
        data["id"] = $('#userId').val();
        data["idsMovie"] = [${param.id}];
        deleteFavor(data);
    });

    //Call API delete favor user
    function deleteFavor(data) {
        $.ajax({
            url: '${deleteFavorApiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                $('#btnAddFavor').css({"visibility": "visible"});
                $('#btnDeleteFavor').css({"visibility": "hidden"});
                decreaseCount();
                const Toast = Swal.mixin({
                    toast: true,
                    position: "top-end",
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                    backdrop: `
            	      url("../templates/img/peachcat-cry.gif")
            	      right center
            	      no-repeat
            	    `,
                    didOpen: (toast) => {
                        toast.addEventListener("mouseenter", Swal.stopTimer);
                        toast.addEventListener("mouseleave", Swal.resumeTimer);
                    },
                });
                Toast.fire({
                    icon: "info",
                    title: "Removed from library successfully",
                });
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong! Please try again!',
                    showConfirmButton: false,
                    timer: 2000,
                    timerProgressBar: true,
                })
            }
        })
    }

    //Call API likeCount Movie
    function updateLike(data) {
        $.ajax({
            url: '${likeApiURL}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            },
            error: function (error) {
            }
        })
    }
</script>
</body>