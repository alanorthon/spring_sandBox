<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 28.01.2020
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User personal page</title>
</head>
<body>
Hi ${username}!
<H2>You can do nothing on this page<br/>
    Just relax and look on this picture</H2>
<img src="https://i.gifer.com/fyDA.gif" align="center" width="300px" alt="pic"><br/>
<form action="/login" method="GET">
    <input type="submit" value="Go to Authorisation page">
</form>
<a href="/logout">logout</a>
</body>
</html>
