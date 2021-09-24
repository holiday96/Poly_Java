<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<%@include file="/WEB-INF/views/lab8/lab8banner.jsp" %>
<%@include file="/WEB-INF/views/lab8/lab8menu.jsp" %>

<div class="my-3">
    <div class="row">
        <div class="col">${body}</div>
        <div class="col-auto">
            <%@include file="/WEB-INF/views/lab8/lab8aside.jsp" %>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/lab8/lab8footer.jsp" %>

<script>
    $(document).ready(function () {
        $('#lab8').addClass("active");
    });
</script>