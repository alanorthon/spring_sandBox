<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 01.02.2020
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AccessDeniedPage</title>
</head>
<body>
<img src="https://videohive.img.customer.envatousercontent.com/files/226725974/Access%20Denied%20590x332.jpg?auto=compress%2Cformat&fit=crop&crop=top&max-h=8000&max-w=590&s=65a99371d79d741ffb46173e35e61990" sizes="500px">
<p align="center"> <H2>You tried to enter a closed territory</H2> <br/>
<p align="center"> <h3>leave this page or I will call the police</h3><br/>
<form action="/" method="GET">
    <input type="submit" value="Go back">
</form>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>
