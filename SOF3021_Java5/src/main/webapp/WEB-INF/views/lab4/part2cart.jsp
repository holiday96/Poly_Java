<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="col-auto me-auto fw-bold fs-1 mb-3" style="color: yellow">My Cart</div>
<div class="form">
    <div class="row justify-content-end">
        <a href="/lab/lab4/part2/clear" class="col-auto me-1 align-self-center btn btn-danger btn-sm">Clear All</a>
        <a href="/lab/lab4/part2/items" class="col-auto btn btn-primary btn-sm">
            <i class='bx bxs-cart-add' style="font-size: 30px"></i>
        </a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col" class="text-end">Price</th>
            <th scope="col" class="text-end">Quantity</th>
            <th scope="col" class="text-end">Amount</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cart.items}" var="i" varStatus="index">
            <form action="/lab/lab4/part2/update/${i.id}" method="post">
                <tr>
                    <th>${index.count}</th>
                    <td>${i.name}</td>
                    <td class="text-end">
                    	<fmt:formatNumber currencySymbol="$" value="${i.price}" type="currency" />
                    </td>
                    <td>
                    	<input type="number" onblur="this.form.submit()" class="form-control text-end ms-auto" name="quantity"
                               id="quantity" value="${i.quantity}" style="width: 70px"/>
                    </td>
                    <td class="text-end">
            			<fmt:formatNumber currencySymbol="$" value="${i.quantity*i.price}" type="currency" />
                    </td>
                    <td>
                        <a href="/lab/lab4/part2/remove/${i.id}" class="">
                            <i class='bx bxs-trash bx-flashing-hover' style='color:#de0303; font-size: 32px;'></i>
                        </a>
                    </td>
                </tr>
            </form>
        </c:forEach>
        <tr>
            <th></th>
            <th class="text-primary fs-4">Total</th>
            <th></th>
            <th class="text-primary text-end fs-4">${cart.count}</th>
            <th class="text-primary text-end fs-4">
            	<fmt:formatNumber currencySymbol="$" value="${cart.amount}" type="currency" />
            </th>
            <th></th>
        </tr>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function () {
        $('#lab4').addClass("active");
    });
</script>