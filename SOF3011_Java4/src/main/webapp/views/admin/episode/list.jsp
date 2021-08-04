<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="apiURL" value="/api/episode"/>
<c:url var="listURL" value="/admin/episode"/>

<head>
    <title>Episodes Management</title>
</head>
<body>
<div class="home-content">
    <i class='bx bx-menu'></i> <span class="text">Movie list</span>
</div>
<div class="container rounded bg-light p-3">
    <table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
        <thead>
        <tr>
            <th class="text-center">#</th>
            <th></th>
            <th>Poster</th>
            <th>Title</th>
            <th>Episodes</th>
            <th>ID</th>
            <th>Trailer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movies}" var="i" varStatus="count">
            <tr>
                <td class="text-center">${count.count}</td>
                <td class="text-center">
                    <a href="/admin/episode/edit?movieid=${i.id}" style="color: #3ac500">
                        <i class='bx bx-plus-circle bx-md bx-tada-hover'></i>
                    </a>
                </td>
                <td>
                    <img src="${i.poster}" height="100" alt="">
                </td>
                <td>${i.title}</td>
                <td>
                    <c:forEach items="${i.episodes}" var="episode">
                        <c:url var="editURL" value="/admin/episode/edit">
                            <c:param name="movieid" value="${i.id}"/>
                            <c:param name="id" value="${episode.id}"/>
                        </c:url>
                        <a href="${editURL}" class="btn btn-success btn-sm">${episode.number}</a>
                    </c:forEach>
                </td>
                <td>${i.id}</td>
                <td><a href="${i.trailer}">${i.trailer}</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        var table = $('#example').DataTable({
            lengthChange: false,
            buttons: ['copy', 'excel', 'pdf', 'colvis'],
            colReorder: true,

            responsive: true,
            select: true
        });

        table.buttons().container()
            .appendTo('#example_wrapper .col-md-6:eq(0)');
    });
</script>
</body>