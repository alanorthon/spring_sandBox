<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 18.01.2020
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<section class="fields">
    <form action="/adduser" method="POST">
        Login: <br><input type="text" name="login"> <br>
        Password: <br><input type="text" name="password"> <br>
        Email: <br><input type="email" name="email"> <br>
        <input type="submit" value="Add user">
    </form>
    <form action="/allusers" method="GET">
        <input type="submit" value="Go back">
    </form>
</section>
</body>
</html>
