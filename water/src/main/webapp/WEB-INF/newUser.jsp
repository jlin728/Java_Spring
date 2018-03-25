<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/css/main.css" rel="stylesheet" type="text/css">
		<!-- <link rel="stylesheet" type= "text/css" href="${pageContext.request.contextPath}/css/style.css" /> -->
		<link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
		<!-- <style>
			body {font-family: 'Josefin Sans', sans-serif;}
			h1 {color: gray;}
		</style>
 -->	
		<title>Login and Registration</title>
	</head>

<body>

    <h1>Login</h1>
    
    <c:if test="${error != null}">
			<h3>${error}</h3>
    </c:if>
    
<form action="/users/login" method="POST">
       <p>
           <label>Email:</label>
           <input type = "text" name = "email">

       </p>
       <p>
           <label>Password:</label>
           <input type = "password" name = "password">
       </p>	
	<input type = "submit" value = "Login">
</form>


<h1>Register</h1>
    
    <c:if test="${errors != null}">
		<c:forEach items="${errors}" var="err">
			<h3>${err.defaultMessage}</h3>
		</c:forEach>
    </c:if>
    
<form:form action="/users/new" method="POST" modelAttribute="user">
       <p>
           <form:label path ="firstName">First Name:
	           <form:input type = "text" path = "firstName"></form:input>
	           <form:errors path ="firstName"></form:errors>
           </form:label>
       </p>
       <p>
           <form:label path ="lastName">Last Name:
	           <form:input type = "text" path = "lastName"></form:input>
	           <form:errors path ="lastName"></form:errors>
           </form:label>
       </p>
       <p>
           <form:label path ="email">Email:
	           <form:input type = "text" path = "email"></form:input>
	           <form:errors path ="email"></form:errors>
           </form:label>
       </p>
       <p>
           <form:label path ="password">Password:
	           <form:input type = "password" path = "password"></form:input>
	           <form:errors path ="password"></form:errors>
           </form:label>
       </p>
		<p>
			<form:select path="host">
				<form:option value="true">Host</form:option>
				<form:option value="false">Guest</form:option>
			</form:select>
		</p>
	<input type = "submit" value = "Register">
</form:form>

</body>
</html>