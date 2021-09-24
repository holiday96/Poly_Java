<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>


<div class="p-3 mx-auto" style="width: 300px;">
    <c:if test="${empty model}">
        <form method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" name="username" id="username" value="${model.username}"
                       required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password" value="${model.password}"
                       required>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" name="remember"
                       id="remember" ${model.remember?"checked":""}>
                <label class="form-check-label" for="remember">Remember me</label>
            </div>
            <button formaction="/lab/lab1" class="btn btn-primary">Submit</button>
        </form>
    </c:if>
    <c:if test="${not empty model}">
        Username: ${model.username}<br>
        Password: ${model.password}<br>
        Remember: ${model.remember?"Yes":"No"}
    </c:if>
</div>

<script>
    $(document).ready(function () {
        $('#lab1').addClass("active");
    });
</script>
