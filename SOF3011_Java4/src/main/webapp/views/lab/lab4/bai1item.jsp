<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<a class="card" href="#">
    <img src="${param.image}" class="card-img-top" alt="image">
    <div class="card-body bg-light">
        <h5 class="card-title text-center text-danger fst-italic fw-bold fs-4">${param.name}</h5>
    </div>
</a>