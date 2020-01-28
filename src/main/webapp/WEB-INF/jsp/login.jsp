<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 28.01.2020
  Time: 1:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
</head>

<body>
<div>
    <form method="POST" action="/login">
        <h2>Вход в систему</h2>
        <p style="">${message}</p>
        <div>
            <input name="login" type="text" placeholder="login"
                   autofocus="true"/>
            <input name="password" type="password" placeholder="Password"/>
            <button type="submit">Log In</button>

            <h4><a href="/registration">Sing Up</a></h4>
        </div>
    </form>
</div>

</body>
</html>
