<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Hello ${sessionScope.user.name}!</h1>
<a href="/reg">Registration</a>
<a href="/auth">Authorization</a>
<a href="/logout">Logout</a>
</body>
</html>
