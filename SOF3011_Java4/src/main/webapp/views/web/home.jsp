<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="main-content">
    <div id="wowslider-container0" style="height: 500px;">
        <div class="ws_images">
            <ul>
                <li>
                    <a href="/movie?id=${movies[0].id}">
                        <img src="${movies[0].banner}" style="height: 500px;" alt="${movies[0].title}"
                             title="${movies[0].title}" id="wows0_0"/>
                    </a>
                </li>
                <li>
                    <a href="/movie?id=${movies[1].id}">
                        <img src="${movies[1].banner}" style="height: 500px;" alt="${movies[1].title}"
                             title="${movies[1].title}" id="wows0_1"/>
                    </a>
                </li>
                <li>
                    <a href="/movie?id=${movies[2].id}">
                        <img src="${movies[2].banner}" style="height: 500px;" alt="${movies[2].title}"
                             title="${movies[2].title}" id="wows0_2"/>
                    </a>
                </li>
                <li>
                    <a href="/movie?id=${movies[3].id}">
                        <img src="${movies[3].banner}" style="height: 500px;" alt="${movies[3].title}"
                             title="${movies[3].title}" id="wows0_3"/>
                    </a>
                </li>
                <li>
                    <a href="/movie?id=${movies[4].id}">
                        <img src="${movies[4].banner}" style="height: 500px;" alt="${movies[4].title}"
                             title="${movies[4].title}" id="wows0_4"/>
                    </a>
                </li>
                <li>
                    <a href="/movie?id=${movies[5].id}">
                        <img src="${movies[5].banner}" style="height: 500px;" alt="${movies[5].title}"
                        	 title="${movies[5].title}" id="wows0_5"/>
                    </a>
                </li>
            </ul>
        </div>
        <div class="ws_shadow"></div>
    </div>
    <div class="slider-wrapper" style="padding: 20px;">
        <c:forEach items="${themes}" var="i">
	    	<c:if test="${not empty i.movies}">
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
	                                        <img src="${movie.poster}" alt="" title="${movie.title}" style="height: 200px; width: 150px;">
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
	    	</c:if>
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