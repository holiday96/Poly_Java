<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/taglib.jsp" %>

<head>
    <title>Lab 3 Bài 5</title>
</head>
<body>
<h1>Send Mail</h1>
<h3>${message}</h3>
<form action="/lab/3/bai5" method="post">
    <label for="to">To: </label>
    <input type="text" name="to" id="to" placeholder="Type destination email address"><br>
    <label for="subject">Subject: </label>
    <input type="text" name="subject" id="subject" placeholder="Subject Email"><br>
    <label for="message">Message: </label>
    <textarea name="message" id="message" cols="40" rows="7" placeholder="Your message"></textarea>
    <hr>
    <button class="btn" type="submit">Send</button>
</form>
</body>