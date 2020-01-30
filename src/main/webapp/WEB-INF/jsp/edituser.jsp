<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Edit user</title>
    <link href="<c:url value='/WEB-INF/res' />" rel="stylesheet"/>
    <link href="<c:url value='/WEB-INF/res' />" rel="stylesheet"/>
</head>
<body>
<section class="fields">
    <form action="/edituser" method="POST">
        <input type="hidden" name="id" value=${user.id}>
        Login: <br><input type="text" name="username" value=${user.username}> <br>
        Password: <br><input type="text" name="password" value=${user.password}> <br>
        Email: <br><input type="email" name="email" value=${user.email}> <br>
        Role: <br><input type="text" name="role" placeholder="admin or user" ><br>
        <input type="submit" value="Edit User">
    </form>
    <form action="/admin" method="GET">
        <input type="submit" value="Go back">
    </form>
</section>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>
