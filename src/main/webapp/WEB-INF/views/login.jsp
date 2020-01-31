<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 28.01.2020
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
</head>

<body>
<div>
    <form method="POST" action="/login">
        <h2>Please enter login and password</h2>
        <p style="">${message}</p>
        <label>
            <input name="username" type="text" placeholder="username"/>
        </label>
        <label>
            <input name="password" type="password" placeholder="password"/>
        </label>
        <button type="submit">Log In</button>
    </form>
</div>
<div>
    <form action="/registration" method="GET">
        <input type="submit" value="Sing Up">
    </form>
</div>
</body>
</html>
