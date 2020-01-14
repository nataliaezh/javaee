<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home Page</h1>

<form action="LoginServlet" method="post">
    Имя пользователя: <input type="text" name="user">
    <br>
    Пароль: <input type="password" name="password">
    <br>
    <input type="submit" value="ОК">
</form>

</body>
</html>
