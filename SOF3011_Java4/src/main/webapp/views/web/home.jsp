<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="main-content">
    <div id="wowslider-container0">
        <div class="ws_images">
            <ul>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/900/300" style="height: 500px;" alt="33099530532_6c5fa55f0e_o"
                             title="33099530532_6c5fa55f0e_o" id="wows0_0"/>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/1100/400" alt="33213470783_3badb96529_k"
                             title="33213470783_3badb96529_k" id="wows0_1"/>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/1100/500" alt="33214043886_e8ac9cc4f7_o"
                             title="33214043886_e8ac9cc4f7_o" id="wows0_2"/>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/1100/600" alt="33255352055_d7167a2454_o"
                             title="33255352055_d7167a2454_o" id="wows0_3"/>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/1100/700" alt="33255353005_1a60527c6e_o"
                             title="33255353005_1a60527c6e_o" id="wows0_4"/>
                    </a>
                </li>
                <li>
                    <a href="a">
                        <img src="https://picsum.photos/1100/800" title="33255354325_495a11e5e6_h"
                             id="wows0_5"/>
                    </a>
                </li>
            </ul>
        </div>
        <div class="ws_shadow"></div>
    </div>
    <div class="slider-wrapper" style="padding: 20px;">
        <c:forEach items="${themes}" var="i">
            <div class="block">
                <div class="block-title">
                    <a href="#">
                        <h3>${i.name}</h3>
                    </a>
                </div>
                <div class="block-content">
                    <section class="regular slider">
                        <c:forEach items="${i.movies}" var="movie">
                            <div>
                                <div class="poster">
                                    <a href="#" onclick="view(${movie.id}, ${movie.viewCount})">
                                        <img src="${movie.poster}" alt="" style="height: 200px; width: 150px;">
                                    </a>
                                </div>
                                <div class="info">
                                    <div class="up row justify-content-between">
	                                    <span class="col view">
	                                        <i class='bx bxs-show'></i>
	                                        <span class="text">
	                                        	<c:if test="${movie.viewCount >= 1000}">${(movie.viewCount - movie.viewCount % 1000) / 1000 + (movie.viewCount % 1000 - movie.viewCount % 100) / 1000} K</c:if>
                   								<c:if test="${movie.viewCount < 1000 }">${movie.viewCount}</c:if>
	                                        </span>
	                                    </span>
                                        <span class="col like">
                                        	<i class='bx bxs-heart'></i>
                                        	<span class="text">
                                        		<c:if test="${movie.likeCount >= 1000}">${(movie.likeCount - movie.likeCount % 1000) / 1000 + (movie.likeCount % 1000 - movie.likeCount % 100) / 1000} K</c:if>
                   								<c:if test="${movie.likeCount < 1000 }">${movie.likeCount}</c:if>
                                        	</span>
                                    	</span>
                                    </div>
                                    <div class="title">${movie.title}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </section>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".regular").slick({
            infinite: true,
            slidesToShow: 5,
            slidesToScroll: 5
        });
    });

    function view(id, viewCount) {
        var data = {};
        data["id"] = id;
        data["viewCount"] = viewCount + 1;
        updateView(data);
    }

    //Call API viewCount Movie
    function updateView(data) {
        $.ajax({
            url: '/api/movie/view',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = "/movie?id=" + data.id;
            },
            error: function (error) {
            }
        })
    }
</script>