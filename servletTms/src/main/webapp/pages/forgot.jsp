<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ForgotYourPassword</title>
</head>
<body>
<form action="/forgot" method="post">
    <input type="text" name="login" placeholder="Login">
    <br>
    <div>
<%--        ${requestScope.question}--%>
    </div>
    <input type="text" name="answer" placeholder="Answer">
    <p style="color: red">${requestScope.messageAnswer}</p>
    <input type="password" name="password" placeholder="New Password">
    <p style="color: red">${requestScope.messageNewPass}</p>
    <br>
    <button>Save new password</button>
</form>
<a href="/auth" class="btn">Back</a>
</body>
</html>
