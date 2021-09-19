<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<div class="rounded bg-dark">
    <div class="row">
        <div class="col">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="https://caodang.fpt.edu.vn" title="FPT Homepage">
                        <img height="25"
                             src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/11/FPT_logo_2010.svg/1280px-FPT_logo_2010.svg.png"
                             alt="logo-home">
                    </a>
                </li>
                <li class="nav-item">
                    <a id="lab8-home" class="nav-link text-light" aria-current="page" href="/lab/lab8"
                       title="FPT Homepage"><s:message code="lo.mn.home"/></a>
                </li>
                <li class="nav-item">
                    <a id="lab8-about" class="nav-link text-light" href="/lab/lab8/about"><s:message
                            code="lo.mn.about"/></a>
                </li>
                <li class="nav-item">
                    <a id="lab8-contact" class="nav-link text-light" href="/lab/lab8/contact"><s:message
                            code="lo.mn.contact"/></a>
                </li>
                <li class="nav-item">
                    <a id="lab8-feed" class="nav-link text-light" href="/lab/lab8/feedback"><s:message
                            code="lo.mn.feedback"/></a>
                </li>
                <li class="nav-item">
                    <a id="lab8-qa" class="nav-link text-light" href="/lab/lab8/q&a"><s:message code="lo.mn.qa"/></a>
                </li>
            </ul>
        </div>
        <div class="col-auto align-self-center mx-2">
            <a href="?lang=vi" class="mx-1">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/2560px-Flag_of_Vietnam.svg.png"
                     alt="flag-vn" height="25" width="40" title="Vietnamese">
            </a>
            <a href="?lang=en" class="mx-1">
                <img src="https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1200px-Flag_of_the_United_Kingdom.svg.png"
                     alt="flag-eng" height="25" width="40" title="English">
            </a>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        var url = $(location).attr('href');
        if (url.includes("about")) {
            $('#lab8-about').addClass("actived");
        } else if (url.includes("contact")) {
            $('#lab8-contact').addClass("actived");
        } else if (url.includes("feedback")) {
            $('#lab8-feed').addClass("actived");
        } else if (url.includes("q&a")) {
            $('#lab8-qa').addClass("actived");
        } else {
            $('#lab8-home').addClass("actived");
        }
    });
</script>