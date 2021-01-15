<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/reg" method="post">
    <input type="text" name="name" placeholder="Name">
    <p style="color: red">${requestScope.messageUser}</p>
    <br>
    <input type="text" name="login" placeholder="Login">
    <br>
    <input type="password" name="password" placeholder="Password">
    <p style="color: red">${requestScope.messagePassword}</p>
    <input type="text" name="question" placeholder="Question">
    <br>
    <input type="text" name="answer" placeholder="Answer">
    <button>Registration</button>
</form>
${sessionScope.user.name}
<a href="/" class="btn">Back</a>
</body>
</html>