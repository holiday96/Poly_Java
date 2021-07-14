<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<div class="nav mt-4">
    <ul>
        <li><a href="<c:url value='/lab/1' />">Lab 1</a></li>
        <li><a href="<c:url value='/lab/2/bai1' />">Lab 2</a>
            <div class="sub-nav">
                <ul>
                    <li><a href="<c:url value='/lab/2/bai1' />">1</a></li>
                    <li><a href="<c:url value='/lab/2/bai2' />">2</a></li>
                    <li><a href="<c:url value='/lab/2/bai3' />">3</a></li>
                    <li><a href="<c:url value='/lab/2/bai4' />">4</a></li>
                </ul>
            </div>
        </li>
        <li><a href="<c:url value='/lab/3/bai1' />">Lab 3</a>
            <div class="sub-nav">
                <ul>
                    <li><a href="<c:url value='/lab/3/bai1' />">1</a></li>
                    <li><a href="<c:url value='/lab/3/bai2' />">2</a></li>
                    <li><a href="<c:url value='/lab/3/bai3' />">3</a></li>
                    <li><a href="<c:url value='/lab/3/bai4' />">4</a></li>
                    <li><a href="<c:url value='/lab/3/bai5' />">5</a></li>
                </ul>
            </div>
        </li>
        <li><a href="<c:url value='/lab/4' />">Lab 4</a></li>
        <li><a href="<c:url value='/lab/5' />">Lab 5</a></li>
        <li><a href="<c:url value='/lab/6' />">Lab 6</a></li>
        <li><a href="<c:url value='/lab/7' />">Lab 7</a></li>
        <li><a href="<c:url value='/lab/8' />">Lab 8</a></li>
    </ul>
</div>