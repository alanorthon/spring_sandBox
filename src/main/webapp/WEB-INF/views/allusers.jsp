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
    <title>List of all users</title>
</head>
<body>
<p style="">${message}</p>
<table style=" width: 30%; border: none">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>email</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td style="border: 1px solid black; text-align: left">${user.id}</td>
            <td style="border: 1px solid black; text-align: left">${user.username}</td>
            <td style="border: 1px solid black; text-align: left">${user.email}</td>
            <td style="border: 1px solid black; text-align: left">
                <c:forEach items="${user.roles}" var="role">${role.name}</c:forEach>
            </td>
            <td>
                <form action="/edituser/${user.id}" method="GET">
                    <input type="submit" value="Edit User"/>
                </form>
            </td>
            <td>
                <form action="/deleteuser/${user.id}" method="POST">
                    <input type="submit" value="Delete User"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<form action="/adduser" method="GET">
    <input type="submit" value="Add User">
</form>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
<form action="/" method="GET">
    <input type="submit" value="Go back">
</form>
</body>
</html>
