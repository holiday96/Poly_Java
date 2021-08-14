<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<ul class="d-flex flex-wrap justify-content-evenly">
    <c:forEach items="${movies}" var="i">
        <li class="film-item item mx-3 mb-4" style="width: 140px;">
            <a href="#" onclick="view(${i.id}, ${i.viewCount})" class="rounded">
                <img src="${i.poster}" class="rounded" height="200" alt="item-poster"/>
            </a>
            <a href="#" onclick="view(${i.id}, ${i.viewCount})" style="font-size: 15px;" class="d-flex text-warning text-center">${i.title}</a>
        </li>
    </c:forEach>
</ul>

<script>
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