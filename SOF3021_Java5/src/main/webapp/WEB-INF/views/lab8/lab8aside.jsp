<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="aside">
    <div class="aside-title"></div>
    <div class="list-group">
        <div class="list-group-item list-group-item-action active disabled text-center" aria-current="true">
            Danh mục
        </div>
        <c:forEach items="${categories}" var="i">
            <a href="#" class="list-group-item list-group-item-action" aria-current="true">
                    ${i.name}
            </a>
        </c:forEach>
    </div>
</div>