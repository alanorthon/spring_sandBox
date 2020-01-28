<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 18.01.2020
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Spring CRUD App</title>
</head>
<h1>Welcome to my first Spring MVC app</h1>
<body>
<div>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Sing In</a></h4>
        <h4><a href="/registration">Sing Up</a></h4>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <h4><a href="/admin">Go to admin page</a></h4>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
        <h4><a href="/user">Go to user page</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Logout</a></h4>
    </sec:authorize>
</div>
</body>
</html>
