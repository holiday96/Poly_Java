<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<!-- ======= Hero Section ======= -->
<section id="hero">
    <div class="hero-container" data-aos="zoom-in" data-aos-delay="100">
        <h1>Welcome to Lab</h1>
        <h2>Please choose one of them above</h2>
        <a href="/lab/lab1" class="btn-get-started">Get Started</a>
    </div>
</section>
<!-- End Hero Section -->

<script>
    $(document).ready(function () {
    	document.body.style.overflow = 'hidden';
        $('#labHome').addClass("active");
    });
</script>