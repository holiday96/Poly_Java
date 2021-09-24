<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="APIurl" value="/lab/lab6/product/report"/>

<div class="col-auto me-auto text-uppercase fw-bold fs-1 mb-3" style="color: yellow">Report product</div>
<div class="form">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Category</th>
            <th scope="col">Total price</th>
            <th scope="col">Total product</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="i" varStatus="index">
            <tr>
                <th>${index.index + 1}</th>
                <td>${i.group.name}</td>
                <td>
                    <fmt:formatNumber type="currency" currencySymbol="$" pattern="¤ 0.00" value="${i.sum}"/>
                </td>
                <td>${i.count}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="pager">
        <ul id="pagination" class="pagination-sm justify-content-center"></ul>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#lab6').addClass("active");

        var totalPages = ${item.totalPage};
        var currentPage = ${item.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 10,
                startPage: currentPage,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        window.location.href = '${APIurl}?page=' + page;
                    }
                }
            });
        });
    });
</script>