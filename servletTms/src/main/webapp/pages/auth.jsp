<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="/auth" method="post">
    <input type="text" name="login" placeholder="Login">
    <br>
    <input type="password" name="password" placeholder="Password">
    <p style="color: red">${requestScope.messageAuth}</p>
    <a href="/forgot" class="btn">Forgot your password?</a>
    <button>Authorization</button>
</form>
<a href="/" class="btn">Back</a>
</body>
</html>
