<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
    <h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    <c:if test="${emailError != null}">
        <c:out value="${emailError}"></c:out>
    </c:if>
    
    <c:if test="${usernameError != null}">
        <c:out value="${usernameError}"></c:out>
    </c:if>
    
    <form:form method="POST" action="/register" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="username">Username:</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="confirm">Password Confirmation:</form:label>
            <form:password path="confirm"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
</body>
</html>