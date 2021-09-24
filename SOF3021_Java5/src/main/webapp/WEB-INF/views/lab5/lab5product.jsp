<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>
<c:url var="APIurl" value="/lab/lab5/product"/>

<div class="col-auto me-auto text-uppercase fw-bold fs-1 mb-3" style="color: yellow">Product Management</div>
<div class="form">
    <form id="formCreate" method="post" class="row justify-content-center" enctype="multipart/form-data">
        <div class="col-auto me-3" style="width: 200px">
            <div class="text-center">
                <img id="img" src="
                	<c:if test='${not empty productItem.imageURL}'>${productItem.imageURL}</c:if>
                	<c:if test='${empty productItem.imageURL}'>https://picsum.photos/200/300</c:if>"
                     class="img-placeholder img-chose mb-3" width="176"/>
            </div>
            <div class="col mb-3">
                <input type="file" class="img-input form-control" id="image" name="image" onchange="updateImage()">
            </div>
        </div>
        <div class="col-4">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="name" name="name" value="${productItem.name}"
                       placeholder="name"/>
                <label for="name">Name</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="price" name="price" value="${productItem.price}"
                       placeholder="price"/>
                <label for="price">Price</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" id="category" name="categoryCode">
                    <option value="" disabled selected>-- Select Category --</option>
                    <c:forEach items="${categories}" var="i">
                        <option value="${i.code}" ${productItem.categoryCode==i.code?'selected':''}>${i.name}</option>
                    </c:forEach>
                </select>
                <label for="category">Category</label>
            </div>
            <div class="form-check mb-3">
                <input type="checkbox" class="form-check-input" value="true" id="available"
                       name="available" ${productItem.available?'checked':''}/>
                <label class="form-check-label" for="available">
                    Available?
                </label>
            </div>
            <input type="hidden" id="id" name="id" value="${productItem.id}"/>
            <input type="hidden" id="imageURL" name="imageURL" value="${productItem.imageURL}"/>
            <button id="createProduct" class="btn btn-success mb-5">
                Create
            </button>
        </div>
    </form>
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
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productItem.listResult}" var="i" varStatus="index">
            <tr>
                <th>${index.index + 1}</th>
                <td>
                    <img src="${not empty i.imageURL?i.imageURL:'https://www.pariyes.net/wp-content/uploads/2021/06/depositphotos_318221368-stock-illustration-missing-picture-page-for-website.jpg'}" width="100">
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
                <td>
                    <i onclick="edit(${i.id})" class='bx bxs-edit bx-flashing-hover'
                       style='color:#ba20f9; font-size: 32px;'></i>
                    <i onclick="deleteProduct(${i.id})" class='bx bxs-trash bx-flashing-hover'
                       style='color:#de0303; font-size: 32px;'></i>
                </td>
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
        $('#lab5').addClass("active");
        
        var a = $(location).attr("href").split('/').pop();
        if ($.isNumeric(a)) {
            $('#createProduct').html('Save');
        }

        var totalPages = ${productItem.totalPage};
        var currentPage = ${productItem.page};
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPages,
                visiblePages: 10,
                startPage: currentPage,
                onPageClick: function (event, page) {
                    if (currentPage != page) {
                        let searchParams = new URLSearchParams(window.location.search);
                        if (searchParams.has('field')) {
                            window.location.href = '${APIurl}?page=' + page + '&field=' + searchParams.get('field') + '&direction=' + searchParams.get('direction');
                        } else {
                            window.location.href = '${APIurl}?page=' + page;
                        }
                    }
                }
            });
        });
    });

    function filter(field) {
        let searchParams = new URLSearchParams(window.location.search);
        if (searchParams.get('direction') == 'asc' || !searchParams.has('field')) {
            window.location.href = '${APIurl}?field=' + field + '&direction=desc';
        } else if (searchParams.get('direction') == 'desc') {
            window.location.href = '${APIurl}?field=' + field + '&direction=asc';
        }
    }

    $('.img-chose').click(function () {
        $('#image').trigger('click');
    });

    const toBase64 = file => new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });

    async function updateImage() {
//         var url = window.URL.createObjectURL($('#image')[0].files[0]);
        const file = $('#image')[0].files[0];
        $('#img').attr('src', await toBase64(file));
    }

    $('#createProduct').click(async function (e) {
        e.preventDefault();
        if ($.isNumeric($('#price').val())) {
            var data = {};
            var formData = $('#formCreate').serializeArray();
            $.each(formData, function (i, v) {
                data["" + v.name + ""] = v.value;
            });
            const file = $('#image')[0].files[0];
            if (file != undefined) {
                data["imageURL"] = await toBase64(file);
            }
            var id = $('#id').val();
            if (id == '') {
                addProduct(data);
            } else {
                editProduct(data);
            }
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Product price must be a number!'
            })
        }

    });

    function addProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire(
                    'Good job!',
                    'You clicked the button!',
                    'success'
                ).then(() => window.location.href = '${APIurl}');
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Product name has been exists!'
                })
                console.log(error);
            }
        });
    }

    function editProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                Swal.fire(
                    'Good job!',
                    'You clicked the button!',
                    'success'
                ).then(() => window.location.href = '${APIurl}');
            },
            error: function (error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Product name has been exists!'
                })
                console.log(error);
            }
        });
    }


    function edit(id) {
        window.location.href = "${APIurl}/" + id;
    }

    function deleteProduct(data) {
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, cancel!',
            reverseButtons: true
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    url: '${APIurl}',
                    type: 'DELETE',
                    contentType: 'application/json',
                    data: JSON.stringify(data),
                    success: function (result) {
                        swalWithBootstrapButtons.fire(
                            'Deleted!',
                            'Your file has been deleted.',
                            'success'
                        ).then(() => {
                            window.location.href = "${APIurl}"
                        });
                    },
                    error: function (error) {
                        Swal.fire({
                            icon: 'error',
                            title: 'Oops...',
                            text: 'Something went wrong!'
                        })
                        console.log(error);
                    }
                });
            } else if (result.dismiss === Swal.DismissReason.cancel) {
                swalWithBootstrapButtons.fire(
                    'Cancelled',
                    'Your imaginary file is safe 🥳🥳',
                    'error'
                )
            }
        })
    }
</script>