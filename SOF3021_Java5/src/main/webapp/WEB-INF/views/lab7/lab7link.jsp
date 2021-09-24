<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="form mb-3 text-danger fw-bold">${uri}</div>
<div class="form">
    <div class="title mb-3">Categories</div>
    <ol class="list-group list-group-numbered">
        <c:forEach var="i" items="${categories}" step="2" varStatus="index">
            <li class="list-group-item list-group-item-action">${categories[index.index].name}</li>
            <c:if test="${not empty categories[index.index+1]}">
                <li class="list-group-item list-group-item-action list-group-item-secondary">${categories[index.index+1].name}</li>
            </c:if>
        </c:forEach>
    </ol>
</div>

<script>
    $(document).ready(function () {
        $('#lab7').addClass("active");
    });
</script>
