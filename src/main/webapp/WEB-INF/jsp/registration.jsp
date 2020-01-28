<%--
  Created by IntelliJ IDEA.
  User: Alanorthon
  Date: 28.01.2020
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration Page</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="userForm">
        <h2>Sing up</h2>
        <div>
            <form:input type="text" path="login" placeholder="login"
                        autofocus="true"></form:input>
            <form:errors path="login"></form:errors>
                ${loginError}
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>
        <div>
            <form:input type="password" path="passwordConfirm"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
                ${passwordError}
        </div>
        <div>
            <form:input type="email" path="email" placeholder="e-mail"></form:input>
        </div>
        <button type="submit">Sing Up</button>
    </form:form>
    <a href="/">Go back</a>
</div>
</body>
</html>