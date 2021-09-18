<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/taglib.jsp" %>

<c:if test="${not empty message}">
    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
        </symbol>
    </svg>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
            <use xlink:href="#check-circle-fill"/>
        </svg>
        <strong>Success!</strong> ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</c:if>
<form action="/lab/lab7/email" method="post" id="formSubmit" class="form mx-auto" style="width: 700px"
      enctype="multipart/form-data">
    <div class="row mb-3">
        <div class="col-auto title mb-3">Send Email</div>
        <div class="col-auto ms-auto">
            <span id="btnCc" class="mail-option fs-3 me-3" style="color: #7a838c">Cc</span>
            <span id="btnBcc" class="mail-option fs-3" style="color: #7a838c">Bcc</span>
        </div>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="from" id="from" placeholder="from" required>
        <label for="from">From</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="to" id="to" placeholder="to" required>
        <label for="to">To</label>
    </div>
    <div id="formCc" class="form-floating mb-3" style="display: none">
        <input type="text" class="form-control" name="cc" id="cc" placeholder="cc">
        <label for="cc">Cc</label>
    </div>
    <div id="formBcc" class="form-floating mb-3" style="display: none">
        <input type="text" class="form-control" name="bcc" id="bcc" placeholder="bcc">
        <label for="bcc">Bcc</label>
    </div>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" name="subject" id="subject" placeholder="subject" required>
        <label for="subject">Subject</label>
    </div>
    <div class="mb-3">
        <label for="body" class="form-label">Content</label>
        <textarea class="form-control" placeholder="body" name="body" id="body" style="height: 100px"></textarea>
    </div>
    <div class="mb-3">
        <label for="attachments" class="form-label">Attachments</label>
        <input class="form-control" type="file" id="attachments" name="attachments" multiple>
    </div>
    <div class="row me-auto">
        <button type="submit" id="btnSubmit" class="col-auto ms-auto btn btn-primary"><i class='bx bx-mail-send'></i>
            Submit
        </button>
    </div>
</form>

<script>
    var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
    $(document).ready(function () {
        $('#lab7').addClass("active");

        $("#btnCc").click(function () {
            $("#btnCc").hide();
            $("#formCc").show();
        });

        $("#btnBcc").click(function () {
            $("#btnBcc").hide();
            $("#formBcc").show();
        })

        CKEDITOR.replace('body');
    });

    $('#btnSubmit').click(function (e) {
        e.preventDefault();
        if ($('#from').val() == '' || !pattern.test($('#from').val())) {
            $('#from').addClass('is-invalid');
        }
        if ($('#to').val() == '' || !pattern.test($('#to').val())) {
            $('#to').addClass('is-invalid');
        }
        if ($('#subject').val() == '') {
            $('#subject').addClass('is-invalid');
        }
        if ($('#from').hasClass('is-valid') && $('#to').hasClass('is-valid') && !$('#subject').hasClass('is-invalid')) {
            $('#formSubmit').submit();
        }
    });

    $('#from').change(function () {
        $('#from').removeClass('is-invalid');
        if (pattern.test($('#from').val())) {
            $('#from').addClass('is-valid');
        }
    });
    $('#to').change(function () {
        $('#to').removeClass('is-invalid');
        if (pattern.test($('#to').val())) {
            $('#to').addClass('is-valid');
        }
    });
    $('#subject').change(function () {
        $('#subject').removeClass('is-invalid');
    });
</script>