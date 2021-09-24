<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="APIurl" value="/lab/lab6/product"/>

<div class="col-auto me-auto text-uppercase fw-bold fs-1 mb-3" style="color: yellow">Search product</div>
<div class="form">
    <div class="row">
        <div class="col-auto">
            <select id="searchOption" onchange="searchOption()" class="col-auto form-select form-select-md mb-3"
                    aria-label=".form-select-lg example">
                <option value="price">Price</option>
                <option value="name">Name</option>
            </select>
        </div>
        <form action="${APIurl}/search" method="get" id="formPrice" class="col justify-content-center mb-3"
              enctype="multipart/form-data">
            <div class="input-group">
                <span class="input-group-text">Min</span>
                <input type="number" min="0" id="min" name="min" class="form-control"/>
                <span class="input-group-text">Max</span>
                <input type="number" min="0" id="max" name="max" class="form-control"/>
                <button class="btn btn-primary">
                    <i class='bx bx-search'></i>
                </button>
            </div>
        </form>
        <form action="${APIurl}/search" method="get" id="formName" class="col justify-content-center"
              enctype="multipart/form-data">
            <div class="input-group">
                <input type="text" id="name" name="name" class="form-control"/>
                <button class="btn btn-primary">
                    <i class='bx bx-search'></i>
                </button>
            </div>
        </form>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Avatar</th>
            <th scope="col">
                <a href="#" onclick="filter('name')">Name<i class='bx bx-sort'></i></a>
            </th>
            <th scope="col">
                <a href="#" onclick="filter('price')">Price<i class='bx bx-sort'></i></a>
            </th>
            <th scope="col">
                <a href="#" onclick="filter('categoryCode')">Category<i class='bx bx-sort'></i></a>
            </th>
            <th scope="col">
                <a href="#" onclick="filter('createDate')">Create Date<i class='bx bx-sort'></i></a>
            </th>
            <th scope="col">
                <a href="#" onclick="filter('available')">Available<i class='bx bx-sort'></i></a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productItem.listResult}" var="i" varStatus="index">
            <tr>
                <th>${index.index + 1}</th>
                <td>
                    <img src="${i.imageURL}" width="100">
                </td>
                <td>${i.name}</td>
                <td>
                    <fmt:formatNumber type="currency" currencySymbol="$" pattern="¤0.00" value="${i.price}"/>
                </td>
                <td>${i.categoryCode}</td>
                <td>
                    <fmt:formatDate value="${i.createDate}" pattern="dd/MM/yyyy"/>
                </td>
                <td>${i.available?"Yes":"No"}</td>
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

        searchOption();

        var totalPages = ${productItem.totalPage};
        var currentPage = ${productItem.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 10,
                startPage: currentPage,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        let last = $(location).attr("href").split('/').pop();
                        let searchParams = new URLSearchParams(window.location.search);
                        if (searchParams.has('field')) {
                            window.location.href = '${APIurl}?page=' + page + '&field=' + searchParams.get('field') + '&direction=' + searchParams.get('direction');
                        } else if (last.includes('search') && searchParams.has('name')) {
                            window.location.href = '${APIurl}/search?page=' + page + '&name=' + searchParams.get('name');
                        } else if (last.includes('search') && searchParams.has('min')) {
                            window.location.href = '${APIurl}/search?page=' + page + '&min=' + searchParams.get('min') + '&max=' + searchParams.get('max');
                        } else {
                            window.location.href = '${APIurl}?page=' + page;
                        }
                    }
                }
            });
        });
    });

    function searchOption() {
        if ($('#searchOption').val() == 'price') {
            $('#formPrice').show();
            $('#formName').hide();
        } else if ($('#searchOption').val() == 'name') {
            $('#formName').show();
            $('#formPrice').hide();
        }
    };

    function filter(field) {
        let searchParams = new URLSearchParams(window.location.search);
        if (searchParams.get('direction') == 'asc' || !searchParams.has('field')) {
            window.location.href = '${APIurl}?field=' + field + '&direction=desc';
        } else if (searchParams.get('direction') == 'desc') {
            window.location.href = '${APIurl}?field=' + field + '&direction=asc';
        }
    }
</script>